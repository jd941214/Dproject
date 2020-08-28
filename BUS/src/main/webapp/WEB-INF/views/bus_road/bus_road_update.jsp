<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="bus_road_update.do" method="post">
		<input type="hidden" name="road_no" value="${bus_road_getBoard.road_no}">
		<input type="hidden" name="member_no" value="${bus_road_getBoard.member_no}">
		
			<table width="50%" border="1">
				<tr>
					<td>버스번호:
						<select name="bus_no">
							<option value="${bus_road_getBoard.bus_no}" selected>${bus_road_getBoard.bus_no}</option>
						<c:forEach var="dto" items="${bus_list}">
							<c:if test="${bus_road_getBoard.bus_no != dto.bus_no}">
								<option value="${dto.bus_no}">${dto.bus_no}</option>
							</c:if>
					    </c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>출발지 : 
						<select name="arrival">
							<option value="${bus_road_getBoard.arrival}" selected>${bus_road_getBoard.arrival}</option>
							<c:forEach var="dto" items="${bus_station_list}">
								<c:if test ="${bus_road_getBoard.arrival != dto.station_no}">
									<option value="${dto.station_name}">${dto.station_name}</option>
								</c:if>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>도착지 : 
					<select name="departure">
						<option value="${bus_road_getBoard.departure}" selected>${bus_road_getBoard.departure}</option>
					<c:forEach var="dto" items="${bus_station_list}">
						<c:if test="${bus_road_getBoard.departure != dto.station_no}">
							<option value="${dto.station_name}">${dto.station_name}</option>
						</c:if>
					</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>가격 : <input type="text" name="price" value="${bus_road_getBoard.price}"></td>
				</tr>
				<tr>
					<td>출발시간 : <input type="text" name="arr_time" value="${bus_road_getBoard.arr_time}"></td>
				</tr>
				<tr>
					<td>소요시간 : <input type="text" name="tot_time" value="${bus_road_getBoard.tot_time}"></td>
				</tr>
				<tr align="right"><td><input type="submit" value="수정"></td></tr>
			</table>
		</form>
	</div>

<%@ include file="../bottom.jsp" %> 