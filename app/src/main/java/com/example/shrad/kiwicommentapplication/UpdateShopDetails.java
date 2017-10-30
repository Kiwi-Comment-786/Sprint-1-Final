package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateShopDetails extends AppCompatActivity {


    DatabaseHelper myDb;
    EditText editId;
    EditText editShopName, editRegNo, editPlaceType, editPhoneno, editWebsiteLink;
    EditText editStreetAddress, editRatings;


    Button btnviewAllShopData;
    Button btnUpdateShopData;
    Button signoutBtn;
    Button btnDeleteShopData;

    public static String shop_id;
    private int anInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_shop_details);
        myDb = WelcomePage.myDb;

        editId =(EditText) findViewById(R.id.shopIdTxt);
        editShopName =(EditText) findViewById(R.id.shopNameTxt);
        editRegNo =(EditText) findViewById(R.id.regnoTxt);
        editPlaceType =(EditText) findViewById(R.id.placesTypeText);
        editPhoneno =(EditText) findViewById(R.id.shopPhoneNumberTxt);
        editWebsiteLink =(EditText) findViewById(R.id.shopwebsiteaddressTxt);
        editStreetAddress =(EditText) findViewById(R.id.streetAddress1Txt);
        editRatings =(EditText) findViewById(R.id.ratingsTxt);
        signoutBtn=(Button) findViewById(R.id.signOutBtn);


        Cursor shopData=myDb.getShopsData(LogIn.successLogInShopId);
        while(shopData.moveToNext()){
            editId.setText(shopData.getString(0));
            editShopName.setText(shopData.getString(1));
            editRegNo.setText(shopData.getString(2));
            editPlaceType.setText(shopData.getString(3));
            editPhoneno.setText(shopData.getString(4));
            editWebsiteLink.setText(shopData.getString(5));
            editStreetAddress.setText(shopData.getString(6));
            editRatings.setText(shopData.getString(7));
        }
        editId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //Validation.isValid(editId,"\\d{3}","Id should be min 3 digit & unique",true);
                //shop_id=editId.getText().toString();
            }
        });
        editShopName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                Validation.hasText(editShopName);
            }
        });
        editRegNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                Validation.isValid(editRegNo,"\\d{5}","Enter 5 digit shop id",true);
            }
        });
        editPlaceType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                Validation.hasText(editPlaceType);
            }
        });
        editStreetAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                Validation.hasText(editStreetAddress);
            }
        });
        editShopName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                Validation.hasText(editShopName);
            }
        });

        btnviewAllShopData =(Button) findViewById(R.id.btnViewAllData);
        btnUpdateShopData= (Button) findViewById(R.id.btnUpdateData);
        btnDeleteShopData = (Button) findViewById(R.id.btnDeleteData);

        viewShopOwnerAllData();
        deleteData();
        updateData();

    }

    public void onClicks(View v){
        switch (v.getId()) {
            case R.id.editButton:
                editShopName.setEnabled(true);
                editRegNo.setEnabled(true);
                editPlaceType.setEnabled(true);
                editPhoneno.setEnabled(true);
                editWebsiteLink.setEnabled(true);
                editStreetAddress.setEnabled(true);
                break;
            case R.id.btnUpdateData:
                update();
                break;
            case R.id.signOutBtn:
                openSignOutIntent();
                break;

        }
    }

    public void openSignOutIntent(){
        Intent intent = new Intent(this,Search.class);
        startActivity(intent);
    }

    private void updateData() {
        btnUpdateShopData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updataShopData(editId.getText().toString(),editShopName.getText().toString(),
                        editRegNo.getText().toString(),editPlaceType.getText().toString(),editPhoneno.getText().toString(),
                        editWebsiteLink.getText().toString(), editStreetAddress.getText().toString(),
                        editRatings.getText().toString());
                if(isUpdate==true){
                    Toast.makeText(UpdateShopDetails.this, "Data Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(UpdateShopDetails.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void update(){
        boolean isUpdate = myDb.updataShopData(editId.getText().toString(),editShopName.getText().toString(),
                editRegNo.getText().toString(),editPlaceType.getText().toString(),editPhoneno.getText().toString(),
                editWebsiteLink.getText().toString(), editStreetAddress.getText().toString(),
                editRatings.getText().toString());
        if(isUpdate==true){
            Toast.makeText(UpdateShopDetails.this, "Data Updated", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(UpdateShopDetails.this, "Data Not Updated", Toast.LENGTH_LONG).show();
        }
    }

    private void deleteData() {
        btnDeleteShopData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        deleteShopOwnerData();
                        Integer deletedRows = myDb.deleteShopData(editId.getText().toString());
                        if(deletedRows>0)
                            Toast.makeText(UpdateShopDetails.this,"Shop Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(UpdateShopDetails.this,"Shop Data Not Deleted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


    public void viewShopOwnerAllData() {
        btnviewAllShopData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openShopOwnerDetailsIntent();
                    }
                }
        );
    }

    public  void deleteShopOwnerData(){
        Integer deletedShopRows = myDb.deleteData(editId.getText().toString());
        if(deletedShopRows>0)
            Toast.makeText(UpdateShopDetails.this,"Shop Owner Data Deleted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(UpdateShopDetails.this,"Shop Owner Data Not Deleted",Toast.LENGTH_LONG).show();

    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public void openShopOwnerDetailsIntent(){
        Bundle bundle = new Bundle();
        bundle.putString("shop_id",LogIn.successLogInShopId);
        Intent intent = new Intent(this,UpdateShopOwnerData.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
