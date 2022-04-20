package com.francescapavone.codiceFiscale.model

import android.os.Parcelable
import androidx.compose.runtime.mutableStateOf
import kotlinx.parcelize.Parcelize

@Parcelize
class CF: Parcelable{

    var _firstName = mutableStateOf("")
    var _lastName = mutableStateOf("")
    var _dateOfBirth = mutableStateOf("")
    var _gender = mutableStateOf("")
    var _countryCode = mutableStateOf("")
    var _fiscalCode = mutableStateOf("")

    // getter and setter

    var firstName: String
    get() {
        return _firstName.value
    }
    set(value) {
        _firstName.value = value
    }
}
