<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="ADbus_station_update.do" method="post">
		<input type="hidden" name="station_no" value="${station.station_no}">
			<table width="100%">
				<tr>
					<td>터미널이름 : <input type="text" name="station_name" value="${station.station_name}"></td>
				</tr>
				<tr>
					<td>터미널주소 : <input type="text" name="address" value="${station.address}"></td>
				</tr>
				<tr><td><input type="submit" value="수정"></td></tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp" %> 