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
		String sno=request.getParameter("sno");//��ȡѧ��
		try {
			informList=informDao.findBySno(sno);//��ȡ����֪ͨ
			request.getSession().setAttribute("informList", informList);
			response.sendRedirect("/student/inbox.jsp");//�ض����ռ���ҳ��
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
