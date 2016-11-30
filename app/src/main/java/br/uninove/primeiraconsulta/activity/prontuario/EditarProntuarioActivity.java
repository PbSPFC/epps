package br.uninove.primeiraconsulta.activity.prontuario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.log.LogAnamneseDao;
import br.uninove.primeiraconsulta.dao.log.LogEstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.log.LogExameFisicoDao;
import br.uninove.primeiraconsulta.dao.log.LogListaProblemasDao;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckListaProntuario;
import br.uninove.primeiraconsulta.util.CheckProntuario;
import br.uninove.primeiraconsulta.util.DataUtil;
import br.uninove.primeiraconsulta.util.EditarProntuarioUtil;
import br.uninove.primeiraconsulta.util.ListaProblemasUtil;
import br.uninove.primeiraconsulta.util.NovoProntuarioUtil;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 10/11/2016.
 */

public class EditarProntuarioActivity extends AppCompatActivity {

    TabHost tabHost;
    TabHost tabListaProblemas;



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
    @Bind(R.id.tv_editar_data)
    TextView tvData;
    @Bind(R.id.tv_editar_data_edicao)
    TextView tvDataEdicao;

    RadioGroup rgGordura;
    RadioGroup rgFibra;
    RadioGroup rgCalcio;
    RadioGroup rgSodio;
    RadioGroup rgAcucar;
    RadioGroup rgRefri;
    RadioGroup rgAgua;
    RadioGroup rgAtFisica;

    RadioGroup rgSexualmenteAtivo;

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

    @Bind(R.id.ed_editar_exame_comentario)
    EditText edExameComentario;

    @Bind(R.id.ed_editar_queixa)
    EditText edQueixa;
    @Bind(R.id.ed_editar_historia_doenca)
    EditText edHistoriaDoenca;
    @Bind(R.id.ed_editar_interrogatorio)
    EditText edInterrogatorio;
    @Bind(R.id.ed_editar_percepcao)
    EditText edPercepcao;

    @Bind(R.id.ed_editar_descricao_1)
    EditText edDescricao1;
    @Bind(R.id.ed_editar_descricao_2)
    EditText edDescricao2;
    @Bind(R.id.ed_editar_descricao_3)
    EditText edDescricao3;
    @Bind(R.id.ed_editar_descricao_4)
    EditText edDescricao4;
    @Bind(R.id.ed_editar_descricao_5)
    EditText edDescricao5;
    @Bind(R.id.ed_editar_descricao_6)
    EditText edDescricao6;
    @Bind(R.id.ed_editar_descricao_7)
    EditText edDescricao7;

    @Bind(R.id.ed_editar_acao_1)
    EditText edAcao1;
    @Bind(R.id.ed_editar_acao_2)
    EditText edAcao2;
    @Bind(R.id.ed_editar_acao_3)
    EditText edAcao3;
    @Bind(R.id.ed_editar_acao_4)
    EditText edAcao4;
    @Bind(R.id.ed_editar_acao_5)
    EditText edAcao5;
    @Bind(R.id.ed_editar_acao_6)
    EditText edAcao6;
    @Bind(R.id.ed_editar_acao_7)
    EditText edAcao7;

    private static Prontuario prontuario;
    private static EstiloDeVida estiloDeVida;
    private static ExameFisico exameFisico;
    private static Anamnese anamnese;
    private static List<ListaProblemas> listaProblemas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_prontuario);
        ButterKnife.bind(this);

        try {
            tabHost = (TabHost) findViewById(R.id.tab_editar_prontuario);
            tabHost.setup();

            TabHost.TabSpec specAnamnese = tabHost.newTabSpec("Anamnese");
            specAnamnese.setContent(R.id.tab_editar_anamnese);
            specAnamnese.setIndicator("Anamnese");

            TabHost.TabSpec specEstiloDeVida = tabHost.newTabSpec("Estilo de Vida");
            specEstiloDeVida.setContent(R.id.tab_editar_estilo_de_vida);
            specEstiloDeVida.setIndicator("Estilo de Vida");

            TabHost.TabSpec specExameFisico = tabHost.newTabSpec("Exame Físico");
            specExameFisico.setContent(R.id.tab_editar_exame_fisico);
            specExameFisico.setIndicator("Exame Físico");

            tabHost.addTab(specAnamnese);
            tabHost.addTab(specEstiloDeVida);
            tabHost.addTab(specExameFisico);

            //TAB LISTA DE PROBLEMAS
            tabListaProblemas = (TabHost) findViewById(R.id.tab_editar_lista_problemas);
            tabListaProblemas.setup();

            TabHost.TabSpec specLP1 = tabListaProblemas.newTabSpec("1");
            specLP1.setContent(R.id.tab_editar_lp_1);
            specLP1.setIndicator("1");

            TabHost.TabSpec specLP2 = tabListaProblemas.newTabSpec("2");
            specLP2.setContent(R.id.tab_editar_lp_2);
            specLP2.setIndicator("2");

            TabHost.TabSpec specLP3 = tabListaProblemas.newTabSpec("3");
            specLP3.setContent(R.id.tab_editar_lp_3);
            specLP3.setIndicator("3");

            TabHost.TabSpec specLP4 = tabListaProblemas.newTabSpec("4");
            specLP4.setContent(R.id.tab_editar_lp_4);
            specLP4.setIndicator("4");

            TabHost.TabSpec specLP5 = tabListaProblemas.newTabSpec("5");
            specLP5.setContent(R.id.tab_editar_lp_5);
            specLP5.setIndicator("5");

            TabHost.TabSpec specLP6 = tabListaProblemas.newTabSpec("6");
            specLP6.setContent(R.id.tab_editar_lp_6);
            specLP6.setIndicator("6");

            TabHost.TabSpec specLP7 = tabListaProblemas.newTabSpec("7");
            specLP7.setContent(R.id.tab_editar_lp_7);
            specLP7.setIndicator("7");

            tabListaProblemas.addTab(specLP1);
            tabListaProblemas.addTab(specLP2);
            tabListaProblemas.addTab(specLP3);
            tabListaProblemas.addTab(specLP4);
            tabListaProblemas.addTab(specLP5);
            tabListaProblemas.addTab(specLP6);
            tabListaProblemas.addTab(specLP7);
        }catch (Exception e){
            Log.e("editar", e.getMessage());
            Toast.makeText(this, "Ocorreu um erro na renderização da tela!", Toast.LENGTH_SHORT).show();
        }

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                prontuario = (Prontuario) bundle.get("prontuario");
                estiloDeVida = EstiloDeVidaDao.buscarPorId(prontuario.getIdEstiloDeVida(), this);
                exameFisico = ExameFisicoDao.buscarPorId(prontuario.getIdExameFisico(), this);
                anamnese = AnamneseDao.buscarPorId(prontuario.getIdAnamnese(), this);
                listaProblemas = ListaProblemasDao.buscarPorNumProntuario(prontuario, this);

                tvNumProntuario.setText(prontuario.getNumProntuario());
                tvSexo.setText(prontuario.getSexo());
                tvData.setText(prontuario.getData());
                tvDataEdicao.setText(prontuario.getDataEdicao());
                edIdade.setText(prontuario.getIdade().toString());
                edPeso.setText(prontuario.getPeso().toString());
                edAltura.setText(prontuario.getAltura().toString());
                edComentario.setText(prontuario.getComentario());

                edQueixa.setText(anamnese.getQueixa());
                edHistoriaDoenca.setText(anamnese.getHistoriaDoenca());
                edInterrogatorio.setText(anamnese.getInterrogatorio());
                edPercepcao.setText(anamnese.getPercepcao());

                edSistole.setText(exameFisico.getSistole().toString());
                edDiastole.setText(exameFisico.getDiastole().toString());
                edCervical.setText(exameFisico.getCervical().toString());
                edCintura.setText(exameFisico.getCintura().toString());
                edQuadril.setText(exameFisico.getQuadril().toString());
                edSnellenDireita.setText(exameFisico.getSnellenDireita().toString());
                edSnellenEsquerda.setText(exameFisico.getSnellenEsquerda().toString());
                edExameComentario.setText(exameFisico.getComentario());

                edDescricao1.setText(listaProblemas.get(0).getDescricao().toString());
                edDescricao2.setText(listaProblemas.get(1).getDescricao().toString());
                edDescricao3.setText(listaProblemas.get(2).getDescricao().toString());
                edDescricao4.setText(listaProblemas.get(3).getDescricao().toString());
                edDescricao5.setText(listaProblemas.get(4).getDescricao().toString());
                edDescricao6.setText(listaProblemas.get(5).getDescricao().toString());
                edDescricao7.setText(listaProblemas.get(6).getDescricao().toString());

                edAcao1.setText(listaProblemas.get(0).getAcao().toString());
                edAcao2.setText(listaProblemas.get(1).getAcao().toString());
                edAcao3.setText(listaProblemas.get(2).getAcao().toString());
                edAcao4.setText(listaProblemas.get(3).getAcao().toString());
                edAcao5.setText(listaProblemas.get(4).getAcao().toString());
                edAcao6.setText(listaProblemas.get(5).getAcao().toString());
                edAcao7.setText(listaProblemas.get(6).getAcao().toString());


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
                rgSexualmenteAtivo = (RadioGroup) findViewById(R.id.rg_editar_sexualmente_ativo);
                if (estiloDeVida.getSexualmenteAtivoOpt() != null) {
                    rgSexualmenteAtivo.check(estiloDeVida.getSexualmenteAtivoOpt());
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

            edIdade.requestFocus();
        }catch (Exception e){
            Log.e("setar valores no edtext", e.getMessage());
            Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @OnClick(R.id.bt_editar_salvar)
    public void salvarProntuario() {
        try {
            try {
                prontuario = EditarProntuarioUtil.getEditarProntuario(prontuario, edIdade, edPeso, edAltura);
            } catch (Exception e) {
                Log.e("getprontuario", e.getMessage());
                Toast.makeText(this, "Algum campo obrigatório foi preenchido incorretamente!", Toast.LENGTH_SHORT).show();
            }
            //ANAMNESE INICIO
            try {
                anamnese = EditarProntuarioUtil.getEditarAnamnese(anamnese, edQueixa, edHistoriaDoenca, edInterrogatorio, edPercepcao);
            } catch (Exception e) {
                Log.e("anamnese", e.getMessage());
                Toast.makeText(this, "Algum campo da aba Anamnese foi preenchido incorretamente!", Toast.LENGTH_SHORT).show();
            }
            //ANAMNESE FIM
            //EXAME FISICO INICIO
            try {
                exameFisico = EditarProntuarioUtil.getEditarExameFisico(exameFisico, edSistole, edDiastole, prontuario, edCervical, edCintura, edQuadril, edSnellenDireita, edSnellenEsquerda, edExameComentario);
            } catch (Exception e) {
                Log.e("exame fisico", e.getMessage());
                Toast.makeText(this, "Algum campo da aba Exame Físico foi preenchido incorretamente!", Toast.LENGTH_SHORT).show();
            }
            //EXAME FISICO FIM
            //ESTILO DE VIDA/HABITOS INICIO
            try {
                estiloDeVida = EditarProntuarioUtil.getEstiloDeVida(estiloDeVida, rgGordura, rgFibra, rgCalcio, rgSodio, rgAcucar,
                        rgRefri, rgAgua, rgAtFisica, rgSonoOpt1, rgSonoOpt2, rgSonoOpt3, rgSonoOpt4, rgSonoOpt5, rgSonoOpt6, rgCigarroAtivo,
                        rgCigarro1, rgCigarro2, rgCigarro3, rgCigarro4, rgCigarro5, rgCigarro6, rgAlcoolAtivo, rgAlcool1, rgAlcool2, rgAlcool3,
                        rgAlcool4, rgSexualmenteAtivo);
            } catch (Exception e) {
                Log.e("estilo de vida", e.getMessage());
                Toast.makeText(this, "Algum campo da aba Estilo de Vida foi preenchido incorretamente!", Toast.LENGTH_SHORT).show();
            }
            //ESTILO DE VIDA/HABITOS FIM

            //LISTA DE PROBLEMAS INICIO
            try {
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
            } catch (Exception e) {
                Log.e("lista de problemas", e.getMessage());
                Toast.makeText(this, "Verifique se a lista de problemas foi preenchida corretamente!", Toast.LENGTH_SHORT).show();
            }

            //LISTA DE PROBLEMAS INICIO
            try {
                prontuario.setComentario(edComentario.getText().toString());
            } catch (Exception e) {
                Log.e("comentario", e.getMessage());
                Toast.makeText(this, "Comentario foi preenchido incorretamente!", Toast.LENGTH_SHORT).show();
            }

            try {
                String data = DataUtil.getDate();

                prontuario.setDataEdicao(data);
                estiloDeVida.setDataEdicao(data);
                exameFisico.setDataEdicao(data);
                anamnese.setDataEdicao(data);
                listaProblemas.get(0).setDataEdicao(data);
                listaProblemas.get(1).setDataEdicao(data);
                listaProblemas.get(2).setDataEdicao(data);
                listaProblemas.get(3).setDataEdicao(data);
                listaProblemas.get(4).setDataEdicao(data);
                listaProblemas.get(5).setDataEdicao(data);
                listaProblemas.get(6).setDataEdicao(data);
            }catch (Exception e){
                Log.e("data", e.getMessage());
                Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
            }


            try {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);

                alert.setTitle("Confirmação");
                alert.setMessage("Digite sua senha para salvar o prontuário.");

                // Set an EditText view to get user input
                final EditText input = new EditText(this);
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        if (input.getText().toString().equals(SessaoUsuario.getUsuarioSessao().getSenha())
                                || input.getText().toString().equals(SessaoUsuario.getSenha())) {
                            try {
                                if (CheckProntuario.checkCampos(prontuario, EditarProntuarioActivity.this)) {
                                    prontuario = CheckProntuario.nadaConstaProntuario(prontuario);
                                    estiloDeVida = CheckProntuario.nadaConstaEstiloDeVida(estiloDeVida);
                                    anamnese = CheckProntuario.nadaConstaAnamnese(anamnese);
                                    listaProblemas = CheckProntuario.nadaConstaListaProb(listaProblemas);

                                    ProntuarioDao.salvar(prontuario, EditarProntuarioActivity.this);
                                    AnamneseDao.salvar(anamnese, EditarProntuarioActivity.this);
                                    EstiloDeVidaDao.salvar(estiloDeVida, EditarProntuarioActivity.this);
                                    ExameFisicoDao.salvar(exameFisico, EditarProntuarioActivity.this);
                                    ListaProblemasDao.salvar(listaProblemas, prontuario, EditarProntuarioActivity.this);

                                    LogEstiloDeVidaDao.salvar(estiloDeVida, EditarProntuarioActivity.this);
                                    LogExameFisicoDao.salvar(exameFisico, EditarProntuarioActivity.this);
                                    LogAnamneseDao.salvar(anamnese, EditarProntuarioActivity.this);
                                    LogListaProblemasDao.salvar(listaProblemas, prontuario, EditarProntuarioActivity.this);
                                    estiloDeVida = LogEstiloDeVidaDao.buscarPorNumProntuario(prontuario, EditarProntuarioActivity.this);
                                    exameFisico = LogExameFisicoDao.buscarPorNumProntuario(prontuario, EditarProntuarioActivity.this);
                                    anamnese = LogAnamneseDao.buscarPorNumProntuario(prontuario, EditarProntuarioActivity.this);
                                    prontuario.setIdEstiloDeVida(estiloDeVida.getId());
                                    prontuario.setIdExameFisico(exameFisico.getId());
                                    prontuario.setIdAnamnese(anamnese.getId());
                                    LogProntuarioDao.salvar(prontuario, EditarProntuarioActivity.this);

                                    Toast.makeText(EditarProntuarioActivity.this, "Prontuario de N° " + prontuario.getNumProntuario() + " foi salvo com sucesso!", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(EditarProntuarioActivity.this, "Algum campo foi preenchido incorretamente", Toast.LENGTH_SHORT).show();
                                }
                            }catch (Exception e){
                                Log.e("salvar", e.getMessage());
                                Toast.makeText(EditarProntuarioActivity.this, "Ocorreu um erro ao salvar, algum campo foi preenchido incorretamente!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(EditarProntuarioActivity.this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();
            }catch (Exception e){
                Log.e("alert salvar senha", e.getMessage());
                Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Log.e("btSalvar-editar", e.getMessage());
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
