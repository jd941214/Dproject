<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*"%>
<%@page import="team.Dproject.main.model.*"%>
<%@ include file="../top.jsp" %>
<%
List<busDTO> list=(List)request.getAttribute("bus_list");
List<bus_stationDTO> list2=(List)request.getAttribute("bus_station_list");
%>
	<div align="center">
		<form action="ADbus_load_insert.do" method="post">
			<table width="100%">
				<tr>
					<td>버스번호 : 
						<select name="bus_no">
						<%
							for(busDTO dto : list){
							%>
								<option value="<%=dto.getBus_no()%>"><%=dto.getBus_no() %></option>
							<%
							}
						%>
						</select>
					</td>
				</tr>
				<tr>
					<td>출발지 : 
						<select name="arrival">
						<%
							for(bus_stationDTO dto : list2){
							%>
								<option value="<%=dto.getStation_no()%>"><%=dto.getStation_name() %></option>
								
							<%
							}
						%>
						</select>
					</td>
				</tr>
				<tr>
					<td>도착지 : 
						<select name="departure">
						<%
							for(bus_stationDTO dto : list2){
							%>
								<option value="<%=dto.getStation_no()%>"><%=dto.getStation_name() %></option>
								
							<%
							}
						%>
						</select>
					</td>
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