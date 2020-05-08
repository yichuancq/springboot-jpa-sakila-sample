import com.example.SakilaApplication;
import com.example.domain.inventory.Inventory;
import com.example.service.inventory.InventoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SakilaApplication.class)
public class InventoryTest {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private InventoryService inventoryService;

    @Test
    public void findOneById() {
        Inventory inventory = inventoryService.findOneById(1);
        //
        assert (inventory != null);
        //get film
        assert (inventory.getFilm() != null);
        logger.info("电影的标题:{}", inventory.getFilm().getTitle());
        //get store address
        assert (inventory.getStore() != null);
        logger.info("获取库存地址 addr:{}", inventory.getStore().getAddress());
        //addr city
        assert (inventory.getStore().getAddress() != null &&
                inventory.getStore().getAddress().getCity() != null);
        logger.info("获取库存地址 city:{}", inventory.getStore().getAddress().getCity());
    }
}
