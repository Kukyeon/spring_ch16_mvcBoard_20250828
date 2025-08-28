<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>게시판 목록</h2>
	<hr>
	<table border="1" cellspcing="0" cellpadding="0" width="800">
		<tr>
			<th>번호</th>
			<th width="400">제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		
		<c:forEach items="${bDtos }" var="bDto">
		<tr>
			<td>${bDto.bnum }</td>
			<td>			
			<a href="content_view?bnum=${bDto.bnum }">${bDto.btitle }</a>
			</td>
			<td>${bDto.bname }</td>
			<td>${bDto.bhit }</td>
			<td>${bDto.bdate }</td>
		</tr>
		</c:forEach>
		
	</table>
	<hr>
		<form action="write_form">
			<input type="submit" value="글쓰기">
		</form>
</body>
</html>