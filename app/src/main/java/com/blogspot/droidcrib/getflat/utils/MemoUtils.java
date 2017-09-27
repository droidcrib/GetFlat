package com.blogspot.droidcrib.getflat.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.userdata.UserNotes;
import com.blogspot.droidcrib.getflat.ui.activities.MainActivity;

/**
 * Created by BulanovA on 27.09.2017.
 */

public class MemoUtils {

    public static void buildDialogMessageNewNote(final Context context, final Card card) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String msg = context.getString(R.string.take_a_note);
        String buttonYes = context.getString(R.string.note_save);
        String buttonNo = context.getString(R.string.note_cancel);

        final EditText input = new EditText(context);
        input.setLines(5);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);

        builder.setView(input);
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        UserNotes.insert(input.getText().toString(), card);
                    }
                })
                .setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
}
