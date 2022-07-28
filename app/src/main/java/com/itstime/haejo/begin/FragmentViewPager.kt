package com.itstime.haejo.begin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.itstime.haejo.R
import com.itstime.haejo.begin.util.AdapterPagerState
import com.itstime.haejo.databinding.FragmentViewPagerBinding
import com.itstime.haejo.main.MainHomeFragment
import com.itstime.haejo.main.MainMypageFragment
import com.itstime.haejo.main.MainOngoingFragment


class FragmentViewPager : Fragment() {

    lateinit var binding : FragmentViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val pagerAdapter = AdapterPagerState(requireActivity())

        // 3개의 Fragment Add
        pagerAdapter.addFragment(FragmentManual1())
        pagerAdapter.addFragment(FragmentManual2())
        pagerAdapter.addFragment(FragmentManual3())

        //Adapter
        binding.viewPager.adapter = pagerAdapter

        binding.viewPager.registerOnPageChangeCallback(object
            : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
            })
    }

}