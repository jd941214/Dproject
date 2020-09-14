<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function openWindowPop(url, name){
    var options = 'top=10, left=10, width=600, height=700, status=no, menubar=no, toolbar=no, resizable=no';
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
	<a href="javascript:openWindowPop('hotel_resvroomcontent?hotel_no=${hotel_no}&grade=${1}', 'popup');">디럭스</a>
	</div>
	<div align="center">
	<a href="javascript:openWindowPop('hotel_resvroomcontent?hotel_no=${hotel_no}&grade=${2}', 'popup');">스탠다드</a>
	</div>
	<div align="center">
	<a href="javascript:openWindowPop('hotel_resvroomcontent?hotel_no=${hotel_no}&grade=${3}', 'popup');">패밀리</a>
	</div>
</body>
</html>