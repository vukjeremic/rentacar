package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import retntACar1.User;
import retntACar1.loginController;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("logout") != null) {
			request.getSession().invalidate();
			
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			User k = loginController.login(username, password);
			if (k != null) {
				request.getSession().setAttribute("user", k);
				if (k.getEmail().equalsIgnoreCase("admin") && k.getPass().equalsIgnoreCase("admin")){
					request.getRequestDispatcher("/admin/adminpage.jsp").forward(request, response);
				}
				
				request.getRequestDispatcher("/home/homepage.jsp").forward(request, response);
			} else {
				request.setAttribute("loginFailed", true);
				request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
