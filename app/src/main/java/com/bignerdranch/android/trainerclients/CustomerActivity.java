package com.bignerdranch.android.trainerclients;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class CustomerActivity extends SingleFragmentActivity {

    public static final String EXTRA_CUSTOMER_ID = "com.bignerdranch.android.trainerclients.customer_id";

    public static Intent newIntent(Context packageContext, UUID customerId) {
        Intent intent = new Intent(packageContext, CustomerActivity.class);
        intent.putExtra(EXTRA_CUSTOMER_ID, customerId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new CustomerFragment();
    }
}
