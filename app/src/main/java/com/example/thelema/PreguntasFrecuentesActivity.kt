package com.example.thelema

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class PreguntasFrecuentesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas_frecuentes)

        val questionsContainer: LinearLayout = findViewById(R.id.questionsContainer)

        val questions = listOf(
            Pair("¿Puedo estudiar Thelema sin practicar magia?", "Sí, puedes estudiar Thelema como una filosofía y aplicarla a tu vida diaria sin necesidad de practicar magia. La base de Thelema es la libertad y el auto-descubrimiento."),
            Pair("¿Thelema tiene una comunidad organizada?", "Existen diversas organizaciones y grupos que siguen la filosofía Thelemica, pero Thelema en sí no tiene una jerarquía centralizada ni una estructura religiosa formal. Cada individuo es libre de interpretar y practicar Thelema a su manera."),
            Pair("¿Es Thelema compatible con el budismo?", "Sí, Thelema y el budismo pueden ser compatibles, ya que ambos enfatizan la importancia del autoconocimiento y la evolución personal. La clave es la libertad para practicar según tu propia voluntad."),
            Pair("¿Es Thelema satánica?", "No, Thelema no es una religión satánica. Es una filosofía espiritual y un sistema de creencias que promueve la libertad personal y el auto-descubrimiento."),
            Pair("¿Se realizan sacrificios en Thelema?", "No, en Thelema no se practican sacrificios. Thelema se enfoca en la evolución personal y el respeto por la libertad y la voluntad de los demás."),
            Pair("¿Thelema está relacionada con la magia negra?", "No, Thelema no es magia negra. Es una corriente filosófica que utiliza la magia ceremonial como herramienta para alcanzar el autoconocimiento, siempre con respeto y responsabilidad."),
            Pair("¿Thelema es una religión?", "Thelema no se considera una religión en el sentido tradicional. Es más una filosofía o sistema de creencias espirituales, con un enfoque en la libertad y el cumplimiento de la propia voluntad."),
            Pair("¿Puedo practicar Thelema si soy de otra religión?", "Sí, Thelema es compatible con diversas creencias y prácticas espirituales, siempre que se respete la libertad y la voluntad de cada individuo."),
            Pair("¿Se hacen orgías en Thelema?", "No, en Thelema no se promueven ni se practican orgías. Thelema se centra en la libertad individual, el auto-descubrimiento y el respeto por los demás."),
            Pair("¿Cuál es el objetivo principal de Thelema?", "El objetivo principal de Thelema es el autoconocimiento y la búsqueda de la verdadera voluntad de cada individuo, basada en la libertad personal y el respeto por la voluntad de los demás."),
            Pair("¿Thelema está relacionada con la religión cristiana?", "No, Thelema no está relacionada con la religión cristiana. Aunque comparte ciertos principios éticos, Thelema es una filosofía que se enfoca en la libertad individual y el cumplimiento de la propia voluntad, sin seguir dogmas religiosos."),
            Pair("¿Cómo puedo saber cuál es mi verdadera voluntad?", "El autoconocimiento es clave para descubrir tu verdadera voluntad. A través de la meditación, la introspección y el estudio de los principios de Thelema, cada individuo puede llegar a comprender su camino y propósito en la vida."),
            Pair("¿Thelema está relacionada con el Tarot?", "Thelema tiene una relación estrecha con el Tarot, especialmente con el Tarot de Aleister Crowley (Thoth Tarot). El Tarot es una herramienta utilizada para el autoconocimiento y la interpretación simbólica dentro de la filosofía Thelemica.")
        )

        // Agregar preguntas y respuestas dinámicamente
        questions.forEach { (question, answer) ->
            val questionButton = Button(this).apply {
                text = question
                contentDescription = question  // Descripción accesible para los botones
                setOnClickListener {
                    // Verificar si la respuesta ya está agregada para evitar duplicados
                    val existingAnswerTextView = questionsContainer.findViewWithTag<TextView>(question)
                    if (existingAnswerTextView == null) {
                        // Crear un TextView para la respuesta
                        val answerTextView = TextView(this@PreguntasFrecuentesActivity).apply {
                            text = answer
                            textSize = 16f
                            setPadding(0, 16, 0, 16)  // Espaciado entre las respuestas
                            contentDescription = answer // Descripción accesible para las respuestas
                            tag = question  // Etiqueta única para evitar duplicados
                        }
                        // Agregar la respuesta debajo del botón de la pregunta
                        questionsContainer.addView(answerTextView)
                    }
                }
            }
            // Agregar el botón de la pregunta al contenedor
            questionsContainer.addView(questionButton)
        }

        // Crear un callback para el botón de retroceso
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Aquí puedes colocar lo que quieras que pase al presionar el botón de retroceso
                finish()  // Esto es equivalente a 'volver atrás'
            }
        }

        // Registrar el callback para el botón de retroceso
        onBackPressedDispatcher.addCallback(this, callback)
    }

    // Método con la firma correcta para ser usado en el XML
    fun volverAtras(view: View) {
        finish()  // Esto finaliza la actividad y regresa a la anterior
    }
}