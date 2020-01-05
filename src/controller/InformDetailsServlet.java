package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Timestamp;

import bean.Inform;
import dao.InformDao;

import javax.servlet.annotation.WebServlet;

@WebServlet("/informdetails")
public class InformDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException {
		InformDao informDao=new InformDao();
		Inform inform=new Inform();
		String sno=request.getParameter("sno");//��ȡѧ��
		Timestamp sendTime=Timestamp.valueOf(request.getParameter("sendTime"));//��ȡ֪ͨ����ʱ��
		try {
			inform=informDao.findSpecificInform(sno,sendTime);//��ȡ��֪ͨ
			request.getSession().setAttribute("inform", inform);
			response.sendRedirect("/student/details.jsp");//�ض���֪ͨϸ��ҳ��
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
