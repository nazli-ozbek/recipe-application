package com.example.myrvexample.data

import android.content.Context
import com.example.myrvexample.R
import com.example.myrvexample.model.Food

class DataSource(val context: Context) {
    fun getFoodNamesList(): Array<String>{
        return context.resources.getStringArray(R.array.name_array)
    }
    fun getFoodTypesList(): Array<String>{
        return context.resources.getStringArray(R.array.type_array)
    }
    fun getFoodRecipesList(): Array<String>{
        return context.resources.getStringArray(R.array.recipe_array)
    }

    fun loadFoods(): List<Food>{
        val foodList = getFoodNamesList()
        val typeList = getFoodTypesList()
        val recipeList  = getFoodRecipesList()

        val foods = mutableListOf<Food>()
        for (i in foodList.indices){
            foods.add(Food(foodList[i], type = typeList[i], recipe = recipeList[i]))
        }
        return foods
    }
}