package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var pocetStranKocky = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton: Button = findViewById(R.id.button)
        val stranyKocky: EditText = findViewById(R.id.pocetStranKocky)

        clickButton.isClickable = false
        stranyKocky.addTextChangedListener(textWatcher)

        clickButton.setOnClickListener { rollDice(pocetStranKocky) }
    }


    private fun rollDice(pNumSides: Int) {
        if (pNumSides <= 0) {
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text =
                getString(R.string.hodena_hodnota, "Musis zadat kladne cislo vacsie ako 0!")
        } else {
            val dice = Dice(pNumSides)
            val diceRoll = dice.roll()
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = getString(R.string.hodena_hodnota, diceRoll.toString())
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            return
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            return
        }

        override fun afterTextChanged(p0: Editable?) {
            val clickButton: Button = findViewById(R.id.button)
            clickButton.isClickable = true
            val stranyKocky: EditText = findViewById(R.id.pocetStranKocky)
            if (stranyKocky.text.toString() == "") {
                return
            }
            pocetStranKocky = Integer.parseInt(stranyKocky.text.toString())
        }

    }

}