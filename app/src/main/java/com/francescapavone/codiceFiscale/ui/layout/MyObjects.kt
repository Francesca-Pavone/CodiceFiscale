package com.francescapavone.codiceFiscale.ui.layout


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.francescapavone.codiceFiscale.ui.theme.MyLightBlue
import com.francescapavone.codiceFiscale.ui.theme.MyLightGray
import com.francescapavone.codiceFiscale.ui.theme.MyDarkBlue

@Composable
fun GradientButton(text: String,
                   textColor: Color,
                   gradient: Brush,
                   onClick: () -> Unit) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent
            ),
            shape = RoundedCornerShape(40),
            contentPadding = PaddingValues(),
            onClick = { onClick() })
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(gradient)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = text, color = textColor, fontSize = 18.sp)
            }
        }
}

@Composable
fun MyEditText(text: MutableState<String>, hint: String, icon: ImageVector ){
    TextField(
        value = text.value ,
        onValueChange = {text.value = it},
        shape = RoundedCornerShape(40),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedLabelColor = MyDarkBlue,
            focusedLabelColor = MyLightBlue,
            backgroundColor = MyLightGray
        ),
        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(
                2.dp,
                Brush.linearGradient(colors = listOf(MyDarkBlue, MyLightBlue)),
                RoundedCornerShape(40)
            ),
        singleLine = true,
        label = {Text(
            text = hint,
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )},
        leadingIcon = {Icon(
            imageVector = icon,
            contentDescription = "startIcon"
        )},
        trailingIcon = {if (text.value != "") {
            IconButton(onClick = { text.value = "" }) {
                Icon(
                    imageVector = Icons.TwoTone.Close,
                    contentDescription = "delete"
                ) }
            }
        }
    )
}

@Preview
@Composable
fun MyObjectsPreview(){
    GradientButton(
        text = "Genera Codice Fiscale",
        textColor = Color.White,
        gradient = Brush.linearGradient(
            colors = listOf(
                MyDarkBlue,
                MyLightBlue
            )
        )
    ) {}}
