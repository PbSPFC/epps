package br.uninove.primeiraconsulta.activity.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.PrimeiraConsulta;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    Usuario usuarioSessao = SessaoUsuario.getUsuarioSessao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        System.out.println(SessaoUsuario.getUsuarioSessao().getNome() + " Conectou-se");

        tvRA.setText(usuarioSessao.getRa());
        tvStatus.setText(usuarioSessao.getStatus().getStatus());
        tvNome.setText(usuarioSessao.getNome());
    }



    @OnClick(R.id.bt_menu_sair)
    public void sair(){
        SessaoUsuario.setUsuarioSessao(new Usuario());
        System.out.println(SessaoUsuario.getUsuarioSessao().getNome() + " Saiu");
        Intent intent = new Intent(this, PrimeiraConsulta.class);
        startActivity(intent);
        finish();
    }

}
