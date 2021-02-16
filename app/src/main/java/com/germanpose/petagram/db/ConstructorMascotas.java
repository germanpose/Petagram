package com.germanpose.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.germanpose.petagram.R;
import com.germanpose.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final Integer LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {

        /*ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Rocky","3", R.drawable.perrito1));
        mascotas.add(new Mascota("Lola", "5",R.drawable.perrito2));
        mascotas.add(new Mascota("Coco", "2",R.drawable.perrito3));
        mascotas.add(new Mascota("Thor", "4",R.drawable.perrito4));
        mascotas.add(new Mascota("Toby", "6",R.drawable.perrito5));

        return mascotas; */

        BaseDatos db = new BaseDatos(context);
        insertarMascota(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascota(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Rocky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Lola");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Coco");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito3);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Thor");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito4);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Toby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perrito5);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUM, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascotas(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

}
