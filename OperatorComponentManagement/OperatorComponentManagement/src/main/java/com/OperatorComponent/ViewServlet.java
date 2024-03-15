package com.OperatorComponent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<h1>Network Components List</h1>");
		
		List<Emp> list=EmpDao.getAllComponents();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>ComponentID</th><th>Type</th><th>Model</th><th>Status</th><th>Location</th><th>VendorID</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list){
			out.print("<tr><td>"+e.getCid()+"</td><td>"+e.getType()+"</td><td>"+e.getModel()+"</td><td>"+e.getStatus()+"</td><td>"+e.getLocation()+"</td><td>"+e.getVid()+"</td><td><a href='EditServlet?cid="+e.getCid()+"'>edit</a></td><td><a href='DeleteServlet?cid="+e.getCid()+"' onclick='return confirmDelete()'>delete</a></td></tr>");
			out.print("<script>");
			out.print("function confirmDelete() {");
			out.print("return confirm('Are you sure you want to delete?');");
			out.print("}");
			out.print("</script>");
		}
		out.print("</table>");
		out.close();
	}
}
