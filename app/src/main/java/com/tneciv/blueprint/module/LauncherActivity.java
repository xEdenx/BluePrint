package com.tneciv.blueprint.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tneciv.blueprint.module.main.MainActivity;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
