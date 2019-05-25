package com.example.simpleclicker.json

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.simpleclicker.R

class PostAdapter : RecyclerView.Adapter<PostAdapter.Companion.PostViewHolder>() {

    var mPostList: ArrayList<Post> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_cardview, parent, false)
        return PostViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mPostList.size
    }

    fun setList(newList: List<Post>) {
        mPostList.clear()
        mPostList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentItem = mPostList.get(position)

        val strTitle: String =
            "User: " + currentItem.userId.toString() + " Post " + currentItem.postId.toString() + " " + currentItem.title

        holder.mtitle.setText(strTitle)
        holder.mtextView.setText(currentItem.textbody)
    }

    companion object {
        class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            lateinit var mtitle: TextView
            lateinit var mtextView: TextView

            init {

                mtitle = itemView.findViewById(R.id.title)
                mtextView = itemView.findViewById(R.id.textView)
            }
        }
    }
}