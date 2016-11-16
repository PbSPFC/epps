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
    @Bind(R.id.tv_ver_gordura)
    TextView tvGordura;
    @Bind(R.id.tv_ver_fibra)
    TextView tvFibra;
    @Bind(R.id.tv_ver_calcio)
    TextView tvCalcio;
    @Bind(R.id.tv_ver_sodio)
    TextView tvSodio;
    @Bind(R.id.tv_ver_acucar)
    TextView tvAcucar;
    @Bind(R.id.tv_ver_refri)
    TextView tvRefri;
    @Bind(R.id.tv_ver_agua)
    TextView tvAgua;
    @Bind(R.id.tv_ver_at_fisica)
    TextView tvAtFisica;
    @Bind(R.id.tv_ver_sono_pontos)
    TextView tvSonoPontos;
    @Bind(R.id.tv_ver_sono)
    TextView tvSono;
    @Bind(R.id.tv_ver_cigarro_1)
    TextView tvCigarro1;
    @Bind(R.id.tv_ver_cigarro_2)
    TextView tvCigarro2;
    @Bind(R.id.tv_ver_cigarro_3)
    TextView tvCigarro3;
    @Bind(R.id.tv_ver_cigarro_4)
    TextView tvCigarro4;
    @Bind(R.id.tv_ver_cigarro_5)
    TextView tvCigarro5;
    @Bind(R.id.tv_ver_cigarro_6)
    TextView tvCigarro6;
    @Bind(R.id.tv_ver_cigarro_pontos)
    TextView tvCigarroPontos;
    @Bind(R.id.tv_ver_cigarro)
    TextView tvCigarro;
    @Bind(R.id.tv_ver_alcool_1)
    TextView tvAlcool1;
    @Bind(R.id.tv_ver_alcool_2)
    TextView tvAlcool2;
    @Bind(R.id.tv_ver_alcool_3)
    TextView tvAlcool3;
    @Bind(R.id.tv_ver_alcool_4)
    TextView tvAlcool4;
    @Bind(R.id.tv_ver_alcool)
    TextView tvAlcool;

    @Bind(R.id.tv_ver_sistole)
    TextView tvSistole;
    @Bind(R.id.tv_ver_diastole)
    TextView tvDiastole;
    @Bind(R.id.tv_ver_imc)
    TextView tvImc;
    @Bind(R.id.tv_ver_circ_cervical)
    TextView tvCervical;
    @Bind(R.id.tv_ver_circ_cintura)
    TextView tvCintura;
    @Bind(R.id.tv_ver_quadril)
    TextView tvQuadril;
    @Bind(R.id.tv_ver_snellen_direita)
    TextView tvSnellenDireita;
    @Bind(R.id.tv_ver_snellen_esquerda)
    TextView tvSnellenEsquerda;

    @Bind(R.id.tv_ver_pa_resultado)
    TextView tvPaResultado;
    @Bind(R.id.tv_ver_imc_resultado)
    TextView tvImcResultado;
    @Bind(R.id.tv_ver_circ_cervical_resultado)
    TextView tvCervicalResultado;
    @Bind(R.id.tv_ver_circ_cintura_resultado)
    TextView tvCinturaResultado;
    @Bind(R.id.tv_ver_quadril_resultado)
    TextView tvQuadrilResultado;
    @Bind(R.id.tv_ver_snellen_resultado)
    TextView tvSnellenResultado;

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
            tvGordura.setText(prontuario.getGordura());
            tvFibra.setText(prontuario.getFibra());
            tvCalcio.setText(prontuario.getCalcio());
            tvSodio.setText(prontuario.getSodio());
            tvAcucar.setText(prontuario.getAcucar());
            tvRefri.setText(prontuario.getRefri());
            tvAgua.setText(prontuario.getAgua());
            tvAtFisica.setText(prontuario.getAtFisica());
            tvSonoPontos.setText(prontuario.getSonoPontos().toString());
            tvSono.setText(prontuario.getSono());
            tvCigarro1.setText(prontuario.getCigarro1());
            tvCigarro2.setText(prontuario.getCigarro2());
            tvCigarro3.setText(prontuario.getCigarro3());
            tvCigarro4.setText(prontuario.getCigarro4());
            tvCigarro5.setText(prontuario.getCigarro5());
            tvCigarro6.setText(prontuario.getCigarro6());
            tvCigarroPontos.setText(prontuario.getCigarroPontos().toString());
            tvCigarro.setText(prontuario.getCigarro());
            tvAlcool1.setText(prontuario.getAlcool1());
            tvAlcool2.setText(prontuario.getAlcool2());
            tvAlcool3.setText(prontuario.getAlcool3());
            tvAlcool4.setText(prontuario.getAlcool4());
            tvAlcool.setText(prontuario.getAlcool());

            tvSistole.setText(prontuario.getSistole().toString());
            tvDiastole.setText(prontuario.getDiastole().toString());
            tvImc.setText(prontuario.getImc().toString());
            tvCervical.setText(prontuario.getCervical().toString());
            tvCintura.setText(prontuario.getCintura().toString());
            tvQuadril.setText(prontuario.getQuadril().toString());
            tvSnellenDireita.setText(prontuario.getSnellenDireita().toString());
            tvSnellenEsquerda.setText(prontuario.getSnellenEsquerda().toString());

            tvPaResultado.setText(prontuario.getPaResultado());
            tvImcResultado.setText(prontuario.getImcResultado());
            tvCervicalResultado.setText(prontuario.getCervicalResultado());
            tvCinturaResultado.setText(prontuario.getCinturaResultado());
            tvQuadrilResultado.setText(prontuario.getQuadrilResultado());
            tvSnellenResultado.setText(prontuario.getSnellenResultado());
        }

    }

    @OnClick(R.id.bt_ver_voltar)
    public void voltar(){
        finish();
    }

}
