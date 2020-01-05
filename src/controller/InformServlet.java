package controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Inform;
import dao.InformDao;

import javax.servlet.annotation.WebServlet;

@WebServlet("/inform")
public class InformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException {
		InformDao informDao=new InformDao();
		ArrayList<Inform> informList=new ArrayList<Inform>();
		String sno=request.getParameter("sno");//获取学号
		try {
			informList=informDao.findBySno(sno);//获取所有通知
			request.getSession().setAttribute("informList", informList);
			response.sendRedirect("/student/inbox.jsp");//重定向到收件箱页面
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
