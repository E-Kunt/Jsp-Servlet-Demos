

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FromServletToJsp
 */
@WebServlet("/FromServletToJsp")
public class FromServletToJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FromServletToJsp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ʹ��forward�ķ�ʽ��ת��JSPҳ��
		request.setAttribute("name", "ekunt");
		this.getServletConfig().getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		
		//ʹ��sendRedirect������ת��JSPҳ��
		//response.sendRedirect("result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
