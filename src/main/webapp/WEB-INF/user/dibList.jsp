<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="kr">
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

<title>Search Result</title>
<style>
.totalresult {
	padding-top: 20px;
}
.resultbox {
	margin: auto;
	padding: 10px;
	box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.25);
	border: solid 1px #efefef;
	border-radius: 0.7em;
	background-color: #efefef;
	width: 500px;
}
.list {
	font-weight: bold;
	font-size: 12px;
	color: #6f263d;
}
.btn_wish {
	float: right;
	color: white;
	box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.25);
	border: solid 1px #6f263d;
	border-radius: 0.7em;
	background-color: #6f263d;
	padding-top: 0px;
	font-weight: bold;
}
.btn_wish:active {
	font-weight: bold;
	border: 1px solid #6f263d;
	background-color: #fff;
	color: #6f263d;
	transition-duration: 1s;
}
.card-border {
	color: #6f263d;
	box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.25);
	border: solid 1px #f1f1f1;
	border-radius: 1em;
	background-color: #fff;
	margin: auto;
	margin-bottom: 20px;
	padding: 3px;
}
.btn_delete {
	font-size: 14px;
	font-weight: bold;
	border: none;
	color: #6f263d;
	float: right;
	background-color: #fff;
}
.card-title {
	font-size: 16px;
	font-weight: bold;
}
.list-cnt {
	color: #6f263d;
	font-size: 18px;
	margin-bottom: 10px;
	font-weight: bold;
	text-align: center;
}
.text-danger {
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>

	<div class="totalresult">
	
		<div class="resultbox">
			<p class="list-cnt">💕 찜 리스트 💕</p>
		
			<!-- <div class="list-cnt">총 10건</div> -->
			<c:if test="${searchFailed}">
				<h6 class="text-danger">
					⛔ 찜한 강의가 없습니다.💧 ⛔
				</h6>
			</c:if>			
				
			<c:forEach var="dib" items="${dibList}">
				<div class="card-border card" style="width: 30rem;">
					<div class="card-body">
						<span class="card-title"> ${dib.title}
						<form action="<c:url value='/user/mypage/deleteDib'/>">
							<button class="btn_delete" name="lecID" type="submit" value="${dib.lecID}">X</button>
						</form>
						</span><br> ${dib.professor}
						<p></p> 
						${dib.lecID} ${dib.cNo}분반 <br>${dib.week}[${dib.lecTime}] ${dib.loc}
						<form action="<c:url value='/user/mypage/othersDib'/>">
							<button class="btn_wish" name="lecID" type="submit" value="${dib.lecID}">추천받기</button>
						</form>
						<!-- button에는 간단힌 추천받기 라고 쓰고 추천기능이 어떤건지 설명하는 html 있으면 좋을듯 -->
					</div>
				</div>
			</c:forEach>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>

	</div>
</body>
</html>

