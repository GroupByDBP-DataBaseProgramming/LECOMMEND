<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%


String[] deptList = { "인문대학", "사회과학대학", "자연정보과학대학", "약학대학", "예술대학", "디자인대학", "공연예술대학", "문화지식융합대학" };
request.setAttribute("deptList", deptList);

String[] deptList01 = { "국어국문학과", "국사학과", "문예창작과", "영어과", "일본어학과", "프랑스어과", "독일어학과", "중어중국학과", "유러피언스터디즈학과" };
request.setAttribute("deptList01", deptList01);

String[] deptList02 = { "경영학과", "경제학과", "국제경영학과", "문헌정보학과", "사회복지학과", "아동학과" };
request.setAttribute("deptList02", deptList02);

String[] deptList03 = { "식품영양학과", "보건관리학과", "화학화장품학부", "응용화학전공", "화장품학전공", 
		"컴퓨터학과", "정보통계학과", "체육학과" };
request.setAttribute("deptList03", deptList03);

String[] deptList05 = { "회화과", "디지털공예과", "큐레이터학과", "피아노과", "관현악과", "성악과" };
request.setAttribute("deptList05", deptList05);


%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
.input-form {
	max-width: 680px;
	margin-top: 5px;
	padding: 180px;
	padding-top: 5px;
}

.color-point {
	color: #6f263d;
	text-align: center;
	font-weight: bold;
	margin-top: 30px;
}

.btn-primary {
	background-color: #6f263d;
	border-color: #6f263d;
	text-align: center;
	width: 40%;
	margin-left: 20px;
}

.submitBtn:hover, .resetBtn:hover {
	background-color: #6f263d;
	border: solid 1px #6f263d;
	opacity: 0.8;
}
</style>
</head>

<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
<body>

	<!-- 회원 정보 수정하기 -->
	<div class="container">
		<div class="row">
			<h1 class="h2 mb-3 color-point">회원 정보 수정</h1>
			<div class="input-form col-md-12 mx-auto">

				<form name="updateForm" method="POST" action="#">
					<div class="form-group mb-3">
						<label for="userId">ID (학번)</label> <input type="text"
							class="form-control" name="userId" id="userId" placeholder=""
							disabled />

					</div>


					<div class="form-group mb-3">
						<label for="password">비밀번호</label> <input type="password"
							class="form-control" name="password" id="password" required>
						<font id="checkPw" size="2"></font>

					</div>

					<div class="form-group mb-3">
						<label for="password2">비밀번호 재확인</label> <input type="password"
							class="form-control" name="password2" id="password2" required>
						<font id="missMatchPw" size="2"></font>
					</div>

					<div class="form-group mb-3">
						<label for="major" class="form-label">학과</label> <select
							class="form-select" name="major" id="major" required>
							<option value="">선택하기</option>
							<option>컴퓨터학과</option>
							<option>정보통계학과</option>
							<option>화장품학과</option>
							<option>경제학과</option>
							<option>경영학과</option>
						</select>

					</div>
				
					<div class="form-group mb-3">
						<input value="수정" class="btn-block btn btn-primary submitBtn"
							type="button" onClick="passwordCheck()"> <input
							value="취소" class="btn-block btn btn-primary resetBtn"
							type="reset">
					</div>

				</form>
			</div>
		</div>
	</div>

	<script>

		function passwordCheck() {
			var pwExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$/;
			//최소 8자 및 최대 10자 & 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자
			if (pwExp.test(updateForm.password.value) == false) {
				document.getElementById("checkPw").innerHTML = "비밀번호 형식이 올바르지 않습니다.";
				document.getElementById("checkPw").style.color = "red";
				updateForm.password.focus();
				return false;
			} else {
				document.getElementById("checkPw").innerHTML = "";
				
			}
			
			if (updateForm.password.value != updateForm.password2.value) {
				
				document.getElementById("missMatchPw").innerHTML = "비밀번호가 일치하지 않습니다.";
				document.getElementById("missMatchPw").style.color = "red";
				updateForm.password2.focus();
				return false;
			} else {
				document.getElementById("missMatchPw").innerHTML = "";
				
			}

			updateForm.submit();
		}
	</script>

	<script src="/docs/5.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>

	<script src="form-validation.js"></script>
</body>
</html>