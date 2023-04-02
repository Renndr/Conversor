import javax.swing.*;

import Inicio.Inicio;

public class Main {
           
    public static void main (String[] args) {

        // apply look & feel
        try {
        UIManager.setLookAndFeel(new com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkContrastIJTheme());
        new Inicio();
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }

    } 
}
