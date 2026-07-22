const {expect} = require("@playwright/test");

export async function checkIfIsAbove(locator1, locator2) {
    const locator1BoundingBox = await locator1.boundingBox()
    const locator2BoundingBox = await locator2.boundingBox()
    const locator1BottomY = locator1BoundingBox.y + locator1BoundingBox.height
    const locator2Y = locator2BoundingBox.y

    expect(locator1BottomY).toBeLessThan(locator2Y)
}

export async function checkIFLocatorHasText(locator, text) {
    await expect(locator).toHaveText(text)
}