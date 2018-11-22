package com.laurapereyra.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.laurapereyra.notifications.firebase.MiFirebaseMessagingService;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity  {

    public static final String TAG = "NOTICIAS";
    private TextView notificationText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                Log.e(TAG, "Token: " +  newToken);
                Log.e(TAG, "Id: " +  instanceIdResult.getId());
            }
        });

        notificationText = findViewById(R.id.notificationText);



        //MiFirebaseMessagingService miFirebaseMessagingService = new MiFirebaseMessagingService();
        if(getIntent().getExtras() != null){
            for (String key : getIntent().getExtras().keySet()) {
                 String value = getIntent().getExtras().getString(key);
                notificationText.append("\n" + key + ": " +value);
            }
        }

    }
}
