package com.example.coud.ueklogo;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;



/**
 * A simple {@link Fragment} subclass.
 */
public class Effects extends Fragment implements SeekBar.OnSeekBarChangeListener {
    MainActivity mainActivity;
    ImageView uek;
    private SeekBar shadow, blur;

    public Effects() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_effects, container, false);
        mainActivity = (MainActivity) getActivity();
        uek = mainActivity.getImage();
        shadow = view.findViewById(R.id.shadow);
        shadow.setMax(15);
        shadow.setOnSeekBarChangeListener(this);
        blur = view.findViewById(R.id.blur);
        blur.setOnSeekBarChangeListener(this);
        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (seekBar.getId() == shadow.getId()) {
            if (i == 0) {
                uek.setElevation(0);
            } else {
                uek.setElevation((15 - i) + 1);
            }
        } else if (seekBar.getId() == blur.getId()) {
            uek.setAlpha(1 - (i * 0.01f));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
