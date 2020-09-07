<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
<script>
	function check(){
		if (f.seat.value == "") {
            alert("좌석수를 입력하지 않았습니다.")
            f.seat.focus();
            return;
        }
		
		document.f.submit()
	}
</script>
	<div align="center">
		<form name="f" action="ADbus_update.do" method="post">
		<input type="hidden" name="bus_no" value="${bus.bus_no }">
			<table width="100%">
				<tr>
					<td>버스등급 : <input type="text" name="grade" value="${bus.grade}"></td>
				</tr>
				<tr>
					<td>버스좌석수 : <input type="text" name="seat" value="${bus.seat}"></td>
				</tr>
				<tr><td><input type="button" value="수정" onclick="javascript:check()">
			</table>
		</form>
	</div>

<%@ include file="../bottom.jsp" %> 