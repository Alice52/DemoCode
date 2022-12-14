package cn.edu.ntu.java.javase.agent.common;

import java.util.regex.Pattern;

/**
 * @author zack <br>
 * @create 2020-09-20 13:05 <br>
 * @project javase <br>
 */
public class WildcardMatcher {

    private final Pattern pattern;

    public WildcardMatcher(final String expression) {

        final String[] parts = expression.split("&");
        final StringBuilder regex = new StringBuilder(expression.length() * 2);
        boolean next = false;

        for (final String part : parts) {
            if (next) {
                regex.append("|");
            }

            regex.append("(").append(toRegex(part)).append(")");

            next = true;
        }

        this.pattern = Pattern.compile(regex.toString());
    }

    private CharSequence toRegex(final String expression) {

        final StringBuilder regex = new StringBuilder(expression.length() * 2);

        for (final char c : expression.toCharArray()) {
            switch (c) {
                case '?':
                    regex.append(".?");
                    break;
                case '*':
                    regex.append(".*");
                    break;
                default:
                    regex.append(Pattern.quote(String.valueOf(c)));
                    break;
            }
        }

        return regex;
    }

    public boolean matches(final String s) {
        return pattern.matcher(s).matches();
    }
}
