package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class logger {

    static Logger logger = Logger.getLogger(logger.class);
    public logger(){

        DOMConfigurator.configure("log4j.xml");
    }
    public void INFO(String message) {

        logger.info(message);
    }
    public void ERROR (String message) {
        logger.error(message);
    }
}
