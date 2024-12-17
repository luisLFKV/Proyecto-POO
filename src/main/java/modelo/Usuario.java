package main.java.modelo;

public class Usuario extends Persona {
    private int id;
    private int lvlPriv;
    private String rol;
    private String turno;
    private String password;

    //Constructor
    public Usuario() {
        //super();
    }
    public Usuario(int id, int lvlPriv, String rol, String turno, String nombre, String apellidoP, String apellidoM, String password) {    
        super(nombre, apellidoP, apellidoM);
        this.id = id;
        this.lvlPriv = lvlPriv;
        this.rol = rol;
        this.turno = turno;
        this.password = password;
    }

    //metodos setter
    public void setId(int id) {
        this.id = id;
    }
    public void setPrivilegio(int lvlPriv) {
        this.lvlPriv = lvlPriv;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    //metodos getter
    public int getId() {
        return id;
    }
    public int getPrivilegio() {
        return lvlPriv;
    }
    
    public String getRol() {
        return rol;
    }
    public String getTurno() {
        return turno;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Nombre: "+getNombres()+" "+getApellidoP()+" "+getApellidoM()+"\nId: "+getId()+"\nTurno: "+getTurno()+"\nRol: "+getRol()+"\nNivel de privilegios: "+getPrivilegio();
    }
}
