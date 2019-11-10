package com.bliepy.studentportal

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class PortalAdapter(val portalList: ArrayList<PortalData>) :  RecyclerView.Adapter<PortalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.portal_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return portalList.size
    }

    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {

        holder.title.text = portalList[position].title
        holder.url.text = portalList[position].url

        holder.card.setOnClickListener(View.OnClickListener { v ->

            val intent = Intent(v.context, WebPortalActivity::class.java)
            intent.putExtra("url",portalList[position].url )
            v.context.startActivity(intent) })


    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title)
        var url: TextView = itemView.findViewById(R.id.url)
        var card: LinearLayout = itemView.findViewById(R.id.card)



    }

}
