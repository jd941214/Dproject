<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp"%>
<div align="center" style="margin-top:0px">
	<h2>서울</h2>
</div>

<div align="center">
	icon
</div>

<div align="center">
	<label><a href="board_write.do">글쓰기</a></label>
	<table width="900" bgcolor="white">
		<tr bgcolor="#dbdbdb">
			<!-- 게시글 번호 -->
			<th>Nr.</th> 
			<!-- 제목 -->
			<th>Title</th> 
			<!-- 작성자 -->
			<th>User</th>
			<!-- 댓글 수 -->
			<th>Comments</th>
			<!-- 조회수 -->
			<th>View</th>
			<!-- 작성일 -->
			<th>Date</th>
		</tr>
		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="6">
					No Contents
				</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${listBoard}">
			<tr>
				<td><c:out value="${dto.main_board_no}"/></td>
				<td><a href="board_content.do?main_board_no=${dto.main_board_no}">${dto.title}</a></td>
				<td>${dto.member_no}</td>
				<td></td>
				<td>${dto.readcount}</td>
				<td>${dto.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="bottom.jsp"%>