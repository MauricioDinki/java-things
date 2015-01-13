package Vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Formulario implements ActionListener{
    
    // A mi me gusta declarar el frame en lugar de extender la clase y entre parentesis va el titulo de este
    JFrame framePrincipal = new JFrame("Formulario de Datos Personales");

    // Definimos el contenedor
    Container contenedor = framePrincipal.getContentPane();

    // Las etiquetas de los campos con su texto entre parentesis
    JLabel aMaternoLabel =  new JLabel("Apellido Materno");
    JLabel aPaternoLabel = new JLabel("Apellido Paterno");
    JLabel humanLabel = new JLabel("Acepto ser Humano");
    JLabel nombreLabel = new JLabel("Nombre");
    JLabel sexoLabel = new JLabel("Sexo");

    // Los campos de texto
    JTextField aMaternoField = new JTextField();
    JTextField aPaternoField = new JTextField();
    JTextField nombreField = new JTextField();

    // El Combobox y su arreglo de opciones
    String [] sexoOptions = {"Masculino","Femenino"};
    JComboBox sexoCombo = new JComboBox(sexoOptions);

    // El CheckBox
    JCheckBox humanCheckBox = new JCheckBox();

    // Los botones
    JButton enviarButton =  new JButton("Enviar");

    public Formulario(){

        contenedor.setLayout(null); // Hacemos que el contenedor no tenga layout
        framePrincipal.setSize(500,400); // Establecemos el tamaño del frame
        framePrincipal.setLocationRelativeTo(null); // Pocicion relativa a nada para que aparesca centrado en la pantalla
        framePrincipal.setVisible(true); // hacemos que sea visible
        framePrincipal.setResizable(false); // que no se pueda modificar su tamaño
        framePrincipal.setDefaultCloseOperation(EXIT_ON_CLOSE); // que al dar click en el boton cerrar, se cierre completamente

        
        aMaternoLabel.setBounds(50,100,130,13); // le decimos el tamaño y la posicion (posicion en x, posicion en y, ancho en x, ancho en y)
        contenedor.add(aMaternoLabel); // Lo agregamos al contenedo, si no lo agregamos no va a aparecer

        aPaternoLabel.setBounds(50,150,130,13);
        contenedor.add(aPaternoLabel);

        humanLabel.setBounds(50,200,150,13);
        contenedor.add(humanLabel);

        nombreLabel.setBounds(50,50,130,13);
        contenedor.add(nombreLabel);

        sexoLabel.setBounds(50,250,130,13);
        contenedor.add(sexoLabel);

        aMaternoField.setBounds(220,95,200,20);
        contenedor.add(aMaternoField);

        aPaternoField.setBounds(220,145,200,20);
        contenedor.add(aPaternoField);

        nombreField.setBounds(220,45,200,20);
        contenedor.add(nombreField);

        sexoCombo.setBounds(220,245,200,20);
        contenedor.add(sexoCombo);

        humanCheckBox.setBounds(215,195,20,20);
        contenedor.add(humanCheckBox);

        enviarButton.setBounds(100,300,300,30);
        contenedor.add(enviarButton);
        enviarButton.addActionListener(this); //Añadimos el action listener para los eventos y le decimos que es el que esta aqui (this)
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	// si se preciona el boton enviarButton
        if (e.getSource() == enviarButton) {
        	// Mostramos el mensaje de alerta y recibe los parametros(donde aparecera,contenido,titulo,tipo)
            JOptionPane.showMessageDialog(framePrincipal,"Hiciste Click En Enviar","Enviar",JOptionPane.WARNING_MESSAGE);
        }
    }
}
