package cn.edu.ntu.springcloud.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author zack <br>
 * @create 2020-04-16 15:15 <br>
 */
public final class IPUntils {
  public static void main(String[] args) throws Exception {
    System.out.println(IPUntils.getInterIP1());
    System.out.println(IPUntils.getInterIP2());
    System.out.println(IPUntils.getOutIPV4());
  }

  public static String getInterIP1() throws Exception {
    return InetAddress.getLocalHost().getHostAddress();
  }

  public static String getInterIP2() throws SocketException {
    // 本地IP，如果没有配置外网IP则返回它
    String localip = null;
    // 外网IP
    String netip = null;
    Enumeration<NetworkInterface> netInterfaces;
    netInterfaces = NetworkInterface.getNetworkInterfaces();
    InetAddress ip = null;
    // 是否找到外网IP
    boolean finded = false;
    while (netInterfaces.hasMoreElements() && !finded) {
      NetworkInterface ni = netInterfaces.nextElement();
      Enumeration<InetAddress> address = ni.getInetAddresses();
      while (address.hasMoreElements()) {
        ip = address.nextElement();
        if (!ip.isSiteLocalAddress()
            && !ip.isLoopbackAddress()
            && !ip.getHostAddress().contains(":")) {
          // 外网IP
          netip = ip.getHostAddress();
          finded = true;
          break;

        } else if (ip.isSiteLocalAddress()
            && !ip.isLoopbackAddress()
            && !ip.getHostAddress().contains(":")) {
          // 内网IP
          localip = ip.getHostAddress();
        }
      }
    }
    if (netip != null && !"".equals(netip)) {
      return netip;
    } else {
      return localip;
    }
  }

  public static String getOutIPV4() {
    String ip = "";
    String chinaz = "http://ip.chinaz.com";

    StringBuilder inputLine = new StringBuilder();
    String read = "";
    URL url = null;
    HttpURLConnection urlConnection = null;
    BufferedReader in = null;
    try {
      url = new URL(chinaz);
      urlConnection = (HttpURLConnection) url.openConnection();
      in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
      while ((read = in.readLine()) != null) {
        inputLine.append(read + "\r\n");
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    Pattern p = compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
    Matcher m = p.matcher(inputLine.toString());
    if (m.find()) {
      String ipstr = m.group(1);
      ip = ipstr;
    }
    return ip;
  }
}
