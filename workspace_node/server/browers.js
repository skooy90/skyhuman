const {chromium} = require('playwright')

test()
async function test(){
    const broswer= await chromium.launch({
        headless: false
    })

    const ctx = await broswer.newContext()
    const page = await ctx.newPage()
    await page.goto("https://naver.com")

    await page.waitForSelector("#query")
    await page.fill('#query', '천안 맞집')
    await page.click('#search-btn')
}