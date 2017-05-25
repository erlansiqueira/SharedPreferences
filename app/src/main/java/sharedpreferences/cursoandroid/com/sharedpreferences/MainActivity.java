package sharedpreferences.cursoandroid.com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button salvar;
    private EditText editText;
    private TextView texto;

    private static  final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salvar = (Button) findViewById(R.id.SalvarId);
        editText = (EditText) findViewById(R.id.editTextId);
        texto = (TextView) findViewById(R.id.textoExibicaoId);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(texto.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha o nome", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("nome",  texto.getText().toString());
                    texto.setText("Ola, " + texto.getText().toString());
                }
            }
        });

        //recuperar os dadods salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if(sharedPreferences.contains("nome")) {
            String nomeUsuario = sharedPreferences.getString("nome", "usuario nao definido");
            texto.setText(nomeUsuario);
        } else {
            texto.setText("Ola, usuario nao definido");
        }

    }
}
