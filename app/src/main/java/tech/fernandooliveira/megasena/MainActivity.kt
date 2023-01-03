package tech.fernandooliveira.megasena

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initial event
        setContentView(R.layout.activity_main)

        //search objects
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        prefs = getSharedPreferences("db_prefs", Context.MODE_PRIVATE)
        val result = prefs.getString("result", null)
        result?.let {
            txtResult.text = "Last bet: $result"
        }

        //generate random numbers
        btnGenerate.setOnClickListener {

            val text = editText.text.toString()
            numberGenerator(text, txtResult)

        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        // validate if null or empty
        if (text.isEmpty()) {
            Toast.makeText(this, "Please, enter a number", Toast.LENGTH_SHORT).show()
            return
        }

        // convert to int
        val intText: Int = text.toInt()

        // validate if number is between 6 and 15
        if (intText !in 6..15) {
            Toast.makeText(this, "Enter a number between 6 and 15", Toast.LENGTH_SHORT).show()
            return
        }

        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            val number = random.nextInt(60)
            numbers.add(number + 1)

            Log.i("numbers generated", "Generated number: $number")

            if (numbers.size == intText) {
                break
            }
        }
        // join numbers
        val joinedNumbers = numbers.joinToString(" - ")
        txtResult.text = joinedNumbers

        // save numbers

        prefs.edit().apply {
            putString("result", joinedNumbers)
            apply()
        }

        Log.i("Preference saving", "The numbers $joinedNumbers were saved")
    }
}