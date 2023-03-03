package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.example.todoapp.databinding.FragmentInputBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.textView.text = "あいうえお"

        binding.editButton.setOnClickListener {
            // エディットテキストのテキストを取得
            println("push")
            if(binding.editText.text != null){
                println("push")
                Toast.makeText(requireContext(), binding.editText.text.toString(), Toast.LENGTH_SHORT).show()
                binding.textView.text = binding.editText.text.toString()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

}