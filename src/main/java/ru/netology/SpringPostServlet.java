package ru.netology;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.config.AppConfig;

import javax.servlet.ServletException;

/** Servlet variant used by the DI branches. */
public class SpringPostServlet extends PostServlet {
    private AnnotationConfigApplicationContext context;

    @Override public void init() throws ServletException {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        controller = context.getBean(PostController.class);
    }

    @Override public void destroy() {
        if (context != null) context.close();
    }
}
