package controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Class;
import dao.ClassDao;

import javax.servlet.annotation.WebServlet;

@WebServlet("/class")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException {
		ClassDao classDao=new ClassDao();
		ArrayList<Class> classList=new ArrayList<Class>();
		String sno=request.getParameter("sno");//获取学号
		try {
			classList=classDao.findBySno(sno);//获取所学习的课程
			request.getSession().setAttribute("classList", classList);
			response.sendRedirect("/student/class.jsp");//重定向到课程页面
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
