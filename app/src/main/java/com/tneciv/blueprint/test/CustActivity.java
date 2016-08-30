package com.tneciv.blueprint.test;

import android.app.Activity;
import android.os.Bundle;

import com.tneciv.blueprint.R;
import com.tneciv.widget.textview.CustTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustActivity extends Activity {

    @BindView(R.id.custView)
    CustTextView custView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust);
        ButterKnife.bind(this);
    }
}
