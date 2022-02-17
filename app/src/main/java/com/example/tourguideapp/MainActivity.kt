package com.example.tourguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.viewpager2.widget.ViewPager2
import com.example.tourguideapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tablayout = findViewById<TabLayout>(R.id.tablayout)
        val viewpager = findViewById<ViewPager2>(R.id.viewpager)

        val adapter = ViewpagerAdapter(supportFragmentManager, lifecycle)

        viewpager.adapter = adapter



        TabLayoutMediator(tablayout, viewpager){tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Рестораны"
                }
                1 -> {
                    tab.text = "Фитнес центры"
                }
                2 -> {
                    tab.text = "Кинотеатры"
                }
            }
        }.attach()
    }
}
//        TabLayoutMediator(
//            tablayout,
//            viewpager,
//            object : TabLayoutMediator.TabConfigurationStrategy {
//                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
//                    when (position) {
//                        0 -> {
//                            tab.text = "Рестораны"
//                        }
//                        1 -> {
//                            tab.text = "Фитнес центры"
//                        }
//                        2 -> {
//                            tab.text = "Кинотеатры"
//                        }
//                    }
//                }
//
//            }).attach()

//val imageId = intArrayOf(
//    R.drawable.ic_cyclone_image,
//    R.drawable.ic_cyclone_image,
//    R.drawable.ic_cyclone_image,
//    R.drawable.ic_cyclone_image,
//    R.drawable.ic_cyclone_image,
//    R.drawable.ic_cyclone_image,
//    R.drawable.ic_cyclone_image,
//    R.drawable.ic_cyclone_image
//)
//
//val place = arrayOf(
//    "Cyclone",
//    "Cyclone1",
//    "Cyclone2",
//    "Cyclone3",
//    "Cyclone4",
//    "Cyclone5",
//)