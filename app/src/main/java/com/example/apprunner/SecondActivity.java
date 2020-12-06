package com.example.apprunner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String first_name,last_name,type;
    int id_user;

    public static final String url = "http://10.0.2.2:3000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.toolbar_user);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_user);
        navigationView = findViewById(R.id.nav_view_user);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer_user,new SecondFragment());
        fragmentTransaction.commit();

        Bundle bundle = new Bundle();
        bundle.putInt("id_user", getIntent().getExtras().getInt("id_user"));
        bundle.putString("first_name", getIntent().getExtras().getString("first_name"));
        bundle.putString("last_name",getIntent().getExtras().getString("last_name"));
        bundle.putString("type",getIntent().getExtras().getString("type"));
        bundle.putString("email", getIntent().getExtras().getString("email"));
        bundle.putString("password",getIntent().getExtras().getString("password"));
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_user,secondFragment).commit();

        first_name = getIntent().getExtras().getString("first_name");
        last_name = getIntent().getExtras().getString("last_name");
        type = getIntent().getExtras().getString("type");
        id_user = getIntent().getExtras().getInt("id_user");
        //Toast.makeText(SecondActivity.this, Integer.toString(id_user), Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        Bundle bundle = new Bundle();
        bundle.putString("first_name", first_name);
        bundle.putString("last_name",last_name);
        bundle.putString("type",type);
        bundle.putInt("id_user",id_user);
        if(item.getItemId() == R.id.home) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer_user,new SecondFragment());
            fragmentTransaction.commit();
            SecondFragment secondFragment = new SecondFragment();
            secondFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_user,secondFragment).commit();
        }

        if(item.getItemId() == R.id.event) {
            Intent intent = new Intent(SecondActivity.this, MenuEventUser.class);
            intent.putExtra("first_name", first_name);
            intent.putExtra("last_name",last_name);
            intent.putExtra("type",type);
            intent.putExtra("id_user",id_user);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.submit_payment) {
            Intent intent = new Intent(SecondActivity.this, SelectPaymentUserActivity.class);
            intent.putExtra("first_name", first_name);
            intent.putExtra("last_name",last_name);
            intent.putExtra("type",type);
            intent.putExtra("id_user",id_user);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.status_payment) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer_user,new StatusPaymentUserFragment());
            fragmentTransaction.commit();
            StatusPaymentUserFragment statusPaymentUserFragment = new StatusPaymentUserFragment();
            statusPaymentUserFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_user,statusPaymentUserFragment).commit();
        }

        if(item.getItemId() == R.id.uplodestatistics) {
            Intent intent = new Intent(SecondActivity.this, EventProfileUplodeActivity.class);
            intent.putExtra("first_name", first_name);
            intent.putExtra("last_name",last_name);
            intent.putExtra("type",type);
            intent.putExtra("id_user",id_user);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.edit_address) {
            Intent intent = new Intent(SecondActivity.this, EditProfileUserActivity.class);
            intent.putExtra("first_name", first_name);
            intent.putExtra("last_name",last_name);
            intent.putExtra("type",type);
            intent.putExtra("id_user",id_user);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.edit_profile) {
            Intent intent = new Intent(SecondActivity.this, EditProfileUserActivity.class);
            intent.putExtra("first_name", first_name);
            intent.putExtra("last_name",last_name);
            intent.putExtra("type",type);
            intent.putExtra("id_user",id_user);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.statistics_event) {
            Intent intent = new Intent(SecondActivity.this, ShowDistanceEventActivity.class);
            intent.putExtra("first_name", first_name);
            intent.putExtra("last_name",last_name);
            intent.putExtra("type",type);
            intent.putExtra("id_user",id_user);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.status_reward) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer_user,new CheckStatusRewardFragment());
            fragmentTransaction.commit();
            CheckStatusRewardFragment checkStatusRewardFragment = new CheckStatusRewardFragment();
            checkStatusRewardFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_user,checkStatusRewardFragment).commit();
        }

        if(item.getItemId() == R.id.help) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer_user,new HelpFragment());
            fragmentTransaction.commit();
            HelpFragment helpFragment = new HelpFragment();
            helpFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_user,helpFragment).commit();
        }

        if(item.getItemId() == R.id.logout) {
            Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        return true;
    }
}