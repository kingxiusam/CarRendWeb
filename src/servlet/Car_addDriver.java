package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timetask.Get_sum_money;
import config.TimeConfig;
import entity.Car;
import bean.SqlControule;

public class Car_addDriver extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7218733594499159616L;

	/**
	 * Constructor of the object.
	 */
	public Car_addDriver() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String DriverId=request.getParameter("check_driver");
	    ServletContext application=this.getServletContext();//将application当成application内置对象使用
	    
	    
	    if(DriverId!=null){
			
				ArrayList dlist=(ArrayList)application.getAttribute("dlist");//已选司机列表
				
				
			   if(dlist==null){
				   dlist=new ArrayList();
				   dlist.add(DriverId);
	               application.setAttribute("dlist",dlist);
	               try {
	       			
	       		
	       			SqlControule.updateCar("CarId",request.getParameter("Car_addDriver_id"),"Cdrivername", request.getParameter("check_driver"));
	       			response.sendRedirect("/CarRendDemo/car/Car_query_success.jsp");
	       		} catch (SQLException e) {
	       			// TODO Auto-generated catch block
	       			e.printStackTrace();
	       		}
	          
			}else{
				
				if(!dlist.contains(DriverId)){
					dlist.add(DriverId);
					try {
						
						SqlControule.updateCar("CarId",request.getParameter("Car_addDriver_id"),"Cdrivername", request.getParameter("check_driver"));
						response.sendRedirect("/CarRendDemo/car/Car_query_success.jsp");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
				 }else{
					  response.sendRedirect("/CarRendDemo/Driver/Driver_query_success.jsp?isOver=yes");
				 }		 
		}	
	    
	}    
	    
} 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
			


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
