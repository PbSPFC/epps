package br.uninove.primeiraconsulta.activity.prontuario.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.activity.prontuario.LogProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.VerProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.excluir.ExcluirLogActivity;
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

        try {
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
            if (prontuario != null) {
                holder.dataEdicao.setText(prontuario.getDataEdicao());
            }
            return convertView;
        }catch (Exception e){
            Log.e("log adapter", e.getMessage());
        }
        return convertView;
    }

    class ViewHolder {

        public Prontuario prontuarioHolder;

        @Bind(R.id.tv_log_data_edicao)
        TextView dataEdicao;

        @OnClick(R.id.bt_log_ver)
        public void btVer(){
            try {
                EstiloDeVida estiloDeVida = LogEstiloDeVidaDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
                ExameFisico exameFisico = LogExameFisicoDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
                Anamnese anamnese = LogAnamneseDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
                List<ListaProblemas> listaProblemas = LogListaProblemasDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());

                Intent intent = new Intent(LogProntuarioActivity.getContext(), VerProntuarioActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("prontuario", prontuarioHolder);
                intent.putExtra("estiloDeVida", estiloDeVida);
                intent.putExtra("exameFisico", exameFisico);
                intent.putExtra("anamnese", anamnese);
                intent.putExtra("listaProblemas", (Serializable) listaProblemas);
                LogProntuarioActivity.getContext().startActivity(intent);
            }catch (Exception e){
                Log.e("log adapter", e.getMessage());
                Toast.makeText(LogProntuarioActivity.getContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
            }
        }

        @OnClick(R.id.bt_log_excluir)
        public void btExcluir(){
            try {
                EstiloDeVida estiloDeVida = LogEstiloDeVidaDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
                ExameFisico exameFisico = LogExameFisicoDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
                Anamnese anamnese = LogAnamneseDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());
                List<ListaProblemas> listaProblemas = LogListaProblemasDao.buscarPorNumProntuario(prontuarioHolder, LogProntuarioActivity.getContext());

                Intent intent = new Intent(LogProntuarioActivity.getContext(), ExcluirLogActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("prontuario", prontuarioHolder);
                intent.putExtra("estiloDeVida", estiloDeVida);
                intent.putExtra("exameFisico", exameFisico);
                intent.putExtra("anamnese", anamnese);
                intent.putExtra("listaProblemas", (Serializable) listaProblemas);
                LogProntuarioActivity.getContext().startActivity(intent);
            }catch (Exception e){
                Log.e("log excluir", e.getMessage());
                Toast.makeText(LogProntuarioActivity.getContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
            }




        }


    }

}
