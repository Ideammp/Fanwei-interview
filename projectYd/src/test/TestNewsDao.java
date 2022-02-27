import com.isoft.dao.NewsDao;
import com.isoft.entity.News;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNewsDao {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

       // NewsDao newsDao = (NewsDao) ioc.getBean("newsDao");
        //System.out.println(newsDao.getPage(0,10,"向往的生活",null));
        //System.out.println(newsDao.getCount("海绵宝宝",null));
        //System.out.println(newsDao.insert(new News()));



        //Dao层("排错完成😊")
        /*News news = new News();
        news.setId(3);
        news.setTitle("派大星你好");
        news.setContent("我们都要前进去大海了");
        news.setComefrom("koko");

        System.out.println(newsDao.updateById(news));*/

        //System.out.println(newsDao.delById(7));

        /*Integer[] ids = {4,5};

        System.out.println(newsDao.delByIds(ids));*/









    }
}
