package boot.tools.email.controller;

import boot.tools.email.service.IMailService;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.mail.MessagingException;
import java.net.URL;
import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2021-05-14 12:23 <br>
 * @project boot-security-shiro <br>
 */
@RestController
@RequestMapping("/email/")
public class EmailSenderController {
    @Autowired private IMailService mailService;
    @Autowired private TemplateEngine templateEngine;
    @Autowired private ApplicationContext context;

    /** 测试简单邮件 */
    @PostMapping("/simple")
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1252068782@qq.com", "这是一封简单邮件", "这是一封普通的SpringBoot测试邮件");
    }

    /**
     * 测试HTML邮件
     *
     * @throws MessagingException 邮件异常
     */
    @PostMapping("/html")
    public void sendHtmlMail() throws MessagingException {
        Context context = new Context();
        context.setVariable("project", "--");
        context.setVariable("author", "--");
        context.setVariable("url", "https://www.baidu.com");

        String emailTemplate = templateEngine.process("welcome", context);
        mailService.sendHtmlMail("1252068782@qq.com", "这是一封模板HTML邮件", emailTemplate);
    }

    /**
     * 测试HTML邮件，自定义模板目录
     *
     * @throws MessagingException 邮件异常
     */
    @PostMapping("/html-v2")
    public void sendHtmlMail2() throws MessagingException {

        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(context);
        templateResolver.setCacheable(false);
        templateResolver.setPrefix("classpath:/email/");
        templateResolver.setSuffix(".html");

        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("project", "Spring Boot Demo");
        context.setVariable("author", "Yangkai.Shen");
        context.setVariable("url", "https://github.com/xkcoding/spring-boot-demo");

        String emailTemplate = templateEngine.process("test", context);
        mailService.sendHtmlMail("1252068782@qq.com", "这是一封模板HTML邮件", emailTemplate);
    }

    /**
     * 测试附件邮件
     *
     * @throws MessagingException 邮件异常
     */
    @PostMapping("/attach")
    public void sendAttachmentsMail() throws MessagingException {
        URL resource = ResourceUtil.getResource("static/th.jpg");
        mailService.sendAttachmentsMail(
                "1252068782@qq.com", "这是一封带附件的邮件", "邮件中有附件，请注意查收！", resource.getPath());
    }

    /**
     * 测试静态资源邮件
     *
     * @throws MessagingException 邮件异常
     */
    @PostMapping("/resource")
    public void sendResourceMail() throws MessagingException {
        String rscId = "https://www.bing.com/th?id=OHR.AltaFloresta_ZH-CN9153671055_1920x1080.jpg";
        String content = "<html><body>这是带静态资源的邮件<br/><img src=\'" + rscId + "\' ></body></html>";
        URL resource = ResourceUtil.getResource("static/th.jpg");
        mailService.sendImageMail(Arrays.asList("1252068782@qq.com"), "这是一封带静态资源的邮件", content);
    }

    @PostMapping("/http")
    public Object http() throws MessagingException {
        String s = HttpUtil.get("https://v1.alapi.cn/api/shici");
        JSONObject jsonObject = JSONUtil.parseObj(s);
        JSONObject data = JSONUtil.parseObj(jsonObject.get("data"));

        mailService.sendImageMail(
                Arrays.asList("1252068782@qq.com", "1035950489@qq.com"),
                data.get("category"),
                data.get("content"));

        return data;
    }

    @PostMapping("/tip")
    public Object tip() throws MessagingException {
        String s = HttpUtil.get("https://v1.alapi.cn/api/mryw");
        JSONObject jsonObject = JSONUtil.parseObj(s);
        JSONObject data = JSONUtil.parseObj(jsonObject.get("data"));

        mailService.sendImageMail(
                Arrays.asList("1252068782@qq.com", "1035950489@qq.com"),
                data.get("title"),
                data.get("content"));

        return data;
    }
}
