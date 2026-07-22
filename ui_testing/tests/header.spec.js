const { test, expect } = require('@playwright/test');
const {checkIfIsAbove} = require("./util");
const testData = JSON.parse(JSON.stringify(require('../test_data.json')))

test.beforeEach(async ({ page }) => {
    await page.goto(testData.url);
});

test('Header has correct text', async function ({ page }) {
    const h1Locator = await page.locator('h1')
    const h2Locator = await page.locator('h2')
    const pLocator = await page.locator('p')
    const liLocator = await page.locator('//ul/li')

    await expect(h1Locator).toHaveText(testData.expectedText.h1)
    await expect(h2Locator).toHaveText(testData.expectedText.h2)
    await expect(pLocator).toHaveText(testData.expectedText.p)
    await expect(liLocator.first()).toHaveText(testData.expectedText.ul[0])
    await expect(liLocator.nth(1)).toHaveText(testData.expectedText.ul[1])
    await expect(liLocator.nth(2)).toHaveText(testData.expectedText.ul[2])
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
