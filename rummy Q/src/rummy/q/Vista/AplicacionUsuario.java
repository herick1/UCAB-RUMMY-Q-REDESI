/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rummy.q.Vista;

import comunicacion.Comunicacion;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import rummy.q.Modelo.Movimiento;
import rummy.q.Modelo.TableroVirtual;
import rummy.q.Modelo.Teclas;
    

/**
 *
 * @author herick
 */
public class AplicacionUsuario extends javax.swing.JFrame implements Cloneable {

    /**
     * Creates new form AplicacionUsuario
     */
    private TableroVirtual MiTablero= new TableroVirtual();
    private Movimiento miMovimiento =new Movimiento(this);
    public int Seleccionado_mouse ;
    public JButton BotonSeleccionado = new JButton();
    public JButton[] botonesPrincipales;
    public JPanel aux;
    public Comunicacion comuni;
    
    
    public AplicacionUsuario() {
        initComponents(); 
        Seleccionado_mouse=0;
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        for(String puerto: Comunicacion.listaPuertos()){
            jComboBox1.addItem(puerto);
            jComboBox2.addItem(puerto);
        }
        
    }
    

    public void ArrayBotonesPrincipales(){
        botonesPrincipales = new JButton[19];
       botonesPrincipales[0] = rackButton1;
       botonesPrincipales[1] = rackButton2;
       botonesPrincipales[2] = rackButton3;
       botonesPrincipales[3] = rackButton4;
       botonesPrincipales[4] = rackButton5;
       botonesPrincipales[5] = rackButton6;
       botonesPrincipales[6] = rackButton7;
       botonesPrincipales[7] = rackButton8;
       botonesPrincipales[8] = rackButton9;
       botonesPrincipales[9] = rackButton10;
       botonesPrincipales[10] = rackButton11;
       botonesPrincipales[11] = rackButton12;
       botonesPrincipales[12] = rackButton13;
       botonesPrincipales[13] = rackButton14;
       botonesPrincipales[14] = rackButton15;
       botonesPrincipales[15] = rackButton16;
       botonesPrincipales[16] = rackButton17;
       botonesPrincipales[17] = rackButton18;
       botonesPrincipales[18] = rackButton19;  
    }

    public void ArrayBotonesPrincipalesInverso(){
       rackButton1 =botonesPrincipales[0] ;
       rackButton2 = botonesPrincipales[1] ;
       rackButton3 = botonesPrincipales[2] ;
       rackButton4 = botonesPrincipales[3];
       rackButton5 = botonesPrincipales[4] ;
       rackButton6 = botonesPrincipales[5] ;
       rackButton7 = botonesPrincipales[6] ;
       rackButton8 = botonesPrincipales[7] ;
       rackButton9 = botonesPrincipales[8] ;
       rackButton10 = botonesPrincipales[9] ;
       rackButton11 = botonesPrincipales[10] ;
       rackButton12 = botonesPrincipales[11] ;
       rackButton13 = botonesPrincipales[12] ;
       rackButton14 = botonesPrincipales[13] ;
       rackButton15 = botonesPrincipales[14] ;
       rackButton16 = botonesPrincipales[15] ;
       rackButton17 = botonesPrincipales[16] ;
       rackButton18 = botonesPrincipales[17] ;
       rackButton19 = botonesPrincipales[18] ;  
    }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerate
     * d by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlPanel = new javax.swing.JPanel();
        rackButton8 = new javax.swing.JButton();
        instructionLabel = new javax.swing.JLabel();
        player1Label = new javax.swing.JLabel();
        player1Score = new javax.swing.JLabel();
        player2Label = new javax.swing.JLabel();
        player2Score = new javax.swing.JLabel();
        challengeButton = new javax.swing.JButton();
        player3ScoreLabel = new javax.swing.JLabel();
        player3ScoreLabel1 = new javax.swing.JLabel();
        player3Score1 = new javax.swing.JLabel();
        player4Score = new javax.swing.JLabel();
        rackButton1 = new javax.swing.JButton();
        rackButton9 = new javax.swing.JButton();
        rackButton2 = new javax.swing.JButton();
        rackButton10 = new javax.swing.JButton();
        rackButton11 = new javax.swing.JButton();
        rackButton4 = new javax.swing.JButton();
        rackButton12 = new javax.swing.JButton();
        rackButton5 = new javax.swing.JButton();
        rackButton6 = new javax.swing.JButton();
        rackButton13 = new javax.swing.JButton();
        rackButton14 = new javax.swing.JButton();
        rackButton7 = new javax.swing.JButton();
        rackButton3 = new javax.swing.JButton();
        player3ScoreLabel2 = new javax.swing.JLabel();
        player4Score1 = new javax.swing.JLabel();
        rackButton15 = new javax.swing.JButton();
        rackButton16 = new javax.swing.JButton();
        rackButton17 = new javax.swing.JButton();
        rackButton18 = new javax.swing.JButton();
        rackButton19 = new javax.swing.JButton();
        EndTurn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        challengeButton1 = new javax.swing.JButton();
        challengeButton2 = new javax.swing.JButton();
        LabelNumeroMaquina = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rackButton20 = new javax.swing.JButton();
        rackButton22 = new javax.swing.JButton();
        rackButton21 = new javax.swing.JButton();
        rackButton23 = new javax.swing.JButton();
        rackButton25 = new javax.swing.JButton();
        rackButton24 = new javax.swing.JButton();
        rackButton26 = new javax.swing.JButton();
        rackButton28 = new javax.swing.JButton();
        rackButton27 = new javax.swing.JButton();
        rackButton29 = new javax.swing.JButton();
        rackButton34 = new javax.swing.JButton();
        rackButton33 = new javax.swing.JButton();
        rackButton30 = new javax.swing.JButton();
        rackButton32 = new javax.swing.JButton();
        rackButton31 = new javax.swing.JButton();
        rackButton35 = new javax.swing.JButton();
        rackButton44 = new javax.swing.JButton();
        rackButton49 = new javax.swing.JButton();
        rackButton46 = new javax.swing.JButton();
        rackButton48 = new javax.swing.JButton();
        rackButton51 = new javax.swing.JButton();
        rackButton37 = new javax.swing.JButton();
        rackButton50 = new javax.swing.JButton();
        rackButton39 = new javax.swing.JButton();
        rackButton38 = new javax.swing.JButton();
        rackButton40 = new javax.swing.JButton();
        rackButton42 = new javax.swing.JButton();
        rackButton41 = new javax.swing.JButton();
        rackButton43 = new javax.swing.JButton();
        rackButton45 = new javax.swing.JButton();
        rackButton47 = new javax.swing.JButton();
        rackButton61 = new javax.swing.JButton();
        rackButton66 = new javax.swing.JButton();
        rackButton63 = new javax.swing.JButton();
        rackButton65 = new javax.swing.JButton();
        rackButton54 = new javax.swing.JButton();
        rackButton67 = new javax.swing.JButton();
        rackButton56 = new javax.swing.JButton();
        rackButton55 = new javax.swing.JButton();
        rackButton57 = new javax.swing.JButton();
        rackButton59 = new javax.swing.JButton();
        rackButton58 = new javax.swing.JButton();
        rackButton60 = new javax.swing.JButton();
        rackButton62 = new javax.swing.JButton();
        rackButton64 = new javax.swing.JButton();
        rackButton78 = new javax.swing.JButton();
        rackButton83 = new javax.swing.JButton();
        rackButton80 = new javax.swing.JButton();
        rackButton82 = new javax.swing.JButton();
        rackButton71 = new javax.swing.JButton();
        rackButton73 = new javax.swing.JButton();
        rackButton72 = new javax.swing.JButton();
        rackButton74 = new javax.swing.JButton();
        rackButton76 = new javax.swing.JButton();
        rackButton75 = new javax.swing.JButton();
        rackButton77 = new javax.swing.JButton();
        rackButton79 = new javax.swing.JButton();
        rackButton81 = new javax.swing.JButton();
        rackButton95 = new javax.swing.JButton();
        rackButton97 = new javax.swing.JButton();
        rackButton99 = new javax.swing.JButton();
        rackButton88 = new javax.swing.JButton();
        rackButton90 = new javax.swing.JButton();
        rackButton89 = new javax.swing.JButton();
        rackButton91 = new javax.swing.JButton();
        rackButton93 = new javax.swing.JButton();
        rackButton92 = new javax.swing.JButton();
        rackButton94 = new javax.swing.JButton();
        rackButton96 = new javax.swing.JButton();
        rackButton98 = new javax.swing.JButton();
        rackButton112 = new javax.swing.JButton();
        rackButton114 = new javax.swing.JButton();
        rackButton105 = new javax.swing.JButton();
        rackButton107 = new javax.swing.JButton();
        rackButton106 = new javax.swing.JButton();
        rackButton108 = new javax.swing.JButton();
        rackButton110 = new javax.swing.JButton();
        rackButton109 = new javax.swing.JButton();
        rackButton111 = new javax.swing.JButton();
        rackButton113 = new javax.swing.JButton();
        rackButton115 = new javax.swing.JButton();
        rackButton122 = new javax.swing.JButton();
        rackButton123 = new javax.swing.JButton();
        rackButton124 = new javax.swing.JButton();
        rackButton125 = new javax.swing.JButton();
        rackButton126 = new javax.swing.JButton();
        rackButton127 = new javax.swing.JButton();
        rackButton128 = new javax.swing.JButton();
        rackButton129 = new javax.swing.JButton();
        rackButton130 = new javax.swing.JButton();
        rackButton139 = new javax.swing.JButton();
        rackButton140 = new javax.swing.JButton();
        rackButton141 = new javax.swing.JButton();
        rackButton142 = new javax.swing.JButton();
        rackButton143 = new javax.swing.JButton();
        rackButton144 = new javax.swing.JButton();
        rackButton145 = new javax.swing.JButton();
        rackButton146 = new javax.swing.JButton();
        rackButton147 = new javax.swing.JButton();
        rackButton36 = new javax.swing.JButton();
        rackButton52 = new javax.swing.JButton();
        rackButton53 = new javax.swing.JButton();
        rackButton70 = new javax.swing.JButton();
        rackButton69 = new javax.swing.JButton();
        rackButton68 = new javax.swing.JButton();
        rackButton84 = new javax.swing.JButton();
        rackButton85 = new javax.swing.JButton();
        rackButton86 = new javax.swing.JButton();
        rackButton87 = new javax.swing.JButton();
        rackButton100 = new javax.swing.JButton();
        rackButton102 = new javax.swing.JButton();
        rackButton104 = new javax.swing.JButton();
        rackButton101 = new javax.swing.JButton();
        rackButton103 = new javax.swing.JButton();
        rackButton116 = new javax.swing.JButton();
        rackButton118 = new javax.swing.JButton();
        rackButton120 = new javax.swing.JButton();
        rackButton117 = new javax.swing.JButton();
        rackButton119 = new javax.swing.JButton();
        rackButton121 = new javax.swing.JButton();
        rackButton131 = new javax.swing.JButton();
        rackButton132 = new javax.swing.JButton();
        rackButton133 = new javax.swing.JButton();
        rackButton134 = new javax.swing.JButton();
        rackButton135 = new javax.swing.JButton();
        rackButton136 = new javax.swing.JButton();
        rackButton137 = new javax.swing.JButton();
        rackButton138 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(797, 754));

        controlPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        controlPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        controlPanel.setPreferredSize(new java.awt.Dimension(616, 151));

        rackButton8.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton8MousePressed(evt);
            }
        });
        rackButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton8ActionPerformed(evt);
            }
        });

        instructionLabel.setText("MAQUINA NUMERO :");

        player1Label.setText("Jugador 1 Fichas:");

        player1Score.setText("0");

        player2Label.setText("Jugador 2 Fichas::");

        player2Score.setText("0");

        challengeButton.setText("Agarrar Ficha(14 primeras)");
        challengeButton.setEnabled(false);
        challengeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                challengeButtonActionPerformed(evt);
            }
        });

        player3ScoreLabel.setText("Jugador 3 Fichas:");

        player3ScoreLabel1.setText("Jugador 4 Fichas:");

        player3Score1.setText("0");

        player4Score.setText("0");

        rackButton1.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                rackButton1MouseDragged(evt);
            }
        });
        rackButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton1MousePressed(evt);
            }
        });
        rackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton1ActionPerformed(evt);
            }
        });

        rackButton9.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton9MousePressed(evt);
            }
        });
        rackButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton9ActionPerformed(evt);
            }
        });

        rackButton2.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton2MousePressed(evt);
            }
        });
        rackButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton2ActionPerformed(evt);
            }
        });

        rackButton10.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton10MousePressed(evt);
            }
        });
        rackButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton10ActionPerformed(evt);
            }
        });

        rackButton11.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton11MousePressed(evt);
            }
        });
        rackButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton11ActionPerformed(evt);
            }
        });

        rackButton4.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton4MousePressed(evt);
            }
        });
        rackButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton4ActionPerformed(evt);
            }
        });

        rackButton12.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton12MousePressed(evt);
            }
        });
        rackButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton12ActionPerformed(evt);
            }
        });

        rackButton5.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton5MousePressed(evt);
            }
        });
        rackButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton5ActionPerformed(evt);
            }
        });

        rackButton6.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton6MousePressed(evt);
            }
        });
        rackButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton6ActionPerformed(evt);
            }
        });

        rackButton13.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton13MousePressed(evt);
            }
        });
        rackButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton13ActionPerformed(evt);
            }
        });

        rackButton14.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton14MousePressed(evt);
            }
        });
        rackButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton14ActionPerformed(evt);
            }
        });

        rackButton7.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton7MousePressed(evt);
            }
        });
        rackButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton7ActionPerformed(evt);
            }
        });

        rackButton3.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton3MousePressed(evt);
            }
        });
        rackButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton3ActionPerformed(evt);
            }
        });

        player3ScoreLabel2.setText("Fichas que Faltan ");

        player4Score1.setText("0");

        rackButton15.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton15MousePressed(evt);
            }
        });
        rackButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton15ActionPerformed(evt);
            }
        });

        rackButton16.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton16MousePressed(evt);
            }
        });
        rackButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton16ActionPerformed(evt);
            }
        });

        rackButton17.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton17MousePressed(evt);
            }
        });
        rackButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton17ActionPerformed(evt);
            }
        });

        rackButton18.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton18MousePressed(evt);
            }
        });
        rackButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton18ActionPerformed(evt);
            }
        });

        rackButton19.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton19MousePressed(evt);
            }
        });
        rackButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton19ActionPerformed(evt);
            }
        });

        EndTurn.setText("End Turn");
        EndTurn.setEnabled(false);
        EndTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndTurnActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setOpaque(false);

        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setOpaque(false);

        challengeButton1.setText("Comunicacion");
        challengeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                challengeButton1ActionPerformed(evt);
            }
        });

        challengeButton2.setText("Empezar Partida SOLO la maquina 00");
        challengeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                challengeButton2ActionPerformed(evt);
            }
        });

        LabelNumeroMaquina.setText("00");

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addComponent(rackButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rackButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(rackButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(rackButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rackButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(player4Score1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(rackButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox1, 0, 283, Short.MAX_VALUE)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(challengeButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(rackButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(challengeButton2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addComponent(rackButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rackButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EndTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player1Label)
                    .addComponent(player2Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(player2Score, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1Score, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(player3ScoreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player3Score1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(player3ScoreLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player4Score, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(player3ScoreLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(instructionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelNumeroMaquina))
                    .addComponent(challengeButton))
                .addGap(30, 30, 30))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1Label)
                    .addComponent(player1Score)
                    .addComponent(player3ScoreLabel)
                    .addComponent(player3Score1)
                    .addComponent(instructionLabel)
                    .addComponent(LabelNumeroMaquina))
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(player2Label)
                            .addComponent(player2Score)
                            .addComponent(player3ScoreLabel1)
                            .addComponent(player4Score)
                            .addComponent(player3ScoreLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(challengeButton)
                            .addComponent(EndTurn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rackButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rackButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rackButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, controlPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rackButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rackButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(challengeButton1)
                                .addComponent(challengeButton2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player4Score1))
        );

        rackButton20.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton20MousePressed(evt);
            }
        });
        rackButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton20ActionPerformed(evt);
            }
        });

        rackButton22.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton22MousePressed(evt);
            }
        });
        rackButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton22ActionPerformed(evt);
            }
        });

        rackButton21.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton21MousePressed(evt);
            }
        });
        rackButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton21ActionPerformed(evt);
            }
        });

        rackButton23.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton23MousePressed(evt);
            }
        });
        rackButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton23ActionPerformed(evt);
            }
        });

        rackButton25.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton25MousePressed(evt);
            }
        });
        rackButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton25ActionPerformed(evt);
            }
        });

        rackButton24.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton24MousePressed(evt);
            }
        });
        rackButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton24ActionPerformed(evt);
            }
        });

        rackButton26.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton26MousePressed(evt);
            }
        });
        rackButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton26ActionPerformed(evt);
            }
        });

        rackButton28.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton28MousePressed(evt);
            }
        });
        rackButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton28ActionPerformed(evt);
            }
        });

        rackButton27.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton27MousePressed(evt);
            }
        });
        rackButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton27ActionPerformed(evt);
            }
        });

        rackButton29.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton29MousePressed(evt);
            }
        });
        rackButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton29ActionPerformed(evt);
            }
        });

        rackButton34.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton34MousePressed(evt);
            }
        });
        rackButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton34ActionPerformed(evt);
            }
        });

        rackButton33.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton33MousePressed(evt);
            }
        });
        rackButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton33ActionPerformed(evt);
            }
        });

        rackButton30.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton30MousePressed(evt);
            }
        });
        rackButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton30ActionPerformed(evt);
            }
        });

        rackButton32.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton32MousePressed(evt);
            }
        });
        rackButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton32ActionPerformed(evt);
            }
        });

        rackButton31.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton31MousePressed(evt);
            }
        });
        rackButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton31ActionPerformed(evt);
            }
        });

        rackButton35.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton35MousePressed(evt);
            }
        });
        rackButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton35ActionPerformed(evt);
            }
        });

        rackButton44.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton44MousePressed(evt);
            }
        });
        rackButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton44ActionPerformed(evt);
            }
        });

        rackButton49.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton49MousePressed(evt);
            }
        });
        rackButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton49ActionPerformed(evt);
            }
        });

        rackButton46.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton46MousePressed(evt);
            }
        });
        rackButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton46ActionPerformed(evt);
            }
        });

        rackButton48.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton48MousePressed(evt);
            }
        });
        rackButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton48ActionPerformed(evt);
            }
        });

        rackButton51.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton51MousePressed(evt);
            }
        });
        rackButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton51ActionPerformed(evt);
            }
        });

        rackButton37.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton37MousePressed(evt);
            }
        });
        rackButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton37ActionPerformed(evt);
            }
        });

        rackButton50.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton50MousePressed(evt);
            }
        });
        rackButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton50ActionPerformed(evt);
            }
        });

        rackButton39.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton39MousePressed(evt);
            }
        });
        rackButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton39ActionPerformed(evt);
            }
        });

        rackButton38.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton38MousePressed(evt);
            }
        });
        rackButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton38ActionPerformed(evt);
            }
        });

        rackButton40.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton40MousePressed(evt);
            }
        });
        rackButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton40ActionPerformed(evt);
            }
        });

        rackButton42.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton42MousePressed(evt);
            }
        });
        rackButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton42ActionPerformed(evt);
            }
        });

        rackButton41.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton41MousePressed(evt);
            }
        });
        rackButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton41ActionPerformed(evt);
            }
        });

        rackButton43.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton43MousePressed(evt);
            }
        });
        rackButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton43ActionPerformed(evt);
            }
        });

        rackButton45.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton45MousePressed(evt);
            }
        });
        rackButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton45ActionPerformed(evt);
            }
        });

        rackButton47.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton47MousePressed(evt);
            }
        });
        rackButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton47ActionPerformed(evt);
            }
        });

        rackButton61.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton61MousePressed(evt);
            }
        });
        rackButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton61ActionPerformed(evt);
            }
        });

        rackButton66.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton66MousePressed(evt);
            }
        });
        rackButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton66ActionPerformed(evt);
            }
        });

        rackButton63.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton63MousePressed(evt);
            }
        });
        rackButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton63ActionPerformed(evt);
            }
        });

        rackButton65.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton65MousePressed(evt);
            }
        });
        rackButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton65ActionPerformed(evt);
            }
        });

        rackButton54.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton54MousePressed(evt);
            }
        });
        rackButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton54ActionPerformed(evt);
            }
        });

        rackButton67.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton67MousePressed(evt);
            }
        });
        rackButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton67ActionPerformed(evt);
            }
        });

        rackButton56.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton56MousePressed(evt);
            }
        });
        rackButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton56ActionPerformed(evt);
            }
        });

        rackButton55.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton55MousePressed(evt);
            }
        });
        rackButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton55ActionPerformed(evt);
            }
        });

        rackButton57.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton57MousePressed(evt);
            }
        });
        rackButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton57ActionPerformed(evt);
            }
        });

        rackButton59.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton59MousePressed(evt);
            }
        });
        rackButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton59ActionPerformed(evt);
            }
        });

        rackButton58.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton58MousePressed(evt);
            }
        });
        rackButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton58ActionPerformed(evt);
            }
        });

        rackButton60.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton60MousePressed(evt);
            }
        });
        rackButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton60ActionPerformed(evt);
            }
        });

        rackButton62.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton62MousePressed(evt);
            }
        });
        rackButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton62ActionPerformed(evt);
            }
        });

        rackButton64.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton64MousePressed(evt);
            }
        });
        rackButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton64ActionPerformed(evt);
            }
        });

        rackButton78.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton78MousePressed(evt);
            }
        });
        rackButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton78ActionPerformed(evt);
            }
        });

        rackButton83.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton83MousePressed(evt);
            }
        });
        rackButton83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton83ActionPerformed(evt);
            }
        });

        rackButton80.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton80MousePressed(evt);
            }
        });
        rackButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton80ActionPerformed(evt);
            }
        });

        rackButton82.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton82MousePressed(evt);
            }
        });
        rackButton82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton82ActionPerformed(evt);
            }
        });

        rackButton71.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton71MousePressed(evt);
            }
        });
        rackButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton71ActionPerformed(evt);
            }
        });

        rackButton73.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton73MousePressed(evt);
            }
        });
        rackButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton73ActionPerformed(evt);
            }
        });

        rackButton72.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton72MousePressed(evt);
            }
        });
        rackButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton72ActionPerformed(evt);
            }
        });

        rackButton74.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton74MousePressed(evt);
            }
        });
        rackButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton74ActionPerformed(evt);
            }
        });

        rackButton76.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton76MousePressed(evt);
            }
        });
        rackButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton76ActionPerformed(evt);
            }
        });

        rackButton75.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton75MousePressed(evt);
            }
        });
        rackButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton75ActionPerformed(evt);
            }
        });

        rackButton77.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton77MousePressed(evt);
            }
        });
        rackButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton77ActionPerformed(evt);
            }
        });

        rackButton79.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton79MousePressed(evt);
            }
        });
        rackButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton79ActionPerformed(evt);
            }
        });

        rackButton81.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton81MousePressed(evt);
            }
        });
        rackButton81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton81ActionPerformed(evt);
            }
        });

        rackButton95.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton95MousePressed(evt);
            }
        });
        rackButton95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton95ActionPerformed(evt);
            }
        });

        rackButton97.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton97MousePressed(evt);
            }
        });
        rackButton97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton97ActionPerformed(evt);
            }
        });

        rackButton99.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton99MousePressed(evt);
            }
        });
        rackButton99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton99ActionPerformed(evt);
            }
        });

        rackButton88.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton88MousePressed(evt);
            }
        });
        rackButton88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton88ActionPerformed(evt);
            }
        });

        rackButton90.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton90MousePressed(evt);
            }
        });
        rackButton90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton90ActionPerformed(evt);
            }
        });

        rackButton89.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton89MousePressed(evt);
            }
        });
        rackButton89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton89ActionPerformed(evt);
            }
        });

        rackButton91.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton91MousePressed(evt);
            }
        });
        rackButton91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton91ActionPerformed(evt);
            }
        });

        rackButton93.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton93MousePressed(evt);
            }
        });
        rackButton93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton93ActionPerformed(evt);
            }
        });

        rackButton92.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton92MousePressed(evt);
            }
        });
        rackButton92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton92ActionPerformed(evt);
            }
        });

        rackButton94.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton94MousePressed(evt);
            }
        });
        rackButton94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton94ActionPerformed(evt);
            }
        });

        rackButton96.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton96MousePressed(evt);
            }
        });
        rackButton96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton96ActionPerformed(evt);
            }
        });

        rackButton98.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton98MousePressed(evt);
            }
        });
        rackButton98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton98ActionPerformed(evt);
            }
        });

        rackButton112.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton112MousePressed(evt);
            }
        });
        rackButton112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton112ActionPerformed(evt);
            }
        });

        rackButton114.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton114MousePressed(evt);
            }
        });
        rackButton114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton114ActionPerformed(evt);
            }
        });

        rackButton105.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton105MousePressed(evt);
            }
        });
        rackButton105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton105ActionPerformed(evt);
            }
        });

        rackButton107.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton107MousePressed(evt);
            }
        });
        rackButton107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton107ActionPerformed(evt);
            }
        });

        rackButton106.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton106MousePressed(evt);
            }
        });
        rackButton106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton106ActionPerformed(evt);
            }
        });

        rackButton108.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton108MousePressed(evt);
            }
        });
        rackButton108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton108ActionPerformed(evt);
            }
        });

        rackButton110.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton110MousePressed(evt);
            }
        });
        rackButton110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton110ActionPerformed(evt);
            }
        });

        rackButton109.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton109MousePressed(evt);
            }
        });
        rackButton109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton109ActionPerformed(evt);
            }
        });

        rackButton111.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton111MousePressed(evt);
            }
        });
        rackButton111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton111ActionPerformed(evt);
            }
        });

        rackButton113.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton113MousePressed(evt);
            }
        });
        rackButton113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton113ActionPerformed(evt);
            }
        });

        rackButton115.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton115MousePressed(evt);
            }
        });
        rackButton115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton115ActionPerformed(evt);
            }
        });

        rackButton122.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton122MousePressed(evt);
            }
        });
        rackButton122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton122ActionPerformed(evt);
            }
        });

        rackButton123.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton123MousePressed(evt);
            }
        });
        rackButton123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton123ActionPerformed(evt);
            }
        });

        rackButton124.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton124.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton124MousePressed(evt);
            }
        });
        rackButton124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton124ActionPerformed(evt);
            }
        });

        rackButton125.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton125.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton125MousePressed(evt);
            }
        });
        rackButton125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton125ActionPerformed(evt);
            }
        });

        rackButton126.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton126MousePressed(evt);
            }
        });
        rackButton126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton126ActionPerformed(evt);
            }
        });

        rackButton127.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton127MousePressed(evt);
            }
        });
        rackButton127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton127ActionPerformed(evt);
            }
        });

        rackButton128.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton128MousePressed(evt);
            }
        });
        rackButton128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton128ActionPerformed(evt);
            }
        });

        rackButton129.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton129.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton129MousePressed(evt);
            }
        });
        rackButton129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton129ActionPerformed(evt);
            }
        });

        rackButton130.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton130.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton130MousePressed(evt);
            }
        });
        rackButton130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton130ActionPerformed(evt);
            }
        });

        rackButton139.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton139.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton139MousePressed(evt);
            }
        });
        rackButton139.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton139ActionPerformed(evt);
            }
        });

        rackButton140.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton140.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton140MousePressed(evt);
            }
        });
        rackButton140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton140ActionPerformed(evt);
            }
        });

        rackButton141.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton141.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton141MousePressed(evt);
            }
        });
        rackButton141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton141ActionPerformed(evt);
            }
        });

        rackButton142.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton142.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton142MousePressed(evt);
            }
        });
        rackButton142.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton142ActionPerformed(evt);
            }
        });

        rackButton143.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton143.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton143MousePressed(evt);
            }
        });
        rackButton143.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton143ActionPerformed(evt);
            }
        });

        rackButton144.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton144.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton144MousePressed(evt);
            }
        });
        rackButton144.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton144ActionPerformed(evt);
            }
        });

        rackButton145.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton145.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton145MousePressed(evt);
            }
        });
        rackButton145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton145ActionPerformed(evt);
            }
        });

        rackButton146.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton146.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton146MousePressed(evt);
            }
        });
        rackButton146.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton146ActionPerformed(evt);
            }
        });

        rackButton147.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton147.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton147MousePressed(evt);
            }
        });
        rackButton147.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton147ActionPerformed(evt);
            }
        });

        rackButton36.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton36MousePressed(evt);
            }
        });
        rackButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton36ActionPerformed(evt);
            }
        });

        rackButton52.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton52MousePressed(evt);
            }
        });
        rackButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton52ActionPerformed(evt);
            }
        });

        rackButton53.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton53MousePressed(evt);
            }
        });
        rackButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton53ActionPerformed(evt);
            }
        });

        rackButton70.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton70MousePressed(evt);
            }
        });
        rackButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton70ActionPerformed(evt);
            }
        });

        rackButton69.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton69MousePressed(evt);
            }
        });
        rackButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton69ActionPerformed(evt);
            }
        });

        rackButton68.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton68MousePressed(evt);
            }
        });
        rackButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton68ActionPerformed(evt);
            }
        });

        rackButton84.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton84MousePressed(evt);
            }
        });
        rackButton84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton84ActionPerformed(evt);
            }
        });

        rackButton85.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton85MousePressed(evt);
            }
        });
        rackButton85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton85ActionPerformed(evt);
            }
        });

        rackButton86.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton86MousePressed(evt);
            }
        });
        rackButton86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton86ActionPerformed(evt);
            }
        });

        rackButton87.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton87MousePressed(evt);
            }
        });
        rackButton87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton87ActionPerformed(evt);
            }
        });

        rackButton100.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton100MousePressed(evt);
            }
        });
        rackButton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton100ActionPerformed(evt);
            }
        });

        rackButton102.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton102MousePressed(evt);
            }
        });
        rackButton102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton102ActionPerformed(evt);
            }
        });

        rackButton104.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton104MousePressed(evt);
            }
        });
        rackButton104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton104ActionPerformed(evt);
            }
        });

        rackButton101.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton101MousePressed(evt);
            }
        });
        rackButton101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton101ActionPerformed(evt);
            }
        });

        rackButton103.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton103MousePressed(evt);
            }
        });
        rackButton103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton103ActionPerformed(evt);
            }
        });

        rackButton116.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton116MousePressed(evt);
            }
        });
        rackButton116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton116ActionPerformed(evt);
            }
        });

        rackButton118.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton118MousePressed(evt);
            }
        });
        rackButton118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton118ActionPerformed(evt);
            }
        });

        rackButton120.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton120MousePressed(evt);
            }
        });
        rackButton120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton120ActionPerformed(evt);
            }
        });

        rackButton117.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton117MousePressed(evt);
            }
        });
        rackButton117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton117ActionPerformed(evt);
            }
        });

        rackButton119.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton119MousePressed(evt);
            }
        });
        rackButton119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton119ActionPerformed(evt);
            }
        });

        rackButton121.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton121MousePressed(evt);
            }
        });
        rackButton121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton121ActionPerformed(evt);
            }
        });

        rackButton131.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton131MousePressed(evt);
            }
        });
        rackButton131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton131ActionPerformed(evt);
            }
        });

        rackButton132.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton132MousePressed(evt);
            }
        });
        rackButton132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton132ActionPerformed(evt);
            }
        });

        rackButton133.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton133.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton133MousePressed(evt);
            }
        });
        rackButton133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton133ActionPerformed(evt);
            }
        });

        rackButton134.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton134.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton134MousePressed(evt);
            }
        });
        rackButton134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton134ActionPerformed(evt);
            }
        });

        rackButton135.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton135.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton135MousePressed(evt);
            }
        });
        rackButton135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton135ActionPerformed(evt);
            }
        });

        rackButton136.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton136.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton136MousePressed(evt);
            }
        });
        rackButton136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton136ActionPerformed(evt);
            }
        });

        rackButton137.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton137.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton137MousePressed(evt);
            }
        });
        rackButton137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton137ActionPerformed(evt);
            }
        });

        rackButton138.setPreferredSize(new java.awt.Dimension(80, 62));
        rackButton138.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rackButton138MousePressed(evt);
            }
        });
        rackButton138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rackButton138ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton116, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton118, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton119, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton120, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton121, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton122, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton123, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton124, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton125, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton126, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton127, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton128, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton129, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton130, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton131, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton132, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton133, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton134, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton135, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton136, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton137, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton138, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rackButton139, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton140, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton141, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton142, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton143, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton144, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton145, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton146, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton147, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rackButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rackButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rackButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rackButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton106, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton111, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton112, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton114, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rackButton115, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton87, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton106, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton111, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton112, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton114, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton115, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton122, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton123, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton124, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton125, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton126, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton127, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton128, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton129, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton130, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton116, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton119, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton118, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton120, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton121, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton131, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rackButton139, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton140, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton141, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton142, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton143, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton144, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton145, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton146, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton147, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton132, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton133, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton134, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton135, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton136, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton137, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rackButton138, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rackButton20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton20MousePressed
        // TODO add your handling code here:
       miMovimiento.BotonPresionado(evt,rackButton20);
    }//GEN-LAST:event_rackButton20MousePressed

    private void rackButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton20ActionPerformed

    private void rackButton22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton22MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton22);
    }//GEN-LAST:event_rackButton22MousePressed

    private void rackButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton22ActionPerformed

    private void rackButton21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton21MousePressed
        // TODO add your handling code here:
               miMovimiento.BotonPresionado(evt,rackButton21);
    }//GEN-LAST:event_rackButton21MousePressed

    private void rackButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton21ActionPerformed

    private void rackButton23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton23MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton23);
    }//GEN-LAST:event_rackButton23MousePressed

    private void rackButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton23ActionPerformed

    private void rackButton25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton25MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton25);
    }//GEN-LAST:event_rackButton25MousePressed

    private void rackButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton25ActionPerformed

    private void rackButton24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton24MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton24);
    }//GEN-LAST:event_rackButton24MousePressed

    private void rackButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton24ActionPerformed

    private void rackButton26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton26MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton26);
    }//GEN-LAST:event_rackButton26MousePressed

    private void rackButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton26ActionPerformed

    private void rackButton28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton28MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton28);
    }//GEN-LAST:event_rackButton28MousePressed

    private void rackButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton28ActionPerformed

    private void rackButton27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton27MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton27);
    }//GEN-LAST:event_rackButton27MousePressed

    private void rackButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton27ActionPerformed

    private void rackButton29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton29MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton29);
    }//GEN-LAST:event_rackButton29MousePressed

    private void rackButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton29ActionPerformed

    private void rackButton34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton34MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton34);
    }//GEN-LAST:event_rackButton34MousePressed

    private void rackButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton34ActionPerformed

    private void rackButton33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton33MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton33);
    }//GEN-LAST:event_rackButton33MousePressed

    private void rackButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton33ActionPerformed

    private void rackButton30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton30MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton30);
    }//GEN-LAST:event_rackButton30MousePressed

    private void rackButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton30ActionPerformed

    private void rackButton32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton32MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton32);
    }//GEN-LAST:event_rackButton32MousePressed

    private void rackButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton32ActionPerformed

    private void rackButton31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton31MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton31);
    }//GEN-LAST:event_rackButton31MousePressed

    private void rackButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton31ActionPerformed

    private void rackButton36MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton36MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton36);
    }//GEN-LAST:event_rackButton36MousePressed

    private void rackButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton36ActionPerformed

    private void rackButton35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton35MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton35);
    }//GEN-LAST:event_rackButton35MousePressed

    private void rackButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton35ActionPerformed

    private void rackButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton87ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton87ActionPerformed

    private void rackButton87MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton87MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton87);
    }//GEN-LAST:event_rackButton87MousePressed

    private void rackButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton71ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton71ActionPerformed

    private void rackButton71MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton71MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton71);
    }//GEN-LAST:event_rackButton71MousePressed

    private void rackButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton85ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton85ActionPerformed

    private void rackButton85MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton85MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton85);
    }//GEN-LAST:event_rackButton85MousePressed

    private void rackButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton82ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton82ActionPerformed

    private void rackButton82MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton82MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton82);
    }//GEN-LAST:event_rackButton82MousePressed

    private void rackButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton80ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton80ActionPerformed

    private void rackButton80MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton80MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton80);
    }//GEN-LAST:event_rackButton80MousePressed

    private void rackButton91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton91ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton91ActionPerformed

    private void rackButton91MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton91MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton91);
    }//GEN-LAST:event_rackButton91MousePressed

    private void rackButton83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton83ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton83ActionPerformed

    private void rackButton83MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton83MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton83);
    }//GEN-LAST:event_rackButton83MousePressed

    private void rackButton89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton89ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton89ActionPerformed

    private void rackButton89MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton89MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton89);
    }//GEN-LAST:event_rackButton89MousePressed

    private void rackButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton78ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton78ActionPerformed

    private void rackButton78MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton78MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton78);
    }//GEN-LAST:event_rackButton78MousePressed

    private void rackButton90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton90ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton90ActionPerformed

    private void rackButton90MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton90MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton90);
    }//GEN-LAST:event_rackButton90MousePressed

    private void rackButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton64ActionPerformed

    private void rackButton64MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton64MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton64);
    }//GEN-LAST:event_rackButton64MousePressed

    private void rackButton103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton103ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton103ActionPerformed

    private void rackButton103MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton103MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton103);
    }//GEN-LAST:event_rackButton103MousePressed

    private void rackButton101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton101ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton101ActionPerformed

    private void rackButton101MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton101MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton101);
    }//GEN-LAST:event_rackButton101MousePressed

    private void rackButton104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton104ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton104ActionPerformed

    private void rackButton104MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton104MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton104);
    }//GEN-LAST:event_rackButton104MousePressed

    private void rackButton88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton88ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton88ActionPerformed

    private void rackButton88MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton88MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton88);
    }//GEN-LAST:event_rackButton88MousePressed

    private void rackButton102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton102ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton102ActionPerformed

    private void rackButton102MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton102MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton102);
    }//GEN-LAST:event_rackButton102MousePressed

    private void rackButton99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton99ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton99ActionPerformed

    private void rackButton99MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton99MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton99);
    }//GEN-LAST:event_rackButton99MousePressed

    private void rackButton97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton97ActionPerformed
        // TODO add your handling code here:       
    }//GEN-LAST:event_rackButton97ActionPerformed

    private void rackButton97MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton97MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton97);
    }//GEN-LAST:event_rackButton97MousePressed

    private void rackButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton62ActionPerformed

    private void rackButton62MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton62MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton62);
    }//GEN-LAST:event_rackButton62MousePressed

    private void rackButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton60ActionPerformed

    private void rackButton60MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton60MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton60);
    }//GEN-LAST:event_rackButton60MousePressed

    private void rackButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton58ActionPerformed

    private void rackButton58MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton58MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton58);
    }//GEN-LAST:event_rackButton58MousePressed

    private void rackButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton59ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton59ActionPerformed

    private void rackButton59MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton59MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton59);
    }//GEN-LAST:event_rackButton59MousePressed

    private void rackButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton57ActionPerformed

    private void rackButton57MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton57MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton57);
    }//GEN-LAST:event_rackButton57MousePressed

    private void rackButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton55ActionPerformed

    private void rackButton55MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton55MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton55);
    }//GEN-LAST:event_rackButton55MousePressed

    private void rackButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton56ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton56ActionPerformed

    private void rackButton56MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton56MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton56);
    }//GEN-LAST:event_rackButton56MousePressed

    private void rackButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton69ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton69ActionPerformed

    private void rackButton69MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton69MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton69);
    }//GEN-LAST:event_rackButton69MousePressed

    private void rackButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton67ActionPerformed

    private void rackButton67MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton67MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton67);
    }//GEN-LAST:event_rackButton67MousePressed

    private void rackButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton70ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton70ActionPerformed

    private void rackButton70MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton70MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton70);
    }//GEN-LAST:event_rackButton70MousePressed

    private void rackButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton54ActionPerformed

    private void rackButton54MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton54MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton54);
    }//GEN-LAST:event_rackButton54MousePressed

    private void rackButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton68ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton68ActionPerformed

    private void rackButton68MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton68MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton68);
    }//GEN-LAST:event_rackButton68MousePressed

    private void rackButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton65ActionPerformed

    private void rackButton65MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton65MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton65);
    }//GEN-LAST:event_rackButton65MousePressed

    private void rackButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton63ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton63ActionPerformed

    private void rackButton63MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton63MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton63);
    }//GEN-LAST:event_rackButton63MousePressed

    private void rackButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton66ActionPerformed

    private void rackButton66MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton66MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton66);
    }//GEN-LAST:event_rackButton66MousePressed

    private void rackButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton61ActionPerformed

    private void rackButton61MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton61MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton61);
    }//GEN-LAST:event_rackButton61MousePressed

    private void rackButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton47ActionPerformed

    private void rackButton47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton47MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton47);
    }//GEN-LAST:event_rackButton47MousePressed

    private void rackButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton45ActionPerformed

    private void rackButton45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton45MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton45);
    }//GEN-LAST:event_rackButton45MousePressed

    private void rackButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton43ActionPerformed

    private void rackButton43MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton43MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton43);
    }//GEN-LAST:event_rackButton43MousePressed

    private void rackButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton41ActionPerformed

    private void rackButton41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton41MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton41);
    }//GEN-LAST:event_rackButton41MousePressed

    private void rackButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton42ActionPerformed

    private void rackButton42MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton42MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton42);
    }//GEN-LAST:event_rackButton42MousePressed

    private void rackButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton40ActionPerformed

    private void rackButton40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton40MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton40);
    }//GEN-LAST:event_rackButton40MousePressed

    private void rackButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton38ActionPerformed

    private void rackButton38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton38MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton38);
    }//GEN-LAST:event_rackButton38MousePressed

    private void rackButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton39ActionPerformed

    private void rackButton39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton39MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton39);
    }//GEN-LAST:event_rackButton39MousePressed

    private void rackButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton52ActionPerformed

    private void rackButton52MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton52MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton52);
    }//GEN-LAST:event_rackButton52MousePressed

    private void rackButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton50ActionPerformed

    private void rackButton50MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton50MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton50);
    }//GEN-LAST:event_rackButton50MousePressed

    private void rackButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton53ActionPerformed

    private void rackButton53MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton53MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton53);
    }//GEN-LAST:event_rackButton53MousePressed

    private void rackButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton37ActionPerformed

    private void rackButton37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton37MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton37);
    }//GEN-LAST:event_rackButton37MousePressed

    private void rackButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton51ActionPerformed

    private void rackButton51MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton51MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton51);
    }//GEN-LAST:event_rackButton51MousePressed

    private void rackButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton48ActionPerformed

    private void rackButton48MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton48MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton48);
    }//GEN-LAST:event_rackButton48MousePressed

    private void rackButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton46ActionPerformed

    private void rackButton46MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton46MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton46);
    }//GEN-LAST:event_rackButton46MousePressed

    private void rackButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton49ActionPerformed

    private void rackButton49MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton49MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton49);
    }//GEN-LAST:event_rackButton49MousePressed

    private void rackButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton44ActionPerformed

    private void rackButton44MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton44MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton44);
    }//GEN-LAST:event_rackButton44MousePressed

    private void rackButton115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton115ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton115ActionPerformed

    private void rackButton115MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton115MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton115);
    }//GEN-LAST:event_rackButton115MousePressed

    private void rackButton113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton113ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton113ActionPerformed

    private void rackButton113MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton113MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton113);
    }//GEN-LAST:event_rackButton113MousePressed

    private void rackButton111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton111ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton111ActionPerformed

    private void rackButton111MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton111MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton111);
    }//GEN-LAST:event_rackButton111MousePressed

    private void rackButton109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton109ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton109ActionPerformed

    private void rackButton109MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton109MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton109);
    }//GEN-LAST:event_rackButton109MousePressed

    private void rackButton110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton110ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton110ActionPerformed

    private void rackButton110MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton110MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton110);
    }//GEN-LAST:event_rackButton110MousePressed

    private void rackButton108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton108ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton108ActionPerformed

    private void rackButton108MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton108MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton108);
    }//GEN-LAST:event_rackButton108MousePressed

    private void rackButton106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton106ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton106ActionPerformed

    private void rackButton106MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton106MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton106);
    }//GEN-LAST:event_rackButton106MousePressed

    private void rackButton107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton107ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton107ActionPerformed

    private void rackButton107MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton107MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton107);
    }//GEN-LAST:event_rackButton107MousePressed

    private void rackButton120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton120ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton120ActionPerformed

    private void rackButton120MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton120MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton120);
    }//GEN-LAST:event_rackButton120MousePressed

    private void rackButton118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton118ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton118ActionPerformed

    private void rackButton118MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton118MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton118);
    }//GEN-LAST:event_rackButton118MousePressed

    private void rackButton121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton121ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton121ActionPerformed

    private void rackButton121MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton121MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton121);
    }//GEN-LAST:event_rackButton121MousePressed

    private void rackButton105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton105ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton105ActionPerformed

    private void rackButton105MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton105MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton105);
    }//GEN-LAST:event_rackButton105MousePressed

    private void rackButton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton100ActionPerformed

    private void rackButton100MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton100MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton100);
    }//GEN-LAST:event_rackButton100MousePressed

    private void rackButton95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton95ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton95ActionPerformed

    private void rackButton95MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton95MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton95);
    }//GEN-LAST:event_rackButton95MousePressed

    private void rackButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton81ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton81ActionPerformed

    private void rackButton81MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton81MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton81);
    }//GEN-LAST:event_rackButton81MousePressed

    private void rackButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton79ActionPerformed
        // TODO add your handling code here:      
    }//GEN-LAST:event_rackButton79ActionPerformed

    private void rackButton79MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton79MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton79);
    }//GEN-LAST:event_rackButton79MousePressed

    private void rackButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton77ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton77ActionPerformed

    private void rackButton77MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton77MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton77);
    }//GEN-LAST:event_rackButton77MousePressed

    private void rackButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton75ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton75ActionPerformed

    private void rackButton75MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton75MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton75);
    }//GEN-LAST:event_rackButton75MousePressed

    private void rackButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton76ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton76ActionPerformed

    private void rackButton76MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton76MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton76);
    }//GEN-LAST:event_rackButton76MousePressed

    private void rackButton119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton119ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton119ActionPerformed

    private void rackButton119MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton119MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton119);
    }//GEN-LAST:event_rackButton119MousePressed

    private void rackButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton74ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton74ActionPerformed

    private void rackButton74MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton74MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton74);
    }//GEN-LAST:event_rackButton74MousePressed

    private void rackButton116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton116ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton116ActionPerformed

    private void rackButton116MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton116MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton116);
    }//GEN-LAST:event_rackButton116MousePressed

    private void rackButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton72ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton72ActionPerformed

    private void rackButton72MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton72MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton72);
    }//GEN-LAST:event_rackButton72MousePressed

    private void rackButton114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton114ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton114ActionPerformed

    private void rackButton114MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton114MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton114);
    }//GEN-LAST:event_rackButton114MousePressed

    private void rackButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton73ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton73ActionPerformed

    private void rackButton73MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton73MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton73);
    }//GEN-LAST:event_rackButton73MousePressed

    private void rackButton117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton117ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton117ActionPerformed

    private void rackButton117MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton117MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton117);
    }//GEN-LAST:event_rackButton117MousePressed

    private void rackButton112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton112ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton112ActionPerformed

    private void rackButton112MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton112MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton112);
    }//GEN-LAST:event_rackButton112MousePressed

    private void rackButton98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton98ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton98ActionPerformed

    private void rackButton98MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton98MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton98);
    }//GEN-LAST:event_rackButton98MousePressed

    private void rackButton96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton96ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton96ActionPerformed

    private void rackButton96MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton96MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton96);
    }//GEN-LAST:event_rackButton96MousePressed

    private void rackButton94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton94ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton94ActionPerformed

    private void rackButton94MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton94MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton94);
    }//GEN-LAST:event_rackButton94MousePressed

    private void rackButton92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton92ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton92ActionPerformed

    private void rackButton92MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton92MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton92);
    }//GEN-LAST:event_rackButton92MousePressed

    private void rackButton93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton93ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton93ActionPerformed

    private void rackButton93MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton93MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton93);
    }//GEN-LAST:event_rackButton93MousePressed

    private void rackButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton86ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton86ActionPerformed

    private void rackButton86MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton86MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton86);
    }//GEN-LAST:event_rackButton86MousePressed

    private void rackButton84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton84ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton84ActionPerformed

    private void rackButton84MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton84MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton84);
    }//GEN-LAST:event_rackButton84MousePressed

    private void rackButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton19ActionPerformed

    private void rackButton19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton19MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton19);
    }//GEN-LAST:event_rackButton19MousePressed

    private void rackButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton18ActionPerformed

    private void rackButton18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton18MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton18);
    }//GEN-LAST:event_rackButton18MousePressed

    private void rackButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton17ActionPerformed

    private void rackButton17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton17MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton17);
    }//GEN-LAST:event_rackButton17MousePressed

    private void rackButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton16ActionPerformed

    private void rackButton16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton16MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton16);
    }//GEN-LAST:event_rackButton16MousePressed

    private void rackButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton15ActionPerformed

    private void rackButton15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton15MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton15);
    }//GEN-LAST:event_rackButton15MousePressed

    private void rackButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton3ActionPerformed

    private void rackButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton3MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton3);
    }//GEN-LAST:event_rackButton3MousePressed

    private void rackButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton7ActionPerformed

    private void rackButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton7MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton7);
    }//GEN-LAST:event_rackButton7MousePressed

    private void rackButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton14ActionPerformed

    private void rackButton14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton14MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton14);
    }//GEN-LAST:event_rackButton14MousePressed

    private void rackButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton13ActionPerformed

    private void rackButton13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton13MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton13);
    }//GEN-LAST:event_rackButton13MousePressed

    private void rackButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton6ActionPerformed

    private void rackButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton6MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton6);
    }//GEN-LAST:event_rackButton6MousePressed

    private void rackButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton5ActionPerformed

    private void rackButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton5MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton5);
    }//GEN-LAST:event_rackButton5MousePressed

    private void rackButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton12ActionPerformed

    private void rackButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton12MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton12);
    }//GEN-LAST:event_rackButton12MousePressed

    private void rackButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton4ActionPerformed

    private void rackButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton4MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton4);
    }//GEN-LAST:event_rackButton4MousePressed

    private void rackButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton11ActionPerformed

    private void rackButton11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton11MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton11);
    }//GEN-LAST:event_rackButton11MousePressed

    private void rackButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton10ActionPerformed

    private void rackButton10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton10MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton10);
    }//GEN-LAST:event_rackButton10MousePressed

    private void rackButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton2ActionPerformed

    private void rackButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton2MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton2);
    }//GEN-LAST:event_rackButton2MousePressed

    private void rackButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton9ActionPerformed

    private void rackButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton9MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton9);
    }//GEN-LAST:event_rackButton9MousePressed

    private void rackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton1ActionPerformed

    private void rackButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton1MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton1);
    }//GEN-LAST:event_rackButton1MousePressed

    private void rackButton1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton1MouseDragged

    private void challengeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_challengeButtonActionPerformed
        // TODO add your handling code here:
        MiTablero.intruccionAgarrarFichasIniciales(comuni);
        challengeButton.setEnabled(false);
    }//GEN-LAST:event_challengeButtonActionPerformed

    private void rackButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton8ActionPerformed

    private void rackButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton8MousePressed
        // TODO add your handling code here:
        miMovimiento.BotonPresionado(evt,rackButton8);
    }//GEN-LAST:event_rackButton8MousePressed

    private void EndTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndTurnActionPerformed
        // TODO add your handling code here:
        MiTablero.Revisar_tableroVirtual(this);
        EndTurn.setEnabled(false);
    }//GEN-LAST:event_EndTurnActionPerformed

    private void challengeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_challengeButton1ActionPerformed
        // TODO add your handling code here:
    MiTablero.setAplicacionUsuario(this, miMovimiento);
    comuni = new Comunicacion(jComboBox1.getSelectedIndex(),jComboBox2.getSelectedIndex());
    comuni.TableroVirtual(MiTablero);
    comuni.RecibirTrama();
    MiTablero.enableComponents(false);
    }//GEN-LAST:event_challengeButton1ActionPerformed

    private void rackButton122MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton122MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton122);
    }//GEN-LAST:event_rackButton122MousePressed

    private void rackButton122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton122ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton122ActionPerformed

    private void rackButton123MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton123MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton123);
    }//GEN-LAST:event_rackButton123MousePressed

    private void rackButton123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton123ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton123ActionPerformed

    private void rackButton124MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton124MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton124);
    }//GEN-LAST:event_rackButton124MousePressed

    private void rackButton124ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton124ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton124ActionPerformed

    private void rackButton125MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton125MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton125);
    }//GEN-LAST:event_rackButton125MousePressed

    private void rackButton125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton125ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton125ActionPerformed

    private void rackButton126MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton126MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton126);
    }//GEN-LAST:event_rackButton126MousePressed

    private void rackButton126ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton126ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton126ActionPerformed

    private void rackButton127MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton127MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton127);
    }//GEN-LAST:event_rackButton127MousePressed

    private void rackButton127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton127ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton127ActionPerformed

    private void rackButton128MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton128MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton128);
    }//GEN-LAST:event_rackButton128MousePressed

    private void rackButton128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton128ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton128ActionPerformed

    private void rackButton129MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton129MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton129);
    }//GEN-LAST:event_rackButton129MousePressed

    private void rackButton129ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton129ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton129ActionPerformed

    private void rackButton130MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton130MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton130);
    }//GEN-LAST:event_rackButton130MousePressed

    private void rackButton130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton130ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton130ActionPerformed

    private void rackButton131MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton131MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton131);
    }//GEN-LAST:event_rackButton131MousePressed

    private void rackButton131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton131ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton131ActionPerformed

    private void rackButton132MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton132MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton132);
    }//GEN-LAST:event_rackButton132MousePressed

    private void rackButton132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton132ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton132ActionPerformed

    private void rackButton133MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton133MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton133);
    }//GEN-LAST:event_rackButton133MousePressed

    private void rackButton133ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton133ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton133ActionPerformed

    private void rackButton134MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton134MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton134);
    }//GEN-LAST:event_rackButton134MousePressed

    private void rackButton134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton134ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton134ActionPerformed

    private void rackButton135MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton135MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton135);
    }//GEN-LAST:event_rackButton135MousePressed

    private void rackButton135ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton135ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton135ActionPerformed

    private void rackButton136MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton136MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton136);
    }//GEN-LAST:event_rackButton136MousePressed

    private void rackButton136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton136ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton136ActionPerformed

    private void rackButton137MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton137MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton137);
    }//GEN-LAST:event_rackButton137MousePressed

    private void rackButton137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton137ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton137ActionPerformed

    private void rackButton138MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton138MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton138);
    }//GEN-LAST:event_rackButton138MousePressed

    private void rackButton138ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton138ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton138ActionPerformed

    private void rackButton139MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton139MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton139);
    }//GEN-LAST:event_rackButton139MousePressed

    private void rackButton139ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton139ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton139ActionPerformed

    private void rackButton140MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton140MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton140);
    }//GEN-LAST:event_rackButton140MousePressed

    private void rackButton140ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton140ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton140ActionPerformed

    private void rackButton141MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton141MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton141);
    }//GEN-LAST:event_rackButton141MousePressed

    private void rackButton141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton141ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton141ActionPerformed

    private void rackButton142MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton142MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton142);
    }//GEN-LAST:event_rackButton142MousePressed

    private void rackButton142ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton142ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton142ActionPerformed

    private void rackButton143MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton143MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton143);
    }//GEN-LAST:event_rackButton143MousePressed

    private void rackButton143ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton143ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton143ActionPerformed

    private void rackButton144MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton144MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton144);
    }//GEN-LAST:event_rackButton144MousePressed

    private void rackButton144ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton144ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton144ActionPerformed

    private void rackButton145MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton145MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton145);
    }//GEN-LAST:event_rackButton145MousePressed

    private void rackButton145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton145ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton145ActionPerformed

    private void rackButton146MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton146MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton146);
    }//GEN-LAST:event_rackButton146MousePressed

    private void rackButton146ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton146ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton146ActionPerformed

    private void rackButton147MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rackButton147MousePressed
        // TODO add your handling code here:
         miMovimiento.BotonPresionado(evt,rackButton147);
    }//GEN-LAST:event_rackButton147MousePressed

    private void rackButton147ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rackButton147ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rackButton147ActionPerformed

    private void challengeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_challengeButton2ActionPerformed
        // TODO add your handling code here:
        comuni.IniciarPartida();
        challengeButton2.setEnabled(false); //ya no se puede volver a presionar 
    }//GEN-LAST:event_challengeButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton EndTurn;
    public javax.swing.JLabel LabelNumeroMaquina;
    public javax.swing.JButton challengeButton;
    private javax.swing.JButton challengeButton1;
    public javax.swing.JButton challengeButton2;
    public javax.swing.JPanel controlPanel;
    private javax.swing.JLabel instructionLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player1Score;
    private javax.swing.JLabel player2Label;
    private javax.swing.JLabel player2Score;
    private javax.swing.JLabel player3Score1;
    private javax.swing.JLabel player3ScoreLabel;
    private javax.swing.JLabel player3ScoreLabel1;
    private javax.swing.JLabel player3ScoreLabel2;
    private javax.swing.JLabel player4Score;
    private javax.swing.JLabel player4Score1;
    public javax.swing.JButton rackButton1;
    public javax.swing.JButton rackButton10;
    public javax.swing.JButton rackButton100;
    public javax.swing.JButton rackButton101;
    public javax.swing.JButton rackButton102;
    public javax.swing.JButton rackButton103;
    public javax.swing.JButton rackButton104;
    public javax.swing.JButton rackButton105;
    public javax.swing.JButton rackButton106;
    public javax.swing.JButton rackButton107;
    public javax.swing.JButton rackButton108;
    public javax.swing.JButton rackButton109;
    public javax.swing.JButton rackButton11;
    public javax.swing.JButton rackButton110;
    public javax.swing.JButton rackButton111;
    public javax.swing.JButton rackButton112;
    public javax.swing.JButton rackButton113;
    public javax.swing.JButton rackButton114;
    public javax.swing.JButton rackButton115;
    public javax.swing.JButton rackButton116;
    public javax.swing.JButton rackButton117;
    public javax.swing.JButton rackButton118;
    public javax.swing.JButton rackButton119;
    public javax.swing.JButton rackButton12;
    public javax.swing.JButton rackButton120;
    public javax.swing.JButton rackButton121;
    public javax.swing.JButton rackButton122;
    public javax.swing.JButton rackButton123;
    public javax.swing.JButton rackButton124;
    public javax.swing.JButton rackButton125;
    public javax.swing.JButton rackButton126;
    public javax.swing.JButton rackButton127;
    public javax.swing.JButton rackButton128;
    public javax.swing.JButton rackButton129;
    public javax.swing.JButton rackButton13;
    public javax.swing.JButton rackButton130;
    public javax.swing.JButton rackButton131;
    public javax.swing.JButton rackButton132;
    public javax.swing.JButton rackButton133;
    public javax.swing.JButton rackButton134;
    public javax.swing.JButton rackButton135;
    public javax.swing.JButton rackButton136;
    public javax.swing.JButton rackButton137;
    public javax.swing.JButton rackButton138;
    public javax.swing.JButton rackButton139;
    public javax.swing.JButton rackButton14;
    public javax.swing.JButton rackButton140;
    public javax.swing.JButton rackButton141;
    public javax.swing.JButton rackButton142;
    public javax.swing.JButton rackButton143;
    public javax.swing.JButton rackButton144;
    public javax.swing.JButton rackButton145;
    public javax.swing.JButton rackButton146;
    public javax.swing.JButton rackButton147;
    public javax.swing.JButton rackButton15;
    public javax.swing.JButton rackButton16;
    public javax.swing.JButton rackButton17;
    public javax.swing.JButton rackButton18;
    public javax.swing.JButton rackButton19;
    public javax.swing.JButton rackButton2;
    public javax.swing.JButton rackButton20;
    public javax.swing.JButton rackButton21;
    public javax.swing.JButton rackButton22;
    public javax.swing.JButton rackButton23;
    public javax.swing.JButton rackButton24;
    public javax.swing.JButton rackButton25;
    public javax.swing.JButton rackButton26;
    public javax.swing.JButton rackButton27;
    public javax.swing.JButton rackButton28;
    public javax.swing.JButton rackButton29;
    public javax.swing.JButton rackButton3;
    public javax.swing.JButton rackButton30;
    public javax.swing.JButton rackButton31;
    public javax.swing.JButton rackButton32;
    public javax.swing.JButton rackButton33;
    public javax.swing.JButton rackButton34;
    public javax.swing.JButton rackButton35;
    public javax.swing.JButton rackButton36;
    public javax.swing.JButton rackButton37;
    public javax.swing.JButton rackButton38;
    public javax.swing.JButton rackButton39;
    public javax.swing.JButton rackButton4;
    public javax.swing.JButton rackButton40;
    public javax.swing.JButton rackButton41;
    public javax.swing.JButton rackButton42;
    public javax.swing.JButton rackButton43;
    public javax.swing.JButton rackButton44;
    public javax.swing.JButton rackButton45;
    public javax.swing.JButton rackButton46;
    public javax.swing.JButton rackButton47;
    public javax.swing.JButton rackButton48;
    public javax.swing.JButton rackButton49;
    public javax.swing.JButton rackButton5;
    public javax.swing.JButton rackButton50;
    public javax.swing.JButton rackButton51;
    public javax.swing.JButton rackButton52;
    public javax.swing.JButton rackButton53;
    public javax.swing.JButton rackButton54;
    public javax.swing.JButton rackButton55;
    public javax.swing.JButton rackButton56;
    public javax.swing.JButton rackButton57;
    public javax.swing.JButton rackButton58;
    public javax.swing.JButton rackButton59;
    public javax.swing.JButton rackButton6;
    public javax.swing.JButton rackButton60;
    public javax.swing.JButton rackButton61;
    public javax.swing.JButton rackButton62;
    public javax.swing.JButton rackButton63;
    public javax.swing.JButton rackButton64;
    public javax.swing.JButton rackButton65;
    public javax.swing.JButton rackButton66;
    public javax.swing.JButton rackButton67;
    public javax.swing.JButton rackButton68;
    public javax.swing.JButton rackButton69;
    public javax.swing.JButton rackButton7;
    public javax.swing.JButton rackButton70;
    public javax.swing.JButton rackButton71;
    public javax.swing.JButton rackButton72;
    public javax.swing.JButton rackButton73;
    public javax.swing.JButton rackButton74;
    public javax.swing.JButton rackButton75;
    public javax.swing.JButton rackButton76;
    public javax.swing.JButton rackButton77;
    public javax.swing.JButton rackButton78;
    public javax.swing.JButton rackButton79;
    public javax.swing.JButton rackButton8;
    public javax.swing.JButton rackButton80;
    public javax.swing.JButton rackButton81;
    public javax.swing.JButton rackButton82;
    public javax.swing.JButton rackButton83;
    public javax.swing.JButton rackButton84;
    public javax.swing.JButton rackButton85;
    public javax.swing.JButton rackButton86;
    public javax.swing.JButton rackButton87;
    public javax.swing.JButton rackButton88;
    public javax.swing.JButton rackButton89;
    public javax.swing.JButton rackButton9;
    public javax.swing.JButton rackButton90;
    public javax.swing.JButton rackButton91;
    public javax.swing.JButton rackButton92;
    public javax.swing.JButton rackButton93;
    public javax.swing.JButton rackButton94;
    public javax.swing.JButton rackButton95;
    public javax.swing.JButton rackButton96;
    public javax.swing.JButton rackButton97;
    public javax.swing.JButton rackButton98;
    public javax.swing.JButton rackButton99;
    // End of variables declaration//GEN-END:variables

}
