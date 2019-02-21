package com.guobaoru.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by guobaoru.
 * @create on 2019/2/21.
 */
@Component
public class LogFilter extends ZuulFilter {

    /**
     * 过滤器类别，zuul的默认实现有四种，pre、routing、post、error
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器级别
     * @return
     */
    @Override
    public int filterOrder() {
        /**
         * zuul各个类别的filter各有一个默认的过滤器
         * FilterConstants.PRE_DECORATION_FILTER_ORDER 参数即为 pre默认过滤器的级别
         * -1 代表在默认过滤器之前执行
         * +1 可拿到路由后的地址
         */
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 过滤器是否启用，默认为false，启动需改为true
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器实际执行逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String puth = context.get(FilterConstants.REQUEST_URI_KEY).toString();
        System.out.println("PRE Filter ## URI: " + request.getRequestURI());
        System.out.println("路由后的 URI: " + puth);
        return null;
    }
}
