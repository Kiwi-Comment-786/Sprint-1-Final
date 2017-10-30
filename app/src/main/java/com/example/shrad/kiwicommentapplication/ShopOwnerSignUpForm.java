package com.example.shrad.kiwicommentapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShopOwnerSignUpForm extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editfirstName, editLastName, editEmailId, editMobileNo, editId, editPassword,editPinNumber;
    Button btnaddData;
    Button btnviewAll;
    Button btnUpdateData;
    Button btnDeleteData;
    Information[] info;
    String shop_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_owner_sign_up_form);
        myDb = new DatabaseHelper(this);


        editfirstName = (EditText) findViewById(R.id.firstNameTxt);
        editfirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                Validation.hasText(editfirstName);
            }
        });
        editLastName = (EditText) findViewById(R.id.lastNameTxt);
        editLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                Validation.hasText(editLastName);
            }
        });
        editEmailId = (EditText) findViewById(R.id.emailIdTxt);
        editEmailId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                Validation.isEmailAddress(editEmailId,true);
            }
        });
        editMobileNo = (EditText) findViewById(R.id.mobileNumberTxt);
        editMobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                Validation.isPhoneNumber(editMobileNo,true);
            }
        });
        editId = (EditText) findViewById(R.id.idTxt);
        editPassword = (EditText) findViewById(R.id.passwordTxt);
        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Validation.hasText(editPassword);
            }
        });
        editPinNumber = (EditText) findViewById(R.id.pinNumberTxt);
        editPinNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                Validation.isValid(editPinNumber,"\\d{5}","Pin number should be 5-digit",true);
            }
        });

        btnaddData = (Button) findViewById(R.id.btnAddData);
        btnviewAll =(Button) findViewById(R.id.btnViewAllData);
        btnUpdateData= (Button) findViewById(R.id.btnUpdateData);
        btnDeleteData = (Button) findViewById(R.id.btnDeleteData);

        addData();
        viewAll();
        deleteData();
       // updateData();

    }


//    private void updateData() {
//        btnUpdateData.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        boolean isUpdate = myDb.updataData(editId.getText().toString(),
//                                editfirstName.getText().toString(),editLastName.getText().toString(),
//                                editMobileNo.getText().toString(),editEmailId.getText().toString());
//                        if(isUpdate==true){
//                            Toast.makeText(ShopOwnerSignUpForm.this, "Data Updated", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(ShopOwnerSignUpForm.this, "Data Not Updated", Toast.LENGTH_LONG).show();
//                        }
//
//                    }
//                }
//        );
//    }

    private void deleteData() {
        btnDeleteData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows = myDb.deleteData(editId.getText().toString());
                        if(deletedRows>0)
                            Toast.makeText(ShopOwnerSignUpForm.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(ShopOwnerSignUpForm.this,"Data Not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void addData(){
        btnaddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (checkValidation()) {
                            boolean isInserted = myDb.insertData(editfirstName.getText().toString(),
                                    editLastName.getText().toString(), editMobileNo.getText().toString(), editEmailId.getText().toString(),
                                    editPassword.getText().toString(),editPinNumber.getText().toString(),ShopDetailSignUpForm.shop_id);
                            if (isInserted == true) {
                                Toast.makeText(ShopOwnerSignUpForm.this, "Data inserted", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(ShopOwnerSignUpForm.this, "Data Not inserted", Toast.LENGTH_LONG).show();
                            }
                            openNewActivity();
                        }
                    }
                }
        );

    }

    public void openNewActivity(){
        Intent intent = new Intent(this,LogIn.class);
        intent.putExtra("information",info);
        startActivity(intent);
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (!(myDb.foundData())){
                            Toast.makeText(ShopOwnerSignUpForm.this,"No Data found",Toast.LENGTH_LONG).show();
                        }
                        else{
                            if(res.getCount() == 0) {
                                showMessage("Error","Nothing found");
                                return;
                            }

                            StringBuffer buffer = new StringBuffer();
                            int i=0;
                            while (res.moveToNext()) {

                                //info[i]= new Information(res.getString(0),res.getString(1),res.getString(2));
                                buffer.append("Id :"+ res.getString(0)+"\n");
                                buffer.append("First Name :"+ res.getString(1)+"\n");
                                buffer.append("Last Name:"+ res.getString(2)+"\n");
                                buffer.append("Mobile No :"+ res.getString(3)+"\n");
                                buffer.append("Email ID:"+ res.getString(4)+"\n\n");
                                buffer.append("Password:"+ res.getString(5)+"\n\n");
                                buffer.append("Pin number:"+ res.getString(6)+"\n\n");
                                buffer.append("Shop_id:"+ res.getString(7)+"\n\n");
                                i++;
                            }

                            showMessage("Data",buffer.toString());
                        }
                        // openNewActivity();
                    }
                }
        );
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.hasText(editfirstName)) ret = false;
        if (!Validation.isEmailAddress(editEmailId, true)) ret = false;
        if (!Validation.isPhoneNumber(editMobileNo, false)) ret = false;

        return ret;
    }

    public String getShopID() {
        return shop_id;
    }

    public void setShopID(){
        this.shop_id=ShopDetailSignUpForm.getShopIdFromDetailsForm();
    }
}
