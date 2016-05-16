package com.traineepath.volodymyrvashchenko.trainee_path_task_2.fragments;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.traineepath.volodymyrvashchenko.trainee_path_task_2.R;

public class AnimateViaXmlFragment extends Fragment{

    private ImageView mImage;
    private Animation mAnimation;
    private AnimatorSet mAnimator;


    public AnimateViaXmlFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAnimation = AnimationUtils.loadAnimation(
                getActivity().getApplicationContext(), R.anim.animation);
        mAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(
                getActivity().getApplicationContext(), R.animator.animator);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_animate_via_xml, container, false);

        Button animate = (Button) v.findViewById(R.id.animation);
        handleAnimationButton(animate);

        Button animator = (Button) v.findViewById(R.id.animator);
        handleAnimatorButton(animator);

        mImage = (ImageView) v.findViewById(R.id.image_animation);
        handleImageViewClick(mImage);


        return v;
    }

    private void handleAnimationButton(Button animate) {
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImage.startAnimation(mAnimation);
            }
        });
    }

    private void handleAnimatorButton(Button animator) {
        animator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimator.setTarget(mImage);
                mAnimator.start();
            }
        });
    }

    private void handleImageViewClick(ImageView mImage) {
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