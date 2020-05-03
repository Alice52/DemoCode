package cn.edu.ntu.boot.encrypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-03 21:23 <br>
 */
@SpringBootApplication
public class SpringBootConfigEncryptApplication implements CommandLineRunner {

  @Resource private ApplicationContext appCtx;

  @Resource private StringEncryptor codeSheepEncryptorBean;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootConfigEncryptApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Environment environment = appCtx.getBean(Environment.class);

    // 首先获取配置文件里的原始明文信息
    String mysqlOriginPswd = environment.getProperty("zack");

    // 加密
    String mysqlEncryptedPswd = encrypt(mysqlOriginPswd);

    // 打印加密前后的结果对比
    System.out.println("MySQL原始明文密码为：" + mysqlOriginPswd);
    System.out.println("====================================");
    System.out.println("MySQL原始明文密码加密后的结果为：" + mysqlEncryptedPswd);
    System.out.println("====================================");
    System.out.println("MySQL密码解密后的结果为：" + decrypt(mysqlEncryptedPswd));
  }

  private String encrypt(String originPassord) {
    String encryptStr = codeSheepEncryptorBean.encrypt(originPassord);
    return encryptStr;
  }

  private String decrypt(String encryptedPassword) {
    String decryptStr = codeSheepEncryptorBean.decrypt(encryptedPassword);
    return decryptStr;
  }
}
