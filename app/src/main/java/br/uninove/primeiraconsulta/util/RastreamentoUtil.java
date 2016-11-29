package br.uninove.primeiraconsulta.util;

import java.util.ArrayList;
import java.util.List;

import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Rastreamento;

/**
 * Created by PB on 22/11/2016.
 */

public class RastreamentoUtil {
    public static List<Rastreamento> getRastreamento(Prontuario prontuario, EstiloDeVida estiloDeVida, ExameFisico exameFisico) {
        List<Rastreamento> listaRastreamento = new ArrayList<>();

        //1 - Cancer de colo de utero
        if((prontuario.getIdade() >= 25 && prontuario.getIdade() <= 64)
                && prontuario.getSexo().equals("Feminino")
                && estiloDeVida.getSexualmenteAtivo().equals("Sim")){

            Rastreamento r = new Rastreamento();
            r.setNivel("A/B");
            r.setRastreamento("Câncer de Colo de Útero (Papanicolau)");
            r.setTitulo("Câncer de Colo de Útero (Papanicolau)");
            r.setTexto("Promoção \t\t\t\t\n" +
                    "O amplo acesso da população a informações claras, consistentes e culturalmente apropriadas a cada região deve ser uma iniciativa dos serviços de saúde em todos os níveis do atendimento. O controle do tabagismo pode ajudar a minimizar o risco de câncer do colo do útero e é também uma das prioridades da Política Nacional de Promoção da Saúde \n" +
                    "\n" +
                    "Prevenção Primaria \n" +
                    "O uso de preservativos (camisinha) durante a relação sexual com penetração protege parcialmente do contagio pelo HPV, que também pode ocorrer por intermédio do contato com a pele da vulva, a perianal e a bolsa escrotal. Atualmente há duas vacinas aprovadas e comercialmente disponíveis no Brasil: a bivalente, que protege contra os tipos oncogênicos 16 e 18, e a quadrivalente, que protege contra os tipos não oncogênicos 6 e 11 e os tipos oncogênicos 16 e 18. Ambas são eficazes contra as lesões precursoras do câncer do colo do útero, principalmente se utilizadas antes do contato com o vírus. Ou seja, os benefícios são significativos antes do início da vida sexual. A adoção das vacinas anti-HPV NÃO elimina a necessidade da prevenção secundária por meio do rastreamento, pois as mesmas não oferecem proteção para 30% dos casos de câncer do colo do útero causados por outros tipos virais oncogênicos.  (MINISTÉRIO DA SAÚDE, 2013)\n" +
                    "\n" +
                    "\t\t\t\t\t\n" +
                    "Prevenção secundária: \n" +
                    "O método de rastreamento do câncer do colo do útero e de suas lesões precursoras é o exame citopatológico\n" +
                    "\n" +
                    "\n" +
                    "População Alvo:\t\t\t\t\t\t \t\t\t\t\t\t\n" +
                    "O início da coleta deve ser aos 25 anos de idade para as mulheres que já tiveram atividade sexual (A).\n" +
                    "\t\t\t\t\t\t\t \t\t\t\t\t\t\t\t\n" +
                    "Os exames devem seguir até os 64 anos e serem interrompidos quando, após essa idade, as mulheres tiverem pelo menos dois exames negativos consecutivos nos últimos cinco anos (B).\n" +
                    "\t\t\t\t\t\t\t\n" +
                    "Para mulheres com mais de 64 anos e que nunca realizaram o exame citopatológico, deve-se realizar dois exames com intervalo de um a três anos. Se ambos forem negativos, essas mulheres podem ser dispensadas de exames adicionais (B). (Caderno de Controle dos cânceres do colo do útero e da mama)\n" +
                    "\t\t\t\t\t\t\t\n" +
                    "\t\t\t\t\t\t \t\t\t\t\t\n" +
                    "Frequência \n" +
                    "A rotina preconizada no rastreamento brasileiro, assim como nos países desenvolvidos, é a repetição do exame de Papanicolau a cada três anos, após dois exames normais consecutivos no intervalo de um ano (A). A particularidade na rotina do rastreamento refere-se àquelas portadoras do vírus HIV ou imunodeprimidas. Estas devem realizar o exame anualmente, pois apresentam defesa imunológica reduzida e, em consequência, maior vulnerabilidade para as lesões precursoras de câncer do colo do útero. Mulheres  .Por outro lado, não devem ser incluídas no rastreamento as mulheres histerectomizadas por outras razões que não o câncer do colo do útero (INCA, 2003).");
            listaRastreamento.add(r);
            System.out.println("add");

        }

        //2 - Cancer de mama
        if((prontuario.getIdade() >= 50 && prontuario.getIdade() <= 69)
                && prontuario.getSexo().equals("Feminino")){

            Rastreamento r = new Rastreamento();
            r.setNivel("B");
            r.setRastreamento("Câncer de Mama");
            r.setTitulo("Câncer de Mama");
            r.setTexto("Evidências demonstram uma diminuição do risco relativo para câncer de mama de cerca de 4,3% a cada 12 meses de aleitamento materno, adicionais à redução de risco relacionada à maior paridade . Fatores relacionados ao estilo de vida como obesidade pós-menopausa, sedentarismo, consumo excessivo de álcool e terapia de reposição hormonal, podem ser controlados e contribuir para diminuir a incidência do câncer de mama, o que historicamente tem sido pouco valorizado. (MINISTÉRIO DA SAÚDE, 2013)\n" +
                    "\t\t\t\t\t\n" +
                    "Publico Alvo :\n" +
                    "Mulheres entre 50 e 69 anos. Grau de recomendação B. \n" +
                    "\n" +
                    "\n" +
                    "Frequência :\n" +
                    "População-alvo|\t|Periodicidade dos exames de rastreamento\n" +
                    "Mulheres de 40 a 49 anos|\t|ECM anual e, se este estiver alterado, mamografia\n" +
                    "Mulheres de 50 a 69 anos|\t|ECM anual e mamografia de dois em dois anos.\n" +
                    "Mulheres de 35 anos ou mais com risco elevado|\t|ECM e mamografia anual.\n" +
                    "Fonte: (INCA, 2004)      \t\t\texame clínico das mamas(ECM)\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }else if((prontuario.getIdade() >= 40 && prontuario.getIdade() <= 49)
                && prontuario.getSexo().equals("Feminino")){

            Rastreamento r = new Rastreamento();
            r.setNivel("B");
            r.setRastreamento("Câncer de Mama");
            r.setTexto("Evidências demonstram uma diminuição do risco relativo para câncer de mama de cerca de 4,3% a cada 12 meses de aleitamento materno, adicionais à redução de risco relacionada à maior paridade . Fatores relacionados ao estilo de vida como obesidade pós-menopausa, sedentarismo, consumo excessivo de álcool e terapia de reposição hormonal, podem ser controlados e contribuir para diminuir a incidência do câncer de mama, o que historicamente tem sido pouco valorizado. (MINISTÉRIO DA SAÚDE, 2013)\n" +
                    "\t\t\t\t\t\n" +
                    "Publico Alvo :\n" +
                    "Mulheres entre 50 e 69 anos. Grau de recomendação B. \n" +
                    "\n" +
                    "\n" +
                    "Frequência :\n" +
                    "População-alvo|\t|Periodicidade dos exames de rastreamento\n" +
                    "Mulheres de 40 a 49 anos|\t|ECM anual e, se este estiver alterado, mamografia\n" +
                    "Mulheres de 50 a 69 anos|\t|ECM anual e mamografia de dois em dois anos.\n" +
                    "Mulheres de 35 anos ou mais com risco elevado|\t|ECM e mamografia anual.\n" +
                    "Fonte: (INCA, 2004)      \t\t\texame clínico das mamas(ECM)\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }

        //3 - Cancer de Prostata
        if((prontuario.getIdade() >= 55 && prontuario.getIdade() <= 69)
                && prontuario.getSexo().equals("Masculino")){
            Rastreamento r = new Rastreamento();
            r.setNivel("I");
            r.setRastreamento("Câncer de Próstata");
            r.setTitulo("Câncer de Próstata");
            r.setTexto("Alimentação rica em frutas, verduras, legumes, grãos e cereais integrais, e pobre em gorduras, principalmente as de origem animal, ajuda a diminuir o risco de câncer. Portanto outros hábitos saudáveis também são recomendados, como fazer, no mínimo, 30 minutos diários de atividade física, manter o peso adequado, diminuir o consumo de álcool e não fumar (INSTITUTO NACIONAL DE CÂNCER, 2011)\n" +
                    "\n" +
                    "Prevenção secundária:\n" +
                    "O rastreamento para câncer de próstata não é recomendado pela OMS e USPSTF. A redução de mortalidade para este tipo de câncer é muito pequena mesmo para faixa ideal de 55 a 69 anos (MINISTÉRIO DA SAÚDE, 2010; VIRGINIA A. MOYER, 2012). A Decisão de iniciar ou continuar o rastreamento por PSA deve ser sempre precedida pela explicação dos riscos beneficios e respeitar as preferências do paciente \n" +
                    "\n" +
                    "\n" +
                    "Publico Alvo:\n" +
                    "Homens entre 55 a 69 anos \n");
            listaRastreamento.add(r);
            System.out.println("add");

        }

        //4 - Cancer de colon e reto
        if((prontuario.getIdade() >= 50 && prontuario.getIdade() <= 75)){
            Rastreamento r = new Rastreamento();
            r.setNivel("A");
            r.setRastreamento("Câncer de Cólon e Reto");
            r.setTitulo("Câncer de Cólon e Reto");
            r.setTexto("Uma alimentação rica em vegetais e laticínios e pobre em gordura (principalmente a saturada), além da prática de atividade física regular, previne o câncer coloretal. Deve-se ainda evitar o consumo exagerado de carne vermelha (INSTITUTO NACIONAL DE CÂNCER, 2011)\n" +
                    "\n" +
                    "Prevenção secundária:\n" +
                    "Recomenda-se o rastreamento para o câncer de cólon e reto usando pesquisa de sangue oculto nas fezes, colonoscopia ou Sigmoidoscopia, em adultos entre 50 e 75 anos. Os riscos e os benefícios variam conforme o exame de rastreamento (A).  O protocolo de rastreamento para o rastreamento câncer do intestino mais utilizado por esses poucos é a realização inicial da pesquisa de sangue oculto nas fezes, seguida pela colonoscopia naqueles com resultado positivo (INSTITUTO NACIONAL DE CÂNCER, 2010).\n" +
                    "\n" +
                    "Público Alvo:\n" +
                    "Os adultos entre 50 e 75 anos\n" +
                    "\n" +
                    "Frequência \n" +
                    "Realização de exame de sangue oculto nas fezes anual ou bienal. Se positivo deve-se se realizar Sigmoidoscopia ou colonoscopia (INSTITUTO NACIONAL DE CÂNCER, 2010).\n");

            listaRastreamento.add(r);
            System.out.println("add");

        }

        //5 - Dislipidemia
        if(prontuario.getIdade() >= 35 && prontuario.getSexo().equals("Masculino")){
            Rastreamento r = new Rastreamento();
            r.setNivel("A");
            r.setRastreamento("Dislipidemia");
            r.setTitulo("Dislipidemia");
            r.setTexto("Está recomendado fortemente o rastreamento das desordens lipídicas em homens com 35 anos ou mais.(A) \n" +
                    "\n" +
                    "Recomenda-se fortemente o rastreamento das desordens lipídicas em mulheres com 45 anos ou mais quando se enquadrarem como grupo de alto risco para doença coronariana.(A)\n" +
                    "\n" +
                    "Frequência:\n" +
                    "\n" +
                    "O intervalo ótimo para rastreamento é incerto e este está principalmente fixado de acordo com o risco cardiovascular. Quanto maior o risco, menor o intervalo de rastreamento. Intervalos menores podem ser recomendados para pessoas que têm níveis lipídicos próximos do limite para instituição de terapia. Intervalos maiores também podem ser estabelecidos para aqueles com baixo risco cardiovascular ou que apresentem níveis lipídicos repetidamente normais.(MINISTÉRIO DA SAÚDE, 2010).\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }else if(prontuario.getIdade() >= 45 && prontuario.getSexo().equals("Feminino")){
            Rastreamento r = new Rastreamento();
            r.setNivel("A");
            r.setRastreamento("Dislipidemia");
            r.setTitulo("Dislipidemia");
            r.setTexto("Está recomendado fortemente o rastreamento das desordens lipídicas em homens com 35 anos ou mais.(A) \n" +
                    "\n" +
                    "Recomenda-se fortemente o rastreamento das desordens lipídicas em mulheres com 45 anos ou mais quando se enquadrarem como grupo de alto risco para doença coronariana.(A)\n" +
                    "\n" +
                    "Frequência:\n" +
                    "\n" +
                    "O intervalo ótimo para rastreamento é incerto e este está principalmente fixado de acordo com o risco cardiovascular. Quanto maior o risco, menor o intervalo de rastreamento. Intervalos menores podem ser recomendados para pessoas que têm níveis lipídicos próximos do limite para instituição de terapia. Intervalos maiores também podem ser estabelecidos para aqueles com baixo risco cardiovascular ou que apresentem níveis lipídicos repetidamente normais.(MINISTÉRIO DA SAÚDE, 2010).\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }else if((prontuario.getIdade() >= 20 && prontuario.getIdade() <= 35)
                && prontuario.getSexo().equals("Masculino")){
            Rastreamento r = new Rastreamento();
            r.setNivel("B");
            r.setRastreamento("Dislipidemia");
            r.setTitulo("Dislipidemia");
            r.setTexto("Recomenda-se também o rastreamento das desordens lipídicas em homens com 20 a 35 anos quando se enquadrarem como um grupo de alto risco para doença coronariana.(B) \n" +
                    "\n" +
                    "Recomenda-se também o rastreamento das desordens lipídicas em mulheres com 20 a 45 anos quando se enquadrarem como um grupo de alto risco para doença coronariana(B) (MINISTÉRIO DA SAÚDE, 2010).\n" +
                    "\n" +
                    "Frequência:\n" +
                    "\n" +
                    "O intervalo ótimo para rastreamento é incerto e este está principalmente fixado de acordo com o risco cardiovascular. Quanto maior o risco, menor o intervalo de rastreamento. Intervalos menores podem ser recomendados para pessoas que têm níveis lipídicos próximos do limite para instituição de terapia. Intervalos maiores também podem ser estabelecidos para aqueles com baixo risco cardiovascular ou que apresentem níveis lipídicos repetidamente normais.(MINISTÉRIO DA SAÚDE, 2010).\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }else if((prontuario.getIdade() >= 20 && prontuario.getIdade() <= 45)
                && prontuario.getSexo().equals("Feminino")){
            Rastreamento r = new Rastreamento();
            r.setNivel("B");
            r.setRastreamento("Dislipidemia");
            r.setTitulo("Dislipidemia");
            r.setTexto("Recomenda-se também o rastreamento das desordens lipídicas em homens com 20 a 35 anos quando se enquadrarem como um grupo de alto risco para doença coronariana.(B) \n" +
                    "\n" +
                    "Recomenda-se também o rastreamento das desordens lipídicas em mulheres com 20 a 45 anos quando se enquadrarem como um grupo de alto risco para doença coronariana(B) (MINISTÉRIO DA SAÚDE, 2010).\n" +
                    "\n" +
                    "Frequência:\n" +
                    "\n" +
                    "O intervalo ótimo para rastreamento é incerto e este está principalmente fixado de acordo com o risco cardiovascular. Quanto maior o risco, menor o intervalo de rastreamento. Intervalos menores podem ser recomendados para pessoas que têm níveis lipídicos próximos do limite para instituição de terapia. Intervalos maiores também podem ser estabelecidos para aqueles com baixo risco cardiovascular ou que apresentem níveis lipídicos repetidamente normais.(MINISTÉRIO DA SAÚDE, 2010).\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }

        //6 - Diabetes Mellitus II (DMII)

            if(!estiloDeVida.getAcucar().isEmpty() && exameFisico.getImc() != null &&
                    !exameFisico.getPaResultado().isEmpty() && !estiloDeVida.getAtFisica().isEmpty()){
                if(prontuario.getIdade() >= 18 && estiloDeVida.getAcucar().equals("Maior de 75g 5x por semana. (Inadequado)")
                        || exameFisico.getImc() >= 25
                        || exameFisico.getPaResultado().equals("Pressão arterial acima do normal")
                        || estiloDeVida.getAtFisica().equals("Menos de 10 minutos contínuos de exercício por semana (Sedentário)")){
                    Rastreamento r = new Rastreamento();
                    r.setNivel("B");
                    r.setRastreamento("Diabetes Mellitus");
                    r.setTitulo("Diabetes Mellitus II (DMII)");
                    r.setTexto("Adoção de hábitos de vida saudáveis, como uma alimentação equilibrada, prática regular de atividade física, moderação no uso de álcool e abandono do tabagismo, e redução do peso. (MINISTÉRIO DA SAÚDE, 2013, DIABETES MELLITUS)\n" +
                            "\n" +
                            "Público alvo:\n" +
                            "Critérios para o rastreamento do DM II em adultos assintomáticos:\n" +
                            " Excesso de peso ( IMC > 25 Kg) e um dos seguintes fatores de risco:\n" +
                            "●\tHistória de pai ou mãe com diabetes;\n" +
                            "●\tHipertensão arterial (> 140/90 mmHg ou uso de anti - hipertensivos em adultos);\n" +
                            "●\tDislipidemia: hipertrigliceridemia (> 250 mg/dL) ou HDL-C baixo (< 35 mg/dL);\n" +
                            "●\tExame prévio de HcA1c  ≥ 5,7%, tolerância diminuída à glicose ou glicemia de jejum alter ada;\n" +
                            "●\tObesidade severa, acanthosis nigricans;\n" +
                            "●\tSíndrome de ovários policísticos;\n" +
                            "●\tHistória de doença cardiovascular;\n" +
                            "●\tInatividade física;\n" +
                            "ou \n" +
                            "●\tIdade≥ 45 anos;\n" +
                            "ou \n" +
                            "●\tRisco cardiovascular moderado.\n" +
                            "Fonte: (MINISTÉRIO DA SAÚDE, 2013,DIABETES MELLITUS)\n" +
                            "\n" +
                            "Frequência:\n" +
                            "\n" +
                            "Alguns estudos apontaram que as pessoas que apresentam resultados negativos podem ser testadas a cada 3 a 5 anos [Grau de Recomendação E] (AMERICAN DIABETES ASSOCIATION, 2013).\n" +
                            "Casos de tolerância diminuída à glicose, glicemia de jejum alterada ou diabetes gestacional prévio, podem ser testados mais frequentemente, por exemplo, anualmente (AMERICAN DIABETES ASSOCIATION, 2013).\n");
                    listaRastreamento.add(r);
                    System.out.println("add");

                }

            }




        //7 - Tabaco

        if(estiloDeVida.getCigarroPontos() != null){

            if(prontuario.getIdade() >= 18 && estiloDeVida.getCigarroPontos() >= 3){
                Rastreamento r = new Rastreamento();
                r.setNivel("A");
                r.setRastreamento("Tabaco");
                r.setTitulo("Tabaco");
                r.setTexto("A abordagem breve (cerca de cinco minutos) pode levar a cerca de 5% do abandono do hábito do tabaco. Em todos os encontros com os pacientes, recomenda-se que os profissionais de saúde perguntem a todos os adultos (incluídas as gestantes) sobre o uso do tabaco e forneçam intervenção para que deixem esse hábito. (Série A. Normas e Manuais Técnicos Cadernos de Atenção Primária, n. 29)\n" +
                        "A promoção de saúde deve ser feita também com pacientes não tabagistas, sempre reforçando que o tabagismo aumento o risco de doenças cardio, cerebrovascular, e neoplasias. (Cadernos de Atenção Básica Prevenção Clínica de doenças cardiovascular, cerebrovascular e renal crônica).\n" +
                        "\n" +
                        "\n" +
                        "Prevenção Secundária:\n" +
                        "Fornecer gratuitamente recursos de abandono para fumantes aumenta significativamente a proporção de fumantes que tentam parar, usam tratamentos medicamentosos e param de fumar.\n" +
                        "\n" +
                        "População alvo:\n" +
                        "Está recomendado o rastreamento do tabagismo em todos os adultos, incluídas as gestantes. (A)\n" +
                        "\n" +
                        "Frequência:\n" +
                        "Em todos os encontros com os pacientes, recomenda-se que os profissionais de saúde perguntem a todos os adultos (incluídas as gestantes) sobre o uso do tabaco e forneçam intervenção para que deixem esse hábito.(Série A. Normas e Manuais Técnicos Cadernos de Atenção Primária, n. 29)\n");
                listaRastreamento.add(r);
                System.out.println("add");

            }

        }



        //8 - Alcool

        if(estiloDeVida.getAlcool() != null){

            if(prontuario.getIdade() >= 18 && (!estiloDeVida.getAlcool().equals("Grau de dependência do álcool: Muito baixo.")
                    && !estiloDeVida.getAlcool().equals("N/D") && !estiloDeVida.getAlcool().equals("Paciente não consome álcool."))){
                Rastreamento r = new Rastreamento();
                r.setNivel("B");
                r.setRastreamento("Álcool");
                r.setTitulo("Álcool");
                r.setTexto("Há boa evidência de que o aconselhamento comportamental breve, com seguimento dos usuários, produz de pequena a moderada redução no consumo de álcool de forma sustentada ao longo de seis a 12 meses ou mais. Encontrou-se alguma evidência de que a intervenção produz resultados em saúde após quatro anos ou mais do aconselhamento.(MINISTÉRIO DA SAÚDE, 2010)\n" +
                        " \n" +
                        "Prevenção Secundária: \n" +
                        "Há dois testes mais conhecidos. O AUDIT (The Alcohol Use Disorders) e o CAGE(feeling the need to Cut down, Annoyed by criticism, Guilty about drinking, and need for an Eye-opener in the morning), sendo esse último o mais utilizado na atenção primária.\n" +
                        "\n" +
                        "População Alvo:\n" +
                        "Recomenda-se o rastreamento e intervenções de aconselhamento na atenção primária para reduzir o uso inadequado de álcool em adultos, incluindo mulheres grávidas. (B).\n" +
                        "\n" +
                        "Frequência:\n" +
                        "Não há um intervalo conhecido para realizar os testes de rastreio. Pacientes com histórico de problemas com álcool, adultos jovens e grupos de alto risco (por exemplo, tabagistas) podem ser beneficiados com o rastreio mais frequente.(MINISTÉRIO DA SAÚDE, 2010)\n");
                listaRastreamento.add(r);
                System.out.println("add");

            }

        }



        //9 - Câncer de Pele

        if(prontuario.getIdade() >= 18){
            Rastreamento r = new Rastreamento();
            r.setNivel("I");
            r.setRastreamento("Câncer de pele");
            r.setTitulo("Câncer de pele");
            r.setTexto("Evitar exposição prolongada ao sol entre 10h e 16h. Usar sempre proteção adequada, como bonês ou chapéus de abas largas, óculos escuros, barraca e filtro solar com fator mínimo de proteção FPS 15 (INSTITUTO NACIONAL DE CÂNCER, 2011).\n" +
                    "\n" +
                    "Prevenção secundária: \n" +
                    "As evidências científicas indicam que o rastreamento populacional para o câncer de pele por meio do auto- exame ou do exame clínico não reduziu a mortalidade por este câncer. Entretanto, o exame clínico da pele deve fazer parte do exame físico de rotina, mesmo que a queixa principal do paciente não esteja localizada na pele. Especial atenção deve ser dada aos indivíduos de pele clara, trabalhadores rurais, pescadores e outros profissionais com alta exposição à luz solar (INSTITUTO NACIONAL DE CÂNCER, 2002).\n" +
                    "\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }

        //10 - Doença Cardiovascular

        if(prontuario.getIdade() >= 12){
            Rastreamento r = new Rastreamento();
            r.setNivel("A");
            r.setRastreamento("Doença Cardiovascular");
            r.setTitulo("Doença Cardiovascular");
            r.setTexto("Prevenção primária\n" +
                    "A prevenção primordial cardiovascular engloba evitar a instalação dos fatores de risco cardiovascular modificáveis, entre eles o tabagismo , e construir estratégias eficazes para que se faça a promoção da saúde cardiovascular do indivíduo e da população. Para tanto, torna-se necessária a ação conjunta de equipes multidisciplinar (médicos, enfermeiros, psicólogos, educadores físicos, pedagogos, nutricionistas, assistentes sociais, comunicadores, gestores) e intersetoriais (família, escola, governo, sociedade de especialistas, universidade) de forma contínua e simultânea.(SIMÃO et al., 2014)\n" +
                    "\n" +
                    "\n" +
                    "Prevenção Secundária\n" +
                    "A intensidade das intervenções preventivas deve ser determinada pelo grau de risco cardiovascular estimado para cada indivíduo e não pelo valor de um determinado fator. Em termos práticos, costuma-se classificar os indivíduos em três níveis de risco - baixo, moderado e alto - para o desenvolvimento de eventos cardiovasculares maiores. A Estratificação de Risco baseia-se na classificação inicial levando-se em conta o exame clínico e avança para a indicação de exames complementares (risco global). Ministério da Saúde, 2006. (Cadernos de Atenção Básica, n. 14)\n" +
                    "\n" +
                    "Frequência:\n" +
                    "A classificação de risco pode ser repetida a cada 3 a 5 anos ou sempre que eventos clínicos apontarem a necessidade de reavaliação.Ministério da Saúde, 2006. (Cadernos de Atenção Básica, n. 14)\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }

        //11 - HAS
        if(prontuario.getIdade() >= 18
                && (exameFisico.getSistole() <= 120 || exameFisico.getDiastole() >= 80)
                || (exameFisico.getSistole() >= 140 || exameFisico.getDiastole() >= 90)){
            Rastreamento r = new Rastreamento();
            r.setNivel("A");
            r.setRastreamento("HAS");
            r.setTitulo("Hipertensão Arterial Sistêmica");
            r.setTexto("Promoção\n" +
                    "A promoção do estilo de vida mais ativo tem sido utilizada como estratégia de desenvolver melhoria nos padrões de saúde e na qualidade de vida. Dentre eles:\n" +
                    "●\tControle de peso;\n" +
                    "●\tAdoção de hábitos alimentares saudáveis: dieta com conteúdo reduzido de teores de sódio, baseada em frutas, verduras e legumes, cereais integrais, leguminosas, leite e derivados desnatados, quantidade reduzida de gorduras saturadas, trans e colesterol;\n" +
                    "●\tRedução do consumo de bebidas alcoólicas;\n" +
                    "●\tAbandono do tabagismo;\n" +
                    "●\tPrática de atividade física regular.\n" +
                    "Ministério da Saúde, 2013. (Cadernos de Atenção Básica, n. 37)\n" +
                    "\n" +
                    "Prevenção Secundária\n" +
                    "Aferição de Pressão arterial \n" +
                    "\n" +
                    "População Alvo:\n" +
                    "Está recomendado o rastreamento da hipertensão arterial nos adultos (acima de 18 anos) sem o conhecimento de que sejam hipertensos.\n" +
                    "\n" +
                    "\n" +
                    "Frequência:\n" +
                    " Recomenda o rastreamento a cada dois anos nas pessoas com pressão arterial menor que 120/80 e rastreamento anual se a pressão sistólica estiver entre 120 e 139 mmHg ou a diastólica entre 80 e 90 mmHg.  \n");
            listaRastreamento.add(r);
            System.out.println("add");

        }


        //12 - Obesidade

        if(exameFisico.getImc() != null){

            if(prontuario.getIdade() >= 18 && exameFisico.getImc() >= 30){
                Rastreamento r = new Rastreamento();
                r.setNivel("B");
                r.setRastreamento("Obesidade");
                r.setTitulo("Obesidade");
                r.setTexto("A pratica de atividade física regular associada com alimentação saudável deve ser incetivada \n" +
                        "Ministério da Saúde, 2014. (Cadernos de Atenção Básica, n. 12)\n" +
                        "\n" +
                        "Prevenção Secundária\n" +
                        "Deve se realizar o calculo de IMC\n" +
                        "\n" +
                        "População Alvo\n" +
                        "Recomenda-se o rastreamento de todos os pacientes adultos para obesidade (B).\n" +
                        "\n" +
                        "Frequência\n" +
                        "Não há recomendação clara sobre a periodicidade do rastreamento, assim ele fica indicado durante a consulta de exame periódico de saúde. (INSTITUTO NACIONAL DE CÂNCER, 2010)\n");
                listaRastreamento.add(r);
                System.out.println("add");

            }

        }




        //13 - Câncer de Boca

        if(prontuario.getIdade() >= 18){
            Rastreamento r = new Rastreamento();
            r.setNivel("I");
            r.setRastreamento("Câncer de Boca");
            r.setTitulo("Câncer de Boca");
            r.setTexto("Os pacientes devem ser encorajados a não fazer uso de tabaco e de álcool com o objetivo de diminuir o risco para o câncer de boca (INSTITUTO NACIONAL DE CÂNCER, 2010)\n" +
                    "\n" +
                    "Prevenção Secundária\n" +
                    "As estratégias de rastreamento populacional para o câncer de boca não têm conseguido demonstrar impacto sobre as taxas de mortalidade. Frente aos estudos disponíveis até o momento, as agências de avaliação de tecnologias em saúde apontam não haver evidências que justifiquem a utilização do rastreamento populacional para esse tipo de câncer.\n" +
                    "(INSTITUTO NACIONAL DE CÂNCER, 2010)\n");
            listaRastreamento.add(r);
            System.out.println("add");

        }

        return listaRastreamento;
    }

    public static String getReferencias(){
        String referencias = "INSTITUTO NACIONAL DE CÂNCER. ABC do câncer : abordagens básicas para o controle do câncer. [S.l: s.n.], 2011. Disponível em: <http://bvsms.saude.gov.br/ bvs/controle_cancer>.\n" +
                "\n" +
                "MINISTÉRIO DA SAÚDE. CONTROLE DOS CÂNCERES DO COLO DO ÚTERO E DA MAMA. 2. ed. Brasília: [s.n.], 2013.\n" +
                "\n" +
                "MINISTÉRIO DA SAÚDE. Rastreamento. Brasília: [s.n.], 2010.\n" +
                "\n" +
                "MOYER VA. Screening for Prostate Cancer: U.S. Preventive Services Task Force Recommendation Statement. Annals of Internal Medicine, v. 157, n. 2, p. I, 17 jul. 2012.\n" +
                "\n" +
                "\t\t\t\t\t\n" +
                "Instituto Nacional de Câncer - INCA (Brasil). Prevenção e controle do câncer: normas e recomendações do INCA. Rev Bras Cancerol 2002;48(3):317-32. \n" +
                "\n" +
                "SIMÃO, Antonio Felipe et al. I Cardiovascular Prevention Guideline of the Brazilian Society of Cardiology - Executive Summary. Arquivos Brasileiros de Cardiologia, v. 102, n. 5, p. 420–431, maio 2014. Acesso em: 30 jun. 2015.\n" +
                "\n" +
                "TOGEIRO, Sônia Maria Guimarães Pereira; SMITH, Anna Karla. Diagnostics methods for sleep disorders. Revista Brasileira de Psiquiatria, v. 27, p. 8–15, maio 2005. Acesso em: 25 jun. 2015.\n" +
                "XAVIER, H. T. et al. V Diretriz Brasileira de Dislipidemias e Prevenção da Aterosclerose. Arquivos Brasileiros de Cardiologia, v. 101, n. 4, p. 1–20, out. 2013. Acesso em: 30 jun. 2015.\n" +
                "\n" +
                "Reda AA, Kotz D, Evers SM, et al. Healthcare financing systems for increasing the use of tobacco dependence treatment. Cochrane Database Syst Rev. 2012;(6):CD004305.)\n";

        return referencias;

    }
}
