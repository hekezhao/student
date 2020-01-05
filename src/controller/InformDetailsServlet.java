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
		String sno=request.getParameter("sno");//获取学号
		Timestamp sendTime=Timestamp.valueOf(request.getParameter("sendTime"));//获取通知发送时间
		try {
			inform=informDao.findSpecificInform(sno,sendTime);//获取该通知
			request.getSession().setAttribute("inform", inform);
			response.sendRedirect("/student/details.jsp");//重定向到通知细节页面
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
