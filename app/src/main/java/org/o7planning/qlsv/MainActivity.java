package org.o7planning.qlsv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.o7planning.qlsv.database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtAddress;
    private EditText edtSex;
    private EditText edtMath;
    private EditText edtPhysical;
    private EditText edtChemistry;
    private EditText edtGrade;
    private Button btnAddUser;
    private RecyclerView rcvUser;

    private userAdapter userAdapter;
    private List<user> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        userAdapter = new userAdapter();
        mListUser = new ArrayList<>();
        userAdapter.setData(mListUser);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setAdapter(userAdapter);
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();

            }
        });
    }


    private void initUi(){
        edtUsername = findViewById(R.id.edt_username);
        edtAddress = findViewById(R.id.edt_address);
        btnAddUser = findViewById(R.id.btn_add_user);
        edtChemistry = findViewById(R.id.edt_chemistry);
        edtMath = findViewById(R.id.edt_math);
        edtPhysical = findViewById(R.id.edt_physical);
        edtSex = findViewById(R.id.edt_sex);
        edtGrade = findViewById(R.id.edt_grade);
        rcvUser = findViewById(R.id.rcv_user);

    }
    private void addUser() {
        String strUsername = edtUsername.getText().toString().trim();
        String strAddress = edtAddress.getText().toString().trim();
        String strChemistry = edtChemistry.getText().toString().trim();
        String strMath = edtMath.getText().toString().trim();
        String strPhysical = edtPhysical.getText().toString().trim();
        String strGrade = edtGrade.getText().toString().trim();
        String strSex = edtSex.getText().toString().trim();
        if(TextUtils.isEmpty(strUsername) || TextUtils.isEmpty(strAddress)
                || TextUtils.isEmpty(strGrade) || TextUtils.isEmpty(strSex) || TextUtils.isEmpty(strMath)
                || TextUtils.isEmpty(strPhysical) || TextUtils.isEmpty(strChemistry))
        {
            return;
        }
        user user = new user(strUsername,strAddress,strSex,strGrade,strChemistry,strMath,strPhysical);
        UserDatabase.getInstance(this).userDAO().insertUser(user);
        Toast.makeText(this, "Add user successfully", Toast.LENGTH_SHORT).show();
        edtUsername.setText("");
        edtAddress.setText("");
        edtGrade.setText("");
        edtSex.setText("");
        edtPhysical.setText("");
        edtMath.setText("");
        edtChemistry.setText("");

        hideSoftKeyboard();

        mListUser = UserDatabase.getInstance(this).userDAO().getListUser();
        userAdapter.setData(mListUser);
    }
    public void hideSoftKeyboard(){
        try{
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow((getCurrentFocus().getWindowToken()),0);
        } catch (NullPointerException ex){
            ex.printStackTrace();
    }
    }
}