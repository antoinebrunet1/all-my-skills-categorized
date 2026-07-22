const { test, expect } = require('@playwright/test');
const {checkIfIsAbove, checkIFLocatorHasText} = require("./util");
const testData = JSON.parse(JSON.stringify(require('../test_data.json')))

test.beforeEach(async ({ page }) => {
    await page.goto(testData.url);
});

test('Header has correct text', async function ({ page }) {
    const h1Locator = await page.locator('h1')
    const h2Locator = await page.locator('h2')
    const pLocator = await page.locator('p')
    const liLocator = await page.locator('//ul/li')

    await checkIFLocatorHasText(h1Locator, testData.expectedText.h1)
    await checkIFLocatorHasText(h2Locator, testData.expectedText.h2)
    await checkIFLocatorHasText(pLocator, testData.expectedText.p)
    await checkIFLocatorHasText(liLocator.first(), testData.expectedText.ul[0])
    await checkIFLocatorHasText(liLocator.nth(1), testData.expectedText.ul[1])
    await checkIFLocatorHasText(liLocator.nth(2), testData.expectedText.ul[2])
});

test('Header sections are in correct order', async function ({ page }) {
    const h1Locator = await page.locator('h1')
    const h2Locator = await page.locator('h2')
    const pLocator = await page.locator('p')
    const ulLocator = await page.locator('ul').first()

    await checkIfIsAbove(h1Locator, h2Locator)
    await checkIfIsAbove(h2Locator, pLocator)
    await checkIfIsAbove(pLocator, ulLocator)
});
