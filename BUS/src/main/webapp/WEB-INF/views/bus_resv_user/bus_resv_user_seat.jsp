<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../top.jsp" %>

	<form action="#">
	<div>
		<div style="border:1px solid gray; width:90%;">
			<h3 style="width:80%;">${dto.arrival} ▶ ${dto.departure}  (${one_date})</h3>
			<input type="hidden" name="one_date" value="${one_date}">
			
		</div><!-- 출발지 도착지 -->
		<div style="border:1px solid gray; width:90%; height:300px">
		
			<div style="border:1px solid blue; width:10%; float:left;">
				운전기사
			</div>
			<br><br>
			<c:forEach var="seat" begin="1" end="${seat_dto.seat}" step="1">
				<c:if test="${seat%2 !=0}">
				<div style="border:1px solid blue; width:10%; float:left;">
					<p><input type="checkbox" name="seat" value="${seat}">${seat}</p>
				</div>
				</c:if>
				<c:if test="${seat%2 == 0}">
					<div style="border:1px solid blue; width:10%; float:right;">
						<p><input type="checkbox" name="seat" value="${seat}">${seat}</p>
					</div>
				</c:if>
			</c:forEach>

			
		</div>
	</div>
	</form>


<%@ include file="../bottom.jsp"%>