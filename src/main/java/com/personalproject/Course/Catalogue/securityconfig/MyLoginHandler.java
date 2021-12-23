package com.personalproject.Course.Catalogue.securityconfig;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyLoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public MyLoginHandler(String defaultTargetUrl){
        setDefaultTargetUrl(defaultTargetUrl);
    }
//    public String getHref(String referrer){
//        int N = referrer.length();
//        StringBuilder sb = new StringBuilder();
//        while(referrer.charAt(--N)!='/'){
//            sb.append(referrer.charAt(N));
//        }
//        return new String(sb.reverse());
//    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("Session is "    +session);
        if (session != null) {
            System.out.println("session not null");
            String redirectUrl = (String) session.getAttribute("url_prior_login");
//            System.out.println(getHref(redirectUrl));
//            if(getHref(redirectUrl).equals("register")){
//                session.removeAttribute("url_prior_login");
//                System.out.println("Came from Register");
//            }
            System.out.println(redirectUrl);
            if (/*!getHref(redirectUrl).equals("register") && */redirectUrl != null) {
                // clean this attribute from session
                session.removeAttribute("url_prior_login");
                // redirect
                System.out.println("Did i come?>>?>??>?>?>");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
                System.out.println("Redirecting...");
            }
            else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        }
        else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
