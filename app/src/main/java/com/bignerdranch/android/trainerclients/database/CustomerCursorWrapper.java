package com.bignerdranch.android.trainerclients.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.trainerclients.Customer;

import java.util.UUID;

/**
 * Created by joshuawykell on 10/5/17.
 */

public class CustomerCursorWrapper extends CursorWrapper {

    public CustomerCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Customer getCustomer() {
        String uuidString = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.UUID));
        String name = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.CUSTOMERNAME));
        String email = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.EMAIL));
        String phone = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.PHONE));
        String address = getString(getColumnIndex(CustomerDbSchema.CustomerTable.Cols.ADDRESS));

        Customer customer = new Customer(UUID.fromString(uuidString));
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setPhone(Integer.parseInt(phone));
        customer.setName(name);

        return customer;
    }
}
