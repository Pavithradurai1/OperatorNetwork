package com.OperatorComponent;

import java.io.IOException;
import java.io.PrintWriter;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Components</h1>");
		String cid=request.getParameter("cid");
		//int cid=Integer.parseInt(sid);
		
		Emp e=EmpDao.getComponentById(cid);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='cid' value='"+e.getCid()+"'/></td></tr>");
		out.print("<tr><td>Type:</td><td><input type='text' name='type' value='"+e.getType()+"'/></td></tr>");
		out.print("<tr><td>Model:</td><td><input type='text' name='model' value='"+e.getModel()+"'/></td></tr>");
		//out.print("<tr><td>Status:</td><td><input type='text' name='status' value='"+e.getStatus()+"'/></td></tr>");
		out.print("<tr><td>Status:</td><td>");
		out.print("<select name='status' style='width:150px'>");
		out.print("<option>Active</option>");
		out.print("<option>Inactive</option>");
		out.print("<option>Maintenance</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>Location:</td><td><input type='text' name='location' value='"+e.getLocation()+"'/></td></tr>");
		out.print("<tr><td>VendorID:</td><td><input type='text' name='vid' value='"+e.getVid()+"'readonly/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
 
