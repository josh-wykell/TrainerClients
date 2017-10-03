package com.bignerdranch.android.trainerclients.database;

/**
 * Created by joshuawykell on 10/2/17.
 */

public class CustomerDbSchema {

    public static final class CustomerTable {
        public static final String NAME = "customers";

        public static final class Cols {
            public static final String UUID ="uuid";
            public static final String CUSTOMERNAME = "customerName";
            public static final String EMAIL = "email";
            public static final String PHONE = "phone";
            public static final String ADDRESS = "address";
        }
    }
}
