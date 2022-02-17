package com.example.tourguideapp.Fragments

import android.opengl.Visibility
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

class CinemasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_cinemas, container, false)

        val listInfo = mutableListOf(
            Place(
                "Broadway",
                "Кинотеатр",
                "Asia Mall. 3 этаж",
                "Открыто до 23:00",
                R.drawable.cinema_broadway_img,false,
                // I think it would be really, cause I didn't noticed that it's a cinemaFragment
                // and tried to change errors in adapter, cause on the rest_layout was another data
                "Rесторан европейской кухни\n"+"Средний чек 800 с\n"+"Открыто до 05:00",
                "Asia Mall. 3 этаж",
                "+996 500 160 301",
            ),
            Place(
                "Манас",
                "Кинотеатр",
                "Проспект Манаса 47А",
                "Открыто до 01:00",
                R.drawable.cinema_manas_img,false,
                "Кинотеатр как кинотеатр, ничего особого.",
                "Проспект Манаса 47А",
                "+996 500 160 301",
            ),
            Place(
                "Ала-Тоо",
                "Кинотеатр",
                "Проспект Чуй 187",
                "Открыто до 02:00",
                R.drawable.cinema_alatoo_img,false,
                "Кинотеатр как кинотеатр, ничего особого.",
                "Проспект Чуй 187",
                "+996 500 160 301",
            ),
            Place(
                "ЦУМ кинотеатр",
                "Кинотеатр",
                "Ул. Шопокова 91",
                "Открыто до 01:00",
                R.drawable.cinema_cum_img,false,
                "Кинотеатр как кинотеатр, ничего особого.",
                "Ул. Шопокова 91",
                "+996 500 160 301",
            )
        )

        val adapter = ListAdapter(listInfo)

        val recyclerView = view?.findViewById<RecyclerView>(R.id.cinemas_recycler)

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

