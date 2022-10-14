package ConexionConsola;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificar extends JFrame {
    
    JTextField txtCodigo = new JTextField();
    JTextField txtNombre = new JTextField();
    JTextField txtDireccion = new JTextField();
    JTextField txtTelefono = new JTextField();
    
    public void vista (){
        this.setTitle("Modificar");
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

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 100, 100, 30);
        panel.add(lblNombre);

        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(50, 150, 100, 30);
        panel.add(lblDireccion);

        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setBounds(50, 200, 100, 30);
        panel.add(lblTelefono);

        txtCodigo.setBounds(200, 50, 200, 30);
        txtNombre.setBounds(200, 100, 200, 30);
        txtDireccion.setBounds(200, 150, 200, 30);
        txtTelefono.setBounds(200, 200, 200, 30);

        JButton btnCrear = new JButton("Crear");
        btnCrear.setBounds(130, 250, 200, 30);

        ActionListener crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               modificar();

            }
        };
        //Acción del evento
        btnCrear.addActionListener(crear);
        panel.add(btnCrear);
        panel.add(txtCodigo);
        panel.add(txtNombre);
        panel.add(txtDireccion);
        panel.add(txtTelefono);



    }

    public void modificar(){
        ColegioDAO colegioDAO = new ColegioDAO();
        colegioDAO.modificar(Integer.parseInt(txtCodigo.getText()), 
        txtNombre.getText(), txtDireccion.getText(), Integer.parseInt(txtTelefono.getText()));

        txtCodigo.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        
    }

    public static void main(String[] args) {
        Modificar modificar = new Modificar();
        modificar.vista();
    }

}
