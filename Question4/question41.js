const company = require('./company')

company.getData().then(sortedArr=>{
 for (let i = 0; i < sortedArr.length; i++) {
  console.log(sortedArr[i].logo)
 }
})