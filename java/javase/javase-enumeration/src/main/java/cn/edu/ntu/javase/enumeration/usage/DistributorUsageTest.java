package cn.edu.ntu.javase.enumeration.usage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumMap;
import java.util.Map;

/** message type */
enum OperationType {
    LOGIN,
    ENTER_ROOM,
    EXIT_ROOM,
    LOGOUT
}

/** Operation handler */
interface OperationHandler {
    /**
     * handle difference operation.
     *
     * @param operation
     */
    void handle(Operation operation);
}

/**
 * @author zack <br>
 * @create 2020-04-05 00:11 <br>
 */
public class DistributorUsageTest {
    private static final Logger LOG = LoggerFactory.getLogger(DistributorUsageTest.class);

    @Test
    public void testOperationDispatcher() {
        OperationDispatcher dispatcher = new OperationDispatcher();
        dispatcher.dispatch(new Operation(OperationType.LOGIN));
    }
}

/** message */
class Operation {
    private final OperationType type;

    public Operation(OperationType type) {
        this.type = type;
    }

    public OperationType getType() {
        return type;
    }
}

/** Implements Operation Dispatcher based on EnumMap */
class OperationDispatcher {

    private static final Logger LOG = LoggerFactory.getLogger(OperationDispatcher.class);

    private final Map<OperationType, OperationHandler> dispatcherMap =
            new EnumMap<>(OperationType.class);

    public OperationDispatcher() {
        dispatcherMap.put(OperationType.LOGIN, message -> LOG.info("Login"));
        dispatcherMap.put(OperationType.ENTER_ROOM, message -> LOG.info("Enter Room"));
        dispatcherMap.put(OperationType.EXIT_ROOM, message -> LOG.info("Exit Room"));
        dispatcherMap.put(OperationType.LOGOUT, message -> LOG.info("Logout"));
    }

    public void dispatch(Operation operation) {
        OperationHandler handler = this.dispatcherMap.get(operation.getType());
        if (handler != null) {
            handler.handle(operation);
        }
    }
}
