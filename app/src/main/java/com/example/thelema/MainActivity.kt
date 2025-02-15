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
        Pair("Oración a Hadit", """
        Oh Hadit, el centro sin círculo,  
        La llama eterna que arde en lo más profundo de mi ser,  
        Tú que eres la chispa de la voluntad,  
        Avivando mi fuego interior con tu pasión infinita.  
        Dame el poder de ser uno con el movimiento,  
        Haz de mí un vehículo para la acción pura,  
        Mi voluntad es tu voluntad,  
        Y a través de ella, manifiesto mi verdadero ser en el mundo.
    """.trimIndent()),
        Pair("Oración a Ra-Hoor-Khuit", """
        Oh Ra-Hoor-Khuit, Señor de la guerra y la justicia,  
        Tú que traes la luz y la ley a la oscuridad,  
        Te invoco en tu forma guerrera y sublime.  
        Que tu fuerza guíe mi voluntad en este día,  
        Y que tu espada, afilada y brillante, corte cualquier obstáculo en mi camino.  
        Que tu presencia sea mi protección,  
        Y que tu luz me inspire a luchar por lo que es justo.
    """.trimIndent()),
        Pair("Oración a Hoor-paar-kraat", """
        Oh Hoor-paar-kraat, señor del silencio y la paz interior,  
        En tu quietud encuentro la verdad,  
        En tu misterio, la llave de mi alma.  
        Que tu silencio me enseñe a escuchar,  
        Que tu sabiduría ilumine mi mente.  
        Permíteme descansar en la calma de tu presencia,  
        Para que, en la quietud, pueda descubrir mi verdadera Voluntad.
    """.trimIndent()),
        Pair("Oración a Babalon", """
        Oh Babalon, madre del éxtasis y del fuego sagrado,  
        Tú que recibes con amor y entregas con pasión,  
        Derrama sobre mí tu fuerza y tu deseo infinito.  
        Que mi copa rebose con tu vino sagrado,  
        Que mi espíritu se libere en la entrega total.  
        Oh gran Babalon, enséñame el camino de la pasión y la libertad.
    """.trimIndent()),
        Pair("Oración a Therion", """
        Oh Therion, bestia indómita del poder y la voluntad,  
        Tú que ruges con la fuerza del universo,  
        Despierta en mí el coraje de seguir mi camino.  
        Que tu fuego arda en mi sangre,  
        Que tu furia sea mi escudo,  
        Y que mi voluntad sea firme como la tuya.  
        En tu fuerza, encuentro mi libertad.
    """.trimIndent()),
        Pair("Ritual de la Estrella Rubí", """
        1. De pie, de cara al Este.
        2. Trazar el pentagrama: usando un dedo o una espada ritual, dibuja un pentagrama en el aire con la punta hacia el Este. Enfócate en la energía del pentagrama.
        3. Invocar las energías elementales: Comienza por invocar las energías de los 4 elementos, comenzando por el Norte (tierra), luego el Este (aire), el Sur (fuego) y el Oeste (agua). Puedes decir: 
        "Yo invoco el poder del Norte, del Sur, del Este y del Oeste. Que los elementos me guíen y protejan."
        4. Cerrar el círculo: Visualiza una barrera de luz dorada o blanca que rodea el espacio donde estás. Mientras lo haces, recita las palabras de protección: 
        "Que este círculo esté cerrado en todas las direcciones. Que esté protegido por la energía divina."
        5. Recita la oración de invocación: Aquí puedes recitar una invocación a los dioses, a la fuerza universal o cualquier oración de tu preferencia.
        6. Finaliza el ritual con la consagración del espacio: "Que este espacio quede consagrado y protegido por las fuerzas cósmicas."
        7. Cerrar el círculo: Para finalizar, visualiza la luz protectora desapareciendo, dejando el espacio en calma.
    """.trimIndent()),
        Pair("Liber Resh", """
        1. Saludar al Sol en cada uno de sus aspectos: Mañana, mediodía, atardecer y medianoche.
        2. Realizar el saludo: Levanta las manos hacia el Sol mientras recitas las palabras sagradas de cada fase. Por ejemplo, al amanecer, recita:
        "Te saludo, oh Sol, gran luz de sabiduría, al comienzo del día."
        3. Recitar las palabras sagradas: Durante cada saludo, recita: "¡Que la Luz del Sol ilumine mi camino y me otorgue sabiduría y fortaleza!"
        4. Finaliza el ritual agradeciendo al Sol y visualiza cómo la luz de la energía solar te llena de poder.
    """.trimIndent()),
        Pair("Ritual del Safiro", """
        1. Preparar el altar: Coloca símbolos de protección como una vela, incienso, un cáliz o cualquier objeto que represente la energía de protección.
        2. Invocar al Ángel Guardián: Recita las palabras de invocación al Ángel Guardián, como por ejemplo:
        "Ángel Guardián, protector de mi alma, ven a mí en este ritual y guíame."
        3. Recitar las palabras de consagración del Safiro: “Que el poder del Safiro me rodee, que la energía azul me proteja y me otorgue claridad espiritual.”
        4. Visualizar el aura del Safiro: Mientras recitas, imagina una luz azul que rodea tu cuerpo, simbolizando protección y sabiduría.
        5. Cerrar el ritual: Para finalizar, recita una oración de gratitud y protección: 
        "Gracias, Ángel Guardián, por tu protección. Que este ritual se cierre con bendiciones y claridad."
    """.trimIndent())
    )


    private val preguntasFrecuentes = mapOf(
        "¿Es Thelema satánica?" to "No, Thelema no es una religión satánica. Es una filosofía espiritual y un sistema de creencias que promueve la libertad personal y el auto-descubrimiento.",
        "¿Se realizan sacrificios en Thelema?" to "No, en Thelema no se practican sacrificios. Thelema se enfoca en la evolución personal y el respeto por la libertad y la voluntad de los demás.",
        "¿Thelema está relacionada con la magia negra?" to "No, Thelema no es magia negra. Es una corriente filosófica que utiliza la magia ceremonial como herramienta para alcanzar el autoconocimiento, siempre con respeto y responsabilidad.",
        "¿Thelema es una religión?" to "Thelema no se considera una religión en el sentido tradicional. Es más una filosofía o sistema de creencias espirituales, con un enfoque en la libertad y el cumplimiento de la propia voluntad.",
        "¿Puedo practicar Thelema si soy de otra religión?" to "Sí, Thelema es compatible con diversas creencias y prácticas espirituales, siempre que se respete la libertad y la voluntad de cada individuo.",
        "¿Se hacen orgías en Thelema?" to "No, en Thelema no se promueven ni se practican orgías. Thelema se centra en la libertad individual, el auto-descubrimiento y el respeto por los demás."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encuentra los elementos de la vista
        val buttonLiberAlVelLegis = findViewById<Button>(R.id.buttonLiberAlVelLegis)
        val buttonLiberAl = findViewById<Button>(R.id.buttonLiberAl)
        val buttonLiberII = findViewById<Button>(R.id.buttonLiberII)
        val buttonLiberTzaddi = findViewById<Button>(R.id.buttonLiberTzaddi)
        val buttonOraciones = findViewById<Button>(R.id.buttonOraciones)
        val buttonPreguntas = findViewById<Button>(R.id.buttonPreguntas)
        val buttonThemes = findViewById<Button>(R.id.buttonThemes)
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)

        textView.movementMethod = ScrollingMovementMethod()  // Habilitar desplazamiento del texto

        // Configuración de los botones
        buttonLiberAlVelLegis.setOnClickListener { showChapters("Liber AL vel Legis", findViewById(R.id.chaptersLiberAlVelLegis)) }
        buttonLiberAl.setOnClickListener { showChapters("Liber AL", findViewById(R.id.chaptersLiberAl)) }
        buttonLiberII.setOnClickListener { showChapters("Liber II", findViewById(R.id.chaptersLiberII)) }
        buttonLiberTzaddi.setOnClickListener { showChapters("Liber Tzaddi", findViewById(R.id.chaptersLiberTzaddi)) }

        buttonOraciones.setOnClickListener { showContent(getOracionesContent()) }
        buttonPreguntas.setOnClickListener { showContent(getPreguntasFrecuentesContent()) }
        buttonThemes.setOnClickListener { showContent("Aquí irán los temas y versículos", findViewById(R.id.themesContainer)) }

        scrollView.visibility = View.GONE  // Inicialmente ocultar el ScrollView
    }

    private fun showChapters(bookName: String, chaptersContainer: LinearLayout) {
        chaptersContainer.removeAllViews()  // Limpiar cualquier vista previa

        // Obtener el contenido del libro
        val book = bookContentData[bookName]

        // Agregar los botones de los capítulos
        book?.forEach { (chapter, _) ->
            val button = Button(this)
            button.text = chapter
            button.setOnClickListener { showVerses(bookName, chapter) }
            chaptersContainer.addView(button)
        }

        // Mostrar el contenedor de capítulos
        chaptersContainer.visibility = View.VISIBLE
        showContent("")  // Limpiar cualquier contenido previo
    }

    private fun showVerses(bookName: String, chapter: String) {
        val verses = bookContentData[bookName]?.get(chapter)
        val content = StringBuilder()

        verses?.forEach { (verse, text) ->
            content.append("$verse: $text\n")
        }

        showContent(content.toString())  // Mostrar los versículos en el ScrollView
    }

    private fun showContent(content: String, container: LinearLayout? = null) {
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        val textView = findViewById<TextView>(R.id.textView)

        // Establecer el texto del TextView
        textView.text = content
        scrollView.visibility = View.VISIBLE  // Hacer visible el ScrollView
        container?.visibility = View.VISIBLE  // Hacer visible el contenedor de capítulos (si es necesario)
    }

    private fun getOracionesContent(): String {
        val content = StringBuilder()
        oraciones.forEach { (title, text) ->
            content.append("$title\n")
            content.append("$text\n\n")
        }
        return content.toString()
    }

    private fun getPreguntasFrecuentesContent(): String {
        val content = StringBuilder()
        preguntasFrecuentes.forEach { (question, answer) ->
            content.append("Pregunta: $question\n")
            content.append("Respuesta: $answer\n\n")
        }
        return content.toString()
    }
}
