package com.example.roomexercise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.roomexercise.R
import com.example.roomexercise.data.model.Category

class CustomDropDownAdapter(
    private val context: Context,
    private var dataSource: MutableList<Category>
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View
        val viewHolder: CategoryHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.item_category, parent, false).apply {
                viewHolder = CategoryHolder(this)
                this.tag = viewHolder
            }
        } else {
            view = convertView.apply {
                viewHolder = this.tag as CategoryHolder
            }
        }
        viewHolder.bind(dataSource[position])
        return view
    }

    override fun getItem(position: Int): Any? {
        return dataSource[position];
    }

    override fun getCount(): Int {
        return dataSource.size;
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        if (dataSource[position].categoryID == -1) {
            tv.setTextColor(ContextCompat.getColor(context,R.color.Gray))
        } else {
            tv.setTextColor(ContextCompat.getColor(context,R.color.Black))
        }
        return view
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    inner class CategoryHolder(row: View?) {
        private val categoryName: TextView = row?.findViewById(R.id.tvCategoryItem) as TextView
        fun bind(category: Category) {
            categoryName.text = category.categoryName
            if(category.categoryID == -1){
                categoryName.setTextColor(ContextCompat.getColor(context,R.color.Gray))
            }
            else{
                categoryName.setTextColor(ContextCompat.getColor(context,R.color.Black))
            }
        }
    }
}