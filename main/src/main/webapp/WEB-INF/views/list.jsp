<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<h2>서울</h2>
</div>

<div>
	icon
</div>

<div>
	<label><a href="board_write.do">글쓰기</a></label>
	<table width="900">
		<tr bgcolor="#dbdbdb">
			<!-- 게시글 번호 -->
			<th>Nr.</th> 
			<!-- 제목 -->
			<th>Subject</th> 
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
				<td>${dto.title}</td>
				<td>${getId}</td>
				<td>${dto.rno}</td>
				<td>${dto.readcount}</td>
				<td>${dto.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
</div>