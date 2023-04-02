package Inicio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Medidas.MenuMedidas;
import Moneda.Monedas;
import Temperatura.MenuTemp;


public class Inicio extends JFrame {
    private JButton bmonedas,btemp,bmedidas;
    private ListenButton listener;
    private JPanel pMonedas, pTemp, pMedidas, inicio;
    private JLabel autor;

    public Inicio() {
        initComponents();
        new Monedas().initComponents(pMonedas);
        setTitle("Conversor de monedas");
    }

    private void initComponents() {

        setTitle("Conversor");
        setPreferredSize (new Dimension (470, 350));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        
    
        //construct components
        bmonedas = new JButton ("Monedas");
        btemp = new JButton ("Temperatura");
        bmedidas = new JButton ("Medidas");
        inicio =  new JPanel();
        autor = new JLabel("@Renndr (GitHub)");

        //add components menu principal
        add (bmonedas);
        add (btemp);
        add (bmedidas);
        add (inicio);
        add (autor);

        //Buttons
        bmonedas.setBounds (0, 0, 150, 50);
        btemp.setBounds (150, 0, 150, 50);
        bmedidas.setBounds (300, 0, 150, 50);
        //label
        autor.setBounds(10,280,100,25);

        // panel conversor de monedas
        pMonedas = new JPanel();
        pMonedas.setLayout(null);
        pMonedas.setBounds(0, 0, 470, 360);
        getContentPane().add(pMonedas);

        // panel conversor de temperatura
        pTemp = new JPanel();
        pTemp.setLayout(null);
        pTemp.setBounds(0, 0, 470, 360);
        getContentPane().add(pTemp);

        // panel conversor de medidas
        pMedidas = new JPanel();
        pMedidas.setLayout(null);
        pMedidas.setBounds(0, 0, 470, 360);
        getContentPane().add(pMedidas);

        //Active actions
        listener = new ListenButton();
        bmonedas.addActionListener(listener);
        bmedidas.addActionListener(listener);
        btemp.addActionListener(listener);

    }

    public class ListenButton implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == bmonedas){
                pTemp.setVisible(false);
                pMedidas.setVisible(false);
                setTitle("Conversor de monedas");
                new Monedas().initComponents(pMonedas);
            }
            if(e.getSource() == btemp){
                pMonedas.setVisible(false);
                pMedidas.setVisible(false);
                setTitle("Conversor de temperatura");
                new MenuTemp().MenuTemperatura(pTemp);
            }
            if(e.getSource() == bmedidas){
                pMonedas.setVisible(false);
                pTemp.setVisible(false);
                setTitle("Conversor de medidas");
                new MenuMedidas().initComponents(pMedidas);
            }   
        } 
    }
}
  
