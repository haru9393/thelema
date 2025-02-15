package com.example.thelema

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View
import android.widget.ScrollView
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
        2. Trazar el pentagrama: usando un dedo o una espada ritual, dibuja un pentagrama en el aire.
        3. Invocar los cuatro elementos: "Te invoco, oh Tierra, Agua, Fuego y Aire."
        4. Invocar el Espíritu: "Te invoco, oh Espíritu, que habitas en lo más alto."
        5. Recitar: "Soy el que soy, el mismo que el todo, y el todo que es todo."
        6. Sellar con el símbolo del Sol: "Que así sea, con la fuerza del Sol."
    """.trimIndent())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oracionesButton: Button = findViewById(R.id.oracionesButton)
        val contentTextView: TextView = findViewById(R.id.contentTextView)
        val scrollView: ScrollView = findViewById(R.id.scrollView)

        oracionesButton.setOnClickListener {
            contentTextView.text = getOracionesContent()
            scrollView.visibility = View.VISIBLE
        }
    }

    private fun getOracionesContent(): String {
        var content = ""
        oraciones.forEach { (title, text) ->
            content += "\n$title\n$text\n"
        }
        return content
    }
}