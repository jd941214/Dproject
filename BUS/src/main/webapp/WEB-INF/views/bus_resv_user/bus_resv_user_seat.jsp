<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	div#left{
	border:1px solid blue; 
	width:10%;
	height:35px; 
	float:left
	}
	
	div#right{
	border:1px solid blue; 
	width:10%; 
	height:35px;
	float:right
	}
</style>
<%@ include file="../top.jsp" %>

	<form action="bus_resv_user_pay.do">
	<div>
		<div style="border:1px solid gray; width:90%;">
			<h3 style="width:80%;">${dto.arrival} ▶ ${dto.departure}  (${one_date})</h3>
			<input type="hidden" name="one_date" value="${one_date}">
			<input type="hidden" name="road_no" value="${seat_dto.road_no}">
			<input type="hidden" name="arrival" value="${dto.arrival}">
			<input type="hidden" name="departure" value="${dto.departure}">
			
			
		</div><!-- 출발지 도착지 -->
		<div style="border:1px solid gray; width:70%; height:590px">
		
			
			<div style="border:1px solid blue; width:20%; float:right;">
				문
			</div>
			<div style="border:1px solid blue; width:20%; float:left;">
				운전기사
			</div>
			<br><br>
			<div>
			<c:forEach var="seat" begin="1" end="${seat_dto.seat}" step="1">
				<c:if test="${seat%4==1 || seat%4==2}">
					<div id="left">
						<p><input type="checkbox" name="seat" value="${seat}">${seat}</p>
					</div>
				<c:if test="${seat%4==2}">
					<br><br>
				</c:if>
				</c:if>
				
				<c:if test="${seat%4==3 || seat%4==0}">
					<div id="right">
						<p><input type="checkbox" name="seat" value="${seat}">${seat}</p>
					</div>
					<c:if test = "${seat%4==0}">
						<br><br>
					</c:if>
				</c:if>
			</c:forEach>
			<div style="float:right"><input type="submit" value="예매" style="width:200px;"></div>
		</div>
		</div>
	</div>
	</form>


<%@ include file="../bottom.jsp"%>