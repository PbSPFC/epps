package br.uninove.primeiraconsulta.activity.prontuario.Adapter;

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.ListaProblemasUtil;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by PB on 21/11/2016.
 */

public class NovoListaProblemasAdapter  extends ArrayAdapter<ListaProblemas> {

    public NovoListaProblemasAdapter(Context context, List<ListaProblemas> listaProblemasList) {
        super(context, R.layout.list_novo_lista_problemas, listaProblemasList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final VierHolder holder;

        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.list_novo_lista_problemas, null);
            holder = new VierHolder();
            ButterKnife.bind(holder, convertView);

            convertView.setTag(holder);
        } else {
            holder = (VierHolder) convertView.getTag();
        }

        final ListaProblemas listaProblemas = getItem(position);
        holder.listaProblemasHolder = listaProblemas;
        if(listaProblemas!=null) {
            holder.edDescricao.setText(listaProblemas.getDescricao().toString());
            holder.edAcao.setText(listaProblemas.getAcao().toString());
        }

        holder.edDescricao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    final int position = view.getId();
                    final EditText edDescricao = (EditText) view;
                    ListaProblemasUtil.listaDeProblemas.get(position).setDescricao(edDescricao.getText().toString());
                    System.out.print("Descrição: " + ListaProblemasUtil.listaDeProblemas.get(position).getDescricao());
                }
            }
        });

        holder.edAcao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    final int position = view.getId();
                    final EditText edAcao = (EditText) view;
                    ListaProblemasUtil.listaDeProblemas.get(position).setAcao(edAcao.getText().toString());
                    System.out.print("Ação: " + ListaProblemasUtil.listaDeProblemas.get(position).getAcao());
                }
            }
        });

        return convertView;
    }

    class VierHolder{
        public ListaProblemas listaProblemasHolder;

        @Bind(R.id.ed_novo_descricao)
        EditText edDescricao;
        @Bind(R.id.ed_novo_acao)
        EditText edAcao;

    }
}
