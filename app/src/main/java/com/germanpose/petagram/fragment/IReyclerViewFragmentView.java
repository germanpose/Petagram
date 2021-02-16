package com.germanpose.petagram.fragment;

import com.germanpose.petagram.Formulario_Contacto;
import com.germanpose.petagram.adapter.MascotaAdaptador;
import com.germanpose.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IReyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
