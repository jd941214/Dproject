<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../top.jsp"%> 

<div align="center">
	<form action="ADroom_insert.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="hotel_no" value="<%=request.getParameter("hnum")%>">
		<table width="100%">
			<tr>
				<td><input multiple="multiple" type="file" name="file" /></td>	
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