package chainofresponsability;

import java.util.HashSet;

public class ChainofresponsabilityEx1 {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;

    }

    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO,
                "Isso é uma informação.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "Isso é uma informação de nivel de DEBUG.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "Isso é uma mensagem de erro.");
    }
}
