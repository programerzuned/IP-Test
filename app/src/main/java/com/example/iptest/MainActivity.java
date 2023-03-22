package com.example.iptest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


////        Context context = requireContext().getApplicationContext();
//          WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//          String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
//        String ipAddress = "";
//        try {
//            ipAddress = InetAddress.getLocalHost().getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//// Print the user's IP address to the console
//        Log.d("MainActivity", "User's IP address: " +ipAddress);


        Utils.getIPAddress(true); // IPv4
        String ip=Utils.getIPAddress(true).toString().trim();
        Toast.makeText(this, "sucess"+Utils.getIPAddress(true), Toast.LENGTH_SHORT).show();

        FirebaseDatabase.getInstance().getReference().child("Ip4 Address").push().setValue(ip);
    }

}