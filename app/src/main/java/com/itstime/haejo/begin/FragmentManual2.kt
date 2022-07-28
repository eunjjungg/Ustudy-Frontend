package com.itstime.haejo.begin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itstime.haejo.R
import com.itstime.haejo.databinding.FragmentManual2Binding

class FragmentManual2 : Fragment() {
    lateinit var binding : FragmentManual2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentManual2Binding.inflate(inflater, container, false)

        binding.lottieAnimation.playAnimation()

        return binding.root
    }

}