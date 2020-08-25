<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="hotel_update.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value="0">
		<input type="hidden" name="room_no" value="${dto.room_no}">
		<table width="100%">
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
				<td>방이미지 : <input type="file" name="filename" size="30"></td>
			</tr>
			<tr>
				<td><input type="submit" value="추가"></td>
			</tr>
		</table>
	</form>
	</div>

<%@ include file="../bottom.jsp" %> 