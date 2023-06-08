package devandroid.glaucomv.applistacurso.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.glaucomv.applistacurso.R;
import devandroid.glaucomv.applistacurso.controller.PessoaController;
import devandroid.glaucomv.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    PessoaController controller;
    Pessoa pessoa;
    Pessoa outraPessoa;

    EditText editPrimeiroNome;
    EditText editSobreNomeAluno;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNomeAluno = findViewById(R.id.editSobreNomeAluno);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNomeAluno.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobreNomeAluno.setText("");
                editTelefoneContato.setText("");
                editNomeCurso.setText("");

                controller.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNomeAluno.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);

            }
        });

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());

    }
}