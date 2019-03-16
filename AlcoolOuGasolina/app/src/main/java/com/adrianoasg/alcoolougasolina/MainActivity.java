package com.adrianoasg.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Localizar elementos da tela
        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Recuperar valor
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                if (textoPrecoAlcool.isEmpty() || textoPrecoGasolina.isEmpty()) {
                    //String vazia
                    textoResultado.setText("Preencha todos os campos!");
                } else {

                    //Converter valores string para numeros
                    Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                    Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                    //Álcool / Gasolina
                    double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7) {
                        //Gasolina
                        textoResultado.setText("É melhor utilizar Gasolina!");
                    } else {
                        //Álcool
                        textoResultado.setText("É melhor utilizar Álcool!!");
                    }
                }

            }
        });

    }
}
