package com.hieuminh.contactappv1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "contact")
public class Contact implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "mobile")
    private String mobile;
    @ColumnInfo(name = "avatar")
    private String avatar;
    @ColumnInfo(name = "email")
    private String email;

    public Contact(int id, String name, String mobile, String avatar, String email) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.avatar = avatar;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
