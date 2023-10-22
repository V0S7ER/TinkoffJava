package edu.hw2;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SUCCESS_MESSAGE = "Success!";
    private static final double DEFAULT_PROBABILITY = 0.1;

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public static final class StableConnection implements Connection {

        @Override public void execute(String command) {
            LOGGER.info(SUCCESS_MESSAGE);
        }

        @Override public void close() {
            // to do some hard things
        }
    }

    public static final class FaultyConnection implements Connection {
        private static double faultProbability = DEFAULT_PROBABILITY;
        private static final Random RANDOM = new Random();

        @Override public void execute(String command) {
            if (RANDOM.nextDouble() < faultProbability) {
                throw new ConnectionException();
            }

            LOGGER.info(SUCCESS_MESSAGE);
        }

        @Override public void close() {
            // close
        }

        public static void setFaultProbability(double probability) {
            faultProbability = probability;
        }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static final class DefaultConnectionManager implements ConnectionManager {
        private static final double FAULT_PROBABILITY = 0.1;
        private static final Random RANDOM = new Random();

        @Override public Connection getConnection() {
            return RANDOM.nextDouble() < FAULT_PROBABILITY ? new FaultyConnection() : new StableConnection();
        }
    }

    public static final class FaultyConnectionManager implements ConnectionManager {

        @Override public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static class ConnectionException extends RuntimeException {
    }

    public static final class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            if (maxAttempts <= 0) {
                throw new IllegalArgumentException();
            }
            this.maxAttempts = maxAttempts;
        }

        public void updatePackages() throws Exception {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) throws Exception {
            ConnectionException cause = null;
            for (int iteration = 0; iteration < maxAttempts; ++iteration) {
                try (
                    Connection connection = manager.getConnection()) { // try-with-resources - connection само закроется
                    connection.execute(command);
                    return; // если выполнилось - оно завершится тут
                } catch (ConnectionException e) {
                    cause = e;
                }
            }

            assert cause != null;
            throw cause; // если не выполнилось - кидаем исключение
        }
    }
}
