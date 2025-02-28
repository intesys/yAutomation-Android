package it.intesys.ybddtests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import it.intesys.ybddtests.databinding.FragmentAlertsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AlertsFragment : Fragment() {

    private var _binding: FragmentAlertsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAlertsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.yesNoButton.setOnClickListener {
            context?.let { context ->
                MaterialAlertDialogBuilder(context)
                        .setTitle(R.string.is_it_yes_or_no)
                        .setMessage(R.string.there_is_no_undo)
                        .setPositiveButton(R.string.yes) { dialog, _ ->
                            binding.state.text = getString(R.string.yes_tapped)
                            binding.state.setTextColor(resources.getColor(R.color.blue, null))
                            dialog.dismiss()
                        }
                        .setNegativeButton(R.string.no) { dialog, _ ->
                            binding.state.text = getString(R.string.no_tapped)
                            binding.state.setTextColor(resources.getColor(R.color.gray, null))
                            dialog.dismiss()
                        }
                        .show()
            }
        }
        binding.colorsButton.setOnClickListener {
                val bottomSheet = ColorPickerBottomSheet { color ->
                    binding.state.text = getString(R.string.tapped, color.name)
                    binding.state.setTextColor(resources.getColor(color.color, null))
                }
                activity?.apply {
                    bottomSheet.show(supportFragmentManager, "ColorPickerBottomSheet")
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}