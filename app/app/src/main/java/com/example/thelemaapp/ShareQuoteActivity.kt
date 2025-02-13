package com.example.thelemaapp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

class ShareQuoteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShareQuoteScreen()
        }
    }
}

@Composable
fun ShareQuoteScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = {
            val quote = "Esto es una frase inspiradora de Thelema." // Reemplaza con tu frase
            val textColor = Color.BLACK
            val textSize = 60f // Ajusta el tamaño del texto
            val fontFamily = Typeface.create(Typeface.DEFAULT, Typeface.ITALIC) // Estilo de texto
            generateImageAndShare(quote, context, textColor, textSize, fontFamily)
        }) {
            Text("Generar y Compartir Frase")
        }

        Button(onClick = {
            val quote = "Otra frase inspiradora." // Reemplaza con tu frase
            val textColor = Color.WHITE
            val textSize = 40f // Ajusta el tamaño del texto
            val fontFamily = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL) // Estilo de texto
            val backgroundImage = BitmapFactory.decodeResource(context.resources, R.drawable.ic_launcher_background) // Reemplaza con tu imagen
            generateImageAndShare(quote, context, textColor, textSize, fontFamily, backgroundImage)
        }) {
            Text("Compartir con imagen de fondo")
        }
    }
}

fun generateImageAndShare(
    quote: String,
    context: Context,
    textColor: Int,
    textSize: Float,
    fontFamily: Typeface,
    backgroundImage: Bitmap? = null
) {
    var width = 0
    var height = 0

    val componentActivity = context as? ComponentActivity

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && componentActivity != null) {
        componentActivity.window.decorView.rootWindowInsets?.let { windowInsets ->
            val insets = windowInsets.getInsets(WindowInsets.Type.navigationBars() or WindowInsets.Type.displayCutout())

            // Obtén las dimensiones *reales* de la ventana, no las del decor view
            width = componentActivity.window.attributes.width
            height = componentActivity.window.attributes.height

            if (width == 0 || height == 0) { // Si no tenemos dimensiones válidas, usa DisplayMetrics como respaldo
                val displayMetrics = context.resources.displayMetrics
                width = displayMetrics.widthPixels
                height = displayMetrics.heightPixels
            }

            width -= insets.left + insets.right  // Resta los insets *después* de obtener las dimensiones
            height -= insets.top + insets.bottom // Resta los insets *después* de obtener las dimensiones

        } ?: run { // Si windowInsets es nulo (poco probable, pero posible), usa DisplayMetrics como respaldo
            val displayMetrics = context.resources.displayMetrics
            width = displayMetrics.widthPixels
            height = displayMetrics.heightPixels
        }
    } else { // Si es una versión anterior a Android 11, usa DisplayMetrics
        val displayMetrics = context.resources.displayMetrics
        width = displayMetrics.widthPixels
        height = displayMetrics.heightPixels
    }

    try {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        if (backgroundImage != null) {
            val scaledBackground = Bitmap.createScaledBitmap(backgroundImage, width, height, false)
            canvas.drawBitmap(scaledBackground, 0f, 0f, null)
        } else {
            canvas.drawColor(Color.parseColor("#FFD700")) // Dorado por defecto
        }

        val paint = Paint()
        paint.color = textColor
        paint.textSize = textSize
        paint.textAlign = Paint.Align.CENTER
        paint.typeface = fontFamily

        val bounds = android.graphics.Rect()
        paint.getTextBounds(quote, 0, quote.length, bounds)
        val x = (width / 2).toFloat()
        val y = (height / 2 + bounds.height() / 2).toFloat()

        canvas.drawText(quote, x, y, paint)

        val file = File(context.cacheDir, "quote_image.png")
        FileOutputStream(file).use {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
        }

        val uri: Uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_STREAM, uri)
            type = "image/png"
        }
        context.startActivity(Intent.createChooser(intent, "Compartir Frase"))

    } catch (e: Exception) {
        e.printStackTrace()
    }
}