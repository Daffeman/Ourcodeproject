package com.outsourcify.outsourcify;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

/**
 * The MainActivity is the launching view of the application
 * and displays a grid for error reporting
 *
 * @author Outsourcify
 * @version 1.0
 *
 *
 */
public class MainActivity extends Activity {
    GridView gv;
    String busID;
    Context context = MainActivity.this ;
    public int []  prgmNameList  = {R.string.delay, R.string.charge,
            R.string.seating,R.string.engine,
            R.string.exterior, R.string.heating,
            R.string.ticket, R.string.door,
            R.string.other,R.string.blank, R.string.traffic_control};
    {};
    public int [] prgmImages={
            R.drawable.late, R.drawable.recharge,
            R.drawable.seat,
            R.drawable.engine, R.drawable.bus_exterior,
            R.drawable.heating, R.drawable.ticket,
            R.drawable.door,R.drawable.other, R.drawable.empty, R.drawable.call};

    /**
     * This method initializes the view.
     * @param savedInstanceState
     *          the state of the application
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView) findViewById(R.id.gridView);

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder
                .setTitle("Ange bussens ID")
                .setView(input)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        busID = input.getText().toString();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
*/


        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

    }

}

