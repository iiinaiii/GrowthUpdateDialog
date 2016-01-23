package com.kyoumi155.growthupdatedialog.internal;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kyoumi155.growthupdatedialog.R;

/**
 * Internal class that makes dialog
 */
public class PatternDialogFragment extends DialogFragment {
    private static final String KEY_IMAGE = "IMAGE";
    private static final String KEY_TITLE = "TITLE";
    private static final String KEY_MESSAGE = "MESSAGE";
    private static final String KEY_CLOSE_BUTTON = "CLOSE_BUTTON";
    private static final String KEY_REVIEW_BUTTON = "REVIEW_BUTTON";

    public static PatternDialogFragment newInstance(@DrawableRes final int imageId, @StringRes final int titleId,
                                                    @StringRes final int messageId, @LayoutRes final int closeButtonId, @LayoutRes final int reviewButtonId) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_IMAGE, imageId);
        bundle.putInt(KEY_TITLE, titleId);
        bundle.putInt(KEY_MESSAGE, messageId);
        bundle.putInt(KEY_CLOSE_BUTTON, closeButtonId);
        bundle.putInt(KEY_REVIEW_BUTTON, reviewButtonId);

        PatternDialogFragment f = new PatternDialogFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        final int imageId = args.getInt(KEY_IMAGE);
        final int titleId = args.getInt(KEY_TITLE);
        final int messageId = args.getInt(KEY_MESSAGE);
        final int closeButtonId = args.getInt(KEY_CLOSE_BUTTON);
        final int reviewButtonId = args.getInt(KEY_REVIEW_BUTTON);


        final Context context = getActivity();
        return new AlertDialog.Builder(context)
                .setTitle(titleId)
                .setView(createView(context, imageId, titleId, messageId, closeButtonId, reviewButtonId))
                .create();
    }

    private View createView(final Context context, final int imageId, final int titleId, final int messageId,
                            final int closeButtonId, final int reviewButtonId) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.growth_update_dialog_base, null);
        ((TextView) rootView.findViewById(R.id.dialog_message)).setText(getString(messageId));
        ViewGroup buttonContainer = (ViewGroup) rootView.findViewById(R.id.dialog_button_container);
        buttonContainer.addView(LayoutInflater.from(context).inflate(closeButtonId, null));
        buttonContainer.addView(LayoutInflater.from(context).inflate(reviewButtonId, null));
        return rootView;
    }
}
