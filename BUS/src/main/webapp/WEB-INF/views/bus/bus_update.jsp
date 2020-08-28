  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="bus_update.do" method="post">
		<input type="hidden" name="bus_no" value="${bus.bus_no }">
			<table width="50%" border="1">
				<tr>
					<td>버스번호 : <input type="text" name="bus_no" value="${bus.bus_no}" readonly></td>
				</tr>
				<tr>
					<td>버스등급 : <input type="text" name="grade" value="${bus.grade}"></td>
				</tr>
				<tr>
					<td>버스좌석수 : <input type="text" name="seat" value="${bus.seat}"></td>
				</tr>
				<tr align="right"><td><input type="submit" value="수정"></td></tr>
			</table>
		</form>
	</div>

<%@ include file="../bottom.jsp" %> 