package com.germanpose.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = findViewById(R.id.recyclerview_mascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        cargadoMascotas();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.btnStar:

                Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                startActivity(intent);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public  void cargadoMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Rocky","3",R.drawable.perrito1));
        mascotas.add(new Mascota("Lola", "5",R.drawable.perrito2));
        mascotas.add(new Mascota("Coco", "2",R.drawable.perrito3));
        mascotas.add(new Mascota("Thor", "4",R.drawable.perrito4));
        mascotas.add(new Mascota("Toby", "6",R.drawable.perrito5));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

}