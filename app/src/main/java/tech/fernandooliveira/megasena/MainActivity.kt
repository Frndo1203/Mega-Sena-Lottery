package tech.fernandooliveira.megasena

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initial event
        setContentView(R.layout.activity_main)

        //search objects
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        // touch listener
        // option1: xml

        // option2: using an interface (anonymous object View.OnClickListener)
        //        btnGenerate.setOnClickListener(buttonClickListener)

        // option3: declaring directly the code block used by the onClick method
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

            txtResult.text = numbers.joinToString(" - ")
        }
    }

    // option1: xml
    //    fun buttonClicked(view: View) {
    //        Log.i("Test", "Button clicked")
    //    }

    // option2: using an interface (anonymous object View.OnClickListener)
    //    val buttonClickListener = object : View.OnClickListener {
    //        // who calls onClick is the Android SDK
    //        override fun onClick(v: View?) {
    //            Log.i("Test", "Button clicked")
    //        }
    //    val buttonClickListener = View.OnClickListener {
    //        Log.i("Test", "Button clicked")
    //    }
}