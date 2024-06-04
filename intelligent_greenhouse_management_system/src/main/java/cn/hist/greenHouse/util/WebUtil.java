package cn.hist.greenHouse.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: Web工具类
 * Data time:2022/9/1 11:11
 * Author:TQ-3038-HuangGongWei
 */
public class WebUtil
{
    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return null
     */
    public static String renderString(HttpServletResponse response, String string) {
        try
        {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
