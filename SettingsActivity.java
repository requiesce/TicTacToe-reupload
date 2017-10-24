package com.example.x.tictactoe;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
            final SwitchPreference switchPreference = (SwitchPreference) findPreference("switchSound");
            switchPreference.setEnabled(true); // enables switch to be changed

            //switchPreference.setSwitchTextOn("MUTE");
            //switchPreference.setSwitchTextOff("UNMUTE");

        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                AudioManager audioManager=(AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
                //boolean isOn = (boolean) newValue;
                boolean isOn;
                if (switchPreference.isEnabled()) {
                    isOn = true;
                }
                else {
                    isOn = false;
                }


                if (isOn) {
                    // switch is on
                    //mute audio
                    /* audioManager.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0); */

                    audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                    audioManager.setStreamMute(AudioManager.STREAM_ALARM, true);
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                    audioManager.setStreamMute(AudioManager.STREAM_RING, true);
                    audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);

                    Toast toast = Toast.makeText(getActivity(), "Sound OFF", Toast.LENGTH_SHORT);
                    toast.show();

                    switchPreference.setEnabled(false);
                }
                else {
                    // switch is off
                    //unmute audio
                    /* audioManager.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_UNMUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_UNMUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_UNMUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_UNMUTE, 0);
                    audioManager.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_UNMUTE, 0); */

                    audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    audioManager.setStreamMute(AudioManager.STREAM_ALARM, false);
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                    audioManager.setStreamMute(AudioManager.STREAM_RING, false);
                    audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, false);

                    Toast toast = Toast.makeText(getActivity(), "Sound ON", Toast.LENGTH_SHORT);
                    toast.show();

                    switchPreference.setEnabled(true);
                }
                return true;
            }

        } );

        }
    }





}
