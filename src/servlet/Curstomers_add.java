package servlet;

import interfacePack.FormReciver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import bean.SqlControule;



import entity.Curstom;

public class Curstomers_add extends HttpServlet implements FormReciver{


	/**
	 * 
	 */
	private static final long serialVersionUID = -540501263134576832L;

	/**
	 * Constructor of the object.
	 */
	public Curstomers_add() {
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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		
//		SqlControule sqlobj = null;
//		try {
//			sqlobj = new  SqlControule();
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
        try {
        	SqlControule.getSqlObj().addOneCurstom((Curstom) getParameter(request));
//       	sqlobj.addOneCurstom((Curstom)getParameter(request));
			System.out.print("Ìí¼Ó³É¹¦£¡£¡£¡");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		
	}

	@Override
	public Object getParameter(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String dentifyId=request.getParameter("curid");
		String curstomName=request.getParameter("curname");
		String curstomage=request.getParameter("curage");
		String curstomAdress=request.getParameter("curaddress");
		String Curstomphone=request.getParameter("curphone");
		return new Curstom(dentifyId,curstomName,curstomage,curstomAdress,Curstomphone);
	}

}
