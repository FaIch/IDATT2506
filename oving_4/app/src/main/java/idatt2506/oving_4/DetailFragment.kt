package idatt2506.oving_4
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var descriptionView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_fragment, container, false)
        imageView = view.findViewById(R.id.book_image)
        descriptionView = view.findViewById(R.id.book_description)
        return view
    }

    fun showBookDetail(book: Book) {
        imageView.setImageResource(book.imageResId)
        descriptionView.text = book.description
    }
}