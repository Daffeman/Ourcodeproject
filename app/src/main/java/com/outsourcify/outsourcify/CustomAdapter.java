package com.outsourcify.outsourcify;


import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

/**
 * CustomAdapter handles the on-click logic for the gridView in MainActivity.
 *
 * @author Outsourcify
 * @version 1.0
 */
public class CustomAdapter extends BaseAdapter{
    String [] timeChoices = {"0-5","6-10","10+"} ;
    String [] locationChoices = {"Fram","Mitten","Bak"};
    String [] fullnessChoices = {"Nästan full","Överfull"};
    String statusReport = "";
    String [] result;
    Context context;
    String text = "";
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /**
     * Counts the number of problems in the grid and returns them.
     * @return
     *      The array length of result.
     */
    @Override
    public int getCount() {
        return result.length;
    }

    /**
     * Returns the position of the button in the grid.
     * @param position
     *      The position in the grid.
     * @return
     *      Position
     */
    @Override
    public Object getItem(int position) {
        return position;
    }

    /**
     * Returns the position of the button in the grid.
     * @param position
     *      The position in the grid.
     * @return
     *      Position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * A class for holding TextView and ImageView
     */
    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    /**
     * Changes report message based on position of button in grid
     * @param position
     *      The position in the grid
     * @return
     *      The message
     */
    public String getMessage(int position){
        String message = "";
        switch(position){
            case 0:
                message = context.getString(R.string.message_late);
                break;
            case 1:
                message = context.getString(R.string.message_recharge);
                break;
            case 2:
                message = context.getString(R.string.message_seats);
                break;
            case 3:
                message = context.getString(R.string.message_engine);
                break;
            case 4:
                message = context.getString(R.string.message_exterior);
                break;
            case 5:
                message = context.getString(R.string.message_heat);
                break;
            case 6:
                message = context.getString(R.string.message_ticket);
                break;
            case 7:
                message = context.getString(R.string.message_door);
                break;
            case 8:
                message = context.getString(R.string.message_other);
                break;
            case 10:
                message = context.getString(R.string.message_call);
                break;
            default:
                break;
        }

        return message;
    }


    /**
     * Determines content in dialog window based on position in grid, shows dialog, determines information to send to confirmationView and finally redirects there.
     * @param position
     *      The position in the grid
     */
    public void showDialog(final int position){
        final String problem = result[position];
        if(position == 0 ){
        new AlertDialog.Builder(context)

                .setTitle(problem)

                .setItems(timeChoices, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case 0 :
                                statusReport = timeChoices[0];
                                break;
                            case 1 :
                                statusReport = timeChoices[1];
                                break;
                            case 2 :
                                statusReport = timeChoices[2];
                                break;
                            default:
                                break;

                        }


                        Toast.makeText(context, "Delayed by "+statusReport+" minutes", Toast.LENGTH_LONG).show();
                        statusReport = " "+ problem+": "+statusReport+" minuter försenad";
                        Intent myIntent = new Intent(context, ConfirmationActivity.class);
                        myIntent.putExtra("Report Information","FelID: " + position + "\n Beskrivning: " +statusReport );
                        context.startActivity(myIntent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    else if (position == 2){
            new AlertDialog.Builder(context)

                    .setTitle(problem)

                    .setItems(fullnessChoices, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                case 0 :
                                    statusReport = fullnessChoices[0];
                                    break;
                                case 1 :
                                    statusReport = fullnessChoices[1];
                                    break;
                                default:
                                    break;

                            }


                            statusReport = " "+ problem+": "+statusReport;
                            Intent myIntent = new Intent(context, ConfirmationActivity.class);
                            myIntent.putExtra("Report Information","FelID: " + position + "\n Beskrivning: "+ statusReport);
                            context.startActivity(myIntent);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }
        else if (position == 6 || position == 7){
            new AlertDialog.Builder(context)

                    .setTitle(problem)

                    .setItems(locationChoices, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch(which){
                                case 0 :
                                    statusReport = locationChoices[0];
                                    break;
                                case 1 :
                                    statusReport = locationChoices[1];
                                    break;
                                case 2 :
                                    statusReport = locationChoices[2];
                                    break;
                                default:
                                    break;

                            }


                            statusReport = " "+ problem+": "+statusReport;
                            Intent myIntent = new Intent(context, ConfirmationActivity.class);
                            myIntent.putExtra("Report Information","FelID: " + position + "\n Beskrivning: "+ statusReport);
                            context.startActivity(myIntent);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (position == 8){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            final EditText input = new EditText(context);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder
                    .setTitle(result[position])
                    .setMessage(getMessage(position))
                    .setView(input)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            text = input.getText().toString();
                            statusReport = "" + problem +": " + text;
                            Intent myIntent = new Intent(context, ConfirmationActivity.class);
                            myIntent.putExtra("Report Information","FelID: " + position + "\nBeskrivning: "+ statusReport);
                            context.startActivity(myIntent);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else if (position == 9){
            //do nothing
        }


        else if (position == 10){
            new AlertDialog.Builder(context)
                    .setTitle(result[position])
                    .setMessage(getMessage(position))
                    .setPositiveButton(R.string.call, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            initiateSkypeUri(context, "skype:daffeman?call");
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }
        else{
            new AlertDialog.Builder(context)
                    .setTitle(result[position])
                    .setMessage(getMessage(position))
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(context, ConfirmationActivity.class);
                        myIntent.putExtra("Report Information","FelID: " + position + "\n Beskrivning: "+ problem);
                        context.startActivity(myIntent);
                    }
                })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

    }

    /**
     * Verifies that skype is installed and launches skype call if installed
     * @param myContext
     *      The context
     * @param mySkypeUri
     *      The Skype URI
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

    /**
     * Determine whether the Skype for Android client is installed on this device.
     * @param myContext
     *      The context
     * @return
     *      true if skype is installed, false otherwise
     */
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


    /**
     * Redirect to Skype on market, through the market URI scheme.
     * @param myContext
     *      The context
     */
    public void goToMarket(Context myContext) {
        Uri marketUri = Uri.parse("market://details?id=com.skype.raider");
        Intent myIntent = new Intent(Intent.ACTION_VIEW, marketUri);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myContext.startActivity(myIntent);

    }

    /**
     * Adds onclick functionality to view for grid
     * @param position
     *      The position in the grid
     * @param convertView
     *      View to apply onclick listener to
     * @param parent
     *      Parent view
     * @return
     *      The view
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.problemlist, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(position);
                ;
            }
        });

        return rowView;
    }

}