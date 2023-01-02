package tech.fernandooliveira.megasena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

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
            Log.i("Test", "button clicked")
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