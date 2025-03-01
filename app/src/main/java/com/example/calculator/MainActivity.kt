package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.*
import java.math.BigInteger
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val factorial = findViewById<Button>(R.id.factorial)
        val editText1 = findViewById<EditText>(R.id.editTextText)
        val editText2 = findViewById<EditText>(R.id.EditText2)
        val sum = findViewById<Button>(R.id.sum)
        val multiple = findViewById<Button>(R.id.multiple)
        val divided = findViewById<Button>(R.id.divided)
        val minus = findViewById<Button>(R.id.minus)
        val result = findViewById<TextView>(R.id.result)
        val persentage = findViewById<Button>(R.id.percentage)
        val powerSquare = findViewById<Button>(R.id.powerSquare)
        val squareRoot = findViewById<Button>(R.id.squareRoot)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sum.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()
            num1?.let { n1 ->
                num2?.let { n2 ->
                    val sonuc = n1 + n2
                    result.text = "result ${sonuc}"
                }

            } ?:run {
                result.text = "geçerli bir sayı giriniz"
            }
        }


        persentage.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()
            num1?.let { n1 ->
                num2?.let { n2 ->
                    val sonuc =( n1 * n2 )/ 100
                    result.text = "result ${sonuc}"
                }
            } ?:run {
                result.text = "geçerli bir sayı giriniz"
            }
        }

        squareRoot.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()

            if (num1 == null) {
                result.text = "lütfen geçerli bir sayı giriniz"
            }else if (num1 < 0){
                result.text = "lütfen pozitif bir sayı giriniz"
            }else{
                val sonuc = Math.sqrt(num1)
                result.text = "result: ${sonuc}"
            }
        }

        fun factorialBig(n: Int): BigInteger {
            var result = BigInteger.ONE
            for (i in 1..n) {
                result = result.multiply(BigInteger.valueOf(i.toLong()))
            }
            return result
        }

        factorial.setOnClickListener {
            val num1 = editText1.text.toString().toIntOrNull() // Doğru dönüşüm

            if (num1 == null || num1 < 0) {
                result.text = "Pozitif bir tam sayı giriniz!"
            } else {
                result.text = "Result: ${factorialBig(num1)}"
            }
        }

        powerSquare.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()
            num1?.let {  n1 ->
                num2?.let { n2 ->
                    val sonuc = Math.pow(num1,num2)
                    result.text = "result ${sonuc}"
                }
            } ?:run {
                result.text = "geçerli sayılar giriniz"
            }
        }


        minus.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()

            if( num1 != null && num2 != null){
                val sonuc = num1 - num2
                result.text = "result ${sonuc}"
            }


            else{
             result.text = "gecerli değerler giriniz"
            }
        }

        multiple.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()

            if( num1 != null && num2 != null){
                val sonuc = num1 * num2
                result.text = "result ${sonuc}"
            }


            else{
                result.text = "gecerli değerler giriniz"
            }
        }

        divided.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()

            if( num1 != null && num2 != null){
                if( num2 != 0.0){
                    val sonuc = num1 / num2
                    result.text = "result ${sonuc}"
                }
                else{
                    result.text = "2.sayıyı değiştiriniz"
                }
            }
            else{
                result.text = "gecerli değerler giriniz"
            }
        }

    }
}

