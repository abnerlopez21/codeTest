package com.example.codetest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.codetest.interactors.LastNameTxtBx
import com.example.codetest.interactors.addToCartBtn
import com.example.codetest.interactors.backHomeBtn
import com.example.codetest.interactors.checkoutBtn
import com.example.codetest.interactors.continueBtn
import com.example.codetest.interactors.finishBtn
import com.example.codetest.interactors.firstNameTxtBx
import com.example.codetest.interactors.loginBtn
import com.example.codetest.interactors.passwordTxt
import com.example.codetest.interactors.testCartBtn
import com.example.codetest.interactors.testError
import com.example.codetest.interactors.usernameTxt
import com.example.codetest.interactors.wrongPwd
import com.example.codetest.interactors.wrongUser
import com.example.codetest.interactors.zipTxtBx
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
        device.findObject(usernameTxt).text = wrongUser
        device.findObject(passwordTxt).text = wrongPwd
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
        waitUntilVisible(firstNameTxtBx).text = "Abner"
        waitUntilVisible(LastNameTxtBx).text = "Lopez"
        waitUntilVisible(zipTxtBx).text = "67205"
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