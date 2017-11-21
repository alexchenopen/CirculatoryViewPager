package com.alex.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alex.widget.CirculatoryFragmentPagerAdapter;
import com.alex.widget.CirculatoryViewPager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private CirculatoryViewPager mViewPager;
    private List<MyFragment> mFragments;
    private TextView mTextView;
    private Button mButtonHorizontal;
    private Button mButtonVertical;
    private int mCurrentPos = 0;
    private FragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (CirculatoryViewPager) findViewById(R.id.viewpager);
        mTextView = (TextView) findViewById(R.id.numIndicator);
        mButtonHorizontal = (Button) findViewById(R.id.btnHorizontal);
        mButtonVertical = (Button) findViewById(R.id.btnVertical);
        mAdapter = new FragmentAdapter(getSupportFragmentManager());
        initData();

        mViewPager.setPageMargin(10);
        mViewPager.addOnPageChangeListener(new CirculatoryViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setIndicators(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mButtonHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setDirection(CirculatoryViewPager.HORIZONTAL);
                initData();
            }
        });
        mButtonVertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setDirection(CirculatoryViewPager.VERTICAL);
                initData();
            }
        });
    }

    private void initData() {
        mCurrentPos = 0;
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            MyFragment fragmentInner1 = MyFragment.newInstance("fragment1", R.drawable.image_1);
            MyFragment fragmentInner2 = MyFragment.newInstance("fragment2", R.drawable.image_2);
            MyFragment fragmentInner3 = MyFragment.newInstance("fragment3", R.drawable.image_3);
            MyFragment fragmentInner4 = MyFragment.newInstance("fragment4", R.drawable.image_4);
            MyFragment fragmentInner5 = MyFragment.newInstance("fragment5", R.drawable.image_5);
            MyFragment fragmentInner6 = MyFragment.newInstance("fragment6", R.drawable.image_6);
            mFragments.add(fragmentInner1);
            mFragments.add(fragmentInner2);
            mFragments.add(fragmentInner3);
            mFragments.add(fragmentInner4);
            mFragments.add(fragmentInner5);
            mFragments.add(fragmentInner6);
        }
        setIndicators(mCurrentPos);
        mViewPager.setAdapter(mAdapter);
    }

    private void setIndicators(int position) {
        mTextView.setText(position + 1 + "/" + mFragments.size());
    }


    class FragmentAdapter extends CirculatoryFragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


    }
}
