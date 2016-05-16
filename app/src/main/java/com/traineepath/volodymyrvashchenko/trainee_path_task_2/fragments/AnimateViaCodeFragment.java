package com.traineepath.volodymyrvashchenko.trainee_path_task_2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.traineepath.volodymyrvashchenko.trainee_path_task_2.R;

public class AnimateViaCodeFragment extends Fragment{

    private ImageView mImage;
    private EditText mXTranslationField;
    private EditText mYTranslationField;
    private Button mAnimate;
    private Button mReset;
    private ViewGroup mContainer;
    private float mXTranslation;
    private float mYTranslation;

    public AnimateViaCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_animate_via_code, container, false);

        mContainer = container;
        mAnimate = (Button) v.findViewById(R.id.view_property);
        handleAnimateButton();

        mReset = (Button) v.findViewById(R.id.reset_animation);
        handleResetButton();

        mXTranslationField = (EditText) v.findViewById(R.id.x_translation);
        mYTranslationField = (EditText) v.findViewById(R.id.y_translation);

        mImage = (ImageView) v.findViewById(R.id.image_animation);
        handleImageViewClick(mImage);

        return v;
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

    private void handleAnimateButton() {
        mAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXTranslation = mXTranslationField.getText().toString().equals("") ?
                        (float) mContainer.getWidth() - mAnimate.getWidth() :
                        Float.parseFloat(mXTranslationField.getText().toString());

                mYTranslation = mYTranslationField.getText().toString().equals("") ?
                        (float) mContainer.getHeight() - mAnimate.getHeight() :
                        Float.parseFloat(mYTranslationField.getText().toString());

                mImage.animate().alpha(0.1F).x(mXTranslation).y(mYTranslation);
            }
        });
    }

    private void handleResetButton() {
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImage.animate().alpha(1.0F).x(0).y(0);
            }
        });
    }
}