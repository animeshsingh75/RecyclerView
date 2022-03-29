package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class RecyclerViewAdapter(private val data: MutableList<Model>, private val onClickListener: OnClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View, onClickListener: OnClickListener) :
        RecyclerView.ViewHolder(view), View.OnClickListener {
        val textViewId: TextView
        val textViewName: TextView
        var onClickListener: OnClickListener
        override fun onClick(v: View) {
            onClickListener.onClick(adapterPosition)
        }

        init {
            textViewId = view.findViewById<TextView>(R.id.text_view_id)
            textViewName = view.findViewById<TextView>(R.id.text_view_name)
            view.setOnClickListener(this)
            this.onClickListener = onClickListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewId.text = data[position].id.toString()
        holder.textViewName.text = data[position].name
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        holder.textViewId.text = data[position].id.toString()
        holder.textViewName.text = data[position].name
    }
    override fun getItemCount(): Int {
        return data.size
    }
    fun getData():MutableList<Model>{
        return data
    }
    fun setData(newData:MutableList<Model>){
        val diffResult = DiffUtil.calculateDiff(MyDiffUtilCallBack(newData, data))

        data.clear()
        data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }
    interface OnClickListener {
        fun onClick(position: Int)
    }
}
