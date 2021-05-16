// package boot.tools.email.utils;
//
// import cn.edu.ntu.javaee.boot.common.utils.ICryptUtil;
// import org.jasypt.encryption.StringEncryptor;
// import org.springframework.stereotype.Component;
//
// import javax.annotation.Resource;
// import java.util.Map;
//
/// **
// * @author zack <br>
// * @create 2021-05-16<br>
// * @project integration <br>
// */
// @Component
// public class CryptUtil implements ICryptUtil {
//    @Resource private StringEncryptor encryptBean;
//
//    @Override
//    public String decrypt(String decryWord) {
//
//        return encryptBean.decrypt(decryWord);
//    }
//
//    @Override
//    public String encrypt(String encryptWord) {
//        return encryptBean.encrypt(encryptWord);
//    }
//
//    public static void main(String[] args) {
//        Map<String, String> getenv =
//                System.getenv();
//
//
//        String as = System.getenv("JASYPT_ENCRYPTOR_PASSWORD");
//    }
// }
