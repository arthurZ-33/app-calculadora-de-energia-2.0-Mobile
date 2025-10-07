package br.ulbra.calcularenergia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtvConsumo, txtvCusto;
    EditText txtPotencia, txtHoras, txtPreco;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtvConsumo = findViewById(R.id.txtvConsumo);
        txtvCusto = findViewById(R.id.txtvCusto);
        txtPotencia = findViewById(R.id.txtPotencia);
        txtHoras = findViewById(R.id.txtHoras);
        txtPreco = findViewById(R.id.txtPreco);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ce, c, h, p, pkwh;
                p = Double.parseDouble(txtPotencia.getText().toString());
                h = Double.parseDouble(txtHoras.getText().toString());
                pkwh = Double.parseDouble(txtPreco.getText().toString());

                ce = p * h/1000;
                c = ce * pkwh;

                txtvConsumo.setText("O seu consumo é de: " +  ce);
                txtvCusto.setText("O seu custo é de: " + c);
            }
        });

    }
    private void limpar(){
        txtPotencia.setText("");
        txtHoras.setText("");
        txtPreco.setText("");

    }
}