package it.intesys.ybddtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import it.intesys.ybddtests.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emojis = listOf("🐶🐱","🐱🐱","🐭🐱","🐹","🐰🦊","🦊","🐻","🐼","🐨","🐯","🦁","🐮","🐷","🐗","🐴","🦄","🐞","🐝","🐔","🦆","🐌","🦋","🐙","🐠","🦀","🐳")

        val emojiAdapter = EmojiAdapter(emojis)
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.listRecyclerView.adapter = emojiAdapter

        // Filter functionality
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = if (!newText.isNullOrEmpty()) {
                    emojis.filter { it.contains(newText, ignoreCase = true) }
                } else {
                    emojis
                }
                emojiAdapter.updateList(filteredList)
                return true
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}