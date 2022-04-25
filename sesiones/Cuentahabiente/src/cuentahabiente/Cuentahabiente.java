/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuentahabiente;

/**
 *
 * @author sergi
 */
public class Cuentahabiente {
private int idcliente;
private String nombre;
private float balance;
String balance2;
//constructor
    public Cuentahabiente() {
    }
//constructor sobrecargado 

    public Cuentahabiente(int idcliente, String nombre, float balance, float dinero) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.balance = balance;
    }

// getter an setter encapsulado y el to string
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    
       @Override
    public String toString() {
        return "Cuentahabiente{" + "idcliente=" + idcliente + ", nombre=" + nombre + ", balance=" + balance + ", dinero=" +'}';
         }
    // se empieza con el metodo
    // codigo para restarle el monto al balance
    public void retirarDinero( float monto ){    
        System.out.println("Su cantidad de dinero que retiro es " + monto);
    }
 // dependiendo del balance debe regresar un string con cualquiera de las opciones regular o premium. 
      public String evaluarNivelCliente(){
  if( balance<=50000);
          balance2 = "Cliente regular";
   if (balance>50000);
          balance2 = "cliente premium";
          System.out.println(balance2);
          return String balance2;
      }
}
        

