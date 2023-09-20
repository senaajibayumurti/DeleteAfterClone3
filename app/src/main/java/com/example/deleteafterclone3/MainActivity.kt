package com.example.deleteafterclone3

import android.R
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.deleteafterclone3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
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

            btnShowCalendar.setOnClickListener {
                val datePicker = DatePicker()
                datePicker.show(supportFragmentManager, "datePicker")
            }

            timePicker.setOnTimeChangedListener { _, hoursOfDay, minute ->
                val selectedTime = "$hoursOfDay:$minute"
                Toast.makeText(
                    this@MainActivity,
                    selectedTime, Toast.LENGTH_SHORT
                ).show()
            }

            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ){_, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth ${month} $year"
                Toast.makeText(
                    this@MainActivity,
                    selectedDate, Toast.LENGTH_SHORT
                ).show()
            }

            val adapterProvinsi = ArrayAdapter<String>(this@MainActivity,
            R.layout.simple_spinner_item, provinsi)
            spinnerProvinsi.adapter = adapterProvinsi

            //Memanggil dari string.xml
            val countries = resources.getStringArray(com.example.deleteafterclone3.R.array.countries)
            val adapterCountries = ArrayAdapter<String>(this@MainActivity,
            R.layout.simple_spinner_item, countries)
            spinnerCountry.adapter = adapterCountries

            //Memanggil selected item dari Spinner (Untuk contoh spinnerCountry)
            spinnerCountry.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ){
                        Toast.makeText(
                            this@MainActivity,
                            countries[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }
    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3: Int) {
        val selectedDate = "$p3/${p2 + 1}/$p1"
        Toast.makeText(
            this@MainActivity,
            selectedDate, Toast.LENGTH_SHORT
        ).show()
    }
}