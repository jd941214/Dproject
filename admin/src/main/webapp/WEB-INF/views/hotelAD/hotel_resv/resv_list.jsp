<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="team.Dproject.main.model.*"%>
<%
	Calendar cal = Calendar.getInstance();
	String strYear = (String) request.getParameter("year");
	String strMonth = (String) request.getParameter("month");
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);
	if (strMonth != null) {
		month = Integer.parseInt(strMonth);
	}

	cal.set(year, month, 1);
	int startDay = cal.getMinimum(java.util.Calendar.DATE);
	int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
	int newLine = 0;

	Calendar todayCal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");

	int cnt = 0;
	int cnt2=0;
	int day=0;
	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
	
	List<roomDTO> roomlist = (List) request.getAttribute("roomlist");
%> 


<%@ include file="../top.jsp"%>
<DIV width="80%" height="40">
	<table width="100%" height="40">
		<tr>
			<td height="60">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="10"></td>
					</tr>
					<tr>
						<td align="center">
							<%
								if (month > 0) {
							%> <a
							href="resv_list.do?hnum=<%=request.getAttribute("hnum")%>&amp;?year=<%=year%>&amp;month=<%=month - 1%>">
								이전달 </a> <%
							 	} else {
							 %> <%
							 	}
							 %> &nbsp;&nbsp; <%=year%>년 <%=month + 1%>월 &nbsp;&nbsp;<%
							 	if (month < 11) {
							 %> <a
							href="resv_list.do?hnum=<%=request.getAttribute("hnum")%>&?year=<%=year%>&amp;month=<%=month + 1%>"
							target="_self"> 다음달 </a> <%
							 	} else {
							 %> <%
							 	}
							 %>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<br>

	<table border="1" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF"
		align="center">
		<THEAD>
			<TR bgcolor="#CECECE">
				<TD width='100px'>
					<DIV align="center">
						<font color="red">일</font>
					</DIV>
				</TD>
				<TD width='100px'>
					<DIV align="center">월</DIV>
				</TD>
				<TD width='100px'>
					<DIV align="center">화</DIV>
				</TD>
				<TD width='100px'>
					<DIV align="center">수</DIV>
				</TD>
				<TD width='100px'>
					<DIV align="center">목</DIV>
				</TD>
				<TD width='100px'>
					<DIV align="center">금</DIV>
				</TD>
				<TD width='100px'>
					<DIV align="center">
						<font color="#529dbc">토</font>
					</DIV>
				</TD>
			</TR>
		</THEAD>

		<TBODY>
			<TR height="1">
				<%
					boolean fir = true;
					//처음 빈공란 표시
					for (int index = 1; index < start; index++) {
						out.println("<TD >&nbsp;</TD>");
						newLine++;
					}
					for (int index = 1; index <= endDay; index++) {
						String color = "";
						if (newLine == 0) {
							color = "RED";
						} else if (newLine == 6) {
							color = "#529dbc";
						} else {
							color = "BLACK";
						}
						;

						
						String backColor = "#EFEFEF";

						out.println("<TD valign='top' align='left' height='1px' bgcolor='" + backColor + "' nowrap>");
						cnt++;
						cnt2++;
				%>
				<font color='<%=color%>'> <%=index%>
				</font>
				<%
					out.println("<BR>");
						out.println("</TD>");
						newLine++;
						if (newLine == 7 || endDay == index) {
							newLine = 0;

							out.println("</TR>");
							if (index <= endDay) {
								out.println("<TR>");
							}
						}
						if (newLine == 0 || endDay == index) {
							newLine = 0;
							//내용 쓰자
							boolean check = false;
							for (roomDTO roomDTO : roomlist) {
								int l = index ;
								if (fir) {
									for (int a = 1; a < start; a++) {
										out.println("<TD >&nbsp;</TD>");
										newLine++;
									}
								}
								int end = index;
								if (end == endDay) {
									if (cnt != 7) {
										end = end - (7 - cnt);
										newLine = 0;
									}
								}
								for (int i = l; i < end+7; i++) {
									day=(i-cnt2)+1;
									String sUseDate = Integer.toString(year) + "";

									sUseDate += Integer.toString(month + 1).length() == 1 ? "0" + Integer.toString(month + 1) + ""
											: Integer.toString(month + 1) + "";

									sUseDate += Integer.toString(day).length() == 1 ? "0" + Integer.toString(day) + ""
											: Integer.toString(day) + "";
									int temp=0;
									List<resvDTO> resvlist = (List) request.getAttribute("resvlist");
									for (resvDTO resvDTO : resvlist) {										
										temp=Integer.parseInt(resvDTO.getEnd_resv_date());
										if (resvDTO.getStart_resv_date().equals(sUseDate)
												&& resvDTO.getRoom_no() == roomDTO.getRoom_no()) {
											check = true;
											break;
										}
										check = false;

									}
										if (check) {
										
										%>
											<TD height="30" align="center" bgcolor="#ffb4a3"><font size="1" color="#b52100" style="padding: 1px; magin: 1px; font-weight: bold "><%=roomDTO.getName()%>&lt;완&gt;</font></TD>
										<%
											newLine++;
											
										} else {
										%>
											<TD height="30" align="center" bgcolor="#a3aeff"><a style="text-decoration: none"> <font size="1"
												color="#020c57" style="padding: 1px; magin: 1px; font-weight: bold "><%=roomDTO.getName()%>&lt;미&gt;</font></a></TD>
						
										
										<%
											newLine++;
									}
									if (end == endDay)
										continue;

									if (newLine == 7) {
										newLine = 0;
										cnt = 0;
										break;
									}

								}
				%>
			</tr>
			<%
				}cnt2=0;
						
						fir = false;
					}
				}
			%>
			</TR>
		</TBODY>
	</TABLE>
</DIV>

<%@ include file="../bottom.jsp"%>
