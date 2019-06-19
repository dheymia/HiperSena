package senac.hipersena;

import android.content.Intent;
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

import senac.hipersena.models.Sorte;

public class MainActivity extends AppCompatActivity {

    EditText jogadas;
    EditText casas;
    public static Sorte sorte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        jogadas = findViewById(R.id.txtJogadas);
        casas = findViewById(R.id.txtCasas);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int jogadasInt = Integer.parseInt(jogadas.getText().toString());
                    int casasInt = Integer.parseInt(casas.getText().toString());

                    sorte = new Sorte(jogadasInt, casasInt);
                    sorte.gerarApostas();

                    Intent telaJogadas = new Intent(getBaseContext(), Jogadas.class);
                    telaJogadas.putExtra("jogadas", jogadasInt);
                    telaJogadas.putExtra("casas", casasInt);
                    startActivity(telaJogadas);
                } catch (Exception ex) {
                    Log.e("Onclick Gerar Apostas", ex.getMessage());
                    Snackbar.make(view, ex.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onResume() {
        try {
            if (sorte != null) {
                jogadas.setText(String.valueOf(sorte.getJogadas()));
                casas.setText(String.valueOf(sorte.getCasas()));
            }
        } catch (Exception ex){
            Log.e("onResume", ex.toString());
        }

        super.onResume();
    }
}
