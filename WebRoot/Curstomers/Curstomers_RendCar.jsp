<%@ page language="java"  import="java.util.*,bean.SqlControule,entity.Car" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
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


</style>
<title>客户租车页面</title>

</head>
<body>

<%
     ArrayList<Car> cars=(ArrayList)application.getAttribute("cars_update");//页面下拉列表
     ArrayList<Car> rendedcars=(ArrayList)application.getAttribute("clist");//已租车辆
// 		     if(cars==null){
// 		    	 cars=(ArrayList)session.getAttribute("cars");
// 		    	 application.setAttribute("cars_update",cars);
// 		     }
		   
	 pageContext.setAttribute("carlist",cars);
     pageContext.setAttribute("rendedcarlist",rendedcars);
	 pageContext.setAttribute("yourid",request.getParameter("CurstomId"));
	 pageContext.setAttribute("yourphone",request.getParameter("CurstomPhone"));


			
	 %>
	<div id="navi">
	  <div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;客户管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/Curstomers/Curstomers_RendCar.jsp">客户租车</a><span>&nbsp;
	  </div>
</div>
<form name="rendForm" action="<%=path%>/servlet/Curstomers_RendCar" method="post">
<table width="400" align="center" style="background-image:url('../images/welcome.jpg')" >
  
  <tr>
    <td>你的身份证号：</td>
  <td>${yourid}</td>
  </tr>
  
  <tr>
    <td>联系电话：</td>
    <td>${yourphone}</td>
  </tr>
   
  <tr>
  <td>
  已经租赁的车辆:
  </td>
  
  <td>
   <c:forEach var="rendedcaritem" items="${rendedcarlist}"  varStatus="item">
    <span>${rendedcaritem}</span>&nbsp;
    </c:forEach>
  
  
  </td>
  </tr>
  <tr>
    <td>你可租赁的车辆：</td>
    <td>
    <select name="carid_check" >
    <option selected="selected">请点击选择</option>
 
    <c:forEach var="caritem" items="${carlist}"  varStatus="item">
    <option value="${caritem.carid}">
    ${caritem.carid}
    </option>
    </c:forEach>
    
    </select>
    (可选择多辆车)
    </td>
  </tr>
  
   <tr>
    <td>请选择租赁类型：</td>
    <td>
    <input type="radio" name="rendtype" onclick="javascript: return alert('你需要预付租金50元！')">日租
    <input type="radio" name="rendtype" onclick="javascript: return alert('你需要预付租金500元！')">月租
    </td>
  </tr>
  
    <tr>
    <td>请输入租车时间：</td>
    <td>
    <input type="text" name="rendtime">
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input class="button" type="submit" value="提交" onclick="javascript:return confirm('提交后将不能再更改,确定要提交吗?');"></td>
  </tr>
</table>
</form>
</body>
</html>