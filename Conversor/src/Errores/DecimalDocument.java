package Errores;

import javax.swing.text.*;

public  class DecimalDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            // Verifica que el nuevo texto solo contenga dígitos y un solo punto decimal
            String newStr = getText(0, offs) + str + getText(offs, getLength() - offs);
            if (newStr.matches("^\\d{0,10}(\\.\\d{0,5})?$")) {
                super.insertString(offs, str, a);
            }
        }
}



