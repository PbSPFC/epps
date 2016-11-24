package br.uninove.primeiraconsulta.activity.prontuario.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Rastreamento;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by PB on 22/11/2016.
 */

public class RastreamentoAdapter extends ArrayAdapter<Rastreamento> {

    public RastreamentoAdapter(Context context, List<Rastreamento> rastreamentoLista) {
        super(context, R.layout.list_rastreamento, rastreamentoLista);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.list_rastreamento, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Rastreamento rastreamento = getItem(position);
        if(rastreamento!=null) {
            holder.tvR.setText(rastreamento.getNivel());
            holder.tvRastreamento.setText(rastreamento.getRastreamento());
        }
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.tv_rastreamento_r)
        TextView tvR;
        @Bind(R.id.tv_rastreamento_ratreamento)
        TextView tvRastreamento;
    }

}
