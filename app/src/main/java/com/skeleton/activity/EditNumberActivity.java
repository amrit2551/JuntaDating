package com.skeleton.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.database.CommonData;
import com.skeleton.modal.signupResponse.updateuserprof.UpdateProfileResponse;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.MultipartParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.Log;
import com.skeleton.util.customview.MaterialEditText;

/**
 * Edit num screen
 */
public class EditNumberActivity extends BaseActivity {
    private MaterialEditText etNewNum;
    private Button btnSubmit, btnSkip;
    private TextView tvTitle;
    private ImageView ivBck;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_number);
        init();
        btnSkip.setVisibility(View.GONE);
        tvTitle.setText("EDIT NUMBER");
        ivBck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                MultipartParams multipartParams = new MultipartParams.Builder()
                        .add(USER_NEW_NUMBER, etNewNum.getText().toString())
                        .build();
                RestClient.getApiInterface().updateProfile("bearer " + CommonData.getAccessToken(), multipartParams.getMap())
                        .enqueue(new ResponseResolver<UpdateProfileResponse>(EditNumberActivity.this, true, true) {
                            @Override
                            public void success(final UpdateProfileResponse updateProfileResponse) {
                                Log.d("edit number", CommonData.getAccessToken());
                                Intent intent = getIntent().putExtra("num", etNewNum.getText().toString());
                                setResult(RESULT_OK, intent);
                                finish();

                            }

                            @Override
                            public void failure(final APIError error) {


                            }
                        });

            }

        });
    }


    /**
     * intilize all variables
     */

    public void init() {
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        ivBck = (ImageView) findViewById(R.id.iv_bck);
        etNewNum = (MaterialEditText) findViewById(R.id.etNewNumber);
    }

}

