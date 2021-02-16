package com.germanpose.petagram.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.germanpose.petagram.Formulario_Contacto;
import com.germanpose.petagram.MainActivity;
import com.germanpose.petagram.R;
import com.germanpose.petagram.adapter.MascotaAdaptador;
import com.germanpose.petagram.pojo.Mascota;
import com.germanpose.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.germanpose.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IReyclerViewFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = v.findViewById(R.id.recyclerview_mascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    /*public  void cargadoMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Rocky","3",R.drawable.perrito1));
        mascotas.add(new Mascota("Lola", "5",R.drawable.perrito2));
        mascotas.add(new Mascota("Coco", "2",R.drawable.perrito3));
        mascotas.add(new Mascota("Thor", "4",R.drawable.perrito4));
        mascotas.add(new Mascota("Toby", "6",R.drawable.perrito5));
    }
*/

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
