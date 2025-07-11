window.addEventListener('load',bind)

function bind(){
    let checkbox = document.querySelector('.board_ch');
    console.log(checkbox)
    let gasi = document.querySelector('.board_gasi')
    document.querySelector('.top_bu')
    .addEventListener('click',() => {
        let intext = document.querySelector('.top_in').value
        gasi.innerHTML += intext.value +'<br>'        


    })
    
}

