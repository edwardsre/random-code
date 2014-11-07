package apprentice.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Requirement: Write an application that uses the slf4j logging library directly (can also choose log4j if you want)
 * <p>
 * Do the following:
 *   <ol>
 *     <li>configure the logging using an accepted department log statement format (see Application Logging)</li>
 *     <li>log at different logging levels (error, warn, info, debug), to see the effect of the default logging level setting</li>
 *     <li>turn on DEBUG in the logging config to show DEBUG output</li>
 *     <li>configure logging to go to both the console and a log file</li>
 *   </ol>
 * </p>
 */
public class LoggingDemo {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private void showLogging() {
    logger.info("This is an info log statement with parameter replacement. param1={}", 23);

    logger.warn("This is a warn log statement with parameter replacement and exception. param1={}",
                "paramValue", new RuntimeException("Simulate exception logging."));

    logger.error("This is an error log statement");
    logger.debug("This is a debug log statement");

    // show MDC logging applied to every log statement (%X in pattern layout)
    MDC.put("aKey", "aValue");
    try {
      makeMethodCallToDemoMDCLogging();
    }
    finally {
      MDC.clear();
    }
  }

  private void makeMethodCallToDemoMDCLogging() {
    logger.info("Show that the MDC values are logged with this log output.");
  }

  public static void main(String[] args) {
    new LoggingDemo().showLogging();
  }

}
