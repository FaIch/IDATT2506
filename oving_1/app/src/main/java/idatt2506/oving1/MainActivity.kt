package idatt2506.oving1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import idatt2506.oving1.ui.theme.Oving1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Oving1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var expanded by remember { mutableStateOf(false) }

                    Text(
                        "Tap to show menu",
                        modifier = Modifier.clickable { expanded = true }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(onClick = {
                            Log.w("Fornavn valgt: ", "Joakim")
                            expanded = false
                        }) {
                            Text("Joakim")
                        }
                        DropdownMenuItem(onClick = {
                            Log.e("Etternavn valgt: ","Falch")
                            expanded = false
                        }) {
                            Text("Falch")
                        }
                    }
                }
            }
        }
    }
}





