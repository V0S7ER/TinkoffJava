package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task3.*;
import static org.assertj.core.api.Assertions.*;

public class Task3Test {
    @Test
    @DisplayName("StableConnection works stable")
    public void testStableConnectionWorks() {
        final int range = 100;
        int exceptionCount = 0;
        for (int i = 0; i < range; ++i) {
            try (Connection connection = new StableConnection()) {
                connection.execute("apt update");
            } catch (Exception e) {
                ++exceptionCount;
            }
        }

        assertThat(exceptionCount == 0).isTrue();
    }

    @Test
    @DisplayName("FaultyConnection sometimes throw connectionException")
    public void testFaultyConnectionSometimesThrowException() {
        FaultyConnection.setFaultProbability(0.1);
        final int range = 100;
        int exceptionCount = 0;
        for (int i = 0; i < range; ++i) {
            try (Connection connection = new FaultyConnection()) {
                connection.execute("apt update");
            } catch (Exception e) {
                ++exceptionCount;
            }
        }

        assertThat(exceptionCount != 0 && exceptionCount < range).isTrue();
    }

    @Test
    @DisplayName("FaultyConnectionManager always return faultyConnection")
    public void testFaultyConnectionManagerAlwaysReturnFaultyConnection() {
        final int range = 100;
        int faultyCount = 0;
        ConnectionManager manager = new FaultyConnectionManager();
        for (int i = 0; i < range; ++i) {
            if (manager.getConnection() instanceof FaultyConnection) {
                faultyCount++;
            }
        }

        assertThat(faultyCount == range).isTrue();
    }

    @Test
    @DisplayName("DefaultConnectionManager sometimes return faultyConnection")
    public void testDefaultConnectionManagerSometimesReturnFaultyConnection() {
        final int range = 100;
        int faultyCount = 0;
        ConnectionManager manager = new DefaultConnectionManager();
        for (int i = 0; i < range; ++i) {
            if (manager.getConnection() instanceof FaultyConnection) {
                faultyCount++;
            }
        }

        assertThat(faultyCount != 0 && faultyCount < range).isTrue();
    }

    @Test
    @DisplayName("Test tryExecute with FaultyConnectionManager")
    public void testTryExecuteWithFaultyConnectionManager() {
        FaultyConnection.setFaultProbability(1);
        ConnectionManager faultyManager = new FaultyConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(faultyManager, 10);

        boolean wasException = false;
        try {
            executor.updatePackages();
        } catch (Exception e) {
            wasException = true;
        }

        assertThat(wasException).isTrue();
    }
}
