package com.germanpose.petagram.adapter;

import android.graphics.PostProcessor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.germanpose.petagram.R;
import com.germanpose.petagram.pojo.Mascota;
import com.germanpose.petagram.pojo.PostMiPerfil;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<PostMiPerfil> post;

    public PerfilAdaptador(ArrayList<PostMiPerfil> post){
        this.post = post;
    }


    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);

        return new PerfilAdaptador.PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder holder, int position) {

        PostMiPerfil postMiPerfil = post.get(position);
        holder.imgFoto.setImageResource(postMiPerfil.getFoto());
        holder.tvContLikes.setText(postMiPerfil.getLikes());


    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvContLikes;
        private ImageButton btnLike;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvContLikes = itemView.findViewById(R.id.tvLikes);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }

}
