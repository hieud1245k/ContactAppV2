package com.hieuminh.contactappv1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact")
    List<Contact> getAllContact();

//    @Query("SELECT * FROM contact WHERE id IN (:userIds)")
//    List<Contact> loadAllByIds(int[] userIds);

    @Insert
    void insertContacts(Contact... contacts);

    @Delete
    void deleteContact(Contact contact);


}