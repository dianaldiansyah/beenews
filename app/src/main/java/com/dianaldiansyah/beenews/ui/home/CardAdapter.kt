package com.dianaldiansyah.beenews.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dianaldiansyah.beenews.R // Replace with your actual R class location

class CardAdapter(private val cardDataList: List<CardData>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardData = cardDataList[position]
        val itemView = holder.itemView

        val smallBlackTextView = itemView.findViewById<TextView>(R.id.smallBlackTextView)
        val smallGreyTextView = itemView.findViewById<TextView>(R.id.smallGreyTextView)
        val largeTitleTextView = itemView.findViewById<TextView>(R.id.largeTitleTextView)

        smallBlackTextView.text = cardData.category
        smallGreyTextView.text = cardData.time
        largeTitleTextView.text = cardData.title
    }

    override fun getItemCount(): Int {
        return cardDataList.size
    }
}




