package com.example.tegbrant.test_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
     //   Button button1 = (Button) findViewById(R.id.button1);
       // button1.setOnClickListener(btnListener);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(btnListener);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(btnListener);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(btnListener);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(btnListener);

        ImageButton imgBus = (ImageButton) findViewById(R.id.imageBus);
        imgBus.setOnClickListener(btnListener);

        ImageButton imgBattery = (ImageButton) findViewById(R.id.imageBattery);
        imgBattery.setOnClickListener(btnListener);

         */

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void nextView(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);

    }

    public void busView(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);// Byt MainActivity2 till Marko och Eriks klass
        startActivity(intent);

    }

    private void confirmDialog() { // http://jymden.com/android-simple-confirm-dialog/
        final Context context = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                })
                .show();
    }

   /** private View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
               // case R.id.button1:
                //    nextView(findViewById(R.id.button1));
                case R.id.button2:
                    nextView(findViewById(R.id.button2));
                case R.id.button3:
                    nextView(findViewById(R.id.button3));
                case R.id.button4:
                    nextView(findViewById(R.id.button4));
                case R.id.button5:
                    nextView(findViewById(R.id.button5));
                case R.id.imageBus:
                    busView(findViewById(R.id.imageBus));
                case R.id.imageBattery:
                    confirmDialog();

                    break;

            }
        }

    };
    **/

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
