package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckNovoProntuario;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 10/11/2016.
 */

public class EditarProntuarioActivity extends AppCompatActivity{

    @Bind(R.id.tv_editar_nome_paciente)
    TextView tvNomePaciente;
    @Bind(R.id.tv_editar_num_prontuario)
    TextView tvNumProntuario;
    @Bind(R.id.ed_editar_idade)
    EditText edIdade;
    @Bind(R.id.ed_editar_peso)
    EditText edPeso;
    @Bind(R.id.ed_editar_altura)
    EditText edAltura;
    @Bind(R.id.ed_editar_comentarioFinal)
    EditText edComentario;
    @Bind(R.id.tv_editar_sexo)
    TextView tvSexo;

    static Prontuario prontuarioEditar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_prontuario);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            prontuarioEditar =(Prontuario) bundle.get("prontuario");
            tvNumProntuario.setText(prontuarioEditar.getNumProntuario());
            tvNomePaciente.setText(prontuarioEditar.getNomePaciente());
            tvSexo.setText(prontuarioEditar.getSexo());
            edIdade.setText(prontuarioEditar.getIdade().toString());
            edPeso.setText(prontuarioEditar.getPeso().toString());
            edAltura.setText(prontuarioEditar.getAltura().toString());
            edComentario.setText(prontuarioEditar.getComentario());
        }

    }

    @OnClick(R.id.bt_editar_salvar)
    public void salvarProntuario(){

        String pIdade = edIdade.getText().toString();
        if(!pIdade.isEmpty()){prontuarioEditar.setIdade(Integer.parseInt(pIdade));}
        if(!edPeso.getText().toString().isEmpty()){prontuarioEditar.setPeso(Integer.parseInt(edPeso.getText().toString()));}
        if(!edAltura.getText().toString().isEmpty()){prontuarioEditar.setAltura(Float.parseFloat(edAltura.getText().toString()));}
        prontuarioEditar.setComentario(edComentario.getText().toString());

        if(CheckNovoProntuario.checkCampos(prontuarioEditar, this)){
            Prontuario p = prontuarioEditar;
            p = CheckNovoProntuario.nadaConsta(p);
            ProntuarioDao.salvar(p, this);
            Toast.makeText(this, "Prontuario de N° " +p.getNumProntuario()+" foi salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Algum campo foi preenchido incorretamente", Toast.LENGTH_SHORT).show();
        }



    }

    @OnClick(R.id.bt_editar_voltar)
    public void voltar(){
        Intent intent = new Intent(this, ListarProntuariosActivity.class);
        startActivity(intent);
        finish();
    }
}
