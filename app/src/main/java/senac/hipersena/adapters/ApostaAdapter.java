package senac.hipersena.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import senac.hipersena.R;
import senac.hipersena.models.Aposta;

public class ApostaAdapter extends RecyclerView.Adapter {

    private List<Aposta> apostas;
    private Context context;

    public ApostaAdapter(List<Aposta> apostas, Context context) {
        this.apostas = apostas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_jogada, viewGroup, false);

        ApostaViewHolder holder = new ApostaViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ApostaViewHolder holder = (ApostaViewHolder) viewHolder;

        Aposta aposta = apostas.get(i);

        holder.conteudo.setText(aposta.getConteudo());
    }

    @Override
    public int getItemCount() {
        return apostas.size();
    }
}
