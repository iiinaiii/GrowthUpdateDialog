package com.kyoumi155.growthupdatedialogapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kyoumi155.growthupdatedialog.GrowthUpdateDialogCreator;
import com.kyoumi155.growthupdatedialog.PatternDialog;

/**
 * Sample Activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GrowthUpdateDialogCreator creator = new GrowthUpdateDialogCreator(this);
        creator.addPattern(createPattern())
                .enable(true);
    }

    private PatternDialog createPattern() {
        return new PatternDialog.Builder()
                .title(R.string.dialog_title)
                .message(R.string.dialog_message)
                .setCloseButton(R.layout.close_button)
                .setReviewButton(R.layout.review_button)
                .build();
    }
}
