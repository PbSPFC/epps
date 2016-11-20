package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckProntuario;
import br.uninove.primeiraconsulta.util.NovoProntuarioUtil;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class NovoProntuarioActivity extends AppCompatActivity {

    TabHost tabHost;

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

    @Bind(R.id.ed_novo_sistole)
    EditText edSistole;
    @Bind(R.id.ed_novo_diastole)
    EditText edDiastole;
    @Bind(R.id.ed_novo_circ_cervical)
    EditText edCervical;
    @Bind(R.id.ed_novo_circ_cintura)
    EditText edCintura;
    @Bind(R.id.ed_novo_quadril)
    EditText edQuadril;
    @Bind(R.id.ed_novo_snellen_direita)
    EditText edSnellenDireita;
    @Bind(R.id.ed_novo_snellen_esquerda)
    EditText edSnellenEsquerda;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_prontuario);
        ButterKnife.bind(this);


        tabHost = (TabHost)findViewById(R.id.tab_novo_prontuario);
        tabHost.setup();

        TabHost.TabSpec specAnamnese = tabHost.newTabSpec("Anamnese");
        specAnamnese.setContent(R.id.tab_novo_anamnese);
        specAnamnese.setIndicator("Anamnese");

        TabHost.TabSpec specEstiloDeVida = tabHost.newTabSpec("Estilo de Vida / Habitos");
        specEstiloDeVida.setContent(R.id.tab_novo_estilo_de_vida);
        specEstiloDeVida.setIndicator("Estilo de Vida / Habitos");

        TabHost.TabSpec specExameFisico = tabHost.newTabSpec("Exame Físico");
        specExameFisico.setContent(R.id.tab_novo_exame_fisico);
        specExameFisico.setIndicator("Exame Físico");

        tabHost.addTab(specAnamnese);
        tabHost.addTab(specEstiloDeVida);
        tabHost.addTab(specExameFisico);


        rgSexo = (RadioGroup) findViewById(R.id.rg_novo_sexo_grupo);
        rgGordura = (RadioGroup) findViewById(R.id.rg_novo_gordura);

        rgFibra = (RadioGroup) findViewById(R.id.rg_novo_fibra);
        rgCalcio = (RadioGroup) findViewById(R.id.rg_novo_calcio);
        rgSodio = (RadioGroup) findViewById(R.id.rg_novo_sodio);
        rgAcucar = (RadioGroup) findViewById(R.id.rg_novo_doces);
        rgRefri = (RadioGroup) findViewById(R.id.rg_novo_refri);
        rgAgua = (RadioGroup) findViewById(R.id.rg_novo_agua);
        rgAtFisica = (RadioGroup) findViewById(R.id.rg_novo_atividade_fisica);

        rgSonoOpt1 = (RadioGroup) findViewById(R.id.rg_novo_sono_lendo);
        rgSonoOpt2 = (RadioGroup) findViewById(R.id.rg_novo_sono_tv);
        rgSonoOpt3 = (RadioGroup) findViewById(R.id.rg_novo_sono_publico);
        rgSonoOpt4 = (RadioGroup) findViewById(R.id.rg_novo_sono_carro);
        rgSonoOpt5 = (RadioGroup) findViewById(R.id.rg_novo_sono_almoco);
        rgSonoOpt6 = (RadioGroup) findViewById(R.id.rg_novo_sono_transito);

        rgCigarroAtivo = (RadioGroup) findViewById(R.id.rg_novo_tabagismo);
        rgCigarro1 = (RadioGroup) findViewById(R.id.rg_novo_tabagismo_1);
        rgCigarro2 = (RadioGroup) findViewById(R.id.rg_novo_tabagismo_2);
        rgCigarro3 = (RadioGroup) findViewById(R.id.rg_novo_tabagismo_3);
        rgCigarro4 = (RadioGroup) findViewById(R.id.rg_novo_tabagismo_4);
        rgCigarro5 = (RadioGroup) findViewById(R.id.rg_novo_tabagismo_5);
        rgCigarro6 = (RadioGroup) findViewById(R.id.rg_novo_tabagismo_6);

        rgAlcoolAtivo = (RadioGroup) findViewById(R.id.rg_novo_alcool);
        rgAlcool1 = (RadioGroup) findViewById(R.id.rg_novo_alcool_1);
        rgAlcool2 = (RadioGroup) findViewById(R.id.rg_novo_alcool_2);
        rgAlcool3 = (RadioGroup) findViewById(R.id.rg_novo_alcool_3);
        rgAlcool4 = (RadioGroup) findViewById(R.id.rg_novo_alcool_4);


    }

    @OnClick(R.id.bt_novo_cadastrar)
    public void novoProntuario() {

        Prontuario prontuario = new Prontuario();
        EstiloDeVida estiloDeVida = new EstiloDeVida();
        ExameFisico exameFisico = new ExameFisico();

        prontuario.setNumProntuario(edNumProntuario.getText().toString());
        estiloDeVida.setNumProntuario(edNumProntuario.getText().toString());
        exameFisico.setNumProntuario(edNumProntuario.getText().toString());

        prontuario = NovoProntuarioUtil.getNovoProntuario(prontuario, rgSexo, edIdade, edPeso, edAltura);


        //EXAME FISICO INICIO

        exameFisico = NovoProntuarioUtil.getNovoExameFisico(exameFisico, edSistole, edDiastole, prontuario, edCervical, edCintura, edQuadril, edSnellenDireita, edSnellenEsquerda);


        //EXAME FISICO FIM
        //ESTILO DE VIDA/HABITOS INICIO

        estiloDeVida = NovoProntuarioUtil.getNovoEstiloDeVida(estiloDeVida, rgGordura, rgFibra, rgCalcio, rgSodio, rgAcucar,
                rgRefri, rgAgua, rgAtFisica, rgSonoOpt1, rgSonoOpt2, rgSonoOpt3, rgSonoOpt4, rgSonoOpt5, rgSonoOpt6, rgCigarroAtivo,
                rgCigarro1, rgCigarro2, rgCigarro3, rgCigarro4, rgCigarro5, rgCigarro6, rgAlcoolAtivo, rgAlcool1, rgAlcool2, rgAlcool3,
                rgAlcool4);


        //ESTILO DE VIDA/HABITOS FIM

        
        prontuario.setComentario(edComentario.getText().toString());

        if (CheckProntuario.checkCampos(prontuario, this)) {

            prontuario = CheckProntuario.checkNumProntuario(prontuario, estiloDeVida, exameFisico, this);
            if (prontuario != null) {
                Toast.makeText(this, "Prontuario de N° " + prontuario.getNumProntuario() + " foi cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Não foi possível cadastrar prontuário, número do prontuário já está registrado!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Algum campo foi preenchido incorretamente", Toast.LENGTH_SHORT).show();
        }


    }


    @OnClick(R.id.bt_novo_voltar)
    public void voltar() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
