package br.uninove.primeiraconsulta.activity.prontuario.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.entidade.Rastreamento;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by PB on 22/11/2016.
 */

public class RastreamentoTextoAdapter extends ArrayAdapter<Rastreamento>{

    public RastreamentoTextoAdapter(Context context, List<Rastreamento> rastreamentoLista) {
        super(context, R.layout.list_rastreamento_texto, rastreamentoLista);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.list_rastreamento_texto, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Rastreamento rastreamento = getItem(position);
        if(rastreamento!=null) {
            holder.tvTitulo.setText(rastreamento.getTitulo());
            holder.tvTexto.setText(rastreamento.getTexto());
        }
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.tv_rastreamento_titulo)
        TextView tvTitulo;
        @Bind(R.id.tv_rastreamento_texto)
        TextView tvTexto;
    }

}
