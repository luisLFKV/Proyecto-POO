package Modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String rol;
    private String turno;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public String getRol() {
        return rol;
    }
    public String getTurno() {
        return turno;
    }
}
