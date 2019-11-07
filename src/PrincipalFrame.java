

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Nassr Eddine Mousati Lamhamdi
 * Yousuf Boutahar El Maachi
 */
public class PrincipalFrame extends javax.swing.JFrame {

    JFileChooser jdcOriginFolder = new JFileChooser();
    JFileChooser jdcDestFolder = new JFileChooser();
    private File originFolder, destinationFolder;
    public static String rutaOriginal, rutaDestino, nombreDelZip;
    
    
    private void clean(){
        originFolder        = null;
        destinationFolder   = null;
        rutaOriginal        = null;  
        rutaDestino         = null;   
        nombreDelZip        = null;    
        originPath.setText("");
        destinationPath.setText("");
                
    }
    
    // private mySwingWorker worker;
    /**
     * Creates new form NewJFrame
     */
    public PrincipalFrame() {
        initComponents();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        originPath = new javax.swing.JTextField();
        destinationPath = new javax.swing.JTextField();
        buttonOriginPath = new javax.swing.JButton();
        buttonDestinationPath = new javax.swing.JButton();
        buttonStartZip = new javax.swing.JButton();
        buttonStopZip = new javax.swing.JButton();
        loadingBar = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("DIU - ZIP");

        jLabel3.setText("Carpeta origen:");

        jLabel4.setText("Carpeta destino:");

        originPath.setEditable(false);
        originPath.setForeground(new java.awt.Color(204, 204, 204));
        originPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originPathActionPerformed(evt);
            }
        });

        destinationPath.setEditable(false);
        destinationPath.setForeground(new java.awt.Color(204, 204, 204));

        buttonOriginPath.setText("Seleccionar carpeta origen");
        buttonOriginPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOriginPathActionPerformed(evt);
            }
        });

        buttonDestinationPath.setText("Seleccionar carpeta destino");
        buttonDestinationPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDestinationPathActionPerformed(evt);
            }
        });

        buttonStartZip.setText("Iniciar compresión");
        buttonStartZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartZipActionPerformed(evt);
            }
        });

        buttonStopZip.setText("Cancelar");
        buttonStopZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopZipActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(destinationPath))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(originPath, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonOriginPath)
                                    .addComponent(buttonDestinationPath)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(buttonStartZip)
                                .addGap(55, 55, 55)
                                .addComponent(buttonStopZip)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(originPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOriginPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(destinationPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDestinationPath))
                .addGap(18, 18, 18)
                .addComponent(loadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonStartZip)
                    .addComponent(buttonStopZip))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void originPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_originPathActionPerformed

    private void buttonOriginPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOriginPathActionPerformed
        
        jdcOriginFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jdcOriginFolder.showOpenDialog(jdcOriginFolder);
        jdcOriginFolder.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(e.getActionCommand());
                if(e.getActionCommand()=="ApproveSelection"){
                    originFolder = jdcOriginFolder.getSelectedFile();
                    rutaOriginal = originFolder.getPath().replaceAll("\\\\", "\\\\\\\\");
                    originPath.setText(rutaOriginal);

                    String aux = rutaOriginal.concat(".zip");

                    // obteniendo el nombre del archivo comprimido, pj: "micarpeta.zip"
                    String[] rutaDestinoDividida = aux.split("\\\\");
                    nombreDelZip = rutaDestinoDividida[rutaDestinoDividida.length-1];
                }
            }
        });
    }//GEN-LAST:event_buttonOriginPathActionPerformed

    private void buttonStartZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartZipActionPerformed
       
        
        Worker1 worker = new Worker1();
        worker.execute();
        

    }//GEN-LAST:event_buttonStartZipActionPerformed

    private void buttonDestinationPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDestinationPathActionPerformed

        jdcDestFolder.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jdcDestFolder.showOpenDialog(jdcDestFolder);

        jdcDestFolder.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand()=="ApproveSelection"){
                    destinationFolder = jdcDestFolder.getSelectedFile();
                    String ruta = destinationFolder.getPath().replaceAll("\\\\", "\\\\\\\\");

                    rutaDestino = ruta + "\\" + nombreDelZip;
                    destinationPath.setText(rutaDestino);    
                }
            }
        });

        
    }//GEN-LAST:event_buttonDestinationPathActionPerformed

    private void buttonStopZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStopZipActionPerformed
        
        if(destinationPath.getText().isEmpty() && originPath.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione las rutas deseadas","Cancelar",JOptionPane.INFORMATION_MESSAGE); 
        }else if (!destinationPath.getText().isEmpty() || !originPath.getText().isEmpty()){
              this.clean();
        }else{
            this.clean();
            Worker1.parar = true;
            JOptionPane.showMessageDialog(null, "La compresión ha sigo cancelada","Cancelar",JOptionPane.INFORMATION_MESSAGE);     
        }

        
        
    }//GEN-LAST:event_buttonStopZipActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDestinationPath;
    private javax.swing.JButton buttonOriginPath;
    private javax.swing.JButton buttonStartZip;
    private javax.swing.JButton buttonStopZip;
    private javax.swing.JTextField destinationPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JProgressBar loadingBar;
    private javax.swing.JTextField originPath;
    // End of variables declaration//GEN-END:variables

    
    
    public static void comprimir(String rutaOriginal, String rutaDestino) throws Exception  {
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(rutaDestino));
        agregarCarpeta("",rutaOriginal, zip);
        zip.flush();
        zip.close();
        
        
    }

    private static void agregarCarpeta(String ruta, String carpeta, ZipOutputStream zip) throws Exception {
        File directorio = new File(carpeta);
        for (String nombreArchivo : directorio.list()) {
            if (ruta.equals("")) {
                agregarArchivo(directorio.getName(), carpeta + "/" + nombreArchivo, zip);
            } else {
                agregarArchivo(ruta + "/" + directorio.getName(), carpeta + "/" + nombreArchivo, zip);
            }
        }
    }

    private static void agregarArchivo(String ruta, String directorio, ZipOutputStream zip) throws Exception {
        File archivo = new File(directorio);
        if (archivo.isDirectory()) {
            agregarCarpeta(ruta, directorio, zip);
        } else {
            byte[] buffer = new byte[4096];
            int leido;
            FileInputStream entrada = new FileInputStream(archivo);
            zip.putNextEntry(new ZipEntry(ruta + "/" + archivo.getName()));
            while ((leido = entrada.read(buffer)) > 0) {
                zip.write(buffer, 0, leido);
            }
        }
    }
}



class Worker1 extends SwingWorker<Double, Integer> {
   // Esta etiqueta se recibe en el constructor o a través de un
   // metodo setEtiqueta().
    boolean finalizado = true;
    public static boolean parar = false;
   
   @Override
    protected Double doInBackground() throws Exception {
   // Mostramos el nombre del hilo, para ver que efectivamente
   // esto NO se ejecuta en el hilo de eventos.
        System.out.println("doInBackground() esta en el hilo "
        + Thread.currentThread().getName()); 
        
        /********** Algo de procesamiento costoso ***********/
        try {
            PrincipalFrame.comprimir(PrincipalFrame.rutaOriginal, PrincipalFrame.rutaDestino);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido realizar la compresion",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            finalizado = false;
        }
        publish();
          
        return 100.0;
    }
    
   @Override
    protected void done() {
        if(finalizado)JOptionPane.showMessageDialog(null, "Archivo ZIP creado correctamente !","Finalizado",JOptionPane.INFORMATION_MESSAGE);
            
    }

    
    @Override
    protected void process(List<Integer> chunks) {
        if(parar) Thread.currentThread().stop();
        
        /**
         * aqui habra que poner los de la barra de progreso
         */
        //JOptionPane.showMessageDialog(null, "Comprimiendo...");      
    }
}