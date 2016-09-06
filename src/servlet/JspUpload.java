package servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 用于接收文件上传请求
 * 
 * @author HuangDong
 */


@WebServlet(urlPatterns="/servlet/JspUpload")
@MultipartConfig(maxFileSize=1024*1024*10)
public class JspUpload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JspUpload() {
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

		doPost(request,response);
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
		request.setCharacterEncoding("utf-8");	
		//String filename=request.getParameter("name");
	//	StringUtils.substringBefore(request.getParameter("excel"),".xls");

try{
		Part part=request.getPart("excel");//
		if(part.getSize()==0L){
			request.setAttribute("result","请选择要上传的文件！！");
		}else{
			/*文件后缀名 */
		    String fileSuffix = FilenameUtils.getExtension(StringUtils.substringBetween(part.getHeader("content-disposition"), "filename=\"", "\""));
			/*原文件名 */
		    String file=StringUtils.substringBetween(part.getHeader("content-disposition"), "\\", ".");
		    String filename=file.substring(file.length()-3,file.length());
			/*文件具体路径 */
		    String saveFilePath = request.getSession().getServletContext().getRealPath("\\")+"upload\\";
		
			System.out.println(saveFilePath);
			System.out.println(fileSuffix);
			System.out.println(filename);
			
			part.write(saveFilePath + filename + "." + fileSuffix);
		//	part.write(saveFilePath + "data" + "." + fileSuffix);
			System.out.println(	saveFilePath + filename+ "." + fileSuffix);
		
		//	System.out.println(StringUtils.substringBefore(request.getParameter("excel"),".xls"));
		//	part.write(saveFilePath + UUID.randomUUID().toString() + "." + fileSuffix);
		//	part.write(saveFilePath + StringUtils.substringBefore(request.getParameter("excel"),".xls") + "." + fileSuffix);
			request.setAttribute("result", "文件上传成功！！！");
			response.sendRedirect("/CarRendDemo/DateMaker.jsp");
			
		}
     }catch(Exception e){
          if(e.getMessage().contains("its maximum permitted size")){
    	     e.printStackTrace();
    	     request.setAttribute("result","上传文件过大，请重新选择！！！");
         }else{
             e.printStackTrace();
             request.setAttribute("result","系统错误，请联系管理员");
            
     }
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

}
