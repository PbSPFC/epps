package br.uninove.primeiraconsulta.activity.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.util.CheckCadastro;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class CadastroUsuarioActivity extends AppCompatActivity {

    @Bind(R.id.ed_cad_nome)
    EditText edNome;

    @Bind(R.id.ed_cad_ra)
    EditText edRa;

    @Bind(R.id.ed_cad_senha)
    EditText edSenha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_cad_cadastrar)
    public void btCadastrar(){
        String nome = edNome.getText().toString();
        String ra = edRa.getText().toString();
        String senha = edSenha.getText().toString();

        if(CheckCadastro.checkRa(ra, this)){

            if(CheckCadastro.checkCampoInvalido(nome, ra, senha, this)){
                Toast.makeText(this, nome + " foi cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                finish();

            }else{
                Toast.makeText(this, "Algum campo está inválido!", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Esse RA já está cadastrado!", Toast.LENGTH_SHORT).show();
        }


    }
}
