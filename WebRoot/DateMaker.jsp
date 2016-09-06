<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传与下载</title>
</head>
<body>
<center>
<form action="servlet/JspUpload" method="post" enctype="multipart/form-data">
文件上传<input type="file" id="excel" name="excel">
<input type="submit" value="开始上传" onclick="javascript: return confirm('真的要上传吗？');">
<br>
数据导入
<a href="servlet/DataImportDB?table_type=客户表" onclick="javascript: return confirm('真的要导入吗？');">导入到客户表</a>
<a href="servlet/DataImportDB?table_type=车辆表" onclick="javascript: return confirm('真的要导入吗？');">导入到车辆表</a>
<a href="servlet/DataImportDB?table_type=司机表" onclick="javascript: return confirm('真的要导入吗？');">导入到司机表</a>
</form>
</center>
</body>
</html>