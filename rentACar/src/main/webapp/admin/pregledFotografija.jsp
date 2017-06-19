<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Picture preview</title>

<meta http-equiv="refresh" content="5">
</head>

<body>





	<%@ page import="java.sql.*"%>

	<%@ page import="java.io.*"%>


	<%
		// 	int randomWithRange=(int)(Math.random() * (9) + 2);
		//maxid-minid+1 prva zagrada druga zagrada minid

		Blob image = null;

		Connection con = null;

		byte[] imgData = null;

		Statement stmt = null;

		ResultSet rs = null;

		ResultSet min = null;
		ResultSet max = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentacar", "root", "root");

			stmt = con.createStatement();

			// 			rs = stmt.executeQuery("select file from files where id = '"+randomWithRange+"'");
			rs = stmt.executeQuery("select file from files order by RAND()");

			if (rs.next()) {

				image = rs.getBlob(1);

				imgData = image.getBytes(1, (int) image.length());

			} else {

				out.println("Display Blob Example");

				out.println("image not found for given id>");

				return;

			}

			// display the image

			response.setContentType("image/gif");

			OutputStream o = response.getOutputStream();

			o.write(imgData);

			o.flush();

			o.close();

		} catch (Exception e) {

			out.println("Unable To Display image");

			out.println("Image Display Error=" + e.getMessage());

			return;

		} finally {

			try {

				rs.close();

				stmt.close();

				con.close();

				// 				Thread.sleep(1000);
				response.setHeader("Refresh", "300");

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}
	%>
</body>
</html>