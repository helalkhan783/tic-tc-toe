package tic.tac.toe.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import tic.tac.toe.R;


public class Dialog {
    public static void exitApp(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        @SuppressLint("InflateParams")
        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.app_exit_dialog, null);
        //Set the view
        builder.setView(view);
       // ImageView imageIcon = view.findViewById(R.id.img_icon);
       // imageIcon.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_launcher));//set warning image
        TextView bOk = view.findViewById(R.id.btn_ok);
        TextView cancel = view.findViewById(R.id.cancel);
        AlertDialog alertDialog = builder.create();
        Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        cancel.setOnClickListener(v -> alertDialog.dismiss());//for cancel
        bOk.setOnClickListener(v -> {
            alertDialog.dismiss();
          ((Activity) context).finish();
        });

        alertDialog.show();
    }

}
