package com.example.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txtNum1: EditText

    lateinit var txtNum2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtNum1 = findViewById<EditText>(R.id.editTxtNum1)

        txtNum2 = findViewById<EditText>(R.id.editTxtNum2)


        //allows textEdit to be found and used in files
        val editText1 = findViewById<TextView>(R.id.editTxtNum1)
        val editText2 = findViewById<TextView>(R.id.editTxtNum2)

        //allows text to be found and used in files
        val textView = findViewById<TextView>(R.id.txtView)

        //allows button to be found and used in the files
        val btnAdd = findViewById<Button>(R.id.btnAddNum)

        //allows button to be found and used in the files
        val btnReset = findViewById<Button>(R.id.btnReset)

        //changes text to what is in the green when the app is run
        textView.text = "Welcome to the sum calculator. " +
                "Insert your numbers in the spaces provided and press the button to find the sum."

        //gives the button a function
        btnAdd.setOnClickListener {
            //retrieves text from user and stores it as a string (Referenced from chatGPT)
            val userInput1: String = editText1.text.toString()
            val userInput2: String = editText2.text.toString()

            //takes string data and converts it to int values, or returns null if that is not possible (referenced from chatGPT)
            val number1: Int? = userInput1.toIntOrNull()
            val number2: Int? = userInput2.toIntOrNull()

            if (number1 != null && number2 != null) {
                val sum = number1 + number2 //preforms the addition (referenced from chatGPT)
                textView.text =
                    "Your answer is: $sum" //displays the results (referenced from chatGPT)
            } else {
                textView.text = "invalid input. Please try again"
            }

            btnReset.setOnClickListener {
                editText1.setText("") //clears the text field (referenced from chatGPT)
                editText2.setText("") //clears the text field (referenced from chatGPT)
                textView.text = "Welcome to the sum calculator. " +
                        "Insert your numbers in the spaces provided and press the button to find the sum."
            }

        }

    }

}
