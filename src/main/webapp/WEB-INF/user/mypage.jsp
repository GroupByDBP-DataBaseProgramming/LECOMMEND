<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>My Page</title>
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

	<%
	HttpSession loginSession = request.getSession();
	System.out.println(loginSession.getAttribute("userId"));

	%>
	<!--로그인이 안 됐으면-->
	<c:if test="${userId eq null}">
		<%response.sendRedirect("login/form"); %>
	</c:if>
	
	<!--  로그인이 됐으면-->
	<c:if test="${userId ne null}">
	<%
		String id = (String)loginSession.getAttribute("userId");
		if(id.equals("admin")) {
	%>
	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../nav.jsp"></jsp:include>
	<form name="deleteForm" method="POST" action="<c:url value='/lecture/delete'/>">		
		<div class="lectureList">
			<p class="list-cnt">📦 강의 리스트 📦</p>
	
			<c:forEach var="lec" items="${lecList}">
				<div class="card-border card" style="width: 30rem;">
					<div class="card-body">
						
						<span class="card-title"> ${lec.title}
						</span><br> ${lec.professor}
						<p></p>
						${lec.lecID} <br>${lec.week}[${lec.lecTime}]
						${lec.loc}
						<button class="btn_delete" type="submit">지우기</button>
					</div>
				</div>
			</c:forEach>
		</div>
		</form>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
		
	<%
		}
		else{ 
	%>
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../nav.jsp"></jsp:include>
	
		<div class="structure">
			<div class="info"><jsp:include page="userInfo.jsp"></jsp:include></div>
			<div class="dList"><jsp:include page="dibList.jsp"></jsp:include></div>
		</div>
	<%
	}
	%>
	</c:if>
	

</body>
</html>