package com.example.owner.grocerylist.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.owner.grocerylist.Dao.GroceryDao;
import com.example.owner.grocerylist.Entities.GroceryEntity;

@Database(entities = {GroceryEntity.class}, version = 1)
public abstract class GroceryDatabase extends RoomDatabase{

    private final String TAG = "GROCERY_DATABASE";
    private static volatile GroceryDatabase INSTANCE;

    public abstract GroceryDao groceryDao();

    //Use singleton pattern so we don't accidentally create multiple databases
    static GroceryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GroceryDatabase.class) {
                if (INSTANCE == null) {
                    // Create database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GroceryDatabase.class, "grocery_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
