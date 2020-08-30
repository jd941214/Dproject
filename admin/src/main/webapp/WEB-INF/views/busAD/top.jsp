<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>버스관리자</title>
<style type="text/css">
	tr{
		align:"center";
	}
</style>
</head>
<body>
	<div align="center">
		<h2>버스관리자 페이지</h2>
		<table>
			<tr>
				<td><a href="ADbus_list.do">버스리스트</a> | </td>
				<td><a href="ADbus_station_list.do">터미널리스트</a> | </td>
				<td><a href="ADbus_load_list.do">버스노선리스트</a> | </td>
				<td><a href="ADbus_resv_list.do">버스예약리스트</a> | </td>
				<td><a href="home.do">관리자</a></td>
			</tr>
		</table>
	</div>