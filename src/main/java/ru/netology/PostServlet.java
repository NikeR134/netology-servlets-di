package ru.netology;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class PostServlet extends HttpServlet {
    protected PostController controller;
    protected final ObjectMapper mapper = new ObjectMapper();

    @Override public void init() throws ServletException {
        final var repository = new PostRepository();
        final var service = new PostService(repository);
        controller = new PostController(service);
    }

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        String id = req.getParameter("id");
        if (id == null) mapper.writeValue(resp.getWriter(), controller.all());
        else { Post post = controller.getById(Long.parseLong(id)); if (post == null) resp.setStatus(404); else mapper.writeValue(resp.getWriter(), post); }
    }
    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Post post = mapper.readValue(req.getReader(), Post.class);
        Post saved = controller.save(post); resp.setStatus(201); resp.setContentType("application/json;charset=UTF-8"); mapper.writeValue(resp.getWriter(), saved);
    }
    @Override protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Post post = mapper.readValue(req.getReader(), Post.class);
        if (post.getId() == 0) { resp.setStatus(400); return; }
        try { Post saved=controller.save(post); resp.setContentType("application/json;charset=UTF-8"); mapper.writeValue(resp.getWriter(), saved); }
        catch (IllegalArgumentException e) { resp.setStatus(404); }
    }
    @Override protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id=req.getParameter("id"); if(id==null){resp.setStatus(400);return;}
        if(controller.removeById(Long.parseLong(id))) resp.setStatus(204); else resp.setStatus(404);
    }
}
