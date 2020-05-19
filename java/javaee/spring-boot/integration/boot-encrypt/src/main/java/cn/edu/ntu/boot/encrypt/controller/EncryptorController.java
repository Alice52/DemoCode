package cn.edu.ntu.boot.encrypt.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;

import cn.edu.ntu.javaee.boot.common.model.ErrorMessage;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.ApplicationContext;
import javax.annotation.Resource;

/**
* @author zack <br/>
* @create 2020-05-03 22:04 <br/>
*/
@Api
@RestController
@ApiResponses({
  @ApiResponse(code = 400, message = "Internal Error", response = ErrorMessage.class)
})
public class EncryptorController {

  @Resource private ApplicationContext appCtx;

  @Resource private StringEncryptor codeSheepEncryptorBean;

    @GetMapping("/encrypt")
   public String doEncrypt(@RequestParam("word") String word) {

    String mysqlEncryptedPswd = encrypt(word);

    return mysqlEncryptedPswd;
  }

  private String encrypt(String originPassword) {
    String encryptStr = codeSheepEncryptorBean.encrypt(originPassword);
    return encryptStr;
  }

  private String decrypt(String encryptedPassword) {
    String decryptStr = codeSheepEncryptorBean.decrypt(encryptedPassword);
    return decryptStr;
  }
}
