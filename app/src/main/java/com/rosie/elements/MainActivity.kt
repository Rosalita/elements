package com.rosie.elements

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

val MY_LOCATION_PERMISSIONS = 0
private var locationManager : LocationManager? = null

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Create persistent LocationManager reference
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?

        val button = location_button
        button.setOnClickListener{

            Log.d("TAG", "clicked")
            askForLocationPermission()
            try {
                // Request location updates
                locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener);
            } catch(ex: SecurityException) {
                Log.d("myTag", "Security Exception, no location available");
                location_text_view.setText("Failed to get location")
            }
            location_text_view.setText("Getting location...")
        }

    }

    //define the listener
    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            location_text_view.setText("Lon: " + location.longitude + " Lat: " + location.latitude);
        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }



    fun askForLocationPermission(){
        // check if have permission to access location
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("TAG", "location permission not granted")

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
            {
                // show explanation and try again to request permission
            } else {
                //no explanation needed can request the permission
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MY_LOCATION_PERMISSIONS)

                // MY_PERMISSIONS_REQUESTS are app defined constants the callback gets the result of the request
            }

        } else {
            Log.d("TAG", "location permission is granted")
        }

    }
}
