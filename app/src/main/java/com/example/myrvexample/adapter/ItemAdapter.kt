package com.example.myrvexample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrvexample.R
import com.example.myrvexample.FoodDetailActivity
import com.example.myrvexample.model.Food

class ItemAdapter(private val data: List<Food>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var food: Food

        val foodView: TextView = view.findViewById(R.id.foodnameTV)
        val typeView: TextView = view.findViewById(R.id.foodtypeTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showFoodIntent = Intent(context, FoodDetailActivity::class.java)
                showFoodIntent.putExtra(FoodDetailActivity.FOOD_NAME, food.name)
                showFoodIntent.putExtra(FoodDetailActivity.FOOD_TYPE, food.type)
                showFoodIntent.putExtra(FoodDetailActivity.FOOD_RECIPE, food.recipe)
                context.startActivity(showFoodIntent)
            }
        }
        fun bind(food:Food){
            this.food = food
            foodView.text = food.name
            typeView.text = food.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val food = data[position]
        holder.bind(food)
    }
}