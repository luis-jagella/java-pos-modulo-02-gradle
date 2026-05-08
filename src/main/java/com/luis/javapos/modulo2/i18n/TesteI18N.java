package com.luis.javapos.modulo2.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class TesteI18N {

    public static void main(String[] args) {

        Locale localeBR = new Locale("pt", "BR");
        Locale loceleUS = new Locale("en", "US");

        ResourceBundle bundleBr = ResourceBundle.getBundle("messages", localeBR);
        ResourceBundle bundleUs = ResourceBundle.getBundle("messages", loceleUS);

        System.out.println(bundleBr.getString("welcome"));
        System.out.println(bundleUs.getString("welcome"));
    }

}
