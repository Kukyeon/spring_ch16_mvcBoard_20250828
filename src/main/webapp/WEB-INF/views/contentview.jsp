<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용e</title>
</head>
<body>
	<h2>글 내용</h2>
	 <hr>
	 글제목 : ${bDto.btitle } <br> <br>
	 글내용 : ${bDto.bcontent} <br> <br>
	 글작성자 : ${bDto.bname } <br> <br>
	 조회수 : ${bDto.bhit } <br> <br>
	 작성일 : ${bDto.bdate } <br> <br>
	 <hr>
	 <input type="button" value="글목록" onclick="javacript:window.location.href='boardlist'">
</body>
</html>