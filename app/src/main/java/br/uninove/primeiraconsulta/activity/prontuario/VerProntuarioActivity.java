package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.prontuario.adapter.RastreamentoAdapter;
import br.uninove.primeiraconsulta.activity.prontuario.adapter.RastreamentoTextoAdapter;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Rastreamento;
import br.uninove.primeiraconsulta.util.EmailUtil;
import br.uninove.primeiraconsulta.util.RastreamentoUtil;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class VerProntuarioActivity extends AppCompatActivity{

    TabHost tabHost;
    TabHost tabListaProblemas;
    TabHost tabRastreamento;
    @Bind(R.id.list_rastreamento)
    ListView lvRastreamento;
    @Bind(R.id.list_rastreamento_texto)
    ListView lvRastreamentoTexto;


    @Bind(R.id.tv_ver_num_prontuario)
    TextView tvNumPronturario;
    @Bind(R.id.tv_ver_nome_usuario)
    TextView tvNomeUsuario;
    @Bind(R.id.tv_ver_ra)
    TextView tvRa;
    @Bind(R.id.tv_ver_data)
    TextView tvData;
    @Bind(R.id.tv_ver_data_edicao)
    TextView tvDataEdicao;
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
    @Bind(R.id.tv_ver_sexualmente_ativo)
    TextView tvSexualmenteAtivo;
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
    @Bind(R.id.tv_ver_exame_comentario)
    TextView tvExameComentario;

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

    @Bind(R.id.tv_ver_queixa)
    TextView tvQueixa;
    @Bind(R.id.tv_ver_historia_doenca)
    TextView tvHistoriaDoenca;
    @Bind(R.id.tv_ver_interrogatorio)
    TextView tvInterrogatorio;
    @Bind(R.id.tv_ver_percepcao)
    TextView tvPercepcao;

    @Bind(R.id.tv_ver_descricao_1)
    TextView tvDescricao1;
    @Bind(R.id.tv_ver_descricao_2)
    TextView tvDescricao2;
    @Bind(R.id.tv_ver_descricao_3)
    TextView tvDescricao3;
    @Bind(R.id.tv_ver_descricao_4)
    TextView tvDescricao4;
    @Bind(R.id.tv_ver_descricao_5)
    TextView tvDescricao5;
    @Bind(R.id.tv_ver_descricao_6)
    TextView tvDescricao6;
    @Bind(R.id.tv_ver_descricao_7)
    TextView tvDescricao7;

    @Bind(R.id.tv_ver_acao_1)
    TextView tvAcao1;
    @Bind(R.id.tv_ver_acao_2)
    TextView tvAcao2;
    @Bind(R.id.tv_ver_acao_3)
    TextView tvAcao3;
    @Bind(R.id.tv_ver_acao_4)
    TextView tvAcao4;
    @Bind(R.id.tv_ver_acao_5)
    TextView tvAcao5;
    @Bind(R.id.tv_ver_acao_6)
    TextView tvAcao6;
    @Bind(R.id.tv_ver_acao_7)
    TextView tvAcao7;

    @Bind(R.id.tv_rastreamento_referencias)
    TextView tvReferencias;

    @Bind(R.id.edFocus)
    EditText edFocus;

    private static Prontuario prontuario;
    private static EstiloDeVida estiloDeVida;
    private static ExameFisico exameFisico;
    private static Anamnese anamnese;
    private static List<ListaProblemas> listaProblemas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prontuario);
        ButterKnife.bind(this);

        tabHost = (TabHost)findViewById(R.id.tab_ver_prontuario);
        tabHost.setup();

        TabHost.TabSpec specAnamnese = tabHost.newTabSpec("Anamnese");
        specAnamnese.setContent(R.id.tab_ver_anamnese);
        specAnamnese.setIndicator("Anamnese");

        TabHost.TabSpec specEstiloDeVida = tabHost.newTabSpec("Estilo de Vida");
        specEstiloDeVida.setContent(R.id.tab_ver_estilo_de_vida);
        specEstiloDeVida.setIndicator("Estilo de Vida");

        TabHost.TabSpec specExameFisico = tabHost.newTabSpec("Exame Físico");
        specExameFisico.setContent(R.id.tab_ver_exame_fisico);
        specExameFisico.setIndicator("Exame Físico");

        tabHost.addTab(specAnamnese);
        tabHost.addTab(specEstiloDeVida);
        tabHost.addTab(specExameFisico);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                tabHost.clearFocus();
            }
        });

        //TAB LISTA DE PROBLEMAS
        tabListaProblemas = (TabHost)findViewById(R.id.tab_ver_lista_problemas);
        tabListaProblemas.setup();

        TabHost.TabSpec specLP1 = tabListaProblemas.newTabSpec("1");
        specLP1.setContent(R.id.tab_ver_lp_1);
        specLP1.setIndicator("1");

        TabHost.TabSpec specLP2 = tabListaProblemas.newTabSpec("2");
        specLP2.setContent(R.id.tab_ver_lp_2);
        specLP2.setIndicator("2");

        TabHost.TabSpec specLP3 = tabListaProblemas.newTabSpec("3");
        specLP3.setContent(R.id.tab_ver_lp_3);
        specLP3.setIndicator("3");

        TabHost.TabSpec specLP4 = tabListaProblemas.newTabSpec("4");
        specLP4.setContent(R.id.tab_ver_lp_4);
        specLP4.setIndicator("4");

        TabHost.TabSpec specLP5 = tabListaProblemas.newTabSpec("5");
        specLP5.setContent(R.id.tab_ver_lp_5);
        specLP5.setIndicator("5");

        TabHost.TabSpec specLP6 = tabListaProblemas.newTabSpec("6");
        specLP6.setContent(R.id.tab_ver_lp_6);
        specLP6.setIndicator("6");

        TabHost.TabSpec specLP7 = tabListaProblemas.newTabSpec("7");
        specLP7.setContent(R.id.tab_ver_lp_7);
        specLP7.setIndicator("7");

        tabListaProblemas.addTab(specLP1);
        tabListaProblemas.addTab(specLP2);
        tabListaProblemas.addTab(specLP3);
        tabListaProblemas.addTab(specLP4);
        tabListaProblemas.addTab(specLP5);
        tabListaProblemas.addTab(specLP6);
        tabListaProblemas.addTab(specLP7);

        tabListaProblemas.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                tabListaProblemas.clearFocus();
            }
        });

        //TAB RASTREAMENTO
        tabRastreamento = (TabHost)findViewById(R.id.tab_ver_rastreamento);
        tabRastreamento.setup();

        TabHost.TabSpec specRastreamento = tabRastreamento.newTabSpec("Rastreamento");
        specRastreamento.setContent(R.id.tab_rastreamento);
        specRastreamento.setIndicator("Rastreamento");

        TabHost.TabSpec specRastreamentoTexto = tabRastreamento.newTabSpec("Texto");
        specRastreamentoTexto.setContent(R.id.tab_rastreamento_texto);
        specRastreamentoTexto.setIndicator("Texto");

        tabRastreamento.addTab(specRastreamento);
        tabRastreamento.addTab(specRastreamentoTexto);
        tabRastreamento.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                tabRastreamento.clearFocus();
            }
        });


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            prontuario = (Prontuario) bundle.get("prontuario");
            estiloDeVida = (EstiloDeVida) bundle.get("estiloDeVida");
            exameFisico = (ExameFisico) bundle.get("exameFisico");
            anamnese = (Anamnese) bundle.get("anamnese");
            listaProblemas = (List<ListaProblemas>) bundle.get("listaProblemas");
            List<Rastreamento> listaRastreamento = RastreamentoUtil.getRastreamento(prontuario, estiloDeVida, exameFisico);


            tvNumPronturario.setText(prontuario.getNumProntuario());
            tvNomeUsuario.setText(prontuario.getNomeMedico());
            tvRa.setText(prontuario.getRaUsuario());
            tvData.setText(prontuario.getData());
            tvDataEdicao.setText(prontuario.getDataEdicao());
            tvSexo.setText(prontuario.getSexo());
            tvIdade.setText(prontuario.getIdade().toString());
            tvPeso.setText(prontuario.getPeso().toString());
            tvAltura.setText(prontuario.getAltura().toString());
            tvComentario.setText(prontuario.getComentario());

            tvQueixa.setText(anamnese.getQueixa());
            tvHistoriaDoenca.setText(anamnese.getHistoriaDoenca());
            tvInterrogatorio.setText(anamnese.getInterrogatorio());
            tvPercepcao.setText(anamnese.getPercepcao());

            tvGordura.setText(estiloDeVida.getGordura());
            tvFibra.setText(estiloDeVida.getFibra());
            tvCalcio.setText(estiloDeVida.getCalcio());
            tvSodio.setText(estiloDeVida.getSodio());
            tvAcucar.setText(estiloDeVida.getAcucar());
            tvRefri.setText(estiloDeVida.getRefri());
            tvAgua.setText(estiloDeVida.getAgua());
            tvAtFisica.setText(estiloDeVida.getAtFisica());
            tvSexualmenteAtivo.setText(estiloDeVida.getSexualmenteAtivo());
            tvSonoPontos.setText(estiloDeVida.getSonoPontos().toString());
            tvSono.setText(estiloDeVida.getSono());
            tvCigarro1.setText(estiloDeVida.getCigarro1());
            tvCigarro2.setText(estiloDeVida.getCigarro2());
            tvCigarro3.setText(estiloDeVida.getCigarro3());
            tvCigarro4.setText(estiloDeVida.getCigarro4());
            tvCigarro5.setText(estiloDeVida.getCigarro5());
            tvCigarro6.setText(estiloDeVida.getCigarro6());
            tvCigarroPontos.setText(estiloDeVida.getCigarroPontos().toString());
            tvCigarro.setText(estiloDeVida.getCigarro());
            tvAlcool1.setText(estiloDeVida.getAlcool1());
            tvAlcool2.setText(estiloDeVida.getAlcool2());
            tvAlcool3.setText(estiloDeVida.getAlcool3());
            tvAlcool4.setText(estiloDeVida.getAlcool4());
            tvAlcool.setText(estiloDeVida.getAlcool());

            tvSistole.setText(exameFisico.getSistole().toString());
            tvDiastole.setText(exameFisico.getDiastole().toString());
            tvImc.setText(exameFisico.getImc().toString());
            tvCervical.setText(exameFisico.getCervical().toString());
            tvCintura.setText(exameFisico.getCintura().toString());
            tvQuadril.setText(exameFisico.getQuadril().toString());
            tvSnellenDireita.setText(exameFisico.getSnellenDireita().toString());
            tvSnellenEsquerda.setText(exameFisico.getSnellenEsquerda().toString());
            tvExameComentario.setText(exameFisico.getComentario().toString());

            tvPaResultado.setText(exameFisico.getPaResultado());
            tvImcResultado.setText(exameFisico.getImcResultado());
            tvCervicalResultado.setText(exameFisico.getCervicalResultado());
            tvCinturaResultado.setText(exameFisico.getCinturaResultado());
            tvQuadrilResultado.setText(exameFisico.getQuadrilResultado());
            tvSnellenResultado.setText(exameFisico.getSnellenResultado());

            tvDescricao1.setText(listaProblemas.get(0).getDescricao());
            tvDescricao2.setText(listaProblemas.get(1).getDescricao());
            tvDescricao3.setText(listaProblemas.get(2).getDescricao());
            tvDescricao4.setText(listaProblemas.get(3).getDescricao());
            tvDescricao5.setText(listaProblemas.get(4).getDescricao());
            tvDescricao6.setText(listaProblemas.get(5).getDescricao());
            tvDescricao7.setText(listaProblemas.get(6).getDescricao());

            tvAcao1.setText(listaProblemas.get(0).getAcao());
            tvAcao2.setText(listaProblemas.get(1).getAcao());
            tvAcao3.setText(listaProblemas.get(2).getAcao());
            tvAcao4.setText(listaProblemas.get(3).getAcao());
            tvAcao5.setText(listaProblemas.get(4).getAcao());
            tvAcao6.setText(listaProblemas.get(5).getAcao());
            tvAcao7.setText(listaProblemas.get(6).getAcao());


            lvRastreamento.setOnTouchListener(new View.OnTouchListener() {
                // Setting on Touch Listener for handling the touch inside ScrollView
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // Disallow the touch request for parent scroll on touch of child view
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
            setListViewHeightBasedOnChildren(lvRastreamento);

            lvRastreamentoTexto.setOnTouchListener(new View.OnTouchListener() {
                // Setting on Touch Listener for handling the touch inside ScrollView
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // Disallow the touch request for parent scroll on touch of child view
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
            setListViewHeightBasedOnChildren(lvRastreamentoTexto);

            RastreamentoAdapter adapter = new RastreamentoAdapter(this, listaRastreamento);
            lvRastreamento.setAdapter(adapter);
            RastreamentoTextoAdapter adapter2 = new RastreamentoTextoAdapter(this, listaRastreamento);
            lvRastreamentoTexto.setAdapter(adapter2);

            tvReferencias.setText(RastreamentoUtil.getReferencias());

            edFocus.requestFocus();
        }

        edFocus.requestFocus();

    }

    @OnClick(R.id.bt_ver_voltar)
    public void voltar(){
        finish();
    }

    @OnClick(R.id.bt_ver_email)
    public void email(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{SessaoUsuario.getUsuarioSessao().getEmail()});
        i.putExtra(Intent.EXTRA_SUBJECT, "N° Prontuário: " + prontuario.getNumProntuario() + " - " + prontuario.getDataEdicao());
        i.putExtra(Intent.EXTRA_TEXT   , EmailUtil.getEmail(prontuario, estiloDeVida, exameFisico, anamnese, listaProblemas));
        try {
            this.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Occorreu um erro, verifique sua conexão com a internet ou se o e-mail é valido.", Toast.LENGTH_SHORT).show();
        }
    }


    /**** Method for Setting the Height of the ListView dynamically.
     **** Hack to fix the issue of not showing all the items of the ListView
     **** when placed inside a ScrollView  ****/
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
