package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.Delay;
import dao.DelayDao;

import javax.servlet.annotation.WebServlet;

@WebServlet("/delay")
public class DelayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException {
		DelayDao delayDao=new DelayDao();
		Delay delay=new Delay();
		String message=null;
		try {
			//��ȡ�ύ����������
			delay.setCno(request.getParameter("cno"));
			delay.setTerm(request.getParameter("term"));
			delay.setSno(request.getParameter("sno"));
			delay.setTno(request.getParameter("tno"));
			delay.setWorkTitle(request.getParameter("workTitle"));
			delay.setReason(request.getParameter("reason"));
			delay.setDelayDays(request.getParameter("delayDays"));
			boolean success=delayDao.addDelay(delay);//�����¼
			if(success) {
				message="�ύ�ɹ���";
			}else {
				message="�ύʧ�ܣ�";
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");//����ת�����ύ���ҳ��
		rd.forward(request, response);
	}
}
