<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="ADbus_load_insert.do" method="post">
			<table width="100%">
				<tr>
					<td>버스번호 : <input type="text" name="bus_no"></td>
				</tr>
				<tr>
					<td>출발지 : <input type="text" name="arrival" ></td>
				</tr>
				<tr>
					<td>도착지 : <input type="text" name="departure" ></td>
				</tr>
				<tr>
					<td>가격 : <input type="text" name="price" ></td>
				</tr>
				<tr>
					<td>출발시간 : <input type="text" name="arr_time" ></td>
				</tr>
				<tr>
					<td>도착시간 : <input type="text" name="tot_time"></td>
				</tr>
				<tr><td><input type="submit" value="수정"></td></tr>
			</table>
		</form>
	</div>

<%@ include file="../bottom.jsp" %> 