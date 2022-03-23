package com.example.cp.oms;

import com.maoyang.enforce.runtime.registry.Container;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

/**
 * 下单：
 * curl -XPOST localhost:9090/order
 * 热加载：
 * curl localhost:9090/reload
 */
@Slf4j
public class StartServer {
    private static final int DEFAULT_PORT = 9090;
    private static final String CONTEXT_PATH = "/";
    private static final String MAPPING_URL = "/*";


    private static final String CONFIG_LOCATION = "com.example.cp.oms.config";
    private static final String PLUGIN_LOCATION = "com.example.cp.oms.plugin";

    public static void main(String[] args) throws Exception {
        int port = DEFAULT_PORT;
        String config = CONFIG_LOCATION;
        if (args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException ignored) {
                log.error("Invalid arg", ignored);
            }

            if (args.length > 1) {
                config = PLUGIN_LOCATION;
                log.info("Using config:{}", config);
            }
        }

        new StartServer().startJetty(port, config);
    }

    private void startJetty(int port, String config) throws Exception {
        log.info("Starting server at port {}", port);
        Server server = new Server(port);
        server.setHandler(getServletContextHandler(getContext(config)));
        server.start();
        log.info("Server started at port {}", port);
        log.info("active plugins: {}", Container.getInstance().getActivePlugins());
        log.info("start success");
        server.join();
    }

    private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        return contextHandler;
    }

    private static WebApplicationContext getContext(String config) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(config);
        return context;
    }

}
