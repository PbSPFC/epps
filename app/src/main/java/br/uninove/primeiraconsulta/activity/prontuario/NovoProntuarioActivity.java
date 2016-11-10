package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioGroup;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class NovoProntuarioActivity extends AppCompatActivity {

    @Bind(R.id.ed_novo_nome_paciente)
    EditText edNomePaciente;
    @Bind(R.id.ed_novo_num_prontuario)
    EditText edNumProntuario;
    @Bind(R.id.ed_novo_idade)
    EditText edIdade;
    @Bind(R.id.ed_novo_peso)
    EditText edPeso;
    @Bind(R.id.ed_novo_altura)
    EditText edAltura;
    @Bind(R.id.ed_novo_comentarioFinal)
    EditText edComentario;

    RadioGroup rg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_prontuario);
        ButterKnife.bind(this);
        rg = (RadioGroup)findViewById(R.id.rg_novo_sexo_grupo);

    }

    @OnClick(R.id.bt_novo_cadastrar)
    public void novoProntuario(){
        String numProntuario = edNumProntuario.getText().toString();
        String nomePaciente = edNomePaciente.getText().toString();
        Usuario usuario = SessaoUsuario.getUsuarioSessao();
        String sexo = "Feminino";
        int sexoEscolha = rg.getCheckedRadioButtonId();
        if(sexoEscolha == R.id.rb_novo_masculino){sexo = "Masculino";}
        Integer idade = Integer.parseInt(edIdade.getText().toString());
        Integer peso = Integer.parseInt(edPeso.getText().toString());
        Float altura = Float.parseFloat(edAltura.getText().toString());
        String comentario = edComentario.getText().toString();




    }

    @OnClick(R.id.bt_novo_voltar)
    public void voltar(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
