package com.example.thelema

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

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

        // Crear canal de notificación (para Android 8+)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        // Intent para abrir la app cuando se toque la notificación
        val intent = Intent(applicationContext, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        // Obtener un versículo aleatorio
        val verse = getRandomVerse()

        // Construir la notificación
        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Versículo del Día")
            .setContentText(verse)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        // Enviar la notificación
        notificationManager.notify(notificationId, notification)
    }

    private fun getRandomVerse(): String {
        val verses = listOf(
            "Haz lo que tú quieras será toda la Ley.",
            "El amor es la ley, amor bajo voluntad.",
            "La voluntad es la ley.",
            "La libertad es el principio de toda acción.",
            "Sigue tu voluntad, y será toda la Ley.",
            "No hay más religión que hacer lo que tú quieras.",
            "El hombre es el centro del universo.",
            "La voluntad que no se puede expresar es una negación de sí misma.",
            "La libertad comienza con la voluntad.",
            "La vida es una cuestión de elección, no de destino.",
            "Todo el universo se rige por una ley que es voluntad.",
            "El amor debe ser la base de toda acción.",
            "La ley de la libertad se basa en el amor.",
            "El único verdadero pecado es la negación de la voluntad.",
            "El hombre es su propio Dios.",
            "La naturaleza humana es una manifestación de la voluntad divina.",
            "La voluntad no tiene límites, solo el conocimiento lo tiene.",
            "La libertad no es un regalo, es un derecho inherente.",
            "Cada acción es una afirmación de la voluntad.",
            "La ley se cumple a través de la expresión de la voluntad.",
            "La magia es la ciencia de la voluntad.",
            "El amor es la clave para comprender el universo.",
            "Solo el hombre que sigue su voluntad es verdaderamente libre.",
            "La verdadera religión es la que libera la voluntad humana.",
            "El poder de la voluntad puede cambiar el curso de los eventos.",
            "El destino es solo la expresión de la voluntad colectiva.",
            "El amor bajo voluntad es el principio de la magia.",
            "En la libertad, se encuentra el verdadero poder.",
            "La ley de la voluntad es la ley de la vida misma.",
            "La voluntad es la energía primaria de todo ser.",
            "El universo responde a la voluntad, no al deseo.",
            "La voluntad es la raíz de todo conocimiento verdadero.",
            "La voluntad siempre encuentra su camino hacia la manifestación.",
            "Cada acción es una expresión de la voluntad universal.",
            "El amor, cuando es verdadero, siempre está alineado con la voluntad.",
            "La libertad solo puede ser alcanzada a través de la voluntad.",
            "La magia no es un acto de deseo, sino de voluntad.",
            "El conocimiento sin voluntad es vacío.",
            "El poder de la voluntad es infinito, solo limitado por la comprensión humana."
        )
        return verses.random()
    }
}
