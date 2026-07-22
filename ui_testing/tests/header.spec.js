const { test, expect } = require('@playwright/test');
const {checkIfIsAbove, checkIfLocatorHasText} = require("./util");
const {testData} = require("../testData");

test.beforeEach(async ({ page }) => {
    await page.goto(testData.url);
});

test('Header has correct text', async function ({ page }) {
    const h1Locator = await page.locator(testData.selectors.h1)
    const h2Locator = await page.locator(testData.selectors.h2)
    const pLocator = await page.locator(testData.selectors.p)
    const liLocator = await page.locator(testData.selectors.li)

    await checkIfLocatorHasText(h1Locator, testData.expectedText.h1)
    await checkIfLocatorHasText(h2Locator, testData.expectedText.h2)
    await checkIfLocatorHasText(pLocator, testData.expectedText.p)
    await checkIfLocatorHasText(liLocator.first(), testData.expectedText.ul[0])
    await checkIfLocatorHasText(liLocator.nth(1), testData.expectedText.ul[1])
    await checkIfLocatorHasText(liLocator.nth(2), testData.expectedText.ul[2])
});

test('Header sections are in correct order', async function ({ page }) {
    const h1Locator = await page.locator(testData.selectors.h1)
    const h2Locator = await page.locator(testData.selectors.h2)
    const pLocator = await page.locator(testData.selectors.p)
    const ulLocator = await page.locator(testData.selectors.ul).first()

    await checkIfIsAbove(h1Locator, h2Locator)
    await checkIfIsAbove(h2Locator, pLocator)
    await checkIfIsAbove(pLocator, ulLocator)
});
