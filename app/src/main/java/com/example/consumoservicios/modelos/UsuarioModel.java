package com.example.consumoservicios.modelos;
import com.google.gson.annotations.SerializedName;

public class UsuarioModel {

    @SerializedName("UsuCve")
    private String usuCve;

    @SerializedName("UsuId")
    private int usuId;

    @SerializedName("UsuNomUsu")
    private String usuNomUsu;

    /**
     * No args constructor for use in serialization
     *
     */
    public UsuarioModel() {
    }

    /**
     *
     * @param usuCve
     * @param usuId
     * @param usuNomUsu
     */
    public UsuarioModel(String usuCve, int usuId, String usuNomUsu) {
        super();
        this.usuCve = usuCve;
        this.usuId = usuId;
        this.usuNomUsu = usuNomUsu;
    }

    public String getUsuCve() {
        return usuCve;
    }

    public void setUsuCve(String usuCve) {
        this.usuCve = usuCve;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getUsuNomUsu() {
        return usuNomUsu;
    }

    public void setUsuNomUsu(String usuNomUsu) {
        this.usuNomUsu = usuNomUsu;
    }
}
