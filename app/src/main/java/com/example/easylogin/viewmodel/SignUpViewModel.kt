package com.example.easylogin.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.easylogin.data.UserRepository

class SignUpViewModel : ViewModel() {
    val userName = mutableStateOf("")
    val password = mutableStateOf("")
    val repetitionPassword = mutableStateOf("")
    val isSignUpSuccess = mutableStateOf(false)

    val usernameError = mutableStateOf<String?>(null)
    val passwordError = mutableStateOf<String?>(null)
    val repetitionPasswordError = mutableStateOf<String?>(null)
    val SignUpMessage = mutableStateOf<String?>(null)

    fun authenticate(): Boolean {
        usernameError.value = null
        passwordError.value = null
        SignUpMessage.value = null
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

        if (repetitionPassword.value.isBlank()) {
            repetitionPasswordError.value = "Password repetition field must not be empty"
            isValid = false
        } else if (repetitionPassword.value.length > 20) {
            repetitionPasswordError.value = "Password repetition too long, must be under 20 characters"
            isValid = false
        } else if (!repetitionPassword.value.equals(password.value)) {
            repetitionPasswordError.value = "You must repeat the same Password"
            isValid = false
        } else {
            repetitionPasswordError.value = null
        }

        if (!isValid) return false

        return if (UserRepository.containUser(userName.value)) {
            SignUpMessage.value = "Error: Already exist a user with this username \"${userName.value}\""
            isSignUpSuccess.value = false
            false
        } else {
            SignUpMessage.value = "Sign-Up success! Now you can Login \"${userName.value}\"!"
            isSignUpSuccess.value = true
            UserRepository.registerUser(userName.value, password.value)
            true
        }
    }
}