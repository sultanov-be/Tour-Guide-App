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
                "Broadway",
                "Кинотеатр",
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                R.drawable.ic_cyclone_image,false,
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                "Открыто до 23:00",
            ),
            Place(
                "Broadway",
                "Кинотеатр",
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                R.drawable.ic_cyclone_image,false,
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                "Открыто до 23:00",
            ),
            Place(
                "Broadway",
                "Кинотеатр",
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                R.drawable.ic_cyclone_image,false,
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                "Открыто до 23:00",
            ),
            Place(
                "Broadway",
                "Кинотеатр",
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                R.drawable.ic_cyclone_image,false,
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                "Открыто до 23:00",
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