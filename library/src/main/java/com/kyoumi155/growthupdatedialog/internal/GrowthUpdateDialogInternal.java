package com.kyoumi155.growthupdatedialog.internal;

import android.support.v4.app.FragmentActivity;

import com.kyoumi155.growthupdatedialog.PatternDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Internal class that have Dialog list
 */
public class GrowthUpdateDialogInternal {

    private final FragmentActivity mActivity;
    private List<PatternDialog> mPatternDialogList = new ArrayList<>();

    public GrowthUpdateDialogInternal(final FragmentActivity activity){
        mActivity = activity;
    }

    public void addPattern(final PatternDialog patternDialog) {
        mPatternDialogList.add(patternDialog);
    }

    public void showPattern(){
        ((PatternDialog) mPatternDialogList.get(0)).getDialog().show(mActivity.getSupportFragmentManager(), "");
    }

    public void init(){
        showPattern();
    }
}
