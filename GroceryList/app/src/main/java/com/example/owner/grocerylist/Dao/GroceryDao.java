package com.example.owner.grocerylist.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.owner.grocerylist.Entities.GroceryEntity;

import java.util.List;

@Dao
public interface GroceryDao {

    @Insert
    void insert(GroceryEntity grocery);

    @Query("SELECT * FROM grocery_table")
    LiveData<List<GroceryEntity>> getAllGroceries();
}
