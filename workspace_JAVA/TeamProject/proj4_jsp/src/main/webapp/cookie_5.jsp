<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.popup{
		border : 1px solid black;
		width : 200px;
		height: 300px;
	}
	.hide{
			display: none;
		}
</style>
<script type="text/javascript">
	window.addEventListener('load', ()=>{
		
		showPopup()
		
		
		document.querySelector('#noShow')
			.addEventListener('click',function(event){
				
				// 쿠키 먹이는 법(세션쿠키, 만료일 없음)
				document.cookie = 'a=a1'
				console.log(document.cookie)
				
				const isCheck = event.target.checked;
				if(isCheck){
					// 10초 뒤 시간 가져오기 
					const now = new Date() //현재 시간
					const s10 = now.getSeconds() + 10 
					now.setSeconds(s10) //초 단위 재설정
					
					document.cookie = 'noShow=true;expires='+now.toGMTString()
				}
		})
	})
	
	function showPopup(){
		
		console.log(document.cookie)
		//a=a1; noShow=true 이런식으로 나옴
		const cookies = document.cookie.split('; ')
		
		for(let i =0; i<cookies.length; i++){
			
			const cookie = cookies[i].split('=');
			const name = cookie[0]
			const value = cookie[1]
			
			if(name == 'noShow' && value == 'true'){
				document.querySelector('.popup').classList.add('hide');
			}
			
		}
		
	}
	

</script>
</head>
<body>
	
	<div class="popup">
	
	공지입니다. 꼭 보세요 <br> <br>
	
	<input type="checkbox" id="noShow"> 10초 동안 보지 않기
	
	
	
	</div>
	
	
	
	
	
	
	
	
</body>
</html>