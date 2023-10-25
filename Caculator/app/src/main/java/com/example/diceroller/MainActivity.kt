package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : ComponentActivity() {
    private var currentOperand :Int=0
    private var currentOperator :String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn0: Button = findViewById(R.id.button18)
        btn0.setOnClickListener {
            numberClick("0")
        }
        val btn1: Button = findViewById(R.id.button13)
        btn1.setOnClickListener {
            numberClick("1")
        }
        val btn2: Button = findViewById(R.id.button14)
        btn2.setOnClickListener {
            numberClick("2")
        }
        val btn3: Button = findViewById(R.id.button15)
        btn3.setOnClickListener {
            numberClick("3")
        }
        val btn4: Button = findViewById(R.id.button9)
        btn4.setOnClickListener {
            numberClick("4")
        }
        val btn5: Button = findViewById(R.id.button10)
        btn5.setOnClickListener {
            numberClick("5")
        }
        val btn6: Button = findViewById(R.id.button11)
        btn6.setOnClickListener {
            numberClick("6")
        }
        val btn7: Button = findViewById(R.id.button5)
        btn7.setOnClickListener {
            numberClick("7")
        }
        val btn8: Button = findViewById(R.id.button6)
        btn8.setOnClickListener {
            numberClick("8")
        }
        val btn9: Button = findViewById(R.id.button7)
        btn9.setOnClickListener {
            numberClick("9")
        }
        val btnPlus: Button = findViewById(R.id.button16)
        btnPlus.setOnClickListener {
            operatorClick("+")
        }
        val btnMinus: Button = findViewById(R.id.button12)
        btnMinus.setOnClickListener {
            operatorClick("-")
        }
        val btnMultiply: Button = findViewById(R.id.button8)
        btnMultiply.setOnClickListener {
            operatorClick("*")
        }
        val btnDivide: Button = findViewById(R.id.button30)
        btnDivide.setOnClickListener {
            operatorClick("/")
        }
        val btnEquals: Button = findViewById(R.id.button20)
        btnEquals.setOnClickListener {
            calculateResult()
        }
    }

    private fun numberClick(number: String) {
        var txtResult: TextView=findViewById(R.id.textView)
        if(txtResult.toString()!="0") {
            val currentText = txtResult.text.toString()
            txtResult.text = currentText + number
        }else{
            txtResult.text = number
        }
    }
    private fun operatorClick(operator: String) {
        var txtResult: TextView=findViewById(R.id.textView)
        currentOperator = operator
        currentOperand = txtResult.text.toString().toInt()
        txtResult.text = ""
    }
    private fun calculateResult() {
        var txtResult: TextView=findViewById(R.id.textView)
        val operand2 = txtResult.text.toString().toInt()
        var result = 0

        when (currentOperator) {
            "+" -> result = currentOperand + operand2
            "-" -> result = currentOperand - operand2
            "*" -> result = currentOperand * operand2
            "/" -> result = currentOperand / operand2
        }

        txtResult.text = result.toString()
    }
}