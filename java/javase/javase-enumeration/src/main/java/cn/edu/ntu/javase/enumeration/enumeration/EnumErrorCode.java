package cn.edu.ntu.javase.enumeration.enumeration;

import cn.edu.ntu.javase.enumeration.constants.ErrorConstants;
import cn.edu.ntu.javase.enumeration.inter.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

/**
 * 1. private constructor <br>
 * 2. private property<br>
 * 3. expose property<br>
 * <br>
 * # Traverse<br>
 * 1. values() / EnumErrorCode.class.getEnumConstants()<br>
 * 2. valueOf(clz, name)<br>
 * 3. convert enum to Optional
 *
 * @author zack<br>
 * @create 2020-01-31 12:02<br>
 */
public enum EnumErrorCode implements ErrorInfo {
    UNEXPECTED_EXCEPTION("030000") {
        @Override
        public String getErrorInfo() {
            return ErrorConstants.UNEXPECTED_EXCEPTION;
        }
    },
    DB_EXCEPTION("030001") {
        @Override
        public String getErrorInfo() {
            return ErrorConstants.DB_EXCEPTION;
        }
    },
    BIZ_EXCEPTION("030002") {
        @Override
        public String getErrorInfo() {
            return ErrorConstants.BIZ_EXCEPTION;
        }
    },
    REPEAT_SUBMIT_EXCEPTION("030501") {
        @Override
        public String getErrorInfo() {
            return ErrorConstants.REPEAT_SUBMIT_EXCEPTION;
        }
    },
    SPECIAL_EXCEPTION("030502") {
        @Override
        public String getErrorInfo() {
            return ErrorConstants.PARAMETER_EXCEPTION;
        }
    },
    UNKNOWN_EXCEPTION("999999") {
        @Override
        public String getErrorInfo() {
            return ErrorConstants.UNKNOWN_EXCEPTION;
        }
    };

    private static final Logger LOG = LoggerFactory.getLogger(EnumErrorCode.class);
    private final String errorCode;

    EnumErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public static String getMessageByErrorCode(final String errorCode) {
        return Arrays.stream(values())
                .filter(enumErrorCode -> enumErrorCode.getErrorCode().equals(errorCode))
                .findFirst()
                .orElse(UNKNOWN_EXCEPTION)
                .getErrorInfo();
    }

    public static String getCodeByErrorMessage(final String errorMessage) {
        Optional<EnumErrorCode> errorCode =
                Arrays.stream(EnumErrorCode.class.getEnumConstants())
                        .filter(enumErrorCode -> enumErrorCode.getErrorInfo().equals(errorMessage))
                        .findFirst();
        return errorCode.isPresent() ? errorCode.get().getErrorCode() : null;
    }

    /**
     * Get enum by enum name
     *
     * @param enumName
     * @return Enum
     */
    public static EnumErrorCode getByEnumName(final String enumName) {
        Optional<EnumErrorCode> errorCode = getValueOf(EnumErrorCode.class, enumName);
        return errorCode.isPresent() ? errorCode.get() : null;
    }

    /**
     * Convert enum to Optional, and handle IllegalArgumentException.
     *
     * @param enumType
     * @param name
     * @return Optional<Enum> or Optional.empty()
     */
    public static Optional<EnumErrorCode> getValueOf(Class<EnumErrorCode> enumType, String name) {
        EnumErrorCode enumValue;
        try {
            enumValue = Enum.valueOf(enumType, name);
        } catch (IllegalArgumentException ex) {
            LOG.info(
                    "occurs IllegalArgumentException when get enum[{}] by enum name: {}, so return {}",
                    enumType,
                    name,
                    Optional.empty());
            return Optional.empty();
        }
        return Optional.ofNullable(enumValue);
    }

    @Override
    public String toString() {
        return "EnumErrorCode{"
                + "errorCode='"
                + errorCode
                + '\''
                + ", errorMessage='"
                + getMessageByErrorCode(errorCode)
                + '\''
                + '}';
    }

    public String getErrorCode() {
        return errorCode;
    }
}
