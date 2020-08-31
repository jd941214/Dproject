<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../top.jsp" %>
	<div>
		<form action="bus_resv_user_payok.do">
		<input type="hidden" name="one_date" value="${one_date}">
		<input type="hidden" name="road_no" value="${resv_dto.road_no}">
		<c:forEach var="seat" items="${seat}">
			<input type="hidden" name="seat" value="${seat}">
		</c:forEach>
		
			<table border="1">
				<tr align="center">
					<td colspan="4">${one_date}</td>
				</tr>
				<tr>
					<td colspan="2">출발지:${dto.arrival}</td>
					<td colspan="2">도착지:${dto.departure}</td>
				</tr>
				<tr>
					<td colspan="2">출발시간:${resv_dto.arr_time}시</td>
					<td colspan="2">도착시간:${resv_dto.arr_time+resv_dto.tot_time}시</td>
				</tr>
				<tr>
					<td colspan="3">1장 가격:${resv_dto.price}원</td>
					<td>인원수:${seat_no}명</td>
				</tr>
				<tr>
					<td colspan="4">좌석번호: 
					<c:forEach var="seat" items="${seat}"> ${seat}번</c:forEach>
					</td>
				</tr>
				<tr align="right">
					<td colspan="4">총가격:${resv_dto.price*seat_no}</td>
				</tr>
				<tr align="right">
					<td colspan="4"><input type="submit" value="결제" size="100"></td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp" %>
