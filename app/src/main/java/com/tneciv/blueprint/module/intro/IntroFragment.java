package com.tneciv.blueprint.module.intro;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.tneciv.blueprint.R;
import com.tneciv.blueprint.common.Constants;
import com.tneciv.blueprint.entity.ShotEntity;
import com.tneciv.blueprint.widget.CircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tneciv.blueprint.common.CheckUtils.checkString;
import static com.tneciv.blueprint.common.CheckUtils.convert2LocalTime;

/**
 * A fragment to show shot info in ShotActivity .
 */
public class IntroFragment extends Fragment {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.avatr)
    ImageView avatar;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.createTime)
    TextView createTime;
    @BindView(R.id.userDesc)
    TextView userDesc;
    @BindView(R.id.cardContainer)
    CardView cardContainer;
    @BindView(R.id.scrollView)
    ObservableScrollView scrollView;
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
        View view = inflater.inflate(R.layout.fragment_intro, container, false);
        ButterKnife.bind(this, view);
        MaterialViewPagerHelper.registerScrollView(getActivity(), scrollView, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        showInfo(mShotEntity);
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

    private void showInfo(ShotEntity entity) {
        try {
            title.setText(checkString(entity.getTitle()));
            createTime.setText(convert2LocalTime(entity.getCreated_at()));
            desc.setText(Html.fromHtml(checkString(entity.getDescription())));
            userName.setText(entity.getUser().getName());
            Glide.with(this)
                    .load(entity.getUser().getAvatar_url())
                    .placeholder(R.drawable.dribbble)
                    .error(R.drawable.dribbble)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new CircleTransform(getActivity()))
                    .into(avatar);
            userDesc.setText(Html.fromHtml(checkString(entity.getUser().getBio())));
        } catch (Exception e) {
            e.printStackTrace();
            Snackbar.make(scrollView, "加载失败", Snackbar.LENGTH_SHORT).setAction("refresh", v -> {

            });
        }

    }

}
