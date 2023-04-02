package Medidas;

import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import Errores.*;

public class panelVelocidad{
    
    private JButton breset,bconvert,bswap;
    private JTextField boxAmount;
    private JLabel txtamount, result;
    private JComboBox<String> cbox1, cbox2;
    private String storeBox1,storeBox2;
    
    public void initComponents (JPanel p) {

        p.setVisible(true);

        //construct preComponents
        String[] cboxItems = {"Metro por segundo","Kilometro por hora","Milla por hora","Pie por segundo","Nudo"};

        //construct components (Monedas)
        boxAmount = new JTextField (5);
        breset = new JButton("Reiniciar");
        bconvert = new JButton("Convertir");
        bswap = new JButton(ImageLoader.createImageIcon("/images/exchange.png"));
        txtamount = new JLabel ("Velocidad");
        cbox1 = new JComboBox<> (cboxItems);
        cbox2 = new JComboBox<> (cboxItems);
        result = new JLabel();

        //set components properties
        boxAmount.setToolTipText ("Ingrese el valor a convertir.");
        bswap.setToolTipText("Intercambiar.");
        result.setHorizontalAlignment(JLabel.CENTER);
        cbox2.setSelectedIndex(1);

        //No permite texto, MAX digitos 10.
        DecimalDocument filter = new DecimalDocument();
        boxAmount.setDocument(filter);
        
        //add components
        p.add (txtamount);
        p.add (boxAmount);
        p.add (cbox1);
        p.add (cbox2);
        p.add (breset);
        p.add (bconvert);
        p.add (bswap);
        p.add (result);

        //buttons 
        bswap.setBounds (22,80,50,25);
        breset.setBounds (10, 170, 100, 25);
        bconvert.setBounds (200, 170, 100, 25);

        //box
        cbox1.setBounds (87, 60, 140, 25);
        cbox2.setBounds (87, 100, 140, 25);
        boxAmount.setBounds (107, 25, 100, 25);
        result.setBounds(107, 135,100, 25);

        //txtfield
        txtamount.setBounds(132,0,100,25);

               //Active actions
       breset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cbox1.setSelectedIndex(0);
                boxAmount.setText(null);
                cbox2.setSelectedIndex(1);
                result.setText(null);
            }  
        });

        bswap.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            Object temp1 = cbox1.getSelectedItem();
            Object temp2 = cbox2.getSelectedItem();
            cbox2.setSelectedItem(temp1);
            cbox1.setSelectedItem(temp2);
            bconvert.doClick();
            }
        });

        //store itembox
        storeBox1 = (String) cbox1.getSelectedItem();
        storeBox2 = (String) cbox2.getSelectedItem();
        
        cbox1.addItemListener(e -> {
            String itemSeleccionado = (String) cbox1.getSelectedItem();
            if (itemSeleccionado.equals(cbox2.getSelectedItem())) {
                cbox2.setSelectedItem(storeBox1);
            } else {
                storeBox1 = itemSeleccionado;  
            }
        });
        
        cbox2.addItemListener(e -> {
            String itemSeleccionado = (String) cbox2.getSelectedItem();
            if (itemSeleccionado.equals(cbox1.getSelectedItem())) {
                cbox1.setSelectedItem(storeBox2);
            } else {
                storeBox2 = itemSeleccionado;  
            }
        });

        bconvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value0 = (String)cbox1.getSelectedItem();
                String value1 = (String)cbox2.getSelectedItem();
            
                if (boxAmount.getText().equals("")) {
                        result.setText("");
                }
                else {
                    try {
                        velocidadConverter conversor = new velocidadConverter();
                        Double amount = Double.parseDouble(boxAmount.getText());
                        double resultValue = conversor.convertTemperature(amount, value0, value1);
                        //Max decimales
                        DecimalFormat df = new DecimalFormat("#.#####E0");
                        Double resultado = Double.parseDouble(df.format(resultValue));
                        result.setText(resultado + " " + value1);
                    } catch (IllegalArgumentException ex) {
                        result.setText(ex.getMessage());
                    }
                }
            }
        });
    }
}