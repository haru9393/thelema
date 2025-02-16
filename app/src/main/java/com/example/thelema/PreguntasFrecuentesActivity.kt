package com.example.thelema

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreguntasFrecuentesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas_frecuentes)  // Asumiendo que crearemos este layout

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
            Pair("¿Se hacen orgías en Thelema?", "No, en Thelema no se promueven ni se practican orgías. Thelema se centra en la libertad individual, el auto-descubrimiento y el respeto por los demás.")
        )



        questions.forEach { (question, answer) ->
            val questionButton = Button(this).apply {
                text = question
                setOnClickListener {
                    val textView = TextView(this@PreguntasFrecuentesActivity)
                    textView.text = answer
                    questionsContainer.addView(textView)
                }
            }
            questionsContainer.addView(questionButton)
        }
    }
}
