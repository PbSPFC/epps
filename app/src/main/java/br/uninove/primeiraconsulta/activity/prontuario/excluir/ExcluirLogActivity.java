package br.uninove.primeiraconsulta.activity.prontuario.excluir;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.uninove.primeiraconsulta.R;
import br.uninove.primeiraconsulta.activity.menu.MenuActivity;
import br.uninove.primeiraconsulta.activity.prontuario.EditarProntuarioActivity;
import br.uninove.primeiraconsulta.activity.prontuario.LogProntuarioActivity;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.util.SessaoUsuario;

/**
 * Created by PB on 28/11/2016.
 */

public class ExcluirLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_log);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            final Prontuario prontuario = (Prontuario) bundle.get("prontuario");
            final EstiloDeVida estiloDeVida = (EstiloDeVida) bundle.get("estiloDeVida");
            final ExameFisico exameFisico = (ExameFisico) bundle.get("exameFisico");
            final Anamnese anamnese = (Anamnese) bundle.get("anamnese");
            final List<ListaProblemas> listaProblemas = (List<ListaProblemas>) bundle.get("listaProblemas");


            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Deseja realmente excluir este Log?");
            alert.setMessage("Digite sua senha para excluir o prontuário.");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            alert.setView(input);

            alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                    if (input.getText().toString().equals(SessaoUsuario.getUsuarioSessao().getSenha())
                            || input.getText().toString().equals(SessaoUsuario.getSenha())) {

                        LogProntuarioDao.excluirProntuario(prontuario, estiloDeVida, exameFisico, anamnese, listaProblemas, ExcluirLogActivity.this);
                        Toast.makeText(ExcluirLogActivity.this, "Log foi excluído com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LogProntuarioActivity.getContext(), MenuActivity.class);
                        ExcluirLogActivity.this.startActivity(intent);
                    } else {
                        Toast.makeText(ExcluirLogActivity.this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }
            });

            alert.setNegativeButton("não", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    finish();
                }
            });

            alert.show();
        }

    }

}
