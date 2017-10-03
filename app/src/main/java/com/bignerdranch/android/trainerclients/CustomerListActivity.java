package com.bignerdranch.android.trainerclients;

import android.support.v4.app.Fragment;

/**
 * Created by joshuawykell on 10/1/17.
 */

public class CustomerListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CustomerListFragment();
    }
}
