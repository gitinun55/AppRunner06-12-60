package com.example.apprunner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Select_event_paymentActivity extends AppCompatActivity {

    String first_name, last_name, type, name_organizer;
    int id_user;
    RecyclerView recycleview_select_event_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_event_payment);

        name_organizer = getIntent().getExtras().getString("name_organizer");
        first_name = getIntent().getExtras().getString("first_name");
        last_name = getIntent().getExtras().getString("last_name");
        type = getIntent().getExtras().getString("type");
        id_user = getIntent().getExtras().getInt("id_user");

        Refresh();
        Event_Payment();
    }

    private void Event_Payment() {
        MainActivity mainActivity = new MainActivity();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mainActivity.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OrganizerAPI services = retrofit.create(OrganizerAPI.class);
        Call<List<ResultQuery>> call = services.event_organizer(id_user);
        call.enqueue(new Callback<List<ResultQuery>>() {
            @Override
            public void onResponse(Call<List<ResultQuery>> call, Response<List<ResultQuery>> response) {
                List<ResultQuery> resultQueries = (List<ResultQuery>) response.body();
                recycleview_select_event_payment = (RecyclerView) findViewById(R.id.recycler_view_eventpayment_organizer);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Select_event_paymentActivity.this);
                recycleview_select_event_payment.setLayoutManager(layoutManager);
                Select_event_paymentAdapter adapter = new Select_event_paymentAdapter(Select_event_paymentActivity.this, resultQueries);
                recycleview_select_event_payment.setAdapter(adapter);
                Toast.makeText(Select_event_paymentActivity.this,"งานวิ่งของคุณ",Toast.LENGTH_SHORT).show();
                Toast.makeText(Select_event_paymentActivity.this,Integer.toString(resultQueries.size()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ResultQuery>> call, Throwable t) {
                Toast.makeText(Select_event_paymentActivity.this,"ไม่พบงานวิ่งของคุณ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Refresh() {
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshlayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Stop animation (This will be after 3 seconds)
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }
}