<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
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

<title>Search Result</title>
<style>
.totalresult {
	margin-top: 35px;
	margin-left: 80px;
	padding-top: 20px;
}

.resultbox {
	margin-left: 50px;
	padding: 10px;
	box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.25);
	border: solid 1px #efefef;
	border-radius: 0.7em;
	background-color: #efefef;
	width: 34.375rem;
	display: inline-block;
}

.keywordbox {
	margin: auto;
}

.hotbox {
	display: inline-block;
	float: right;
	margin-right: 160px;
	
}

.keywords {
	font-size: 12px;
	font-weight: bold;
	color: #6f263d;
	box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.25);
	border: solid 1px #f1f1f1;
	border-radius: 0.7em;
	background-color: #fff;
	margin-left: 20px;
	margin-bottom: 10px;
	padding: 3px;
	text-align: center;
	width: 18%;
	float: left;
	font-weight: bold;
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

button.btn_wish_active {
	font-weight: bold;
	border: 1px solid #6f263d;
	background-color: #fff;
	color: #6f263d;
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

.recommend-card {
	text-align: center;
	margin-bottom: 10px;
	
}

.list-cnt {
	color: #6f263d;
	font-size: 18px;
	margin-bottom: 10px;
	font-weight: bold;
	text-align: center;

}

.text-danger{
	text-align: center;
	font-weight: bold;
}


</style>
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:include page="../nav.jsp"></jsp:include>

	<div class="totalresult">
	
		<div class="resultbox">
			<p class="list-cnt">📦 검색 결과 📦</p>
			<div class="keywordbox">
				<c:forEach var="keyword" items="${keywordList}">
					<div class="keywords">${keyword}</div>
				</c:forEach>
			</div>
			
			<!-- <div class="list-cnt">총 10건</div> -->
			<c:if test="${searchFailed}">
				<h6 class="text-danger">
					⛔ Keyword를 선택하지 않으셨으므로, 전체 강의를 검색합니다. ⛔
				</h6>
			</c:if>
			
			<!--  검색 결과 -->
			<c:forEach var="lec" items="${lecList}">
				<div class="card-border card" style="width: 30rem;">
					<div class="card-body">
						<span class="card-title"> ${lec.title}
						</span><br> ${lec.professor}
						<p></p>
						${lec.lecID} <br>${lec.week}[${lec.lecTime}]
						${lec.loc}
						<form action="<c:url value='/lecture/searchResult/createDib'/>">
							<button class="btn_wish" id="btn_before" 
							name="lecID" type="submit" value="${lec.lecID}" onClick="changeBtn()" >♡ 찜하기</button>
						</form>
						<!--  <form action="<c:url value='/lecture/searchResult/deleteDib'/>">
							<button class="btn_wish" id="btn_after_wish" 
							name="lecID" type="submit" value="${lec.lecID}" onClick="changeBtn()" >♡ 찜해제</button>
						</form>-->
					</div>
				</div>
			</c:forEach>
		</div>

		<!--  인기 있는 강의 List -->
		<div class="hotbox">
			<p class="list-cnt">✨인기 있는 강의✨</p>
			<c:forEach var="hotLec" items="${hotLecList}">
				<div class="card-border card recommend-card" style="width: 15rem;">
					<div class="card-body">
						<h5 class="card-title">${hotLec.title}</h5>
						${hotLec.professor}
						<p></p>
						${hotLec.lecID} <br>${hotLec.week}[${hotLec.lecTime}]
						${hotLec.loc}
					</div>
				</div>
			</c:forEach>
		</div>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>

	</div>
</body>
<script>
	$("button").click(function() {
	    toggleClass(".btn_wish_active");
	});
	
	function changeBtn()  {
		  const btn1 = document.getElementById('btn_before');
		  
		  if(btn1.style.display !== 'none') {
			    btn1.style.display = 'none';
			}

		}
</script>
</html>

