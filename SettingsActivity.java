package com.example.x.tictactoe;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.AudioManager;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_background);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SettingsFragment settingsFragment = new SettingsFragment();
        fragmentTransaction.add(android.R.id.content, settingsFragment, "settings_fragment");
        fragmentTransaction.commit();


       /* AudioManager audioManager;
        float volume, mute;
        volumeSounds(); */
    }

/*    protected void volumeSounds(){
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        volume = (float)audioManager.getStreamVolume(AudioManager.ADJUST_MUTE);
    } */




    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_screen);
            SwitchPreference switchPreference = (SwitchPreference) findPreference("switchSound");
            switchPreference.setEnabled(true); // enables switch to be changed
        }
    }





}
