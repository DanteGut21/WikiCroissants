package com.example.wikicroissants

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Notificacion (private val context: Context){
    private val CHANNEL_ID = "canal_cambio_activity"
    private val NOTIFICATION_ID = 101

    init {
        crearCanalDeNotificacion()
    }

    private fun crearCanalDeNotificacion() {
        // Crear el NotificationChannel, pero solo en API 26+ porque
        // la clase NotificationChannel es nueva y no está en la biblioteca de soporte
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nombre = "Notificaciones de Cambio de Activity"
            val descripcionTexto = "Notificaciones para indicar cambio de Activity"
            val importancia = NotificationManager.IMPORTANCE_DEFAULT
            val canal = NotificationChannel(CHANNEL_ID, nombre, importancia).apply {
                description = descripcionTexto
            }
            // Registrar el canal con el sistema
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(canal)
        }
    }

    fun mostrarNotificacion(titulo: String, contenido: String) {
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.local_library_24) // Cambia ic_notification por tu icono de notificación
            .setContentTitle(titulo)
            .setContentText(contenido)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            notify(NOTIFICATION_ID, builder.build())
        }
    }
}//Notificacion