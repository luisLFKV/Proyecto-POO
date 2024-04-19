package main.java.modelo;

public class Usuario {
    private int id;
    private String nombre;
    private int lvlPriv;
    private String rol;
    private String turno;

    public void setId(int id) {
        this.id = id;
    }
    public void setPrivilegio(int lvlPriv) {
        this.lvlPriv = lvlPriv;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public int getId() {
        return id;
    }
    public int getPrivilegio() {
        return lvlPriv;
    }
    public String getNombre() {
        return nombre;
    }
    public String getRol() {
        return rol;
    }
    public String getTurno() {
        return turno;
    }
}
