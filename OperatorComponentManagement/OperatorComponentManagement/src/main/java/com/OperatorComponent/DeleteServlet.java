package com.OperatorComponent;

import java.io.IOException;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		//int cid=Integer.parseInt(sid);
		EmpDao.delete(cid);
		response.sendRedirect("ViewServlet");
	}
}
 
