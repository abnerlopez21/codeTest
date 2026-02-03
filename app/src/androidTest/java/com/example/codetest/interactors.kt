package com.example.codetest

import androidx.test.uiautomator.By

object interactors {
    //login
    val usernameTxt = By.desc("test-Username")
    val usernameT = "standard_user"
    val passwordT = "secret_sauce"
    val passwordTxt = By.desc("test-Password")
    val wrongUser = "user"
    val wrongPwd = "pwd"
    val loginBtn = By.desc("test-LOGIN")
    val testError = By.desc("test-Error message")
    val errorMessage = "Username and password do not match any user in this service."
    //home page
    val menuBtn = By.desc("test-Menu")
    val logoutBtn = By.text("LOGOUT")
    val homePageText = By.text("PRODUCTS")
    val addToCartBtn = By.desc("test-ADD TO CART")
    val testCartBtn = By.desc("test-Cart")
    //your cart
    val checkoutBtn = By.desc("test-CHECKOUT")
    //checkout info
    val firstNameTxtBx = By.desc("test-First Name")
    val firstName = "Abner"
    val LastNameTxtBx = By.desc("test-Last Name")
    val lastName = "Lopez"
    val zipTxtBx = By.desc("test-Zip/Postal Code")
    val zipCode = "64700"
    val continueBtn = By.desc("test-CONTINUE")
    //overview
    val finishBtn = By.desc("test-FINISH")
    //checkout complete
    val backHomeBtn = By.desc("test-BACK HOME")
}