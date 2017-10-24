package com.example.x.tictactoe;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.media.AudioManager;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings_background);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SettingsFragment settingsFragment = new SettingsFragment();
        fragmentTransaction.add(android.R.id.content, settingsFragment, "settings_fragment");
        fragmentTransaction.commit();
    }

    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_screen);

            setHasOptionsMenu(true); //

            final AudioManager audioManager=(AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);

            final Preference switchPref = (Preference) findPreference("switchSound");
            switchPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {

                    boolean isOn = (boolean) newValue;

                    if (isOn) {
                        // switch is on
                        //mute audio
                        audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);

                        Toast toast = Toast.makeText(getActivity(), "Sound OFF", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {
                        // switch is off
                        //unmute audio

                        audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);

                        Toast toast = Toast.makeText(getActivity(), "Sound ON", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    return true;
                }
            });
        }
    }
}
