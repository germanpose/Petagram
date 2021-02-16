package com.germanpose.petagram.presentador;

import android.content.Context;

import com.germanpose.petagram.Formulario_Contacto;
import com.germanpose.petagram.adapter.MascotaAdaptador;
import com.germanpose.petagram.db.ConstructorMascotas;
import com.germanpose.petagram.fragment.IReyclerViewFragmentView;
import com.germanpose.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IReyclerViewFragmentView iReyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IReyclerViewFragmentView iReyclerViewFragmentView, Context context) {
        this.iReyclerViewFragmentView = iReyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {

        iReyclerViewFragmentView.inicializarAdaptadorRV(iReyclerViewFragmentView.crearAdaptador(mascotas));
        iReyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
