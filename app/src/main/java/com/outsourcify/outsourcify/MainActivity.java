package com.outsourcify.outsourcify;
import java.util.ArrayList;

import android.app.DialogFragment;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
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
    public static String [] prgmNameList={"Försening","Laddstation","Sittplatser","Motorfel","Yttre skada","Klimat","Biljett","Dörr","Övrigt","  ","Trafikledning"};
    public static int [] prgmImages={
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
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));
    }

}

