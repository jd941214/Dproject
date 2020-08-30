<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="team.Dproject.main.model.*"%>
<%@page import="java.util.*"%>
<%@ include file="../top.jsp"%>
<script type="text/javascript">
	function show(inum,rooms){
		for(var i=2;i<=rooms;i++){
			num=inum+"-"+i;
			if(document.getElementById(num).style.display==''){
				document.getElementById(num).style.display='none';
			}else{
				document.getElementById(num).style.display='';
			}
		}
	}
</script>
<%
List<roomDTO> list = (List) request.getAttribute("list");
%>
<div align="center">
	<table width="100%" border="1">
		<tr align="right">
			<td colspan="7"><a href="room_insert.do?hnum=<%=request.getParameter("hnum")%>">추가</a></td>
		</tr>
		<tr>
			<td>방번호</td>
			<!-- 멤버넘 -->
			<!-- 호텔넘 -->
			<td>방이름</td>
			<td>방 평수</td>
			<td>인원수</td>
			<td>상세설명 (구비물품)</td>
			<td>이미지</td>
			<td>수정/삭제</td>
		</tr>
		
		<c:if test="${empty list}">
			<tr>
				<td colspan="7">등록된 방이 없습니다.</td>
			</tr>
		</c:if>
		<%
		if(list!=null){
			String num="";
			for(roomDTO dto : list){
				String temp=dto.getRoom_no();
				String[] arrtemp=temp.split("-");
				if(num.equals(arrtemp[0])||num==arrtemp[0]){
					%>
					<TR id="<%=dto.getRoom_no() %>" style="display:none">
					<td>└<%=dto.getRoom_no() %></td>
					<%
				}else{
					%>
					<TR>
					<td><%=dto.getRoom_no() %><input type="button" onclick="javascript:show(<%=arrtemp[0]%>,<%=dto.getRooms() %>);" value="보기"></td>
					<%
				}
				%>
						<td><a href="room_show.do?no=<%=dto.getRoom_no()%>"><%=dto.getName() %></a></td>
						<td><%=dto.getRoomsize() %></td>
						<td><%=dto.getSleeps()%></td>
						<td><%=dto.getItem() %></td>
						<%
							String img=dto.getFilename(); 
							if(img!=null){
								String[] SPimg=img.split("/");
								%><td><%
								for(int i=0;i<SPimg.length;i++){
									%>
									<img src="${pageContext.request.contextPath}/resources/img/<%=SPimg[i] %>" width="80" height="40">
									<% 
								}
								%></td><%
							}else{
								%><td>이미지 없음</td><%
							}
						if(num.equals(arrtemp[0])||num==arrtemp[0]){%>
						<td><a href="room_update.do?no=<%=dto.getRoom_no()%>">수정</a> | 
						<a href="room_delete.do?no=<%=dto.getRoom_no()%>">삭제</a></td>
						<%}else{ %>
						<td><a href="room_update.do?no=<%=dto.getRoom_no()%>">수정</a> | 
						<a href="room_alldelete.do?no=<%=arrtemp[0]%>">전체삭제</a></td>
						<%} %>
					</TR>
				<%
				num=arrtemp[0];
			}
		}
		%>		
	</table>
</div>
<%@ include file="../bottom.jsp"%>
