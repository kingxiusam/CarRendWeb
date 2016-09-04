<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传与下载</title>
</head>
<body>

<form action="servlet/JspUpload" method="post" enctype="multipart/form-data">
文件上传<input type="file" id="excel" name="excel">
<input type="submit" value="开始上传" onclick="javascript: return confirm('真的要上传吗？');">
<br>
<a href="servlet/DataImportDB" onclick="javascript: return confirm('真的要导入吗？');">数据导入</a>
</form>
</body>
</html>