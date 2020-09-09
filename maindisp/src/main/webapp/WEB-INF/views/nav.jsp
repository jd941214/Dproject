<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nav.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body style="background-color: #f5f5f5;">
<div style="background-color: #fccfcf; padding-top: 0px; padding-bottom: 0px; margin-bottom:10px">
	<div style="margin-left: 550px; padding-top: 9px; padding-bottom:9px; display: flex; justify-content: space-between;">
		<div style="align-self: center; ">
			<button style="margin-right: 20px;" class="nav-btn-menu" onClick="location.href='index.do'">BUS</button>
			<button style="margin-right: 20px;" class="nav-btn-menu" onClick="location.href='login.do'">HOTEL</button>
			<button style="margin-right: 20px;" class="nav-btn-menu" onClick="location.href='list.do'">RESTAURANT</button>
			<button style="margin-right: 20px;" class="nav-btn-menu" onClick="location.href='donate.do'">FORUM</button>
		</div>
	</div>
</div>