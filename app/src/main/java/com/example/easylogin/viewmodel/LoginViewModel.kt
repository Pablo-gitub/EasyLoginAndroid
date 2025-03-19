package com.example.easylogin.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val userName = mutableStateOf("")
    val password = mutableStateOf("")

    val usernameError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)

    fun validateFields(): Boolean {
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

        return isValid
    }
}