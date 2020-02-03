const bodyParser = require('body-parser')
const express = require('express')
const company = require('./company')
const BASE_URL = 'https://theinternship.io/'

const app = express()

app.use(bodyParser.urlencoded({ extended: false }))

app.get('/',(req,res)=>{
 return res.send('<div style="text-align: center;margin-top:5rem;"><h1><a href="/companies">Go to api</a></h1></div>')
})

app.get('/companies', async(req,res,next)=>{
 const sortedArr = await company.getData()
 const companiesObj = {
  companies:[]
 }
 sortedArr.forEach(company=>{
  companiesObj.companies.push(BASE_URL+company.logo)
 })
 return res.json(companiesObj);
})

app.listen(3000, () => {
    console.log(
      'Server is up on http://localhost:3000'
    )
})

module.exports = app
