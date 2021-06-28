package com.android.food_hub.Helper;

import android.content.Context;
import android.widget.Toast;

import com.android.food_hub.Activity.ShowDetailActivity;
import com.android.food_hub.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagementCard
{
    private Context context;
    private TinyDB tinyDB;

    public ManagementCard(Context context, TinyDB tinyDB) {
        this.context = context;
        this.tinyDB = tinyDB;
    }

    public ManagementCard(Context context) {
    }

    public void insertFood(FoodDomain item)
    {
        ArrayList<FoodDomain> listFood = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i<listFood.size(); i++)
        {
            if(listFood.get(i).getTitle().equals(item.getTitle()))
            {
                existAlready = true;
                n = i;
                break;
            }
        }

        if(existAlready)
        {
            listFood.get(n).setNumberInCard(item.getNumberInCard());
        }else {
            listFood.add(item);
        }

        tinyDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Added to your cart", Toast.LENGTH_LONG).show();
    }



    private ArrayList<FoodDomain> getListCard()
    {
        return tinyDB.getListObject("CardList");
    }
}
