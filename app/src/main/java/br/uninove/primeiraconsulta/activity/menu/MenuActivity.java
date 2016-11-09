package br.uninove.primeiraconsulta.activity.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.entidade.Usuario;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by PB on 08/11/2016.
 */

public class MenuActivity extends AppCompatActivity{


    @Bind(R.id.tv_menu_ra)
    TextView tvRA;

    @Bind(R.id.tv_menu_status)
    TextView tvStatus;

    @Bind(R.id.tv_menu_nome)
    TextView tvNome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Usuario usuarioSessao = (Usuario) bundle.get("usuarioSessao");

        tvRA.setText(usuarioSessao.getRa());
        tvStatus.setText(usuarioSessao.getStatus().getStatus());
        tvNome.setText(usuarioSessao.getNome());
    }
}
