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
        if(prontuario!=null) {
            holder.numProntuario.setText(prontuario.getNumProntuario());
            holder.nomePaciente.setText(prontuario.getNomePaciente());
            holder.btEditar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    System.out.print(prontuario.getNomeMedico());

                }
            });




        }
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.tv_lista_num_prontuario)
        TextView numProntuario;

        @Bind(R.id.tv_lista_paciente)
        TextView nomePaciente;

        @Bind(R.id.bt_lista_editar)
        Button btEditar;

        @Bind(R.id.bt_lista_ver)
        Button btVer;
    }


}
