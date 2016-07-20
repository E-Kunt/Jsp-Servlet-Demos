package com.ekunt.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionInfo
 */
@WebServlet("/SessionInfo")
public class SessionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionInfo() {
        super();
    }	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String headMsg;
		PrintWriter writer = response.getWriter();
		//��û򴴽�һ��Session
		HttpSession mysession = request.getSession(true);
		
		//��дSession��ļ�ֵ�ԣ���ɷ��ʴ����ļ�¼����ʾ
		Integer i = (Integer)mysession.getAttribute("i");
		if(i == null) {
			headMsg = "Hello, new guy!";
			mysession.setAttribute("i", new Integer(0));
		} else {
			headMsg = "Welcome back!";
			mysession.setAttribute("i", i.intValue() + 1);
		}
		writer.println("<h1>" + headMsg + "</h1>");
		writer.println("<br/> i:" + mysession.getAttribute("i"));
		
		//չʾSession�ĸ�������
		writer.println("<h1>Session Info</h1>");
		writer.println("<br/>Id: " + mysession.getId());
		writer.println("<br/>Creation Time: " + new Date(mysession.getCreationTime()));
		writer.println("<br/>Last Accessed Time: " + new Date(mysession.getLastAccessedTime()));
		writer.println("<br/>Is New: " + mysession.isNew());
		
		//չʾrequest���й�Session�ĸ�������
		writer.println("<h1>Request</h1>");
		writer.println("<br/>Requested Session Id: " + request.getRequestedSessionId());
		writer.println("<br/>Is Requested Session Id From Cookie: " + request.isRequestedSessionIdFromCookie());
		writer.println("<br/>Is Requested Session Id From URL: " + request.isRequestedSessionIdFromURL());
		writer.println("<br/>Is Requested Session Id Valid: " + request.isRequestedSessionIdValid());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
