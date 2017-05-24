package com.skeleton.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.skeleton.R;
import com.skeleton.constant.AppConstant;
import com.skeleton.database.CommonData;
import com.skeleton.fragment.ProfOneFragment;
import com.skeleton.fragment.ProfStepTwoFragment;
import com.skeleton.modal.signupResponse.UserDetails;
import com.skeleton.modal.signupResponse.userprofile.Response;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.customview.CustomViewPager;

/**
 * activity complete profile
 */
public class CompleteProfileActivity extends AppCompatActivity implements View.OnClickListener, AppConstant {
    private CustomViewPager customViewPager;
    private Button btnSkip;
    private ImageView ivBack;
    private UserDetails muserInfo;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_profile);
        init();
        customViewPager.setPagingEnabled(false);
        customViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                switch (position) {
                    case 0:
                        return ProfOneFragment.getInstance();
                    case 1:
                        return ProfStepTwoFragment.getInstance();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        if (muserInfo != null) {
            if (muserInfo.getStep1CompleteOrSkip()) {
                if (muserInfo.getStep2CompleteOrSkip()) {
                    startActivity(new Intent(this, HomeActivity.class));
                } else {
                    customViewPager.setCurrentItem(1);
                }
            } else {
                customViewPager.setCurrentItem(0);
            }

        }
    }

//    /**
//     * @param item index of the view pager which is to be set
//     */
//
//    public void setCurrentPagerItem(final int item) {
//        customViewPager.setCurrentItem(item);
//    }
//

    /**
     * initialization
     */
    private void init() {
        muserInfo = CommonData.getUserDetail();
        customViewPager = (CustomViewPager) findViewById(R.id.vpCProfile);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        ivBack = (ImageView) findViewById(R.id.ivBck);
    }

    /**
     * returns viewpager in activity
     *
     * @return : viewpager containing fragments
     */
    public CustomViewPager getViewPager() {
        return customViewPager;
    }

    /**
     * fired when view is clicked
     *
     * @param v : view clicked
     */

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.btnSkip:
                final int mCurrent = customViewPager.getCurrentItem() + 1;
                RestClient.getApiInterface().skipStep("bearer " + CommonData.getAccessToken(), mCurrent)
                        .enqueue(new ResponseResolver<Response>(CompleteProfileActivity.this) {

                            @Override
                            public void success(final Response response) {
                                if (customViewPager.getCurrentItem() != 1) {
                                    customViewPager.setCurrentItem(1);
                                } else {
                                    startActivityForResult(new Intent(CompleteProfileActivity.this, HomeActivity.class), RC_HOME);
                                    ;

                                }

                            }

                            @Override
                            public void failure(final APIError error) {

                            }
                        });
                break;
            case R.id.ivBck:
                if (customViewPager.getCurrentItem() != 0) {
                    customViewPager.setCurrentItem(customViewPager.getCurrentItem(), false);
                } else {
                    finish();
                }

                break;
            default:
                break;
        }
    }
}
