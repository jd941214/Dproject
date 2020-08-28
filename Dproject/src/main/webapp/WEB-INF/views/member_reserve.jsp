<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align = "center">
<hr color="green" width="300">
<h2>호 텔 예 약 정 보</h2>
<hr color="green" width="300">
<table class = "outline" border = "1">
	<tr align = "center">
		<th>선택</th>
		<th>예약번호</th>
		<th>호텔이름</th>
		<th>방 번호</th>
		<th>가격</th>
	</tr>
	<c:choose>
		<c:when test="${empty hotelList}">
			<td colspan = "4" align = "center">
				예약 정보가 없습니다.
			</td>
		</c:when>
		<c:otherwise>
			<c:forEach var = "dto" items = "${hotelList}">
				<tr align = "center">
					<td><input type = "checkbox" name = "choose" value = "${dto.hotel_resv_no}"></td>
					<td>${dto.hotel_resv_no}</td>
					<td>${dto.name}</td>
					<td>${dto.room_no}</td>
					<td>${dto.price}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</div>
<%@ include file="bottom.jsp" %>