<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 쓰기 	</title>
</head>
<body>
	<h2>게시판 글 쓰기</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0">
		<form action="write">
			<tr>
				<th>이 름</th>
				<td><input type="text" name="bname" size="60"></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><input type="text" name="btitle" size="60"></td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><textarea rows="10" cols="50" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글작성">
					<input type="button" value="글목록" onclick="#">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>