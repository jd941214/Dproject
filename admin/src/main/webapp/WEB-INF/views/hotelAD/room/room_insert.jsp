<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../top.jsp"%> 
<%
	String img="";
	if(request.getParameter("img")!=null){
		img=request.getParameter("img");
	} 
%>
<div align="center">
	<form action="room_insert.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="hotel_no" value="<%=request.getParameter("hnum")%>">
		<input type="hidden" name="filename" value="<%=img%>">
		<table width="100%">
			<tr>
				<%
					if(img!=""){
						String[] SPimg=img.split("/");
						%><td><%
						for(int i=0;i<SPimg.length;i++){
							%>
							<img src="${pageContext.request.contextPath}/resources/img/<%=SPimg[i] %>" width="80" height="40">
							<%
						}
						%></td><%
					}
				%>
			</tr>
			<tr>
				<td>
				<a href="#" onClick="window.open('imgIN.do?img=<%=img %>'
				,'이미지','width=400, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">이미지추가</a>
				</td>
			</tr>
			<tr>
				<td>방이름 : <input type="text" name="name"></td>
			</tr>
			<tr>
				<td>방 평수 : <input type="text" name="roomsize"></td>
			</tr>
			<tr>
				<td>인원수 : <input type="text" name="sleeps"></td>
			</tr>
			<tr>
				<td>구비 물품 : <input type="text" name="item"></td>
			</tr>
			<tr>
				<td>방가격 : <input type="text" name="price" size="30"></td>
			</tr>
			<tr>
				<td>방의 수 : <input type="text" name="rooms" size="30"></td>
			</tr>
			<tr>
				<td><input type="submit" value="추가"></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="../bottom.jsp"%>