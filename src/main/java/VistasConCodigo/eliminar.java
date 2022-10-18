package VistasConCodigo;


import ConexionConsola.ColegioDAO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class eliminar extends JFrame {
    JTextField txtCodigo = new JTextField();
    
    public void vista (){
        this.setTitle("Eliminar");
        this.setSize(500, 350);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(50, 50, 100, 30);
        panel.add(lblCodigo);
        txtCodigo.setBounds(200, 50, 200, 30);
        panel.add(txtCodigo);


        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(130, 250, 200, 30);

        ActionListener eliminar_accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               eliminar();

            }
        };

        btnEliminar.addActionListener(eliminar_accion);

        panel.add(btnEliminar);
        panel.add(txtCodigo);

    }

    public void eliminar(){
        ColegioDAO colegioDAO = new ColegioDAO();
        colegioDAO.eliminar(Integer.parseInt(txtCodigo.getText()));
    }

    public static void main(String[] args) {
        eliminar eliminar = new eliminar();
        eliminar.vista();
    }

}
