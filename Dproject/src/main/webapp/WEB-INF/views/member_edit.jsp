<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="myArray" value="${fn:split('총관리자,버스관리자,호텔관리자,사용자',',')}" />
<div align = "center">
	<form name = "f" action = "member_edit_ok.do" method = "post">
		<input type="hidden" name="member_no" value="${dto.member_no}">
		<table class = "outline" border = "1">
			<tr>
				<th align = "center">이름</th>
				<td colspan = "3">${dto.name}</td>
			</tr>
			<tr>
				<th align = "center">아이디</th>
				<td><input type = "text" name = "id" value = "${dto.id}" size = "10" readOnly></td>
				<th align = "center">비밀번호</th>
				<td><input type = "password" name = "passwd" value = "${dto.passwd}" size = "10"></td>
			</tr>
			<tr>
				<th align = "center">주민번호</th>
				<td colspan = "3">
					<input type = "text" name = "ssn1" value = "${dto.ssn1}" size = "10" readOnly> - 
					<input type = "password" name = "ssn2" value = "${dto.ssn2}" size = "10" readOnly>
				</td>
			</tr>
			<tr>
				<th align = "center">이메일</th>
				<td colspan = "3">
					<input type = "text" name = "email" value = "${dto.email}">
				</td>
			</tr>
			<tr>
				<th align = "center">전화번호</th>
				<td colspan = "3">
					<input type = "text" name = "hp1" size = "4" maxlength = "4" value = "${dto.hp1}"> -
					<input type = "text" name = "hp2" size = "4" maxlength = "4" value = "${dto.hp2}"> - 
					<input type = "text" name = "hp3" size = "4" maxlength = "4" value = "${dto.hp3}">
				</td>
			</tr>
			<tr>
				<th align = "center">포인트</th>
				<td colspan = "3"><input type = "text" name = "point" value = "${dto.point}" size = "5">점</td>
			</tr>
			<tr>
				<th align = "center">성별</th>
				<td>
					<label><input type = "radio" name = "sex" value = "0" checked>남자</label>
					<label><input type = "radio" name = "sex" value = "1">여자</label>
				</td>
			</tr>
			<tr>
				<th align = "center">회원 등급</th>
				<td>
					<select name = "position">
						<c:forEach var = "i" begin="0" end="3">
							<c:choose>
								<c:when test="${dto.position == i}">
									<option value = "${i}" selected = "selected">${myArray[i]}</option>
								</c:when>
								<c:otherwise>
									<option value = "${i}">${myArray[i]}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th align = "center">가입일</th>
				<td colspan = "3"><input type = "text" name = "joindate" value = "${dto.joindate}" size = "10" readOnly></td>
			</tr>
			<tr>
				<td colspan = "4" align = "center">
					<input type="submit" value="회원 수정">
					<input type = "button" value = "돌아가기" onClick = "history.back()">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp" %>