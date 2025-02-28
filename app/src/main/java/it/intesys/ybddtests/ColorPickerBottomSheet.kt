package it.intesys.ybddtests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import it.intesys.ybddtests.databinding.BottomSheetColorsBinding

class ColorPickerBottomSheet(private val onColorSelected: (Color) -> Unit) : BottomSheetDialogFragment() {
    private var _binding: BottomSheetColorsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetColorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    enum class Color(val color: Int) {
        Red(R.color.red),
        Green(R.color.green),
        Yellow(R.color.yellow)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setContentView(view)

        binding.buttonRed.setOnClickListener {
            onColorSelected(Color.Red)
            dismiss()
        }

        binding.buttonGreen.setOnClickListener {
            onColorSelected(Color.Green)
            dismiss()
        }

        binding.buttonYellow.setOnClickListener {
            onColorSelected(Color.Yellow)
            dismiss()
        }

        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }
}
