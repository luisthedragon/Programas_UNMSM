
package Ordenamientos_Y_Busquedas;

public class OrdFrame extends javax.swing.JFrame {
    Ordenamientos o = new Ordenamientos();
    Busquedas b= new Busquedas();
    VECTOR V = new VECTOR();    
    /**
     * Creates new form OrdFrame
     */
    public OrdFrame() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbOrdenamientos = new javax.swing.JComboBox<>();
        cbBusquedas = new javax.swing.JComboBox<>();
        tdatoBuscado = new javax.swing.JTextField();
        bOrdenar = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();
        lmostrarVO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lmostrarVD = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        bDesor = new javax.swing.JButton();
        bGenerarV = new javax.swing.JButton();
        lMuestraEncontrado = new javax.swing.JLabel();
        lEstadoVector = new javax.swing.JLabel();
        vAleatorio = new javax.swing.JRadioButton();
        ingresoVec = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbOrdenamientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Burbuja", "Shell", "Selección Menor", "Insercion", "Quicksort", "Heap Sort", "Merge sort" }));

        cbBusquedas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Secuencial", "Binaria" }));

        bOrdenar.setText("Ordenar");
        bOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdenarActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        l1.setText("Vector ordenado: ");

        jLabel1.setText("Elige el tipo de ordenamiento");

        jLabel2.setText("Elige el tipo de búsqueda");

        jLabel3.setText("Digita el elemento a buscar");

        jLabel4.setText("Ordenamiento");

        jLabel5.setText("Búsqueda");

        l2.setText("Vector desordenado: ");

        bDesor.setText("desordenar");
        bDesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesorActionPerformed(evt);
            }
        });

        bGenerarV.setText("Generar vector");
        bGenerarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarVActionPerformed(evt);
            }
        });

        vAleatorio.setText("Vector aleatorio");
        vAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vAleatorioActionPerformed(evt);
            }
        });

        ingresoVec.setText("12 25 13 48 5 20 10 3 14 8");
        ingresoVec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoVecActionPerformed(evt);
            }
        });

        jLabel6.setText("Inserta el vector");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(l1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(l2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bOrdenar)
                                .addGap(18, 18, 18)
                                .addComponent(bDesor))
                            .addComponent(lmostrarVD, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(lmostrarVO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbOrdenamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lEstadoVector, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(185, 185, 185)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bBuscar)
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lMuestraEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(tdatoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel5)))
                                .addGap(75, 75, 75))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(vAleatorio)
                                .addGap(291, 291, 291))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ingresoVec, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bGenerarV, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingresoVec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(vAleatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bGenerarV)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tdatoBuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cbOrdenamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbBusquedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMuestraEncontrado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addComponent(l1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bOrdenar)
                            .addComponent(bDesor))
                        .addGap(18, 18, 18)
                        .addComponent(lmostrarVD, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lmostrarVO, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lEstadoVector, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenarActionPerformed
        String ordenado=ordena(cbOrdenamientos.getSelectedIndex());
        lEstadoVector.setText(ordenado);
        if(ordenado.equals("Ordenado con exito")){
            lmostrarVO.setText(V.mostrar());
        }
    }//GEN-LAST:event_bOrdenarActionPerformed

    private void bGenerarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarVActionPerformed
        if(vAleatorio.isSelected()){
            V.defaultVector(10);
        }
        else{
            V.leerV_desdeTF(ingresoVec.getText());
        }
        lmostrarVD.setText(V.mostrar());
    }//GEN-LAST:event_bGenerarVActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        lMuestraEncontrado.setText(busca(cbBusquedas.getSelectedIndex()));
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bDesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesorActionPerformed
        o.desordenar(V.vector, V.n);
        lmostrarVD.setText(V.mostrar());
        lEstadoVector.setText("Vector desordenado");
    }//GEN-LAST:event_bDesorActionPerformed

    private void ingresoVecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoVecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoVecActionPerformed

    private void vAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vAleatorioActionPerformed
        
    }//GEN-LAST:event_vAleatorioActionPerformed
    
    public String ordena(int i){
        switch(i){
            case 0: o.burbuja(V.vector, V.n); break;
            case 1: o.shell(V.vector, V.n); break;
            case 2: o.seleccion_menor(V.vector, V.n); break;
            case 3: o.insercion(V.vector, V.n); break;
            case 4: o.quicksort(V.vector, 0, V.n-1);break;
            case 5: o.heapSort(V.vector, V.n);break;
            case 6: o.mergeSort(V.vector, 0, V.n-1);break;
            default: return "El vector no ha sido ordenado";
        }
        return "Ordenado con exito";
    }
    
    public String busca(int i){
        int busqueda;
        switch(i){
            case 0: 
                    busqueda=b.busqSec(V.vector, V.n, Integer.parseInt(tdatoBuscado.getText()));
                    if(busqueda<V.n){
                        return "El elemento fue encontrado en la posición "+ busqueda;
                    }
                    else{
                        return "El elemento no está en el vector";
                    }
            case 1: 
                    busqueda=b.busBin(V.vector, V.n, Integer.parseInt(tdatoBuscado.getText()));
                    if(busqueda<V.n){
                        return "El elemento fue encontrado en la posición "+ busqueda;
                    }
                    else{
                        return "El elemento no está en el vector";
                    }
            default:
                    return "Opcion no válida";
        }
    }

    public static void main(String args[]) {
         /*Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
         /*If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
          For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdFrame().setVisible(true);
            }
        });
    }     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bDesor;
    private javax.swing.JButton bGenerarV;
    private javax.swing.JButton bOrdenar;
    private javax.swing.JComboBox<String> cbBusquedas;
    private javax.swing.JComboBox<String> cbOrdenamientos;
    private javax.swing.JTextField ingresoVec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel lEstadoVector;
    private javax.swing.JLabel lMuestraEncontrado;
    private javax.swing.JLabel lmostrarVD;
    private javax.swing.JLabel lmostrarVO;
    private javax.swing.JTextField tdatoBuscado;
    private javax.swing.JRadioButton vAleatorio;
    // End of variables declaration//GEN-END:variables
}
