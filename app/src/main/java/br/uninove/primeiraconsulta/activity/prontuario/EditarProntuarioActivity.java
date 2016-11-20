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
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.CheckProntuario;
import br.uninove.primeiraconsulta.util.EditarProntuarioUtil;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 10/11/2016.
 */

public class EditarProntuarioActivity extends AppCompatActivity {

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
    RadioGroup rgFibra;
    RadioGroup rgCalcio;
    RadioGroup rgSodio;
    RadioGroup rgAcucar;
    RadioGroup rgRefri;
    RadioGroup rgAgua;
    RadioGroup rgAtFisica;

    RadioGroup rgSonoOpt1;
    RadioGroup rgSonoOpt2;
    RadioGroup rgSonoOpt3;
    RadioGroup rgSonoOpt4;
    RadioGroup rgSonoOpt5;
    RadioGroup rgSonoOpt6;

    RadioGroup rgCigarroAtivo;
    RadioGroup rgCigarro1;
    RadioGroup rgCigarro2;
    RadioGroup rgCigarro3;
    RadioGroup rgCigarro4;
    RadioGroup rgCigarro5;
    RadioGroup rgCigarro6;

    RadioGroup rgAlcoolAtivo;
    RadioGroup rgAlcool1;
    RadioGroup rgAlcool2;
    RadioGroup rgAlcool3;
    RadioGroup rgAlcool4;

    @Bind(R.id.ed_editar_sistole)
    EditText edSistole;
    @Bind(R.id.ed_editar_diastole)
    EditText edDiastole;
    @Bind(R.id.ed_editar_circ_cervical)
    EditText edCervical;
    @Bind(R.id.ed_editar_circ_cintura)
    EditText edCintura;
    @Bind(R.id.ed_editar_quadril)
    EditText edQuadril;
    @Bind(R.id.ed_editar_snellen_direita)
    EditText edSnellenDireita;
    @Bind(R.id.ed_editar_snellen_esquerda)
    EditText edSnellenEsquerda;


    static Prontuario prontuario;
    static EstiloDeVida estiloDeVida;
    static ExameFisico exameFisico;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_prontuario);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            prontuario = (Prontuario) bundle.get("prontuario");
            estiloDeVida = EstiloDeVidaDao.buscarPorId(prontuario.getIdEstiloDeVida(), this);
            exameFisico = ExameFisicoDao.buscarPorId(prontuario.getIdExameFisico(), this);


            tvNumProntuario.setText(prontuario.getNumProntuario());
            tvSexo.setText(prontuario.getSexo());
            edIdade.setText(prontuario.getIdade().toString());
            edPeso.setText(prontuario.getPeso().toString());
            edAltura.setText(prontuario.getAltura().toString());
            edComentario.setText(prontuario.getComentario());
            
            edSistole.setText(exameFisico.getSistole().toString());
            edDiastole.setText(exameFisico.getDiastole().toString());
            edCervical.setText(exameFisico.getCervical().toString());
            edCintura.setText(exameFisico.getCintura().toString());
            edQuadril.setText(exameFisico.getQuadril().toString());
            edSnellenDireita.setText(exameFisico.getSnellenDireita().toString());
            edSnellenEsquerda.setText(exameFisico.getSnellenEsquerda().toString());

            rgGordura = (RadioGroup) findViewById(R.id.rg_editar_gordura);
            if (estiloDeVida.getGorduraOpt() != null) {
                rgGordura.check(estiloDeVida.getGorduraOpt());
            }
            rgFibra = (RadioGroup) findViewById(R.id.rg_editar_fibra);
            if (estiloDeVida.getFibraOpt() != null) {
                rgFibra.check(estiloDeVida.getFibraOpt());
            }
            rgCalcio = (RadioGroup) findViewById(R.id.rg_editar_calcio);
            if (estiloDeVida.getCalcioOpt() != null) {
                rgCalcio.check(estiloDeVida.getCalcioOpt());
            }
            rgSodio = (RadioGroup) findViewById(R.id.rg_editar_sodio);
            if (estiloDeVida.getSodioOpt() != null) {
                rgSodio.check(estiloDeVida.getSodioOpt());
            }
            rgAcucar = (RadioGroup) findViewById(R.id.rg_editar_doces);
            if (estiloDeVida.getAcucarOpt() != null) {
                rgAcucar.check(estiloDeVida.getAcucarOpt());
            }
            rgRefri = (RadioGroup) findViewById(R.id.rg_editar_refri);
            if (estiloDeVida.getRefriOpt() != null) {
                rgRefri.check(estiloDeVida.getRefriOpt());
            }
            rgAgua = (RadioGroup) findViewById(R.id.rg_editar_agua);
            if (estiloDeVida.getAguaOpt() != null) {
                rgAgua.check(estiloDeVida.getAguaOpt());
            }
            rgAtFisica = (RadioGroup) findViewById(R.id.rg_editar_atividade_fisica);
            if (estiloDeVida.getAtFisicaOpt() != null) {
                rgAtFisica.check(estiloDeVida.getAtFisicaOpt());
            }
            //Sono Opts
            rgSonoOpt1 = (RadioGroup) findViewById(R.id.rg_editar_sono_lendo);
            if (estiloDeVida.getSonoOpt1() != null) {
                rgSonoOpt1.check(estiloDeVida.getSonoOpt1());
            }
            rgSonoOpt2 = (RadioGroup) findViewById(R.id.rg_editar_sono_tv);
            if (estiloDeVida.getSonoOpt2() != null) {
                rgSonoOpt2.check(estiloDeVida.getSonoOpt2());
            }
            rgSonoOpt3 = (RadioGroup) findViewById(R.id.rg_editar_sono_publico);
            if (estiloDeVida.getSonoOpt3() != null) {
                rgSonoOpt3.check(estiloDeVida.getSonoOpt3());
            }
            rgSonoOpt4 = (RadioGroup) findViewById(R.id.rg_editar_sono_carro);
            if (estiloDeVida.getSonoOpt4() != null) {
                rgSonoOpt4.check(estiloDeVida.getSonoOpt4());
            }
            rgSonoOpt5 = (RadioGroup) findViewById(R.id.rg_editar_sono_almoco);
            if (estiloDeVida.getSonoOpt5() != null) {
                rgSonoOpt5.check(estiloDeVida.getSonoOpt5());
            }
            rgSonoOpt6 = (RadioGroup) findViewById(R.id.rg_editar_sono_transito);
            if (estiloDeVida.getSonoOpt6() != null) {
                rgSonoOpt6.check(estiloDeVida.getSonoOpt6());
            }

            rgCigarroAtivo = (RadioGroup) findViewById(R.id.rg_editar_tabagismo);
            if (estiloDeVida.getCigarroAtivoOpt() != null) {
                rgCigarroAtivo.check(estiloDeVida.getCigarroAtivoOpt());
            }
            rgCigarro1 = (RadioGroup) findViewById(R.id.rg_editar_tabagismo_1);
            if (estiloDeVida.getCigarroOpt1() != null) {
                rgCigarro1.check(estiloDeVida.getCigarroOpt1());
            }
            rgCigarro2 = (RadioGroup) findViewById(R.id.rg_editar_tabagismo_2);
            if (estiloDeVida.getCigarroOpt2() != null) {
                rgCigarro2.check(estiloDeVida.getCigarroOpt2());
            }
            rgCigarro3 = (RadioGroup) findViewById(R.id.rg_editar_tabagismo_3);
            if (estiloDeVida.getCigarroOpt3() != null) {
                rgCigarro3.check(estiloDeVida.getCigarroOpt3());
            }
            rgCigarro4 = (RadioGroup) findViewById(R.id.rg_editar_tabagismo_4);
            if (estiloDeVida.getCigarroOpt4() != null) {
                rgCigarro4.check(estiloDeVida.getCigarroOpt4());
            }
            rgCigarro5 = (RadioGroup) findViewById(R.id.rg_editar_tabagismo_5);
            if (estiloDeVida.getCigarroOpt5() != null) {
                rgCigarro5.check(estiloDeVida.getCigarroOpt5());
            }
            rgCigarro6 = (RadioGroup) findViewById(R.id.rg_editar_tabagismo_6);
            if (estiloDeVida.getCigarroOpt6() != null) {
                rgCigarro6.check(estiloDeVida.getCigarroOpt6());
            }
            rgAlcoolAtivo = (RadioGroup) findViewById(R.id.rg_editar_alcool);
            if (estiloDeVida.getAlcoolAtivoOpt() != null) {
                rgAlcoolAtivo.check(estiloDeVida.getAlcoolAtivoOpt());
            }
            rgAlcool1 = (RadioGroup) findViewById(R.id.rg_editar_alcool_1);
            if (estiloDeVida.getAlcoolOpt1() != null) {
                rgAlcool1.check(estiloDeVida.getAlcoolOpt1());
            }
            rgAlcool2 = (RadioGroup) findViewById(R.id.rg_editar_alcool_2);
            if (estiloDeVida.getAlcoolOpt2() != null) {
                rgAlcool2.check(estiloDeVida.getAlcoolOpt2());
            }
            rgAlcool3 = (RadioGroup) findViewById(R.id.rg_editar_alcool_3);
            if (estiloDeVida.getAlcoolOpt3() != null) {
                rgAlcool3.check(estiloDeVida.getAlcoolOpt3());
            }
            rgAlcool4 = (RadioGroup) findViewById(R.id.rg_editar_alcool_4);
            if (estiloDeVida.getAlcoolOpt4() != null) {
                rgAlcool4.check(estiloDeVida.getAlcoolOpt4());
            }
        }

    }

    @OnClick(R.id.bt_editar_salvar)
    public void salvarProntuario() {

        prontuario = EditarProntuarioUtil.getEditarProntuario(prontuario, edIdade, edPeso, edAltura);

        //EXAME FISICO INICIO

        exameFisico = EditarProntuarioUtil.getEditarExameFisico(exameFisico, edSistole, edDiastole, prontuario, edCervical, edCintura, edQuadril, edSnellenDireita, edSnellenEsquerda);

        //EXAME FISICO FIM
        //ESTILO DE VIDA/HABITOS INICIO

        estiloDeVida = EditarProntuarioUtil.getEstiloDeVida(estiloDeVida, rgGordura, rgFibra, rgCalcio, rgSodio, rgAcucar,
                rgRefri, rgAgua, rgAtFisica, rgSonoOpt1, rgSonoOpt2, rgSonoOpt3, rgSonoOpt4, rgSonoOpt5, rgSonoOpt6, rgCigarroAtivo,
                rgCigarro1, rgCigarro2, rgCigarro3, rgCigarro4, rgCigarro5, rgCigarro6, rgAlcoolAtivo, rgAlcool1, rgAlcool2, rgAlcool3,
                rgAlcool4);

        //ESTILO DE VIDA/HABITOS FIM

        prontuario.setComentario(edComentario.getText().toString());

        if (CheckProntuario.checkCampos(prontuario, this)) {
            Prontuario p = prontuario;
            EstiloDeVida eDV = estiloDeVida;
            ExameFisico eF = exameFisico;
            p = CheckProntuario.nadaConstaProntuario(p);
            eDV = CheckProntuario.nadaConstaEstiloDeVida(eDV);
            ProntuarioDao.salvar(p, this);
            EstiloDeVidaDao.salvar(eDV, this);
            ExameFisicoDao.salvar(eF, this);
            Toast.makeText(this, "Prontuario de N° " + p.getNumProntuario() + " foi salvo com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Algum campo foi preenchido incorretamente", Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.bt_editar_voltar)
    public void voltar() {
        Intent intent = new Intent(this, ListarProntuariosActivity.class);
        startActivity(intent);
        finish();
    }
}
