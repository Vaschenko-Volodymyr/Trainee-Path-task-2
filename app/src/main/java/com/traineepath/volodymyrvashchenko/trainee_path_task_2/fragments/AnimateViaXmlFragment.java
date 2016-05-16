package com.traineepath.volodymyrvashchenko.trainee_path_task_2.fragments;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.traineepath.volodymyrvashchenko.trainee_path_task_2.R;

public class AnimateViaXmlFragment extends Fragment{

    private static final String TAG = AnimateViaXmlFragment.class.getSimpleName();
    private ImageView mImage;
    private Animation mAnimation;
    private AnimatorSet mAnimator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Method: onCreate()");
        super.onCreate(savedInstanceState);
        mAnimation = AnimationUtils.loadAnimation(
                getActivity().getApplicationContext(), R.anim.animation);
        mAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(
                getActivity().getApplicationContext(), R.animator.animator);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(TAG, "Method: onCreateView()");
        View v = inflater.inflate(R.layout.fragment_animate_via_xml, container, false);

        Button animate = (Button) v.findViewById(R.id.animation);
        setAnimationButtonClickListener(animate);

        Button animator = (Button) v.findViewById(R.id.animator);
        setAnimatorButtonClickListener(animator);

        mImage = (ImageView) v.findViewById(R.id.image_animation);
        setImageViewClickListener(mImage);

        return v;
    }

    private void setAnimationButtonClickListener(Button animate) {
        Log.v(TAG, "Method: setAnimationButtonClickListener()");
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImage.startAnimation(mAnimation);
            }
        });
    }

    private void setAnimatorButtonClickListener(Button animator) {
        Log.v(TAG, "Method: setAnimatorButtonClickListener()");
        animator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimator.setTarget(mImage);
                mAnimator.start();
            }
        });
    }

    private void setImageViewClickListener(ImageView mImage) {
        Log.v(TAG, "Method: setImageViewClickListener()");
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getActivity().getApplicationContext(),
                        "You clicked me! >_<",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

}