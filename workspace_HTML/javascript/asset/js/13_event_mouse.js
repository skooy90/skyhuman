let wiew;
let isDown = false;
let mouseX = 0;
let mouseY = 0;
window.onload = function () {
    view = document.querySelector('#view');
    // 이미지가 처음에 안보이게 하기 위해서
    const cursor = document.querySelector('#cursor');
    cursor.style.top = '-1000px';
    cursor.style.left = '-1000px';
    const drag = document.querySelector('#drag');
    drag.style.top = '100px';
    drag.style.left = '100px';
    bind()
}

function bind() {
    view.innerHTML = '안녕?<br>'
    document.querySelector('#mouse')
        .addEventListener('mousedown', function (evt) {
            view.innerHTML = 'mousedown 발생 <br>' + view.innerHTML
            console.log(evt)
            //offset : DOM의 좌상단 기준
            //page : 스크롤에 관계 없이 문서 좌상단 기준
            //client : 지금 눈에 보이는 화면의 좌상단 기준
            view.innerHTML = `
        event.offsetX : ${evt.offsetX} 
        event.offsetY : ${evt.offsetY} <br>
        event.pageX : ${evt.pageX} event.pageY : ${evt.pageY} <br>
        event.clientX : ${evt.clientX} event.clientY : ${evt.clientY} <br>
        event.screenX : ${evt.screenX} 
        event.screenY : ${evt.screenY} <br>
        
        ${view.innerHTML}

    `
        })
    document.querySelector('#mouse')
        .addEventListener('mouseup', function () {
            view.innerHTML = 'mouseup 발생 <br>' + view.innerHTML
        })
    document.querySelector('#mouse')
        .addEventListener('mousemove', function () {
            // view.innerHTML = 'mousemove 발생 <br>' + view.innerHTML
            // 확인하고 너무 많이 나와 주석처림함
        })
    //마우스 들어옴 over & enter도 가능
    document.querySelector('#mouse')
        .addEventListener('mouseover', function () {
            view.innerHTML = 'mouseover 발생 <br>' + view.innerHTML
            document.querySelector('#mouse').style.backgroundColor = 'red'
        })
    //마우스가 나갈때 발생 out 또는 leave
    document.querySelector('#mouse')
        .addEventListener('mouseout', function () {
            view.innerHTML = 'mouseout 발생 <br>' + view.innerHTML
            document.querySelector('#mouse').style.backgroundColor = 'white'
        })

    document.querySelector('body')
        .addEventListener('mousemove', function (evt) {
            const cursor = document.getElementById('cursor')
            cursor.style.top = evt.pageY + 3 + 'px';
            cursor.style.left = evt.pageX + 3 + 'px';
        })

    document.querySelector('#drag')
        .addEventListener('mousedown', function (evt) {
            isDown = true;
            mouseX = evt.pageX
            mouseY = evt.pageY
        })
    document.querySelector('#drag')
        .addEventListener('mouseup', function (evt) {
            isDown = false;
        })
    document.querySelector('#drag')
        .addEventListener('mousemove', function (evt) {
            if (isDown) {
                console.log(isDown)
                // mouseX = evt.clientX - mouseX
                const drag = document.getElementById('drag')
                drag.style.top = (parseInt(drag.style.top) + (evt.pageY - mouseY)) + 'px';
                drag.style.left =(parseInt(drag.style.left) + (evt.pageX - mouseX)) + 'px';
                mouseX = evt.pageX
                mouseY = evt.pageY
            }
        })

}