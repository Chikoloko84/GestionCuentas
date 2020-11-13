package gestioncuentas;

import java.util.Scanner;

public class GestionCuentas {

    // ------------VARIABLE PARA LEER DATOS INTRODUCIDOS -------------------//
    // Creamos una variable Scanner para leer datos por teclado
    private static final Scanner lectura = new Scanner(System.in);
    
    //********************************************************************//
    
    // ------------VARIABLE PARA LEER OPCIONES DEL MENÚ -------------------//
    /* Declaramos una variable de tipo String que almacenará la opción
    que elija el usuario en formato texto y le asignaremos un valor vacío
    ya que, si no lo hacemos así la variable no tendrá ningún valor,
    ni siquiera cero. */ 
    private static String opcion = "";
    
    /* Declaramos una variable de tipo byte para almacenar en formato numérico
    el valor que el usuario está introduciendo en formato texto*/
    private static byte numeroOpcion= -1;
    
    //********************************************************************//
    // --------------VARIABLES PARA LA CLASE USUARIO -------------------//
    /* Creamos una variable privada llamada nuevoUsuario.
    Esta variable almacenará objetos de tipo Usuario.
    Para ello usaremos la palabra reservada new */
    private static Usuario nuevoUsuario = new Usuario();
    
    // Declaramos una variable para almacenar el nombre del usuario
    private static String nombreUsuario="";
    
    // Declaramos una variable para almacenar la edad del usuario
    private static String edadUsu="";
    
    /* Declaramos una variable para almacenar la edad del usuario
    en un formato numérico*/
    private static byte edadUsuario=-1;
    
    // Declaramos una variable para almacenar el dni del usuario
    private static String dniUsuario="";
    
    /* Declaramos una variable para validar que el usuario creado es correcto
    La iniciamos en falso porque a estas alturas del programa todavia no
    se han pedido datos de usuario*/
    private static boolean usuarioCreado=false;
    
    //********************************************************************//
    // --------------VARIABLES PARA LA CLASE CUENTA -------------------//
    
    /* Declaramos una variable que va a almacenar un objeto de tipo Cuenta
    en una variable llamada nuevaCuenta. De momento le asignamos un valor null
    */
    private static Cuenta nuevaCuenta = null;
    
    /* Declaramos una variable de tipo texto (String)
    donde almacenaremos el importe del gasto o ingreso*/
    private static String importe="";
    
    /* Declaramos una variable de tipo double (decimal)
    donde almacenaremos el importe del gasto o ingreso
    convertido en formato numérico decimal tipo double*/
    private static double importeTotal=0;
    
    /* Declaramos una variable de tipo texto (String)
    donde almacenaremos el concepto del gasto o ingreso*/
    private static String descripcion="";
    
    //********************************************************************//
    // -------------- MÉTODOS O FUNCIONES NECESARIAS -------------------//
    
    // METODO QUE MUESTRA EL MENÚ DE OPCIONES, PIDE UNA OPCIÓN AL USUARIO
    // E INTENTA PASAR LA OPCION INTRODUCIDA EN TEXTO A FORMATO NUMÉRICO.
    private static void mostrarMenu(){
        
        do{
        System.out.println("1. Introducir un nuevo gasto");
        System.out.println("2. Introducir un nuevo ingreso");
        System.out.println("3. Mostrar gastos");
        System.out.println("4. Mostrar ingresos");
        System.out.println("5. Mostrar saldo de la cuenta");
        System.out.println("0. Salir");
        
        try{
        
            // Informamos al usuario que elija una opción.
            System.out.print("Introduce una opción del menú: ");

            // Leemos lo que el usuario ha introducido por teclado
            // y lo guardamos en la variable opción
            opcion = lectura.nextLine();
            
            /* Passamos el valor de tipo String a tipo byte. Esto lo hacemos
            para asegurarnos de que el usuario ha introducido un número
            y no un texto */
            numeroOpcion = Byte.parseByte(opcion);
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("La opción elegida debe ser un número "
                    + "entre 0 y 5");
        }
        }while(numeroOpcion<0 && numeroOpcion>5);
    }
    
    // METODO QUE PIDE LOS DATOS PARA CREAR UN USURIO
    private static void pedirDatosUsuario(){
        usuarioCreado=false;
        // Pedimos el nombre de usuario y repetimos la operación mientras que
        // el nombre del usuario tenga una cadena vacía.
        do{
            System.out.println("Introduce el nombre del usuario");
            nombreUsuario=lectura.nextLine().toUpperCase();
        }while(nombreUsuario.isEmpty());
        nuevoUsuario.setNombre(nombreUsuario);
        
        /* Pedimos la edad de usuario y repetimos la operación mientras que
        la edad del usuario (edadUsu) sea una cadena vacía, o mientras la
        edad del usuario en formato numérico sea mayor que cero*/
        do{
            System.out.println("Introduce la edad del usuario");
            edadUsu=lectura.nextLine();
            // Intentamos pasar la edad del usuario a formato numérico
            try{
                edadUsuario = Byte.parseByte(edadUsu);
                nuevoUsuario.setEdad(edadUsuario);
            }catch(NumberFormatException e){
                System.out.println("La edad debe numérica y mayor que cero");
            }
        }while(edadUsu.isEmpty() || edadUsuario<=0);
        
        
        /* Pedimos el DNI del usuario y repetimos la operación mientras que
        la variable dniUsuario tenga una cadena vacía o siempre que el
        metodo setDNI de tipo booleano devuelva falso*/
        do{
            System.out.println("Introduce el DNI del usuario");
            dniUsuario=lectura.nextLine().toUpperCase();
            
            /* Si el valor es correcto se establece el valor del DNI
            a la variable dni de la clase (objeto) Usuario*/
            if(nuevoUsuario.setDNI(dniUsuario)){
                nuevoUsuario.setDNI(dniUsuario);
            }
            else{
                System.out.println("El DNI introducido no es correcto."
                        + "Vuelva a introducir el DNI");
            }
        }while(dniUsuario.isEmpty() || nuevoUsuario.setDNI(dniUsuario)==false);
        
        // Si todo está correcto, validamos el usuario
        usuarioCreado=true;
    }
    
    /* METODO QUE NOS PERMITIRÁ INTRODUCIR INGRESOS EN LA CUELTA*/
    private static void introducirIngresos(){
        
        // Reiniciamos las variables por si tuvieran algún valor.
        importe="";
        descripcion="";
        importeTotal=0;
        
        // Pedimos la descripción del ingreso
        do{
            System.out.print("Introduce el concepto del ingreso: ");
            descripcion = lectura.nextLine();
            
        }while(descripcion.isEmpty());
        
        // Pedimos la el importe del ingreso
        do{
            System.out.print("Introduce el importe del ingreso: ");
            importe = lectura.nextLine();
            
            try{ //Intentamos pasar el valor ingresado a formato numérico
                importeTotal=Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println("El importe del ingreso debe ser numérico +"
                        + e.getMessage());
            }
        }while(importe.isEmpty());
        
        // Agregamos el ingreso a la cuenta
        nuevaCuenta.addIngresos(descripcion, importeTotal);
        
        // Informamos al usuario
        System.out.println("Ingreso registrado correctamente");
    }
   
    // METODO QUE NOS PERMITIRÁ INTRODUCIR GASTOS EN LA CUENTA
    private static void introducirGastos(){
        
          // Reiniciamos las variables por si tuvieran algún valor.
        importe="";
        descripcion="";
        importeTotal=0;
        
         // Pedimos la descripción del gasto
        do{
            System.out.print("Introduce el concepto del gasto: ");
            descripcion = lectura.nextLine();
            
        }while(descripcion.isEmpty());
        
        // Pedimos la el importe del gasto
        do{
            System.out.print("Introduce el importe del gasto: ");
            importe = lectura.nextLine();
            
            try{ // Intentamos pasar el valor ingresado a formato numérico
                importeTotal=Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println("El importe del ingreso debe ser numérico +"
                        + e.getMessage());
            } 
        }while(importe.isEmpty());
            
        // Si el saldo de la cuenta es cero, o es menor al importe del gasto
        if(nuevaCuenta.getSaldo()<importeTotal || nuevaCuenta.getSaldo()==0){
           
            // Por lo tanto, informamos al usuario que debe realizar un ingreso
            // antes de registrar el gasto.
            System.out.println("Debes realizar primero un ingreso para "
                    + "registrar un gasto");
        }
        else{ // En caso contrario
            
          // Agregamos el gasto a la cuenta
            nuevaCuenta.addGastos(descripcion, importeTotal);

            // Informamos al usuario que se ha registrado el gasto.
            System.out.println("Gasto registrado correctamente.");  
        }
    }
    
    // METODO QUE NOS PERMITE MOSTRAR UNA LISTA DE GASTOS DE LA CUENTA
    private static void mostrarGastos(){
        
        // Si la lista de gastos no está vacia
       if(!nuevaCuenta.getGastos().isEmpty()){
            // Recorremos la lista de gastos
           for(int x=0;x<nuevaCuenta.getGastos().size();x++){
               System.out.println(nuevaCuenta.getGastos().get(x).toString());
           }
       }
       else{ // En caso de que la lista esté vacía informamos al usuario
           System.out.println("No existen gastos en esta cuenta.");
       }
    }
    
    // METODO QUE NOS PERMITE MOSTRAR UNA LISTA DE INGRESOS DE LA CUENTA
    private static void mostrarIngresos(){
        
        // Si la lista de ingresos no está vacia
       if(!nuevaCuenta.getIngresos().isEmpty()){
            // Recorremos la lista de gastos
           for(int x=0;x<nuevaCuenta.getIngresos().size();x++){
               System.out.println(nuevaCuenta.getIngresos().get(x).toString());
           }
       }
       else{ // En caso de que la lista este vacía, informamos al usuario
           System.out.println("No existen gastos en esta cuenta.");
       }
    }
    
    //********************************************************************//
    // -------------- MÉTODO MAIN -------------------//
    public static void main(String[] args) {
        
       /* Pedimos los datos para crear un usuario como mínimo una vez y hasta
       que el usuario se haya creado correctamente*/
        do{
           pedirDatosUsuario();
       }while(usuarioCreado=false);
        
        /* Si sale del bucle ya sabemos que el usuario está creado, entonces
        Mostramos los datos del usuario */
        System.out.println("Datos del nuevo usuario:");
        System.out.println(nuevoUsuario.toString());
        
        // Y creamos una nueva cuenta
        nuevaCuenta=new Cuenta(nuevoUsuario);
        
        /* Mostramos el menú como mínimo una vez.
        Tener en cuenta que la primera vez que se muestra el menú la variable
        numeroOpcion tiene un valor de -1 y el menú se mostrará mientras que
        la variable numeroOpcion sea diferente de cero.*/
        do{ 
            
            mostrarMenu();

            /* Creamos una estructura switch a través de la cual sabremos
            que opción se debe ejecutar en cada momento. */
            switch(numeroOpcion){

                case 0: // Eligiendo un cero, saldrá del programa
                    System.out.println("Programa finalizado."
                            + "Gracias por utilizar la aplicación.");
                    break;

                case 1: // Eligiendo un uno se registra un nuevo gasto
                    introducirGastos();
                    break;

                case 2: // Eligiendo un dos se registra un nuevo ingreso
                    introducirIngresos();
                    break;

                case 3: // Eligiendo un tres se muestran los gastos
                    mostrarGastos();
                    break;

                case 4: // Eligiendo un cuatro se muestran los ingresos
                        mostrarIngresos();
                    break;

                case 5: // Elige un cinco se muestra el saldo de la cuenta
                    System.out.println(nuevaCuenta.toString());
                    break;

                default: // Con cualquier otro número, muestra un mensaje

                    System.out.println("Introduce el valor correcto");
                    break;
            }

        // Esto lo hará miestras el valor de la variable
        // numeroOpcion sea diferente de cero
        }while(numeroOpcion !=0);
        
        // Cerramos el objeto lectura, ya que si sale del bucle do - while
        // quiere decir que el programa finalizó.
        lectura.close();
    }
    
}