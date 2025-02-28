package it.intesys.ybddtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import it.intesys.ybddtests.databinding.FragmentDemoBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DemoFragment : Fragment() {

    private var _binding: FragmentDemoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDemoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.defaultFocusHighlightEnabled = false
        //setSupportActionBar(binding.toolbar)
        binding.formButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_FormFragment)
        }
        binding.listButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_ListFragment)
        }
        binding.imagesButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_ImagesFragment)
        }
        binding.controlsButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_ControlsFragment)
        }
        binding.pickerButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_PickersFragment)
        }
        binding.datePickerButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_DatePickersFragment)
        }
        binding.alertsButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_AlertsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}