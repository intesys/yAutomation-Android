package it.intesys.ybddtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.datepicker.MaterialDatePicker
import it.intesys.ybddtests.databinding.FragmentDatePickersBinding
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DatePickersFragment : Fragment() {

    private var _binding: FragmentDatePickersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDatePickersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val formattedDate = dateFormat.format(currentDate)
        binding.datePickerButton.text = formattedDate
        binding.dateIsText.text = getString(R.string.date_is, formattedDate)
        binding.datePickerButton.setOnClickListener {
            activity?.let { activity ->
                val datePicker = MaterialDatePicker.Builder.datePicker().build()
                datePicker.show(activity.supportFragmentManager, "DATE_PICKER")
                datePicker.addOnPositiveButtonClickListener { selection ->
                    // Convert the selection (timestamp in milliseconds) to LocalDate
                    val selectedDate = Instant.ofEpochMilli(selection).atZone(ZoneId.systemDefault()).toLocalDate()
                    // Format the LocalDate to "DD/MM/yyyy"
                    val dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val formattedDate = selectedDate.format(dateFormat)
                    binding.datePickerButton.text = formattedDate
                    binding.dateIsText.text = getString(R.string.date_is, formattedDate)
                    binding.datePicker.updateDate(selectedDate.year, selectedDate.monthValue - 1, selectedDate.dayOfMonth)
                }
            }
        }
        binding.datePicker.setOnDateChangedListener { datePicker, i, i2, i3 ->
            var formattedDate = ""
            if (i3 < 10) formattedDate = "0$i3/" else formattedDate = "$i3/"
            if (i2 < 10) formattedDate += "0${i2+1}/" else formattedDate += "${i2+1}/"
            formattedDate += "$i"
            binding.datePickerButton.text = formattedDate
            binding.dateIsText.text = getString(R.string.date_is, formattedDate)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}