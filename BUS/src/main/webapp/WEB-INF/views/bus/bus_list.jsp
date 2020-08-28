<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<table width="100%" width="800">
			<tr align="right">
				<td colspan="4">
					<a href="bus_insert.do">추가</a>
				</td>
			</tr>
		</table>
		<table border="1"  width="800">
			<tr height="10%" align="center">
				<td>버스번호</td>
				<td>버스등급</td>
				<td>버스좌석수</td>
				<td>수정/삭제</td>
			</tr> 
			<c:if test="${empty bus_list}">
				<tr height="10%">
					<td colspan="4">등록된 버스가 없습니다.</td>
				</tr>	
			</c:if>
			<c:forEach var="dto" items="${bus_list}">			
			<tr align="center">
				<td>${dto.bus_no}</td>
				<td>${dto.grade}</td>
				<td>${dto.seat}</td>
				<td>
					<a href="bus_update.do?no=${dto.bus_no}">수정</a> | 
					<a href="bus_delete.do?no=${dto.bus_no}">삭제</a>
				</td>
			</tr>	
			</c:forEach>
		</table>	
	</div>
<%@ include file="../bottom.jsp" %> 