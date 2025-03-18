package com.example.easylogin.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easylogin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    val userName = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.clip(RoundedCornerShape(bottomStart = 80.dp, bottomEnd = 80.dp)),
                title = {
                    Text(
                        text = "Easy Login",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF219FF3)
                ),

            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.logo_foreground),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Login Screen",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                )
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    value = userName.value,
                    onValueChange = {
                        userName.value = it
                    },
                    label = { Text(text = "Username") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it
                    },
                    label = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF219FF3)
                    )
                ) {
                    Text(text = "Login", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(text = "Don't you have an account, ")
                    Text(text = "Sign-up!",
                        color = Color(0xFF219FF3),
                        modifier = Modifier.clickable {

                        }
                    )
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun LogicScreenPreview(){
    LoginScreen()
}