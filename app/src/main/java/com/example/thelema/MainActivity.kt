package com.example.thelema

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de variables para las vistas
    private lateinit var chaptersContainer: LinearLayout
    private lateinit var chapterTitleTextView: TextView
    private lateinit var verseTextView: TextView
    private lateinit var versesContainer: LinearLayout
    private lateinit var chaptersScrollView: ScrollView
    private lateinit var versesScrollView: ScrollView
    private lateinit var buttonsContainer: LinearLayout

    // Constantes para los nombres de los libros
    companion object {
        const val LIBER_AL_VEL_LEGIS = "Liber AL vel Legis"
        const val LIBER_II = "Liber II"
        const val LIBER_TZADDI = "Liber Tzaddi"
    }

    // Datos de ejemplo para los libros, capítulos y versículos
    // **RECUERDA: Debes reemplazar estos datos con los tuyos.**
    private val bookContentData: Map<String, Map<String, Map<String, String>>> = mapOf(
        LIBER_AL_VEL_LEGIS to mapOf(
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
        LIBER_II to mapOf(
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
        LIBER_TZADDI to mapOf(
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

        // Inicialización de vistas
        chaptersContainer = findViewById(R.id.chaptersContainer)
        chapterTitleTextView = findViewById(R.id.chapterTitleTextView)
        verseTextView = findViewById(R.id.verseTextView)
        versesContainer = findViewById(R.id.versesContainer)
        chaptersScrollView = findViewById(R.id.chaptersScrollView)
        versesScrollView = findViewById(R.id.versesScrollView)
        buttonsContainer = findViewById(R.id.buttonsContainer)

        // Botones
        val buttonLiberAlVelLegis: Button = findViewById(R.id.buttonLiberAlVelLegis)
        val buttonLiberII: Button = findViewById(R.id.buttonLiberII)
        val buttonLiberTzaddi: Button = findViewById(R.id.buttonLiberTzaddi)
        val buttonOraciones: Button = findViewById(R.id.buttonOraciones)
        val buttonPreguntas: Button = findViewById(R.id.buttonPreguntas)
        val buttonThemes: Button = findViewById(R.id.buttonThemes)

        // Listeners de botones
        buttonLiberAlVelLegis.setOnClickListener { showChapters(LIBER_AL_VEL_LEGIS) }
        buttonLiberII.setOnClickListener { showChapters(LIBER_II) }
        buttonLiberTzaddi.setOnClickListener { showChapters(LIBER_TZADDI) }
        buttonOraciones.setOnClickListener {
            val intent = Intent(this, OracionesActivity::class.java)
            startActivity(intent)
        }
        buttonPreguntas.setOnClickListener {
            val intent = Intent(this, PreguntasFrecuentesActivity::class.java)
            startActivity(intent)
        }
        buttonThemes.setOnClickListener {
            val intent = Intent(this, ThemesActivity::class.java)
            startActivity(intent)
        }

        showBooks()
    }

    private fun showBooks() {
        chaptersContainer.removeAllViews()
        chaptersScrollView.visibility = View.GONE
        versesScrollView.visibility = View.GONE
        chapterTitleTextView.visibility = View.GONE
        verseTextView.visibility = View.GONE
        buttonsContainer.visibility = View.VISIBLE

        val books = listOf(LIBER_AL_VEL_LEGIS, LIBER_II, LIBER_TZADDI)
        books.forEach { bookName ->
            val bookButton = Button(this).apply {
                text = bookName
                setOnClickListener { showChapters(bookName) }
            }
            chaptersContainer.addView(bookButton)
        }
    }

    private fun showChapters(bookName: String) {
        val chapters = bookContentData[bookName] ?: run {
            println("Error: Libro no encontrado: $bookName")
            return
        }

        chaptersContainer.removeAllViews()
        chaptersScrollView.visibility = View.VISIBLE
        versesScrollView.visibility = View.GONE
        chapterTitleTextView.visibility = View.GONE
        verseTextView.visibility = View.GONE
        buttonsContainer.visibility = View.GONE

        chapters.forEach { (chapterName, _) ->
            val chapterButton = Button(this).apply {
                text = getString(R.string.chapter_title, chapterName)
                setOnClickListener { showVerses(bookName, chapterName) }
            }
            chaptersContainer.addView(chapterButton)
        }
    }

    private fun showVerses(bookName: String, chapterName: String) {
        val verses = bookContentData[bookName]?.get(chapterName) ?: run {
            println("Error: Capítulo no encontrado: $chapterName en $bookName")
            return
        }

        // Formatear el título del capítulo usando String.format() y el recurso de cadena
        val chapterTitle = String.format(
            getString(R.string.chapter_title_format), // Recurso de cadena con marcadores de posición
            getString(R.string.book_title, bookName), // Título del libro
            getString(R.string.chapter_title, chapterName) // Título del capítulo
        )
        chapterTitleTextView.text = chapterTitle
        chapterTitleTextView.visibility = View.VISIBLE

        versesContainer.removeAllViews()
        chaptersScrollView.visibility = View.GONE
        versesScrollView.visibility = View.VISIBLE
        verseTextView.visibility = View.VISIBLE

        verses.forEach { (verseName, verseText) ->
            val verseButton = Button(this).apply {
                text = verseName
                setOnClickListener { verseTextView.text = verseText }
            }
            versesContainer.addView(verseButton)
        }
    }
}