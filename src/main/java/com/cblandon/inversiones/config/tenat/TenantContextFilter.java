package com.cblandon.inversiones.config.tenat;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TenantContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String tenantId = ((HttpServletRequest) request).getHeader("X-Tenant-ID");
        TenantContext.setCurrentTenant(tenantId); // Aquí puedes usar un `ThreadLocal` para guardar el `tenantId`.
        chain.doFilter(request, response);
    }

}
