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
				<td><a href="ADBAD_list.do?pos=1">버스관리자 리스트</a> | </td>
				<td><a href="ADHAD_list.do?pos=2">호텔관리자 리스트</a> | </td>
				<td><a href="ADmember_list.do">회원리스트</a> | </td>
				<td><a href="home.do">관리자</a></td>
			</tr>
		</table>
	</div>