package Modelo;

public class Usuario {
    private int id;
    private String nombre;
    private int privilegio;
    private String rol;
    private String turno;

    public void setId(int id) {
        this.id = id;
    }
    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
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
        return privilegio;
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
