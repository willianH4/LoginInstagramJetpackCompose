package com.willian.logininstagramjetpackcompose

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreeLogin() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        ImageLogo()
        Spacer(modifier = Modifier.size(16.dp))
        EmailComponent(email) { email = it }
        Spacer(modifier = Modifier.size(4.dp))
        PasswordComponent(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPasswordComponent(Modifier.align(Alignment.End))
    }
}

@Composable
fun ForgotPasswordComponent(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9), modifier = modifier
    )
}

// Separamos la pantalla en componentes
@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close, contentDescription = "Close App", modifier = modifier.clickable { activity.finish() })
}

@Composable
fun PasswordComponent(password: String, onTextChanged: (String) -> Unit) {
    TextField(value = password, onValueChange = { onTextChanged(it) } )
}

@Composable
fun EmailComponent(email: String, onTextChanged: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChanged(it) } )
}

@Composable
fun ImageLogo() {
    Image(painter = painterResource(id = R.drawable.insta), contentDescription = "logo")
}