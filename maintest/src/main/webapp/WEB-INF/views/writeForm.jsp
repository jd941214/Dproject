<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light scolled sleep scrolled awake" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="index">DProject</a>
      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"><a href="index" class="nav-link-1">Home</a></li>
          <li class="nav-item"><a href="about" class="nav-link-1">Bus</a></li>
          <li class="nav-item"><a href="hotel" class="nav-link-1">Hotels</a></li>
          <li class="nav-item"><a href="restaurant" class="nav-link-1">Restaurant</a></li>
          <li class="nav-item active"><a href="board_list.do" class="nav-link-1">Forum</a></li>
         </ul>
      </div>
      
      <div class="header-btns" id="ftco-nav">
      	<ul class="navbar-nav">
      	<li class="nav-item cta"><a href="contact" class="nav-link"><span>Login</span></a>
      		<ul class="submenu">
      			<li><a href="blog.html" class="submenu-1-first" style="color:black">My Page</a></li>
      			<li><a href="blog_details.html" class="submenu-1-second" style="color:black">Wish List</a></li>
                <li><a href="blog_details.html" class="submenu-1-third" style="color:black">Sign Up</a></li>
      		</ul>
      	</li>
      	</ul>
      </div>
      </div> 
  </nav>
 
  
<!-- END nav -->


<div align="center" width="80%">
	<form name="f" action="board_write.do" method="post" onsubmit="return check()">
		<fieldset align="center" style="margin-top:100px;">
			<legend>새로운 게시글 작성</legend>
			<label>TITLE</label>
			<input type="text" name="title" class="box">
			<br>
			<label>지역 선택</label>
			<select name="location_no">
				<option value="0">서울</option>
				<option value="1">경기</option>
				<option value="2">대전</option>
				<option value="3">대구</option>
				<option value="4">부산</option>
				<option value="5">울산</option>
				<option value="6">강원</option>
				<option value="7">인천</option>
			</select>
			<br>
			<label>CONTENT</label>
			<textarea name="content" rows="12" cols="60" class="box"></textarea>
			<br>
			<label>FILE</label>
			<input type="file" name="filename" class="box">
			<br>
			<input type="reset" value="CANCEL">
			<input type="submit" value="SUMBIT">
		</fieldset>
	</form>
</div>
    
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