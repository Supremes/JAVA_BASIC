package org.dododo.aop;

import org.dododo.common.TimeTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/family/get/*")
public class JunkFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(JunkFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("Filter before: " + TimeTools.getCurrentTime());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.debug("Filter after:{} , ClassName:{} " , TimeTools.getCurrentTime(), JunkFilter.class);
    }
}
