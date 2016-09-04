package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5863116151898332415L;

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
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
          //设置页面不缓存
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);
		
		//在缓存中创建图像
		int width=60,height=20;
        BufferedImage image=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);		
        
        //获取图形上下文
        Graphics g=image.getGraphics();
        
	   //创建随机数对象
        Random random=new Random();
        
      //设定背景色
        g.setColor(new Color(122,123,100));
        g.fillRect(0, 0, width, height);
        
      //设置字体
      g.setFont(new Font("Times New Roman",Font.PLAIN,18));
	  
      //随机产生干扰线
      for(int i=0;i<200;i++){
    	  int x=random.nextInt(width);
    	  int y=random.nextInt(height);
    	  int x1=random.nextInt(12);
    	  int y1=random.nextInt(12);
    	  g.drawLine(x, y, x+x1, y+y1);
    	  
      }
      //取随机产生的验证码
      
      String sRand="";
      for(int i=0;i<4;i++){
    	  String rand=String.valueOf(random.nextInt(10));
    	  sRand+=rand;
    	  
    	  //将认证码显示到图像中
    	  g.setColor(new Color(30+random.nextInt(160),40+random.nextInt(170),40+random.nextInt(180)));
    	  g.drawString(rand, 13*i+6,16);
      }
    	  //将认证码存入SESSION
    	  request.getSession().setAttribute("yzm",sRand);
          g.dispose();
          //输出图像到页面
          ImageIO.write(image, "JPEG",response.getOutputStream());
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
