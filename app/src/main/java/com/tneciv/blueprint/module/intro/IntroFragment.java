package com.tneciv.blueprint.module.intro;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {
    private ShotEntity mShotEntity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mShotEntity = getArguments().getParcelable(Constants.SHOT_ENTITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro, container, false);
    }

    public IntroFragment() {
    }

    public static IntroFragment newInstance(Parcelable parcelable) {
        IntroFragment fragment = new IntroFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.SHOT_ENTITY, parcelable);
        fragment.setArguments(args);
        return fragment;
    }

}
