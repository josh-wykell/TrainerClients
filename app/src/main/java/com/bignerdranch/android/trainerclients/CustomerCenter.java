package com.bignerdranch.android.trainerclients;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.trainerclients.database.CustomerBaseHelper;
import com.bignerdranch.android.trainerclients.database.CustomerCursorWrapper;
import com.bignerdranch.android.trainerclients.database.CustomerDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by joshuawykell on 10/1/17.
 */

public class CustomerCenter {
    private static CustomerCenter sCustomerCenter;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CustomerCenter get(Context context) {

        if (sCustomerCenter == null) {
            sCustomerCenter = new CustomerCenter(context);
        }
        return sCustomerCenter;
    }

    private CustomerCenter(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CustomerBaseHelper(mContext).getWritableDatabase();
    }

    public void addCustomer(Customer c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CustomerDbSchema.CustomerTable.NAME, null, values);
    }

    public List<Customer> getCustomers() {

        List<Customer> customers = new ArrayList<>();

        CustomerCursorWrapper cursor = queryCustomers(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                customers.add(cursor.getCustomer());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return customers;
    }

    public Customer getCustomer(UUID id) {
        CustomerCursorWrapper cursor = queryCustomers(CustomerDbSchema.CustomerTable.Cols.UUID + " = ?",
                new String[] {id.toString()});

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCustomer();
        } finally {
            cursor.close();
        }
    }

    public void updateCustomer(Customer customer) {

        String uuidString = customer.getId().toString();
        ContentValues values = getContentValues(customer);
        mDatabase.update(CustomerDbSchema.CustomerTable.NAME, values, CustomerDbSchema.CustomerTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private CustomerCursorWrapper queryCustomers(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CustomerDbSchema.CustomerTable.NAME,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null,// groupBy
                null, //having
                null // orderBy
        );
        return new CustomerCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Customer customer) {
        ContentValues values = new ContentValues();
        values.put(CustomerDbSchema.CustomerTable.Cols.UUID, customer.getId().toString());
        values.put(CustomerDbSchema.CustomerTable.Cols.CUSTOMERNAME, customer.getName());
        values.put(CustomerDbSchema.CustomerTable.Cols.EMAIL, customer.getEmail());
        values.put(CustomerDbSchema.CustomerTable.Cols.PHONE, Integer.toString(customer.getPhone()));
        values.put(CustomerDbSchema.CustomerTable.Cols.ADDRESS, customer.getAddress());
        return values;
    }
}
