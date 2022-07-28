package com.itstime.haejo.begin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itstime.haejo.BeginActivity
import com.itstime.haejo.R
import com.itstime.haejo.databinding.FragmentManual3Binding

class FragmentManual3 : Fragment() {
    lateinit var binding : FragmentManual3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentManual3Binding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            val intent = Intent(binding.root.context, BeginActivity::class.java)
            startActivity(intent)
        }

        binding.lottieAnimation.playAnimation()

        return binding.root
    }

}