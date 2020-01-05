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
		//��ȡ�γ���Ϣ
		String cno=request.getParameter("cno");
		String term=request.getParameter("term");
		String sno=request.getParameter("sno");
		String tno=request.getParameter("tno");
		try {
			homeworkList=homeworkDao.find(cno, term, sno, tno);//��ȡ���ſγ̵���ҵ
			request.getSession().setAttribute("homeworkList", homeworkList);
			response.sendRedirect("/student/homework.jsp");//�ض�����ҵҳ��
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
