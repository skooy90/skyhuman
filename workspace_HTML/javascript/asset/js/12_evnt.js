console.log('hello js2')

// 첫번째 window.addEventListener('load', init );
// 두번째 window.onload = init;
// html파일 boby에 onload드로 불러오게 한다
window.addEventListener('load', init);
function init() {
    const c = document.querySelector('#console');
    console.log(c);
    const game = document.querySelector('#game')
    game.style.top = '10px';
    game.style.left = '10px';

    bind();
}
function bind() {
    const msg = document.querySelector('#console');
    const btn1 = document.querySelector('#btn1')
    // btn1.onclick=""
    // onclick은 변수라서 마지막 값만 저장된다
    btn1.onclick = function () {
        msg.innerHTML += '<br>버튼1 클릭'
    }
    btn1.onclick = function () {
        msg.innerHTML += '<br>버튼1! 클릭'
    }
    //addEventListener는 계속 동일 이벤트를 추가할 수 있다
    const btn2 = document.querySelector('#btn2')
    btn2.addEventListener('click', function () {
        msg.innerHTML += "<br>버튼 2 클릭"
    })
    btn2.addEventListener('click', function () {
        msg.innerHTML += "<br>버튼 2!! 클릭"
    })
    
    // 로그인 버튼을 눌렀을 때 
    // 아이디와 비밀번호가 비어있지 않다면 
    //      아이디 , 비밀번호 출력
    // 하나라도 안썻다면 
    //      아이디 또는 비밀번호는 필수 입니다.
    const btn4 = document.querySelector('#login')
    const id = document.querySelector('#id')
    const pw = document.querySelector('#pw')
    
    
    
    console.log(typeof (id.value));
    btn4.addEventListener('click', function () {
        if (id.value != '' && pw.value != '') {
            msg.innerHTML = `${id.value} <br>${pw.value}`;
        } else if (id.value == '' || pw.value == '') {
            msg.innerHTML = '아이디 입력 또는 비밀번호 입력';
        }
    })
    // document.querySelector('#id').addEventListener('keydown',function(){
        //     console.log('아다다다')
    // })
    document.querySelector('#id').addEventListener('keyup', function (event) {
        console.log('event : ', event);
        console.log('event.keyCode : ', event.keyCode);
        if (event.keyCode == 13) {
            console.log('엔터 빵!!!')
            document.querySelector('#pw').focus();
        }
    });
    document.querySelector('#pw').addEventListener('keyup', function (event) {
        if (event.keyCode == 13) {
            document.querySelector('#login').click();
        }
    })
    
    document.querySelector('body').addEventListener('keydown',function(event){
        console.log(event.keyCode)
        const game = document.querySelector('#game')
        console.log(game.style.top)
        if(event.keyCode == 37){
            game.style.left = parseInt(game.style.left) - 15 + 'px';
        }else if(event.keyCode == 39){
            game.style.left = parseInt(game.style.left) + 15 + 'px';
            
        }else if(event.keyCode == 38){
            game.style.top = parseInt(game.style.top) - 15 + 'px';
            
        }else if(event.keyCode == 40){
            game.style.top = parseInt(game.style.top) + 15 + 'px';
            
        }
    })
    
    document.querySelector('#pw').addEventListener('click', btnClick);
    document.querySelector('#pw').removeEventListener('click', btnClick);
    
    
}
window.addEventListener('resize', function () {
    console.log('resize')
    console.log(window.innerHeight)
})
function btnClick() {
    const msg = document.querySelector('#console');
    msg.innerHTML += '<br>btnClick 실행'
}

window.addEventListener('scroll', function () {
    console.log('scroll');
    console.log('scroll', document.documentElement.scrollTop)
    // document.documentElement.scrollTop = 140

    document.querySelector('#top').addEventListener('click', function () {
        // document.documentElement.scrollTop = 140
        // window.scrollTo(
        //     {
        //         top: 0,
        //         behavior: 'smooth'
        //     }
        // )
        //180일때 100
        //170일때 200
        for (i = document.documentElement.scrollTop; i >= 0; i -= 10) {
            let time = (200 - i) * 10;

            setTimeout(function () {
                console.log('i : ', i, 'time :', time)
                document.documentElement.scrollTop = i;
            }, time);
        }
        //160일때 300
    })
})

