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
            SwitchPreference switchPreference = (SwitchPreference) findPreference("switchSound");
            switchPreference.setEnabled(true); // enables switch to be changed

            //switchPreference.setSwitchTextOn("MUTE");
            //switchPreference.setSwitchTextOff("UNMUTE");

        switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                boolean isOn = (boolean) newValue;
                if (isOn) {
                    // switch is on

                    //mute audio
                    AudioManager audioManager=(AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
                    audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);

                    ///audioManager.setStreamVolume(AudioManager.STREAM_ALARM, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE)

                    ///MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.sound_win); //Use your mediaplayer instance instead of this. Also maintain a single instance of mediaplayer for the entire app.
                    ///mp.start();
                    ///mp.setvolume(0,0);



                    Toast toast = Toast.makeText(getActivity(), "Sound OFF", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    // switch is off

                    //unmute audio
                    AudioManager audioManager=(AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);

                    Toast toast = Toast.makeText(getActivity(), "Sound ON", Toast.LENGTH_SHORT);
                    toast.show();
                }


                return true;
            }

        } );

        }
    }





}
