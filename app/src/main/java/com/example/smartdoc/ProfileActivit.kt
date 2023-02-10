package com.example.smartdoc

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import java.text.SimpleDateFormat
import java.util.*

class ProfileActivit : AppCompatActivity() {

    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()



    @SuppressLint("NewApi", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        textview_date = this.text_view_date_1
        button_date = this.btn_picker_date

        imageButton.setOnClickListener {
            val imgbtnIntent = Intent(this,MainActivity::class.java)
            startActivity(imgbtnIntent)
        }
        Toastbutton.setOnClickListener {
            Toast.makeText(applicationContext, "Details updated succesfully", Toast.LENGTH_LONG).show()
            val ToastbtnIntent = Intent(this,ChatActivity::class.java)
        startActivity(ToastbtnIntent)
        }


        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
        btn_picker_date.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@ProfileActivit,
                        dateSetListener,
                        // set DatePickerDialog to point to today's date when it loads up
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }

    /* btn_picker_date.setOnClickListener { View.OnClickListener {
         val getDate= getInstance()
         val datePicker = DatePickerDialog(this, android.R.Style.Hololight_Dialog_DatePickerDialog.OnDateSetListener { })
     }}*/

    }

