<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약 내용 확인</title>
</head>
<body>
<div align="center">${sedto.name}님의 예약 내용</div>
<div align="center">
<form action="hotel_resvpayment">
<input type="hidden" name="start_resv_date" value="${start_resv_date}"/>
<input type="hidden" name="end_resv_date" value="${end_resv_date}"/>
<!-- 디럭스 선택 후 결제로 넘기기 -->
<c:if test="${not empty drdto}">
<input type="hidden" name="d_roomsu" value="${d_roomsu}"/>
<input type="hidden" name="d_rn" value="${d_rn}"/>
<input type="hidden" name="d_pay" value="${drdto.price * stay * d_roomsu}"/>
</c:if>
<!-- 스탠다드 선택 후 결제로 넘기기 -->
<c:if test="${not empty srdto}">
<input type="hidden" name="s_roomsu" value="${s_roomsu}"/>
<input type="hidden" name="s_rn" value="${s_rn}"/>
<input type="hidden" name="s_pay" value="${srdto.price * stay * s_roomsu}"/>
</c:if>
<!-- 패밀리 선택 후 결제로 넘기기 -->
<c:if test="${not empty frdto}">
<input type="hidden" name="f_roomsu" value="${f_roomsu}"/>
<input type="hidden" name="f_rn" value="${f_rn}"/>
<input type="hidden" name="f_pay" value="${frdto.price * stay * f_roomsu}"/>
</c:if>
<c:if test="${not empty drdto}">
<table border="1">
<tr>
	<th>체크 인 : 15:00</th>
	<th>체크 아웃 : 12:00</th>
	<th>호텔</th>
	<th>룸 등급</th>
	<th>룸 호실</th>
	<th>가격</th>
</tr>
<tr>
	<td>${start_resv_date}</td>
	<td>${end_resv_date}</td>
	<td>${hotelname}</td>
	<td>디럭스</td>
	<td>
	<c:forEach var="ho" items="${d_rn}">
	${ho}호<br>
	</c:forEach>
	</td>
	<td>${drdto.price * stay * d_roomsu}</td>
</tr>
</table>
</c:if>
<c:if test="${not empty srdto}">
<table border="1">
<tr>
	<th>체크 인 : 15:00</th>
	<th>체크 아웃 : 12:00</th>
	<th>호텔</th>
	<th>룸 등급</th>
	<th>룸 호실</th>
	<th>가격</th>
</tr>
<tr>
	<td>${start_resv_date}</td>
	<td>${end_resv_date}</td>
	<td>${hotelname}</td>
	<td>스탠다드</td>
	<td>
	<c:forEach var="ho" items="${s_rn}">
	${ho}호<br>
	</c:forEach>
	</td>
	<td>${srdto.price * stay * s_roomsu}</td>
</tr>
</table>
</c:if>
<c:if test="${not empty frdto}">
<table border="1">
<tr>
	<th>체크 인 : 15:00</th>
	<th>체크 아웃 : 12:00</th>
	<th>호텔</th>
	<th>룸 등급</th>
	<th>룸 호실</th>
	<th>가격</th>
</tr>
<tr>
	<td>${start_resv_date}</td>
	<td>${end_resv_date}</td>
	<td>${hotelname}</td>
	<td>패밀리</td>
	<td>
	<c:forEach var="ho" items="${f_rn}">
	${ho}호<br>
	</c:forEach>
	</td>
	<td>${frdto.price * stay * f_roomsu}</td>
</tr>
</table>
</c:if>
<div align="center">
<input type="submit" value="결제">
</div>
</form>
</div>
</body>
</html>