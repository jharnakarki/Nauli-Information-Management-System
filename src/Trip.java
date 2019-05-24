import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;
public class Trip extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/Project";
		String uname="root";
		String pwd="";
			int Tnum=Integer.parseInt(request.getParameter("vehNum"));
			//String Start=request.getParameter("dtStart");
			//String End=request.getParameter("dtEnd");
			int Start=Integer.parseInt(request.getParameter("dtStart"));
			int End=Integer.parseInt(request.getParameter("dtEnd"));
			int MStart=Integer.parseInt(request.getParameter("mastart"));
			int MEnd=Integer.parseInt(request.getParameter("maEnd"));
			String origin=request.getParameter("org");
			String des=request.getParameter("mulDes");
			int reve=Integer.parseInt(request.getParameter("rev"));
			String dName=request.getParameter("dName");
			String rem=request.getParameter("remarks");
			
			try {
				//load the database driver
				Class.forName("com.mysql.jdbc.Driver");
				//create connection to database
				Connection con= DriverManager.getConnection(url,uname,pwd);
				String sql="insert into trip(vehNum,dtStart,dtEnd,maStart,maEnd,org,mulDes,rev,dName,remarks) values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setInt(1,Tnum);
				pst.setInt(2,Start);
				pst.setInt(3, End);
				pst.setInt(4, MStart);
				pst.setInt(5, MEnd);
				pst.setString(6, origin );
				pst.setString(7,des);
				pst.setInt(8, reve);
				pst.setString(9,dName );
				pst.setString(10, rem);
				
			
				pst.execute();
				con.close();
				System.out.println("Record inserted");
		}
		catch(Exception ex) {
			System.out.println(ex);
			
		}
		
	}
}





