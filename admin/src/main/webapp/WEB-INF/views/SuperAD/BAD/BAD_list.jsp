<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- memberAll.jsp -->
<%@ include file="../top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<hr color="green" width="300">
	<h2>버스관리자 목 록 보 기</h2>
	<hr color="green" width="300">
	<table width="100%" class="outline">
		<tr>
			<th class="m3">번호</th>
			<th class="m3">아이디</th>
			<th class="m3">이름</th>
			<th class="m3">이메일</th>
			<th class="m3">전화번호</th>
			<th class="m3">가입일</th>
			<th class="m3">회원등급</th>
			<th class="m3">수정 | 삭제</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="7" align = "center">등록된(찾으시는) 회원이 없습니다.</td>
				</tr>	
			</c:when>
			<c:otherwise>
				<c:forEach var="dto" items="${list}">
					<tr align = "center">
						<td>${dto.member_no}</td>
						<td>${dto.id}</td>
						<td><a href="ADmember_show.do?no=${dto.member_no }">${dto.name}</a></td>
						<td>${dto.email}</td>
						<td>${dto.allHp}</td>
						<td>${dto.joindate}</td>
						<td>${dto.position}</td>
						<td>
							<a href = "ADBADbus_list.do">관리중인 버스</a> |
							<a href = "ADmember_edit.do?id=${dto.id}">수정</a> |
							<a href = "ADmember_delete.do?id=${dto.id}">삭제</a>
						</td>
					</tr>	
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</div>
<%@ include file="../bottom.jsp"%>