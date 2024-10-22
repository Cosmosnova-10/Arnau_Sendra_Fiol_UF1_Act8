package com.example.uf1act8
/*
* Crea una pantalla de matriculació on podem triar entre diversas materies
* i torns per triar les materies fes servir un checkbox per triar torn de matí o tarda fes servir
* un radiobutton que només deixa triar una de les dues opcions. Afegeix un títol matriculació a la pantalla
*/
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val catala = findViewById<CheckBox>(R.id.checkBox)
        val castella = findViewById<CheckBox>(R.id.checkBox3)
        val matematiques = findViewById<CheckBox>(R.id.checkBox5)
        val tornGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val botoMatricular = findViewById<Button>(R.id.button)

        botoMatricular.setOnClickListener {
            val selectedMateries = StringBuilder(" ") //Matèries seleccionades:
            if (catala.isChecked) selectedMateries.append("Català, ")
            if (castella.isChecked) selectedMateries.append("Castellà, ")
            if (matematiques.isChecked) selectedMateries.append("Matemàtiques, ")

            val selectedTornId = tornGroup.checkedRadioButtonId

            val selectedTorn = when (selectedTornId) {
                R.id.radioButton -> "Matí"
                R.id.radioButton3 -> "Tarda"
                else -> "Cap torn seleccionat"
            }
            val resultMessage = "$selectedMateries\n $selectedTorn" //Torn seleccionat:
            Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show()


        }


    }
}