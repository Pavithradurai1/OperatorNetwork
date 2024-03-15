package com.OperatorComponent;

import java.io.IOException;
import java.io.PrintWriter;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String cid=request.getParameter("cid");
		//int cid=Integer.parseInt(sid);
		String type=request.getParameter("type");
		String model=request.getParameter("model");
		String status=request.getParameter("status");
		String location=request.getParameter("location");
		String vid=request.getParameter("vid");
		Emp e=new Emp();
		e.setCid(cid);
		e.setType(type);
		e.setModel(model);
		e.setStatus(status);
		e.setLocation(location);
		e.setVid(vid);
		
		int status1=EmpDao.update(e);
		if(status1>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}
 
}   