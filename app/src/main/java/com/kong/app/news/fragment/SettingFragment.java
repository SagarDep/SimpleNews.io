package com.kong.app.news.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.kong.R;
import com.kong.app.news.utils.SettingsUtil;

/**
 * Created by CaoPengfei on 17/6/17.
 */

public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {

    private Preference mPreferenceTheme;
    private Preference mCleanCache;

    public static SettingFragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        mCleanCache = findPreference("clean_cache");
        mCleanCache.setOnPreferenceClickListener(this);
        mCleanCache.setSummary("0MB");

        mPreferenceTheme = findPreference("keyTheme");
        mPreferenceTheme.setOnPreferenceClickListener(this);
        String[] colorNames = getActivity().getResources().getStringArray(R.array.SettingColorNames);
        int currentThemeIndex = SettingsUtil.getThemeIndex();
        if (currentThemeIndex >= colorNames.length) {
            mPreferenceTheme.setSummary("自定义色");
        } else {
            mPreferenceTheme.setSummary(colorNames[currentThemeIndex]);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        if (preference == mCleanCache){
        }else if (preference == mPreferenceTheme){
//            new ColorChooserDialog.Builder((SettingActivity)getActivity(), R.string.theme)
//                    .customColors(R.array.colors, null)
//                    .doneButton(R.string.done)
//                    .cancelButton(R.string.cancel)
//                    .allowUserColorInput(false)
//                    .allowUserColorInputAlpha(false)
//                    .show();
        }
        return true;
    }

}
