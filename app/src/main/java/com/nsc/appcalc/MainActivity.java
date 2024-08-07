package com.nsc.appcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText n1, n2, n3, n4, numeroFaltas;
    private Button btCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        n1 = findViewById(R.id.Nota1);
        n2 = findViewById(R.id.Nota2);
        n3 = findViewById(R.id.Nota3);
        n4 = findViewById(R.id.Nota4);
        numeroFaltas = findViewById(R.id.NumeroFaltas);
        btCalcular = findViewById(R.id.btCalular);
        txtResultado = findViewById(R.id.txtResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nota1 = Integer.parseInt(n1.getText().toString());
                int nota2 = Integer.parseInt(n2.getText().toString());
                int nota3 = Integer.parseInt(n3.getText().toString());
                int nota4 = Integer.parseInt(n4.getText().toString());
                int numero_faltas = Integer.parseInt(numeroFaltas.getText().toString());
                int media = (nota1 + nota2 + nota3 + nota4)/4;

                if(media >= 7 && numero_faltas <=10) {
                    txtResultado.setText("Aluno aprovado e sua \n " +
                            "média é: " + media + "\n" +
                            " e o número de faltas é: " + numero_faltas);
                    txtResultado.setTextColor(getColor(R.color.green));
                } else if (numero_faltas >20) {
                    txtResultado.setText("aluno reprovado por faltas \n" +
                            " e sua média é: "+media);
                    txtResultado.setTextColor(getColor(R.color.red));
                }else if(media < 7) {
                    txtResultado.setText("Aluno reprovado por notas e sua \n" +
                            "média é "+media+ "\n" +
                            "mesmo tendo "+numero_faltas+" faltas");
                    txtResultado.setTextColor(getColor(R.color.red));
                }


            }
        });
    }
}