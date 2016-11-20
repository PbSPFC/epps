package br.uninove.primeiraconsulta.activity.prontuario.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 10/11/2016.
 */

public class ProntuarioListAdapter extends ArrayAdapter<Prontuario> {

    public ProntuarioListAdapter(Context context, List<Prontuario> prontuarioLista) {
        super(context, R.layout.list_listar_prontuarios, prontuarioLista);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.list_listar_prontuarios, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Prontuario prontuario = getItem(position);
        holder.prontuarioHolder = prontuario;
        if(prontuario!=null) {
            holder.numProntuario.setText(prontuario.getNumProntuario());
        }
        return convertView;
    }


}
