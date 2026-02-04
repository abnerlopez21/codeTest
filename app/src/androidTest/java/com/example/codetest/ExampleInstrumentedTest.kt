package com.example.codetest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.codetest.interactors.addToCartBtn
import com.example.codetest.interactors.loginBtn
import com.example.codetest.interactors.testError
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : BaseUiTest() {

    @After
    fun killApp() {
        closeApp()
    }

    @Test
    fun loginHP() {
        login()
    }

    @Test
    fun loginFailTest() {
        // wrong user and password
        loginIsDisplayed()
        setWrongUser()
        setWrongPwd()
        // click login button
        device.findObject(loginBtn).click()
        waitUntilVisible(testError)
    }

    @Test
    fun checkoutFlow() {
        login()
        //add to cart
        addToCart()
        //click cart
        goToCart()
        //checkout
        clickOnCheckout()
        //fill the checkout info
        completeForm()
        clickOnContinue()
        //finish checkout
        finishCheckout()
        //back home
        backHome()
        //logout
        validateHomePage()
        logout()

    }

    @Test
    fun addProductsWithScrollTest() {
        login()
        addToCart()
        scrollUntilVisible(addToCartBtn)
        addToCart()
    }

}