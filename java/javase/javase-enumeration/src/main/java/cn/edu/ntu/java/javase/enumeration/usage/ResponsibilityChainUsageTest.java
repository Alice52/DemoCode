package cn.edu.ntu.java.javase.enumeration.usage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Message Type
 */
enum MessageType {
    TEXT,
    BIN,
    XML,
    JSON,
    UNKNOWN;
}

/**
 * implements MessageHandlers based on enum
 */
enum MessageHandlers implements MessageHandler {
    /**
     * text handler
     */
    TEXT_HANDLER(MessageType.TEXT) {
        @Override
        boolean doHandle(Message message) {
            LOG.info("text");
            return true;
        }
    },
    /**
     * bin handler
     */
    BIN_HANDLER(MessageType.BIN) {
        @Override
        boolean doHandle(Message message) {
            LOG.info("bin");
            return true;
        }
    },
    /**
     * xml handler
     */
    XML_HANDLER(MessageType.XML) {
        @Override
        boolean doHandle(Message message) {
            LOG.info("xml");
            return true;
        }
    },
    /**
     * json handler
     */
    JSON_HANDLER(MessageType.JSON) {
        @Override
        boolean doHandle(Message message) {
            LOG.info("json");
            return true;
        }
    },
    UNKNOWN_HANDLER(MessageType.UNKNOWN);

    private static final Logger LOG = LoggerFactory.getLogger(MessageHandlers.class);
    private final MessageType acceptType;

    MessageHandlers(MessageType acceptType) {
        this.acceptType = acceptType;
    }

    boolean doHandle(Message message) {
        LOG.info("Cannot find suitable handler.");

        return false;
    }

    /**
     * if message type is accept type, then call doHandle to handle message.
     *
     * @param message
     * @return handle response: 1 is success; 0 is failed
     */
    @Override
    public boolean handle(Message message) {
        return message.getType() == this.acceptType && doHandle(message);
    }
}

/**
 * define message handler
 */
interface MessageHandler {
    /**
     * handle difference type message.
     *
     * @param message
     * @return
     */
    boolean handle(Message message);
}

/**
 * @author zack <br>
 * @create 2020-04-05 00:11 <br>
 */
public class ResponsibilityChainUsageTest {

    private static final Logger LOG = LoggerFactory.getLogger(ResponsibilityChainUsageTest.class);

    @Test
    public void testMessageHandlerChain() {
        MessageHandlerChain messageHandlerChain = new MessageHandlerChain();
        LOG.info(
                "handle JSON type message {} success!",
                messageHandlerChain.handle(new Message(MessageType.JSON)) == true
                        ? "is"
                        : "is not");
        LOG.info(
                "handle UNKNOWN type message {} success!",
                messageHandlerChain.handle(new Message(MessageType.UNKNOWN)) == true
                        ? "is"
                        : "is not");
    }
}

/**
 * define message
 */
class Message {
    private final MessageType type;

    public Message(MessageType type) {
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }
}

/**
 * message handle chain
 */
class MessageHandlerChain {
    public boolean handle(Message message) {
        for (MessageHandler handler : MessageHandlers.values()) {
            if (handler.handle(message)) {
                return true;
            }
        }
        return false;
    }
}
