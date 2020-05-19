package cn.edu.ntu.boot.encrypt.controller;

import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-03 22:04 <br>
 */
@Api
@RestController
@ApiResponses({@ApiResponse(code = 400, message = "Internal Error", response = ErrorResponse.class)})
public class EncryptController {

  @Resource private ApplicationContext appCtx;

  @Resource private StringEncryptor encryptBean;

  @GetMapping("/encrypt")
  public String doEncrypt(@RequestParam("word") String word) {

    String mysqlEncryptedPswd = encrypt(word);

    return mysqlEncryptedPswd;
  }

  private String encrypt(String originPassword) {
    String encryptStr = encryptBean.encrypt(originPassword);
    return encryptStr;
  }

  private String decrypt(String encryptedPassword) {
    String decryptStr = encryptBean.decrypt(encryptedPassword);
    return decryptStr;
  }
}
