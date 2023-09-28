package idatt2506.oving_3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.collections.ArrayList

class FriendListActivity : AppCompatActivity() {

    private lateinit var friendsList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friend_list)

        val goBackButton = findViewById<Button>(R.id.goBackButton)

        goBackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("friendsList", friendsList)
            startActivity(intent)
        }

        val friendsListView = findViewById<ListView>(R.id.friendsListView)

        friendsList = intent.getStringArrayListExtra("friendsList") as ArrayList<String>

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, friendsList)
        friendsListView.adapter = adapter

        friendsListView.setOnItemClickListener { _, _, position, _ ->
            showEditDialog(position)
        }
    }

    private fun showEditDialog(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Change details")

        val input = EditText(this)
        input.setText(friendsList[position])
        builder.setView(input)

        builder.setPositiveButton("OK") { _, _ ->
            val editedFriend = input.text.toString()
            friendsList[position] = editedFriend
            adapter.notifyDataSetChanged()
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }

        builder.show()
    }
}

