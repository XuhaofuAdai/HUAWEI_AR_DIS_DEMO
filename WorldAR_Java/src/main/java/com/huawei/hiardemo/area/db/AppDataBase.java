package com.huawei.hiardemo.area.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = AppDataBase.NAME,version = AppDataBase.VERSION)
public class AppDataBase {
    public static final String NAME="ARLocation";
    public static final int VERSION=2;
}
