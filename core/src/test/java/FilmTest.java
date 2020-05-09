import com.example.SakilaApplication;
import com.example.domain.film.Film;
import com.example.domain.film.FilmActor;
import com.example.domain.film.FilmText;
import com.example.domain.film.key.FilmActorKey;
import com.example.domain.language.Language;
import com.example.service.film.FilmActorService;
import com.example.service.film.FilmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class FilmTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmActorService filmActorService;

    /**
     *
     */
    @Test
    public void findOneById() {
        Film film = filmService.findOneById(1);
        assert (film != null);
        System.out.println(film.toString());
        assert (film.getFilmText() != null);
        logger.info("film text:{}", film.getFilmText().toString());
    }

    /**
     * findOneFilmActor
     */
    @Test
    public void findOneFilmActor() {
        FilmActorKey filmActorKey = new FilmActorKey();
        filmActorKey.setActorId(1);
        filmActorKey.setFilmId(1);
        FilmActor filmActor = filmActorService.findOneById(filmActorKey);
        assert (filmActor != null);
        System.out.println("" + filmActor.toString());
    }

    /**
     * 分页查询测试（对象属性的值查询）
     */
    @Test
    public void findFormByPage() {
        Film queryFilm = new Film();
        //file
        FilmText filmText = new FilmText();
        //设置电影文本的标题
        filmText.setTitle("LAWLESS VISION");
        //
        queryFilm.setTitle("VISION");

        Language language = new Language();
        // 选择英文语言
        language.setName("English");
        //设置对象属性
        queryFilm.setFilmText(filmText);
        //
        queryFilm.setLanguage(language);
        Page<Film> filmPage = filmService.findAllByPage(queryFilm, 1, 50);
        Stream<Film> filmStream = filmPage.get();
        logger.info("filmStream :{}", filmStream.count());
        List<Film> filmList = filmPage.getContent();
        for (Film film : filmList) {
            //film title
            logger.info("film title:{}", film.getTitle());
            //language
            logger.info("film language:{}", film.getLanguage().getName());
            //film text
            logger.info("film text:{}", film.getFilmText().toString());
        }

        List<Film> films = filmService.queryByConditions(queryFilm);
        for(Film film :films){
            logger.info("film title:{}", film.getTitle());
            //language
            logger.info("film language:{}", film.getLanguage().getName());
            //film text
            logger.info("film text:{}", film.getFilmText().toString());
        }
    }
}
