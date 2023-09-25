package com.example.dowchemicalapp;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dowchemicalapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }


    public class DictionaryExample {
        public void main(String[] args) {
            // Create a new dictionary
            Map<String, Dictionary> projectDict = new HashMap<>();
            Map<String, String[]> project1 = new HashMap<>();
            String[] Creator = {"Jim","jimbo@gmail"};
            String[] Description = {"blah blah"};
            String[] Coworkers = {"Sarah","George"};
            String[] Email = {"ssaheley@gmail.com","georgebruh@gmail.com"};
            String[] Dates = {"9/1/2000"};
            project1.put("Creator", Creator);
            project1.put("Description", Description);
            project1.put("Coworkers", Coworkers);
            project1.put("Email", Email);
            project1.put("Dates", Dates);

        }
    }


    public void sendEmail(){

        Intent savedIS = new Intent(this, EmailSender.class);
        savedIS.putExtra("recipientEmail", "rex.ramza@sstx.org");
        savedIS.putExtra("messageBody", "messageBody");
        savedIS.putExtra("subject", "subject");
        startActivity(savedIS);


        EmailSender.sendEmail(new MainActivity(), "rex.ramza@sstx.org", "email","email is successful");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}