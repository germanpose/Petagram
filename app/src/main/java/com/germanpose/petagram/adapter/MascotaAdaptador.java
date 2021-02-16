package com.germanpose.petagram.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.germanpose.petagram.db.ConstructorMascotas;
import com.germanpose.petagram.pojo.Mascota;
import com.germanpose.petagram.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotasViewHolder> {

    ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);

        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvCont.setText(String.valueOf(mascota.getLikes()));

        /* Esta parte del codigo comentada sirve para obtener un dato de el item mostrado y seleccionado en el RecyclerView,
        en este caso obtengo el nombre y se imprime en consola. */

        holder.btn_likes.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //System.out.println("Prueba OnClick " + holder.tvNombre.getText().toString());

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                holder.tvCont.setText(String.valueOf(constructorMascotas.obtenerLikesMascotas(mascota)));

                Toast.makeText(activity, "Diste like a " + holder.tvNombre.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }



    @Override
    public int getItemCount() {
        return mascotas.size();
    }



    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvCont;
        private ImageButton btn_likes;
        CardView cardView_mascotas;


        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCont = itemView.findViewById(R.id.tv_cont);
            cardView_mascotas = itemView.findViewById(R.id.cardview_mascotas);
            btn_likes = itemView.findViewById(R.id.imgBtnLike);
        }
    }

}
