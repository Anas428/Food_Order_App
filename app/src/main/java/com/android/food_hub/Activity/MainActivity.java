package com.android.food_hub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.android.food_hub.Adapter.CategoryAdapter;
import com.android.food_hub.Adapter.PopularAdapter;
import com.android.food_hub.Domain.CategoryDomain;
import com.android.food_hub.Domain.FoodDomain;
import com.android.food_hub.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        RecyclerViewPopular();
    }

    private void RecyclerViewPopular()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView1);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> FoodList = new ArrayList<>();
        FoodList.add(new FoodDomain("Pepperoni Pizza", "pizza1", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 9.76));
        FoodList.add(new FoodDomain("Cheese Burger", "burger", "beef, Gouda Cheese, Special sauce, Lettuce, tomato", 8.76));
        FoodList.add(new FoodDomain("Vegetable Pizza", "pizza2", "olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 11.24));

        adapter2 = new PopularAdapter(FoodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView2);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}