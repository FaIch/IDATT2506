package idatt2506.oving_4

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private lateinit var listView: ListView
    private var listener: BookSelectedListener? = null

    interface BookSelectedListener {
        fun onBookSelected(book : Book)
        fun getBookList(): List<Book>
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BookSelectedListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)
        listView = view.findViewById(R.id.item_list)

        val items = listener?.getBookList() ?: emptyList()

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items.map { it.title })
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            listener?.onBookSelected(items[position])
        }
        return view
    }
}