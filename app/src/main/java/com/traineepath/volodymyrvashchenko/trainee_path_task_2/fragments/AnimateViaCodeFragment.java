package com.traineepath.volodymyrvashchenko.trainee_path_task_2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.traineepath.volodymyrvashchenko.trainee_path_task_2.R;

public class AnimateViaCodeFragment extends Fragment{

    private static final String TAG = AnimateViaCodeFragment.class.getSimpleName();

    private ImageView mImage;
    private EditText mXTranslationField;
    private EditText mYTranslationField;
    private Button mAnimate;
    private Button mReset;
    private ViewGroup mContainer;
    private float mXTranslation;
    private float mYTranslation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Method: onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(TAG, "Method: onCreateView()");
        View v = inflater.inflate(R.layout.fragment_animate_via_code, container, false);

        mContainer = container;
        mAnimate = (Button) v.findViewById(R.id.view_property);
        setAnimateButtonClickListener();

        mReset = (Button) v.findViewById(R.id.reset_animation);
        setResetButtonClickListener();

        mXTranslationField = (EditText) v.findViewById(R.id.x_translation);
        mYTranslationField = (EditText) v.findViewById(R.id.y_translation);

        mImage = (ImageView) v.findViewById(R.id.image_animation);
        setImageViewClickListener(mImage);

        return v;
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

    private void setAnimateButtonClickListener() {
        Log.v(TAG, "Method: setAnimateButtonClickListener()");
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

    private void setResetButtonClickListener() {
        Log.v(TAG, "Method: setResetButtonClickListener()");
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImage.animate().alpha(1.0F).x(0).y(0);
            }
        });
    }
}