package com.example.easylogin.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.easylogin.data.UserRepository

class LoginViewModel : ViewModel() {
    val userName = mutableStateOf("")
    val password = mutableStateOf("")
    val isLoginSuccess = mutableStateOf(false)
    val usernameError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)
    val loginMessage = mutableStateOf<String?>(null)

    fun authenticate(): Boolean {
        usernameError.value = null
        passwordError.value = null
        loginMessage.value = null
        var isValid = true

        if (userName.value.isBlank()) {
            usernameError.value = "Username field must not be empty"
            isValid = false
        } else if (userName.value.length > 20) {
            usernameError.value = "Username too long, must be under 20 characters"
            isValid = false
        } else {
            usernameError.value = null
        }

        if (password.value.isBlank()) {
            passwordError.value = "Password field must not be empty"
            isValid = false
        } else if (password.value.length > 20) {
            passwordError.value = "Password too long, must be under 20 characters"
            isValid = false
        } else {
            passwordError.value = null
        }

        if (!isValid) return false

        return if (UserRepository.authenticate(userName.value, password.value)) {
            loginMessage.value = "Authentication success! Welcome to easyLogin \"${userName.value}\"!"
            isLoginSuccess.value = true
            true
        } else {
            if (UserRepository.containUser(userName.value)) {
                loginMessage.value = "Error: wrong password for user \"${userName.value}\""
            } else {
                loginMessage.value = "Error: user \"${userName.value}\" not found"
            }
            isLoginSuccess.value = false
            false
        }
    }
}