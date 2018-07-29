package com.example.mahamud.foodies.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.support.annotation.NonNull;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.example.mahamud.foodies.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    /*private static  final  String DB_NAME = "FoodSqlDb.db";
    /*private static final int DB_VER = 1;*/


    public Database(Context context)

    {
        super(context,"labtestApp",null,2);
    }
    @Override
    public void onCreate (SQLiteDatabase db)
    {
        String sql = "CREATE TABLE order_details(Id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "ProductId TEXT NOT NULL,"+
                "ProductName TEXT NOT NULL,"+

                "Quantity TEXT NOT NULL,"+
                "Price TEXT NOT NULL,"+

                "Discount TEXT);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
        String sql = "DROP TABLE IF EXISTS order_details";
        db.execSQL(sql);
        //onCreate(db);
    }

    public void dbInsert(Order order)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues photographData = getOrderContentValues(order);
        db.insert("order_details",null,photographData);
    }

    @NonNull
    protected ContentValues getOrderContentValues(Order order)
    {
        ContentValues orderData = new ContentValues();
        orderData.put("ProductId",order.getProductId());
        orderData.put("ProductName",order.getProductName());
        orderData.put("Quantity",order.getQuantity());
        orderData.put("Price",order.getPrice());
        orderData.put("Discount",order.getDiscount());


        return orderData;
    }
    public List<Order> getCarts()
    {
        String sql = "SELECT * FROM order_details";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Order> result = new ArrayList<Order>();
        while(c.moveToNext())
        {
            Order order = new Order();
            order.setProductId(c.getString(c.getColumnIndex("ProductId")));
            order.setProductName(c.getString(c.getColumnIndex("ProductName")));
            order.setPrice(c.getString(c.getColumnIndex("Price")));
            order.setQuantity(c.getString(c.getColumnIndex("Quantity")));
            order.setDiscount(c.getString(c.getColumnIndex("Discount")));


            result.add(order);
        }
        c.close();
        return result;
    }

    public void addToCart(Order order)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO order_details (ProductId,ProductName,Quantity,Price,Discount) VALUES ('%s','%s','%s','%s','%s');",
                order.getProductId(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice(),
                order.getDiscount());

    db.execSQL(query);
    }

    public void cleanCart()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM order_details");

        db.execSQL(query);
    }

}

