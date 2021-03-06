package com.francescapavone.codiceFiscale.ui.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material.icons.twotone.LocationOn
import androidx.compose.material.icons.twotone.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.francescapavone.codiceFiscale.R
import com.francescapavone.codiceFiscale.model.CF
import com.francescapavone.codiceFiscale.ui.theme.MyLightBlue
import com.francescapavone.codiceFiscale.ui.theme.MyDarkBlue
import com.francescapavone.codiceFiscale.viewmodels.CFModel


@Composable
fun CFscreen(fiscalCode: CF) {
    val firstName = rememberSaveable() { mutableStateOf("") }
    val lastName = rememberSaveable() { mutableStateOf("") }
    val gender = rememberSaveable() { mutableStateOf("") }
    val dateOfBirth = rememberSaveable() { mutableStateOf("") }
    val birthPlace = rememberSaveable() { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.linearGradient(colors = listOf(MyDarkBlue, MyLightBlue))),
            contentAlignment = Alignment.CenterStart
        ) { Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Fiscal Code generator",
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 15.dp, top = 30.dp, bottom = 30.dp, end = 50.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.repubblica_italiana),
                contentDescription = "repIaliana",
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                alignment = Alignment.CenterEnd
            )

        }
            

        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(40.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (fiscalCode.fiscalCode != "") {
                Text(
                    text = fiscalCode.fiscalCode,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
            MyEditText(text = firstName, hint = "Name", icon = Icons.TwoTone.Person)
            MyEditText(text = lastName, hint = "Last name", icon = Icons.TwoTone.Person)
            MyEditText(text = gender, hint = "Gender (M/F)", icon = Icons.TwoTone.Person)
            MyEditText(text = dateOfBirth, hint = "Date of birth (dd/mm/yyyy)", icon = Icons.TwoTone.DateRange)
            MyEditText(text = birthPlace, hint = "Birth place", icon = Icons.TwoTone.LocationOn)
            Spacer(modifier = Modifier.padding(20.dp))
            GradientButton(
                text = "Generate Fiscal Code",
                textColor = Color.White,
                gradient = Brush.linearGradient(
                    colors = listOf(
                        MyDarkBlue,
                        MyLightBlue
                    )
                ),
                onClick = {
                    fiscalCode.firstName = firstName.value
                    fiscalCode.lastname = lastName.value
                    fiscalCode.gender = gender.value
                    fiscalCode.dateOfBirth = dateOfBirth.value
                    fiscalCode.birthPlace = birthPlace.value
                    fiscalCode.fiscalCode = CFModel.encode(firstName.value, lastName.value, dateOfBirth.value,gender.value, birthPlace.value)
                }
            )

        }
    }
}

@Preview
@Composable
fun CFScreenPreview(){
    //CFscreen()
}