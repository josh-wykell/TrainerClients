package com.bignerdranch.android.trainerclients;

import java.io.File;
import java.util.UUID;

/**
 * Created by joshuawykell on 10/1/17.
 */

public class Customer {
    private UUID mId;
    private String mName;
    private String mEmail;
    private String mAddress;
    private int mPhone;
    private File mImage;

    public Customer() {
        mId = UUID.randomUUID();

    }

    public UUID getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public int getPhone() {
        return mPhone;
    }

    public void setPhone(int phone) {
        mPhone = phone;
    }

    public File getImage() {
        return mImage;
    }

    public void setImage(File image) {
        mImage = image;
    }
}
