<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
체크 인 : ${start_resv_date}<br>
체크 아웃 : ${end_resv_date}<br>
${member_no}<br>
${hotel_no}<br>
포인트 사용 후 총 금액 : ${total}<br>
<c:forEach var="d" items="${droom_no}">
${d}호<br>
</c:forEach>
<c:forEach var="s" items="${sroom_no}">
${s}<br>
</c:forEach>
<c:forEach var="f" items="${froom_no}">
${f}<br>
</c:forEach>
사용 보인트 ${use_point}<br>
결제 후 얻는 포인트${save_point}<br>
현재 남은 포인트${user_point}<br>
결제 내역
</body>
</html>