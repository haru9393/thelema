package com.example.thelema

import android.content.Context
import android.text.TextUtils // Importa TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ThemesAdapter(context: Context, resource: Int, objects: List<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    private val verses = mapOf(
        "Amor" to "Amor es la ley, amor bajo voluntad. (Liber AL vel Legis 1:57)",
        "Enojo" to "No te detengas por el odio. Deja que todo se haga según la voluntad. (Liber AL vel Legis 3:42)",
        "Ansiedad" to "Nada hay que temer en el camino de la voluntad. (Liber AL vel Legis 2:70)",
        "Esperanza" to "Hay ayuda y esperanza en nuestra vida. (Liber AL vel Legis 2:21)",
        "Paz" to "Sé fuerte, oh hombre, en la alegría de tu fuerza. (Liber AL vel Legis 2:66)",
        "Temor" to "No temas nada, no dudes en absoluto. (Liber AL vel Legis 3:17)",
        "Paciencia" to "Sigue tu voluntad sin apurarte. (Liber AL vel Legis 1:44)",
        "Orgullo" to "Sé orgulloso de tu voluntad y síguela con pasión. (Liber AL vel Legis 2:30)",
        "Tentación" to "No hay ley más allá de Haz tu voluntad. (Liber AL vel Legis 3:60)",
        "Duda" to "No dudes de tu camino, pues es el camino de la estrella. (Liber AL vel Legis 2:7)",
        "Gozo" to "Vive con alegría, pues el gozo es poder. (Liber AL vel Legis 2:9)",
        "Estrés" to "Relájate en la danza de la vida. (Liber AL vel Legis 2:22)",
        "Sanidad" to "El cuerpo es un templo, cuídalo y fortalécelo. (Liber AL vel Legis 2:56)"
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)

        val theme = getItem(position)
        val verse = verses[theme] ?: "No hay versículo disponible"

        val text1 = view.findViewById<TextView>(android.R.id.text1)
        val text2 = view.findViewById<TextView>(android.R.id.text2)

        text1.text = theme
        text2.text = verse

        text1.textSize = 16f
        text2.textSize = 14f
        text1.maxLines = 1
        text2.maxLines = 1
        text1.ellipsize = TextUtils.TruncateAt.END // Usa TextUtils.TruncateAt.END
        text2.ellipsize = TextUtils.TruncateAt.END // Usa TextUtils.TruncateAt.END

        return view
    }
}