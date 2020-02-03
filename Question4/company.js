const puppeteer = require('puppeteer')
const THE_INTERNSHIP_URL = 'https://theinternship.io/'

const company = {
  async getData() {
    const companyArr = []
    const browser = await puppeteer.launch({ headless: false })
    const page = await browser.newPage()
    await page.goto(THE_INTERNSHIP_URL)

    try {
      await page.goto(THE_INTERNSHIP_URL)
      await page.waitForSelector('.partner')

      const companyElementArr = await page.$$('.partner')
      for (const company of companyElementArr) {
        const companyObj = await {
          logo: await company.$eval('.logo-box a img', img =>
            img.getAttribute('src')
          ),
          text: await company.$eval(
            '.box-textbox .list-company',
            text => text.innerHTML
          )
        }
        // console.log(companyObj);
        companyArr.push(companyObj)
      }
      browser.close()
      companyArr.sort((a, b) => {
        if (a.text === b.text) {
          return 0
        }
        if (a.text < b.text) {
          return -1
        }
        return 1
      })

      companyArr.sort((a, b) => {
        return a.text.length - b.text.length
      })
      return companyArr
    } catch (err) {
      console.log(err)
    }
  },
  something() {
    console.log('some')
  }
}

module.exports = company
