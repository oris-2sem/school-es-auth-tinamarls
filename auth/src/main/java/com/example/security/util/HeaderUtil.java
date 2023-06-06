package com.example.security.util;

import javax.servlet.http.HttpServletRequest;

public interface HeaderUtil {
    boolean hasAuthorizationToken(HttpServletRequest request);

    String getToken(HttpServletRequest request);

}
