package com.example.shrad.kiwicommentapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shrad on 23/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ShopDatabase.db";
    private static final String TABLE_NAME = "ShopOwnerInfoTable";
    private static final String COl_1 = "id";
    private static final String COl_2 = "ownerFirstName";
    private static final String COl_3 = "ownerLastName";
    private static final String COl_4 = "ownerMobileNo";
    private static final String COl_5 = "ownerEmailId";
    private static final String COl_6 = "ownerPassword";
    private static final String COl_7 = "pinNumber";
    private static final String COL_8 = "shop_id";

    private boolean foundData;
    private static String shop_id;
    public  static String loginShopId;
    private static final String TABLE_NAME2 = "ShopDetailsTable";
    private static final String COl2_1 = "shop_id";
    private static final String COl2 = "shopName";
    private static final String COl2_3 = "shopRegNo";
    private static final String COl2_4 = "placesType";
    private static final String COl2_5 = "shopPhoneno";
    private static final String COl2_6 = "shopWebsiteLink";
    private static final String COl2_7 = "shopStreetAddress";
    private static final String COl2_8 = "ratings";

    private static final String tableSql = "CREATE TABLE " + TABLE_NAME + "( id INTEGER PRIMARY KEY AUTOINCREMENT, ownerFirstName TEXT, " +
            "ownerLastName TEXT, ownerMobileNo INTEGER, ownerEmailId TEXT,ownerPassword TEXT, pinNumber INTEGER,shop_id INTEGER) ";
    private static final String table2sql = "CREATE TABLE " + TABLE_NAME2 + "(" + COl2_1 + " INTEGER PRIMARY KEY," +
            "shopName TEXT, shopRegNo INTEGER, placesType TEXT, shopPhoneno INTEGER," +
            "shopWebsiteLink TEXT, shopStreetAddress TEXT,ratings REAL) ";

    private static final String tableSql3 = "CREATE TABLE CommentsTable (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "commentPersonName TEXT, commentRating REAL, commentDesc TEXT, commentShopId INTEGER) ";

    private static final String tableSql4 ="CREATE TABLE ShopImages (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "imgDesc TEXT, image BLOB, shopId INTEGER)";
    /**
     * calling the super DatabaseHelper constructor with our database name & database version.
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase myDb) {
        myDb.execSQL(tableSql);
        myDb.execSQL(table2sql);
        myDb.execSQL(tableSql3);
        myDb.execSQL(tableSql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDb, int i, int i1) {
        myDb.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        myDb.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        myDb.execSQL("DROP TABLE IF EXISTS ShopImages");
        myDb.execSQL("DROP TABLE IF EXISTS CommentsTable");
        onCreate(myDb);
    }

    //Inserts data into ShopOwnersInfoTable
    public boolean insertData(String firstName, String lastName, String mobile_number, String emailID,String password,String pinNumber,String shop_id){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2,firstName);
        contentValues.put(COl_3,lastName);
        contentValues.put(COl_4, mobile_number);
        contentValues.put(COl_5,emailID);
        contentValues.put(COl_6,password);
        contentValues.put(COl_7,pinNumber);
        contentValues.put(COL_8,shop_id);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    //deletes record from shopOwnersInfoTable
    public Integer deleteData(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_NAME,"shop_id = ?",new String[]{id});
    }


    //Receives res object for all data from ShopOwnersInfoTable
    public Cursor getAllData(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME,null);
        if (res.getCount()>0)
            foundData =true;
        else
            foundData=false;
        return  res;
    }

    //Updates data into ShopOwnersInfoTable
    public boolean updataData(String id, String firstName, String lastName, String mobile_number, String emailID,
                             String ownerPassword, String pinNumber ){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_1,id);
        contentValues.put(COl_2,firstName);
        contentValues.put(COl_3,lastName);
        contentValues.put(COl_4, mobile_number);
        contentValues.put(COl_5,emailID);
        contentValues.put(COl_6,ownerPassword);
        contentValues.put(COl_7,pinNumber);
        db.update(TABLE_NAME,contentValues,"id= ?",new String[] {id});
        return true;
    }

    public boolean foundData(){
        return  this.foundData;
    }

    //deletes record from shopDetailsTable
    public Integer deleteShopData(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        return db.delete(TABLE_NAME2,"shop_id = ?",new String[]{id});
    }

    //Updates data into ShopDetailsTable
    public boolean updataShopData(String id,String shopName, String shopRegNo, String shopPlaceType, String shopPhoneNo,
                                  String shopWebsiteLink, String streetAddress, String ratings){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl2_1,id);
        contentValues.put(COl2,shopName);
        contentValues.put(COl2_3,shopRegNo);
        contentValues.put(COl2_4,shopPlaceType);
        contentValues.put(COl2_5,shopPhoneNo);
        contentValues.put(COl2_6,shopWebsiteLink);
        contentValues.put(COl2_7,streetAddress);
        contentValues.put(COl2_8,ratings);

        db.update(TABLE_NAME2,contentValues,"shop_id= ?",new String[] {id});

        return true;
    }

    //Inserts data into ShopDetailsInfoTable
    public boolean insertShopData(String id,String shopName, String shopRegNo, String shopPlaceType, String shopPhoneNo,
                                  String shopWebsiteLink, String streetAddress, String ratings){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl2_1,id);
        contentValues.put(COl2,shopName);
        contentValues.put(COl2_3,shopRegNo);
        contentValues.put(COl2_4,shopPlaceType);
        contentValues.put(COl2_5,shopPhoneNo);
        contentValues.put(COl2_6,shopWebsiteLink);
        contentValues.put(COl2_7,streetAddress);
        contentValues.put(COl2_8,ratings);
        long result = db.insert(TABLE_NAME2,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    //Inserts data into ShopDetailsInfoTable
    public boolean insertShopDataFromAPI(String id,String shopName, String shopRegNo, String shopPlaceType, String shopPhoneNo,
                                         String shopWebsiteLink, String streetAddress,String ratings){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl2_1,id);
        contentValues.put(COl2,shopName);
        contentValues.put(COl2_3,shopRegNo);
        contentValues.put(COl2_4,shopPlaceType);
        contentValues.put(COl2_5,shopPhoneNo);
        contentValues.put(COl2_6,shopWebsiteLink);
        contentValues.put(COl2_7,streetAddress);
        contentValues.put(COl2_8,ratings);
        long result = db.insert(TABLE_NAME2,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }
    //This method gets all the data from the shopdetails table

    public Cursor getAllShopData(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME2,null);
        if (res.getCount()>0)
            foundData =true;
        else
            foundData=false;
        return  res;
    }

    public Cursor getShopData(String placeType){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res=null;
        if(placeType.equals("88")) {
            res = db.rawQuery("Select shop_id,shopName,shopPhoneno,shopWebsiteLink,ratings from " + TABLE_NAME2 + " where placesType IN ( 88, 83)", null);
            if (res.getCount() > 0)
                foundData = true;
            else
                foundData = false;
        } else if(placeType.equals("15") || placeType.equals("Cafe")){
            res = db.rawQuery("Select shop_id,shopName,shopPhoneno,shopWebsiteLink,ratings from " + TABLE_NAME2 + " where placesType = 'Cafe' ", null);
            if (res.getCount() > 0)
                foundData = true;
            else
                foundData = false;
        } else if(placeType.equals("60") || placeType.equals("Restaurant")){
            res = db.rawQuery("Select shop_id,shopName,shopPhoneno,shopWebsiteLink,ratings from " + TABLE_NAME2 + " where placesType = 'Restaurant' OR placesType = '60' ", null);
            if (res.getCount() > 0)
                foundData = true;
            else
                foundData = false;
        }
        return  res;
    }

    public Cursor getShopsDetailData(String shop_id){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("Select  shopName,shopPhoneno,shopWebsiteLink, shopStreetAddress,ratings from "+TABLE_NAME2+" where "+COl2_1+"= "+shop_id+" ",null);
        if (res.getCount()>0)
            foundData =true;
        else
            foundData=false;
        return  res;
    }

    //gets all shop details data for update purpose
    public Cursor getShopsData(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME2+" where "+COl2_1+"= "+id,null);
        if (res.getCount()>0)
            foundData =true;
        else
            foundData=false;
        return  res;
    }

    //Gets all shop owner data for update purpose
    public Cursor getShopOwnersData(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME+" where "+COL_8+"= "+id,null);
        if (res.getCount()>0)
            foundData =true;
        else
            foundData=false;
        return  res;
    }

    public String getShopId(){
        return shop_id;
    }

    public void setShop_id(String shop_id){
        this.shop_id=shop_id;
    }

    public Cursor shopID(String username, String password){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from ShopOwnerInfoTable where " +
                "ownerEmailId = '"+username+"' " +
                "AND ownerPassword = '"+password+"'",null);
        if (res.getCount()>0)
            foundData =true;
        else
            foundData=false;
        return  res;

    }
    // Login
    public String login(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select shop_id,ownerEmailId, ownerPassword from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String Uname, Upass;
        String id="";
        Upass = "not found";
        if(cursor.moveToFirst()){
            do{
                Uname = cursor.getString(1);

                if(Uname.equals(username))
                {
                    Upass = cursor.getString(2);
                    id=cursor.getString(0);
                    break;
                }
            }while (cursor.moveToNext());
        }
        loginShopId=id;
        return Upass;

    }

    public boolean insertComment(Comments aComment){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("commentPersonName ", aComment.getName());
        values.put("commentRating ", aComment.getRating());
        values.put("commentDesc ", aComment.getContent());
        values.put("commentShopId", aComment.getShop_ID());
        long result = db.insert("CommentsTable",null,values);
        if(result == -1)
            return false;
        else
            return true;
    }


}
