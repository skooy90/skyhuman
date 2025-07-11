window.addEventListener('load', bind);
function bind() {
    let boad = document.querySelector('#board')
    document.querySelector('#submit_1')
        .addEventListener('click', function () {

            boad.innerHTML += '<br>' + document.querySelector('#text_1').value

        })

    //문제2
    document.querySelector('#moonsame_2')
        .addEventListener('click', () => {
            if (document.querySelector('#moonsame_2').checked) {
                document.querySelector('#name_2').value = document.querySelector('#name_1').value
                document.querySelector('#juso_2').value = document.querySelector('#juso_1').value
                document.querySelector('#phonnum_2').value = document.querySelector('#phonnum_1').value
            } else {
                document.querySelector('#name_2').value = ''
                document.querySelector('#juso_2').value = ''
                document.querySelector('#phonnum_2').value = ''
            }
        })
    //문제3

    let sel = document.querySelectorAll('#sel')
    sel.forEach(e => {
        e.addEventListener('click', () => {
            sel.forEach(el => el.removeAttribute('style'));
            e.style.fontWeight = 600;
            e.style.fontSize = '20px';
            e.style.color = 'aqua';
            e.style.textDecoration = 'underline';
        })
    })
    //이거 클릭하면 flex 이영 colum으로 해서 번호 주는 그걸로 순선 설정 해당그게 맞게 sort해서 나오는 순서를 다르게 뽑으면 될려나???
    //order

    let sjun = document.querySelectorAll('.sjun');
    let sspace = document.querySelectorAll('.sspace');
    let ssee = document.querySelectorAll('.ssee');


    document.querySelector('.rosel')
        .addEventListener('click', () => {
            for (let i = 0; i < sspace.length; i++) {
                sjun[i].style.order = i;
            }
            // 2중 for문으로 비교 및 순서 교체
            for (let i = 0; i < sspace.length; i++) {
                for (let j = i + 1; j < sspace.length; j++) {
                    
                    if (parseInt(sspace[i].textContent) > parseInt(sspace[j].textContent)) {
                        // style.order 값을 바꿔서 정렬 순서 변경
                        const temp = sjun[i].style.order;
                        sjun[i].style.order = sjun[j].style.order;
                        sjun[j].style.order = temp;
                    }
                }
            }
            console.log(sjun[0].style.order)
            console.log(sjun[0].textContent)
            console.log(sjun[1].style.order)
            console.log(sjun[1].textContent)
            console.log(sjun[2].style.order)
            console.log(sjun[2].textContent)
            
            
        })
        document.querySelector('.hisel')
        .addEventListener('click', () => {
            for (let i = 0; i < sspace.length; i++) {
                sjun[i].style.order = i;
            }
           
            let arrSspace =  Array.from(sspace)
            arrSspace.sort(a,b)
            // 2중 for문으로 비교 및 순서 교체
            for (let i = 0; i < sspace.length; i++) {
                for (let j = 1; j < sspace.length; j++) {

                    if (parseInt(sspace[i].textContent) < parseInt(sspace[j].textContent)) {
                        // style.order 값을 바꿔서 정렬 순서 변경

                        const temp = sjun[i].style.order;
                        sjun[i].style.order = sjun[j].style.order;
                        sjun[j].style.order = temp;
                    }
                }
            }

            
        })

    document.querySelector('.rocl')
        .addEventListener('click', () => {
            for (let i = 0; i < ssee.length; i++) {
                sjun[i].style.order = i;
            }

            // 2중 for문으로 비교 및 순서 교체
            for (let i = 0; i < ssee.length; i++) {
                for (let j = i + 1; j < ssee.length; j++) {

                    if (ssee[i].textContent > ssee[j].textContent) {
                        // style.order 값을 바꿔서 정렬 순서 변경
                        const temp = sjun[i].style.order;
                        sjun[i].style.order = sjun[j].style.order;
                        sjun[j].style.order = temp;
                    }
                }
            }


        })
    document.querySelector('.hicl')
        .addEventListener('click', () => {
            for (let i = 0; i < ssee.length; i++) {
                sjun[i].style.order = i;
            }

            // 2중 for문으로 비교 및 순서 교체
            for (let i = 0; i < ssee.length; i++) {
                for (let j = i + 1; j < ssee.length; j++) {

                    if (ssee[i].textContent < ssee[j].textContent) {
                        // style.order 값을 바꿔서 정렬 순서 변경
                        const temp = sjun[i].style.order;
                        sjun[i].style.order = sjun[j].style.order;
                        sjun[j].style.order = temp;
                    }
                }
            }

            //NODE.LIST를 ARR.LIST 배열을 바꿔서 SORT로 하면 숫자로 구별된다 
        })


}