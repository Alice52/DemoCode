//package cn.edu.ntu.javaee.boot.common.encrypt;
//
//import org.jasypt.encryption.StringEncryptor;
//import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
//import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
//
///**
// * // TODO: make this here and use every, how to use other beans ioc bean
// *
// * @author zack <br>
// * @create 2020-05-03 22:04 <br>
// */
//public class CustomEncryptorConfig {
//
//  public StringEncryptor stringEncryptor() {
//
//    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//
//    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//    config.setPassword("CodeSheep");
//    config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
//    config.setKeyObtentionIterations("1000");
//    config.setPoolSize("1");
//    config.setProviderName("SunJCE");
//    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//    config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
//    config.setStringOutputType("base64");
//    encryptor.setConfig(config);
//
//    return encryptor;
//  }
//}
