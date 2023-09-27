package idatt2506.oving_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle


class RandomNumberActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        generateNumber()
    }

    private fun generateNumber() {
        val upperLimit = intent.getIntExtra("UPPER_LIMIT", 0)
        val randomNumber = (0..upperLimit).random();

        val resultIntent = Intent()
        resultIntent.putExtra("RANDOM_NUMBER", randomNumber)
        setResult(RESULT_OK, resultIntent)

        finish()
    }
}