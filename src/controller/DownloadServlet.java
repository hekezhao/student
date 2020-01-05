package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/filedownload")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException {
		//����ļ��洢·��
		String path=request.getParameter("filepath");
		//�õ�Ҫ���ص��ļ�
		File file=new File(path);
		//����ļ�������
		if(!file.exists()){
			request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ����");
			request.getRequestDispatcher("/result.jsp").forward(request, response);
			return;
		}
		//�����ļ���
		String realname = path.substring(path.indexOf("_")+1);
		//������Ӧͷ��������������ظ��ļ�
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		//��ȡҪ���ص��ļ������浽�ļ�������
		FileInputStream in = new FileInputStream(path);
		//���������
		OutputStream out = response.getOutputStream();
		//����������
		byte buffer[] = new byte[1024];
		int len = 0;
		//ѭ�����������е����ݶ�ȡ������������
		while((len=in.read(buffer))>0){
			//��������������ݵ��������ʵ���ļ�����
			out.write(buffer, 0, len);
		}
		//�ر��ļ�������
		in.close();
		//�ر������
		out.close();
	}
}
