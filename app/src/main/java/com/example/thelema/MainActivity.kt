package com.example.thelema

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val bookContentData: Map<String, Map<String, Map<String, String>>> = mapOf(
        "Liber AL vel Legis" to mapOf(
            "Capítulo 1" to mapOf(
                "Versículo 1" to "La Ley es para todos. Haz lo que tú quieras será toda la Ley.",
                "Versículo 2" to "No hay más que una ley: la ley de la libertad.",
                "Versículo 3" to "Haz lo que tú quieras será toda la Ley.",
                "Versículo 4" to "El amor es la ley, amor bajo voluntad.",
                "Versículo 5" to "La libertad es la ley.",
                "Versículo 6" to "La voluntad es la ley."
            ),
            "Capítulo 2" to mapOf(
                "Versículo 1" to "Tú que lees estas palabras, este libro es para ti.",
                "Versículo 2" to "Tú no puedes hacer nada si no tienes voluntad.",
                "Versículo 3" to "Todo lo que haces está en armonía con la Ley.",
                "Versículo 4" to "El amor es la única fuerza que puede unir el universo.",
                "Versículo 5" to "La libertad es el principio de toda acción.",
                "Versículo 6" to "Sigue tu voluntad, y será toda la Ley."
            ),
            "Capítulo 3" to mapOf(
                "Versículo 1" to "Esto es solo el principio, sigue buscando tu camino.",
                "Versículo 2" to "Haz lo que tú quieras, sin miedo.",
                "Versículo 3" to "Nada puede detener tu voluntad.",
                "Versículo 4" to "El amor es el verdadero camino.",
                "Versículo 5" to "La voluntad es más poderosa que el deseo.",
                "Versículo 6" to "No te detengas ante los obstáculos."
            ),
            "Capítulo 4" to mapOf(
                "Versículo 1" to "La sabiduría llega cuando uno se entrega al camino.",
                "Versículo 2" to "Sé valiente y sigue tu propio camino.",
                "Versículo 3" to "No hay límite para lo que puedes lograr.",
                "Versículo 4" to "La libertad es lo que nos define como seres humanos.",
                "Versículo 5" to "El amor es la clave para comprender el universo.",
                "Versículo 6" to "El hombre es el creador de su propio destino."
            )
        ),
        "Liber II" to mapOf(
            "Capítulo 1" to mapOf(
                "Versículo 1" to "La sabiduría es un camino largo, pero vale la pena.",
                "Versículo 2" to "Haz lo que es correcto, no lo que es fácil.",
                "Versículo 3" to "La voluntad es más poderosa que el deseo.",
                "Versículo 4" to "Sé valiente, incluso en la oscuridad.",
                "Versículo 5" to "La verdadera libertad es la libertad interna."
            ),
            "Capítulo 2" to mapOf(
                "Versículo 1" to "La verdad siempre está por encima de todo.",
                "Versículo 2" to "La luz del conocimiento ilumina el camino.",
                "Versículo 3" to "La mente disciplinada es la que alcanza la sabiduría.",
                "Versículo 4" to "No te dejes guiar por el miedo.",
                "Versículo 5" to "El sacrificio es necesario para la transformación."
            ),
            "Capítulo 3" to mapOf(
                "Versículo 1" to "El amor debe ser el motor de todas tus acciones.",
                "Versículo 2" to "La libertad se alcanza cuando no hay ataduras.",
                "Versículo 3" to "La paz viene de la aceptación de uno mismo.",
                "Versículo 4" to "La disciplina es la llave para abrir las puertas del conocimiento.",
                "Versículo 5" to "El poder está en la mente iluminada."
            ),
            "Capítulo 4" to mapOf(
                "Versículo 1" to "Solo quien es libre puede conocer la verdadera sabiduría.",
                "Versículo 2" to "El amor es la base del universo.",
                "Versículo 3" to "Solo con valentía se puede alcanzar el conocimiento verdadero.",
                "Versículo 4" to "El sacrificio por la causa noble es la verdadera libertad.",
                "Versículo 5" to "El universo responde a aquellos que siguen su voluntad."
            )
        ),
        "Liber Tzaddi" to mapOf(
            "Capítulo 1" to mapOf(
                "Versículo 1" to "Recuerda, la verdad siempre está en tu interior.",
                "Versículo 2" to "La fe es el puente entre el conocimiento y la acción.",
                "Versículo 3" to "La fuerza de la voluntad te llevará lejos.",
                "Versículo 4" to "Solo el que sigue su camino verá el final.",
                "Versículo 5" to "La mente es la clave para el poder verdadero."
            ),
            "Capítulo 2" to mapOf(
                "Versículo 1" to "El camino hacia el conocimiento es el camino hacia la luz.",
                "Versículo 2" to "La voluntad puede mover montañas.",
                "Versículo 3" to "La mente iluminada no teme al cambio.",
                "Versículo 4" to "El universo escucha la voluntad de aquellos que son sinceros.",
                "Versículo 5" to "La fe no es ciega, sino sabiduría interior."
            ),
            "Capítulo 3" to mapOf(
                "Versículo 1" to "Solo a través del sacrificio se logra la iluminación.",
                "Versículo 2" to "La verdadera libertad solo se encuentra en la autodeterminación.",
                "Versículo 3" to "La mente tiene el poder de crear y destruir.",
                "Versículo 4" to "La paz interna es lo más importante.",
                "Versículo 5" to "El amor es la fuerza cósmica que mueve el universo."
            ),
            "Capítulo 4" to mapOf(
                "Versículo 1" to "La verdadera magia es la que proviene de la voluntad pura.",
                "Versículo 2" to "Solo aquel que se conoce a sí mismo puede conocer el universo.",
                "Versículo 3" to "La mente no tiene límites si está dirigida por la voluntad.",
                "Versículo 4" to "El amor es la clave de todas las enseñanzas.",
                "Versículo 5" to "La libertad verdadera es cuando la voluntad está alineada con el universo."
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones
        val buttonLiberAlVelLegis = findViewById<Button>(R.id.buttonLiberAlVelLegis)
        val buttonLiberIi = findViewById<Button>(R.id.buttonLiberIi)
        val buttonLiberTzaddi = findViewById<Button>(R.id.buttonLiberTzaddi)

        // Referencias a otros botones
        val buttonThemes = findViewById<Button>(R.id.buttonThemes)
        val buttonOraciones = findViewById<Button>(R.id.buttonOraciones)

        // Contenedores
        val themesContainer = findViewById<LinearLayout>(R.id.themesContainer)
        val oracionesContainer = findViewById<LinearLayout>(R.id.oracionesContainer)
        val shareButtonContainer = findViewById<LinearLayout>(R.id.shareButtonContainer)
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)
        val shareButton = findViewById<Button>(R.id.share_button) // Asegúrate de que este botón exista en tu layout

        // Acción para el botón Liber AL Vel Legis
        buttonLiberAlVelLegis.setOnClickListener {
            // Mostrar el contenido de Liber AL Vel Legis
            textView.text = getBookContent("Liber AL vel Legis")
            scrollView.visibility = View.VISIBLE
            shareButtonContainer.visibility = View.VISIBLE // Hacer visible el contenedor de compartir
        }

        // Acción para el botón Liber II
        buttonLiberIi.setOnClickListener {
            // Mostrar el contenido de Liber II
            textView.text = getBookContent("Liber II")
            scrollView.visibility = View.VISIBLE
            shareButtonContainer.visibility = View.VISIBLE // Hacer visible el contenedor de compartir
        }

        // Acción para el botón Liber Tzaddi
        buttonLiberTzaddi.setOnClickListener {
            // Mostrar el contenido de Liber Tzaddi
            textView.text = getBookContent("Liber Tzaddi")
            scrollView.visibility = View.VISIBLE
            shareButtonContainer.visibility = View.VISIBLE // Hacer visible el contenedor de compartir
        }

        // Acción para el botón de Themes
        buttonThemes.setOnClickListener {
            // Mostrar u ocultar el contenedor de temas
            if (themesContainer.visibility == View.GONE) {
                themesContainer.visibility = View.VISIBLE
            } else {
                themesContainer.visibility = View.GONE
            }
        }

        // Acción para el botón de Oraciones y Ritual
        buttonOraciones.setOnClickListener {
            // Mostrar u ocultar el contenedor de oraciones
            if (oracionesContainer.visibility == View.GONE) {
                oracionesContainer.visibility = View.VISIBLE
            } else {
                oracionesContainer.visibility = View.GONE
            }
        }

        // Acción para el botón de compartir (dentro del contenedor shareButtonContainer)
        shareButton.setOnClickListener {
            val selectedVerse = textView.text.toString() // O cualquier otro texto que quieras compartir
            if (selectedVerse.isNotEmpty()) {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, getString(R.string.share_message, selectedVerse))
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_with)))
            } else {
                Toast.makeText(this, getString(R.string.select_verse_first), Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Función para obtener el contenido de un libro
    private fun getBookContent(bookName: String): String {
        val bookContent = bookContentData[bookName]
        var content = ""

        bookContent?.forEach { (chapter, verses) ->
            content += "\n$chapter\n"
            verses.forEach { (verse, text) ->
                content += "$verse: $text\n"
            }
        }

        return content
    }
}
