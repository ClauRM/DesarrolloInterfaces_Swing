package temperatureconverter;

import java.awt.Color;

public class TemperatureConverter extends javax.swing.JFrame {

    //constructor
    public TemperatureConverter() {
        initComponents();
    }

    //metodo para calcular temperatura
    private String temperature(String stTempInput, String unit) {
        float flTempInput, flTempOutput;
        String stTempOutput = "";

        try {
            flTempInput = Float.parseFloat(stTempInput); //convertir string a float

            switch (unit) {
                case "C":
                    //convertir ºC a ºF (0 °C × 9 / 5) + 32
                    flTempOutput = (flTempInput * 9 / 5) + 32;
                    stTempOutput = Float.toString(flTempOutput);
                    jlFahrenheit.setText(stTempOutput + " ºF");
                    //convertir ºC a K (0 °C + 273,15)
                    flTempOutput = (flTempInput + 273.15f);
                    stTempOutput = Float.toString(flTempOutput);
                    jlKelvin.setText(stTempOutput + " K");
                    //temperatura en ºC
                    jlCelsius.setText(stTempInput + " ºC");
                    jlError.setText("");
                    break;
                case "F":
                    //convertir ºF a ºC (0 °F − 32) × 5 / 9
                    flTempOutput = (flTempInput - 32) * 5 / 9;
                    stTempOutput = Float.toString(flTempOutput);
                    jlCelsius.setText(stTempOutput + " ºC");
                    //convertir de ºF a K (0 °F − 32) × 5 / 9 + 273,15
                    flTempOutput = (flTempInput - 32) * 5 / 9 + 273.15f;
                    stTempOutput = Float.toString(flTempOutput);
                    jlKelvin.setText(stTempOutput + " K");
                    //temperatura en ºF
                    jlFahrenheit.setText(stTempInput + " ºF");
                    jlError.setText("");
                    break;
                case "K":
                    //convertir K a ºC  (0 °C - 273,15)
                    flTempOutput = flTempInput - 273.15f;
                    stTempOutput = Float.toString(flTempOutput);
                    jlCelsius.setText(stTempOutput + " ºC");
                    //convertir K a ºF (0 K − 273,15) × 9 / 5 + 32
                    flTempOutput = (flTempInput - 273.15f) * 9 / 5 + 32;
                    stTempOutput = Float.toString(flTempOutput);
                    jlFahrenheit.setText(stTempOutput + " ºF");
                    //temperatura en K
                    jlKelvin.setText(stTempInput + " K");
                    jlError.setText("");
                    break;
                default:
                    throw new AssertionError();
            }

        } catch (Exception e) {
            e.printStackTrace();
            jlError.setText("Debe indicar un valor numérico");
        }
        return stTempOutput;
    }

    //iniciar componentes
    private void initComponents() {
        //instancias de objetos
        jlTitle = new javax.swing.JLabel();
        jtInput = new javax.swing.JTextField();
        jcbUnit = new javax.swing.JComboBox<>();
        jlResults = new javax.swing.JLabel();
        jlCelsius = new javax.swing.JLabel();
        jlFahrenheit = new javax.swing.JLabel();
        jlKelvin = new javax.swing.JLabel();
        jlError = new javax.swing.JLabel();

        //setear textos de los objetos
        jlTitle.setText("CONVERTIDOR DE TEMPERATURA");
        jlTitle.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jtInput.setText("1");
        jcbUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecciona unidad:", "Celsius [ºC]", "Fahrenheit [ºF]", "Kelvin [K]"}));
        jlResults.setText("Valores:");
        jlResults.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jlCelsius.setText(" ºC");
        jlFahrenheit.setText(" ºF");
        jlKelvin.setText(" K");
        jlError.setText("");
        jlError.setForeground(Color.red);

        //cerrar ventana al pulsar X
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Aniadir listener al selector
        jcbUnit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                changeItem(evt);
            }
        });

        //crear un layout (disposicion de los objetos) e indicar que debe ir en la ventana
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        //indicar la posicion del layout
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlTitle)
                                        .addComponent(jtInput)
                                        .addComponent(jcbUnit)
                                        .addComponent(jlResults)
                                        .addComponent(jlCelsius)
                                        .addComponent(jlFahrenheit)
                                        .addComponent(jlKelvin)
                                        .addComponent(jlError))
                                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlTitle)
                                .addComponent(jtInput)
                                .addComponent(jcbUnit)
                                .addComponent(jlResults)
                                .addComponent(jlCelsius)
                                .addComponent(jlFahrenheit)
                                .addComponent(jlKelvin)
                                .addComponent(jlError)
                                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }

    //accion al cambiar el valor de la seleccion
    private void changeItem(java.awt.event.ItemEvent evt) {
        // código del evento al pulsar el Boton
        System.out.println("Ha cambiado el valor del Item: " + jcbUnit.getSelectedItem());
        String selection = (String) jcbUnit.getSelectedItem();

        switch (selection) {
            case "Selecciona unidad:":
                jlCelsius.setText(" ºC");
                jlFahrenheit.setText(" ºF");
                jlKelvin.setText(" K");
                jlError.setText("Selecciona una unidad de temperatura");
                break;
            case "Celsius [ºC]":
                temperature(jtInput.getText(), "C");
                break;
            case "Fahrenheit [ºF]":
                temperature(jtInput.getText(), "F");
                break;
            case "Kelvin [K]":
                temperature(jtInput.getText(), "K");
                break;
            default:
                throw new AssertionError();
        }

    }

    //metodo main
    public static void main(String[] args) {
        //Look and Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TemperatureConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TemperatureConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TemperatureConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TemperatureConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Abrir la ventana instanciando la clase principal
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }

    //DECLARACION DE VARIABLES
    private javax.swing.JTextField jtInput;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JComboBox<String> jcbUnit;
    private javax.swing.JLabel jlResults;
    private javax.swing.JLabel jlCelsius;
    private javax.swing.JLabel jlFahrenheit;
    private javax.swing.JLabel jlKelvin;
    private javax.swing.JLabel jlError;
}
