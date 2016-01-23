package com.kyoumi155.growthupdatedialog;

import android.support.v4.app.FragmentActivity;

import com.kyoumi155.growthupdatedialog.internal.GrowthUpdateDialogInternal;

/**
 * Factory class
 */
public class GrowthUpdateDialogCreator {
    private GrowthUpdateDialogInternal mDialogInternal;

    public GrowthUpdateDialogCreator(final FragmentActivity activity) {
        mDialogInternal = new GrowthUpdateDialogInternal(activity);
    }

    public GrowthUpdateDialogCreator addPattern(final PatternDialog patternDialog) {
        mDialogInternal.addPattern(patternDialog);
        return this;
    }

    public void enable(final boolean enabled) {
        if (enabled) {
            mDialogInternal.init();
        }
    }
}
