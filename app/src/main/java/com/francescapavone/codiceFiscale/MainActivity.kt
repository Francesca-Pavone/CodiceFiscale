package com.francescapavone.codiceFiscale

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.francescapavone.codiceFiscale.adapters.MyArrayAdapter
import com.francescapavone.codiceFiscale.model.CF
import com.francescapavone.codiceFiscale.ui.layout.CFscreen
import com.francescapavone.codiceFiscale.viewmodels.CountryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class MainActivity : ComponentActivity() {

    companion object {
        const val TAG = "CF2021"
        private const val FILENAME = "countrycode.csv"
    }

    private var fiscalCode = CF()
    private val countryList = mutableListOf<CountryModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CFscreen(fiscalCode)

        }
    }



    private fun findSingleCountry(name: String) {
        CoroutineScope(Dispatchers.Default).launch {
            fiscalCode.birthPlace = "X999"
            for (country in countryList) {
                if (country.description.equals(name, ignoreCase = true)) {
                    fiscalCode.birthPlace = country.code
                    break
                }
            }
            fiscalCode.fiscalCode
        }
    }

    private fun readFile() {
        val reader = assets.open(FILENAME)
            .bufferedReader()
        CoroutineScope(Dispatchers.IO).launch {
            reader.useLines { lines ->
                lines.forEach {
                    val fields = it.uppercase(Locale.getDefault()).split(";")
                    countryList.add(CountryModel(fields[0], fields[1], fields[2]))
                }
                launch(Dispatchers.Default) {
                    countryList.sortBy { it.description }
                    launch(Dispatchers.Main) {
                        Log.w(TAG, "LETTO!")
                        //binding.etCountryName.isEnabled = true
                        //val adapter = MyArrayAdapter(
                          //  this@MainActivity,
                           // R.layout.simple_dropdown_item_1line,
                            // countryList
                        //)
                        //binding.etCountryName.setAdapter(adapter)
                        //binding.etCountryName.hint = "Birthplace"
                    }
                }
            }
        }
    }

    /*private fun setViewModel() {
        val fiscalCodeObserver = Observer<String> { cf ->
            Log.w(TAG, cf)
            binding.tvFiscalCode.text = cf
        }
        cFviewModel.fiscalCode.observe(this, fiscalCodeObserver)

//        val countryObserver = Observer<List<CountryModel>> {c ->
//            binding.etCountryName.setAdapter(ArrayAdapter<CountryModel>(this,
//                android.R.layout.simple_dropdown_item_1line, c))
//        }
//        countryViewModel.listOfCountries.observe(this, countryObserver)
    }*/

}

