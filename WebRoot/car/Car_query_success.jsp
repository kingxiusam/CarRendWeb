<%@ page language="java"  import="java.util.*,bean.SqlControule,entity.Curstom,entity.Car,timetask.*" contentType="text/html; charset=utf-8"
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

<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;车辆管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/car/Car_query_success.jsp">车辆列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'" ">
			<a href="<%=path%>/car/Car_add.jsp">添加车辆</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a>查找车辆</a>
		</div>
	</div>
</div>

<% 
   // SqlControule sqlObj=new SqlControule();
	session.setAttribute("sum_money",Get_sum_money.getMoney());

	ArrayList<Car> cars=new  ArrayList<Car>();
    cars=SqlControule.getSqlObj().queryAllCar(null,null); 
    pageContext.setAttribute("carlist",cars);
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
		<td>类型</td>
		<td>车名</td>
		<td>车辆状态</td>
		<td>租金标准</td>
		<td>车牌号</td>
		<td>司机姓名</td>
		<td>相关操作</td>
	</tr>
	
 <c:forEach var="car" items="${carlist}"  varStatus="item">
	
	<tr class="list">
	    <td>${car.type}</td>
	    <td>${car.carname}</td>
        <td>${car.carstate}</td>
	    <td>${car.rendprice}</td>
	    <td>${car.carid}</td>
	    <td>${car.cdrivername}</td>
		
	<td><a href="<%=path%>/Driver/Driver_query_success.jsp?CarId=${car.carid}">安排司机</a>
	&nbsp;&nbsp;<a href="<%=path%>/servlet/Car_delete?CarId=${car.carid}"onclick="javascript: return confirm('真的要删除吗？');">删除</a></td>
	</tr>
  </c:forEach>
</table>

</div>
</body>
</html>