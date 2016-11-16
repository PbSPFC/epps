package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckProntuario;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class NovoProntuarioActivity extends AppCompatActivity {

    @Bind(R.id.ed_novo_nome_paciente)
    EditText edNomePaciente;
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

        prontuario.setNumProntuario(edNumProntuario.getText().toString());
        prontuario.setNomePaciente(edNomePaciente.getText().toString());
        Usuario usuario = SessaoUsuario.getUsuarioSessao();
        prontuario.setIdUsuario(usuario.getId());
        prontuario.setRaUsuario(usuario.getRa());
        prontuario.setNomeMedico(usuario.getNome());

        String sexo = "Feminino";
        int sexoEscolha = rgSexo.getCheckedRadioButtonId();
        if (sexoEscolha == R.id.rb_novo_masculino) {
            sexo = "Masculino";
        }
        prontuario.setSexo(sexo);

        String pIdade = edIdade.getText().toString();
        if (!pIdade.isEmpty()) {
            prontuario.setIdade(Integer.parseInt(pIdade));
        }
        if (!edPeso.getText().toString().isEmpty()) {
            prontuario.setPeso(Integer.parseInt(edPeso.getText().toString()));
        }
        if (!edAltura.getText().toString().isEmpty()){prontuario.setAltura(Float.parseFloat(edAltura.getText().toString()));}

        //EXAME FISICO INICIO

        if (!edSistole.getText().toString().isEmpty()){prontuario.setSistole(Integer.parseInt(edSistole.getText().toString()));}
        if (!edDiastole.getText().toString().isEmpty()){prontuario.setDiastole(Integer.parseInt(edDiastole.getText().toString()));}
        if (prontuario.getSistole() != null && prontuario.getDiastole() != null){
            if(prontuario.getSistole() >= 140 || prontuario.getDiastole() >= 90){
                prontuario.setPaResultado("Pressão arterial acima do normal");
            } else {
                prontuario.setPaResultado("Pressão arterial está normal");
            }
        }
        if(prontuario.getPeso() != null && prontuario.getAltura() != null){
            prontuario.setImc(CheckProntuario.getImc(prontuario.getPeso(), prontuario.getAltura()));
            prontuario.setImcResultado(CheckProntuario.getImcResultado(prontuario.getImc()));
        }
        if (!edCervical.getText().toString().isEmpty()){prontuario.setCervical(Integer.parseInt(edCervical.getText().toString()));}
        if(prontuario.getCervical() != null){
            if(prontuario.getSexo().equals("Masculino")){
                if(prontuario.getCervical() > 37){
                    prontuario.setCervicalResultado("Circunferência está elevada!");
                } else {
                    prontuario.setCervicalResultado("Circunferência está normal.");
                }
            } else {
                if(prontuario.getCervical() > 34){
                    prontuario.setCervicalResultado("Circunferência está elevada!");
                } else {
                    prontuario.setCervicalResultado("Circunferência está normal.");
                }
            }
        }

        if (!edCintura.getText().toString().isEmpty()){prontuario.setCintura(Integer.parseInt(edCintura.getText().toString()));}
        if(prontuario.getCintura() != null){
            if(prontuario.getSexo().equals("Masculino")){
                if(prontuario.getCintura() > 102){
                    prontuario.setCinturaResultado("Circunferência está elevada!");
                } else {
                    prontuario.setCinturaResultado("Circunferência está normal.");
                }
            } else {
                if(prontuario.getCintura() > 88){
                    prontuario.setCinturaResultado("Circunferência está elevada!");
                } else {
                    prontuario.setCinturaResultado("Circunferência está normal.");
                }
            }
        }

        if (!edQuadril.getText().toString().isEmpty()){prontuario.setQuadril(Float.parseFloat(edQuadril.getText().toString()));}
        if(prontuario.getQuadril() != null){
            if(prontuario.getSexo().equals("Masculino")){
                if(prontuario.getQuadril() >= 0.9){
                    prontuario.setQuadrilResultado("Risco para complicações metabólicas!");
                } else {
                    prontuario.setQuadrilResultado("Cintura/Quadril está normal.");
                }
            } else {
                if(prontuario.getQuadril() >= 0.85){
                    prontuario.setQuadrilResultado("Risco para complicações metabólicas!");
                } else {
                    prontuario.setQuadrilResultado("Cintura/Quadril está normal.");
                }
            }
        }

        if (!edSnellenDireita.getText().toString().isEmpty()){prontuario.setSnellenDireita(Integer.parseInt(edSnellenDireita.getText().toString()));}
        if (!edSnellenEsquerda.getText().toString().isEmpty()){prontuario.setSnellenEsquerda(Integer.parseInt(edSnellenEsquerda.getText().toString()));}
        if (prontuario.getSnellenDireita() != null && prontuario.getSnellenEsquerda() != null){
            if(prontuario.getSnellenDireita() > 20 || prontuario.getSnellenEsquerda() > 20){
                prontuario.setSnellenResultado("Vista está alterada!");
            } else {
                prontuario.setSnellenResultado("Vista está normal.");
            }
        }


        //EXAME FISICO FIM
        //ESTILO DE VIDA/HABITOS INICIO

        int gorduraEscolha = rgGordura.getCheckedRadioButtonId();
        if (gorduraEscolha == R.id.rb_novo_gordura_1) {
            prontuario.setGorduraOpt(R.id.rb_editar_gordura_1);
            prontuario.setGordura("7 vezes na semana ou mais: frango com pele, carne com gordura, miúdos, frituras (alta ingesta).");
        } else if (gorduraEscolha == R.id.rb_novo_gordura_2) {
            prontuario.setGorduraOpt(R.id.rb_editar_gordura_2);
            prontuario.setGordura("Abaixo de 7 vezes na semana (Ingesta adequada).");
        } else {
            prontuario.setGordura("");
        }


        int fibraEscolhe = rgFibra.getCheckedRadioButtonId();
        if (fibraEscolhe == R.id.rb_novo_fibra_1) {
            prontuario.setFibraOpt(R.id.rb_editar_fibra_1);
            prontuario.setFibra("Menos de 5 porções de frutas e verduras e hortaliças por dia. (Inadequado)");
        } else if (fibraEscolhe == R.id.rb_novo_fibra_2) {
            prontuario.setFibraOpt(R.id.rb_editar_fibra_2);
            prontuario.setFibra("Recomendação da ingestão diária de 400 gramas de frutas e hortaliças (WHO, 2003), o que seria equivalente, aproximadamente, ao consumo diário de cinco porções desses alimentos. (Adequado)");
        } else {
            prontuario.setFibra("");
        }


        int calcioEscolha = rgCalcio.getCheckedRadioButtonId();
        if (calcioEscolha == R.id.rb_novo_calcio_1) {
            prontuario.setCalcioOpt(R.id.rb_editar_calcio_1);
            prontuario.setCalcio("Menos de 3 porções de laticínios por semana (Inadequado).");
        } else if (calcioEscolha == R.id.rb_novo_calcio_2) {
            prontuario.setCalcioOpt(R.id.rb_editar_calcio_2);
            prontuario.setCalcio("3 porções de laticínios ou mais por semana (Adequado).");
        } else {
            prontuario.setCalcio("");
        }


        int sodioEscolha = rgSodio.getCheckedRadioButtonId();
        if (sodioEscolha == R.id.rb_novo_sodio_1) {
            prontuario.setSodioOpt(R.id.rb_editar_sodio_1);
            prontuario.setSodio("Uso de tempero pronto, embutidos, industrializados ou enlatados diário) ou mais de 5g de sal por dia. (alta ingesta)");
        } else if (sodioEscolha == R.id.rb_novo_sodio_2) {
            prontuario.setSodioOpt(R.id.rb_editar_sodio_2);
            prontuario.setSodio("Menos que 5 e mais que 2g de sal por dia. (moderada Ingesta)");
        } else if (sodioEscolha == R.id.rb_novo_sodio_3) {
            prontuario.setSodioOpt(R.id.rb_editar_sodio_3);
            prontuario.setSodio("Abaixo de 2g de sal por dia. (baixa ingesta)");
        } else {
            prontuario.setSodio("");
        }


        int acucarEscolha = rgAcucar.getCheckedRadioButtonId();
        if (acucarEscolha == R.id.rb_novo_doces_1) {
            prontuario.setAcucarOpt(R.id.rb_editar_doces_1);
            prontuario.setAcucar("Maior de 75g 5x por semana. (Inadequado)");
        } else if (acucarEscolha == R.id.rb_novo_doces_2) {
            prontuario.setAcucarOpt(R.id.rb_editar_doces_2);
            prontuario.setAcucar("Menor de 75g 5x por semana. (Adequado)");
        } else {
            prontuario.setAcucar("");
        }


        int refriEscolha = rgRefri.getCheckedRadioButtonId();
        if (refriEscolha == R.id.rb_novo_refri_1) {
            prontuario.setRefriOpt(R.id.rb_editar_refri_1);
            prontuario.setRefri("Mais de 5 vezes por semana. (Consumo regular)");
        } else if (refriEscolha == R.id.rb_novo_refri_2) {
            prontuario.setRefriOpt(R.id.rb_editar_refri_2);
            prontuario.setRefri("Menos de 1 vez por semana (Consumo normal)");
        } else {
            prontuario.setRefri("");
        }


        int aguaEscolha = rgAgua.getCheckedRadioButtonId();
        if (aguaEscolha == R.id.rb_novo_agua_1) {
            prontuario.setAguaOpt(R.id.rb_editar_agua_1);
            prontuario.setAgua("De dois ou mais litros de agua por dia. (Adequada)");
        } else if (aguaEscolha == R.id.rb_novo_agua_2) {
            prontuario.setAguaOpt(R.id.rb_editar_agua_2);
            prontuario.setAgua("Menos de dois litro por dia. (Inadequada)");
        } else {
            prontuario.setAgua("");
        }


        int atFisicaEscolha = rgAtFisica.getCheckedRadioButtonId();
        if (atFisicaEscolha == R.id.rb_novo_atividade_fisica_1) {
            prontuario.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_1);
            prontuario.setAtFisica("Menos de 10 minutos contínuos de exercício por semana (Sedentário)");
        } else if (atFisicaEscolha == R.id.rb_novo_atividade_fisica_2) {
            prontuario.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_2);
            prontuario.setAtFisica("Menos de 150 minutos de exercicíos por semana. (Irregularmente ativo)");
        } else if (atFisicaEscolha == R.id.rb_novo_atividade_fisica_3) {
            prontuario.setAtFisicaOpt(R.id.rb_editar_atividade_fisica_3);
            prontuario.setAtFisica("Mais de 150 minutos exercicíos por semana. (Ativo)");
        } else {
            prontuario.setAtFisica("");
        }


        //Sono, avaliacao do ronco
        int sonoPontos = 0;
        int sonoEscolha = rgSonoOpt1.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_novo_sono_lendo_0) {
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_novo_sono_lendo_1) {
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_novo_sono_lendo_2) {
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_novo_sono_lendo_3) {
            prontuario.setSonoOpt1(R.id.rb_editar_sono_lendo_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt2.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_novo_sono_tv_0) {
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_novo_sono_tv_1) {
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_novo_sono_tv_2) {
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_novo_sono_tv_3) {
            prontuario.setSonoOpt2(R.id.rb_editar_sono_tv_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt3.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_novo_sono_publico_0) {
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_novo_sono_publico_1) {
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_novo_sono_publico_2) {
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_novo_sono_publico_3) {
            prontuario.setSonoOpt3(R.id.rb_editar_sono_publico_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt4.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_novo_sono_carro_0) {
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_novo_sono_carro_1) {
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_novo_sono_carro_2) {
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_novo_sono_carro_3) {
            prontuario.setSonoOpt4(R.id.rb_editar_sono_carro_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt5.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_novo_sono_almoco_0) {
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_novo_sono_almoco_1) {
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_novo_sono_almoco_2) {
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_novo_sono_almoco_3) {
            prontuario.setSonoOpt5(R.id.rb_editar_sono_almoco_3);
            sonoPontos = sonoPontos + 3;
        }

        sonoEscolha = rgSonoOpt6.getCheckedRadioButtonId();
        if (sonoEscolha == R.id.rb_novo_sono_transito_0) {
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_0);
            sonoPontos = sonoPontos + 0;
        } else if (sonoEscolha == R.id.rb_novo_sono_transito_1) {
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_1);
            sonoPontos = sonoPontos + 1;
        } else if (sonoEscolha == R.id.rb_novo_sono_transito_2) {
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_2);
            sonoPontos = sonoPontos + 2;
        } else if (sonoEscolha == R.id.rb_novo_sono_transito_3) {
            prontuario.setSonoOpt6(R.id.rb_editar_sono_transito_3);
            sonoPontos = sonoPontos + 3;
        }

        prontuario.setSonoPontos(sonoPontos);
        if (sonoPontos >= 10) {
            prontuario.setSono("Sonolência diurna excessiva!");
        } else {
            prontuario.setSono("Sono regular.");
        }

        //Tabagismo, cigarro, etc
        int cigarroPontos = 0;
        int cigarroEscolha = rgCigarroAtivo.getCheckedRadioButtonId();

        if (cigarroEscolha == R.id.rb_novo_tabagismo_sim) {

            prontuario.setCigarroAtivoOpt(R.id.rb_editar_tabagismo_sim);

            cigarroEscolha = rgCigarro1.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_novo_tabagismo_1_1) {
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_1);
                prontuario.setCigarro1("Dentro de 5 minutos. (3 pontos)");
                cigarroPontos = cigarroPontos + 3;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_1_2) {
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_2);
                prontuario.setCigarro1("Entre 6-30 minutos. (2 pontos)");
                cigarroPontos = cigarroPontos + 2;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_1_3) {
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_3);
                prontuario.setCigarro1("Entre 31-60 minutos. (1 ponto)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_1_4) {
                prontuario.setCigarroOpt1(R.id.rb_editar_tabagismo_1_4);
                prontuario.setCigarro1("Após 60 minutos. (0 ponto)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro2.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_novo_tabagismo_2_1) {
                prontuario.setCigarroOpt2(R.id.rb_editar_tabagismo_2_1);
                prontuario.setCigarro2("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_2_2) {
                prontuario.setCigarroOpt2(R.id.rb_editar_tabagismo_2_2);
                prontuario.setCigarro2("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro3.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_novo_tabagismo_3_1) {
                prontuario.setCigarroOpt3(R.id.rb_editar_tabagismo_3_1);
                prontuario.setCigarro3("O primeira do dia. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_3_2) {
                prontuario.setCigarroOpt3(R.id.rb_editar_tabagismo_3_2);
                prontuario.setCigarro3("Outros. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_3_3) {
                prontuario.setCigarroOpt3(R.id.rb_editar_tabagismo_3_3);
                prontuario.setCigarro3("Nenhum. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro4.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_novo_tabagismo_4_1) {
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_1);
                prontuario.setCigarro4("Menos de 10. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_4_2) {
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_2);
                prontuario.setCigarro4("De 11 a 20. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_4_3) {
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_3);
                prontuario.setCigarro4("De 21 a 30. (2 ponto)");
                cigarroPontos = cigarroPontos + 2;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_4_4) {
                prontuario.setCigarroOpt4(R.id.rb_editar_tabagismo_4_4);
                prontuario.setCigarro4("Mais de 31. (3 ponto)");
                cigarroPontos = cigarroPontos + 3;
            }

            cigarroEscolha = rgCigarro5.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_novo_tabagismo_5_1) {
                prontuario.setCigarroOpt5(R.id.rb_editar_tabagismo_5_1);
                prontuario.setCigarro5("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_5_2) {
                prontuario.setCigarroOpt5(R.id.rb_editar_tabagismo_5_2);
                prontuario.setCigarro5("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            cigarroEscolha = rgCigarro6.getCheckedRadioButtonId();
            if (cigarroEscolha == R.id.rb_novo_tabagismo_6_1) {
                prontuario.setCigarroOpt6(R.id.rb_editar_tabagismo_6_1);
                prontuario.setCigarro6("Sim. (1 pontos)");
                cigarroPontos = cigarroPontos + 1;
            } else if (cigarroEscolha == R.id.rb_novo_tabagismo_6_2) {
                prontuario.setCigarroOpt6(R.id.rb_editar_tabagismo_6_2);
                prontuario.setCigarro6("Não. (0 pontos)");
                cigarroPontos = cigarroPontos + 0;
            }

            prontuario.setCigarroPontos(cigarroPontos);

            if (cigarroPontos >= 0 && cigarroPontos <= 2) {
                prontuario.setCigarro("Grau de dependência do tabagismo: Muito baixo.");
            } else if (cigarroPontos >= 3 && cigarroPontos <= 4) {
                prontuario.setCigarro("Grau de dependência do tabagismo: Baixo.");
            } else if (cigarroPontos == 5) {
                prontuario.setCigarro("Grau de dependência do tabagismo: Médio.");
            } else if (cigarroPontos >= 6 && cigarroPontos <= 7) {
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


        //Alcool
        int alcoolPontos = 0;
        int alcoolEscolha = rgAlcoolAtivo.getCheckedRadioButtonId();

        if (alcoolEscolha == R.id.rb_novo_alcool_1) {

            prontuario.setAlcoolAtivoOpt(R.id.rb_editar_alcool_1);

            alcoolEscolha = rgAlcool1.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_novo_alcool_1_1) {
                prontuario.setAlcoolOpt1(R.id.rb_editar_alcool_1_1);
                prontuario.setAlcool1("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_novo_alcool_1_2) {
                prontuario.setAlcoolOpt1(R.id.rb_editar_alcool_1_2);
                prontuario.setAlcool1("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            alcoolEscolha = rgAlcool2.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_novo_alcool_2_1) {
                prontuario.setAlcoolOpt2(R.id.rb_editar_alcool_2_1);
                prontuario.setAlcool2("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_novo_alcool_2_2) {
                prontuario.setAlcoolOpt2(R.id.rb_editar_alcool_2_2);
                prontuario.setAlcool2("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            alcoolEscolha = rgAlcool3.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_novo_alcool_3_1) {
                prontuario.setAlcoolOpt3(R.id.rb_editar_alcool_3_1);
                prontuario.setAlcool3("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_novo_alcool_3_2) {
                prontuario.setAlcoolOpt3(R.id.rb_editar_alcool_3_2);
                prontuario.setAlcool3("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            alcoolEscolha = rgAlcool4.getCheckedRadioButtonId();
            if (alcoolEscolha == R.id.rb_novo_alcool_4_1) {
                prontuario.setAlcoolOpt4(R.id.rb_editar_alcool_4_1);
                prontuario.setAlcool4("Sim.");
                alcoolPontos = alcoolPontos + 1;
            } else if (alcoolEscolha == R.id.rb_novo_alcool_4_2) {
                prontuario.setAlcoolOpt4(R.id.rb_editar_alcool_4_2);
                prontuario.setAlcool4("Não.");
                alcoolPontos = alcoolPontos + 0;
            }

            if (alcoolPontos >= 2) {
                prontuario.setAlcool("Grau de dependência do álcool: Clinicamente significante (" + alcoolPontos + " 'Sim').");
            } else {
                prontuario.setAlcool("Grau de dependência do álcool: Muito baixo.");
            }


        } else {
            prontuario.setAlcoolAtivoOpt(R.id.rb_editar_alcool_2);
            prontuario.setAlcoolOpt1(null);
            prontuario.setAlcool1("Paciente não consome álcool.");
            prontuario.setAlcoolOpt2(null);
            prontuario.setAlcool2("Paciente não consome álcool.");
            prontuario.setAlcoolOpt3(null);
            prontuario.setAlcool3("Paciente não consome álcool.");
            prontuario.setAlcoolOpt4(null);
            prontuario.setAlcool4("Paciente não consome álcool.");
            prontuario.setAlcool("Paciente não consome álcool.");
        }


        
        prontuario.setComentario(edComentario.getText().toString());

        if (CheckProntuario.checkCampos(prontuario, this)) {

            prontuario = CheckProntuario.checkNumProntuario(prontuario, this);
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
