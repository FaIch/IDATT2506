package idatt2506.oving_4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity(), ListFragment.BookSelectedListener {

    private val items = listOf(
        Book("The Way of Kings", R.drawable.twok, "Stormlight archive first book"),
        Book("Words of Radiance", R.drawable.wor, "Stormlight archive second book"),
        Book("Edgedancer", R.drawable.edgedancer, "Stormlight archive novella following 'Lift'"),
        Book("Oathbringer", R.drawable.ob, "Stormlight archive third book"),
        Book("Dawnshard", R.drawable.dawnshard, "Stormlight novella following Dalinar"),
        Book("Rythm of War", R.drawable.row, "Stormlight archive fourth book")
    )
    private var selectedItemIndex = 0
    private lateinit var detailFragment: DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val listFragment = ListFragment()
            detailFragment = DetailFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.list_container, listFragment)
                .add(R.id.detail_container, detailFragment)
                .commit()
        }
    }

    override fun getBookList(): List<Book> {
        return items
    }

    override fun onBookSelected(book : Book) {
        detailFragment.showBookDetail(book)
        selectedItemIndex = items.indexOf(book)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_prev -> {
                if (selectedItemIndex > 0) {
                    selectedItemIndex--
                    detailFragment.showBookDetail(items[selectedItemIndex])
                }
            }
            R.id.action_next -> {
                if (selectedItemIndex < items.size - 1) {
                    selectedItemIndex++
                    detailFragment.showBookDetail(items[selectedItemIndex])
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}