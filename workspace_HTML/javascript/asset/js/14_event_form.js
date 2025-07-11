window.addEventListener('load', bind);
function bind() {
    document.querySelector('#keyword')
        .addEventListener('focus', () => {
            const keyword = document.querySelector('#keyword');
            keyword.style.backgroundColor = 'yellow';

        })
    // 포커스가 빠지면서 생기는 이벤트
    document.querySelector('#keyword')
        .addEventListener('blur', () => {
            const keyword = document.querySelector('#keyword');
            keyword.style.backgroundColor = '';

        })
    document.querySelector('#keyword')
        .addEventListener('input', () => {
            const keyword = document.querySelector('#keyword');
            const r = parseInt(Math.random() * 256)
            const g = parseInt(Math.random() * 256)
            const b = parseInt(Math.random() * 256)
            const a = Math.random()
            keyword.style.backgroundColor = `rgba(${r},${g},${b},${a})`;
            keyword.style.fontSize='30px'
        })
    document.querySelector('#site')
        .addEventListener('change', () => {
            const value = document.querySelector('#site').value
            console.log('change 이벤트의 value', value)
            const form = document.querySelector('#form')
            if (value == 1) {
                //naver
                form.setAttribute('action', "https://search.naver.com/search.naver")
            } else if (value == 2)
                form.setAttribute('action', "https://www.google.com/search")
            //google

        })
    document.querySelector('#form')
        .addEventListener('submit', (evt) => {
            // html 테그의 기본(고유) 기능을 막아줌
            // 여기서는 submit 기능을 막음
            evt.preventDefault();

            const value = document.querySelector('#keyword').value
            if (value.length < 2) {
                alert('검색어는 두 글자 이상입니다.')
            } else {
                // submit 기능 살림
                document.querySelector('#form').submit();
            }

        })
    addEventListener('copy', (evf) => {
        evf.preventDefault();
        alert('복사 금지');
    })

    addEventListener('selectstart', (evf) => {
        evf.preventDefault();
    })


    //문제 시작
    const chk = document.querySelectorAll('.chk')

    // 1번문제
    document.querySelector('#chbu')
        .addEventListener('click', () => {
            const vl = document.querySelector('.ckva')
            vl.innerHTML = '토핑 : '
            for (let i = 0; i < chk.length; i++) {

                if (chk[i].checked) {
                    vl.innerHTML += chk[i].value
                }
            }
        })

        // 2-1번 문제
    let chk_all = document.querySelector('.chk_all');
    chk_all.addEventListener('change', () => {
    if(chk_all.checked == true){
            for (let i = 0; i < chk.length; i++) {
                chk[i].checked = true;
            }
        }else{
                for (let i = 0; i < chk.length; i++) {
                    chk[i].checked = false;
                }
        }
    })
    
    //2-2 문제
    chk.forEach(e => {
        //배열을 전체 이벤트 돌리기 위해 배열을 각각의 e에 넣어 반복된다 
        e.addEventListener('change',()=>{
            let all_checked =true;
            for(let i = 0; i < chk.length; i++){
                if(chk[i].checked == false){
                    // 내가 선택 해제 되었다면
                    all_checked = false;
                }
            }
            chk_all.checked = all_checked;
        })
    })

    
    
    //콜백을 화살표 함수로 하면 this는 여전히 window로 유지됨
    document.querySelector('#parent')
    .addEventListener('click',function(evt){
        console.log('부모 클릭')
        // event.target : 이벤트가 발생한 DOM
        console.log('event.target : ', evt.target)
        // event.currentTarget : 이벤트가 적용된 DOM (addE...이 있는곳)
        console.log('event.currentTarget : ', evt.currentTarget)
        // 이벤트 안에서 this는 더 이상 윈도우가 아님
        // js에서 this는 뭔지 알고 있을 때만 사용하세요.
        console.log(this)
        console.log(this === evt.currentTarget)

        // 부모로 이동.
        console.log('event.target.parentNode : ', evt.target.parentNode)

    },true)
    document.querySelector('#c1')
    .addEventListener('click',function(){

        //자식을 눌럿을때 부모꺼까지 온게 '전파'라고 한다.
        // evt.preventDefault 기본값을 막는거
        // evt.stopPropagation(); // 전파방지
        // 부모로 전달되는 이벤트 중지
        
        console.log('자식 클릭')
    })

    //this : window 객체를 가지고 있다
    console.log('밖',this)
    
}