package com.dhruvam.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {

    TextView category,title, subtitle, main_text, readALot, readALotStatement, membership;
    ImageView header;
    Button upgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        title = findViewById(R.id.title_detailed);
        subtitle = findViewById(R.id.sub_text_detailed);
        main_text = findViewById(R.id.story_text_detailed);
        header = findViewById(R.id.main_image);
        category = findViewById(R.id.category_detailed);

        readALot = findViewById(R.id.read_a_lot);
        readALotStatement = findViewById(R.id.read_a_lot_statement);
        membership = findViewById(R.id.learn_about_membership);
        upgrade = findViewById(R.id.upgrade);

        Intent intent = getIntent();
        if(intent.hasExtra("topic")) {
            title.setText(intent.getStringExtra("topic"));
            subtitle.setText(intent.getStringExtra("sub_topic"));
            header.setImageResource(Integer.parseInt(intent.getStringExtra("main_image")));
            category.setText(intent.getStringExtra("category"));
            actionBarSetup(intent.getStringExtra("author"),intent.getStringExtra("date"));
        }

        subtitle.setPaintFlags(subtitle.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        membership.setPaintFlags(membership.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        main_text.setText("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate vel.");
       }

    /**
     * Sets the Action Bar for new Android versions.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void actionBarSetup(String title, String subtitle) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            android.support.v7.app.ActionBar ab = getSupportActionBar();
            ab.setTitle(title);
            ab.setSubtitle(subtitle);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setLogo(R.drawable.lake);
            ab.setDisplayUseLogoEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_activity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share_all) {
            return true;
        }
        if (id == R.id.action_bookmark) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
