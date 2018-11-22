package com.laurapereyra.notifications.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.laurapereyra.notifications.MainActivity;

public class MiFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "NOTICIAS";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de: " + from);

        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Notificacion: "+ remoteMessage.getNotification().getBody());

        }
    }

    /*@Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de: " + from);

        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Notificacion: "+ remoteMessage.getNotification().getBody());

            //showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }

        //Verificamos si data tiene datos
        if (remoteMessage.getData().size() > 0 ) {
            Log.d(TAG, "Data: " + remoteMessage.getData());
        }

    }*/

    /*private void showNotification(String tittle, String body){
        Intent notification = new Intent(this, MainActivity.class);
        notification.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notification,PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri  = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,"0")
                .setContentTitle(tittle)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notifictionManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notifictionManager.notify(0,notificationBuilder.build());
    }*/
}
