<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>룸 소개</title>
</head>
<body>
<div align="center">
	<b>룸 보기</b><br><br>
	<table border="1">
		<tr height="30">
			<th width="20%" bgcolor="yellow">호텔번호</th>
			<td align="center" width="30%">${getRoom.hotel_no}</td>
			<th width="20%" bgcolor="yellow">룸 번호</th>
			<td align="center" width="30%">${getRoom.room_no}</td>
		</tr>
		<tr height="30">
			<th width="20%" bgcolor="yellow">룸 이름</th>
			<td align="center" width="30%">${getRoom.name}</td>
			<th width="20%" bgcolor="yellow">룸 가격</th>
			<td align="center" width="30%">${getRoom.price}</td>
		</tr>
		<tr height="30">
			<th width="20%" bgcolor="yellow">객실 크기</th>
			<td align="center" width="30%">${getRoom.roomsize}m²</td>
			<th width="20%" bgcolor="yellow">정원</th>
			<td align="center" width="30%">${getRoom.sleeps}명</td>
		</tr>
		<tr height="80">
			<th width="20%" bgcolor="yellow">룸 설명</th>
			<td colspan="3" >${getRoom.item}</td>
		</tr>
		<tr>
			<th width="20%" bgcolor="yellow">룸 사진</th>
			<td colspan="3"><img src="c:/hotelimg/${getRoom.filename}"></td>
		</tr>
		<tr bgcolor="yellow">
			<td colspan="4" align="right">
				<a href="roomlist?hotel_no=${getRoom.hotel_no}"><input type="button" value="글목록"></a>
			</td>
		</tr>
	</table>
</div>

</body>
</html>