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

        String pIdade = edIdade.getText().toString();
        if (!pIdade.isEmpty()) {
            prontuario.setIdade(Integer.parseInt(pIdade));
        }
        if (!edPeso.getText().toString().isEmpty()) {
            prontuario.setPeso(Integer.parseInt(edPeso.getText().toString()));
        }
        if (!edAltura.getText().toString().isEmpty()) {
            prontuario.setAltura(Float.parseFloat(edAltura.getText().toString()));
        }

        //EXAME FISICO INICIO

        if (!edSistole.getText().toString().isEmpty()){exameFisico.setSistole(Integer.parseInt(edSistole.getText().toString()));}
        if (!edDiastole.getText().toString().isEmpty()){exameFisico.setDiastole(Integer.parseInt(edDiastole.getText().toString()));}
        if (exameFisico.getSistole() != null && exameFisico.getDiastole() != null){
            if(exameFisico.getSistole() >= 140 || exameFisico.getDiastole() >= 90){
                exameFisico.setPaResultado("Pressão arterial acima do normal");
            } else {
                exameFisico.setPaResultado("Pressão arterial está normal");
            }
        }
        if(prontuario.getPeso() != null && prontuario.getAltura() != null){
            exameFisico.setImc(CheckProntuario.getImc(prontuario.getPeso(), prontuario.getAltura()));
            exameFisico.setImcResultado(CheckProntuario.getImcResultado(exameFisico.getImc()));
        }
        if (!edCervical.getText().toString().isEmpty()){exameFisico.setCervical(Integer.parseInt(edCervical.getText().toString()));}
        if(exameFisico.getCervical() != null){
            if(prontuario.getSexo().equals("Masculino")){
                if(exameFisico.getCervical() > 37){
                    exameFisico.setCervicalResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCervicalResultado("Circunferência está normal.");
                }
            } else {
                if(exameFisico.getCervical() > 34){
                    exameFisico.setCervicalResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCervicalResultado("Circunferência está normal.");
                }
            }
        }

        if (!edCintura.getText().toString().isEmpty()){exameFisico.setCintura(Integer.parseInt(edCintura.getText().toString()));}
        if(exameFisico.getCintura() != null){
            if(prontuario.getSexo().equals("Masculino")){
                if(exameFisico.getCintura() > 102){
                    exameFisico.setCinturaResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCinturaResultado("Circunferência está normal.");
                }
            } else {
                if(exameFisico.getCintura() > 88){
                    exameFisico.setCinturaResultado("Circunferência está elevada!");
                } else {
                    exameFisico.setCinturaResultado("Circunferência está normal.");
                }
            }
        }

        if (!edQuadril.getText().toString().isEmpty()){exameFisico.setQuadril(Float.parseFloat(edQuadril.getText().toString()));}
        if(exameFisico.getQuadril() != null){
            if(prontuario.getSexo().equals("Masculino")){
                if(exameFisico.getQuadril() >= 0.9){
                    exameFisico.setQuadrilResultado("Risco para complicações metabólicas!");
                } else {
                    exameFisico.setQuadrilResultado("Cintura/Quadril está normal.");
                }
            } else {
                if(exameFisico.getQuadril() >= 0.85){
                    exameFisico.setQuadrilResultado("Risco para complicações metabólicas!");
                } else {
                    exameFisico.setQuadrilResultado("Cintura/Quadril está normal.");
                }
            }
        }

        if (!edSnellenDireita.getText().toString().isEmpty()){exameFisico.setSnellenDireita(Integer.parseInt(edSnellenDireita.getText().toString()));}
        if (!edSnellenEsquerda.getText().toString().isEmpty()){exameFisico.setSnellenEsquerda(Integer.parseInt(edSnellenEsquerda.getText().toString()));}
        if (exameFisico.getSnellenDireita() != null && exameFisico.getSnellenEsquerda() != null){
            if(exameFisico.getSnellenDireita() > 20 || exameFisico.getSnellenEsquerda() > 20){
                exameFisico.setSnellenResultado("Vista está alterada!");
            } else {
                exameFisico.setSnellenResultado("Vista está normal.");
            }
        }


        //EXAME FISICO FIM
        //ESTILO DE VIDA/HABITOS INICIO

        int gorduraEscolha = rgGordura.getCheckedRadioButtonId();
        if (gorduraEscolha == R.id.rb_editar_gordura_1) {
            estiloDeVida.setGorduraOpt(R.id.rb_editar_gordura_1);
            estiloDeVida.setGordura("7 vezes na semana ou mais: frango com pele, carne com gordura, miúdos, frituras (alta ingesta).");
        } else if (gorduraEscolha == R.id.rb_editar_gordura_2) {
            estiloDeVida.setGorduraOpt(R.id.rb_editar_gordura_2);
            estiloDeVida.setGordura("Abaixo de 7 vezes na semana (Ingesta adequada).");
        } else {
            estiloDeVida.setGordura("");
        }


        int fibraEscolhe = rgFibra.getCheckedRadioButtonId();
        if (fibraEscolhe == R.id.rb_editar_fibra_1) {
            estiloDeVida.setFibraOpt(R.id.rb_editar_fibra_1);
            estiloDeVida.setFibra("Menos de 5 porções de frutas e verduras e hortaliças por dia. (Inadequado)");
        } else if (fibraEscolhe == R.id.rb_editar_fibra_2) {
            estiloDeVida.setFibraOpt(R.id.rb_editar_fibra_2);
            estiloDeVida.setFibra("Recomendação da ingestão diária de 400 gramas de frutas e hortaliças (WHO, 2003), o que seria equivalente, aproximadamente, ao consumo diário de cinco porções desses alimentos. (Adequado)");
        } else {
            estiloDeVida.setFibra("");
        }


        int calcioEscolha = rgCalcio.getCheckedRadioButtonId();
        if (calcioEscolha == R.id.rb_editar_calcio_1) {
            estiloDeVida.setCalcioOpt(R.id.rb_editar_calcio_1);
            estiloDeVida.setCalcio("Menos de 3 porções de laticínios por semana (Inadequado).");
        } else if (calcioEscolha == R.id.rb_editar_calcio_2) {
            estiloDeVida.setCalcioOpt(R.id.rb_editar_calcio_2);
            estiloDeVida.setCalcio("3 porções de laticínios ou mais por semana (Adequado).");
        } else {
            estiloDeVida.setCalcio("");
        }


        int sodioEscolha = rgSodio.getCheckedRadioButtonId();
        if (sodioEscolha == R.id.rb_editar_sodio_1) {
            estiloDeVida.setSodioOpt(R.id.rb_editar_sodio_1);
            estiloDeVida.setSodio("Uso de tempero pronto, embutidos, industrializados ou enlatados diário) ou mais de 5g de sal por dia. (alta ingesta)");
        } else if (sodioEscolha == R.id.rb_editar_sodio_2) {
            estiloDeVida.setSodioOpt(R.id.rb_editar_sodio_2);
            estiloDeVida.setSodio("Menos que 5 e mais que 2g de sal por dia. (moderada Ingesta)");
        } else if (sodioEscolha == R.id.rb_editar_sodio_3) {
            estiloDeVida.setSodioOpt(R.id.rb_editar_sodio_3);
            estiloDeVida.setSodio("Abaixo de 2g de sal por dia. (baixa ingesta)");
        } else {
            estiloDeVida.setSodio("");
        }


        int acucarEscolha = rgAcucar.getCheckedRadioButtonId();
        if (acucarEscolha == R.id.rb_editar_doces_1) {
            estiloDeVida.setAcucarOpt(R.id.rb_editar_doces_1);
            estiloDeVida.setAcucar("Maior de 75g 5x por semana. (Inadequado)");
        } else if (acucarEscolha == R.id.rb_editar_doces_2) {
            estiloDeVida.setAcucarOpt(R.id.rb_editar_doces_2);
            estiloDeVida.setAcucar("Menor de 75g 5x por semana. (Adequado)");
        } else {
            estiloDeVida.setAcucar("");
        }


        int refriEscolha = rgRefri.getCheckedRadioButtonId();
        if (refriEscolha == R.id.rb_editar_refri_1) {
            estiloDeVida.setRefriOpt(R.id.rb_editar_refri_1);
            estiloDeVida.setRefri("Mais de 5 vezes por semana. (Consumo regular)");
        } else if (refriEscolha == R.id.rb_editar_refri_2) {
            estiloDeVida.setRefriOpt(R.id.rb_editar_refri_2);
            estiloDeVida.setRefri("Menos de 1 vez por semana (Consumo normal)");
        } else {
            estiloDeVida.setRefri("");
        }


        int aguaEscolha = rgAgua.getCheckedRadioButtonId();
        if (aguaEscolha == R.id.rb_editar_agua_1) {
            estiloDeVida.setAguaOpt(R.id.rb_editar_agua_1);
            estiloDeVida.setAgua("De dois ou mais litros de agua por dia. (Adequada)");
        } else if (aguaEscolha == R.id.rb_editar_agua_2) {
            estiloDeVida.setAguaOpt(R.id.rb_editar_agua_2);
            estiloDeVida.setAgua("Menos de dois litro por dia. (Inadequada)");
        } else {
            estiloDeVida.setAgua("");
        }


        int atFisicaEscolha = rgAtFisica.getCheckedRadioButtonId();
        if (atFisicaEscolha == R.id.rb_editar_atividade_fisica_1) {
            estiloDeVida.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_1);
            estiloDeVida.setAtFisica("Menos de 10 minutos contínuos de exercício por semana (Sedentário)");
        } else if (atFisicaEscolha == R.id.rb_editar_atividade_fisica_2) {
            estiloDeVida.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_2);
            estiloDeVida.setAtFisica("Menos de 150 minutos de exercicíos por semana. (Irregularmente ativo)");
        } else if (atFisicaEscolha == R.id.rb_editar_atividade_fisica_3) {
            estiloDeVida.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_3);
            estiloDeVida.setAtFisica("Mais de 150 minutos exercicíos por semana. (Ativo)");
        } else {
            estiloDeVida.setAtFisica("");
        }


        //Sono, avaliacao do ronco
        int sonoPontos = 0;
        int sonoEscolha = rgSonoOpt1.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_editar_sono_lendo_0) {
            estiloDeVida.setSonoOpt1(R.id.rb_editar_sono_lendo_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_editar_sono_lendo_1) {
            estiloDeVida.setSonoOpt1(R.id.rb_editar_sono_lendo_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_editar_sono_lendo_2) {
            estiloDeVida.setSonoOpt1(R.id.rb_editar_sono_lendo_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_editar_sono_lendo_3) {
            estiloDeVida.setSonoOpt1(R.id.rb_editar_sono_lendo_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt2.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_editar_sono_tv_0) {
            estiloDeVida.setSonoOpt2(R.id.rb_editar_sono_tv_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_editar_sono_tv_1) {
            estiloDeVida.setSonoOpt2(R.id.rb_editar_sono_tv_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_editar_sono_tv_2) {
            estiloDeVida.setSonoOpt2(R.id.rb_editar_sono_tv_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_editar_sono_tv_3) {
            estiloDeVida.setSonoOpt2(R.id.rb_editar_sono_tv_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt3.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_editar_sono_publico_0) {
            estiloDeVida.setSonoOpt3(R.id.rb_editar_sono_publico_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_editar_sono_publico_1) {
            estiloDeVida.setSonoOpt3(R.id.rb_editar_sono_publico_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_editar_sono_publico_2) {
            estiloDeVida.setSonoOpt3(R.id.rb_editar_sono_publico_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_editar_sono_publico_3) {
            estiloDeVida.setSonoOpt3(R.id.rb_editar_sono_publico_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt4.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_editar_sono_carro_0) {
            estiloDeVida.setSonoOpt4(R.id.rb_editar_sono_carro_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_editar_sono_carro_1) {
            estiloDeVida.setSonoOpt4(R.id.rb_editar_sono_carro_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_editar_sono_carro_2) {
            estiloDeVida.setSonoOpt4(R.id.rb_editar_sono_carro_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_editar_sono_carro_3) {
            estiloDeVida.setSonoOpt4(R.id.rb_editar_sono_carro_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt5.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_editar_sono_almoco_0) {
            estiloDeVida.setSonoOpt5(R.id.rb_editar_sono_almoco_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_editar_sono_almoco_1) {
            estiloDeVida.setSonoOpt5(R.id.rb_editar_sono_almoco_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_editar_sono_almoco_2) {
            estiloDeVida.setSonoOpt5(R.id.rb_editar_sono_almoco_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_editar_sono_almoco_3) {
            estiloDeVida.setSonoOpt5(R.id.rb_editar_sono_almoco_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt6.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_editar_sono_transito_0) {
            estiloDeVida.setSonoOpt6(R.id.rb_editar_sono_transito_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_editar_sono_transito_1) {
            estiloDeVida.setSonoOpt6(R.id.rb_editar_sono_transito_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_editar_sono_transito_2) {
            estiloDeVida.setSonoOpt6(R.id.rb_editar_sono_transito_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_editar_sono_transito_3) {
            estiloDeVida.setSonoOpt6(R.id.rb_editar_sono_transito_3);
            sonoPontos = sonoPontos + 3;
        }

        estiloDeVida.setSonoPontos(sonoPontos);
        if (sonoPontos >= 10) {
            estiloDeVida.setSono("Sonolência diurna excessiva!");
        } else {
            estiloDeVida.setSono("Sono regular.");
        }

        //Tabagismo, cigarro, etc
        int cigarroPontos = 0;
        int cigarroEscolha = rgCigarroAtivo.getCheckedRadioButtonId();

        if (cigarroEscolha == R.id.rb_editar_tabagismo_sim) {

            estiloDeVida.setCigarroAtivoOpt(R.id.rb_editar_tabagismo_sim);

            cigarroEscolha = rgCigarro1.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_editar_tabagismo_1_1) {
                estiloDeVida.setCigarroOpt1(R.id.rb_editar_tabagismo_1_1);
                estiloDeVida.setCigarro1("Dentro de 5 minutos. (3 pontos)");
                cigarroPontos = cigarroPontos + 3;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_1_2) {
                estiloDeVida.setCigarroOpt1(R.id.rb_editar_tabagismo_1_2);
                estiloDeVida.setCigarro1("Entre 6-30 minutos. (2 pontos)");
                cigarroPontos = cigarroPontos + 2;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_1_3) {
                estiloDeVida.setCigarroOpt1(R.id.rb_editar_tabagismo_1_3);
                estiloDeVida.setCigarro1("Entre 31-60 minutos. (1 ponto)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_1_4) {
                estiloDeVida.setCigarroOpt1(R.id.rb_editar_tabagismo_1_4);
                estiloDeVida.setCigarro1("Após 60 minutos. (0 ponto)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro2.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_editar_tabagismo_2_1) {
                estiloDeVida.setCigarroOpt2(R.id.rb_editar_tabagismo_2_1);
                estiloDeVida.setCigarro2("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_2_2) {
                estiloDeVida.setCigarroOpt2(R.id.rb_editar_tabagismo_2_2);
                estiloDeVida.setCigarro2("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro3.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_editar_tabagismo_3_1) {
                estiloDeVida.setCigarroOpt3(R.id.rb_editar_tabagismo_3_1);
                estiloDeVida.setCigarro3("O primeira do dia. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_3_2) {
                estiloDeVida.setCigarroOpt3(R.id.rb_editar_tabagismo_3_2);
                estiloDeVida.setCigarro3("Outros. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_3_3) {
                estiloDeVida.setCigarroOpt3(R.id.rb_editar_tabagismo_3_3);
                estiloDeVida.setCigarro3("Nenhum. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro4.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_editar_tabagismo_4_1) {
                estiloDeVida.setCigarroOpt4(R.id.rb_editar_tabagismo_4_1);
                estiloDeVida.setCigarro4("Menos de 10. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_4_2) {
                estiloDeVida.setCigarroOpt4(R.id.rb_editar_tabagismo_4_2);
                estiloDeVida.setCigarro4("De 11 a 20. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_4_3) {
                estiloDeVida.setCigarroOpt4(R.id.rb_editar_tabagismo_4_3);
                estiloDeVida.setCigarro4("De 21 a 30. (2 ponto)");
                cigarroPontos = cigarroPontos + 2;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_4_4) {
                estiloDeVida.setCigarroOpt4(R.id.rb_editar_tabagismo_4_4);
                estiloDeVida.setCigarro4("Mais de 31. (3 ponto)");
                cigarroPontos = cigarroPontos + 3;
            }

            cigarroEscolha = rgCigarro5.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_editar_tabagismo_5_1) {
                estiloDeVida.setCigarroOpt5(R.id.rb_editar_tabagismo_5_1);
                estiloDeVida.setCigarro5("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_5_2) {
                estiloDeVida.setCigarroOpt5(R.id.rb_editar_tabagismo_5_2);
                estiloDeVida.setCigarro5("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro6.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_editar_tabagismo_6_1) {
                estiloDeVida.setCigarroOpt6(R.id.rb_editar_tabagismo_6_1);
                estiloDeVida.setCigarro6("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_6_2) {
                estiloDeVida.setCigarroOpt6(R.id.rb_editar_tabagismo_6_2);
                estiloDeVida.setCigarro6("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            estiloDeVida.setCigarroPontos(cigarroPontos);

            if (cigarroPontos >= 0 && cigarroPontos <= 2) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Muito baixo.");
            } else if (cigarroPontos >= 3 && cigarroPontos <= 4) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Baixo.");
            } else if (cigarroPontos == 5) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Médio.");
            } else if (cigarroPontos >= 6 && cigarroPontos <= 7) {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Elevado.");
            } else {
                estiloDeVida.setCigarro("Grau de dependência do tabagismo: Muito elevado.");
            }


        } else {
            estiloDeVida.setCigarroAtivoOpt(R.id.rb_editar_tabagismo_nao);
            estiloDeVida.setCigarroOpt1(null);
            estiloDeVida.setCigarro1("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt2(null);
            estiloDeVida.setCigarro2("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt3(null);
            estiloDeVida.setCigarro3("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt4(null);
            estiloDeVida.setCigarro4("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt5(null);
            estiloDeVida.setCigarro5("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroOpt6(null);
            estiloDeVida.setCigarro6("Paciente não é usuário ativo.");
            estiloDeVida.setCigarroPontos(cigarroPontos);
            estiloDeVida.setCigarro("Paciente não é usuário ativo.");
        }


        //Alcool
        int alcoolPontos = 0;
        int alcoolEscolha = rgAlcoolAtivo.getCheckedRadioButtonId();

        if (alcoolEscolha == R.id.rb_editar_alcool_1) {

            estiloDeVida.setAlcoolAtivoOpt(R.id.rb_editar_alcool_1);

            alcoolEscolha = rgAlcool1.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_editar_alcool_1_1) {
                estiloDeVida.setAlcoolOpt1(R.id.rb_editar_alcool_1_1);
                estiloDeVida.setAlcool1("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_editar_alcool_1_2) {
                estiloDeVida.setAlcoolOpt1(R.id.rb_editar_alcool_1_2);
                estiloDeVida.setAlcool1("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            alcoolEscolha = rgAlcool2.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_editar_alcool_2_1) {
                estiloDeVida.setAlcoolOpt2(R.id.rb_editar_alcool_2_1);
                estiloDeVida.setAlcool2("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_editar_alcool_2_2) {
                estiloDeVida.setAlcoolOpt2(R.id.rb_editar_alcool_2_2);
                estiloDeVida.setAlcool2("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            alcoolEscolha = rgAlcool3.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_editar_alcool_3_1) {
                estiloDeVida.setAlcoolOpt3(R.id.rb_editar_alcool_3_1);
                estiloDeVida.setAlcool3("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_editar_alcool_3_2) {
                estiloDeVida.setAlcoolOpt3(R.id.rb_editar_alcool_3_2);
                estiloDeVida.setAlcool3("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            alcoolEscolha = rgAlcool4.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_editar_alcool_4_1) {
                estiloDeVida.setAlcoolOpt4(R.id.rb_editar_alcool_4_1);
                estiloDeVida.setAlcool4("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_editar_alcool_4_2) {
                estiloDeVida.setAlcoolOpt4(R.id.rb_editar_alcool_4_2);
                estiloDeVida.setAlcool4("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            if (alcoolPontos >= 2) {
                estiloDeVida.setAlcool("Grau de dependência do álcool: Clinicamente significante (" + alcoolPontos + " 'Sim').");
            } else {
                estiloDeVida.setAlcool("Grau de dependência do álcool: Muito baixo.");
            }


        } else {
            estiloDeVida.setAlcoolAtivoOpt(R.id.rb_editar_alcool_2);
            estiloDeVida.setAlcoolOpt1(null);
            estiloDeVida.setAlcool1("Paciente não consome álcool.");
            estiloDeVida.setAlcoolOpt2(null);
            estiloDeVida.setAlcool2("Paciente não consome álcool.");
            estiloDeVida.setAlcoolOpt3(null);
            estiloDeVida.setAlcool3("Paciente não consome álcool.");
            estiloDeVida.setAlcoolOpt4(null);
            estiloDeVida.setAlcool4("Paciente não consome álcool.");
            estiloDeVida.setAlcool("Paciente não consome álcool.");
        }


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
