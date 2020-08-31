<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- member_edit.jsp -->
<%@ include file="../top.jsp" %>
<link rel="stylesheet" type="text/css" href="style.css">
<form name="f" method="post" action="ADmember_edit_ok.do">
	<input type="hidden" name="member_no" value="${dto.member_no}"/>
	<table width="600" align="center" class="outline">
  		<tr>
			<td colspan="2" align=center class="m2">회원수정</td>
 		</tr>
		<tr>
			<td width="150" class="m3">이름</td>
			<td class="m3">
				<input type="text" name="name" class="box" value="${dto.name}" readOnly>
			</td>
		</tr>
		<tr>
			<td width="150" class="m3">아이디</td>
			<td class="m3">
				<input type="text" name="id" class="box"
												value="${dto.id}" readOnly>
			</td>
  		</tr>
  		<tr>
			<td width="150" class="m3">비밀번호</td>
			<td class="m3">
				<input type="password" name="passwd" class="box" value = "${dto.passwd}">
			</td>
  		</tr>
  		<tr>
			<td width="150" class="m3">주민번호</td>
			<td class="m3">
				<input type="text" name="ssn1" class="box" value="${dto.ssn1}" readOnly> -
				<input type="password" name="ssn2" class="box" value="${dto.ssn2}" readOnly>
			</td>
  		</tr>
  		<tr>
			<td width="150" class="m3">이메일</td>
			<td class="m3">
				<input type="text" name="email" class="box" value="${dto.email}">
			</td>
  		</tr>
  		<tr>
			<td width="150" class="m3">연락처</td>
			<td class="m3">
				<input type="text" name="hp1" class="box"
								size="4" maxlength="4" value="${dto.hp1}"> -
				<input type="text" name="hp2" class="box"
								size="4" maxlength="4" value="${dto.hp2}"> -
				<input type="text" name="hp3" class="box"
								size="4" maxlength="4" value="${dto.hp3}">
			</td>
  		</tr>
  		<tr>
  			<td>
  				<select name="position">
  					<option value="0">슈퍼관리자</option>
  					<option value="1">버스관리자</option>
  					<option value="2">호텔관리자</option>
  					<option value="3">일반회원</option>
  				</select>
  			</td>
  		</tr>
  		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정" >
				<input type = "button" value = "취소" onclick = "window.location='ADmember_list.do'">
			</td>
  		</tr>
  	</table>
</form>	
<%@ include file="../bottom.jsp" %>