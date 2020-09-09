<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>
<div style="padding-top:50px;" align="center">
	<form name="f" action="board_write.do" method="post" onsubmit="return check()">
		<fieldset align="center">
			<legend>새로운 게시글 작성</legend>
			<label>TITLE</label>
			<input type="text" name="title" class="box">
			<br>
			<label>지역 선택</label>
			<select name="location_no">
				<option value="0">서울</option>
				<option value="1">대구</option>
				<option value="2">경기</option>
			</select>
			<br>
			<label>CONTENT</label>
			<textarea name="content" rows="12" cols="60" class="box"></textarea>
			<br>
			<label>FILE</label>
			<input type="file" name="filename" class="box">
			<br>
			<input type="reset" value="CANCEL">
			<input type="submit" value="SUMBIT">
		</fieldset>
	</form>
</div>
<%@ include file="bottom.jsp"%>