<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
		<body>
<!-- 		주소 노출 및 검색되지 않게 WEB-INF 폴더 안에 생성
			http://127.0.0.1:8888/WEB-INF/member/register.jsp 경로로 진입 시도 시 접속 불가
			http://127.0.0.1/member/join.do -->
			<h1>회원가입</h1>
			<h3>회원정보를 입력하세요</h3>
			<form action="/member/join.kh" method="post"> <!-- fiedset 안에 있어도 됨 -->
			<fieldset>
				<legend>회원가입</legend>
					아이디 : <input type="text" name="member-id"><br>
					비밀번호 : <input type="password" name="memberPw"> <br>
					이름 : <input type="text" name="member-name"> <br>
					성별 : 남 <input type="radio" name="gender" value="남"> 여 <input type="radio" name="gender" value="여"> <br>
					나이 : <input type="number" name="age"> <br>
					이메일 : <input type="text" name="email"> <br>
					전화번호 : <input type="text" name="phone"> <br>
					주소 : <input type="text" name="address"> <br>
					취미 : <input type="text" name="hobby"> <br>
					<input type="submit" value="회원가입">
			</fieldset>
			</form>
		</body>
</html>