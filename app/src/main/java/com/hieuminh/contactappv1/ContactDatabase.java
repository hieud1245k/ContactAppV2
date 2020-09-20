package com.hieuminh.contactappv1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class},version = 1)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
    public static ContactDatabase instance;

    public static ContactDatabase getInstance(Context mcontext) {
        if(instance == null) {
            instance = Room.databaseBuilder(mcontext,
                    ContactDatabase.class, "database-name").build();
        }
        return instance;
    }
}
