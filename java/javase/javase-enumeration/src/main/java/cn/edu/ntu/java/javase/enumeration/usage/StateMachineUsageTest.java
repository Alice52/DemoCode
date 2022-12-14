package cn.edu.ntu.java.javase.enumeration.usage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implements state machine based on enum
 */
enum OrderState implements IOrderState {
    /**
     * CREATED state when order is created
     */
    CREATED {
        @Override
        public void cancel(OrderStateContext context) {
            context.setState(CANCELED);
        }

        /** allow confirm operation and set state to CONFIRMED */
        @Override
        public void confirm(OrderStateContext context) {
            context.setState(CONFIRMED);
        }
    },
    /**
     * CONFIRMED state when order is confirm
     */
    CONFIRMED {
        /** allow cancel operation and set state to CANCELED */
        @Override
        public void cancel(OrderStateContext context) {
            context.setState(CANCELED);
        }

        /** allow timeout operation and set state to OVERTIME */
        @Override
        public void timeout(OrderStateContext context) {
            context.setState(OVERTIME);
        }

        /** allow pay operation and set state to PAYED */
        @Override
        public void pay(OrderStateContext context) {
            context.setState(PAYED);
        }
    },
    /**
     * Canceled is freeze state when order is cancel()
     */
    CANCELED {},

    /**
     * Canceled is freeze state when order is overtime()
     */
    OVERTIME {},

    /**
     * CREATED state when order is pay()
     */
    PAYED {
        @Override
        public void cancel(OrderStateContext context) {
            context.setState(CANCELED);
        }
    };

    @Override
    public void cancel(OrderStateContext context) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void confirm(OrderStateContext context) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void timeout(OrderStateContext context) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void pay(OrderStateContext context) {
        throw new UnsupportedOperationException();
    }
}

interface IOrderState {
    /**
     * @param context
     */
    void cancel(OrderStateContext context);

    /**
     * @param context
     */
    void confirm(OrderStateContext context);

    /**
     * @param context
     */
    void timeout(OrderStateContext context);

    /**
     * @param context
     */
    void pay(OrderStateContext context);
}

/**
 * State Context: for change order state
 */
interface OrderStateContext {
    /**
     * this method is to change order state.
     *
     * @param state
     */
    void setState(OrderState state);
}

/**
 * @author zack <br>
 * @create 2020-04-05 00:12 <br>
 */
public class StateMachineUsageTest {
    private static final Logger LOG = LoggerFactory.getLogger(StateMachineUsageTest.class);

    @Test
    public void testOrderState() {
        Order order = new Order();
        LOG.info(order.getState().name());

        order.confirm();
        LOG.info(order.getState().name());

        order.timeout();
        LOG.info(order.getState().name());

        Order order2 = new Order();
        LOG.info(order2.getState().name());

        order2.confirm();
        LOG.info(order2.getState().name());

        order2.pay();
        LOG.info(order2.getState().name());

        order2.cancel();
        LOG.info(order2.getState().name());
    }
}

/**
 * order implements
 */
class Order {
    private OrderState state;

    /**
     * this is subClass and use it to change order state
     */
    private StateContext stateContext = new StateContext();

    public Order() {
        this.state = OrderState.CREATED;
    }

    public OrderState getState() {
        return state;
    }

    private void setState(OrderState state) {
        this.state = state;
    }

    /**
     * transfer request operation to enum state to handle
     */
    public void cancel() {
        this.state.cancel(stateContext);
    }

    /**
     * transfer request operation to enum state to handle
     */
    public void confirm() {
        this.state.confirm(stateContext);
    }

    /**
     * transfer request operation to enum state to handle
     */
    public void timeout() {
        this.state.timeout(stateContext);
    }

    /**
     * transfer request operation to enum state to handle
     */
    public void pay() {
        this.state.pay(stateContext);
    }

    /**
     * subClass: implements OrderStateContext to change Order state
     */
    private class StateContext implements OrderStateContext {

        @Override
        public void setState(OrderState state) {
            Order.this.setState(state);
        }
    }
}
