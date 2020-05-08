import com.example.SakilaApplication;
import com.example.domain.actor.Actor;
import com.example.service.actor.ActorService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class ActorTest {

    @Autowired
    private ActorService actorService;

    @Test
    public void findOneById() {
        Actor actor = actorService.findOneById(1);
        assert (actor != null);
        System.out.println(actor.toString());
    }

}
