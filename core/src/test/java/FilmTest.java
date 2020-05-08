import com.example.SakilaApplication;
import com.example.domain.film.Film;
import com.example.domain.film.FilmActor;
import com.example.domain.film.key.FilmActorKey;
import com.example.service.film.FilmActorService;
import com.example.service.film.FilmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class FilmTest {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmActorService filmActorService;

    @Test
    public void findOneById() {
        Film film = filmService.findOneById(1);
        assert (film != null);
        System.out.println(film.toString());
    }

    @Test
    public void findOneFilmActor() {
        FilmActorKey filmActorKey = new FilmActorKey();
        filmActorKey.setActorId(1);
        filmActorKey.setFilmId(1);
        FilmActor filmActor = filmActorService.findOneById(filmActorKey);
        assert (filmActor != null);
        System.out.println("" + filmActor.toString());
    }

}
