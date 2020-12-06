package com.example.apprunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailEventUserActivity extends AppCompatActivity {
    TextView tv_event_name,tv_date_start,tv_detail,tv_date_end;
    String name_event,detail,type,name_producer;
    String date_reg_start,date_reg_end,pic_event;
    Button btn_register;
    ImageView imageView_user;
    int id_add,id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event_user);

        imageView_user = (ImageView) findViewById(R.id.imageView_user);
        tv_event_name = (TextView) findViewById(R.id.tv_event_name_user);
        tv_date_start = (TextView) findViewById(R.id.tv_date_start_user);
        tv_date_end = (TextView) findViewById(R.id.tv_date_end_user);
        tv_detail = (TextView) findViewById(R.id.tv_detail_user);


        pic_event = getIntent().getExtras().getString("pic_event");
        name_event = getIntent().getExtras().getString("name_event");
        date_reg_start = getIntent().getExtras().getString("date_reg_start");
        date_reg_end = getIntent().getExtras().getString("date_reg_end");
        detail = getIntent().getExtras().getString("detail");
        type = getIntent().getExtras().getString("type");
        id_add = getIntent().getExtras().getInt("id_add");
        id_user = getIntent().getExtras().getInt("id_user");
        name_producer = getIntent().getExtras().getString("name_producer");
        //Toast.makeText(DetailEventUserActivity.this,pic_event, Toast.LENGTH_SHORT).show();

        Picasso.with(DetailEventUserActivity.this).load(pic_event).into(imageView_user);
        tv_event_name.setText(name_event);
        tv_date_start.setText(date_reg_start);
        tv_date_end.setText(date_reg_end);
        tv_detail.setText(detail);
        btn_register = (Button) findViewById(R.id.btn_register);
        if(type != null && type.equals("นักวิ่ง")){
            btn_register.setText("สมัครงาน");
        }
        if(type != null && type.equals("ผู้จัดกิจกรรม")){
            btn_register.setText("รายขื่อนักวิ่ง");
        }
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type != null && type.equals("นักวิ่ง")) {
                    Intent intent = new Intent(DetailEventUserActivity.this, RegEventActivity.class);
                    intent.putExtra("id_user", id_user);
                    intent.putExtra("first_name", getIntent().getExtras().getString("first_name"));
                    intent.putExtra("last_name", getIntent().getExtras().getString("last_name"));
                    intent.putExtra("type", getIntent().getExtras().getString("type"));
                    intent.putExtra("pic_event", pic_event);
                    intent.putExtra("id_add", id_add);
                    intent.putExtra("name_event", name_event);
                    intent.putExtra("name_producer", name_producer);
                    startActivity(intent);
                }
                if (type != null && type.equals("ผู้จัดกิจกรรม")) {

                }
            }
        });
    }
}