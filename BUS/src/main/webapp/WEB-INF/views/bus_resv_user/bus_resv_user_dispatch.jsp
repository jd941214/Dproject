<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../top.jsp" %>
 
 
 <div>
 	<form action="#">
 	<table border="1">
 	<c:if test="${mode eq 'oneway'}">
 	<tr>
 		<td colspan="9">${one_date}</td>
 		
 	</tr>
 	<tr>
 		<th>노선번호</th>
 		<th>출발지</th>
 		<th>도착지</th>
 		<th>등급</th>
 		<th>가격</th>
 		<th>출발시간</th>
 		<th>도착시간</th>
 		<th>좌석수</th>
 		<th>예약</th>
 	</tr>
 	<c:if test="${empty dispatch_list}">
 	<tr>
 		<td colspan="9">해당되는 배차정보가 없습니다</td>
 	</tr>
 	</c:if>
 	<c:forEach var="list" items="${dispatch_list}">
 		<tr>
 			<td>${list.road_no}</td>
 			<td>${list.arrival}</td>
 			<td>${list.departure}</td>
 			<td>${list.grade}</td>
 			<td>${list.price}</td>
 			<td>${list.arr_time}</td>
 			<td>${list.tot_time+list.arr_time}</td>
 			<td>${list.seat}</td>
 			<td><a href="<c:url value="bus_resv_user_seat.do">
 			<c:param name="one_date" value="${one_date}"></c:param>
 			<c:param name="road_no" value="${list.road_no}"></c:param>
 			<c:param name="arrival" value="${list.arrival}"></c:param>
 			<c:param name="departure" value="${list.departure}">
 			</c:param></c:url>">예약</a></td>
 		</tr>
 	</c:forEach>
 	</c:if>
 	
 	</table>
 	</form>
 </div>

<c:if test="${mode eq 'twoway'}">
 <form action="#">
	 <div align="center" style="display: inline-block; border:solid 1px blue;">
 		<table border="1">
 			<tr>
 				<td colspan="9">${arr_date}</td>
 			</tr>
 			<tr>
 				<th>노선번호</th>
 				<th>출발지</th>
 				<th>도착지</th>
 				<th>등급</th>
 				<th>가격</th>
 				<th>출발시간</th>
 				<th>도착시간</th>
 				<th>좌석수</th>
 				<th>예약</th>
 			</tr>
 			<c:if test="${empty arr_dispatch_list}">
 			<tr>
 				<td colspan="9">해당되는 배차정보가 없습니다</td>
 			</tr>
 			</c:if>
 			<c:forEach var="arr_list" items="${arr_dispatch_list}">
 				<tr>
		 			<td>${arr_list.road_no}</td>
		 			<td>${arr_list.arrival}</td>
		 			<td>${arr_list.departure}</td>
		 			<td>${arr_list.grade}</td>
		 			<td>${arr_list.price}</td>
		 			<td>${arr_list.arr_time}</td>
		 			<td>${arr_list.tot_time + arr_list.arr_time}</td>
		 			<td>${arr_list.seat}</td>
		 			<td>예약</td>
 				</tr>
 			</c:forEach>
 			
 		</table>
	 </div>
 </form>

<form>
 	<div align="center" style="display: inline-block">
 		<table border="1">
 			<tr>
 				<td colspan="9">${dep_date}</td>
 			</tr>
 			<tr>
 				<th>노선번호</th>
 				<th>출발지</th>
 				<th>도착지</th>
 				<th>등급</th>
 				<th>가격</th>
 				<th>출발시간</th>
 				<th>도착시간</th>
 				<th>좌석수</th>
 				<th>예약</th>
 			</tr>
 			<c:if test="${empty dep_dispatch_list}">
 			<tr>
 				<td colspan="9">해당되는 배차정보가 없습니다</td>
 			</tr>
 			</c:if>
 			<c:forEach var="dep_list" items="${dep_dispatch_list}">
 				<tr>
		 			<td>${dep_list.road_no}</td>
		 			<td>${dep_list.arrival}</td>
		 			<td>${dep_list.departure}</td>
		 			<td>${dep_list.grade}</td>
		 			<td>${dep_list.price}</td>
		 			<td>${dep_list.arr_time}</td>
		 			<td>${dep_list.tot_time+dep_list.arr_time}</td>
		 			<td>${dep_list.seat}</td>
		 			<td>예약</td>
 				</tr>
 			</c:forEach>
 		</table>
 	</div>
</form> 	
 </c:if>
 <%@ include file="../bottom.jsp" %>
