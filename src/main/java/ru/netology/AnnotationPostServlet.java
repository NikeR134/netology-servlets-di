package ru.netology;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.config.AnnotationConfig;
import javax.servlet.ServletException;

public class AnnotationPostServlet extends PostServlet {
    private AnnotationConfigApplicationContext context;
    @Override public void init() throws ServletException {
        context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        controller = context.getBean(DiController.class);
    }
    @Override public void destroy() { if (context != null) context.close(); }
}
