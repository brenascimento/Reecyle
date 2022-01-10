package com.reecycle.reecycleapp.form.SlidePages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.reecycle.reecycleapp.R;
import com.reecycle.reecycleapp.form.ReeUserContaOption;
import com.reecycle.reecycleapp.form.SlidePages.Artigos.ArtigosFragment;
import com.reecycle.reecycleapp.form.SlidePages.Mapa.MapaFragment;
import com.reecycle.reecycleapp.form.SlidePages.Reepontos.PremiosFragment;

import java.util.ArrayList;
import java.util.List;

public class InAppActivity extends FragmentActivity {
    private static final String TAG = InAppActivity.class.getSimpleName();
    private static final int NUM_PAGES = 5;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_app);
        TabLayout tb = findViewById(R.id.tabs);

        Log.i(TAG, "Foi criado!");

        mPager = findViewById(R.id.viewPager);
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), ScreenSlidePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pagerAdapter.adicionar(MapaFragment.newInstance(), "Mapa");
        pagerAdapter.adicionar(PremiosFragment.newInstance(), "Reepontos");
        pagerAdapter.adicionar(ArtigosFragment.newInstance(), "Artigos");
        mPager.setAdapter(pagerAdapter);
        tb.setupWithViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        if(mPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);

    }

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments = new ArrayList<>();
        private List<String> titulosAba = new ArrayList<>();

        ScreenSlidePagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        void adicionar(Fragment fragment, String tituloAba){
            this.fragments.add(fragment);
            this.titulosAba.add(tituloAba);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return this.titulosAba.get(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}

