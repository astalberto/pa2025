package Presentacion;

import Clases.Cliente;
import Logica.LogCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ventana extends JFrame{
    private JPanel JPanel1;
    private JTextArea textArea1;
    private JButton button1;

     public Ventana(){
        super("ejemplo");

        JPanel1 = new JPanel();
        textArea1 = new JTextArea();
        button1 = new JButton("Insertar Cliente");

        JPanel1.setLayout(new BoxLayout(JPanel1, BoxLayout.Y_AXIS));
        JPanel1.add(textArea1);
        JPanel1.add(button1);

        setContentPane(JPanel1);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente objCliente = new Cliente();
                Cliente objCliente1 = new Cliente("1102","Juan","Perez");
                LogCliente objLogCliente = new LogCliente();
                objCliente.setCedula("1107");
                objCliente.setNombres("Guillermo ");
                objCliente.setApellidos("Lazzo ");
                if (objLogCliente.ValidarCedula(objCliente)) {
                    try {
                        objLogCliente.Insertar(objCliente);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                textArea1.setText(objCliente1.toString());
            }
        });

        // Configura la ventana
        setSize(400, 300); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}