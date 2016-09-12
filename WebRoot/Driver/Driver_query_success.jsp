<%@ page language="java"  import="java.util.*,bean.SqlControule,entity.*,timetask.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<body>
<script type="text/javascript">

var over="<%=request.getParameter("isOver")%>";

if(over=="yes"){
   alert("该司机正在忙碌");
}

function checkDriver(){

document.getElementById("DriverStatu").innerHTML ="已被选" ;
}

</script>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;司机管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/car/Car_query_success.jsp">司机列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'" ">
			<a href="<%=path%>/car/Car_add.jsp">添加司机</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a>查找司机</a>
		</div>
	</div>
</div>

<% 
  int  curpage=1;//默认当前页为1
	 String spage=request.getParameter("curpage");
	 if(spage!=null){
	 curpage=Integer.parseInt(spage);
	 }
  
	List<Driver> drivers=new  ArrayList<Driver>();
	if(drivers.size()>=20){
    drivers=SqlControule.getSqlObj().queryAllDriver(null, null).subList((curpage-1)*20, (curpage-1)*20+20);
    }else{
      drivers=SqlControule.getSqlObj().queryAllDriver(null, null);
    }
    pageContext.setAttribute("driverlist",drivers);
   // request.getParameter("CarId");
    pageContext.setAttribute("CarId_save",request.getParameter("CarId"));
    
    
     int listsize=drivers.size();//总的记录数
	 int pages=0;
	 int curpage_index=1;//当前页默认为1
	 
	 if(listsize%20==0){
      pages=listsize/20;

	 }else{
	  pages=listsize/20+1;
	 }
	 
    
%>
<div id="mainContainer">
<table class="default" width="100%">
	<col width="15%">
	<col width="10%">
	<col width="5%">
	<col width="30%">
	<col width="15%">
	<col width="10%">
	<tr class="title">
		<td>身份证号</td>
		<td>姓名</td>
		<td>年龄</td>
		<td>地址</td>
		<td>联系电话</td>
		<td>驾驶证号</td>
		<td>相关操作</td>
	</tr>
	
 <c:forEach var="driver" items="${driverlist}"  varStatus="item">
	
	<tr class="list">
	    <td>${driver.dentifyId}</td>
	    <td>${driver.driverName}</td>
        <td>${driver.age}</td>
	    <td>${driver.driveradress}</td>
	    <td>${driver.driverphone}</td>
	    <td>${driver.driverId}</td>
		
		<td><a href="<%=path%>/servlet/Driver_delete?DriverId=${driver.driverId}" onclick="javascript: return confirm('真的要删除吗？');">删除</a>
		<a id="DriverStatu" href="<%=path%>/servlet/Car_addDriver?Car_addDriver_id=${CarId_save}&check_driver=${driver.driverName}" onclick="checkDriver()">选中</a>
		
		<!--<input type="radio" name="check_driver" value="${driver.driverName}" onclick="checkDriver()">-->
		</td>
	      
	</tr>
  </c:forEach>
</table>
<% 
out.println("<tr><td><a href=Driver_query_success.jsp?curpage=1>首页</a></td>");
out.println("<td><a href=Driver_query_success.jsp?curpage="+(curpage+1)+">>下一页</a></td>");
out.println("<td><a href=Driver_query_success.jsp?curpage="+(curpage-1)+">>上一页</a></td>");      
out.println("<td><a href=Driver_query_success.jsp?curpage="+pages+">>最后一页</a></td>");

 %>
</div>
</body>
</html>