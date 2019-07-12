package com.naulitraders.servlets;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.*;
public class EditEmpDetail extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/Project"; 
		String uname="root";
		String pwd="";
		try{
			// load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pwd);
			String sql="select * from Employee";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			PrintWriter pw=response.getWriter();
			pw.println("<html><body>");
			pw.println("<table border=1 width='1000'>");
			pw.println("<tr><th>ID</th><th>Emp ID</th><th>Name</th><th>Age</th><th>address</th><th>Phone</th><th>Position</th><th>Salary</th><th>Id Prove</th></tr>");


			while(rs.next()) {
				pw.println("<tr>");
				for(int i=1;i<=9;i++) {
					pw.println("<td>"+rs.getString(i)+"</td>");
				}
				pw.println("</tr>");
			}
			pw.println("</table></body></html>");
			
			pw.close();
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}


