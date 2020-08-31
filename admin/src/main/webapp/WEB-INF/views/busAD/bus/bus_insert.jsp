<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="ADbus_insert.do" method="post">
			<table width="100%">
				<tr>
					<td>버스등급 : 
						<select name="grade">
							<option value="일반">일반</option>
							<option value="우등">우등</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>버스좌석수 : <input type="text" name="seat"></td>
				</tr>
				<tr><td><input type="submit" value="추가"></td></tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp"%>