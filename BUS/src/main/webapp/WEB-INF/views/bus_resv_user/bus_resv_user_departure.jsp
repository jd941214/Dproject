<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도착지</title>
</head>
<body>

	<div>
		<div align="center"style="width:100%; float:center;">
			<div align="center" style="width:100%; folat:center; background:#CEECF5";><h2>도착지선택</h2></div>
				<div align="left" style="border:1px solid blue; width:100%; folat:center;">
					<form action="resv_user_departure_find.do">
					<table border="1">
						<tr>
							<td>
								검색:<input type="text" name="searchString" size="111">
								<input type="submit" value="찾기">
							</td>
						</tr>
					</table>
					</form>
				</div><!-- 검색 -->
			<form action="bus_resv_user_departure.do" method="post">
				<div align="center" style="border:1px solid blue;width:50%;  background:#EFF5FB;">
					<table border="1">
						<tr>
							<td width="4000">도착지:
								<c:if test="${not empty dep_dto.station_name}">
									<input type="hidden" name="departure" value="${dep_dto.station_name}">${dep_dto.station_name}
									
								</c:if>
							</td>
							
						</tr>
					</table>
				</div><!-- 도착지 -->
		

				
				<div align="center" style="display: inline-block;border:1px solid blue;">
						<h3>출발지</h3>
					<table border="1">
						<c:if test="${not empty find_station}">
							<c:forEach var="list" items="${find_station}">
								<tr>
									<td><input type="button" onclick="javascript:location.href='bus_resv_user_departure_select.do?departure=${list.station_no}'" value="${list.station_name}"></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:forEach var="dto" items="${bus_station_list}">
						
						<tr>
							<td width="100">
							<input type="button" onclick="javascript:location.href='bus_resv_user_departure_select.do?departure=${dto.station_no}'"  value="${dto.station_name}" style="width:100%;">
							</td>
						</tr>
						</c:forEach>
					</table>
					<input type="submit" value="선택">
				</div><!-- 터미널 출발지 버튼 -->
				
				
			</form>
		</div>
	</div>
</body>
</html>
<%@ include file="../bottom.jsp"%>