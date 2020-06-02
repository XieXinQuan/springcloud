package com.quan.interceptor;

/**
 * @author: xiexinquan520@163.com
 * User: XieXinQuan
 * DATE:2020/5/6
 */
//@Configuration
public class FeignInterceptor
//        implements RequestInterceptor
{
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        if (requestAttributes == null) {
//            return;
//        }
//
//        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        if (headerNames != null) {
//            while (headerNames.hasMoreElements()) {
//                String name = headerNames.nextElement();
//                String value = request.getHeader(name);
//                requestTemplate.header(name, value);
////                Enumeration<String> values = request.getHeaders(name);
////                while (values.hasMoreElements()) {
////                    String value = values.nextElement();
////                    requestTemplate.header(name, value);
////                }
//            }
//        }
//        System.out.println(requestTemplate);

//    }
}
