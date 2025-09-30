const express = require('express')

const app = express()
const appRoot = require('app-root-path').path
const session = require('express-session')
const bodyParser = require('body-parser')

const port = 3000;

app.listen(port, ()=>{
    console.log("서버켜짐", port);
})

app.set('views', appRoot+'/ui/views')
app.set('view engine', 'ejs')

//파라메터로 json 해석
app.use(bodyParser.urlencoded({extended:false}))
app.use(bodyParser.json())


app.use(playwright.)
app.use( express.static ( appRoot+'/ui/public') )
app.use( session({
    secret: 'qwe123', // 세션 내용이 바뀌지 않으면 저장 안함
    resave : false, // 로그인 안한 사용자의 세선 저장 안함
    saveUninitialized : true, // 활동이 있으면 갱신
    cookie : { maxAge : 30*60*1000 } //30분 후 로그인 풀림

}))

app.use(aop);


app.get('/hello',(req, resp)=>{
    console.log("hello express")
    
})

app.get('/echo', (req, resp)=>{
    //get 방식일떄 파라미터 
    const id = req.query.id
    console.log('id : ' , id)
    resp.send(id)
})

app.get('/json', (req, resp)=>{
    const j = {
        a : 1,
        b : "eng",
        c : "한굴"

    }
    resp.send(j)
})


app.get('/ejs',(req, resp)=>{
    resp.render('hello', {title: '타이틀'})
})

app.get('/login',(req, resp)=>{
    const pw = req.query.pw
    if(pw == '1234'){
        req.session.user = {
            login : true
        }
        resp.send("로그인 성공")
    }
})
app.get('/main', (req, resp)=>{
    if(req.session.user && req.session.user.login){
        resp.send('회원전용 페이지를 보고 계십니다.')
    } else{
        resp.send("로그인 필요")
    }
})
app.get('/delay',async (req, resp)=>{
    await delay(2000)
    resp.send("2초 지남")
})


app.post('/ajax',function(req, resp){
    console.log(req.body.name)
    console.log(req.body.addr)

    resp.send(req.body)
})






function aop(req, resp, next){
    const before = new Date().getTime()

    resp.on('finish', function(){ //응답이 끝낫을때 

        const after = new Date().getTime()
        console.log (after - before);
    })
    next()
}


function delay(ms){
    return new Promise(function(resolve, reject){
        setTimeout(function(){
            resolve()
        }, ms)
    })
}