package com.example.myapplication

import androidx.recyclerview.widget.DiffUtil
import android.os.Bundle


class MyDiffUtilCallBack(var newList: MutableList<Model>?, var oldList: MutableList<Model>?) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return if (oldList != null) oldList!!.size else 0
    }

    override fun getNewListSize(): Int {
        return if (newList != null) newList!!.size else 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList!![newItemPosition].id == oldList!![oldItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList!![newItemPosition]==oldList!![oldItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}