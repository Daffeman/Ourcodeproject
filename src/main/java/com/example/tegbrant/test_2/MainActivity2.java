package com.example.tegbrant.test_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(btnListener);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(btnListener);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(btnListener);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(btnListener);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(btnListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void nextView(View view)
    {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);

    }

    private View.OnClickListener btnListener = new View.OnClickListener()
    {
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.button1:
                    nextView(findViewById(R.id.button1));
                case R.id.button2:
                    nextView(findViewById(R.id.button2));
                case R.id.button3:
                    nextView(findViewById(R.id.button3));
                case R.id.button4:
                    nextView(findViewById(R.id.button4));
                case R.id.button5:
                    nextView(findViewById(R.id.button5));

                    break;

            }
        }

    };

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
}

