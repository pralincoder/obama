package com.example.dell.obama.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dell.obama.R;
import com.example.dell.obama.adapter.CardsAdapter;
import com.example.dell.obama.model.Model;

public class Navigation_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public ViewGroup newsnnotification;
    private Boolean ispanel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
newsnnotification =(ViewGroup)findViewById(R.id.news_n_notification);
newsnnotification.setVisibility(View.INVISIBLE);
ispanel=false;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView=(ListView)findViewById(R.id.list_of_news);
        CardsAdapter adapter = new CardsAdapter(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
navigationView.setItemIconTintList(null);
        listView.setAdapter((ListAdapter) adapter);
        adapter.addAll(new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub),
                new Model(R.drawable.obama, R.string.obama, R.string.obama_sub));

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.news_n_notification);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Navigation_drawer.this,News_and_notification.class);
                startActivity(intent);
            }
        });


        //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            //}
        //});
        ImageView imageView=(ImageView)findViewById(R.id.image_menu);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        View header = navigationView.getHeaderView(0);
        ImageView imageView1=(ImageView) header.findViewById(R.id.nav_close);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(Gravity.START);
            }
        });
        imageView=(ImageView)findViewById(R.id.image_menu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


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
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
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

        if (id == R.id.bio) {
Intent intent2=new Intent(Navigation_drawer.this,MyBio.class);
startActivity(intent2);

            // Handle the camera action
        } else if (id == R.id.question) {

        } else if (id == R.id.notification) {
            Intent intent=new Intent(Navigation_drawer.this,Notification_activity.class);
            startActivity(intent);

        } else if (id == R.id.news) {
            Intent intent=new Intent(Navigation_drawer.this,News_and_notification.class);
            startActivity(intent);
        } else if (id == R.id.maps) {
            Intent intent=new Intent(Navigation_drawer.this,leaders_map.class);
            startActivity(intent);

        } else if (id == R.id.gallery) {

        }else if (id==R.id.social_media){
            Intent intent1=new Intent(Navigation_drawer.this,SocialMedia.class);
            startActivity(intent1);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
