  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>


	<div align="center">
		<form action="bus_insert.do" method="post">
			<table width="50%" border="1">

				<tr>
					<td>버스등급 : <input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>버스좌석수 : <input type="text" name="seat"></td>
				</tr>
				<tr align="right"><td><input type="submit" value="추가" onclick = "javascript:check()"></td></tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp"%>