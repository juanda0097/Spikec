package com.spikec.spikec;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Button portal,animalvet,veterinariaoasis,veterinariamimaskota,agroveterinariamispotrillos,maceo,animalhouse,agroveterinariahojarasca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        animalvet = (Button)findViewById(R.id.btnanimalvet);
        animalvet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animalvet = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(animalvet);
            }
        });
        veterinariaoasis = (Button)findViewById(R.id.btnveterinariaoasis);
        veterinariaoasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent veterinariaoasis = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(veterinariaoasis);
            }
        });
        veterinariamimaskota = (Button)findViewById(R.id.btnmimaskota);
        veterinariamimaskota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mimaskota = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(mimaskota);
            }
        });
        agroveterinariamispotrillos = (Button)findViewById(R.id.btnmispotrillos);
        agroveterinariamispotrillos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mispotrillos = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(mispotrillos);
            }
        });
        maceo= (Button)findViewById(R.id.btnmaceo);
        maceo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maceo = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(maceo);
            }
        });
        animalhouse = (Button)findViewById(R.id.btnanimalhouse);
        animalhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animalhouse = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(animalhouse);
            }
        });
        agroveterinariahojarasca = (Button)findViewById(R.id.btnhojarasca);
        agroveterinariahojarasca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hojarasca = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(hojarasca);
            }
        });


        portal = (Button)findViewById(R.id.btnbano);
        portal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent portal = new Intent(MainActivity.this, Menu_miportal.class);
                startActivity(portal);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action

        } else if (id == R.id.nav_gallery) {
            Intent vistaveterinario = new Intent(MainActivity.this, ViewCites.class);
            startActivity(vistaveterinario);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;



    }
}
