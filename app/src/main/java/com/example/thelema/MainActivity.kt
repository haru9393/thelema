package com.example.thelema

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ScrollView
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 1. Define el contenido de los libros (un ejemplo para Liber AL vel Legis)
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
        )
    )

    // 2. Define oraciones (este es un ejemplo - reemplázalo con tus oraciones reales)
    private val oraciones = listOf(
        Pair("Oración a Nuit", """
        Oh Nuit, vasto y eterno misterio,  
        Madre cósmica que envuelves al universo entero,  
        Tú que eres la estrella que no se apaga,  
        Contigo, me uno en la luz infinita y el amor absoluto.  
        Eres el espacio y el tiempo,  
        Y en tu abrazo encuentro la libertad y el éxtasis eterno.  
        Oh Nuit, guíame en tu silencio y en tu sabiduría,  
        Para que mi voluntad se disuelva en tu voluntad infinita.
    """.trimIndent()),
        // Agregar más oraciones
    )

    private val preguntasFrecuentes = mapOf(
        "¿Es Thelema satánica?" to "No, Thelema no es una religión satánica. Es una filosofía espiritual y un sistema de creencias que promueve la libertad personal y el auto-descubrimiento.",
        "¿Se realizan sacrificios en Thelema?" to "No, en Thelema no se practican sacrificios. Thelema se enfoca en la evolución personal y el respeto por la libertad y la voluntad de los demás.",
        // Agregar más preguntas frecuentes
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra los elementos de la vista
        val buttonLiberAlVelLegis = findViewById<Button>(R.id.buttonLiberAlVelLegis)
        val buttonOraciones = findViewById<Button>(R.id.buttonOraciones)
        val buttonPreguntas = findViewById<Button>(R.id.buttonPreguntas)
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)
        val chaptersContainer = findViewById<LinearLayout>(R.id.chaptersContainer)

        textView.movementMethod = ScrollingMovementMethod()  // Habilitar desplazamiento del texto

        // Configuración de los botones
        buttonLiberAlVelLegis.setOnClickListener {
            showChapters("Liber AL vel Legis", chaptersContainer)
        }

        buttonOraciones.setOnClickListener {
            showContent(getOracionesContent())
        }

        buttonPreguntas.setOnClickListener {
            showContent(getPreguntasFrecuentesContent())
        }

        scrollView.visibility = View.GONE  // Inicialmente ocultar el ScrollView
    }

    // Función para mostrar los capítulos del libro
    private fun showChapters(bookName: String, chaptersContainer: LinearLayout) {
        chaptersContainer.removeAllViews() // Limpiar el contenedor de capítulos
        val chapters = bookContentData[bookName]

        chapters?.forEach { (chapterName, verses) ->
            val button = Button(this).apply {
                text = chapterName
                setOnClickListener {
                    showVerses(verses)
                }
            }
            chaptersContainer.addView(button)
        }
    }

    // Función para mostrar los versículos de un capítulo
    private fun showVerses(verses: Map<String, String>) {
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)

        val text = verses.entries.joinToString("\n") { "${it.key}: ${it.value}" }
        textView.text = text
        scrollView.visibility = View.VISIBLE
    }

    // Función para mostrar el contenido de las oraciones
    private fun getOracionesContent(): String {
        val content = StringBuilder()
        oraciones.forEach { (title, text) ->
            content.append("$title\n")
            content.append("$text\n\n")
        }
        return content.toString()
    }

    // Función para mostrar el contenido de las preguntas frecuentes
    private fun getPreguntasFrecuentesContent(): String {
        val content = StringBuilder()
        preguntasFrecuentes.forEach { (question, answer) ->
            content.append("Pregunta: $question\n")
            content.append("Respuesta: $answer\n\n")
        }
        return content.toString()
    }

    // Función para mostrar contenido de texto
    private fun showContent(content: String) {
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)

        textView.text = content
        scrollView.visibility = View.VISIBLE
    }
}
