package com.outsourcify.outsourcify;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * ConfirmationActivity represents a view that handles confirmation, both visually and in text.
 * It displays that an error report has gone through, generates additional information and sends it through email.
 *
 * @author Outsourcify
 * @version 1.0
 */
public class ConfirmationActivity extends AppCompatActivity {
    String statusReport;
    String gpsCoordinates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        gpsCoordinates = getGPSLocation();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                statusReport = " ";
            } else {
                statusReport = extras.getString(getString(R.string.report_info));
            }

        } else {
            statusReport = (String) savedInstanceState.getSerializable(getString(R.string.report_info));
        }


        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.visualConfirmationView);
        mImageView.setImageResource(R.drawable.tick);

        TextView recommendedActionView;
        recommendedActionView = (TextView) findViewById(R.id.recommendedActionView);
        CharSequence old = recommendedActionView.getText();
        recommendedActionView.setText(old + "\n" + statusReport);


    }

    /**
     * Handles the intent for sending email with the proper content.
     * @param view
     *      Current view
     */
    protected void sendMail(View view) {
        Log.i("Send email", "");
        String[] TO = {"jakkefaxx@gmail.com"};
        String[] CC = {""};
        
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Felrapportering");
        emailIntent.putExtra(Intent.EXTRA_TEXT, additionalInformation(statusReport));

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ConfirmationActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Gets GPS-location from BusLocationListener, checks if coordinates are avaliable and then returns the information in a sring.
     * @return
     *      The coordinates.
     */
    public String getGPSLocation() {
        String coordinates = "";
        LocationManager mlocManager = null;
        LocationListener mlocListener;
        mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mlocListener = new BusLocationListener();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return "";
        }
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

        if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if(BusLocationListener.latitude>0)
            {
                coordinates="Latitud:- " + BusLocationListener.latitude + "\n";
                coordinates= coordinates + "Longitud:- " + BusLocationListener.longitude + "\n";;
            }
            else
            {
                Toast.makeText(ConfirmationActivity.this, "GPS-position kan inte hittas.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(ConfirmationActivity.this, "GPS är inte aktiverad.", Toast.LENGTH_SHORT).show();
        }
        return coordinates;

    }

    /**
     * Functionality for adding additional information for complete error reporting.
     * @param oldInfo
     *      The string to expand information on.
     * @return
     *      The string with additional information.
     */
    public String additionalInformation(String oldInfo){
        String newInfo = "";
        Random rand = new Random();
        int messageId = rand.nextInt(89999)+10000;
        int busId = rand.nextInt(11)+2030;
        int routeId = 1797;
        int employeeId = rand.nextInt(1400)+500000;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm");
        Date date = new Date();
        String reportDate = dateFormat.format(date);

        newInfo = "ID: "+ Integer.toString(messageId)+"\nPlats: "+ gpsCoordinates+"\nDatum och tid: "+ reportDate+ "\nRapporterad av : "
                + Integer.toString(employeeId)+"\nOmlopp: "+Integer.toString(routeId)+"\nBussID: "+Integer.toString(busId)+ "\n"  + oldInfo;
        return newInfo;
    }

    /**
     * Changes view to MainActivity
     * @param view
     *      Current view
     */
    public void returnHome(View view){
        Intent myIntent = new Intent(ConfirmationActivity.this, MainActivity.class);
        startActivity(myIntent);
    }

    /**
     * Changes view to previous view
     * @param view
     *      Current view
     */
    public void previousActivity(View view){
        finish();
    }
}
