package com.tneciv.blueprint.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.module.main.MainFragment;
import com.tneciv.blueprint.module.other.EmptyFragment;
import com.tneciv.blueprint.module.other.EmptyPresenter;
import com.tneciv.blueprint.module.recent.RecentFragment;
import com.tneciv.blueprint.module.recent.RecentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tneciv
 * on 2016-08-14 15:58 .
 * Abstract BaseActivity with DrawerLayout
 */

public abstract class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.contentFrame)
    protected FrameLayout contentFrame;
    @BindView(R.id.fab_add_task)
    protected FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();

        initFragment();


    }

    protected void initView() {
        if (fab != null) {
            fab.setVisibility(View.GONE);
        }
    }

    protected abstract void initFragment();

    protected static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                @NonNull Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.contentFrame, fragment);
        transaction.commit();
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
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            replaceFragment(new MainFragment());
            Log.d("BaseActivity", "mainFragment click");
        } else if (id == R.id.nav_gallery) {
            EmptyFragment emptyFragment = new EmptyFragment();
            replaceFragment(emptyFragment);
            new EmptyPresenter(emptyFragment);
            Log.d("BaseActivity", "emptyFragment click");
        } else if (id == R.id.nav_slideshow) {
            RecentFragment recentFragment = new RecentFragment();
            replaceFragment(recentFragment);
            new RecentPresenter(recentFragment);
            Log.d("BaseActivity", "recentFragment click");
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(fragment.toString())
                .replace(R.id.contentFrame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

}
