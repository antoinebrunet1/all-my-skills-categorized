const { test } = require('@playwright/test');
const {testData} = require("../testData");
const {checkIfElementsAreInAlphabeticalOrder} = require("./util");

test.beforeEach(async ({ page }) => {
    await page.goto(testData.url);
});

test('Titles are in alphabetical order', async function ({ page }) {
    const titlesLocators = await page.locator(testData.selectors.h3).all()

    titlesLocators.shift()
    await checkIfElementsAreInAlphabeticalOrder(titlesLocators)
})

test('List items are in alphabetical order for every list', async function ({ page }) {
    const listsLocators = await page.locator(testData.selectors.ul).all()

    listsLocators.shift()

    for (const listLocator of listsLocators) {
        const liLocators = listLocator.locator(testData.selectors.li)

        await checkIfElementsAreInAlphabeticalOrder(liLocators)
    }
})