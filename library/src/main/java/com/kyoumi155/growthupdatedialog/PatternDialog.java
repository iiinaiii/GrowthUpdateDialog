package com.kyoumi155.growthupdatedialog;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

import com.kyoumi155.growthupdatedialog.internal.PatternDialogFragment;

/**
 * Dialog interface that defined pattern
 */
public class PatternDialog {
    private PatternDialogFragment mDialog;

    private PatternDialog(Builder builder) {
        mDialog = PatternDialogFragment.newInstance(
                builder.imageResId,
                builder.titleResId,
                builder.messageResId,
                builder.closeButtonResId,
                builder.reviewButtonResId);

    }

    public PatternDialogFragment getDialog(){
        return mDialog;
    }


    /**
     * Pattern Dialog's Builder
     */
    public static class Builder {
        @DrawableRes
        int imageResId;
        @StringRes
        int titleResId;
        @StringRes
        int messageResId;
        @LayoutRes
        int closeButtonResId;
        @LayoutRes
        int reviewButtonResId;

        public Builder image(@DrawableRes final int imageResId) {
            this.imageResId = imageResId;
            return this;
        }

        public Builder title(@StringRes final int titleResId) {
            this.titleResId = titleResId;
            return this;
        }

        public Builder message(@StringRes final int messageResId) {
            this.messageResId = messageResId;
            return this;
        }

        public Builder setCloseButton(@LayoutRes final int closeButton) {
            this.closeButtonResId = closeButton;
            return this;
        }

        public Builder setReviewButton(@LayoutRes final int reviewButton) {
            this.reviewButtonResId = reviewButton;
            return this;
        }

        public PatternDialog build() {
            return new PatternDialog(this);
        }
    }
}
