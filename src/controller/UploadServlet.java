package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.annotation.WebServlet;
import bean.Homework;
import dao.HomeworkDao;

@WebServlet("/fileupload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException {
		//�õ��ϴ��ļ��ı���Ŀ¼
		String savePath = this.getServletContext().getRealPath("/upload");
		File file = new File(savePath);
		//�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
		if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
		}
		
		Homework homework=new Homework();
		HomeworkDao homeworkDao=new HomeworkDao();
		//��Ϣ��ʾ
		String message = "δѡ���ļ���";
		try{
			homework.setCno(request.getParameter("cno"));
			homework.setTerm(request.getParameter("term"));
			homework.setSno(request.getParameter("sno"));
			homework.setTno(request.getParameter("tno"));
			homework.setTitle(request.getParameter("title"));
			
			//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			//1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			//����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8"); 
			//3���ж��ύ�����������Ƿ����ϴ���������
			if(!ServletFileUpload.isMultipartContent(request)){
				//���մ�ͳ��ʽ��ȡ����
				return;
			}
			
			//4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				//���fileitem�з�װ������ͨ�����������
				if(item.isFormField()){
					continue;
				}else{//���fileitem�з�װ�����ϴ��ļ�
					//�õ��ϴ����ļ����ƣ�
					String filename = item.getName();
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					//�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					//��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					//�õ��ļ����������
					String saveFilename = makeFileName(filename);
					//�õ��ļ������·��
					String filepath=savePath + "\\" + saveFilename;
					//����һ���ļ������
					FileOutputStream out = new FileOutputStream(filepath);
					//����һ��������
					byte buffer[] = new byte[1024];
					//�ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					//ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while((len=in.read(buffer))>0){
						//ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
						out.write(buffer, 0, len);
					}
					//�ر�������
					in.close();
					//�ر������
					out.close();
					//ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					item.delete();
					
					homework.setAnswer(filename);
					homework.setFilepath(filepath);
					boolean success=homeworkDao.updateAnswer(homework);//���´�
					if(success) {
						message="�ύ�ɹ���";
					}else {
						message="�ύʧ�ܣ�";
					}
				}
			}
		}catch (Exception e) {
			message= "�ύʧ�ܣ�";
			e.printStackTrace();
		}
		request.setAttribute("message",message);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
	
	private String makeFileName(String filename){
		//Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
		return UUID.randomUUID().toString() + "_" + filename;
	}
}
