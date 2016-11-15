package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckNovoProntuario;
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

    RadioGroup rgSexo;
    RadioGroup rgGordura;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_prontuario);
        ButterKnife.bind(this);
        rgSexo = (RadioGroup)findViewById(R.id.rg_novo_sexo_grupo);
        rgGordura = (RadioGroup)findViewById(R.id.rg_novo_gordura);

    }

    @OnClick(R.id.bt_novo_cadastrar)
    public void novoProntuario(){

        Prontuario prontuario = new Prontuario();

        prontuario.setNumProntuario(edNumProntuario.getText().toString());
        prontuario.setNomePaciente(edNomePaciente.getText().toString());
        Usuario usuario = SessaoUsuario.getUsuarioSessao();
        prontuario.setIdUsuario(usuario.getId());
        prontuario.setRaUsuario(usuario.getRa());
        prontuario.setNomeMedico(usuario.getNome());

        String sexo = "Feminino";
        int sexoEscolha = rgSexo.getCheckedRadioButtonId();
        if(sexoEscolha == R.id.rb_novo_masculino){sexo = "Masculino";}
        prontuario.setSexo(sexo);

        String pIdade = edIdade.getText().toString();
        if(!pIdade.isEmpty()){prontuario.setIdade(Integer.parseInt(pIdade));}
        if(!edPeso.getText().toString().isEmpty()){prontuario.setPeso(Integer.parseInt(edPeso.getText().toString()));}
        if(!edAltura.getText().toString().isEmpty()){prontuario.setAltura(Float.parseFloat(edAltura.getText().toString()));}

        prontuario.setComentario(edComentario.getText().toString());

        int gorduraEscolha = rgGordura.getCheckedRadioButtonId();
        if(gorduraEscolha == R.id.rb_novo_gordura_1){
            prontuario.setGorduraOpt(R.id.rb_editar_gordura_1);
            prontuario.setGordura("7 vezes na semana ou mais: frango com pele, carne com gordura, miúdos, frituras (alta ingesta).");
        } else if(gorduraEscolha == R.id.rb_novo_gordura_2){
            prontuario.setGorduraOpt(R.id.rb_editar_gordura_2);
            prontuario.setGordura("Abaixo de 7 vezes na semana (Ingesta adequada).");
        } else {
            prontuario.setGordura("");
        }

        if(CheckNovoProntuario.checkCampos(prontuario, this)){

            prontuario = CheckNovoProntuario.checkNumProntuario(prontuario, this);
            if(prontuario != null) {
                Toast.makeText(this, "Prontuario de N° " +prontuario.getNumProntuario()+" foi cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, "Não foi possível cadastrar prontuário, número do prontuário já está registrado!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Algum campo foi preenchido incorretamente", Toast.LENGTH_SHORT).show();
        }



    }

    @OnClick(R.id.bt_novo_voltar)
    public void voltar(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
