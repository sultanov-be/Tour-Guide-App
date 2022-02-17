package com.example.tourguideapp;

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tourguideapp.Fragments.CinemasFragment
import com.example.tourguideapp.Fragments.FitnessesFragment
import com.example.tourguideapp.Fragments.RestaurantsFragment

class ViewpagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    val fragmentsNumber = 3

    override fun getItemCount(): Int {
        return fragmentsNumber
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                RestaurantsFragment()
            }
            1 -> {
                FitnessesFragment()
            }
            2 ->  {
                CinemasFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}