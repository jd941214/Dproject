<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 결제 api 스크립트  -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-x.y.z.js">
IMP.init('imp23515175');
IMP.request_pay({
    pg : 'kakaopay', // version 1.1.0부터 지원.
    pay_method : 'card',
    merchant_uid : 'merchant_' + new Date().getTime(),
    name : '주문명:결제테스트',
    amount : 14000, 
    buyer_email : 'iamport@siot.do',
    buyer_name : '구매자이름',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
    buyer_postcode : '123-456',
    //m_redirect_url : 'https://www.yourdomain.com/payments/complete'
}, function(rsp) {
    if ( rsp.success ) {
        var msg = '결제가 완료되었습니다.';
        msg += '고유ID : ' + rsp.imp_uid;
        msg += '상점 거래ID : ' + rsp.merchant_uid;
        msg += '결제 금액 : ' + rsp.paid_amount;
        msg += '카드 승인번호 : ' + rsp.apply_num;
    } else {
        var msg = '결제에 실패하였습니다.';
        msg += '에러내용 : ' + rsp.error_msg;
    }
    alert(msg);
});
</script>


<%@ include file="../top.jsp" %>
	<div>
		<form action="#">
			<table border="1">
				<tr align="center">
					<td colspan="4">${one_date}</td>
				</tr>
				<tr>
					<td colspan="2">출발지:${dto.arrival}</td>
					<td colspan="2">도착지:${dto.departure}</td>
				</tr>
				<tr>
					<td colspan="2">출발시간:${resv_dto.arr_time}</td>
					<td colspan="2">도착시간:${resv_dto.arr_time+resv_dto.tot_time}</td>
				</tr>
				<tr>
					<td colspan="3">1장 가격:${resv_dto.price}</td>
					<td>인원수:${seat_no}</td>
				</tr>
				<tr align="right">
					<td colspan="4">총가격:${resv_dto.price*seat_no}</td>
				</tr>
				<tr align="right">
					<td colspan="4"><input type="submit" value="결제"></td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="../bottom.jsp" %>
