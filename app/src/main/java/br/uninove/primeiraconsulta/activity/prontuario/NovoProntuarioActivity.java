package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Scroller;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.activity.prontuario.Adapter.NovoListaProblemasAdapter;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckProntuario;
import br.uninove.primeiraconsulta.util.ListaProblemasUtil;
import br.uninove.primeiraconsulta.util.NovoProntuarioUtil;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class NovoProntuarioActivity extends AppCompatActivity {

    private static Context context;
    public static Context getContext(){
        return NovoProntuarioActivity.context;
    }

    TabHost tabHost;
    TabHost tabListaProblemas;




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

    @Bind(R.id.ed_novo_queixa)
    EditText edQueixa;
    @Bind(R.id.ed_novo_historia_doenca)
    EditText edHistoriaDoenca;
    @Bind(R.id.ed_novo_interrogatorio)
    EditText edInterrogatorio;
    @Bind(R.id.ed_novo_percepcao)
    EditText edPercepcao;

    @Bind(R.id.ed_novo_descricao_1)
    EditText edDescricao1;
    @Bind(R.id.ed_novo_descricao_2)
    EditText edDescricao2;
    @Bind(R.id.ed_novo_descricao_3)
    EditText edDescricao3;
    @Bind(R.id.ed_novo_descricao_4)
    EditText edDescricao4;
    @Bind(R.id.ed_novo_descricao_5)
    EditText edDescricao5;
    @Bind(R.id.ed_novo_descricao_6)
    EditText edDescricao6;
    @Bind(R.id.ed_novo_descricao_7)
    EditText edDescricao7;

    @Bind(R.id.ed_novo_acao_1)
    EditText edAcao1;
    @Bind(R.id.ed_novo_acao_2)
    EditText edAcao2;
    @Bind(R.id.ed_novo_acao_3)
    EditText edAcao3;
    @Bind(R.id.ed_novo_acao_4)
    EditText edAcao4;
    @Bind(R.id.ed_novo_acao_5)
    EditText edAcao5;
    @Bind(R.id.ed_novo_acao_6)
    EditText edAcao6;
    @Bind(R.id.ed_novo_acao_7)
    EditText edAcao7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NovoProntuarioActivity.context = getApplicationContext();
        setContentView(R.layout.activity_novo_prontuario);
        ButterKnife.bind(this);

        //TAB ANAMNESE, ESTILO DE VIDA, EXAME FISICO
        tabHost = (TabHost)findViewById(R.id.tab_novo_prontuario);
        tabHost.setup();

        TabHost.TabSpec specAnamnese = tabHost.newTabSpec("Anamnese");
        specAnamnese.setContent(R.id.tab_novo_anamnese);
        specAnamnese.setIndicator("Anamnese");

        TabHost.TabSpec specEstiloDeVida = tabHost.newTabSpec("Estilo de Vida");
        specEstiloDeVida.setContent(R.id.tab_novo_estilo_de_vida);
        specEstiloDeVida.setIndicator("Estilo de Vida");

        TabHost.TabSpec specExameFisico = tabHost.newTabSpec("Exame Físico");
        specExameFisico.setContent(R.id.tab_novo_exame_fisico);
        specExameFisico.setIndicator("Exame Físico");

        tabHost.addTab(specAnamnese);
        tabHost.addTab(specEstiloDeVida);
        tabHost.addTab(specExameFisico);

        //TAB LISTA DE PROBLEMAS
        tabListaProblemas = (TabHost)findViewById(R.id.tab_novo_lista_problemas);
        tabListaProblemas.setup();

        TabHost.TabSpec specLP1 = tabListaProblemas.newTabSpec("1");
        specLP1.setContent(R.id.tab_novo_lp_1);
        specLP1.setIndicator("1");

        TabHost.TabSpec specLP2 = tabListaProblemas.newTabSpec("2");
        specLP2.setContent(R.id.tab_novo_lp_2);
        specLP2.setIndicator("2");

        TabHost.TabSpec specLP3 = tabListaProblemas.newTabSpec("3");
        specLP3.setContent(R.id.tab_novo_lp_3);
        specLP3.setIndicator("3");

        TabHost.TabSpec specLP4 = tabListaProblemas.newTabSpec("4");
        specLP4.setContent(R.id.tab_novo_lp_4);
        specLP4.setIndicator("4");

        TabHost.TabSpec specLP5 = tabListaProblemas.newTabSpec("5");
        specLP5.setContent(R.id.tab_novo_lp_5);
        specLP5.setIndicator("5");

        TabHost.TabSpec specLP6 = tabListaProblemas.newTabSpec("6");
        specLP6.setContent(R.id.tab_novo_lp_6);
        specLP6.setIndicator("6");

        TabHost.TabSpec specLP7 = tabListaProblemas.newTabSpec("7");
        specLP7.setContent(R.id.tab_novo_lp_7);
        specLP7.setIndicator("7");

        tabListaProblemas.addTab(specLP1);
        tabListaProblemas.addTab(specLP2);
        tabListaProblemas.addTab(specLP3);
        tabListaProblemas.addTab(specLP4);
        tabListaProblemas.addTab(specLP5);
        tabListaProblemas.addTab(specLP6);
        tabListaProblemas.addTab(specLP7);


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

        edNumProntuario.requestFocus();
    }


    @OnClick(R.id.bt_novo_cadastrar)
    public void novoProntuario() {

        Prontuario prontuario = new Prontuario();
        EstiloDeVida estiloDeVida = new EstiloDeVida();
        ExameFisico exameFisico = new ExameFisico();
        Anamnese anamnese = new Anamnese();

        prontuario.setNumProntuario(edNumProntuario.getText().toString());
        estiloDeVida.setNumProntuario(edNumProntuario.getText().toString());
        exameFisico.setNumProntuario(edNumProntuario.getText().toString());
        anamnese.setNumProntuario(edNumProntuario.getText().toString());

        prontuario = NovoProntuarioUtil.getNovoProntuario(prontuario, rgSexo, edIdade, edPeso, edAltura);

        //ANAMNESE INICIO

        anamnese = NovoProntuarioUtil.getNovoAnamnese(anamnese, edQueixa, edHistoriaDoenca, edInterrogatorio, edPercepcao);

        //ANAMNESE FIM

        //EXAME FISICO INICIO

        exameFisico = NovoProntuarioUtil.getNovoExameFisico(exameFisico, edSistole, edDiastole, prontuario, edCervical, edCintura, edQuadril, edSnellenDireita, edSnellenEsquerda);


        //EXAME FISICO FIM
        //ESTILO DE VIDA/HABITOS INICIO

        estiloDeVida = NovoProntuarioUtil.getNovoEstiloDeVida(estiloDeVida, rgGordura, rgFibra, rgCalcio, rgSodio, rgAcucar,
                rgRefri, rgAgua, rgAtFisica, rgSonoOpt1, rgSonoOpt2, rgSonoOpt3, rgSonoOpt4, rgSonoOpt5, rgSonoOpt6, rgCigarroAtivo,
                rgCigarro1, rgCigarro2, rgCigarro3, rgCigarro4, rgCigarro5, rgCigarro6, rgAlcoolAtivo, rgAlcool1, rgAlcool2, rgAlcool3,
                rgAlcool4);


        //ESTILO DE VIDA/HABITOS FIM

        //LISTA DE PROBLEMAS INICIO

        List<ListaProblemas> listaProblemas = ListaProblemasUtil.getNewListaProb();
        listaProblemas.get(0).setDescricao(edDescricao1.getText().toString());
        listaProblemas.get(1).setDescricao(edDescricao2.getText().toString());
        listaProblemas.get(2).setDescricao(edDescricao3.getText().toString());
        listaProblemas.get(3).setDescricao(edDescricao4.getText().toString());
        listaProblemas.get(4).setDescricao(edDescricao5.getText().toString());
        listaProblemas.get(5).setDescricao(edDescricao6.getText().toString());
        listaProblemas.get(6).setDescricao(edDescricao7.getText().toString());

        listaProblemas.get(0).setAcao(edAcao1.getText().toString());
        listaProblemas.get(1).setAcao(edAcao2.getText().toString());
        listaProblemas.get(2).setAcao(edAcao3.getText().toString());
        listaProblemas.get(3).setAcao(edAcao4.getText().toString());
        listaProblemas.get(4).setAcao(edAcao5.getText().toString());
        listaProblemas.get(5).setAcao(edAcao6.getText().toString());
        listaProblemas.get(6).setAcao(edAcao7.getText().toString());



        //LISTA DE PROBLEMAS INICIO


        prontuario.setComentario(edComentario.getText().toString());

        if (CheckProntuario.checkCampos(prontuario, this)) {

            prontuario = CheckProntuario.checkNumProntuario(prontuario, estiloDeVida, exameFisico, anamnese, listaProblemas, this);
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


    /*private void atualizar() {
        NovoListaProblemasAdapter adapter = new NovoListaProblemasAdapter(this, ListaProblemasUtil.listaDeProblemas);
        lvListaProblemas.setAdapter(adapter);
    }

    @OnClick(R.id.bt_novo_add_lista_problemas)
    public void add_lista_problemas(){
        ListaProblemas lp = new ListaProblemas();
        lp.setDescricao("");
        lp.setAcao("");
        ListaProblemasUtil.listaDeProblemas.add(lp);
        atualizar();
    }*/

    @OnClick(R.id.bt_novo_voltar)
    public void voltar() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
