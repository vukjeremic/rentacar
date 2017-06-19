package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import managers.userManager;
import retntACar1.User;
/**
 * Servlet implementation class uploadServlet
 */
@MultipartConfig(maxFileSize = 16177215) 
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/rentacar";
    private String dbUser = "root";
    private String dbPass = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u= (User) request.getSession().getAttribute("user");
		boolean isAdmin=new userManager().isAdmin(u);
		if(!isAdmin){
			request.getRequestDispatcher("/admin/pagenotfound.jsp").forward(request, response);
		}
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/admin/fotografije.jsp");
		rd.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("lastName");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
//            System.out.println(filePart.getName());
//            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; // connection to the database
//        String message = null;  // message will be sent back to client
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "INSERT INTO files (file) values (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, firstName);
//            statement.setString(2, lastName);
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(1, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                System.out.println("uspeo sam a ti nisi");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
//            request.setAttribute("Message", message);
             
            // forwards to the message page
//            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
        doGet(request, response);
	}

}
