package com.spikec.spikec;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by Juanda on 15/10/2017.
 */

public class Fireapp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("server/saving-data/fireblog");
    }
}
