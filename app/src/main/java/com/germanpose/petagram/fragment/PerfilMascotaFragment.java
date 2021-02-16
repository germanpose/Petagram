package com.germanpose.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.germanpose.petagram.R;
import com.germanpose.petagram.adapter.PerfilAdaptador;
import com.germanpose.petagram.pojo.PostMiPerfil;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {

    ArrayList<PostMiPerfil> postMiPerfil;
    private RecyclerView mispost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.recyclerview_perfil, container, false);

        mispost = v.findViewById(R.id.rvPerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
         */
        mispost.setLayoutManager(glm);

        CargarPosts();
        IniciarAdaptador();

        return v;
    }

    public void CargarPosts(){

        postMiPerfil = new ArrayList<PostMiPerfil>();

        postMiPerfil.add(new PostMiPerfil("10", R.drawable.post1));
        postMiPerfil.add(new PostMiPerfil("8", R.drawable.post2));
        postMiPerfil.add(new PostMiPerfil("13", R.drawable.post3));
        postMiPerfil.add(new PostMiPerfil("18", R.drawable.post4));
        postMiPerfil.add(new PostMiPerfil("7", R.drawable.post5));
        postMiPerfil.add(new PostMiPerfil("27", R.drawable.post6));
        postMiPerfil.add(new PostMiPerfil("22", R.drawable.post7));
        postMiPerfil.add(new PostMiPerfil("25", R.drawable.post8));
        postMiPerfil.add(new PostMiPerfil("9", R.drawable.post9));
        postMiPerfil.add(new PostMiPerfil("17", R.drawable.post10));
        postMiPerfil.add(new PostMiPerfil("14", R.drawable.post11));
        postMiPerfil.add(new PostMiPerfil("48", R.drawable.post13));
        postMiPerfil.add(new PostMiPerfil("31", R.drawable.post14));
        postMiPerfil.add(new PostMiPerfil("32", R.drawable.post15));


    }

    public void IniciarAdaptador(){

        PerfilAdaptador adaptador = new PerfilAdaptador(postMiPerfil);
        mispost.setAdapter(adaptador);

    }

}
