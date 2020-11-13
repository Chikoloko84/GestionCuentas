package gestioncuentas;

import java.util.*;

public class Cuenta {

    private double saldo; // Saldo de la cuenta
    private Usuario usuarioCuenta; // Usuario propietario de la cuenta
    private List<Gasto> gastos; // Lista de gastos
    private List<Ingreso>ingresos; // Lista de ingresos

    // Contructor del objeto cuenta. Le da un estado iniciar a la cuenta.
    public Cuenta(Usuario usuarioCuenta) {
        this.usuarioCuenta=usuarioCuenta;
        this.saldo=0;
        this.gastos=new ArrayList<Gasto>();
        this.ingresos=new ArrayList<Ingreso>();
    }

    // Establece el usuario de la cuenta
    public void setUsuarioCuenta(Usuario usuarioCuenta) {
        this.usuarioCuenta = usuarioCuenta;
    }

    // Establece el saldo de la cuenta.
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // Devuelve el saldo de la cuenta
    public double getSaldo() {
        return saldo;
    }
    
    // Devuelve el usuario de la cuenta
    public Usuario getUsuarioCuenta() {
        return usuarioCuenta;
    }
    
    // Devuelve la lista de gastos
    public List<Gasto> getGastos() {
        return gastos;
    }
    
    // Devuelve la lista de ingresos
    public List<Ingreso> getIngresos() {
        return ingresos;
    }
    
    // Agrega un ingreso a la lista.
    public double addIngresos(String description, double cantidad){
        
        // Se crea el ingreso y se pasa el importe y la descripcion.
        Ingreso nuevoIngreso = new Ingreso(cantidad,description);
        // Se agrega el ingreso a la lista
        this.ingresos.add(nuevoIngreso);
        // Se suma el saldo
        this.saldo=this.saldo+cantidad;
        // se devuelve el saldo
        return saldo;
    }
    
    // Agrega un gasto a la lista
    public double addGastos(String description, double cantidad){
        
        try{ // Intentamos
            // Restar el saldo
            this.saldo = this.saldo-cantidad;
            
            if(this.getSaldo()<0){ // Si el saldo es menor que cero
                // Lanzamos la excepción personalizada
                throw new GastoException();
            }
            // Al lanzar la excepción se ejecuta el catch.
        }catch(GastoException e){
            // Devolvemos un -1
            return -1;
        }
        // Si no ejecuta el catch ejecutará lo siguiente
        // Creamos un nuevo gasto
        Gasto nuevoGasto=new Gasto(cantidad,description);
        // Lo agregamos a la lista de gastos
        gastos.add(nuevoGasto);
        // Devolvemos el saldo
        return saldo;
    }
    
    @Override
    public String toString(){
        return "Hola " + this.usuarioCuenta.getNombre() + ", el saldo de tu "
                + "cuenta es " + this.saldo;
    }
}