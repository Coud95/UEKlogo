package com.example.coud.ueklogo;


import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.madrapps.eyedropper.EyeDropper;


/**
 * A simple {@link Fragment} subclass.
 */
public class Colour extends Fragment implements RadioGroup.OnCheckedChangeListener {
    MainActivity mainActivity;
    ImageView uek;
    FrameLayout background;
    RadioGroup buttons;
    private View wheel;

    public Colour() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colour, container, false);
        wheel = view.findViewById(R.id.wheel);
        mainActivity = (MainActivity) getActivity();
        uek = mainActivity.getImage();
        background = mainActivity.getBackground();
        buttons = view.findViewById(R.id.radioColors);
        buttons.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {
        switch (id) {
            case R.id.radioLogo:
                new EyeDropper(wheel, new EyeDropper.ColorSelectionListener() {
                    @Override
                    public void onColorSelected(@ColorInt int color) {
                        uek.setColorFilter(color);
                    }
                });
                break;
            case R.id.radioBackground:
                new EyeDropper(wheel, new EyeDropper.ColorSelectionListener() {
                    @Override
                    public void onColorSelected(@ColorInt int color) {
                        background.setBackgroundColor(color);
                    }
                });
                break;
        }
    }
}
