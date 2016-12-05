package com.example.ensu4.termproject;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent1 = new Intent(getApplicationContext(),day.class);
                startActivity(intent1);
                return true;
            case R.id.menu2:
                Intent intent2 = new Intent(getApplicationContext(),week.class);
                startActivity(intent2);

                return true;
            case R.id.menu3:
                Intent intent3 = new Intent(getApplicationContext(),month.class);
                startActivity(intent3);

                return true;
            case R.id.menu4:
                Intent intent4 = new Intent(getApplicationContext(),schedule.class);
                startActivity(intent4);

                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }
}
