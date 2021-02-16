package com.germanpose.petagram.pojo;

public class PostMiPerfil {

    String likes;
    int foto;

    public PostMiPerfil(String likes, int foto) {
        this.likes = likes;
        this.foto = foto;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
