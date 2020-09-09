<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<%@include file="head.jsp" %>

  <body>
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="index">DProject</a>
      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"><a href="index" class="nav-link">Home</a></li>
          <li class="nav-item"><a href="about" class="nav-link">Bus</a></li>
          <li class="nav-item"><a href="hotel" class="nav-link">Hotels</a></li>
          <li class="nav-item"><a href="restaurant" class="nav-link">Restaurant</a></li>
          <li class="nav-item active"><a href="board_list.do" class="nav-link">Forum</a></li>
         </ul>
      </div>
      
      <div class="header-btns" id="ftco-nav">
      	<ul class="navbar-nav">
      	<li class="nav-item cta"><a href="contact" class="nav-link"><span>Login</span></a>
      		<ul class="submenu">
      			<li><a href="blog.html" class="submenu-1-first">My Page</a></li>
      			<li><a href="blog_details.html" class="submenu-1-second">Wish List</a></li>
                <li><a href="blog_details.html" class="submenu-1-third">Sign Up</a></li>
      		</ul>
      	</li>
      	</ul>
      </div>
      </div>
  </nav>
    <!-- END nav -->

   <div class="hero-wrap js-fullheight" style="background-image: url('${pageContext.request.contextPath}/resources/images/bgi_3.jpg'); height:70%;">
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9-1 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">
            <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }" style="margin-top:170px"><span class="mr-2"><a href="index">Home</a></span> <span>Forum</span></p>
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }" >Forum</h1>
          </div>
        </div>
      </div>
    </div>

<section>

<div align="center" width="80%">
	<table bgcolor="white" width="80%" style="border-inline:1px solid #adadad">
		<tr align="right">
		<td colspan="5"><a href="board_write.do"><i class="fas fa-edit fa-2x"></i></a></td>
		<td>
			<select name="loaction_no">
				<option value="10">전체</option>
				<option value="0">서울</option>
				<option value="1">경기</option>
				<option value="2">대구</option>
			</select>
		</td>
		</tr>
		<tr bgcolor="#dbdbdb" align="center">
			<!-- 게시글 번호 -->
			<th >Nr.</th> 
			
			<!-- 작성자 -->
			<th>User</th>
			
			<!-- 제목 -->
			<th width="40%">Title</th> 
			
			<!-- 댓글 수 -->
			<th>Comments</th>
			
			<!-- 조회수 -->
			<th>View</th>
			
			<!-- 작성일 -->
			<th>Date</th>
		</tr>
		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="6">
					No Contents
				</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${listBoard}">
			<tr align="center">
				<td style="border-bottom:1px solid #ebebeb"><c:out value="${dto.main_board_no}"/></td>
				<td style="border-right:1px solid #ebebeb;border-left:1px solid #ebebeb;border-bottom:1px solid #ebebeb">${dto.member_no}</td>
				<td style="border-right:1px solid #ebebeb;border-left:1px solid #ebebeb;border-bottom:1px solid #ebebeb"><a href="board_content.do?main_board_no=${dto.main_board_no}">${dto.title}</a></td>
				<td style="border-right:1px solid #ebebeb;border-left:1px solid #ebebeb;border-bottom:1px solid #ebebeb"></td>
				<td style="border-right:1px solid #ebebeb;border-left:1px solid #ebebeb;border-bottom:1px solid #ebebeb">${dto.readcount}</td>
				<td style="border-bottom:1px solid #ebebeb">${dto.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</section>
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