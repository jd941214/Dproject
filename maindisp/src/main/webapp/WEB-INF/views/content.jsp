<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.0/css/all.min.css"/>
</head>

<body>
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