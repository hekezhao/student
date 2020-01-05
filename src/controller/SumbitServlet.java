package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Homework;
import dao.HomeworkDao;

import javax.servlet.annotation.WebServlet;

@WebServlet("/submit")
public class SumbitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException {
		HomeworkDao homeworkDao=new HomeworkDao();
		Homework homework=new Homework();
		//获取作业信息
		String cno=request.getParameter("cno");
		String term=request.getParameter("term");
		String sno=request.getParameter("sno");
		String tno=request.getParameter("tno");
		String title=request.getParameter("title");
		try {
			homework=homeworkDao.findSpecificHomework(cno, term, sno, tno, title);//获取该作业
			request.getSession().setAttribute("homework", homework);
			response.sendRedirect("/student/submit.jsp");//重定向到提交页面
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
