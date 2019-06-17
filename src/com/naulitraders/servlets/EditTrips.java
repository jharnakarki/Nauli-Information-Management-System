package com.naulitraders.servlets;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.*;
public class EditTrips extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/Project"; 
		String uname="root";
		String pwd="";
		try{
			// load the database driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pwd);
			String sql="select * from trip";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			PrintWriter pw=response.getWriter();
			pw.println("<html><body>");
			pw.println("<table border=1 width='1000'>");
			pw.println("<tr><th>ID</th><th>Truck NO.</th><th>StartDate</th><th>EndDate</th><th>Start Mileage</th><th>End Mileage</th><th>Origin</th><th>Mul Destination</th><th>revenue</th><th>driver</th><th>Remarks</th></tr>");
			while(rs.next()) {
				pw.println("<tr>");
				for(int i=1;i<=11;i++) {
					pw.println("<td>"+rs.getString(i)+"</td>");
				}
				pw.println("</tr>");
			}
			pw.println("</table></body></html>");
			pw.println("<a href='Form.html'>Edit Trip</a>");
			pw.close();
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}

