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
import br.uninove.primeiraconsulta.util.CheckProntuario;
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
            rgFibra = (RadioGroup)findViewById(R.id.rg_editar_fibra);
            if(prontuario.getFibraOpt() != null){
                rgFibra.check(prontuario.getFibraOpt());
            }
            rgCalcio = (RadioGroup)findViewById(R.id.rg_editar_calcio);
            if(prontuario.getCalcioOpt() != null){
                rgCalcio.check(prontuario.getCalcioOpt());
            }
            rgSodio = (RadioGroup)findViewById(R.id.rg_editar_sodio);
            if(prontuario.getSodioOpt() != null){
                rgSodio.check(prontuario.getSodioOpt());
            }
            rgAcucar = (RadioGroup)findViewById(R.id.rg_editar_doces);
            if(prontuario.getAcucarOpt() != null){
                rgAcucar.check(prontuario.getAcucarOpt());
            }
            rgRefri = (RadioGroup)findViewById(R.id.rg_editar_refri);
            if(prontuario.getRefriOpt() != null){
                rgRefri.check(prontuario.getRefriOpt());
            }
            rgAgua = (RadioGroup)findViewById(R.id.rg_editar_agua);
            if(prontuario.getAguaOpt() != null){
                rgAgua.check(prontuario.getAguaOpt());
            }
            rgAtFisica = (RadioGroup)findViewById(R.id.rg_editar_atividade_fisica);
            if(prontuario.getAtFisicaOpt() != null){
                rgAtFisica.check(prontuario.getAtFisicaOpt());
            }
            //Sono Opts
            rgSonoOpt1 = (RadioGroup)findViewById(R.id.rg_editar_sono_lendo);
            if(prontuario.getSonoOpt1() != null){
                rgSonoOpt1.check(prontuario.getSonoOpt1());
            }
            rgSonoOpt2 = (RadioGroup)findViewById(R.id.rg_editar_sono_tv);
            if(prontuario.getSonoOpt2() != null){
                rgSonoOpt2.check(prontuario.getSonoOpt2());
            }
            rgSonoOpt3 = (RadioGroup)findViewById(R.id.rg_editar_sono_publico);
            if(prontuario.getSonoOpt3() != null){
                rgSonoOpt3.check(prontuario.getSonoOpt3());
            }
            rgSonoOpt4 = (RadioGroup)findViewById(R.id.rg_editar_sono_carro);
            if(prontuario.getSonoOpt4() != null){
                rgSonoOpt4.check(prontuario.getSonoOpt4());
            }
            rgSonoOpt5 = (RadioGroup)findViewById(R.id.rg_editar_sono_almoco);
            if(prontuario.getSonoOpt5() != null){
                rgSonoOpt5.check(prontuario.getSonoOpt5());
            }
            rgSonoOpt6 = (RadioGroup)findViewById(R.id.rg_editar_sono_transito);
            if(prontuario.getSonoOpt6() != null){
                rgSonoOpt6.check(prontuario.getSonoOpt6());
            }

            rgCigarroAtivo = (RadioGroup)findViewById(R.id.rg_editar_tabagismo);
            if(prontuario.getCigarroAtivoOpt() != null){
                rgCigarroAtivo.check(prontuario.getCigarroAtivoOpt());
            }
            rgCigarro1 = (RadioGroup)findViewById(R.id.rg_editar_tabagismo_1);
            if(prontuario.getCigarroOpt1() != null){
                rgCigarro1.check(prontuario.getCigarroOpt1());
            }
            rgCigarro2 = (RadioGroup)findViewById(R.id.rg_editar_tabagismo_2);
            if(prontuario.getCigarroOpt2() != null){
                rgCigarro2.check(prontuario.getCigarroOpt2());
            }
            rgCigarro3 = (RadioGroup)findViewById(R.id.rg_editar_tabagismo_3);
            if(prontuario.getCigarroOpt3() != null){
                rgCigarro3.check(prontuario.getCigarroOpt3());
            }
            rgCigarro4 = (RadioGroup)findViewById(R.id.rg_editar_tabagismo_4);
            if(prontuario.getCigarroOpt4() != null){
                rgCigarro4.check(prontuario.getCigarroOpt4());
            }
            rgCigarro5 = (RadioGroup)findViewById(R.id.rg_editar_tabagismo_5);
            if(prontuario.getCigarroOpt5() != null){
                rgCigarro5.check(prontuario.getCigarroOpt5());
            }
            rgCigarro6 = (RadioGroup)findViewById(R.id.rg_editar_tabagismo_6);
            if(prontuario.getCigarroOpt6() != null){
                rgCigarro6.check(prontuario.getCigarroOpt6());
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


        int fibraEscolhe = rgFibra.getCheckedRadioButtonId();
        if(fibraEscolhe == R.id.rb_editar_fibra_1){
            prontuario.setFibraOpt(R.id.rb_editar_fibra_1);
            prontuario.setFibra("Menos de 5 porções de frutas e verduras e hortaliças por dia. (Inadequado)");
        } else if(fibraEscolhe == R.id.rb_editar_fibra_2){
            prontuario.setFibraOpt(R.id.rb_editar_fibra_2);
            prontuario.setFibra("Recomendação da ingestão diária de 400 gramas de frutas e hortaliças (WHO, 2003), o que seria equivalente, aproximadamente, ao consumo diário de cinco porções desses alimentos. (Adequado)");
        } else {
            prontuario.setFibra("");
        }


        int calcioEscolha = rgCalcio.getCheckedRadioButtonId();
        if(calcioEscolha == R.id.rb_editar_calcio_1){
            prontuario.setCalcioOpt(R.id.rb_editar_calcio_1);
            prontuario.setCalcio("Menos de 3 porções de laticínios por semana (Inadequado).");
        } else if(calcioEscolha == R.id.rb_editar_calcio_2){
            prontuario.setCalcioOpt(R.id.rb_editar_calcio_2);
            prontuario.setCalcio("3 porções de laticínios ou mais por semana (Adequado).");
        } else {
            prontuario.setCalcio("");
        }


        int sodioEscolha = rgSodio.getCheckedRadioButtonId();
        if(sodioEscolha == R.id.rb_editar_sodio_1){
            prontuario.setSodioOpt(R.id.rb_editar_sodio_1);
            prontuario.setSodio("Uso de tempero pronto, embutidos, industrializados ou enlatados diário) ou mais de 5g de sal por dia. (alta ingesta)");
        } else if(sodioEscolha == R.id.rb_editar_sodio_2){
            prontuario.setSodioOpt(R.id.rb_editar_sodio_2);
            prontuario.setSodio("Menos que 5 e mais que 2g de sal por dia. (moderada Ingesta)");
        } else if(sodioEscolha == R.id.rb_editar_sodio_3){
            prontuario.setSodioOpt(R.id.rb_editar_sodio_3);
            prontuario.setSodio("Abaixo de 2g de sal por dia. (baixa ingesta)");
        } else {
            prontuario.setSodio("");
        }


        int acucarEscolha = rgAcucar.getCheckedRadioButtonId();
        if(acucarEscolha == R.id.rb_editar_doces_1){
            prontuario.setAcucarOpt(R.id.rb_editar_doces_1);
            prontuario.setAcucar("Maior de 75g 5x por semana. (Inadequado)");
        } else if(acucarEscolha == R.id.rb_editar_doces_2){
            prontuario.setAcucarOpt(R.id.rb_editar_doces_2);
            prontuario.setAcucar("Menor de 75g 5x por semana. (Adequado)");
        } else {
            prontuario.setAcucar("");
        }


        int refriEscolha = rgRefri.getCheckedRadioButtonId();
        if(refriEscolha == R.id.rb_editar_refri_1){
            prontuario.setRefriOpt(R.id.rb_editar_refri_1);
            prontuario.setRefri("Mais de 5 vezes por semana. (Consumo regular)");
        } else if(refriEscolha == R.id.rb_editar_refri_2){
            prontuario.setRefriOpt(R.id.rb_editar_refri_2);
            prontuario.setRefri("Menos de 1 vez por semana (Consumo normal)");
        } else {
            prontuario.setRefri("");
        }


        int aguaEscolha = rgAgua.getCheckedRadioButtonId();
        if(aguaEscolha == R.id.rb_editar_agua_1){
            prontuario.setAguaOpt(R.id.rb_editar_agua_1);
            prontuario.setAgua("De dois ou mais litros de agua por dia. (Adequada)");
        } else if(aguaEscolha == R.id.rb_editar_agua_2){
            prontuario.setAguaOpt(R.id.rb_editar_agua_2);
            prontuario.setAgua("Menos de dois litro por dia. (Inadequada)");
        } else {
            prontuario.setAgua("");
        }


        int atFisicaEscolha = rgAtFisica.getCheckedRadioButtonId();
        if(atFisicaEscolha == R.id.rb_editar_atividade_fisica_1){
            prontuario.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_1);
            prontuario.setAtFisica("Menos de 10 minutos contínuos de exercício por semana (Sedentário)");
        } else if(atFisicaEscolha == R.id.rb_editar_atividade_fisica_2){
            prontuario.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_2);
            prontuario.setAtFisica("Menos de 150 minutos de exercicíos por semana. (Irregularmente ativo)");
        } else if(atFisicaEscolha == R.id.rb_editar_atividade_fisica_3){
            prontuario.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_3);
            prontuario.setAtFisica("Mais de 150 minutos exercicíos por semana. (Ativo)");
        } else {
            prontuario.setAtFisica("");
        }


        //Sono
        int sonoPontos = 0;
        int sonoEscolha = rgSonoOpt1.getCheckedRadioButtonId();
        if(sonoEscolha == R.id.rb_editar_sono_lendo_0){
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_0);
            sonoPontos = sonoPontos + 0;
        } else if(sonoEscolha == R.id.rb_editar_sono_lendo_1){
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_1);
            sonoPontos = sonoPontos + 1;
        } else if(sonoEscolha == R.id.rb_editar_sono_lendo_2){
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_2);
            sonoPontos = sonoPontos + 2;
        } else if(sonoEscolha == R.id.rb_editar_sono_lendo_3){
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt2.getCheckedRadioButtonId();
        if(sonoEscolha == R.id.rb_editar_sono_tv_0){
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_0);
            sonoPontos = sonoPontos + 0;
        } else if(sonoEscolha == R.id.rb_editar_sono_tv_1){
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_1);
            sonoPontos = sonoPontos + 1;
        } else if(sonoEscolha == R.id.rb_editar_sono_tv_2){
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_2);
            sonoPontos = sonoPontos + 2;
        } else if(sonoEscolha == R.id.rb_editar_sono_tv_3){
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt3.getCheckedRadioButtonId();
        if(sonoEscolha == R.id.rb_editar_sono_publico_0){
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_0);
            sonoPontos = sonoPontos + 0;
        } else if(sonoEscolha == R.id.rb_editar_sono_publico_1){
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_1);
            sonoPontos = sonoPontos + 1;
        } else if(sonoEscolha == R.id.rb_editar_sono_publico_2){
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_2);
            sonoPontos = sonoPontos + 2;
        } else if(sonoEscolha == R.id.rb_editar_sono_publico_3){
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt4.getCheckedRadioButtonId();
        if(sonoEscolha == R.id.rb_editar_sono_carro_0){
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_0);
            sonoPontos = sonoPontos + 0;
        } else if(sonoEscolha == R.id.rb_editar_sono_carro_1){
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_1);
            sonoPontos = sonoPontos + 1;
        } else if(sonoEscolha == R.id.rb_editar_sono_carro_2){
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_2);
            sonoPontos = sonoPontos + 2;
        } else if(sonoEscolha == R.id.rb_editar_sono_carro_3){
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt5.getCheckedRadioButtonId();
        if(sonoEscolha == R.id.rb_editar_sono_almoco_0){
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_0);
            sonoPontos = sonoPontos + 0;
        } else if(sonoEscolha == R.id.rb_editar_sono_almoco_1){
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_1);
            sonoPontos = sonoPontos + 1;
        } else if(sonoEscolha == R.id.rb_editar_sono_almoco_2){
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_2);
            sonoPontos = sonoPontos + 2;
        } else if(sonoEscolha == R.id.rb_editar_sono_almoco_3){
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt6.getCheckedRadioButtonId();
        if(sonoEscolha == R.id.rb_editar_sono_transito_0){
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_0);
            sonoPontos = sonoPontos + 0;
        } else if(sonoEscolha == R.id.rb_editar_sono_transito_1){
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_1);
            sonoPontos = sonoPontos + 1;
        } else if(sonoEscolha == R.id.rb_editar_sono_transito_2){
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_2);
            sonoPontos = sonoPontos + 2;
        } else if(sonoEscolha == R.id.rb_editar_sono_transito_3){
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_3);
            sonoPontos = sonoPontos + 3;
        }

        prontuario.setSonoPontos(sonoPontos);
        if(sonoPontos >= 10){
            prontuario.setSono("Sonolência diurna excessiva!");
        } else {
            prontuario.setSono("Sono regular.");
        }

        //Tabagismo, cigarro, etc
        int cigarroPontos = 0;
        int cigarroEscolha = rgCigarroAtivo.getCheckedRadioButtonId();

        if(cigarroEscolha == R.id.rb_editar_tabagismo_sim){

            prontuario.setCigarroAtivoOpt(R.id.rb_editar_tabagismo_sim);

            cigarroEscolha = rgCigarro1.getCheckedRadioButtonId();
            if(cigarroEscolha == R.id.rb_editar_tabagismo_1_1){
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_1);
                prontuario.setCigarro1("Dentro de 5 minutos. (3 pontos)");
                cigarroPontos = cigarroPontos + 3;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_1_2){
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_2);
                prontuario.setCigarro1("Entre 6-30 minutos. (2 pontos)");
                cigarroPontos = cigarroPontos + 2;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_1_3){
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_3);
                prontuario.setCigarro1("Entre 31-60 minutos. (1 ponto)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_1_4){
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_4);
                prontuario.setCigarro1("Após 60 minutos. (0 ponto)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro2.getCheckedRadioButtonId();
            if(cigarroEscolha == R.id.rb_editar_tabagismo_2_1){
                prontuario.setCigarroOpt2(R.id.rb_editar_tabagismo_2_1);
                prontuario.setCigarro2("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos +1 ;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_2_2){
                prontuario.setCigarroOpt2(R.id.rb_editar_tabagismo_2_2);
                prontuario.setCigarro2("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro3.getCheckedRadioButtonId();
            if(cigarroEscolha == R.id.rb_editar_tabagismo_3_1){
                prontuario.setCigarroOpt3(R.id.rb_editar_tabagismo_3_1);
                prontuario.setCigarro3("O primeira do dia. (1 pontos)");
                cigarroPontos = cigarroPontos +1 ;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_3_2){
                prontuario.setCigarroOpt3(R.id.rb_editar_tabagismo_3_2);
                prontuario.setCigarro3("Outros. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_3_3){
                prontuario.setCigarroOpt3(R.id.rb_editar_tabagismo_3_3);
                prontuario.setCigarro3("Nenhum. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro4.getCheckedRadioButtonId();
            if(cigarroEscolha == R.id.rb_editar_tabagismo_4_1){
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_1);
                prontuario.setCigarro4("Menos de 10. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_4_2){
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_2);
                prontuario.setCigarro4("De 11 a 20. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_4_3){
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_3);
                prontuario.setCigarro4("De 21 a 30. (2 ponto)");
                cigarroPontos = cigarroPontos + 2;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_4_4){
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_4);
                prontuario.setCigarro4("Mais de 31. (3 ponto)");
                cigarroPontos = cigarroPontos + 3;
            }

            cigarroEscolha = rgCigarro5.getCheckedRadioButtonId();
            if(cigarroEscolha == R.id.rb_editar_tabagismo_5_1){
                prontuario.setCigarroOpt5(R.id.rb_editar_tabagismo_5_1);
                prontuario.setCigarro5("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos +1 ;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_5_2){
                prontuario.setCigarroOpt5(R.id.rb_editar_tabagismo_5_2);
                prontuario.setCigarro5("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro6.getCheckedRadioButtonId();
            if(cigarroEscolha == R.id.rb_editar_tabagismo_6_1){
                prontuario.setCigarroOpt6(R.id.rb_editar_tabagismo_6_1);
                prontuario.setCigarro6("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos +1 ;
            } else if (cigarroEscolha == R.id.rb_editar_tabagismo_6_2){
                prontuario.setCigarroOpt6(R.id.rb_editar_tabagismo_6_2);
                prontuario.setCigarro6("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            prontuario.setCigarroPontos(cigarroPontos);

            if(cigarroPontos >= 0 && cigarroPontos <= 2){
                prontuario.setCigarro("Grau de dependência do tabagismo: Muito baixo.");
            } else if(cigarroPontos >= 3 && cigarroPontos <= 4){
                prontuario.setCigarro("Grau de dependência do tabagismo: Baixo.");
            } else if(cigarroPontos == 5){
                prontuario.setCigarro("Grau de dependência do tabagismo: Médio.");
            } else if(cigarroPontos >= 6 && cigarroPontos <= 7){
                prontuario.setCigarro("Grau de dependência do tabagismo: Elevado.");
            } else {
                prontuario.setCigarro("Grau de dependência do tabagismo: Muito elevado.");
            }

        } else {
            prontuario.setCigarroAtivoOpt(R.id.rb_editar_tabagismo_nao);
            prontuario.setCigarroOpt1(null);
            prontuario.setCigarro1("Paciente não é usuário ativo.");
            prontuario.setCigarroOpt2(null);
            prontuario.setCigarro2("Paciente não é usuário ativo.");
            prontuario.setCigarroOpt3(null);
            prontuario.setCigarro3("Paciente não é usuário ativo.");
            prontuario.setCigarroOpt4(null);
            prontuario.setCigarro4("Paciente não é usuário ativo.");
            prontuario.setCigarroOpt5(null);
            prontuario.setCigarro5("Paciente não é usuário ativo.");
            prontuario.setCigarroOpt6(null);
            prontuario.setCigarro6("Paciente não é usuário ativo.");
            prontuario.setCigarroPontos(cigarroPontos);
            prontuario.setCigarro("Paciente não é usuário ativo.");
        }


        prontuario.setComentario(edComentario.getText().toString());

        if(CheckProntuario.checkCampos(prontuario, this)){
            Prontuario p = prontuario;
            p = CheckProntuario.nadaConsta(p);
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
