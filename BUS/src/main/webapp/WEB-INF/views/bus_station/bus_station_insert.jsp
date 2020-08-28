  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="bus_station_insert.do" method="post" enctype="multipart/form-data">
			<table width="50%" border="1">
				<tr>
					<td>터미널번호 : <input type="text" name="station_no"></td>
				</tr>
				<tr>
					<td>터미널이름 : <input type="text" name="station_name"></td>
				</tr>
				<tr>
					<td>터미널주소 : <input type="text" name="address"></td>
				</tr>
				<tr>
					<td>파일명: <input type="file" name="filename"></td>
				</tr>
				<tr align="right"><td><input type="submit" value="추가"></td></tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp"%>