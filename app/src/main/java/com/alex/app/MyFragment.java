package com.alex.app;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chenlin on 17/11/21.
 */

public class MyFragment extends Fragment {

    public static final String KEY_TITLE = "KEY_TITLE";
    public static final String KEY_IMG = "KEY_IMG";
    private TextView mTextView;
    private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        mTextView = (TextView) rootView.findViewById(R.id.tv1);
        mImageView = (ImageView) rootView.findViewById(R.id.img1);
        return rootView;
    }

    public static MyFragment newInstance(String title, @DrawableRes int res) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITLE, title);
        bundle.putInt(KEY_IMG, res);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        mTextView.setText(arguments.getString(KEY_TITLE));
        mImageView.setImageResource(arguments.getInt(KEY_IMG));
    }
}
