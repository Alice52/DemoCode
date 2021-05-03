package cn.edu.ntu.javaee.springboot.syntax.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author zack
 * @create 2019-12-25 22:37
 * @function
 */
public class CustomLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lg = request.getParameter("lg");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(lg)) {
            String[] split = lg.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(
            HttpServletRequest request, HttpServletResponse response, Locale locale) {}
}
