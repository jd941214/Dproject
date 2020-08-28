<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script>
  $.datepicker.setDefaults({
    dateFormat: 'yy년 mm월 dd일',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
  });

  $(function() {
    $("#arr_date, #dep_date,#one_date").datepicker();
  });
	
  

</script>


<%@ include file="../top.jsp"%>
<div align="center">
	<form action="bus_resv_user_dispatch.do">
	<div style="border:1px solid gray; width:50%; float:left;">
		
		<table	border="1">
			<tr align="left">
				<td colspan="4" width="400">
					<input type="radio" name="mode" value="oneway" checked>☞편도
				</td>
			</tr>
			<tr align="left">
				<td colspan="2">
					
					<a href="bus_resv_user_arrival.do">
						출발지
					</a>
				</td>
				<td colspan="2">
					
					<a href="bus_resv_user_departure.do">
						도착지
					</a>
				</td>
			</tr>
			<tr>
			
				<td colspan="2"><c:if test="${not empty arr_dto.station_name}"><input type="hidden" name="arrival" value="${arrnoDTO.station_no}">${arr_dto.station_name}</c:if></td>
				<td colspan="2"><c:if test="${not empty dep_dto.station_name}"><input type="hidden" name="departure" value="${depnoDTO.station_no}">${dep_dto.station_name}</c:if></td>
			</tr>
			<tr>
				<td colspan="4" width="50%">편도날짜:<input type="text" id="one_date" name="one_date"></td>
			</tr>
			<tr align="left">
				<td>등급</td>
				<td><input type="radio" name="grade" value="전체" >전체</td>
				<td><input type="radio" name="grade" value="우등">우등</td>
				<td><input type="radio" name="grade" value="일반">일반</td>
			</tr>
		</table>
	</div>
	<div style="border:1px solid gray; width:50%; float:left;">
			<table	border="1">
			<tr align="left">
				<td colspan="4" width="400">
					<input type="radio" name="mode" value="twoway">☞☜왕복
				</td>
			</tr>
			<tr>
				<td colspan="2" width="50%">가는날</td>
				<td colspan="2" width="50%">오는날</td>
			</tr>
			<tr>
				<td colspan="2" width="50%"><input type="text" id="arr_date" name="arr_date"></td>
				<td colspan="2" width="50%"><input type="text" id="dep_date" name="dep_date"></td>
			</tr>
			<tr align="right">
				<td colspan="4">
					<input type="submit" value="조회 하기" >
				</td>
			</tr>
		</table>
		
	</div>
</form>
</div>


<%@ include file="../bottom.jsp"%>