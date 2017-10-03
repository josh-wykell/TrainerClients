package com.bignerdranch.android.trainerclients;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by joshuawykell on 10/1/17.
 */

public class CustomerFragment extends Fragment {
    private Customer mCustomer;
    private EditText mCustomerName;
    private EditText mCustomerEmail;
    private EditText mCustomerPhone;
    private EditText mCustomerAddress;
    private Button mCustomerSave;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID customerId = (UUID) getActivity().getIntent().getSerializableExtra(CustomerActivity.EXTRA_CUSTOMER_ID);
        mCustomer = CustomerCenter.get(getActivity()).getCustomer(customerId);
    }

    @Override
    public void onPause() {
        super.onPause();
        CustomerCenter.get(getActivity()).updateCustomer(mCustomer);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_customer, container, false);

        mCustomerSave = (Button) v.findViewById(R.id.customer_save);
        mCustomerSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CustomerListActivity.class);
                startActivity(intent);
            }
        });

        mCustomerName = (EditText) v.findViewById(R.id.customer_name);
        mCustomerName.setText(mCustomer.getName());
        mCustomerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCustomerEmail = (EditText) v.findViewById(R.id.customer_email);
        mCustomerEmail.setText(mCustomer.getEmail());
        mCustomerEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCustomerPhone = (EditText) v.findViewById(R.id.customer_phone);
        mCustomerPhone.setText(Integer.toString(mCustomer.getPhone()));
        mCustomerPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setPhone(Integer.parseInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCustomerAddress = (EditText) v.findViewById(R.id.customer_address);
        mCustomerAddress.setText(mCustomer.getAddress());
        mCustomerAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        return v;
    }
}



