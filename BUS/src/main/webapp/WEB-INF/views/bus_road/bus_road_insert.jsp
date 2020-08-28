
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="bus_road_insert.do" method="post">
			<table width="50%" border="1">
				<tr>
					<td>버스번호:
						<select name="bus_no">
						<c:forEach var="dto" items="${bus_list}">
							<option value="${dto.bus_no}">${dto.bus_no}</option>
					    </c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>출발지 : 
						<select name="arrival">
						<c:forEach var="dto" items="${bus_station_list}">
							<option value="${dto.station_name}">${dto.station_name}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>도착지 : 
						<select name="departure">
						<c:forEach var="dto" items="${bus_station_list}">
							<option value="${dto.station_name}">${dto.station_name}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>가격 : <input type="text" name="price" ></td>
				</tr>
				<tr>
					<td>출발시간 : <input type="text" name="arr_time" ></td>
				</tr>
				<tr>
					<td>소요시간 : <input type="text" name="tot_time"></td>
				</tr>
				<tr align="right"><td><input type="submit" value="추가"></td></tr>
			</table>
		</form>
	</div>

<%@ include file="../bottom.jsp" %> 