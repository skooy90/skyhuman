<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File UPload</title>
</head>
<body>
	<h1>File Up</h1>
	<h3>파일하나</h3>
	<form action="upload" method="post" enctype="multipart/form-data" accept-charset="utf-8"> 
		
		제목 : <input type="text" name="title"><br>
		내용 : <input type="text" name="content"><br>
		파일첨부 : <input type="file" name="file1"><br>
		<input type="submit" value="등록">
		
	</form>
	
	<hr>
	<h3>파일 여러개</h3>
	<form action="uploads" method="post" enctype="multipart/form-data" accept-charset="utf-8"> 
		
		제목 : <input type="text" name="title"><br>
		내용 : <input type="text" name="content"><br>
		파일첨부 : <input type="file" name="file1" multiple="multiple"><br>
		<input type="submit" value="등록">
		
	</form>
	
	
</body>
</html>