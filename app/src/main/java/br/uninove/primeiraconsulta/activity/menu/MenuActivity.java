package br.uninove.primeiraconsulta.activity.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.PrimeiraConsulta;
import br.uninove.primeiraconsulta.activity.cadastro.CadastroUsuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.ListarProntuariosActivity;
import br.uninove.primeiraconsulta.activity.prontuario.NovoProntuarioActivity;
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

    @OnClick(R.id.bt_menu_cadastrar)
    public void btCadastro(){
        if(usuarioSessao.getStatus().getId() == 2){
            Toast.makeText(this, "Você não tem permissão para cadastrar usuários!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, CadastroUsuarioActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.bt_menu_novo_prontuario)
    public void novoProntuario(){
        Intent intent = new Intent(this, NovoProntuarioActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.bt_menu_listar_prontuarios)
    public void listaDeProntuarios(){
        Intent intent = new Intent(this, ListarProntuariosActivity.class);
        startActivity(intent);
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
