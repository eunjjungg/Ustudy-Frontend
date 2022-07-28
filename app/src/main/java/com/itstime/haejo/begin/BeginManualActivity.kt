package com.itstime.haejo.begin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itstime.haejo.R
import com.itstime.haejo.databinding.ActivityBeginManualBinding
import com.itstime.haejo.main.MainHomeFragment

class BeginManualActivity : AppCompatActivity() {
    lateinit var binding : ActivityBeginManualBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeginManualBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.fragmentView.id, FragmentViewPager())
        transaction.commit()
    }
}