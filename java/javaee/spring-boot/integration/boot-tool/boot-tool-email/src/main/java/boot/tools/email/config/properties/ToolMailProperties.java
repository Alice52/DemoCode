package boot.tools.email.config.properties;

import cn.edu.ntu.javaee.boot.common.utils.JasyptUtils;
import lombok.Data;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author zack <br>
 * @create 2021-05-16<br>
 * @project integration <br>
 */
@Data
@ConfigurationProperties(prefix = "spring.mail")
public class ToolMailProperties extends MailProperties {

    private static final Charset DEFAULT_CHARSET = UTF_8;

    /** SMTP server host. For instance, `smtp.example.com`. */
    private String host =
            JasyptUtils.decrypt("KwgyFVRJzE76uUF+B2EOyjJgijQDrxhRWzrUBa6eUfmduClTbtpaCVxXRWWctYSi");

    /** SMTP server port. */
    private Integer port =
            Integer.valueOf(
                    JasyptUtils.decrypt(
                            "nvvb0wOLlW+Kl+2CLMay0AyhVmWzXr5Ma2Tn4hTWSyMb95lPCjaIXpHm2Oms/9rB"));

    /** Login user of the SMTP server. */
    private String username =
            JasyptUtils.decrypt(
                    "XtxDqyspABu9dQ0xSZ0zRV7MfVfk/7tN1rE/wkjko5vcjA0vgqmcE10FxRRYlribavOUtBGNy2PDPHWtIrrFUg==");

    /** Login password of the SMTP server. */
    private String password =
            JasyptUtils.decrypt("cVfVnGq4tQ6J3+FtW0TejImmx2ESWomD/tuGN5bJqMGM8v+Of/onqraHBd9xhH0J");

    /** Protocol used by the SMTP server. */
    private String protocol = "smtp";

    /** Default MimeMessage encoding. */
    private Charset defaultEncoding = UTF_8;

    /** Additional JavaMail Session properties. */
    private Map<String, String> properties =
            new HashMap<String, String>() {
                {
                    put("mail.smtp.display.sendmail", "spring boot tool email");
                    put("mail.smtp.ssl.required", "true");
                    put("mail.smtp.writetimeout", "10000");
                    put("mail.smtp.starttls.required", "true");
                    put("mail.smtp.auth", "true");
                    put("mail.smtp.starttls.enable", "true");
                    put("mail.smtp.timeout", "10000");
                    put("mail.smtp.ssl.enable", "true");
                    put("mail.smtp.connectiontimeout", "10000");
                }
            };

    /** Session JNDI name. When set, takes precedence over other Session settings. */
    private String jndiName;
}
