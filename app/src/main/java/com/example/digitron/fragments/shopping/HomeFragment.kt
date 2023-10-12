package com.example.digitron.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.digitron.R
import com.example.digitron.adapters.HomeViewpagerAdapter
import com.example.digitron.databinding.FragmentHomeBinding
import com.example.digitron.fragments.categories.*
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf(
            MainCategoryFragment(),
            IPhoneFragment(),
            MacFragment(),
            AccessoriesFragment(),
            IPadsFragment(),
            AppleWatchesFragment()
        )

        binding.viewpagerHome.isUserInputEnabled = false

        val viewPager2Adapter =
            HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Main"
                1 -> tab.text = "iPhone"
                2 -> tab.text = "Mac"
                3 -> tab.text = "Apple Watch"
                4 -> tab.text = "iPads"
                5 -> tab.text = "Accessory"
            }
        }.attach()
    }
}