<%@ page language="java" import="java.util.*,servlet.Users_login,bean.SqlControule,entity.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>

	<title>后台管理</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/index.css" />
</head>
<body>
<%
    ArrayList<Car> cars=new  ArrayList<Car>();
    cars=SqlControule.getSqlObj().queryAllCar(null,null);
    application.setAttribute("cars_update", cars);
    application.setAttribute("clist",null);
    
 %>
<div id="wrapper">
	<div id="header">
		<div id="logo">LOGO</div>
		<div id="title">后台管理系统</div>

		<div id="user_info">
			<div id="welcome">欢迎${sessionScope.uname}使用本系统</div>
			<div id="logout"><a href="Users_login.jsp">安全退出</a></div>
		</div>
	</div>
	<div id="navigator">
		<iframe src="tree.jsp"></iframe>
        </div><div id="main">
		<iframe name="MainFrame"></iframe>
	</div>
        
	
	<div id="footer">Copyright © 2016-2017 All Rights Reserved Powered By HuangDong</div>
</div>
</body>

<script type="text/javascript">

   
function screenAdapter(){
	document.getElementById('footer').style.top=document.documentElement.scrollTop+document.documentElement.clientHeight- document.getElementById('footer').offsetHeight+"px";
		document.getElementById('navigator').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.width=window.screen.width-230+"px";
}

window.onscroll=function(){screenAdapter();};
window.onresize=function(){screenAdapter();};
window.onload=function(){screenAdapter();};
</script>
</html>