package br.uninove.primeiraconsulta.activity.prontuario.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.activity.prontuario.EditarProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.ListarProntuariosActivity;
import br.uninove.primeiraconsulta.activity.prontuario.LogProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.VerProntuarioActivity;
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
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 23/11/2016.
 */

public class LogProntuarioAdapter extends ArrayAdapter<Prontuario> {

    public LogProntuarioAdapter(Context context, List<Prontuario> prontuarioLista) {
        super(context, R.layout.list_log_edicoes, prontuarioLista);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.list_log_edicoes, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Prontuario prontuario = getItem(position);
        holder.prontuarioHolder = prontuario;
        if(prontuario!=null) {
            holder.dataEdicao.setText(prontuario.getDataEdicao());
        }
        return convertView;
    }

    class ViewHolder {

        public Prontuario prontuarioHolder;

        @Bind(R.id.tv_log_data_edicao)
        TextView dataEdicao;

        @OnClick(R.id.bt_log_ver)
        public void btVer(){
            List<ListaProblemas> listaProblemas = LogListaProblemasDao.buscarPorNumProntuario(prontuarioHolder, ListarProntuariosActivity.getContext());

            Intent intent = new Intent(LogProntuarioActivity.getContext(), VerProntuarioActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("prontuario", prontuarioHolder);
            intent.putExtra("listaProblemas", (Serializable) listaProblemas);
            LogProntuarioActivity.getContext().startActivity(intent);
        }

        @OnClick(R.id.bt_log_excluir)
        public void btExcluir(){

            EstiloDeVida estiloDeVida = LogEstiloDeVidaDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
            ExameFisico exameFisico = LogExameFisicoDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
            Anamnese anamnese = LogAnamneseDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
            List<ListaProblemas> listaProblemases = LogListaProblemasDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());

            LogProntuarioDao.excluirProntuario(prontuarioHolder, estiloDeVida, exameFisico, anamnese, listaProblemases, LogProntuarioActivity.getContext());
            Toast.makeText(LogProntuarioActivity.getContext(), "Log foi excluído com sucesso!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LogProntuarioActivity.getContext(), MenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            LogProntuarioActivity.getContext().startActivity(intent);

            /*AlertDialog.Builder alert = new AlertDialog.Builder(LogProntuarioActivity.getContext());

            alert.setTitle("Excluir");
            alert.setMessage("Deseja excluir este registro?");

            alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                }
            });

            alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    // Canceled.
                }
            });

            alert.show();*/


        }


    }

}
