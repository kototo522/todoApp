package com.example.todoapp

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.example.todoapp.databinding.FragmentInputBinding
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ModalBottomSheet : BottomSheetDialogFragment() {
    private lateinit var bottomSheet: View
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>


    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheet = view.findViewById(R.id.bottom_sheet_layout)
        bottomSheet.layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        val screenHeight = Resources.getSystem().displayMetrics.heightPixels
        bottomSheetBehavior.peekHeight = screenHeight

        binding.editButton.setOnClickListener {
            if(binding.editText.text != null){
                Toast.makeText(requireContext(), binding.editText.text.toString(), Toast.LENGTH_SHORT).show()
                binding.textView.text = binding.editText.text.toString()
            }
        }
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}