<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="team.Dproject.main.model.*"%>
<%@ include file="../top.jsp"%>
<div align="center">
	<table width="100%" height="100%" align="center">
	<tr align="center">
	<%
		roomDTO dto=(roomDTO)request.getAttribute("RDTO");
		String img=dto.getFilename(); 
		if(img!=null){
			String[] SPimg=img.split("/");
			%><td><%
			for(int i=0;i<SPimg.length;i++){
				%>
				<img src="${pageContext.request.contextPath}/resources/img/<%=SPimg[i] %>" width="120" height="80">
				<% 
			}
			%></td><%
		}else{
			%><td>이미지 없음</td><%
		}%>
	</tr>
	<tr align="center"><td>예약번호 : ${dto.hotel_resv_no}</td></tr>
	<tr align="center"><td>멤버이름 : ${MDTO.name}</td></tr>
	<tr align="center"><td>호텔이름 : ${HDTO.name}</td></tr>
	<tr align="center"><td>방이름 : ${RDTO.name}</td></tr>
	<tr align="center"><td>사용 포인트 : ${dto.use_point}</td></tr>
	<tr align="center"><td>적립 포인트 : ${dto.save_point}</td></tr>
	<tr align="center"><td>결제여부 : ${dto.pay}</td></tr>
	<tr align="center"><td>체크인 : ${dto.start_resv_date}</td></tr>
	<tr align="center"><td>체크아웃 : ${dto.end_resv_date}</td></tr>
	<tr align="center"><td><input type="button" value="돌아가기" onclick="window.location='resv_list.do?hnum=${dto.hotel_no}'">	
</table>
</div>
<%@ include file="../bottom.jsp"%>
 