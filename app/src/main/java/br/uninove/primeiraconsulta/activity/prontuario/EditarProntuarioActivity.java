package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.CheckNovoProntuario;
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

    RadioGroup rgGordura;

    static Prontuario prontuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_prontuario);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            prontuario =(Prontuario) bundle.get("prontuario");
            tvNumProntuario.setText(prontuario.getNumProntuario());
            tvNomePaciente.setText(prontuario.getNomePaciente());
            tvSexo.setText(prontuario.getSexo());
            edIdade.setText(prontuario.getIdade().toString());
            edPeso.setText(prontuario.getPeso().toString());
            edAltura.setText(prontuario.getAltura().toString());
            edComentario.setText(prontuario.getComentario());

            rgGordura = (RadioGroup)findViewById(R.id.rg_editar_gordura);
            if(prontuario.getGorduraOpt() != null){
                rgGordura.check(prontuario.getGorduraOpt());
            }

        }

    }

    @OnClick(R.id.bt_editar_salvar)
    public void salvarProntuario(){

        String pIdade = edIdade.getText().toString();
        if(!pIdade.isEmpty()){
            prontuario.setIdade(Integer.parseInt(pIdade));}
        if(!edPeso.getText().toString().isEmpty()){
            prontuario.setPeso(Integer.parseInt(edPeso.getText().toString()));}
        if(!edAltura.getText().toString().isEmpty()){
            prontuario.setAltura(Float.parseFloat(edAltura.getText().toString()));}
        int gorduraEscolha = rgGordura.getCheckedRadioButtonId();
        if(gorduraEscolha == R.id.rb_editar_gordura_1){
            prontuario.setGorduraOpt(R.id.rb_editar_gordura_1);
            prontuario.setGordura("7 vezes na semana ou mais: frango com pele, carne com gordura, miúdos, frituras (alta ingesta).");
        } else if(gorduraEscolha == R.id.rb_editar_gordura_2){
            prontuario.setGorduraOpt(R.id.rb_editar_gordura_2);
            prontuario.setGordura("Abaixo de 7 vezes na semana (Ingesta adequada).");
        } else {
            prontuario.setGordura("");
        }


        prontuario.setComentario(edComentario.getText().toString());

        if(CheckNovoProntuario.checkCampos(prontuario, this)){
            Prontuario p = prontuario;
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
