package br.uninove.primeiraconsulta.activity.prontuario.Adapter;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.activity.prontuario.EditarProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.ListarProntuariosActivity;
import br.uninove.primeiraconsulta.activity.prontuario.VerProntuarioActivity;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by PB on 10/11/2016.
 */

public class ViewHolder {

    public Prontuario prontuarioHolder;

    @Bind(R.id.tv_lista_num_prontuario)
    TextView numProntuario;

    @OnClick(R.id.bt_lista_ver)
    public void btVer(){
        Intent intent = new Intent(ListarProntuariosActivity.getContext(), VerProntuarioActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("prontuario", prontuarioHolder);
        ListarProntuariosActivity.getContext().startActivity(intent);
    }

    @OnClick(R.id.bt_lista_excluir)
    public void btExcluir(){
        EstiloDeVida estiloDeVida = EstiloDeVidaDao.buscarPorNumProntuario(prontuarioHolder, ListarProntuariosActivity.getContext());
        ExameFisico exameFisico = ExameFisicoDao.buscarPorNumProntuario(prontuarioHolder, ListarProntuariosActivity.getContext());

        ProntuarioDao.excluirProntuario(prontuarioHolder, estiloDeVida, exameFisico, ListarProntuariosActivity.getContext());
        Toast.makeText(ListarProntuariosActivity.getContext(), "Prontuario de N°" + prontuarioHolder.getNumProntuario() + "" +
                " foi excluído com sucesso!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ListarProntuariosActivity.getContext(), MenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ListarProntuariosActivity.getContext().startActivity(intent);
    }

    @OnClick(R.id.bt_lista_editar)
    public void btEditar(){
        Intent intent = new Intent(ListarProntuariosActivity.getContext(), EditarProntuarioActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("prontuario", prontuarioHolder);
        ListarProntuariosActivity.getContext().startActivity(intent);
    }

    @OnClick(R.id.bt_lista_email)
    public void btEmail(){
        Toast.makeText(ListarProntuariosActivity.getContext(), "Tela não foi implementada ainda, tente novamente no futuro."
                , Toast.LENGTH_SHORT).show();
    }

}
