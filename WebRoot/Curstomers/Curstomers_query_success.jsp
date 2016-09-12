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

<script type="text/javascript">
var success="<%=request.getParameter("isSuccess")%>";
var over="<%=request.getParameter("isOver")%>";

if(over=="yes"){
   alert("你已选择了该车辆");
}
if(success=="yes"){
   confirm("表单已提交,请等待处理！");
}

function getMoney(){
var money="<%=session.getAttribute("sum_money")%>";

   if(money!=null){
   alert("当前系统为你结算的租金总额为："+money);
   }else{
     alert("系统正为你结算租金总额，请在至少一个工昨日后结算");
   }
}



</script>
<div id="navi">
	<div id='naviDiv'>
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;顾客管理<span>&nbsp;
		<span><img src="../images/arror.gif" width="7" height="11" border="0" alt=""></span>&nbsp;<a href="<%=path%>/Curstomers/Curstomers_query_success.jsp">顾客列表</a><span>&nbsp;
	</div>
</div>
<div id="tips">
	<div id="buttonGroup">
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'" ">
			<a href="<%=path%>/Curstomers/Curstomers_add.jsp">添加客户</a>
		</div>
		<div class="button" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
			<a>查找客户</a>
		</div>
	</div>
</div>

<% 


     int  curpage=1;//默认当前页为1
	 String spage=request.getParameter("curpage");
	 if(spage!=null){
	 curpage=Integer.parseInt(spage);
	 }
	 
	 
    // SqlControule sqlObj=new SqlControule();
	 List<Curstom> curstomers=new  ArrayList<Curstom>();
	// curstomers=sqlObj.queryAllCurstom();
	if(curstomers.size()>=20){
 	 curstomers= SqlControule.getSqlObj().queryAllCurstom().subList((curpage-1)*20, (curpage-1)*20+20);
 	 }else{
 	  curstomers= SqlControule.getSqlObj().queryAllCurstom();
 	 }
	 pageContext.setAttribute("curstomerlist",curstomers);

	 session.setAttribute("sum_money",Get_sum_money.getMoney());
     
     
     int listsize=curstomers.size();//总的记录数
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
		<td>相关操作</td>
	</tr>
	
 <c:forEach var="curstomer" items="${curstomerlist}"  varStatus="item">
	
	<tr class="list">
	    <td>${curstomer.dentifyId}</td>
	    <td>${curstomer.curstomName}</td>
        <td>${curstomer.curstomage}</td>
	    <td>${curstomer.curstomAdress}</td>
	    <td>${curstomer.curstomphone}</td>
		<td><a href="<%=path%>/Curstomers/Curstomers_RendCar.jsp?CurstomId=${curstomer.dentifyId}&CurstomPhone=${curstomer.curstomphone}">租赁车辆</a>
		&nbsp;&nbsp;<a href="<%=path%>/servlet/Curstomers_delete?CurstomName=${curstomer.curstomName}"onclick="javascript: return confirm('真的要删除吗？');">删除</a>
	    </td>
	</tr>
  </c:forEach>
</table>
<% 
out.println("<tr><td><a href=Curstomers_query_success.jsp?curpage=1>首页</a></td>");
out.println("<td><a href=Curstomers_query_success.jsp?curpage="+(curpage+1)+">>下一页</a></td>");
out.println("<td><a href=Curstomers_query_success.jsp?curpage="+(curpage-1)+">>上一页</a></td>");      
out.println("<td><a href=Curstomers_query_success.jsp?curpage="+pages+">>最后一页</a></td>");

 %>
   <br>
<input type="button" name="getMoney" value="租金结算" onclick="getMoney()">
</div>
</body>
</html>