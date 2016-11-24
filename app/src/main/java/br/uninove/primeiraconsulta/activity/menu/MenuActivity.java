package br.uninove.primeiraconsulta.activity.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
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

    TabHost tabHost;

    @Bind(R.id.tv_menu_ra)
    TextView tvRA;

    @Bind(R.id.tv_menu_status)
    TextView tvStatus;

    @Bind(R.id.tv_menu_nome)
    TextView tvNome;

    @Bind(R.id.tv_menu_email)
    TextView tvEmail;


    Usuario usuarioSessao = SessaoUsuario.getUsuarioSessao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        tabHost = (TabHost)findViewById(R.id.tab_menu);
        tabHost.setup();

        TabHost.TabSpec specMenu = tabHost.newTabSpec("Menu");
        specMenu.setContent(R.id.tab_menu_menu);
        specMenu.setIndicator("Menu");

        TabHost.TabSpec specColaboradores = tabHost.newTabSpec("Colaboradores");
        specColaboradores.setContent(R.id.tab_menu_colaboradores);
        specColaboradores.setIndicator("Colaboradores");

        TabHost.TabSpec specDesenvolvedores = tabHost.newTabSpec("Desenvolvedores");
        specDesenvolvedores.setContent(R.id.tab_menu_desenvolvedores);
        specDesenvolvedores.setIndicator("Desenvolvedores");

        tabHost.addTab(specMenu);
        tabHost.addTab(specColaboradores);
        tabHost.addTab(specDesenvolvedores);

        tvRA.setText(usuarioSessao.getRa());
        tvStatus.setText(usuarioSessao.getStatus().getStatus());
        tvNome.setText(usuarioSessao.getNome());
        tvEmail.setText(usuarioSessao.getEmail());
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
