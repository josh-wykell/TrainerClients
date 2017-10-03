package com.bignerdranch.android.trainerclients;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by joshuawykell on 10/1/17.
 */

public class CustomerCenter {
    private static CustomerCenter sCustomerCenter;

    private List<Customer> mCustomers;

    public static CustomerCenter get(Context context) {

        if (sCustomerCenter == null) {
            sCustomerCenter = new CustomerCenter(context);
        }
        return sCustomerCenter;
    }

    private CustomerCenter(Context context) {
        mCustomers = new ArrayList<>();
//        for (int i = 0; i < 50; i ++) {
//            Customer customer = new Customer();
//            customer.setName("Customer " + i);
//            customer.setPhone((int)((Math.random() * 9000000) + 1000000));
//            customer.setEmail("customer" + i + "@gmail.com");
//            customer.setAddress((Integer.toString(((int)((Math.random() * 9000) + 1000)))) + "Central Ave.");
//            mCustomers.add(customer);
//        }
    }

    public void addCustomer(Customer c) {
        mCustomers.add(c);
    }

    public List<Customer> getCustomers() {
        return mCustomers;
    }

    public Customer getCustomer(UUID id) {
        for (Customer customer : mCustomers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }
}
