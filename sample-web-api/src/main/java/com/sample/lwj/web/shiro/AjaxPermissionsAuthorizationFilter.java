package com.sample.lwj.web.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 * @date 2021/8/5 8:46
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code", CodeEnum.EXPIRED_CREDENTIALS.getCode());
//        jsonObject.put("msg", CodeEnum.EXPIRED_CREDENTIALS.getMsg());
//        JSONObject errorObject = new JSONObject();
//        jsonObject.put("data", errorObject);
//        PrintWriter out = null;
//        HttpServletResponse res = (HttpServletResponse) response;
//        try {
//            res.setCharacterEncoding("UTF-8");
//            res.setContentType("application/json");
//            out = response.getWriter();
//            out.println(jsonObject);
//        } catch (Exception e) {
//        } finally {
//            if (null != out) {
//                out.flush();
//                out.close();
//            }
//        }
//        return false;
//    }
//
//    @Bean
//    public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//        registration.setEnabled(false);
//        return registration;
//    }
}
