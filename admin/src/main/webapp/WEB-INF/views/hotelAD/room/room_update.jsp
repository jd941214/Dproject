<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
<%
	String img="";
	if(request.getParameter("img")!=null){
		img=request.getParameter("img");
	} 
%>
	<div align="center">
		<form action="ADroom_update.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value="2">
		<input type="hidden" name="room_no" value="${dto.room_no}">
		<table width="100%">
			
			<tr>
				<td><input multiple="multiple" type="file" name="file" /></td>	
			</tr>
			<tr>
				<td>방이름 : <input type="text" name="name" value="${dto.name }"></td>
			</tr>
			<tr>
				<td>방 평수 : <input type="text" name="roomsize" value="${dto.roomsize}"></td>
			</tr>
			<tr>
				<td>인원수 : <input type="text" name="sleeps" value="${dto.sleeps }"></td>
			</tr>
			<tr>
				<td>구비 물품 : <input type="text" name="item" value="${dto.item }"></td>
			</tr>
			<tr>
				<td>방가격 : <input type="text" name="price" value="${dto.price }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="추가"></td>
			</tr>
		</table>
	</form>
	</div>

<%@ include file="../bottom.jsp" %> 