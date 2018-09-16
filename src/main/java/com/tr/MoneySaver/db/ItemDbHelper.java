package com.tr.MoneySaver.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tr.MoneySaver.model.Item;
import com.tr.expenses.BuildConfig;
import com.tr.expenses.R;

import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class ItemDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "items.db";

    // Schema is kept simple and somewhat denormalised.
    private static final String CREATE_ITEM_SUBTYPE = "CREATE TABLE "
            + ItemContract.ItemSubtype.TABLE_NAME + "("
            + ItemContract.ItemSubtype._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ItemContract.ItemSubtype.COLUMN_ITEM_TYPE + " INTEGER NOT NULL, "
            + ItemContract.ItemSubtype.COLUMN_SUBTYPE + " TEXT NOT NULL UNIQUE);";
    private Context context;
    private static final String CREATE_ITEM = "CREATE TABLE "
            + ItemContract.Item.TABLE_NAME + "("
            + ItemContract.Item._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ItemContract.Item.COLUMN_TYPE + " INTEGER NOT NULL, "
            + ItemContract.Item.COLUMN_SUBTYPE + " TEXT NOT NULL, "
            + ItemContract.Item.COLUMN_AMOUNT + " INTEGER NOT NULL, "
            + ItemContract.Item.COLUMN_TIME_STAMP + " INTEGER NOT NULL, "
            + ItemContract.Item.COLUMN_DESCRIPTION + " TEXT);";

    @Inject
    ItemDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context.getApplicationContext();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ITEM_SUBTYPE);
        db.execSQL(CREATE_ITEM);

        populateItemSubtype(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void populateItemSubtype(SQLiteDatabase writableDb) {

        final String[] expenseTypes = this.context.getResources().getStringArray(R.array.expense_items_array);
        final String[] incomeType = this.context.getResources().getStringArray(R.array.income_items_array);
        Arrays.sort(expenseTypes);
        Arrays.sort(incomeType);

        insertItemSubtypes(writableDb, Item.TYPE_EXPENSE, expenseTypes);
        insertItemSubtypes(writableDb, Item.TYPE_INCOME, incomeType);
    }

    private static void insertItemSubtypes(SQLiteDatabase writableDb, int type, String[] subtypes) {
        ContentValues values = new ContentValues();
        for (String subtype : subtypes) {
            values.put(ItemContract.ItemSubtype.COLUMN_ITEM_TYPE, type);
            values.put(ItemContract.ItemSubtype.COLUMN_SUBTYPE, subtype);
            writableDb.insertOrThrow(ItemContract.ItemSubtype.TABLE_NAME, null, values);
        }
    }
}