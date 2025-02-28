package it.intesys.ybddtests

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmojiAdapter(private var emojiList: List<String>) :
    RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder>() {
        var selection: String? = null

        inner class EmojiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView: TextView = itemView.findViewById(R.id.list_item_text)
            val checked: ImageView = itemView.findViewById(R.id.checked)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return EmojiViewHolder(view)
        }

        @SuppressLint("UseCompatLoadingForDrawables", "NotifyDataSetChanged")
        override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
            holder.itemView.setOnClickListener {
                selection = emojiList[position]
                notifyDataSetChanged()
            }
            holder.textView.text = emojiList[position]
            val context = holder.itemView.context
            if (position == 0) {
                holder.itemView.background = context.getDrawable(R.drawable.top_corner_background)
            } else if (position == emojiList.size - 1) {
                holder.itemView.background = context.getDrawable(R.drawable.bottom_corner_background)
            } else {
                holder.itemView.background = context.getDrawable(R.drawable.no_corner_background)
            }
            if (selection == emojiList[position]) {
                holder.checked.visibility = View.VISIBLE
            } else {
                holder.checked.visibility = View.GONE
            }
        }

        override fun getItemCount(): Int = emojiList.size

        @SuppressLint("NotifyDataSetChanged")
        fun updateList(newList: List<String>) {
            emojiList = newList
            notifyDataSetChanged()
        }
}
