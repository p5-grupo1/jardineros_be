package com.solucionesverdes.postbems.models;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Posts {
        @Id
        private String  idPost;
        private String  username;
        private String  descripcionServicio;
        private String  imagen;
        private String  ciudad;
        private Integer precio;
        private String  area;
        private Date fechaPublicacion;

        public Posts(String idPost, String username, String descripcionServicio,String imagen, String ciudad,
                     Integer precio, String area, Date fechaPublicacion){
            this.idPost = idPost;
            this.username = username;
            this.descripcionServicio = descripcionServicio;
            this.imagen = imagen;
            this.ciudad = ciudad;
            this.precio =precio;
            this.area = area;
            this.fechaPublicacion = fechaPublicacion;
        }

    public String getIdPost() {
        return idPost;
    }

    public  String getUsername(){ return  username; }

    public  void setUsername(String username){ this.username = username; }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getImagen(){
            return  imagen;
    }

    public void setImagen (String imagen){
            this.imagen = imagen;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String idArea) {
        this.area = area;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) { this.fechaPublicacion = fechaPublicacion;           }
}

