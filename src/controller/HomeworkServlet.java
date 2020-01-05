package controller;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Homework;
import dao.HomeworkDao;

import javax.servlet.annotation.WebServlet;

@WebServlet("/homework")
public class HomeworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException {
		HomeworkDao homeworkDao=new HomeworkDao();
		ArrayList<Homework> homeworkList=new ArrayList<Homework>();
		//获取课程信息
		String cno=request.getParameter("cno");
		String term=request.getParameter("term");
		String sno=request.getParameter("sno");
		String tno=request.getParameter("tno");
		try {
			homeworkList=homeworkDao.find(cno, term, sno, tno);//获取该门课程的作业
			request.getSession().setAttribute("homeworkList", homeworkList);
			response.sendRedirect("/student/homework.jsp");//重定向到作业页面
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
