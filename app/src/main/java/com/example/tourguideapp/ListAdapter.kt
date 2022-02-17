package com.example.tourguideapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity


class ListAdapter(var list: List<Place>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {

        val onePlace = list[position]
        holder.itemTitle.text = onePlace.place
        holder.itemType.text = onePlace.type
        holder.itemImage.setImageResource(onePlace.imgId)
        holder.location.text = onePlace.adress

        val isVisible: Boolean = onePlace.visibility
        holder.expandableLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.moreDetail.setOnClickListener {
            onePlace.visibility = !onePlace.visibility
            notifyItemChanged(position)
        }

        val locationString: String = holder.locationTouch.text.toString()
        holder.locationTouch.setOnClickListener {
            val intentMap =
                Uri.parse("geo:0,0?q=$locationString")
            val mapIntent = Intent(Intent.ACTION_VIEW, intentMap)
            mapIntent.setPackage("com.google.android.apps.maps")
            it.context.startActivity(mapIntent)
        }

        val numberString: String = holder.numberTouch.text.toString()
        holder.numberTouch.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", numberString, null))
            it.context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemType: TextView
        val location: TextView
        val time: TextView
        var expandableLayout: ConstraintLayout
        var moreDetail: ImageView
        var locationTouch: TextView
        var numberTouch: TextView


        init {
            itemImage = itemView.findViewById(R.id.place_img)
            itemTitle = itemView.findViewById(R.id.place_text)
            itemType = itemView.findViewById(R.id.type_text)
            location = itemView.findViewById(R.id.adress_text)
            time = itemView.findViewById(R.id.time_text)
            expandableLayout = itemView.findViewById(R.id.expandableLayout)
            moreDetail = itemView.findViewById(R.id.imageButton)
            locationTouch = itemView.findViewById(R.id.extra_location_text)
            numberTouch = itemView.findViewById(R.id.call_text)
        }
    }
}


//class ListAdapter(private val context: Activity, private val arrayList: ArrayList<Place>) :
//    ArrayAdapter<Place>(context, R.layout.list_item, arrayList) {
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//
//        val inflater: LayoutInflater = LayoutInflater.from(context)
//        val view: View = inflater.inflate(R.layout.list_item, null)
//
//        val imageView: ImageView = view.findViewById(R.id.place_img)
//        val place: TextView = view.findViewById(R.id.place_text)
//        val type: TextView = view.findViewById(R.id.type_text)
//        val adress: TextView = view.findViewById(R.id.adress_text)
//        val time: TextView = view.findViewById(R.id.time_text)
//
//        imageView.setImageResource(arrayList[position].imgId)
//        place.text = arrayList[position].place
//        type.text = arrayList[position].type
//        adress.text = arrayList[position].adress
//        time.text = arrayList[position].time
//
//        return view
//
//    }
//}