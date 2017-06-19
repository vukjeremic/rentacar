package servlets;

import java.io.IOException;
import java.net.URLConnection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="filterOne", urlPatterns = { "/admin/*", "/cenovnik/*", "/home/*", "/kontakt/*", "/rezervisi/*", "/vozniPark/*", "/rezervisiServlet/*", "/vozniParkServlet/*", "/cenovnikServlet/*", "/adminCenovnikServlet/*", "/pregledIznajmljivanjaServlet/*", "/razduziServlet/*", "/uploadServlet/*"  })

public class LoginFilter implements Filter {

	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(((HttpServletRequest) request).getSession().getAttribute("user")!=null){
			chain.doFilter(request, response);
			System.out.println("Inside filter one.");
			
		}else {	
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
