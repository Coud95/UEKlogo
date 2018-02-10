package com.example.coud.ueklogo;


import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment implements SeekBar.OnSeekBarChangeListener {
    MainActivity mainActivity;
    ImageView uek;
    private SeekBar size, rotation;

    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_size, container, false);
        mainActivity = (MainActivity) getActivity();
        uek = mainActivity.getImage();
        rotation = view.findViewById(R.id.rotation);
        rotation.setOnSeekBarChangeListener(this);
        size = view.findViewById(R.id.size);
        size.setOnSeekBarChangeListener(this);
        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == size.getId()) {
            uek.setScaleX((float) (i * 0.01));
            uek.setScaleY((float) (i * 0.01));
        } else if (seekBar.getId() == rotation.getId()) {
            uek.setRotation((float) (i * 3.6));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
