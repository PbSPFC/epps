package br.uninove.primeiraconsulta.activity.prontuario;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.prontuario.Adapter.ProntuarioListAdapter;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.database.DataBase;
import br.uninove.primeiraconsulta.database.DbProntuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckListaProntuario;
import br.uninove.primeiraconsulta.util.DbFactory;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class ListarProntuariosActivity extends AppCompatActivity{

    @Bind(R.id.lv_listar_lista)
    ListView listViewProntuario;

    Usuario usuarioSessao = SessaoUsuario.getUsuarioSessao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_prontuarios);
        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizar();
    }

    private void atualizar() {
        ProntuarioListAdapter adapter = new ProntuarioListAdapter(this, CheckListaProntuario.checkProntuarioUsuarioId(usuarioSessao.getId(),this));
        listViewProntuario.setAdapter(adapter);
    }

    @OnClick(R.id.bt_listar_voltar)
    public void voltar(){
        finish();
    }
}
