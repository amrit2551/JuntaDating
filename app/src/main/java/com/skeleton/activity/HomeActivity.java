package com.skeleton.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.skeleton.R;

/**
 * class home
 */
public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Button btnSkip;
    private TextView tvLogout;
    private ImageView ivBck;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * Initialize all views
     */
    private void init() {
        drawerLayout = (DrawerLayout) findViewById(R.id.dlUserDrawer);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        btnSkip.setVisibility(View.GONE);
        ivBck = (ImageView) findViewById(R.id.iv_bck);
        tvLogout = (TextView) findViewById(R.id.tv_logout);
        ivBck.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_arrow_drop_down_grey_24dp));

    }

}



