package com.outsourcify.outsourcify;
    import android.location.Location;
    import android.location.LocationListener;
    import android.os.Bundle;

/**
 * BusLocationListener provides functionality for getting coordinates.
 *
 * @author Ratan from http://webdesignergeeks.com/
 * @version 1.0
 */
    class BusLocationListener implements LocationListener {

        public static double latitude;
        public static double longitude;

    /**
     * Gets the latitude and longitude and stores them.
     * @param loc
     *      The location
     */
        @Override
        public void onLocationChanged(Location loc)
        {
            loc.getLatitude();
            loc.getLongitude();
            latitude=loc.getLatitude();
            longitude=loc.getLongitude();
        }

        @Override
        public void onProviderDisabled(String provider)
        {
            //print "Currently GPS is Disabled";
        }
        @Override
        public void onProviderEnabled(String provider)
        {
            //print "GPS got Enabled";
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {
        }
    }

