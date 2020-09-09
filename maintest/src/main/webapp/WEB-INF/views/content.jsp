<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp"%>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.0/css/all.min.css"/>
</head>

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
      			<li><a href="blog.html" class="submenu-1-first" style="color:white">My Page</a></li>
      			<li><a href="blog_details.html" class="submenu-1-second" style="color:white">Wish List</a></li>
                <li><a href="blog_details.html" class="submenu-1-third" style="color:white">Sign Up</a></li>
      		</ul>
      	</li>
      	</ul>
      </div>
      </div>
  </nav>
<div align="center">
	<form name="f" method="post">
		<fieldset style="width:600;">
			<div>
				<span><img src="${pageContext.request.contextPath}/resources/images/usericon.png" width="30" height="30"></span>
				<span>
					글쓴이 ID
				</span>
			</div>
			<div>
				<textarea rows="5" cols="60" readOnly>${getBoard.content}</textarea>
			</div>
			<div>
				<span><i class="fas fa-chevron-left" style="font-size:1.5em;"></i></span>
				<span><i class="fas fa-bars" style="font-size:1.5em;"></i></span>
				<span><i class="fas fa-chevron-right" style="font-size:1.5em;"></i></span>
			</div>
		</fieldset>
	</form>
</div>
</body>
<%@ include file="footer.jsp"%>