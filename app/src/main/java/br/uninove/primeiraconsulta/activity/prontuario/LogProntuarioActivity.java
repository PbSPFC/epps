package br.uninove.primeiraconsulta.activity.prontuario;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.prontuario.Adapter.LogProntuarioAdapter;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.CheckListaProntuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by PB on 23/11/2016.
 */

public class LogProntuarioActivity extends AppCompatActivity{

    private static Context context;
    public static Context getContext(){
        return LogProntuarioActivity.context;
    }

    @Bind(R.id.lv_listar_log)
    ListView lvLog;

    @Bind(R.id.tv_log_num_prontuario)
    TextView tvNumProntuario;

    private static Prontuario prontuario;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogProntuarioActivity.context = getApplicationContext();
        setContentView(R.layout.activity_listar_historico);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            prontuario = (Prontuario) bundle.get("prontuario");

            tvNumProntuario.setText(prontuario.getNumProntuario());
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizar();
    }

    private void atualizar() {
        LogProntuarioAdapter adapter = new LogProntuarioAdapter(this, CheckListaProntuario.checkProntuarioNumProntuario(prontuario.getNumProntuario(),this));
        lvLog.setAdapter(adapter);
    }

    @OnClick(R.id.bt_log_voltar)
    public void voltar(){
        finish();
    }


}
