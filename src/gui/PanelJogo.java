package gui;

import Controller.JogoController;
import javax.swing.JOptionPane;

public class PanelJogo extends javax.swing.JPanel 
{
    
    private FramePrincipal framePai;
    private String palavra;
    private JogoController controller;
    
    public PanelJogo(FramePrincipal pai, String palavra) 
    {
        initComponents();
        
        this.framePai = pai;
        this.palavra = palavra;
        this.controller = new JogoController(this, palavra);
        
        iniciaTela();
    }
    
    private void iniciaTela()
    {
        cabecaTxt.setText("");
        torsoTxt.setText("");
        pernasTxt.setText("");
        palavraTxt.setText(this.controller.contaLetras(this.palavra));
        errosTxt.setText("");
    }
    
    private void rodada()
    {
        String letra = novaLetraTxt.getText();
        novaLetraTxt.setText("");
        if(this.controller.confereLetra(this.palavra, letra))
        {
            palavraTxt.setText(this.controller.contaAcertos(letra));
            
            if(this.controller.verificaAcertos())
            {
                JOptionPane.showMessageDialog(this, "Jogador 2 foi o vencedor", "",JOptionPane.INFORMATION_MESSAGE);
                this.framePai.trocaPanel(new PanelTelaInicial(this.framePai));
            }
        }else {
            if(!errosTxt.getText().contains(letra))
            {
                errosTxt.setText(errosTxt.getText()+letra.toUpperCase()+"  ");
            }
            
            switch(this.controller.getErros())
            {
                case 1: cabecaTxt.setText("O"); break;
                case 2: torsoTxt.setText("  |  "); break;
                case 3: torsoTxt.setText("/ |  "); break;
                case 4: torsoTxt.setText("/ | \\"); break;
                case 5: pernasTxt.setText("/  "); break;
                case 6: pernasTxt.setText("/ \\"); break;
            }

            if(!this.controller.verificaErros())
            {
                JOptionPane.showMessageDialog(this, "Jogador 1 foi o vencedor", "",JOptionPane.INFORMATION_MESSAGE);
                this.framePai.trocaPanel(new PanelTelaInicial(this.framePai));
            }
        }
    }

    private void chute()
    {
        if(this.palavra.equalsIgnoreCase(chutePalavraTxt.getText()))
        {
            JOptionPane.showMessageDialog(this, "Jogador 2 foi o vencedor", "",JOptionPane.INFORMATION_MESSAGE);
            this.framePai.trocaPanel(new PanelTelaInicial(this.framePai));
        }else {
            cabecaTxt.setText("O");
            torsoTxt.setText("/ | \\");
            pernasTxt.setText("/ \\");
            JOptionPane.showMessageDialog(this, "Jogador 1 foi o vencedor", "",JOptionPane.INFORMATION_MESSAGE);
            this.framePai.trocaPanel(new PanelTelaInicial(this.framePai));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        palavraTxt = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        errosTxt = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cabecaTxt = new javax.swing.JLabel();
        torsoTxt = new javax.swing.JLabel();
        pernasTxt = new javax.swing.JLabel();
        novaLetraTxt = new javax.swing.JTextField();
        chutePalavraTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        palavraTxt.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        palavraTxt.setForeground(new java.awt.Color(51, 51, 51));
        palavraTxt.setText("A  B  C  D  E");
        palavraTxt.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));

        errosTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        errosTxt.setForeground(new java.awt.Color(51, 51, 51));
        errosTxt.setText("A B C D E");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(errosTxt)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(errosTxt)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Adivinhe uma letra");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("|");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("|");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("|");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("|");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("|");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("__ __ __");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("|");

        cabecaTxt.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        cabecaTxt.setForeground(new java.awt.Color(51, 51, 51));
        cabecaTxt.setText("o");

        torsoTxt.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        torsoTxt.setForeground(new java.awt.Color(51, 51, 51));
        torsoTxt.setText("/ | \\");

            pernasTxt.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
            pernasTxt.setForeground(new java.awt.Color(51, 51, 51));
            pernasTxt.setText("/ \\");

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(torsoTxt)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(27, 27, 27)
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8))
                                        .addComponent(jLabel7)))
                                .addContainerGap(61, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cabecaTxt)
                                .addGap(52, 52, 52))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pernasTxt)
                                .addGap(34, 34, 34))))
                );
                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cabecaTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(torsoTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(pernasTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44))
                );

                novaLetraTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                novaLetraTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        novaLetraTxtKeyReleased(evt);
                    }
                });

                chutePalavraTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                chutePalavraTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        chutePalavraTxtKeyReleased(evt);
                    }
                });

                jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
                jLabel10.setForeground(new java.awt.Color(51, 51, 51));
                jLabel10.setText("Adivinhe a palavra");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(palavraTxt)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(chutePalavraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(novaLetraTxt))))))
                        .addContainerGap(169, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(novaLetraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chutePalavraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(palavraTxt)
                                .addGap(58, 58, 58)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(53, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                );
            }// </editor-fold>//GEN-END:initComponents

    private void novaLetraTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_novaLetraTxtKeyReleased
        
        if(evt.getKeyChar() == '\n')
        {
            rodada();
        }
    }//GEN-LAST:event_novaLetraTxtKeyReleased

    private void chutePalavraTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chutePalavraTxtKeyReleased

        if(evt.getKeyChar() == '\n')
        {
            chute();
        }
    }//GEN-LAST:event_chutePalavraTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cabecaTxt;
    private javax.swing.JTextField chutePalavraTxt;
    private javax.swing.JLabel errosTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField novaLetraTxt;
    private javax.swing.JLabel palavraTxt;
    private javax.swing.JLabel pernasTxt;
    private javax.swing.JLabel torsoTxt;
    // End of variables declaration//GEN-END:variables
}
