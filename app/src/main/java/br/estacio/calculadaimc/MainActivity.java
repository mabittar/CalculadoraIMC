package br.estacio.calculadaimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate;
    private EditText txtWeight;
    private EditText txtHeight;
    private EditText txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking XML components to Java variables
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        txtHeight = (EditText) findViewById(R.id.txtHeight);
        txtResult = (EditText) findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                double peso = Double.parseDouble(txtWeight.getText().toString());
                double altura = Double.parseDouble(txtHeight.getText().toString());
                double result = peso / (altura * altura);

                txtResult.setText(String.format("%.2f", result));

                // Dialog box creating
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.resultado);
                if(result < 18.5){
                    builder.setMessage(R.string.peso_baixo);
                }else if(result < 25){
                    builder.setMessage(R.string.peso_normal);
                }else if(result < 30){
                    builder.setMessage(R.string.sobre_peso);
                }else {
                    builder.setMessage(R.string.obsidade);
                }

                AlertDialog dialog = builder.create();
                dialog.show();

            }

        });
    }
}