package com.skeleton.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.skeleton.R;
import com.skeleton.adapter.PagerAdapter;
import com.skeleton.fragment.SignInFragment;
import com.skeleton.fragment.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin23 on 10/5/17.
 */

public class LoginSignUpActivity extends BaseActivity {
    private ViewPager viewPager;
    private List<Fragment> fList;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
//        tabLayout.addTab(tabLayout.newTab().setText("sign_up"));
//        tabLayout.addTab(tabLayout.newTab().setText("sign_in"));
        PagerAdapter pagerAdapter = new com.skeleton.adapter.PagerAdapter(getSupportFragmentManager(), fList);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    /**
     * init
     */
    private void init() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tlSlide);
        fList = new ArrayList<>();
        fList.add(new SignUpFragment());
        fList.add(new SignInFragment());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /**
     * @param requestCode req code
     * @param resultCode  result code
     * @param data        data
     */
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RC_OTP) {
                Intent intent = new Intent(this, CompleteProfileActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}