package it.intesys.ybddtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import it.intesys.ybddtests.databinding.FragmentPickersBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PickersFragment : Fragment() {

    private var _binding: FragmentPickersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPickersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = listOf("Red", "Green", "Blue", "Tartan")
        context?.apply {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
            binding.spinner.adapter = adapter
            binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    binding.selectedColor.text = getString(R.string.selected_color, items[p2])
                    binding.numberPicker.value = p2
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }

            binding.numberPicker.minValue = 0
            binding.numberPicker.maxValue = items.size-1
            binding.numberPicker.displayedValues = items.toTypedArray()
            binding.numberPicker.setOnValueChangedListener { numberPicker, i, i2 ->
                binding.selectedColor.text = getString(R.string.selected_color, items[i2])
                binding.spinner.setSelection(i2)
            }

            binding.selectedColor.text = getString(R.string.selected_color, items[0])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}