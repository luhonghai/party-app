package com.yalantis.guillotine.sample.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.yalantis.guillotine.animation.GuillotineAnimation;
import com.yalantis.guillotine.sample.R;
import com.yalantis.guillotine.sample.fragments.ProfileFragment;
import com.yalantis.guillotine.sample.widget.CanaroTextView;

import butterknife.ButterKnife;
import butterknife.BindView;

/**
 * Created by Dmytro Denysenko on 5/4/15.
 */
public class MainActivity extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener {
    private static final long RIPPLE_DURATION = 250;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.root)
    FrameLayout root;
    @BindView(R.id.content_hamburger)
    View contentHamburger;

    LinearLayout profileLayout;
    LinearLayout feedLayout;
    LinearLayout activityLayout;
    LinearLayout settingLayout;
    CanaroTextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        ButterKnife.bind(this);

        Fragment profileFragment = new ProfileFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contentView, profileFragment).commit();

        if (toolbar != null) {
            toolBarTitle = (CanaroTextView)toolbar.findViewById(R.id.toolbar_title);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        profileLayout = (LinearLayout) guillotineMenu.findViewById(R.id.profile_group);
        feedLayout    = (LinearLayout) guillotineMenu.findViewById(R.id.feed_group);
        activityLayout= (LinearLayout) guillotineMenu.findViewById(R.id.activity_group);
        settingLayout = (LinearLayout) guillotineMenu.findViewById(R.id.settings_group);

        root.addView(guillotineMenu);


        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        feedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        activityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(String text) {
        toolBarTitle.setText(text);
    }
}
