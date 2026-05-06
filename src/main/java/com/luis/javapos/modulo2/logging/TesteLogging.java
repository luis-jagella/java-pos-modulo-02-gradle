package com.luis.javapos.modulo2.logging;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TesteLogging {

    private static final Logger logger = Logger.getLogger(TesteLogging.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    TesteLogging.class.getClassLoader()
                            .getResourceAsStream("logging.properties")
            );
        } catch (IOException e) { System.out.println("Erro ao carregar config de log"); }

        logger.severe("Erro grave");
        logger.warning("Aviso importante");
        logger.info("Informação geral");
        logger.fine("Debug (talvez não apareça)");
        logger.finer("Mais detalhado ainda");
        logger.finest("Ultra detalhado");

        logger.info("Aplicação finalizada");
    }
}
