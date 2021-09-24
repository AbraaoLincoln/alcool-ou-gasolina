package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("asdasd")
        val buttonCalcular: Button = findViewById(R.id.buttonCalcular)
        buttonCalcular.setOnClickListener {
            val tituloView: TextView = findViewById(R.id.textTituloView)
            val mediaAlcoolView: TextInputEditText = findViewById(R.id.mediaAlcoolView)
            val precoAlcoolView: TextInputEditText = findViewById(R.id.precoAlcoolView)
            val mediaGasolinaView: TextInputEditText = findViewById(R.id.mediaGasolinaView)
            val precoGasolinaView: TextInputEditText = findViewById(R.id.precoGasolinaView)
            val mediaAlcool: Double = if(mediaAlcoolView.text != null) mediaAlcoolView.text.toString().toDouble() else 0.0
            val precoAlcool: Double = if(precoAlcoolView.text != null) precoAlcoolView.text.toString().toDouble() else 0.0
            val mediaGasolina: Double = if(mediaGasolinaView.text != null) mediaGasolinaView.text.toString().toDouble() else 0.0
            val precoGasolina: Double = if(precoGasolinaView.text != null) precoGasolinaView.text.toString().toDouble() else 0.0

            /*
                1 - Divida o desempenho do etanol pelo desempenho da gasolina (se seu carro faz 7,3 km/litro com etanol e 10 km/l com gasolina,
                você deve dividir 7,3 por 10, que é igual a 0,73 ou 73%. Pronto, você achou o rendimento do carro com etanol).

                2 - Faça agora o cálculo da relação do preço etanol/gasolina na bomba: divida o valor do etanol pelo do da gasolina (exemplo:
                se o litro do etanol custou R$ 2,74 e o da gasolina R$ 4,64, a relação, então, é de 0,59 ou 59%).

                3 - A relação de preço acima (59%) dá uma enorme economia ao consumidor que optar por abastecer seu veículo com etanol. Se
                este cálculo resultar em 73%, por exemplo, o motorista também estará economizando ao optar pelo etanol.

             */

            val redimentoAlcool = if(mediaGasolina > 0) mediaAlcool / mediaGasolina else 0.0
            val relacaoPrecoAlcoolGasolina = if(precoGasolina > 0) precoAlcool / precoGasolina else 0.0

            if(relacaoPrecoAlcoolGasolina > redimentoAlcool) tituloView.text = "Gasolina" else tituloView.text = "Alcool"
        }
    }
}