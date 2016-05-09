package com.outsourcify.outsourcify;

//import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

//zelin
public class TemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        ImageButton btn1 = (ImageButton)findViewById(R.id.call_skype);
        btn1.setOnClickListener(btnListener);

    }

    private View.OnClickListener btnListener = new View.OnClickListener()
    {
        public void onClick(View v) {
            switch(v.getId()) {
                default:
                    break;
                case R.id.call_skype:
                    initiateSkypeUri(getApplicationContext(), "skype:daffeman?call");
                    break;
              /*  case R.id.confirmation_test:
                    testConfirmation(findViewById(R.id.confirmation_test));
                    break;*/
            }
        }
    };

    /**
     * Initiate the actions encoded in the specified URI.
     */

    public void initiateSkypeUri(Context myContext, String mySkypeUri) {

        // Make sure the Skype for Android client is installed.
        if (!isSkypeClientInstalled(myContext)) {
            goToMarket(myContext);
            return;
        }

        // Create the Intent from our Skype URI.
        Uri skypeUri = Uri.parse(mySkypeUri);
        Intent myIntent = new Intent(Intent.ACTION_VIEW, skypeUri);

        // Restrict the Intent to being handled by the Skype for Android client only.
        myIntent.setComponent(new ComponentName("com.skype.raider", "com.skype.raider.Main"));
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Initiate the Intent. It should never fail because you've already established the
        // presence of its handler (although there is an extremely minute window where that
        // handler can go away).
        myContext.startActivity(myIntent);

    }

    /*public void testConfirmation(View view){
        Intent myIntent = new Intent(TemplateActivity.this, BusMenu.class);
        startActivity(myIntent);
    }*/

// Determine whether the Skype for Android client is installed on this device.
 public boolean isSkypeClientInstalled(Context myContext) {
 PackageManager myPackageMgr = myContext.getPackageManager();
 try {
 myPackageMgr.getPackageInfo("com.skype.raider", PackageManager.GET_ACTIVITIES);
 }
 catch (PackageManager.NameNotFoundException e) {
 return (false);
 }
 return (true);
 }


// Install the Skype client through the market: URI scheme.

 public void goToMarket(Context myContext) {
 Uri marketUri = Uri.parse("market://details?id=com.skype.raider");
 Intent myIntent = new Intent(Intent.ACTION_VIEW, marketUri);
 myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
 myContext.startActivity(myIntent);

 }
    public void nextView(View view) {
        Intent intent = new Intent(TemplateActivity.this, ConfirmationActivity.class);
        startActivity(intent);

    }

    public void busView(View view) {
        Intent intent = new Intent(TemplateActivity.this, BusMenu.class);// Byt MainActivity2 till Marko och Eriks klass
        startActivity(intent);

    }

   /* private void confirmDialog() { // http://jymden.com/android-simple-confirm-dialog/
        final Context context = this;

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(TemplateActivity.this, ConfirmationActivity.class);
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
    }*/
}
