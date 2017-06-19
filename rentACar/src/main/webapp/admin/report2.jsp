<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@page import="com.mysql.jdbc.EscapeTokenizer"%>
<%@page import="net.sf.jasperreports.engine.* "%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <% HashMap dbTable = ((HashMap)request.getAttribute("dbTable")); %> --%>

<%
	Connection conn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentacar", "root", "root");

// 		Map parametersMap = new HashMap();  
// 		parametersMap.put("jmbg",123123123);
		
 		HashMap dbTable = ((HashMap)request.getSession().getAttribute("dbTable"));

// 		Map dbTable = new HashMap();
// 		dbTable = ((Map)request.getAttribute("dbTable"));
		
//    		dbTable.put("jmbg", 123123123);
		String jrxmlFile = session.getServletContext().getRealPath("/admin/report2.jrxml");
		InputStream input = new FileInputStream(new File(jrxmlFile));
		JasperReport jasperReport = JasperCompileManager.compileReport(input);

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, dbTable, conn);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (conn != null) {
			conn.close();
		}
	}
%>

