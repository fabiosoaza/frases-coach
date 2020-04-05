package com.example.frasesdecoach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gerarFraseMotivacional()

        btnGerarFrase.setOnClickListener(View.OnClickListener {
            gerarFraseMotivacional()
        })

    }

    private fun gerarFraseMotivacional(){
        atualizarFrase( sortearFrase())
    }

    private fun sortearFrase(): String {
        val frases: Array<String> = resources.getStringArray(R.array.statements)
        val indexFrase = (frases.indices).shuffled().first()
        return frases[indexFrase]
    }

    private fun atualizarFrase(frase: String) {
        val textFrase =   findViewById<TextView>(R.id.textStatement)
        textFrase.text = frase
        textFrase.contentDescription = frase
        textFrase.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED)
    }


}
