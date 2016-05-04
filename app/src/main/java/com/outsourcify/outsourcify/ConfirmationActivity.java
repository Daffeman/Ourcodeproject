package com.outsourcify.outsourcify;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmationActivity extends AppCompatActivity {
    String statusReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);


        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                statusReport = " ";
            } else {
                statusReport = extras.getString("Report Information");
            }

        } else {
            statusReport = (String) savedInstanceState.getSerializable("Report Information");
        }


        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.visualConfirmationView);
        mImageView.setImageResource(R.drawable.tick);

        TextView recommendedActionView;
        recommendedActionView = (TextView) findViewById(R.id.recommendedActionView);
        CharSequence old = recommendedActionView.getText();
        recommendedActionView.setText(old +"\n" + statusReport);

        Button btn1 = (Button)findViewById(R.id.returnButton);
        btn1.setOnClickListener(btnListener);

    }



    private View.OnClickListener btnListener = new View.OnClickListener()
    {
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.returnButton:
                    returnHome(findViewById(R.id.returnButton));
                    break;
                case R.id.previous_activity:
                    previousActivity(findViewById(R.id.previous_activity));
                    break;
                case R.id.return_home:
                    returnHome(findViewById(R.id.return_home));
                    break;
            }
        }
    };

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
        emailIntent.putExtra(Intent.EXTRA_TEXT, statusReport);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ConfirmationActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


    public void returnHome(View view){
        Intent myIntent = new Intent(ConfirmationActivity.this, TemplateActivity.class);
        startActivity(myIntent);
    }

    public void previousActivity(View view){
        finish();
    }
}
