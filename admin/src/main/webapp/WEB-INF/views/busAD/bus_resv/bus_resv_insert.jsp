<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
	<div align="center">
		<form action="bus_resv_insert.do" method="post">
			<table width="100%">
				<tr>
					<td>예약한 사람 : <input type="text" name="member_no"></td>
				</tr>
				<tr>
					<td>버스 : <input type="text" name="bus_no"></td>
				</tr>
				<tr>
					<td>버스노선 : <input type="text" name="road_no"></td>
				</tr>
				<tr>
					<td>좌석번호 : <input type="text" name="seat"></td>
				</tr>
				<tr>
					<td>사용한 포인트 : <input type="text" name="use_point"></td>
				</tr>
				<tr>
					<td>적립 포인트 : <input type="text" name="save_point"></td>
				</tr>
				<tr>
					<td>날짜 : <input type="text" name="resv_date"></td>
				</tr>
				<tr><td><input type="submit" value="추가"></td></tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp"%>