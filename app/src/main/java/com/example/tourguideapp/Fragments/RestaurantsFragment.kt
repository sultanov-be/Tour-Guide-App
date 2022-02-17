package com.example.tourguideapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tourguideapp.ListAdapter
import com.example.tourguideapp.Place
import com.example.tourguideapp.R

class RestaurantsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurants, container, false)

        val listInfo = mutableListOf(
            Place(
                "Cyclone",
                "Ресторан",
                "Проспект Чуй 136",
                "Открыто до 05:00",
                R.drawable.ic_cyclone_image,
                false,
                "Открыто до 05:00",
                "Проспект Чуй 136",
                "+996 505 505 505",
            ),
            Place(
                "Anar",
                "Ресто-чайхана",
                "ул. Льва Толстого, 102/4",
                "Открыто до 02:00",
                R.drawable.ic_cyclone_image,
                false,
                "В первый раз слышу",
                "ул. Льва Толстого, 102/4",
                "+996 505 505 505",
            ),
            Place(
                "Бай Казан",
                "Ресто-чайхана",
                "ул. К. Баялинова, 131",
                "Открыто до 23:00",
                R.drawable.ic_cyclone_image,
                false,
                "Открыто до 23:00",
                "ул. К. Баялинова, 131",
                "+996 505 505 505",
            ),
            Place(
                "BARHAT",
                "Ресто-чайхана",
                "ул. Иса Ахунбаева 17А",
                "Открыто до 24:00",
                R.drawable.ic_cyclone_image,
                false,
                "Открыто до 23:00",
                "ул. Иса Ахунбаева 17А",
                "+996 505 505 505",
            )
        )

        val adapter = ListAdapter(listInfo)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.restaurant_recycler)

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(view?.context)

        recyclerView?.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        return view
    }
}