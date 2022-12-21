<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>

<style>
.structure {
	margin: 50px;
	width: 100%;
}

.info {
	float: left;
	width:20%;
}

.dList {
	float: left;
	width:60%;
}


</style>


</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div class="structure">

		<div class="info"><jsp:include page="userInfo.jsp"></jsp:include></div>
		<!-- controller를 이용하고, controller에서 dibList.jsp를 리턴한다. -->
		<div class="dList"><jsp:include page="<c:url value='/user/mypage/dibList'/>"></jsp:include></div>
	</div>



</body>
</html>