package com.francescapavone.codiceFiscale.model

import android.os.Parcelable
import androidx.compose.runtime.mutableStateOf
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class CF: Parcelable{
    @IgnoredOnParcel
    var _firstName = mutableStateOf("")
    @IgnoredOnParcel
    var _lastName = mutableStateOf("")
    @IgnoredOnParcel
    var _dateOfBirth = mutableStateOf("")
    @IgnoredOnParcel
    var _gender = mutableStateOf("")
    @IgnoredOnParcel
    var _countryCode = mutableStateOf("")
    @IgnoredOnParcel
    private var _birthPlace= mutableStateOf("")
    @IgnoredOnParcel
    var _fiscalCode = mutableStateOf("")

    // getter and setter

    var firstName: String
    get() {
        return _firstName.value
    }
    set(value) {
        _firstName.value = value
    }

    var lastname: String
    get() {
        return _lastName.value
    }
    set(value) {
        _lastName.value=value
    }

    var dateOfBirth: String
    get() {
        return _dateOfBirth.value
    }
    set(value) {
        _dateOfBirth.value=value
    }

    var gender: String
    get() {
        return _gender.value
    }
    set(value) {
        _gender.value=value
    }

    var countryCode: String
    get() {
        return _countryCode.value
    }
    set(value) {
        _countryCode.value=value
    }

    var birthPlace: String
    get() {
        return _birthPlace.value
    }
    set(value) {
        _birthPlace.value=value
    }

    var fiscalCode: String
    get() {
        return _fiscalCode.value
    }
    set(value) {
        _fiscalCode.value=value
    }
}
