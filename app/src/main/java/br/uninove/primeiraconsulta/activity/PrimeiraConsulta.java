package br.uninove.primeiraconsulta.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.activity.prontuario.ListarProntuariosActivity;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.util.CheckLogin;
import br.uninove.primeiraconsulta.util.SessaoUsuario;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrimeiraConsulta extends AppCompatActivity {

    @Bind(R.id.tv_primeira_consulta)
    TextView tvPrimeiraConsulta;
    @Bind(R.id.ed_ra)
    EditText edRA;
    @Bind(R.id.ed_senha)
    EditText edSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        try {
            Typeface font = Typeface.createFromAsset(getAssets(), "fonts/blacksword.otf");
            tvPrimeiraConsulta.setTypeface(font);
        }catch (Exception e){

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_primeira_consulta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.bt_login)
    public void conectar(){
        try {
            String ra = edRA.getText().toString();
            String senha = edSenha.getText().toString();

            Usuario usuario = CheckLogin.checklogin(ra, senha, this);

            if (usuario != null) {
                Intent intent = new Intent(this, MenuActivity.class);
                SessaoUsuario.setUsuarioSessao(usuario);
                SessaoUsuario.setSenha(senha);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "CRM/RA ou senha inválidas", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("login", e.getMessage());
            Toast.makeText(this, "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }
}
