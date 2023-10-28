package swing5;

public class Swing5 extends javax.swing.JFrame {

    public Swing5() {
        initComponents();
    }

    private void initComponents() {
        //instanciar objeto JLabel 
        jlSaludo = new javax.swing.JLabel();
        jlSaludando = new javax.swing.JLabel();
        jtCaja = new javax.swing.JTextField();
        jBoton = new javax.swing.JButton();
        jcbOpciones = new javax.swing.JComboBox<>();

        //setear el texto a mostrar en los componenter
        jlSaludo.setText("Hola Mundo!");
        jlSaludando.setText("Hola");
        jtCaja.setText("");
        jBoton.setText("Pulsame");
        jcbOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Ciudades:", "Madrid", "Valencia", "Barcelona", "Bilbao"}));

        //cerrar ventana al pulsar X
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Aniadir listener
        jBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsarBoton(evt);
            }
        });

        //crear un layout e indicar que debe ir en la ventana
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        //indicar la posicion del layout - maquetacion
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlSaludo)
                                        .addComponent(jlSaludando)
                                        .addComponent(jtCaja)
                                        .addComponent(jBoton)
                                        .addComponent(jcbOpciones))
                                .addContainerGap(357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlSaludo)
                                .addComponent(jlSaludando)
                                .addComponent(jtCaja)
                                .addComponent(jBoton)
                                .addComponent(jcbOpciones)
                                .addContainerGap(278, Short.MAX_VALUE))
        );

        pack();
    }

    private void pulsarBoton(java.awt.event.ActionEvent evt) {
        // código del evento al pulsar el Boton
        System.out.print("Has pulsado el botón");
        jlSaludando.setText("Has pulsado el botón");
    }

    public static void main(String[] args) {

        //Look and Feel para mejorar la apariencia
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Swing5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Swing5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Swing5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Swing5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //al dar Play ejecutar ventana
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Swing5().setVisible(true);
            }
        });
    }

    //DECLARACION DE VARIABLES
    private javax.swing.JLabel jlSaludo;
    private javax.swing.JLabel jlSaludando;
    private javax.swing.JTextField jtCaja;
    private javax.swing.JButton jBoton;
    private javax.swing.JComboBox<String> jcbOpciones;
}
