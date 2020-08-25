<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>호텔관리자</title>
<style type="text/css">
	tr{
		align:"center";
	}
</style>

</head>
<body>
<%int member_num=2; %>
	<div align="center">
		<h2>호텔관리자 페이지</h2>
		<table>
			<tr>
				<td><a href="hotel_board.do?member_num=<%=member_num%>">호텔 게시판</a> | </td>
				<td><a href="hotel_list.do?member_num=<%=member_num%>">호텔리스트</a> | </td>
				<td><a href="home.do">관리자</a></td>
			</tr>
		</table>
	</div>