<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
<%@page import="java.util.*"%>
<%@page import="team.Dproject.main.model.*"%>
<%
List<MemberDTO> mlist=(List)request.getAttribute("mlist");

bus_loadDTO bdto=(bus_loadDTO)request.getAttribute("dto");
%>
	<div align="center">
		<form action="ADbus_resv_insert.do" method="post">
			<table align="center">
				<tr>
					<td>회원 번호 : 
					<select name="member_no">
					<%for(MemberDTO dto : mlist){%>
						<option value="<%=dto.getMember_no()%>"><%=dto.getMember_no()%> . <%=dto.getName() %></option>
					<%}%>
					</select>
					</td>
				</tr>
				<tr>
					<td>버스번호 : <%=bdto.getBus_no() %><input type="hidden" name="bus_no" value="<%=bdto.getBus_no() %>"></td>
				</tr>
				<tr>
					<td>노선번호 : <%=bdto.getRoad_no()%> : <%=bdto.getArrival() %>--><%=bdto.getDeparture() %>
					<input type="hidden" name="road_no" value="<%=bdto.getRoad_no()%>"></td>
				</tr>
				<tr>
					<td>자리번호 : <input type="text" name="seat" value="${bus.seat}"></td>
				</tr>
				<tr>
					<td>사용한 포인트 : <input type="text" name="use_point" value="${bus.use_point}"></td>
				</tr>
				<tr>
					<td>적립 : <input type="text" name="save_point" value="${bus.save_point}"></td>
				</tr>
				<tr>
					<td>날짜 : <input type="text" name="resv_date" value="${bus.resv_date}"></td>
				</tr>
				<tr><td><input type="submit" value="입력"></td></tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp"%>