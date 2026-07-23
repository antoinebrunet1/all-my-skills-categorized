const { test, expect } = require('@playwright/test');
const {testData} = require("../testData");

test.beforeEach(async ({ page }) => {
    await page.goto(testData.url);
});

test('Titles are in alphabetical order', async function ({ page }) {
    const titlesLocators = await page.locator(testData.selectors.h3).all()

    titlesLocators.shift()

    const titlesTexts = []

    for (const titleLocator of titlesLocators) {
        const titleText = await titleLocator.innerText()
        titlesTexts.push(titleText)
    }

    const sortedTitlesTexts = titlesTexts.sort()

    expect(JSON.stringify(titlesTexts) === JSON.stringify(sortedTitlesTexts)).toBeTruthy()
})