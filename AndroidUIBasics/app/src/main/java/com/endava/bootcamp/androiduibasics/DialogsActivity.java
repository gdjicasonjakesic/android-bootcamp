package com.endava.bootcamp.androiduibasics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DialogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
    }

    public void onNotificationDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.notification_dialog_title)
                .setMessage(R.string.notification_dialog_body)
                .show();
    }

    public void onAlertDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.alert_dialog_title)
                .setMessage(R.string.alert_dialog_body)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // By calling finish(), current activity will be killed and removed
                                // from task stack. User will be returned to main activity after
                                // clicking on OK button.
                                finish();
                            }
                        }).show();
    }

    public void onYesNoDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.yesno_dialog_title)
                .setMessage(R.string.yesno_dialog_body)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // By calling finish(), current activity will be killed and removed
                                // from task stack. User will be returned to main activity after
                                // clicking on OK button.
                                finish();
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Close the dialog only, if user clicked on Cancel button.
                                dialog.dismiss();
                            }
                        })
                .show();
    }
}
