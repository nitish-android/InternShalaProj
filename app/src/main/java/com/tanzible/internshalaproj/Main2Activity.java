package com.tanzible.internshalaproj;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {



    private TabLayout tabLayout;
    private PortfolioFragment portfolioFragment;
    private VideoFragment videoFragment;
    private LifestyleFragment lifestyleFragment;
    private CollaborationFragment collaborationFragment;
    ImageView img_back;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        tabLayout = findViewById(R.id.tablayout);
        img_back = findViewById(R.id.tv_header_image);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));

            }
        });
        setUpLayout();
        replaceFragment(portfolioFragment);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               setCurrentTabFragment(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    private void setCurrentTabFragment(int position) {

        switch (position){
            case 0:replaceFragment(portfolioFragment);

            break;

            case 1:replaceFragment(videoFragment);
            break;

            case 2:replaceFragment(lifestyleFragment);
            break;

            case 3:replaceFragment(collaborationFragment);
            break;


        }
    }

    private void setUpLayout() {

        portfolioFragment = new PortfolioFragment();
        videoFragment = new VideoFragment();
        lifestyleFragment = new LifestyleFragment();
        collaborationFragment = new CollaborationFragment();



    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
