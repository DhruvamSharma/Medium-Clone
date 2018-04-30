package com.dhruvam.myapplication;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView mTopStories, mBottomStories;
    TopAdapter topAdapter;
    BottomAdapter bottomAdapter;
    NavigationView navigationView;

    ArrayList<String> arrayListTopicName, arrayListCategory, arrayListAuthor, arrayListDate, arrayListSubtitle;
    ArrayList<Integer> resourceIdList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Home");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        arrayListTopicName = new ArrayList<>();
        arrayListSubtitle = new ArrayList<>();
        arrayListAuthor = new ArrayList<>();
        arrayListCategory = new ArrayList<>();
        arrayListDate = new ArrayList<>();
        resourceIdList = new ArrayList<>();

        mTopStories = findViewById(R.id.topRecyclerView);
        mBottomStories = findViewById(R.id.bottomRecyclerView);

        topAdapter = new TopAdapter(getPrepared(arrayListTopicName),getAuthorPrepared(arrayListAuthor),getDatePrepared(arrayListDate),getResourcePrepared(resourceIdList));
        bottomAdapter = new BottomAdapter(getCategoryPrepared(arrayListCategory),arrayListTopicName,getSubtitlePrepared(arrayListSubtitle),arrayListAuthor,arrayListDate, resourceIdList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);

        mTopStories.setAdapter(topAdapter);
        mBottomStories.setAdapter(bottomAdapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mTopStories);

        mTopStories.setLayoutManager(linearLayoutManager);
        mBottomStories.setLayoutManager(linearLayoutManager1);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
        if (id == R.id.action_search) {
            return true;
        }
        if (id == R.id.action_notification) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        resetAllMenuItemsTextColor(navigationView);
        setTextColorForMenuItem(item, R.color.colorPrimary);



        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_audio) {

        } else if (id == R.id.nav_bookmarks) {

        } else if (id == R.id.nav_interests) {


        } else if (id == R.id.nav_new_story) {

        } else if (id == R.id.nav_stats) {

        } else if (id == R.id.nav_become_a_member)  {
            setTextColorForMenuItem(item, R.color.colorAccent);
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<String> getPrepared(ArrayList<String> arrayList) {
        arrayList.add("Recycler View Exploration and it's explanation");
        arrayList.add("Data Scientist path to future. Try it now!");
        arrayList.add("How to start a startup. What is the scope");
        arrayList.add("Starting your day in a good manner. Let's do it.");
        arrayList.add("Kindly review your resume and propose");
        arrayList.add("Dance your way out into the world.");
        arrayList.add("Hand drawn drawings and sketches to your group.");
        return arrayList;
    }

    private ArrayList<String> getSubtitlePrepared(ArrayList<String> arrayList) {
        arrayList.add("Hi, everyone. This is Dhruvam here.");
        arrayList.add("Start the data into the world");
        arrayList.add("How to start a startup. What is the scope");
        arrayList.add("Kindly review the article first.");
        arrayList.add("Data Scientist path to future");
        arrayList.add("Dance your way out into the world.");
        arrayList.add("Starting your day in a good manner. Let's do it.");
        return arrayList;
    }

    private ArrayList<String> getCategoryPrepared(ArrayList<String> arrayList) {
        arrayList.add("Best Explanation");
        arrayList.add("Best Images");
        arrayList.add("Trial List");
        arrayList.add("Shared Image");
        arrayList.add("Kind Choice");
        arrayList.add("Editor's Choice");
        arrayList.add("Best Edit");
        return arrayList;
    }


    private ArrayList<String> getDatePrepared(ArrayList<String> arrayList) {
        arrayList.add("06/08/2018");
        arrayList.add("22/12/2018");
        arrayList.add("03/06/2018");
        arrayList.add("04/05/2018");
        arrayList.add("13/04/2018");
        arrayList.add("14/08/2018");
        arrayList.add("22/12/2018");
        return arrayList;
    }


    private ArrayList<String> getAuthorPrepared(ArrayList<String> arrayList) {
        arrayList.add("Dhruvam");
        arrayList.add("Google");
        arrayList.add("Microsoft");
        arrayList.add("Uber");
        arrayList.add("GSOC");
        arrayList.add("ProtoPie");
        arrayList.add("FOSSAsia");
        return arrayList;
    }


    private ArrayList<Integer> getResourcePrepared(ArrayList<Integer> arrayList) {
        arrayList.add(R.drawable.big_one);
        arrayList.add(R.drawable.lake);
        arrayList.add(R.drawable.download);
        arrayList.add(R.drawable.maxresdefault);
        arrayList.add(R.drawable.images);
        arrayList.add(R.drawable.trial_image);
        arrayList.add(R.drawable.split_image);
        return arrayList;
    }

    private void setTextColorForMenuItem(MenuItem menuItem, @ColorRes int color) {
        SpannableString spanString = new SpannableString(menuItem.getTitle().toString());
        spanString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, color)), 0, spanString.length(), 0);
        menuItem.setTitle(spanString);
    }

    private void resetAllMenuItemsTextColor(NavigationView navigationView) {
        for (int i = 0; i < navigationView.getMenu().size(); i++)
            setTextColorForMenuItem(navigationView.getMenu().getItem(i), R.color.cardview_dark_background);
    }

}
