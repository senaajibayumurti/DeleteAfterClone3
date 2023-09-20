package com.example.deleteafterclone3

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.deleteafterclone3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Membuat list untuk konten Spinner
        val provinsi = arrayOf(
            "Jawa Timur",
            "Jawa Tengah",
            "Jawa Barat",
            "Jakarta",
            "Yogyakarta"
        )

        //Memasukkan val provinsi ke spinner
        with(binding){
            val adapterProvinsi = ArrayAdapter<String>(this@MainActivity,
            R.layout.simple_spinner_item, provinsi)
            spinnerProvinsi.adapter = adapterProvinsi

            //Memanggil dari string.xml
            val countries = resources.getStringArray(com.example.deleteafterclone3.R.array.countries)
            val adapterCountries = ArrayAdapter<String>(this@MainActivity,
            R.layout.simple_spinner_item, countries)
            spinnerCountry.adapter = adapterCountries
        }
    }
}