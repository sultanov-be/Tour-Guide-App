package com.example.tourguideapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

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
        holder.extraInfo.text = onePlace.extra_info
        holder.locationTouch.text = onePlace.adress
        holder.numberTouch.text = onePlace.numberTouch

        val isVisible: Boolean = onePlace.visibility
        holder.expandableLayout.visibility = if (isVisible) View.VISIBLE else View.GONE
        holder.location.visibility = if (isVisible) View.GONE else View.VISIBLE

        holder.moreDetail.setOnClickListener {
            if (holder.location.visibility == View.GONE) {
                holder.itemTitle.textSize = 20f
                holder.itemType.textSize = 18f
                holder.time.textSize = 18f
            } else {
                holder.itemTitle.textSize = 16f
                holder.time.textSize = 14f
                holder.itemType.textSize = 14f
            }

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
        var extraInfo: TextView


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
            extraInfo = itemView.findViewById(R.id.info_text)
        }
    }
}