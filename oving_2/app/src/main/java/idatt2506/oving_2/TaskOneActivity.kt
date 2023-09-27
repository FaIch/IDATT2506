package idatt2506.oving_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class TaskOneActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
    }

    fun onClickRandomButton(v: View?) {
        val intent = Intent(this, RandomNumberActivity::class.java)
        intent.putExtra("UPPER_LIMIT", 100)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val result = data?.getIntExtra("RANDOM_NUMBER", -1)

            Toast.makeText(this, "Random number: $result", Toast.LENGTH_LONG).show()

            val textView = findViewById<View>(R.id.textView) as TextView
            textView.text = "Meow this is your number, prrr: $result"
        }
    }
}