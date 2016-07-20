package com.ekunt.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SetCookie() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(int i=1;i<4;i++) {
			//�������������Cookie,�رմ��ڻ��Զ����
			Cookie cookie1 = new Cookie("Session-Cookie-" + i, "value-" + i);
			response.addCookie(cookie1);
			
			//д���ļ���Cookie,�������õ�ʱ��Ż����
			Cookie cookie2 = new Cookie("Persistent-Cookie-" + i, "value-" + i);
			cookie2.setMaxAge(3600);
			response.addCookie(cookie2);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<html><head><title>��д��cookie</title></head><body>��д��cookie</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
