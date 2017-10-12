package com.bignerdranch.android.trainerclients;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

/**
 * Created by joshuawykell on 10/1/17.
 */

public class CustomerListFragment extends Fragment {

    private RecyclerView mCustomerRecyclerView;
    private CustomerAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_list, container, false);
        mCustomerRecyclerView = (RecyclerView) view.findViewById(R.id.customer_recycler_view);
        mCustomerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_customer_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_customer:
                Customer customer = new Customer();
                CustomerCenter.get(getActivity()).addCustomer(customer);
                Intent intent = CustomerActivity.newIntent(getActivity(), customer.getId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        CustomerCenter customerCenter = CustomerCenter.get(getActivity());
        List<Customer> customers = customerCenter.getCustomers();
        if (mAdapter == null) {
            mAdapter = new CustomerAdapter(customers);
            mCustomerRecyclerView.setAdapter(mAdapter);
        } else {
//            mAdapter.setCustomers(customers);
            mAdapter.notifyDataSetChanged();
        }

    }

    private class CustomerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Customer mCustomer;
        private TextView mCustomerNameView;

        public CustomerHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_customer, parent, false));

            itemView.setOnClickListener(this);

            mCustomerNameView = (TextView) itemView.findViewById(R.id.customer_name);
        }

        @Override
        public void onClick(View view) {
            Intent intent = CustomerActivity.newIntent(getActivity(), mCustomer.getId());
            startActivity(intent);

        }

        public void bind(Customer customer) {
            mCustomer = customer;
            mCustomerNameView.setText(mCustomer.getName());
        }
    }

    private class CustomerAdapter extends RecyclerView.Adapter<CustomerHolder> {

        private List<Customer> mCustomers;

        public CustomerAdapter(List<Customer> customers) {
            mCustomers = customers;
        }

        @Override
        public CustomerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CustomerHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CustomerHolder holder, int position) {
            Customer customer = mCustomers.get(position);
            holder.bind(customer);

        }

        @Override
        public int getItemCount() {
            return mCustomers.size();
        }

//        public void setCustomers(List<Customer> customers) {
//            mCustomers = customers;
//        }
    }
}
