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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}