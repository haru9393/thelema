package com.example.thelema

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.Random

class DailyVerseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        showNotification()
        return Result.success()
    }

    private fun showNotification() {
        val channelId = "daily_verse_channel"
        val channelName = "Versículo Diario"
        val notificationId = 1

        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Crear canal de notificación (para Android 8.0 Oreo y superior)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        // Intent para abrir la app cuando se toque la notificación
        val intent = Intent(applicationContext, MainActivity::class.java)
        //Flags added for android 12 and above
        val pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        } else {
            PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }


        // Obtener un versículo aleatorio
        val verse = getRandomVerse()

        // Construir la notificación
        val notificationBuilder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info) // Usa un icono adecuado
            .setContentTitle("Versículo del Día")
            .setContentText(verse)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        // Establecer la prioridad (opcional, pero recomendado)
        notificationBuilder.priority = NotificationCompat.PRIORITY_DEFAULT

        val notification = notificationBuilder.build()


        // Enviar la notificación
        notificationManager.notify(notificationId, notification)
    }

    private fun getRandomVerse(): String {
        val verses = listOf( // ... (your list of verses)
            "Haz lo que tú quieras será toda la Ley.",
            "El amor es la ley, amor bajo voluntad.",
            // ... (rest of your verses)
            "El poder de la voluntad es infinito, solo limitado por la comprensión humana."
        )
        val randomIndex = Random().nextInt(verses.size) // Use java.util.Random
        return verses[randomIndex]
    }
}