package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class VerProntuarioActivity extends AppCompatActivity{

    @Bind(R.id.tv_ver_num_prontuario)
    TextView tvNumPronturario;
    @Bind(R.id.tv_ver_nome_usuario)
    TextView tvNomeUsuario;
    @Bind(R.id.tv_ver_ra)
    TextView tvRa;
    @Bind(R.id.tv_ver_nome_paciente)
    TextView tvPaciente;
    @Bind(R.id.tv_ver_sexo)
    TextView tvSexo;
    @Bind(R.id.tv_ver_idade)
    TextView tvIdade;
    @Bind(R.id.tv_ver_peso)
    TextView tvPeso;
    @Bind(R.id.tv_ver_altura)
    TextView tvAltura;
    @Bind(R.id.tv_ver_comentario)
    TextView tvComentario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prontuario);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            Prontuario prontuario =(Prontuario) bundle.get("prontuario");
            tvNumPronturario.setText(prontuario.getNumProntuario());
            tvNomeUsuario.setText(prontuario.getNomeMedico());
            tvRa.setText(prontuario.getRaUsuario());
            tvPaciente.setText(prontuario.getNomePaciente());
            tvSexo.setText(prontuario.getSexo());
            tvIdade.setText(prontuario.getIdade().toString());
            tvPeso.setText(prontuario.getPeso().toString());
            tvAltura.setText(prontuario.getAltura().toString());
            tvComentario.setText(prontuario.getComentario());
        }

    }

    @OnClick(R.id.bt_ver_voltar)
    public void voltar(){
        finish();
    }

}
