package com.example.codetest

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import com.example.codetest.interactors.addToCartBtn
import com.example.codetest.interactors.backHomeBtn
import com.example.codetest.interactors.checkoutBtn
import com.example.codetest.interactors.continueBtn
import com.example.codetest.interactors.finishBtn
import com.example.codetest.interactors.homePageText
import com.example.codetest.interactors.loginBtn
import com.example.codetest.interactors.logoutBtn
import com.example.codetest.interactors.menuBtn
import com.example.codetest.interactors.passwordT
import com.example.codetest.interactors.passwordTxt
import com.example.codetest.interactors.testCartBtn
import com.example.codetest.interactors.testError
import com.example.codetest.interactors.usernameT
import com.example.codetest.interactors.usernameTxt
import org.junit.Before

open class BaseUiTest {

    open lateinit var device: UiDevice

    //initialize device
    @Before
    open fun baseSetUp() {
        device = UiDevice.getInstance(
            InstrumentationRegistry.getInstrumentation()
        )
        device.pressHome()
        launchApp()
    }

    //launch external app
    fun launchApp() {
        device.executeShellCommand(
            "am start -n com.swaglabsmobileapp/.SplashActivity"
        )

        device.wait(
            Until.hasObject(By.pkg("com.swaglabsmobileapp").depth(0)),
            5000
        )
    }

    //close app
    fun closeApp() {
        device.executeShellCommand(
            "am force-stop com.swaglabsmobileapp"
        )
    }

    //find elements on the screen
    fun waitUntilVisible(selector: BySelector, timeout: Long = 5_000): UiObject2 {
        device.wait(Until.hasObject(selector), timeout)
        return device.findObject(selector)
            ?: throw AssertionError("Object not found: $selector")
    }


    //scroll
    fun scrollUntilVisible(
        selector: BySelector,
        maxSwipes: Int = 5
    ): UiObject2 {

        repeat(maxSwipes) {
            device.findObject(selector)?.let { return it }

            device.swipe(
                device.displayWidth / 2,
                device.displayHeight * 3 / 4,
                device.displayWidth / 2,
                device.displayHeight / 4,
                20
            )
        }

        throw AssertionError("Object not found after scrolling: $selector")
    }

    //login
    fun login() {
        device.wait(
            Until.hasObject(loginBtn),
            5000
        )
        device.findObject(
            usernameTxt
        ).text = usernameT
        device.findObject(
            passwordTxt
        ).text = passwordT
        //device.pressBack()
        val loginButton = device.wait(
            Until.findObject(loginBtn),
            5_000
        )
        requireNotNull(loginButton) { "LOGIN button not found" }
        loginButton.click()
        validateHomePage()
    }

    /*
            fun validateLoginError(expectedMessage: String) {
                // wait til the error
                device.wait(
                    Until.hasObject(testError),
                    5000
                )
            }
    */
    fun loginIsDisplayed() {
        device.wait(
            Until.hasObject(loginBtn),
            5000
        )
    }


    //logout
    fun logout() {
        // open menu
        waitUntilVisible(menuBtn).click()
        //click on logout
        waitUntilVisible(logoutBtn).click()
        // verify login screen
        loginIsDisplayed()
    }

    // home page
    fun validateHomePage() {
        device.wait(
            Until.hasObject(homePageText),
            5000
        )
    }

    fun goToCart() {
        waitUntilVisible(testCartBtn).click()
    }

    fun clickOnCheckout() {
        scrollUntilVisible(checkoutBtn).click()
    }
    //checkout info
    fun clickOnContinue() {
        waitUntilVisible(continueBtn).click()
    }
    //finish checkout
    fun finishCheckout() {
        scrollUntilVisible(finishBtn).click()
    }
    //back to home
    fun backHome() {
        waitUntilVisible(backHomeBtn).click()
    }

    //add to cart
    fun addToCart() {
        device.findObjects(addToCartBtn)
            .take(2)
            .forEach { it.click() }
    }

    companion object

}
