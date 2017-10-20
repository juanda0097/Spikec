package com.spikec.spikec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ViewCites extends AppCompatActivity {

    private TextView vercitas;
    private DatabaseReference mDatabasereference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cites);
        vercitas = (TextView)findViewById(R.id.ViewCites);
        mDatabasereference = FirebaseDatabase.getInstance().getReference();



        }

    private class Post {
    }
}
