<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	아 자 아자 
	
	<button type="button" id="btn">ajax 실행</button>
	
	<script>
	
		document.querySelector("#btn").addEventListener("click",function(){
			console.log("click")
			
			let data ={
				id:'avcd'
			}
			console.log(data)
			console.log(''+data)
			console.log(JSON.stringify(data))
			
			const xhr = new XMLHttpRequest()
			
// 			xhr.open('post', 'ajax1')
			xhr.open('post', 'ajax5')
			xhr.setRequestHeader('Content-Type','application/json')
			xhr.send(JSON.stringify(data))		
			
			xhr.onload = function(){
				console.log(xhr.responseText)
			}
			
		})		
	</script>
	
</body>
</html>