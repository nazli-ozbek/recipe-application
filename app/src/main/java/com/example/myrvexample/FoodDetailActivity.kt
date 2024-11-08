package com.example.myrvexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myrvexample.databinding.ActivityFoodDetailBinding

class FoodDetailActivity : AppCompatActivity() {
    companion object{
        const val FOOD_NAME = "food_name"
        const val FOOD_TYPE = "food_type"
        const val FOOD_RECIPE = "food_recipe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_detail)
        val binding: ActivityFoodDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_food_detail)

        val foodName = intent.getStringExtra(FOOD_NAME)
        val foodType = intent.getStringExtra(FOOD_TYPE)
        val foodRecipe = intent.getStringExtra(FOOD_RECIPE)

        binding.foodView.text = foodName
        binding.typeView.text = foodType
        binding.recipeView.text = foodRecipe

        if (foodName != null) {
            binding.foodImageView.setImageResource(getFoodImageResource(foodName))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getFoodImageResource(foodModel: String): Int {
        return when (foodModel) {
            "\uD83E\uDD6ASandwich" -> R.drawable.sandwich
            "\uD83E\uDD69Steak" -> R.drawable.steak
            "\uD83C\uDF5DPasta" -> R.drawable.pasta
            "\uD83D\uDC1FFish and Chips" -> R.drawable.fishchips
            "\uD83E\uDED4Lasagna" -> R.drawable.lasagna
            "\uD83E\uDD57Salad" -> R.drawable.salad
            "\uD83C\uDF69Donuts" -> R.drawable.donuts
            "\uD83C\uDF2ETacos" -> R.drawable.tacos
            "\uD83E\uDDC7Waffles" -> R.drawable.waffles
            "\uD83C\uDF63Sushi Rolls" -> R.drawable.sushirolls
            "\uD83E\uDD5EPancakes" -> R.drawable.pancake
            "\uD83C\uDF57Fried Chicken" -> R.drawable.friedchicken
            "\uD83C\uDF55Pizza" -> R.drawable.pizza
            "\uD83C\uDF5CRamen" -> R.drawable.ramen
            else -> R.drawable.sandwich
        }
    }
}