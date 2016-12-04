package br.uninove.primeiraconsulta.activity.prontuario.adapter;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.activity.prontuario.EditarProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.ListarProntuariosActivity;
import br.uninove.primeiraconsulta.activity.prontuario.LogProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.VerProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.excluir.ExcluirProntuarioActivity;
import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by PB on 10/11/2016.
 */

public class ViewHolderProntuarioList {

    public Prontuario prontuarioHolder;

    @Bind(R.id.tv_lista_num_prontuario)
    TextView numProntuario;

    @OnClick(R.id.bt_lista_ver)
    public void btVer(){
        try {
            EstiloDeVida estiloDeVida = EstiloDeVidaDao.buscarPorId(prontuarioHolder.getIdEstiloDeVida(), ListarProntuariosActivity.getContext());
            ExameFisico exameFisico = ExameFisicoDao.buscarPorId(prontuarioHolder.getIdExameFisico(), ListarProntuariosActivity.getContext());
            Anamnese anamnese = AnamneseDao.buscarPorId(prontuarioHolder.getIdAnamnese(), ListarProntuariosActivity.getContext());
            List<ListaProblemas> listaProblemas = ListaProblemasDao.buscarPorNumProntuario(prontuarioHolder, ListarProntuariosActivity.getContext());

            Intent intent = new Intent(ListarProntuariosActivity.getContext(), VerProntuarioActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("prontuario", prontuarioHolder);
            intent.putExtra("estiloDeVida", estiloDeVida);
            intent.putExtra("exameFisico", exameFisico);
            intent.putExtra("anamnese", anamnese);
            intent.putExtra("listaProblemas", (Serializable) listaProblemas);
            ListarProntuariosActivity.getContext().startActivity(intent);
        }catch (Exception e){
            Log.e("ver holder", e.getMessage());
            Toast.makeText(ListarProntuariosActivity.getContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.bt_lista_excluir)
    public void btExcluir(){

        try {
            EstiloDeVida estiloDeVida = EstiloDeVidaDao.buscarPorId(prontuarioHolder.getIdEstiloDeVida(), ListarProntuariosActivity.getContext());
            ExameFisico exameFisico = ExameFisicoDao.buscarPorId(prontuarioHolder.getIdExameFisico(), ListarProntuariosActivity.getContext());
            Anamnese anamnese = AnamneseDao.buscarPorId(prontuarioHolder.getIdAnamnese(), ListarProntuariosActivity.getContext());
            List<ListaProblemas> listaProblemas = ListaProblemasDao.buscarPorNumProntuario(prontuarioHolder, ListarProntuariosActivity.getContext());

            Intent intent = new Intent(ListarProntuariosActivity.getContext(), ExcluirProntuarioActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("prontuario", prontuarioHolder);
            intent.putExtra("estiloDeVida", estiloDeVida);
            intent.putExtra("exameFisico", exameFisico);
            intent.putExtra("anamnese", anamnese);
            intent.putExtra("listaProblemas", (Serializable) listaProblemas);
            ListarProntuariosActivity.getContext().startActivity(intent);
        }catch (Exception e){
            Log.e("excluir holder", e.getMessage());
            Toast.makeText(ListarProntuariosActivity.getContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.bt_lista_editar)
    public void btEditar(){
        try {
            Intent intent = new Intent(ListarProntuariosActivity.getContext(), EditarProntuarioActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("prontuario", prontuarioHolder);
            ListarProntuariosActivity.getContext().startActivity(intent);
        }catch (Exception e){
            Log.e("editar holder", e.getMessage());
            Toast.makeText(ListarProntuariosActivity.getContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }


    @OnClick(R.id.bt_lista_log)
    public void btLog(){
        try {
            Intent intent = new Intent(ListarProntuariosActivity.getContext(), LogProntuarioActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("prontuario", prontuarioHolder);
            ListarProntuariosActivity.getContext().startActivity(intent);
        }catch (Exception e){
            Log.e("log holder", e.getMessage());
            Toast.makeText(ListarProntuariosActivity.getContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

}
