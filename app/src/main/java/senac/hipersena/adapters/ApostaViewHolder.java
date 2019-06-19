package senac.hipersena.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import senac.hipersena.R;

public class ApostaViewHolder extends RecyclerView.ViewHolder {

    final TextView conteudo;

    public ApostaViewHolder(@NonNull View itemView) {
        super(itemView);
        conteudo = itemView.findViewById(R.id.txtConteudoJogada);
    }
}
