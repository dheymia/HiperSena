package senac.hipersena;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import senac.hipersena.adapters.ApostaAdapter;

public class Jogadas extends AppCompatActivity {

    RecyclerView ListaJogadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListaJogadas = findViewById(R.id.ListaJogadas);
        ListaJogadas.setAdapter(new ApostaAdapter(MainActivity.sorte.getApostas(), this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                GridLayoutManager.VERTICAL, false);

        ListaJogadas.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ListaJogadas.setLayoutManager(layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
