package Vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        // Instanciamos la base
        BD.Conexion enlaceDB = new  BD.Conexion();
        
        // En un try catch intentamos conectar a la base con el metodo conectarDB
        try{
            
            // Nos conectamos
            enlaceDB.conectarDB();
            // con el metodo consulta llamamos al procedimiento sp_getGenero()
            ResultSet rsSexo = enlaceDB.consulta("call sp_getGenero()"); 
            
            // Con while y .next() aplicados al resultset podemos llenar el combo con los datos que trae
            while(rsSexo.next()){
                // añadimos los datos de cada columna en este caso la columna genero al las opciones del combo
                sexoCombo.addItem(rsSexo.getString("genero"));
            }

        } catch(SQLException exx){
            // Si hay error lo atrapamos y lo imprimimos en la consola para saber que esta pasando
            System.out.println(exx);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Almacenamos en variables el contenido de los campos con getText()
        String nombre = nombreField.getText();
        String amaterno = aMaternoField.getText();
        String apaterno = aPaternoField.getText();
        String ser_humano = humanCheckBox.getText();

        // En el caso del combobox es diferente, hay que traer el objeto seleccionado y obtenemos su valo con String.valueOf()
        Object sexoSelected = sexoCombo.getSelectedItem(); 
        String sexo = String.valueOf(sexoSelected);

    	// si se preciona el boton enviarButton
        if (e.getSource() == enviarButton) {

            // si las variables estan vacias o el CheckBox no esta seleccionado (lo comprobamos con .isSelected()==false)
        	if (nombre.equals("")||amaterno.equals("")||apaterno.equals("")||humanCheckBox.isSelected()==false||sexo.equals("")){

                // Mostramos el error
                JOptionPane.showMessageDialog(framePrincipal,"No Se Admiten Campos Vacios","Alerta",JOptionPane.ERROR_MESSAGE);

            } else { //Si no, intentamos la conexion y la subida

                try {

                    BD.Conexion enlaceDB = new  BD.Conexion();
                    enlaceDB.conectarDB();
                    // Llamamos al SP que da de alta y le pasamos las variables que definimos al principio, 
                    // el ultimo dice humano por que el checkbox no devuelve un texto
                    ResultSet resultSet = enlaceDB.consulta("call sp_altaInformacion('"+nombre+"','"+amaterno+"','"+apaterno+"','"+sexo+"','humano');");
                    
                } catch(SQLException exx){

                    System.out.println(exx);
                }
            }
        }
    }
}
