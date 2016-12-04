package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.prontuario.adapter.ProntuarioListAdapter;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckListaProntuario;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PB on 09/11/2016.
 */

public class ListarProntuariosActivity extends AppCompatActivity{

    private static Context context;
    public static Context getContext(){
        return ListarProntuariosActivity.context;
    }


    @Bind(R.id.tvProntuarios)
    TextView tvProntuarios;
    @Bind(R.id.lv_listar_lista)
    ListView listViewProntuario;

    Usuario usuarioSessao = SessaoUsuario.getUsuarioSessao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListarProntuariosActivity.context = getApplicationContext();
        setContentView(R.layout.activity_listar_prontuarios);
        ButterKnife.bind(this);
        try {
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/blacksword.otf");
            tvProntuarios.setTypeface(font);
        }catch (Exception e){

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizar();
    }

    private void atualizar() {
        try {
            ProntuarioListAdapter adapter = new ProntuarioListAdapter(this, CheckListaProntuario.checkProntuarioUsuarioId(usuarioSessao.getId(), this));
            listViewProntuario.setAdapter(adapter);
        }catch (Exception e){
            Log.e("list view prontuario", e.getMessage());
            Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.bt_listar_voltar)
    public void voltar(){
        finish();
    }
}
