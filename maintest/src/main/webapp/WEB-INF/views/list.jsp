<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%@include file="head.jsp"%>

<style>
.writeBoardBtn {
	border-radius: 2px;
	border: none;
}

.writeBoardForm {
	margin-top: 20px;
}

.writeBoardIn {
	padding: 16px 24px 24px;
}

.writeBtn {
	display: block; border-radius : 13px;
	border: 2px solid #c94dff;
	background-color: #fff;
	color: #000;
	width: 60%;
	cursor: pointer;
	border-radius: 13px; border : 2px solid #c94dff; background-color :
	#fff; color : #000; width : 60%; cursor : pointer;
	transition: all 0.8s;
}

.writeBtn:hover {
	box-shadow: 0 50px 0 0 #c94dff inset, 0 -50px 0 0 #c94dff inset;
	border-color: #fff;
	font-weight: 600;
	border: 2px solid #fff;
	color: #fff;
}

.revContainer{
	width:60%;
	margin:20px auto;
}

.content{
	border-top:1px solid #e0e0e0;
}
	
.is-2{
	width:25%;
	float:left;
	margin-right:10px;
	margin-top:10px;
}

.is-9{
	width:70%;
	float:left;
	padding:8px 0;
	margin-top:10px;
}

.memberInfo{
	margin:0 auto;
}
.memberImg{
	padding:10px 10px;
}
.memberImg img{
	width:70px;
	height:70px;
	border-radius:70px;
}
.memberId{
	margin:0 auto;
	width:50;
	text-align:center;
}

.memberImgWrapper{
	margin:0 auto;
	padding:0;
	width:100px;
	text-align:center;
}
</style>

<body>
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index">DProject</a>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="index" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="about" class="nav-link">Bus</a></li>
					<li class="nav-item"><a href="hotel" class="nav-link">Hotels</a></li>
					<li class="nav-item"><a href="restaurant" class="nav-link">Restaurant</a></li>
					<li class="nav-item active"><a href="board_list.do"
						class="nav-link">Forum</a></li>
				</ul>
			</div>

			<div class="header-btns" id="ftco-nav">
				<ul class="navbar-nav">
					<li class="nav-item cta"><a href="contact" class="nav-link"><span>Login</span></a>
						<ul class="submenu">
							<li><a href="blog.html" class="submenu-1-first">My Page</a></li>
							<li><a href="blog_details.html" class="submenu-1-second">Wish
									List</a></li>
							<li><a href="blog_details.html" class="submenu-1-third">Sign
									Up</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->

	<div class="hero-wrap js-fullheight"
		style="background-image: url('${pageContext.request.contextPath}/resources/images/bgi_3.jpg'); height:70%;">
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-center justify-content-center"
				data-scrollax-parent="true">
				<div class="col-md-9-1 ftco-animate text-center"
					data-scrollax=" properties: { translateY: '70%' }">
					<p class="breadcrumbs"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"
						style="margin-top: 170px">
						<span class="mr-2"><a href="index">Home</a></span> <span>Forum</span>
					</p>
					<h1 class="mb-3 bread"
						data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Forum</h1>
				</div>
			</div>
		</div>
	</div>

	<!-- 리뷰작성 버튼 -->

	<div class="writeBoardBtn">
		<div class="writeBoardForm">
			<div class="writeBoardIn">
				<a href="board_write.do">
					<div align="center">
						<button class="writeBtn">Write Board</button>
					</div>
				</a>
			</div>
		</div>
	</div>

	<!-- BoardList Start -->
	<c:forEach var="dto" items="${listBoard}">
	<div class="revContainer">
	<div style="height:20%;border-top:1px solid #e0e0e0;width:90%;margin:0 auto;">
		<div class="is-2">
			<div class="memberInfo">
				<div class="memberImgWrapper">
					<div class="memberImg">
						<a><img src="${pageContext.request.contextPath}/resources/images/bg_5.jpg"></a>
					</div>
				</div>
				<div class="memberId">
					<div>${dto.member_no}</div>
				</div>
			</div>
		</div>
		
		<div class="is-9">
			<span>${dto.reg_date}</span>
			<div class="revTitle">
				<span><a href="board_content.do?main_board_no=${dto.main_board_no}">${dto.title}</a></span>
			</div>
			<div class="revContent">
				<div>
					<p>${dto.content}</p>
					<span class="taLnk ulBlueLinks" onclick="widgetEvCall('handlers.clickExpand',event,this);">More</span>
				</div>
			</div>
		</div>
		
	</div>
	</div>
	</c:forEach>
	
<%@ include file="footer.jsp"%>
<!-- loader -->
  <div id="ftco-loader" class="show fullscreen">
  <svg class="circular" width="48px" height="48px">
  <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
  <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#c94dff"/>
  </svg>
  </div>

  <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.stellar.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/aos.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.animateNumber.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/jquery.timepicker.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="${pageContext.request.contextPath}/resources/js/google-map.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/main2.js"></script>		
	
</body>
</html>