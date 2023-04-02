package Medidas;

import javax.swing.*;
import java.awt.event.*;

public class MenuMedidas extends JFrame{
    private JButton bLongitud,bVolumen,bMasa,bArea,bVelocidad;
    private JPanel pLongitud, pVolumen, pMasa, pArea, pVelocidad;
    private ListenButton listener;

    
    public MenuMedidas (){
        //bVolumen.doClick();
    }
    
    public void  initComponents(JPanel p){
        
        p.setVisible(true);

        //construct components buttons
        bLongitud = new JButton("Longitud");
        bVolumen = new JButton("Volumen");
        bMasa = new JButton("Masa");
        bArea = new JButton("Area");
        bVelocidad = new JButton("Velocidad");

        // panel volumen
        pVolumen = new JPanel();
        pVolumen.setLayout(null);
        pVolumen.setVisible(true);
        pVolumen.setBounds(145,80,325,300);
        new panelVolumen().initComponents(pVolumen);

        // panel longitud
        pLongitud = new JPanel();
        pLongitud.setLayout(null);
        pLongitud.setVisible(false);
        pLongitud.setBounds(145,80,325,300);

        // panel masa
        pMasa = new JPanel();
        pMasa.setLayout(null);
        pMasa.setVisible(false);
        pMasa.setBounds(145,80,325,300);

        // panel velocidad
        pVelocidad = new JPanel();
        pVelocidad.setLayout(null);
        pVelocidad.setVisible(false);
        pVelocidad.setBounds(145,80,325,300);

        // panel area
        pArea = new JPanel();
        pArea.setLayout(null);
        pArea.setVisible(false);
        pArea.setBounds(145,80,325,300);        
        
        //add components panel principal
        p.add (bArea);
        p.add (bLongitud);
        p.add (bMasa);
        p.add (bVelocidad);
        p.add (bVolumen);
        p.add (pVolumen);
        p.add (pLongitud);
        p.add (pMasa);
        p.add (pArea);
        p.add (pVelocidad);

        //Buttons
        bVolumen.setBounds(10,80,125,35);
        bLongitud.setBounds(10,120,125,35);
        bMasa.setBounds(10,160,125,35);
        bVelocidad.setBounds(10,200,125,35);
        bArea.setBounds(10,240,125,35);

        //Active actions
        listener = new ListenButton();
        bVolumen.addActionListener(listener);
        bLongitud.addActionListener(listener);
        bVelocidad.addActionListener(listener);
        bMasa.addActionListener(listener);
        bArea.addActionListener(listener);

    }

    public class ListenButton implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == bVolumen){
                pVolumen.setVisible(true);
                pLongitud.setVisible(false);
                pMasa.setVisible(false);
                pVelocidad.setVisible(false);
                pArea.setVisible(false);
                new panelVolumen().initComponents(pVolumen);
            }
            if(e.getSource() == bLongitud){
                pLongitud.setVisible(true);
                pVolumen.setVisible(false);
                pMasa.setVisible(false);
                pVelocidad.setVisible(false);
                pArea.setVisible(false);
                new panelLongitud().initComponents(pLongitud);
            }
            if(e.getSource() == bMasa){
                pMasa.setVisible(true);
                pVolumen.setVisible(false);
                pLongitud.setVisible(false);
                pVelocidad.setVisible(false);
                pArea.setVisible(false);
                new panelMasa().initComponents(pMasa);
            }
            if(e.getSource() == bVelocidad){
                pVelocidad.setVisible(true);
                pVolumen.setVisible(false);
                pMasa.setVisible(false);
                pLongitud.setVisible(false);
                pArea.setVisible(false);
                new panelVelocidad().initComponents(pVelocidad);
            }
            if(e.getSource() == bArea){
                pArea.setVisible(true);
                pVolumen.setVisible(false);
                pMasa.setVisible(false);
                pVelocidad.setVisible(false);
                pArea.setVisible(false);
                new panelArea().initComponents(pArea);
            }
        }
    }
}