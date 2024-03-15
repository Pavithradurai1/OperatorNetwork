package com.OperatorNetwork;

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
    /**
     *
     */
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        // Output HTML content with embedded CSS styles
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Network Component List</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f2f2f2; }");
        out.println("h1 { color: #333; text-align: center; margin-top: 20px; }");
        out.println("h2 { color: #666; margin-top: 30px; }");
        out.println("table { width: 80%; margin: 20px auto; border-collapse: collapse; }");
        out.println("th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println(".btn { padding: 8px 16px; border: none; cursor: pointer; border-radius: 4px; text-decoration: none; }");
        out.println(".btn-edit { background-color: #4CAF50; color: white; }");
        out.println(".btn-delete { background-color: #f44336; color: white; }");
        out.println(".search-form { margin: 20px auto; text-align: center; }");
        out.println(".search-form input[type='text'], .search-form select { padding: 8px; margin-right: 10px; }");
        out.println(".search-form input[type='submit'] { padding: 8px 16px; background-color: #008CBA; color: white; border: none; border-radius: 4px; cursor: pointer; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
 
        out.println("<div style='text-align: center; margin-top: 20px;'>");
        //out.println("<a href='index.html' style='display: inline-block; padding: 10px 20px; background-color: #008CBA; color: white; text-decoration: none; border-radius: 5px; transition: background-color 0.3s;'>Add New Components</a>");
        out.println("</div>");
 
        out.println("<h1>Network Component List</h1>");
 
        // Search parameters
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        String location = request.getParameter("location");
 
        // Search and filter form
        out.println("<div class='search-form'>");
        out.println("<form method='get'>");
        out.println("<input type='text' name='search' placeholder='Search...'>");
        out.println("<select name='type'>");
        out.println("<option value=''>Filter by Type</option>");
        out.println("<option value='Router'>Router</option>");
        out.println("<option value='Switch'>Switch</option>");
        out.println("<option value='Base Station'>Base Station</option>");
        out.println("<option value='Firewall'>Firewall</option>");
        out.println("</select>");
        out.println("<select name='status'>");
        out.println("<option value=''>Filter by Status</option>");
        out.println("<option value='Active'>Active</option>");
        out.println("<option value='Inactive'>Inactive</option>");
        out.println("<option value='Maintenance'>Maintenance</option>");
        out.println("</select>");
        out.println("<select name='location'>");
        out.println("<option value=''>Filter by Location</option>");
        out.println("<option value='Atlanta,GA'>Atlanta,GA</option>");
        out.println("<option value='Chicago,IL'>Chicago,IL</option>");
        out.println("<option value='Dallas,TX'>Dallas,TX</option>");
        out.println("<option value='San Jose,CA'>San Jose,CA</option>");
        out.println("</select>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form>");
        out.println("</div>");
 
        // Retrieve filtered list of components
        List<Emp> list = EmpDao.getAllComponents(search, type, status, location);
 
        // Display table
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>ComponentID</th><th>Type</th><th>Model</th><th>Status</th><th>Location</th><th>VendorID</th><th>Edit</th><th>Delete</th></tr>");
 
        // Display table rows
        for (Emp e : list) {
            out.print("<tr><td>" + e.getCid() + "</td><td>" + e.getType() + "</td><td>" + e.getModel() + "</td><td>" + e.getStatus() + "</td><td>" + e.getLocation() + "</td><td>" + e.getVid() + "</td><td><a href='EditServlet?cid=" + e.getCid() + "' class='btn btn-edit'>Edit</a></td><td><a href='DeleteServlet?cid=" + e.getCid() + "' class='btn btn-delete' onclick='return confirmDelete()'>Delete</a></td></tr>");
        }
        out.print("</table>");
 
        // JavaScript for delete confirmation
        out.print("<script>");
        out.print("function confirmDelete() {");
        out.print("return confirm('Are you sure you want to delete?');");
        out.print("}");
        out.print("</script>");
        out.println("</body>");
        out.println("</html>");
 
        out.close();
    }
}