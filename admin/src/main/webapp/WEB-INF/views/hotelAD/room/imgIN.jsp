<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String img=null;
	if(request.getParameter("img")!=null){
		img=request.getParameter("img");
	}
%>

<body>
<div align="center">
	<form action="imgIN.do?img=<%=img %>" method="post" enctype="multipart/form-data">
		<table width="100%">
			<tr>
				<td>방이미지 : <input type="file" name="filename" size="30"></td>
			</tr>
			<tr>
				<td><input type="submit" value="추가"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>