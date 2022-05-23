/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ico.fes.swing;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sergi
 */
public class VentanaCifradoCesar extends JFrame implements ActionListener{
 
    String letras = "abcdefghijklmnñopqrstuvwxyz"; 
    private JTextField cDesplazar;     
    private JTextField cMensaje;       
    private JTextField cMensajeD;      
    private JLabel etiDesp;            
    private JLabel etIngresar;         
    private JLabel etiMensaje;         
    private JButton btn;               

    /*Método Constructor*/
    public VentanaCifradoCesar() throws HeadlessException {

        
        setTitle("Cifrado Cesar");

        /*Dimensión de la ventana*/
        setSize(475, 450);
                
        
        setLayout(null);
        //setLocationRelativeTo(null);
        //setLayout(new FlowLayout(FlowLayout.CENTER));   

         etIngresar = new JLabel("Ingresa un mensaje: ");
        etIngresar.setBounds(20, 77, 400, 50);

        cMensaje = new JTextField();
        cMensaje.setBounds(20, 110, 200, 250);
        cMensaje.setToolTipText("Introduzca algun texto a cifrar");

        etiDesp = new JLabel("Numero de desplazamiento");
        etiDesp.setBounds(20, 20, 400, 50);

        cDesplazar = new JTextField();
        cDesplazar.setBounds(20, 55, 35, 25);
        cDesplazar.setToolTipText("Introduzca un numero de desplazamientos porfavor.");  
       
       //
       
        etiMensaje = new JLabel("Su cifrado es... ");
        etiMensaje.setBounds(250, 1, 200, 200); 
        cMensajeD = new JTextField();
        cMensajeD.setBounds(250, 110, 200, 250);
        cMensajeD.setToolTipText("Su cifrado aparece aqui");

       
        //ImageIcon icono = new ImageIcon(System.getProperty("user.dir")+"/src/ico/fes/swing/cifrando.png"); ----> Esto no va
        btn = new JButton("Cifrar Texto");
        btn.setBounds(165, 380, 150, 30);
        btn.setToolTipText("Por favor de hacer clic para cifrar el mensaje");

        
        this.getContentPane().add(cDesplazar);
        this.getContentPane().add(cMensajeD);
        this.getContentPane().add(cMensaje);
        this.getContentPane().add(etiDesp);
        this.getContentPane().add(etIngresar);
        this.getContentPane().add(etiMensaje);
        this.getContentPane().add(btn);
        btn.addActionListener(this);

        this.validate();
        this.setVisible(true);

        /*Nota: Para que la ventana cierre directamente*/
        /*Declarar Adaptador para cerrar ventana*/
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
    }

    
   
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == btn) {           
            char caracter;
            String texto;
            String textoCodificado = "";
            try {                
                texto = cMensaje.getText();
               
                texto = texto.toLowerCase();
               
                int clave = Integer.parseInt(cDesplazar.getText());                
                for (int i = 0; i < texto.length(); i++) {                   
                    caracter = texto.charAt(i);                  
                    int posicion = letras.indexOf(caracter);               
                    if (posicion == -1) {                      
                        textoCodificado += caracter;
                    } else {                      
                        textoCodificado += letras.charAt((posicion + clave) % letras.length());
                    }
                }              
                cMensajeD.setText("" + textoCodificado);
            } catch (Exception ex) {                
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(null,
                        "Introduzca los valores correctamente",
                        "Error de captura del texto",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
