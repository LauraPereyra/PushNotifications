package com.laurapereyra.notifications.firebase;

import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MiFirebaseInstanceIdService extends FirebaseMessagingService{
    public static final String TAG = "NOTICIAS";
    public static String refreshedToken = "";
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d(TAG, "Mi Token"+ s);

    }


}
