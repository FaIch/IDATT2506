package idatt2506.oving_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TaskTwoActivity : Activity() {
    private lateinit var number1: TextView
    private lateinit var number2: TextView
    private lateinit var answer: EditText
    private lateinit var upperLimit: EditText
    private lateinit var addButton: Button
    private lateinit var multiplyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        answer = findViewById(R.id.answer)
        upperLimit = findViewById(R.id.upperLimitInput)
        addButton = findViewById(R.id.addButton)
        multiplyButton = findViewById(R.id.multiplyButton)

        addButton.setOnClickListener {
            checkAnswer('+')
        }

        multiplyButton.setOnClickListener {
            checkAnswer('*')
        }
    }

    private fun checkAnswer(operator: Char) {
        val first = number1.text.toString().toInt()
        val second = number2.text.toString().toInt()
        val inputAnswer = answer.text.toString().toInt()

        val solution = when (operator) {
            '+' -> first + second
            '*' -> first * second
            else -> 0
        }

        if(inputAnswer == solution) {
            Toast.makeText(this, R.string.riktig, Toast.LENGTH_SHORT).show()
        }
        else {
            val message = getString(R.string.feil) + solution.toString()
            Toast.makeText(this, message , Toast.LENGTH_SHORT).show()
        }

        setNumbers(1)
    }

    private fun setNumbers(requestCode: Int) {
        val upperLimitInput = upperLimit.text.toString().toInt()
        val intent = Intent(this, RandomNumberActivity::class.java)
        intent.putExtra("UPPER_LIMIT", upperLimitInput)
        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK) {
            when (requestCode) {
                1 -> {
                    number1.text = data?.getIntExtra("RANDOM_NUMBER", -1).toString()
                    setNumbers(2)
                }
                2 -> {
                    number2.text = data?.getIntExtra("RANDOM_NUMBER", -1).toString()
                }
            }
        }
    }
}