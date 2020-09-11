<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function openWindowPop(url, name){
    var options = 'top=400, left=600, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no';
    window.open(url, name, options);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<div align="right">
		<c:choose>
			<c:when test="${empty sedto}">
				<input type="button" value="로그인"
					onClick="location.href='memberlogin'" />
			</c:when>
			<c:otherwise>
				<input type="button" value="로그아웃"
					onClick="location.href = 'memberlogout'" />
			</c:otherwise>
		</c:choose>
	</div>
	<div align="center">
	<a href="javascript:openWindowPop('hotel_resvroomcontent?hotel_no=${hotel_no}&room_no=${room_no}', 'popup');">디럭스</a>
	</div>
</body>
</html>