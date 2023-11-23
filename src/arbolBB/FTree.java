package arbolBB;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class FTree extends javax.swing.JFrame {
    
    ArbolBinario tree = new ArbolBinario();
    NArbol rx;


    public FTree() {
        initComponents();
        this.inicializar(false);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                         
                dispose(); 

            }
        });
    }

    private void inicializar(boolean enable) {
        this.InOrden.setEnabled(enable);
        this.PostOrden.setEnabled(enable);
        this.PreOrden.setEnabled(enable);
    }

    public void preOrder(NArbol raiz)
    {    
        if(raiz != null)
        {
            
            txtArea.append(raiz.getDato() + ", ");
            // System.out.println("-->" + raiz.getDato() + "\n");
            preOrder(raiz.getIzq());
            preOrder(raiz.getDer());
        }       
        
    }
    
    public void inOrder(NArbol raiz)
    {
        if(raiz != null)
        {
            inOrder(raiz.getIzq());
            txtArea.append(raiz.getDato() + ", ");
            //System.out.println("-->" + raiz.getDato() + "\n");
            inOrder(raiz.getDer());
        }
    }
    
    public void postOrder(NArbol raiz){
        
        if(raiz != null)
        {
            postOrder(raiz.getIzq());
            postOrder(raiz.getDer());
            txtArea.append(raiz.getDato() + ", ");
            System.out.println("-->" + raiz.getDato() + "\n");
        }
        
    }
    
    public void deleteFromTree(int dato) {
       
        tree.setRaiz(deleteNode(tree.getRaiz(), dato));
        
    }
    
    private NArbol deleteNode(NArbol aux, int dato)
    {
        if(aux == null)
        {
            System.out.println("No se encontro el nodo ha eliminar");
        }else if(dato < aux.getDato())
        {
            NArbol left = deleteNode(aux.getIzq(), dato);
            
            aux.setIzq(left);
        }else if(dato > aux.getDato()){
            
            NArbol right = deleteNode(aux.getDer(), dato);
            
            aux.setDer(right);
            
        }else {
            
            NArbol p = aux;
            
            if(p.getDer() == null)
            {
                aux = p.getIzq();
            }else if(p.getIzq() == null)
            {
                aux = p.getDer();
            }else {
                p = change(p);
            }
            p = null;
            
        }
        
        return aux;
    }
    
    private NArbol change(NArbol aux)
    {
        NArbol p = aux;
        NArbol a = aux.getIzq();
        
        while(a.getDer() != null)
        {
            p = a;
            a = a.getDer();
        }
        aux.setDato(a.getDato());
        if(p == aux)
        {
            p.setIzq(a.getIzq());
        }else {
            p.setDer(a.getIzq());
        }
        
        return a;
    }
        
    public NArbol searchInTree(int dato, NArbol raiz)
    {
        
        NArbol term = raiz;
        
        if (raiz == null) {
            System.out.println("No hay nada que eliminar");
            return null;
        }else {
            
            while(term.getDato() != dato)
            {

                if(dato > term.getDato())
                {
                    term = term.getDer();
                }
                if(dato < term.getDato())
                {
                    term = term.getIzq();
                }else{
                    System.out.println("El dato: " + dato + " no se encuentra en el arbol");
                }


            }
        }
        
        
        return term;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        botonInsertar = new javax.swing.JButton();
        InOrden = new javax.swing.JButton();
        PreOrden = new javax.swing.JButton();
        PostOrden = new javax.swing.JButton();
        txtNumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Panel de Pruebas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N
        jPanel2.setOpaque(false);

        jDesktopPane1.setOpaque(false);

        jInternalFrame2.setIconifiable(true);
        jInternalFrame2.setMaximizable(true);
        jInternalFrame2.setResizable(true);
        jInternalFrame2.setEnabled(false);
        jInternalFrame2.setFocusCycleRoot(false);
        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jDesktopPane1.add(jInternalFrame2);
        jInternalFrame2.setBounds(10, 10, 600, 510);

        botonInsertar.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        botonInsertar.setText("Insertar");
        botonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarActionPerformed(evt);
            }
        });

        InOrden.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        InOrden.setText("InOrden");
        InOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InOrdenActionPerformed(evt);
            }
        });

        PreOrden.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        PreOrden.setText("PreOrden");
        PreOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreOrdenActionPerformed(evt);
            }
        });

        PostOrden.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        PostOrden.setText("PostOrden");
        PostOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostOrdenActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        btnDelete.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(InOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PreOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PostOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PostOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarActionPerformed
        try {
            int dato = Integer.parseInt(txtNumber.getText());
            this.tree.insertToTree(dato);
            inicializar(true);
            complementos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el dato", "Intenta de nuevo...", 0);

        }
    }//GEN-LAST:event_botonInsertarActionPerformed

    private void InOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InOrdenActionPerformed

        txtArea.append("\nInOrder: \n");
        
        rx = tree.getRaiz();
        
        inOrder(rx);
        
    }//GEN-LAST:event_InOrdenActionPerformed

    private void PreOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreOrdenActionPerformed
       
        txtArea.append("\nPreorder: \n");
        
        rx = tree.getRaiz();
        
        preOrder(rx);
        
    }//GEN-LAST:event_PreOrdenActionPerformed

    private void PostOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostOrdenActionPerformed
        
        txtArea.append("\nPostorder: \n");
        
        rx = tree.getRaiz();
        
        postOrder(rx);
        
    }//GEN-LAST:event_PostOrdenActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       
        if(!txtNumber.getText().isEmpty())
        {
            int dato = Integer.parseInt(txtNumber.getText());

            System.out.println("Acción realizada");

            deleteFromTree(dato);
        
            preOrder(tree.getRaiz());
            
            complementos();
            
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        int dato = Integer.parseInt(txtNumber.getText());
        
        txtArea.append("\nBusqueda: \n");
        
        rx = tree.getRaiz();
        
        try {
            NArbol result = searchInTree(dato, rx);
            if(result != null){
            txtArea.append("\nDato encontrado: "+ result.getDato());
            
            }else {
                txtArea.append("\nNo se ha encontrado el dato: ");
            }
        } catch (Exception e) {
            txtArea.append("\nDato no se encuentra en el arbol");
        }
        
        
        
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    public void complementos(){
        this.repintarArbol();
    }
    private void repintarArbol() {
        this.jDesktopPane1.removeAll();
        Rectangle tamaño = this.jInternalFrame2.getBounds();
        this.jInternalFrame2 = null;
        this.jInternalFrame2 = new JInternalFrame("Representación gráfica", true);
        this.jDesktopPane1.add(this.jInternalFrame2, JLayeredPane.DEFAULT_LAYER);
        this.jInternalFrame2.setVisible(true);
        this.jInternalFrame2.setBounds(tamaño);
        this.jInternalFrame2.setEnabled(false);
        this.jInternalFrame2.add(this.tree.getdibujo(), BorderLayout.CENTER);
    }

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
            java.util.logging.Logger.getLogger(FTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTree().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InOrden;
    private javax.swing.JButton PostOrden;
    private javax.swing.JButton PreOrden;
    private javax.swing.JButton botonInsertar;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
