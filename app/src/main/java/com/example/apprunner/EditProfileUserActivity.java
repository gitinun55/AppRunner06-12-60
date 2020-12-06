package com.example.apprunner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditProfileUserActivity extends AppCompatActivity {

    EditText edt_FName, edt_LName, edt_Tel, edt_idcard;
    TextView text_bd;
    String gender, first_name, id_user;
    Button btn_bd, btn_submit;
    RadioGroup rd_gender;
    RadioButton selectRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_user);

        edt_FName = findViewById(R.id.FNameEdt);
        edt_LName = findViewById(R.id.LNameEdt);
        edt_Tel = findViewById(R.id.telEdt);
        edt_idcard = findViewById(R.id.idEdt);
        rd_gender = findViewById(R.id.rd_gender);
        text_bd = findViewById(R.id.text_date);
        btn_bd = findViewById(R.id.btn_date);
        btn_submit = findViewById(R.id.btn_edit_profile);

        Calendar calendar_bd = Calendar.getInstance();
        final int year = calendar_bd.get(Calendar.YEAR);
        final int month = calendar_bd.get(Calendar.MONTH);
        final int day = calendar_bd.get(Calendar.DAY_OF_MONTH);

        btn_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        EditProfileUserActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        text_bd.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        rd_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectRadioButton = (RadioButton) findViewById(rd_gender.getCheckedRadioButtonId());
                gender = selectRadioButton.getText().toString();
                Toast.makeText(EditProfileUserActivity.this, gender, Toast.LENGTH_SHORT).show();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FName = edt_FName.getText().toString().trim();
                String LName = edt_LName.getText().toString().trim();
                String Tel = edt_Tel.getText().toString().trim();
                String id_card = edt_Tel.getText().toString().trim();
                String gender = rd_gender.toString().trim();
                String bd = text_bd.getText().toString().trim();
                SecondActivity secondActivity = new SecondActivity();
//                UpdateProfile();
                final Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(secondActivity.url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                OrganizerAPI service = retrofit.create(OrganizerAPI.class);
                Call call = service.edit_ProfileUser(id_user);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Toast.makeText(EditProfileUserActivity.this, "แก้ไขข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
                        openSecondActivity();
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {

                    }
                });
            }
        });
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

//    private void updateprofile() {
//        String FName = edt_FName.getText().toString().trim();
//        String LName = edt_LName.getText().toString().trim();
//        String Tel = edt_Tel.getText().toString().trim();
//        String id_card = edt_Tel.getText().toString().trim();
//        String gender = rd_gender.toString().trim();
//        String bd = text_bd.getText().toString().trim();
//
//        if (FName.isEmpty()) {
//            edt_FName.setError("โปรดกรอกชื่อเพื่อแก้ไขข้อมูล");
//            edt_FName.requestFocus();
//            return;
//        }
//        if (LName.isEmpty()) {
//            edt_LName.setError("โปรดกรอกนามสกุลเพื่อแก้ไขข้อมูล");
//            edt_LName.requestFocus();
//            return;
//        }
//        if (Tel.isEmpty()) {
//            edt_Tel.setError("โปรดกรอกเบอร์โทรศัพท์เพื่อแก้ไขข้อมูล");
//            edt_Tel.requestFocus();
//            return;
//        }
//        if (id_card.isEmpty()) {
//            edt_idcard.setError("โปรดกรอกเลขบัตรประชาชนเพื่อแก้ไขข้อมูล");
//            edt_idcard.requestFocus();
//            return;
//        }
////        if (gender.isEmpty()){
////            rd_gender.setError("โปรดกรอกชื่อเพื่อแก้ไขข้อมูล");
////            edt_FName.requestFocus();
////            return;
////        }
//        if (bd.isEmpty()) {
//            text_bd.setError("โปรดกรอกวันเกิดเพื่อแก้ไขข้อมูล");
//            text_bd.requestFocus();
//            return;
//        }

    }



