package com.example.easylogin.ui.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CustomSnackbarHost(
    hostState: androidx.compose.material3.SnackbarHostState,
    isSuccess: Boolean
) {
    androidx.compose.material3.SnackbarHost(hostState = hostState) { data ->
        androidx.compose.material3.Snackbar(
            containerColor = if (isSuccess) Color(0xFF4CAF50) else Color(0xFFF44336),
            content = { Text(text = data.visuals.message) }
        )
    }
}
