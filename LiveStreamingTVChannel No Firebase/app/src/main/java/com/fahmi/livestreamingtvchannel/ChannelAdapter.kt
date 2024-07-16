package com.fahmi.livestreamingtvchannel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChannelAdapter(private val channels: List<Channel>, private val onItemClick: (Channel) -> Unit) :
    RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_channel, parent, false)
        return ChannelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channels[position]
        holder.bind(channel)
    }

    override fun getItemCount(): Int {
        return channels.size
    }

    inner class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val channelNameTextView: TextView = itemView.findViewById(R.id.textView_channel_name)
        private val channelLogoImageView: ImageView = itemView.findViewById(R.id.imageView_channel_logo)

        fun bind(channel: Channel) {
            channelNameTextView.text = channel.name
            Glide.with(itemView.context)
                .load(channel.logoUrl)
                .into(channelLogoImageView)

            itemView.setOnClickListener {
                onItemClick.invoke(channel)
            }
        }
    }
}
