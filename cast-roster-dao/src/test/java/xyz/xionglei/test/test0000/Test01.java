package xyz.xionglei.test.test0000;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.xionglei.dao.IPerformerRepository;
import xyz.xionglei.domain.PerformerEntity;
import xyz.xionglei.test.AbstractTest;

public class Test01 extends AbstractTest {

    @Autowired
    private IPerformerRepository performerDao;

    @Override
    public void test() {
        PerformerEntity performer = new PerformerEntity();
        performer.setName("枫花可恋");
        performer.setAge(22);
        performer.setImg("/performer/maple");
        performerDao.save(performer);
        performer.setName("明日花绮罗");
        performerDao.save(performer);
        System.out.println(performerDao.findAll());
    }
}
