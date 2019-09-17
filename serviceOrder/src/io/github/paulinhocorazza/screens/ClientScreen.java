/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.paulinhocorazza.screens;

import java.sql.*;
import io.github.paulinhocorazza.dal.DatabaseConnection;
import java.awt.Color;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author paulo.corazza
 */
public class ClientScreen extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form UserScreen
     */
    public ClientScreen() {
        initComponents();
        conexao = DatabaseConnection.conector();
    }

    //criar cliente
    private void createClient() {

        String sql = "insert into tb_clientes(cliente_nome, cliente_endereco , cliente_fone, cliente_email ) values (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtClientName.getText());
            pst.setString(2, txtClientAddress.getText());
            pst.setString(3, txtClientPhoneNumber.getText());
            pst.setString(4, txtClientEmail.getText());

            if (txtClientName.getText().isEmpty() || txtClientAddress.getText().isEmpty() || txtClientPhoneNumber.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Preencha todos os campos !");
            } else {
                int addedCLient = pst.executeUpdate();
                if (addedCLient > 0) {
                    JOptionPane.showMessageDialog(null, "O Cliente " + txtClientName.getText() + " foi cadastrado com sucesso !");
                    txtClientName.setText("");
                    txtClientAddress.setText("");
                    txtClientPhoneNumber.setText("");
                    txtClientEmail.setText("");

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado, erro: " + e);
        }

    }

    public void updateClient() {
        String sql = "update tb_clientes set cliente_nome=?, cliente_endereco=?, cliente_fone=?, cliente_email=? where id_cliente=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtClientName.getText());
            pst.setString(2, txtClientAddress.getText());
            pst.setString(3, txtClientPhoneNumber.getText());
            pst.setString(4, txtClientEmail.getText());
            pst.setString(5, txtClientId.getText());

            if (txtClientName.getText().isEmpty() || txtClientAddress.getText().isEmpty() || txtClientPhoneNumber.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios !");

            } else {
                int updatedClient = pst.executeUpdate();
                if (updatedClient > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso !");
                    txtClientName.setText("");
                    txtClientAddress.setText("");
                    txtClientPhoneNumber.setText("");
                    txtClientEmail.setText("");
                    btnCreateClient.setEnabled(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);

        }
    }

    public void deleteClient() {

        int accept = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o cliente " + txtClientName.getText() + " ?");
        if (accept == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_clientes  where id_cliente=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtClientId.getText());
                int deleted = pst.executeUpdate();
                if(deleted > 0){
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso !");
                    txtClientName.setText("");
                    txtClientAddress.setText("");
                    txtClientPhoneNumber.setText("");
                    txtClientEmail.setText("");
                    btnCreateClient.setEnabled(true);
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e);
            }
        }

    }

    public void searchClient() {
        String sql = "select * from tb_clientes where cliente_nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtClientSearch.getText() + "%");
            rs = pst.executeQuery();
            tblClient.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }

    }

    public void setFieldsFromTable() {
        int set = tblClient.getSelectedRow();
        txtClientId.setText(tblClient.getModel().getValueAt(set, 0).toString());
        txtClientName.setText(tblClient.getModel().getValueAt(set, 1).toString());
        txtClientAddress.setText(tblClient.getModel().getValueAt(set, 2).toString());
        txtClientPhoneNumber.setText(tblClient.getModel().getValueAt(set, 3).toString());
        txtClientEmail.setText(tblClient.getModel().getValueAt(set, 4).toString());
        btnCreateClient.setEnabled(false);
        //txtClientName.setEditable(false);

    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userName = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtClientAddress = new javax.swing.JTextField();
        btnCreateClient = new javax.swing.JButton();
        btnDeleteClient = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtClientSearch = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        userName1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboUserProfile1 = new javax.swing.JComboBox();
        txtUserName1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtUserLogin1 = new javax.swing.JTextField();
        btnEditUser1 = new javax.swing.JButton();
        txtUserPassword1 = new javax.swing.JPasswordField();
        comboUserRole1 = new javax.swing.JComboBox();
        btnCreateUser1 = new javax.swing.JButton();
        btnReadUser1 = new javax.swing.JButton();
        btnDeleteUser1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtIdUser1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnUpdateClient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        iconMagnifyingGlass = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtClientPhoneNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtClientEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtClientId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        setMaximumSize(new java.awt.Dimension(916, 650));
        setPreferredSize(new java.awt.Dimension(915, 650));

        userName.setText("* Nome:");

        txtClientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClientNameActionPerformed(evt);
            }
        });

        jLabel6.setText("* Endereço:");

        btnCreateClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/create.png"))); // NOI18N
        btnCreateClient.setToolTipText("Adicionar Usuário");
        btnCreateClient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCreateClient.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCreateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateClientActionPerformed(evt);
            }
        });

        btnDeleteClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/delete.png"))); // NOI18N
        btnDeleteClient.setToolTipText("Excluir Usuário");
        btnDeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClientActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisar:");

        txtClientSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClientSearchKeyReleased(evt);
            }
        });

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Usuários");
        jInternalFrame1.setMaximumSize(new java.awt.Dimension(916, 650));
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(915, 650));

        userName1.setText("Nome:");

        jLabel7.setText("Cargo:");

        jLabel8.setText("Senha:");

        jLabel9.setText("Perfil de usuário:");

        comboUserProfile1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "restrito" }));

        txtUserName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserName1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Login:");

        btnEditUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/update.png"))); // NOI18N
        btnEditUser1.setToolTipText("Editar Usuário");
        btnEditUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUser1ActionPerformed(evt);
            }
        });

        txtUserPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserPassword1ActionPerformed(evt);
            }
        });

        comboUserRole1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "administrador", "técnico", "atendente" }));
        comboUserRole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUserRole1ActionPerformed(evt);
            }
        });

        btnCreateUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/create.png"))); // NOI18N
        btnCreateUser1.setToolTipText("Adicionar Usuário");
        btnCreateUser1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCreateUser1.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCreateUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUser1ActionPerformed(evt);
            }
        });

        btnReadUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/read.png"))); // NOI18N
        btnReadUser1.setToolTipText("Consultar Usuário");
        btnReadUser1.setPreferredSize(new java.awt.Dimension(80, 80));
        btnReadUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadUser1ActionPerformed(evt);
            }
        });

        btnDeleteUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/delete.png"))); // NOI18N
        btnDeleteUser1.setToolTipText("Excluir Usuário");
        btnDeleteUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUser1ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboUserRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userName1)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel2))
                                .addGap(9, 9, 9)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(txtUserLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboUserProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtUserPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(txtIdUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCreateUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReadUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName1)
                    .addComponent(txtUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtUserLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtUserPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboUserRole1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboUserProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCreateUser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditUser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnReadUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setBackground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("* Campos Obrigatorios");

        btnUpdateClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/update.png"))); // NOI18N
        btnUpdateClient.setToolTipText("Editar Usuário");
        btnUpdateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateClientActionPerformed(evt);
            }
        });

        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClient);

        iconMagnifyingGlass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/io/github/paulinhocorazza/icons/pesquisar.png"))); // NOI18N
        iconMagnifyingGlass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMagnifyingGlassMouseClicked(evt);
            }
        });

        jLabel5.setText("* Telefone:");

        jLabel12.setText("E-mail:");

        jLabel3.setText("ID:");

        txtClientId.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userName)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(3, 3, 3)
                                        .addComponent(txtClientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtClientEmail))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtClientAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                            .addComponent(txtClientName, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(txtClientSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(iconMagnifyingGlass))
                                            .addComponent(txtClientId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnCreateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(btnDeleteClient, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(358, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(372, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtClientSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconMagnifyingGlass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userName)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtClientPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtClientEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDeleteClient, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(299, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(299, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 732, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void txtClientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClientNameActionPerformed

    private void btnCreateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateClientActionPerformed
        // TODO add your handling code here:
        createClient();
    }//GEN-LAST:event_btnCreateClientActionPerformed

    private void btnDeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClientActionPerformed
        // TODO add your handling code here:
        deleteClient();
    }//GEN-LAST:event_btnDeleteClientActionPerformed

    private void txtUserName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserName1ActionPerformed

    private void btnEditUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUser1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnEditUser1ActionPerformed

    private void txtUserPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserPassword1ActionPerformed

    private void comboUserRole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUserRole1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUserRole1ActionPerformed

    private void btnCreateUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateUser1ActionPerformed

    private void btnReadUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReadUser1ActionPerformed

    private void btnDeleteUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteUser1ActionPerformed

    private void btnUpdateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateClientActionPerformed
        // TODO add your handling code here:
        updateClient();
    }//GEN-LAST:event_btnUpdateClientActionPerformed

    private void txtClientSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClientSearchKeyReleased
        // TODO add your handling code here:
        //enquanto dor digitando 
        searchClient();
    }//GEN-LAST:event_txtClientSearchKeyReleased

    private void tblClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientMouseClicked
        // TODO add your handling code here:
        setFieldsFromTable();
    }//GEN-LAST:event_tblClientMouseClicked

    private void iconMagnifyingGlassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMagnifyingGlassMouseClicked
        // TODO add your handling code here:
        // searchClient();
    }//GEN-LAST:event_iconMagnifyingGlassMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateClient;
    private javax.swing.JButton btnCreateUser1;
    private javax.swing.JButton btnDeleteClient;
    private javax.swing.JButton btnDeleteUser1;
    private javax.swing.JButton btnEditUser1;
    private javax.swing.JButton btnReadUser1;
    private javax.swing.JButton btnUpdateClient;
    private javax.swing.JComboBox comboUserProfile1;
    private javax.swing.JComboBox comboUserRole1;
    private javax.swing.JLabel iconMagnifyingGlass;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClient;
    private javax.swing.JTextField txtClientAddress;
    private javax.swing.JTextField txtClientEmail;
    private javax.swing.JTextField txtClientId;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtClientPhoneNumber;
    private javax.swing.JTextField txtClientSearch;
    private javax.swing.JTextField txtIdUser1;
    private javax.swing.JTextField txtUserLogin1;
    private javax.swing.JTextField txtUserName1;
    private javax.swing.JPasswordField txtUserPassword1;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userName1;
    // End of variables declaration//GEN-END:variables
}
