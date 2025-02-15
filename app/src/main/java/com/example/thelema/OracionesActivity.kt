
package com.example.thelema

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OracionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oraciones)

        // Declarar las vistas
        val buttonOraciones = findViewById<Button>(R.id.buttonOraciones)
        val containerOraciones = findViewById<LinearLayout>(R.id.oracionesContainer)
        val textViewOracionesRituales = findViewById<TextView>(R.id.textViewOracionesRituales)
        val textViewContenido = findViewById<TextView>(R.id.textViewContenido) // Para mostrar el contenido
        val scrollViewContenido = findViewById<ScrollView>(R.id.scrollViewContenido) // ScrollView para el contenido

        // Lista de oraciones y rituales
        val oraciones = listOf(
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

        // Establecer el listener para el botón de Oraciones y Rituales
        buttonOraciones.setOnClickListener {
            // Mostrar el contenedor de oraciones y rituales
            containerOraciones.visibility = View.VISIBLE
            textViewOracionesRituales.visibility = View.INVISIBLE

            // Limpiar el contenedor antes de agregar los nuevos botones
            containerOraciones.removeAllViews()

            // Agregar los botones para las oraciones y rituales
            for ((titulo, contenido) in oraciones) {
                val button = Button(this).apply {
                    text = titulo
                    setOnClickListener {
                        // Mostrar el contenido en el TextView dentro del ScrollView
                        scrollViewContenido.visibility = View.VISIBLE
                        textViewContenido.text = contenido

                        // Agregar un Log para depurar
                        android.util.Log.d("Oraciones", "Mostrando contenido: $contenido")
                    }
                }
                containerOraciones.addView(button)
            }
        }
    }
}

