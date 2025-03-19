package com.example.easylogin.data

object UserRepository {

    private val users = mutableMapOf<String, String>(
        "prova" to "prova"
    )

    fun authenticate(username: String, password: String): Boolean {
        return users[username] == password
    }

    fun containUser(userName: String): Boolean{
        return users.containsKey(userName)
    }

    fun registerUser(username: String, password: String): Boolean {
        if (users.containsKey(username)) {
            return false
        }
        users[username] = password
        return true
    }
}