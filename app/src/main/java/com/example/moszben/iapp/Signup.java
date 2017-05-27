package com.example.moszben.iapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import Adapters.SpinnerAdapter;
import Models.Client;

public class Signup extends AppCompatActivity {

    Spinner spinner;
    SpinnerAdapter adapter;
    List<Client> types;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //init
        String type []=getResources().getStringArray(R.array.type);
        types=new ArrayList<Client>();
        Client client1=new Client(type[0]);
        types.add(client1);
        Client client2=new Client(type[1]);
        types.add(client2);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=new SpinnerAdapter(this,R.layout.spinner_item,types);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
    }

    public void onLogin(View v)
    {
        Intent i=new Intent(getApplication(),LoginAct.class);
        finish();
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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
}
