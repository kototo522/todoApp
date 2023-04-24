package com.example.todoapp

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.todoapp.databinding.FragmentInputBinding
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
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheet.layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT
        bottomSheetBehavior.saveFlags = BottomSheetBehavior.SAVE_ALL
        val screenHeight = Resources.getSystem().displayMetrics.heightPixels
        bottomSheetBehavior.peekHeight = screenHeight

        binding.editButton.setOnClickListener {
            if(binding.editTitle.text != null) binding.titleView.text = binding.editTitle.text.toString()
            if(binding.editText.text != null) binding.textView.text = binding.editText.text.toString()
        }

        // もっとシンプルにできそう
        binding.colorSelectButton1.setOnClickListener {
            binding.labelText.text = "1"
        }
        binding.colorSelectButton2.setOnClickListener {
            binding.labelText.text = "2"
        }
        binding.colorSelectButton3.setOnClickListener {
            binding.labelText.text = "3"
        }

        binding.exitButton.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}