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

class FitnessesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_fitnesses, container, false)

        val listInfo = mutableListOf(
            Place(
                "JFC Gym",
                "Спортивный клуб",
                "Ул. Кара-кульская 1/4",
                "Открыто до 23:00",
                R.drawable.fitness_jfc_img,false,
                "Что то связанное со спортом",
                "Ул. Кара-кульская 1/4",
                "+996 555 160 301",
            ),
            Place(
                "Beauty Dance Studio",
                "Студия фитнеса и танцев",
                "Ул. Исанова 41/1",
                "Открыто до 22:00",
                R.drawable.fitness_beauty_img,false,
                "Что то связанное со спортом",
                "Ул. Исанова 41/1",
                "+996 555 160 301",
            ),
            Place(
                "UMAY Dance Fit",
                "Студия фитнеса и танцев",
                "Проспект Манаса 135",
                "Открыто до 05:00",
                R.drawable.fitness_umay_img,false,
                "Что то связанное со спортом",
                "Проспект Манаса 135",
                "+996 555 160 301",
            ),
            Place(
                "Dasmia",
                "Этно комплекс",
                "Ул. Максима Горького 23"   ,
                "Открыто до 22:00",
                R.drawable.fitness_dasmia_img,false,
                "Что то связанное со спортом",
                "Ул. Максима Горького 23",
                "+996 555 160 301",
            )
        )

        val adapter = ListAdapter(listInfo)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.fitness_recycler)

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