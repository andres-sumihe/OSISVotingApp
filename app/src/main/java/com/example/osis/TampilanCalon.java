package com.example.osis;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class TampilanCalon extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 1;
    private static final String NOTIFICATION_CHANNEL_ID = "my_notification_channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_tampilan_calon);
        TextView namaCalon = (TextView) findViewById(R.id.namaCalonTampilan);
        TextView nisCalon = (TextView) findViewById(R.id.nisCalon);
        TextView jenisCalon = (TextView) findViewById(R.id.jenisKelaminTampilan);
        TextView kelasCalon = (TextView) findViewById(R.id.kelasCalonTampilan);
        Button btnPilih = (Button) findViewById(R.id.Pilih1);
        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String nis = intent.getStringExtra("nis");
        String jenis = intent.getStringExtra("jk");
        String kelas = intent.getStringExtra("kelas");
//        Log.d("Data", nama + " " + nis + " " + jenis + " " + kelas + " " );
        namaCalon.setText(nama);
        nisCalon.setText(nis);
        jenisCalon.setText(jenis);
        kelasCalon.setText(kelas);

        btnPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), TampilanCalon.class);
                tampilNotifikasi("Pemilihan Osis",  "Anda memilih "+nama, in);
            }
        });

    }

    private void tampilNotifikasi(String s, String s1, Intent intent) {
        // membuat komponen pending intent
        PendingIntent pendingIntent = PendingIntent.getActivity(TampilanCalon.this
                , NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager) TampilanCalon.this
                .getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Channel Name", NotificationManager.IMPORTANCE_DEFAULT);

            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500});
            notificationChannel.enableVibration(true);
            notificationChannel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), audioAttributes);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        // membuat komponen
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification;
        notification = builder
                .setChannelId(NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setVibrate(new long[]{100, 200, 100, 200})
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle(s)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(TampilanCalon.this.getResources()
                        , R.mipmap.ic_launcher))
                .setContentText(s1)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}

