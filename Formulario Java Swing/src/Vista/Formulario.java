package Vista;

import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Formulario {
    
    // A mi me gusta declarar el frame en lugar de extender la clase y entre parentesis va el titulo de este
    JFrame framePrincipal = new JFrame("Formulario de Datos Personales");

    // Definimos el contenedor
    Container contenedor = framePrincipal.getContentPane();

    // Las etiquetas de los campos con su texto entre parentesis
    JLabel aMaternoLabel =  new JLabel("Apellido Materno");
    JLabel aPaternoLabel = new JLabel("Apellido Paterno");
    JLabel checkLabel = new JLabel("Acepto ser Humano");
    JLabel nombreLabel = new JLabel("Nombre");
    JLabel sexoLabel = new JLabel("sexo");

    // Los campos de texto
    JTextField aMaternoField = new JTextField();
    JTextField aPaternoField = new JTextField();
    JTextField nombreField = new JTextField();

    // El Combobox y su arreglo de opciones
    String [] sexoOptions = {"Masculino","Femenino"};
    JComboBox sexoCombo = new JComboBox(sexoOptions);
}
