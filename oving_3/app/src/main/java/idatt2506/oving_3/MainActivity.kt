package idatt2506.oving_3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var daySpinner: Spinner
    private lateinit var monthSpinner: Spinner
    private lateinit var yearSpinner: Spinner

    private val friendsList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewFriendsButton = findViewById<Button>(R.id.viewFriendsButton)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        daySpinner = findViewById(R.id.daySpinner)
        monthSpinner = findViewById(R.id.monthSpinner)
        yearSpinner = findViewById(R.id.yearSpinner)
        val addButton = findViewById<Button>(R.id.addButton)

        val friendsList = ArrayList<String>()

        val days = (1..30).map { it.toString() }
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, days)
        daySpinner.adapter = dayAdapter

        val months = (1 .. 12).map { it.toString() }
        val monthAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        monthSpinner.adapter = monthAdapter

        val years = (1950..2023).map { it.toString() }
        val yearAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        yearSpinner.adapter = yearAdapter

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val day = daySpinner.selectedItem.toString()
            val month = monthSpinner.selectedItem.toString()
            val year = yearSpinner.selectedItem.toString()
            val date = "$day $month $year"
            friendsList.add("$name - $date")

            viewFriendsButton.setOnClickListener {
                val intent = Intent(this, FriendListActivity::class.java)
                intent.putExtra("friendsList", friendsList)
                startActivity(intent)
            }
        }
    }
}

