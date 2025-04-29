/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.koneksi;  //import model koneksi
import java.sql.Connection;  //import java.sql.Connection
import java.sql.ResultSet; //import java.sql.ResultSet
import java.sql.Statement; //import java.sql.Statement
import javax.swing.JOptionPane; //import javax.swing.JOptionPane
import javax.swing.table.DefaultTableModel; //import javax.swing.table.DefaultTableModel
import java.text.ParseException; //import java.text.ParseException
import java.text.SimpleDateFormat; //import java.text.SimpleDateFormat
import java.util.Date; //import java.util.Date

/**
 *
 * @author Kellman N. Gunawan
 */
public class input extends javax.swing.JFrame {

    /**
     * Creates new form input
     */
    String sql; //sql bertipe data string
    Connection con; //con mewakili connection
    Statement stm; //stm mewakili statement
    ResultSet rs;  //rs mewakili result set
    
    
    
    public void clear(){ //method clear
        kodeobat.setText(""); //mengosongkan isi tampilan
        namaobat.setText(""); //mengosongkan isi tampilan
        kategori.setText(""); //mengosongkan isi tampilan
        keterangan.setText(""); //mengosongkan isi tampilan
        hargabeli.setText(""); //mengosongkan isi tampilan
        hargajual.setText(""); //mengosongkan isi tampilan
        kuantitas.setText(""); //mengosongkan isi tampilan
        datesekarang.setCalendar(null); //mengosongkan isi tampilan
        datekadaluarsa.setCalendar(null); //mengosongkan isi tampilan
        cbkategori.setSelectedItem("pilih kategori"); //mengosongkan isi tampilan
   }
    
    public void tanggal(){//method tanggal
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //membuat format tanggal
        tglkada = String.valueOf(format.format(datekadaluarsa.getDate())); //menampung format tanggal dalam bentuk string
        tglkada2 = String.valueOf(format.format(datesekarang.getDate())); //menampung format tanggal dalam bentuk string
        
        if(datesekarang.getDate().after(datekadaluarsa.getDate())){//kondisi pertama
            keterangan.setText("Kadaluarsa");//menampilkan kadaluarsa pada keterangan
        }
        else{
            keterangan.setText("Belum kadaluarsa");//menampilkan belum kadaluarsa pada keterangan
        }
    }
    
    String ket; //ket bertipe string
    String tglkada; //tgl kada bertipe data string  
    String tglkada2;
    String totalbeli;//totalbeli bertipe string
    
    public void tbeli(){//method tbeli
        int kuat = Integer.parseInt(kuantitas.getText()); //mengubah nilai kuantitas ke integer variabel kuat
        int beli = Integer.parseInt(hargabeli.getText()); //mengubah nilai hargabeli ke integer variabel beli
        totalbeli = (Integer.toString((int) (kuat*beli)));   //mengubah niai dari kuat*beli ke string   
    }
    
    String totaljual; //totaljual bertipe string
    public void tjual(){ //methodtjual
        int kuat = Integer.parseInt(kuantitas.getText()); //mengubah nilai kuantitas ke integer variabel kuat
        int jual = Integer.parseInt(hargajual.getText()); //mengubah nilai hargajual ke integer variabel jual
        totaljual = (Integer.toString((int) (kuat*jual)));      //mengubah niai dari kuat*jual ke string   
    }
    
    public void Display_Data(){ //method display_data
        koneksi DB = new koneksi(); //koneksi db
        DB.koneksi(); //koneksi db
        con=DB.con; //con mewakili db.con
        stm=DB.stm; //stm mewakili db.stm
        
        DefaultTableModel Model = new DefaultTableModel(); //object model
        Model.addColumn("Kode"); //menambah kolom kode
        Model.addColumn("Nama obat"); //menambah kolom Nama obat
        Model.addColumn("Kd_kategori"); //menambah kolom Kd_kategori
        Model.addColumn("Kategori"); //menambah kolom Kategori
        Model.addColumn("Kadaluarsa"); //menambah kolom Kadaluarsa
        Model.addColumn("Keterangan"); //menambah kolom Keterangan
        Model.addColumn("Harga Beli"); //menambah kolom Harga Beli
        Model.addColumn("Harga Jual"); //menambah kolom Harga Jual
        Model.addColumn("Kuantitas"); //menambah kolom Kuantitas
        Model.addColumn("Total harga beli"); //menambah kolom Total harga beli
        Model.addColumn("Total harga jual"); //menambah kolom Total harga jual
        
        try { //statement try
            sql = "SELECT * FROM tblinput order by Kode asc"; //url sql
            rs = stm.executeQuery(sql); //memasukkan url sql ke query
            
            while (rs.next()){ //kondisi while
                Model.addRow(new Object[]{rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6)
                    ,rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)
                    ,rs.getString(11)}); //menambah baris di tabel frame dari data database
            }
            tabelinput.setModel(Model); //tabelinput.setmodel
        } catch (Exception e) { //jika error
            JOptionPane.showMessageDialog(this, e.getMessage()); //menampilkan message
        }
    }
    
    public input() { //method input
        initComponents(); //initcomponents
        Display_Data(); //displaydata
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kodeobat = new javax.swing.JTextField();
        namaobat = new javax.swing.JTextField();
        cbkategori = new javax.swing.JComboBox<>();
        kategori = new javax.swing.JTextField();
        kembali = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelinput = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        keterangan = new javax.swing.JTextField();
        hargabeli = new javax.swing.JTextField();
        hargajual = new javax.swing.JTextField();
        kuantitas = new javax.swing.JTextField();
        datekadaluarsa = new com.toedter.calendar.JDateChooser();
        datesekarang = new com.toedter.calendar.JDateChooser();
        btnket = new javax.swing.JButton();
        btnjual = new javax.swing.JButton();
        cari = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT DATA OBAT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 50));

        jLabel2.setText(" Kode Obat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 30));

        jLabel3.setText(" Nama Obat");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        jLabel4.setText(" Kode Kategori");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, -1));

        jLabel5.setText("Kategori");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 200, 110, -1));

        jLabel6.setText("Tanggal update");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 249, -1, -1));

        jLabel7.setText("Tanggal Kadaluarsa");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));
        getContentPane().add(kodeobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 200, -1));
        getContentPane().add(namaobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 200, -1));

        cbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih kategori", "Narkotika", "Psikotropika", "Bebas", "Keras" }));
        cbkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkategoriActionPerformed(evt);
            }
        });
        getContentPane().add(cbkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 200, -1));
        getContentPane().add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 197, 200, -1));

        kembali.setText("kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, 49));

        batal.setText("batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 87, 49));

        simpan.setText("simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, 49));

        tabelinput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelinput);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1180, 217));

        jLabel9.setText("Harga Beli");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));

        jLabel11.setText("Kuantitas");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 75, -1));

        keterangan.setEditable(false);
        keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keteranganActionPerformed(evt);
            }
        });
        getContentPane().add(keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 180, 30));
        getContentPane().add(hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 180, -1));

        hargajual.setEditable(false);
        hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargajualActionPerformed(evt);
            }
        });
        getContentPane().add(hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 182, -1));

        kuantitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kuantitasActionPerformed(evt);
            }
        });
        getContentPane().add(kuantitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 182, -1));
        getContentPane().add(datekadaluarsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 182, -1));

        datesekarang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datesekarangPropertyChange(evt);
            }
        });
        getContentPane().add(datesekarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 249, 200, -1));

        btnket.setText("keterangan");
        btnket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnketActionPerformed(evt);
            }
        });
        getContentPane().add(btnket, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, 30));

        btnjual.setText("Harga Jual");
        btnjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnjualActionPerformed(evt);
            }
        });
        getContentPane().add(btnjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, 30));

        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 80, 50));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 0, 0));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        new kategori().setVisible(true); //tombol ke form kategori
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        clear(); //memanggil method clear
    }//GEN-LAST:event_batalActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        koneksi DB = new koneksi(); //koneksi
        DB.koneksi(); //dbkoneksi
        con=DB.con; //con mewkili db.con
        stm=DB.stm; //stm mewakili db.stm
        tbeli(); //memanggil method tbeli
        tjual(); //memanggil method tjual
        
        try { //statemnt try
            sql = "INSERT INTO tblinput VALUES ('"+kodeobat.getText()+"','"+namaobat.getText()+"','"
                    +cbkategori.getSelectedItem()+"','"+kategori.getText()+"','"+tglkada+"','"
                    +keterangan.getText()+"','"+hargabeli.getText()+"','"+hargajual.getText()+"','"+kuantitas.getText()+"','"
                    +totalbeli+"','"+totaljual+"')"; //memasukkan nilai ke database
            stm.execute(sql); //execute
            
            JOptionPane.showMessageDialog(null, "Proses Simpan Berhasil"); //menampilkan proses simpan berhsil
            Display_Data(); //memanggil method displaydata
            clear(); //memanggil method clear
            
        } catch (Exception e){ //statemnt catch
            
            JOptionPane.showMessageDialog(this, e.getMessage()); //menampilkan message
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void cbkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkategoriActionPerformed
        // TODO add your handling code here:
        String pilih_kategori=(String)cbkategori.getSelectedItem(); //membuat isi combo box ke string
        switch (pilih_kategori){ //switch case
        case "Narkotika": //case1
        kategori.setText("N");//menampikan n di kategori
        break;//break
        case "Psikotropika"://case2
        kategori.setText("P");//menampilkan p di kategori
        break;//break
        case "Bebas"://case 3
        kategori.setText("B");//menampilkan b di kategori
        break;//break
        case "Keras"://case 4
        kategori.setText("K"); //menampilkan k di kategori
        break;//break
    }
    }//GEN-LAST:event_cbkategoriActionPerformed

    private void hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargajualActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_hargajualActionPerformed

    private void keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keteranganActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_keteranganActionPerformed

    private void btnketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnketActionPerformed
        // TODO add your handling code here:
        tanggal(); //menampilkan method tanggal
    }//GEN-LAST:event_btnketActionPerformed

    private void btnjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnjualActionPerformed
        // TODO add your handling code here:
        int Harga_jual = Integer.parseInt(hargabeli.getText()); //mengubah nilai isi hargabeli ke integer
        hargajual.setText(Integer.toString((int) (Harga_jual*1.2))); //mengubah nilai hargajual ke string
    }//GEN-LAST:event_btnjualActionPerformed

    private void kuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kuantitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kuantitasActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
        new cari().setVisible(true); //tombol ke form cari
        dispose();
    }//GEN-LAST:event_cariActionPerformed

    private void datesekarangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datesekarangPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_datesekarangPropertyChange

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new input().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batal;
    private javax.swing.JButton btnjual;
    private javax.swing.JButton btnket;
    private javax.swing.JButton cari;
    private javax.swing.JComboBox<String> cbkategori;
    private com.toedter.calendar.JDateChooser datekadaluarsa;
    private com.toedter.calendar.JDateChooser datesekarang;
    private javax.swing.JTextField hargabeli;
    private javax.swing.JTextField hargajual;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField kategori;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField keterangan;
    private javax.swing.JTextField kodeobat;
    private javax.swing.JTextField kuantitas;
    private javax.swing.JTextField namaobat;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabelinput;
    // End of variables declaration//GEN-END:variables
}
