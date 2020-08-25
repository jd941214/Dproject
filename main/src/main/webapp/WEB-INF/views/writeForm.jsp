<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
	<form name="f" action="board_write.do" method="post">
		<dl>
			<dt>
				새로운 게시글 작성
			</dt>
		</dl>
		<dl>
			<dd>
				<label>SUBJECT</label>
				<input type="text" name="title">
			</dd>
			<dd>
				<label>CONTENT</label>
				<textarea name="content" cols="50" rows="8"></textarea>
			</dd>
		</dl>
		
	</form>
</div>