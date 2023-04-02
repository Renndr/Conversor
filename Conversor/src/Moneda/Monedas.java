package Moneda;

import java.awt.event.*;
import javax.swing.*;
import Errores.*;

public class Monedas {
    
    private JButton breset,bconvert,bswap;
    private JTextField boxAmount;
    private JLabel txtamount, result;
    private JComboBox<String> cbox1, cbox2;
    private String storeBox1,storeBox2;

    public void initComponents(JPanel p) {
        
       p.setVisible(true);

        //construct preComponents
        String[] cboxItems = {"Peso Dominicano (DOP)","Peso Mexicano (MXN)","Dolar Estadounidense (USD)","Euro (EUR)","Libra Esterlina (GBP)","Yen (JPY)","Won Coreano (KRW)"};

        //construct components (Monedas)
        boxAmount = new JTextField (5);
        breset = new JButton("Reiniciar");
        bconvert = new JButton("Convertir");
        bswap = new JButton(ImageLoader.createImageIcon("/images/sw.png"));
        txtamount = new JLabel ("Cantidad");
        cbox1 = new JComboBox<> (cboxItems);
        cbox2 = new JComboBox<> (cboxItems);
        result = new JLabel();
        //autor = new JLabel("Manuel Bernabel (Ren) 2023 ");

        //set components properties
        boxAmount.setToolTipText ("Ingrese el valor a convertir.");
        bswap.setToolTipText("Intercambiar.");
        result.setHorizontalAlignment(JLabel.CENTER);
        cbox2.setSelectedIndex(1);

        //No permite texto, MAX digitos 10.
        DecimalDocument filter = new DecimalDocument();
        boxAmount.setDocument(filter);
        
        //Borde personalizado
        //Border border = BorderFactory.createLineBorder(Color.RED, 1);

        //add components
        p.add (txtamount);
        p.add (boxAmount);
        p.add (cbox1);
        p.add (cbox2);
        p.add (breset);
        p.add (bconvert);
        p.add (bswap);
        p.add (result);
        //p.add (autor);

        //Buttons
        breset.setBounds (10, 250, 100, 25);
        bconvert.setBounds (340, 250, 100, 25);
        bswap.setBounds (200,150,50,25);

        //Box
        boxAmount.setBounds (175, 115, 100, 25);
        txtamount.setBounds (195, 85, 60, 25);
        cbox1.setBounds (10, 150, 150, 25);
        cbox2.setBounds (290, 150, 150, 25);
        result.setBounds(100, 180,250, 25);
       // autor.setBounds(290, 280, 150, 25);

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
                if (boxAmount.getText().equals("")) {
                    result.setText("");
                } else {
                    String value0 = ""+cbox1.getSelectedItem();
                    String value1 = ""+cbox2.getSelectedItem();
                    Mconversor operator = new Mconversor();
                    String conversion = operator.operatorCurrency(value0, value1, Double.parseDouble(boxAmount.getText()));
                    result.setText(conversion);
                }
            }
        });
    }
}
  