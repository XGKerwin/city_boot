package com.city.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 关鑫
 * @date 2021/9/17 16:32 星期五
 * @Description com.city.util
 */
public class ServletUtils {

    public static String getImageUrl(String imageName){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        String servletPath = request.getServletPath();
        int index = requestURL.indexOf(servletPath);
        return requestURL.delete(index+1 , requestURL.length())+"images/"+imageName;
    }

}
