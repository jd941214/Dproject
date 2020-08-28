<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<%@ include file="../top.jsp" %>
<%

%>
	<div align="center">
		<table width="800">
						<tr align="right">
				<td colspan="8">
					<a href="bus_road_insert.do">추가</a>
				</td>
			</tr>
		</table>
		<table width="100%" border="1">
			<tr>
				<th>노선번호</th>
				<th>버스번호</th>
				<th>노선 등록 회원</th>
				<th>출발지</th>
				<th>도착지</th>
				<th>가격</th>
				<th>출발시간</th>
				<th>도착시간</th>
				<th>수정/삭제</th>
			</tr> 
			<c:if test="${empty listBus_road}">
				<tr>
					<td colspan="9">등록된 노선이 없습니다.</td>
				</tr>	
			</c:if>
			<c:forEach var="dto" items="${listBus_road}">			
			<tr align="center">
				<td>${dto.road_no}</td>
				<td>${dto.bus_no}</td>
				<td>${dto.member_no}</td>
				<td>${dto.arrival}</td>
				<td>${dto.departure}</td>
				<td>${dto.price}</td>
				<td>${dto.arr_time}</td>
				<td>${dto.tot_time+dto.arr_time}</td>
				<td>
					<a href="bus_road_update.do?no=${dto.road_no}">수정</a> | 
					<a href="bus_road_delete.do?no=${dto.road_no}">삭제</a>
				</td>
			</tr>	
			</c:forEach>
		</table>	
	</div>
<%@ include file="../bottom.jsp" %> 