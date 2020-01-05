package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException {
		String sname=request.getParameter("sname");//��ȡѧ������
		String sno=request.getParameter("sno");//��ȡѧ��
		request.getSession().setAttribute("sname", sname);
		request.getSession().setAttribute("sno", sno);
		response.sendRedirect("/student/protal.jsp");//�ض���ѧ����ҳ
	}
}
