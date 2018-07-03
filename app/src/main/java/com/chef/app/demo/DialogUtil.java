package com.chef.app.demo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public final class DialogUtil {

    public static AlertDialog.Builder netWorkErrorAlert(Context context, DialogInterface.OnClickListener listener){
        AlertDialog.Builder alert = new AlertDialog.Builder(context)
                .setTitle("Network Error")
                .setMessage("Internet is not connected")
                .setCancelable(false)
                .setNegativeButton("Exit App", listener);
        return alert;

    }

    public static AlertDialog.Builder exceptionAlert(Context context, String message, DialogInterface.OnClickListener listener){
        AlertDialog.Builder alert = new AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK", listener);
        return alert;

    }

    public static AlertDialog completeDeliveryDialog(Context context, DialogInterface.OnClickListener doneListener){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View mView = inflater.inflate(R.layout.delivery_complete_dialog, null);
        final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
        final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
        Button mDone = mView.findViewById(R.id.btn_done);

//        mBuilder.setPositiveButton("Done", doneListener);
//
//        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        return dialog;
    }

    public static AlertDialog completePickUpDialog(Context context, DialogInterface.OnClickListener doneListener){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View mView = inflater.inflate(R.layout.delivery_complete_dialog, null);
        final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
        mEmail.setVisibility(View.GONE);
        final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
        mPassword.setVisibility(View.GONE);
        final TextView title = mView.findViewById(R.id.tv_title);
        title.setText("Pick Up");
        Button mDone = mView.findViewById(R.id.btn_done);

        mBuilder.setPositiveButton("Submit", doneListener);

        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        return dialog;
    }
}
