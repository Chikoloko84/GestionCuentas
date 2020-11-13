package gestioncuentas;

public class Usuario {
    String nombre;
    String dni;
    int edad;

    // Metodo constructor para dar un estado inicial al objeto Usuario.
    public Usuario() { 
        this.nombre="";
        this.dni="";
        this.edad=0;
    }

    // Metodos setter (establecen valores)
    public void setNombre(String nombre) { // Establece el nombre
        this.nombre = nombre;
    }
    
    public void setEdad(int edad) { // Establece la edad
        this.edad = edad;
    }
    
    public void setDni(String dni) { // Establece el DNI
        this.dni = dni;
    }
    
    // Este metodo es getter (devuelve un valor) pero
    // también es un setter (establece un valor)
    // Este método comprueba si el DNI es correcto.
    public boolean setDNI(String dni){
        
        if(dni.matches("^[0-9]{8}[a-zA-Z]$")
                || dni.matches("^[0-9]{8}[-][a-zA-Z]$")){
            this.dni=dni;
            return true;
        }
        else{
            return false;
        }      
    }

    // Métodos getter (devuelven un valor).
    public String getNombre() { // Devuelve el nombre
        return nombre;
    }

    public String getDni() { // Devuelve el DNI
        return dni;
    }

    public int getEdad() { // Devuelve la edad
        return edad;
    }

    // Metodo sobreescrito toString
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ".\n" +
                "DNI: " + this.dni + ".\n" +
                "Edad: " + this.edad + ".";
    }
}