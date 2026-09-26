package ru.netology;

import org.junit.jupiter.api.Test;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {
 @Test void createsAndUpdates() { var r=new PostRepository(); var p=r.save(new Post(0,"A","B")); assertEquals(1,p.getId()); var u=r.save(new Post(p.getId(),"C","D")); assertEquals("C",u.getTitle()); assertEquals("C",r.getById(1).getTitle()); }
 @Test void concurrentCreateGetsUniqueIds() throws Exception { var r=new PostRepository(); var pool=Executors.newFixedThreadPool(8); var futures=new java.util.ArrayList<Future<Post>>(); for(int i=0;i<100;i++) futures.add(pool.submit(()->r.save(new Post(0,"t","c")))); var ids=new java.util.HashSet<Long>(); for(var f:futures) ids.add(f.get().getId()); pool.shutdown(); assertEquals(100,ids.size()); }
}
