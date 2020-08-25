<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../top.jsp"%>
<div align="center">
	<table width="100%">
		<tr align="right">
			<td colspan="7"><a href="room_insert.do?hnum=<%=request.getParameter("hnum")%>">추가</a></td>
		</tr>
		<tr>
			<td>방번호</td>
			<!-- 멤버넘 -->
			<!-- 호텔넘 -->
			<td>방이름</td>
			<td>방 평수</td>
			<td>인원수</td>
			<td>상세설명 (구비물품)</td>
			<td>이미지</td>
			<td>수정/삭제</td>
		</tr>
		
		<c:if test="${empty list}">
			<tr>
				<td colspan="7">등록된 방이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.room_no}</td>
				<td>${dto.name}</td>
				<td>${dto.roomsize}</td>
				<td>${dto.sleeps}</td>
				<td>${dto.item}</td>
				<c:if test="${dto.filesize != 0}">
					<td><img
						src="c:/img/${dto.filename }" width="40">
					</td>
				</c:if>
				<c:if test="${dto.filesize == 0}">
					<td>이미지없음
					</td>
				</c:if>

				<td><a href="room_update.do?no=${dto.room_no}">수정</a> | <a
					href="room_delete.do?no=${dto.room_no}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../bottom.jsp"%>
