package gestioncuentas;

public class GastoException extends Exception {

    // Declaramos una variable para almacenar el mensaje de error
    private String error="";
    public GastoException() {
        // Construimos la excepción.
        this.error="No se puede agregar el gasto ya que el saldo es menor que "
                + "el importe del gasto, o su saldo es cero euros.";
    }
    
    // Sobreescribimos el metodo getMessage
    @Override
    public String getMessage(){
        return error;
    }    
}