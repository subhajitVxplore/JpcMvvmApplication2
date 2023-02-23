package com.vxplore.jpcmvvmapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
 fun LoginScreen(onNextClick: () -> Unit, onNextClick2: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(8.dp))
                    .background(color = Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "LoginScreen",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(16.dp)
                )
                var emailText by remember { mutableStateOf(TextFieldValue("")) }
                TextField(value = emailText, onValueChange = { emailText = it },
                    label = { Text("Email") }, placeholder = { Text(text = "yourEmail@mail.com") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                var pswdText by remember { mutableStateOf(TextFieldValue("")) }
                TextField(value = pswdText, onValueChange = { pswdText = it },
                    label = { Text("Password") }, placeholder = { Text(text = "********") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number
                    )
                )

                val scop2 = rememberCoroutineScope()

                Button(
                    onClick = {
                        // Toast.makeText(context, "LoginScreen", Toast.LENGTH_SHORT).show()
                          onNextClick()
                        scop2.launch {
                           // viewModel.readRegister(dao, emailText.text, pswdText.text)
                            //viewModel.checkEmail(context, emailText.text)
                        }

                    }, shape = RoundedCornerShape(30.dp), modifier = Modifier
                        .padding(20.dp)
                        .height(50.dp)
                ) { Text(text = "Login to Dashboard") }
            }
            TextButton(onClick = onNextClick2) {
                Text(
                    text = "Navigate to Registration",
                    textDecoration = TextDecoration.Underline
                )
            }
            TextButton(onClick = {


            }) { Text(text = "Forgot Password ?", color = Color.Gray) }

        }

}

