import com.isoft.dao.NewsDao;
import com.isoft.dao.SysDao;
import com.isoft.entity.News;
import com.isoft.entity.Sys;
import com.isoft.service.NewsService;
import com.isoft.service.SysService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestSys {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml") ;
 //       SysDao sysDao = (SysDao) ioc.getBean("sysDao");
//        System.out.println(sysDao.getByName("aa"));
//        System.out.println(sysDao.getByName("admin"));
//        System.out.println(sysDao.getByNamePwd("admin","aa"));
//        System.out.println(sysDao.getByNamePwd("admin","admin"));

        /*SysService sysService = (SysService) ioc.getBean("sysService");
        System.out.println(sysService.login("aa","aa"));
        System.out.println(sysService.login("admin","aa"));
        System.out.println(sysService.login("admin","admin"));*/

        //管理员操作测试 Dao（添加用户，修改密码）
       /* SysDao sysDao = (SysDao) ioc.getBean("sysDao");
        System.out.println(sysDao.add("ad","123","1234567890"));
        System.out.println(sysDao.add("ad","123","1234567890"));
        System.out.println(sysDao.add("ad","123","1234567890"));
        System.out.println(sysDao.getCountByName("ad"));
        System.out.println(sysDao.checkPwd(1,"aaa"));
        System.out.println(sysDao.updatePwd(1,"123"));*/

        //管理员操作测试 Service(添加用户，修改密码)
        SysService sysService = (SysService) ioc.getBean("sysService");
//        System.out.println(sysService.add("admin","2342222222"));
//        System.out.println(sysService.checkPwd(1,"123"));
//        System.out.println(sysService.repass(1,"234"));


        //新闻页Dao测试
       /* News news = new News();

        NewsDao newsDao = (NewsDao) ioc.getBean("newsDao");
        news.setTypeid(1);
        news.setTitle("海绵宝宝");
        news.setContent("你好再见");
        news.setPublishdt(new Date());
        news.setComeform("idea");
        System.out.println(newsDao.insert(news));
        System.out.println(newsDao.getPage(4,3,"海绵宝宝",1));
        System.out.println(newsDao.getCount("海绵宝宝",1));
        System.out.println(newsDao.getById(1));*/

       //新闻页service测试
       // NewsService newsService = (NewsService) ioc.getBean("newsService");


        Sys sys = new Sys();
        sys.setId(2);
        sys.setState(1);

        System.out.println(sysService.updateState(sys));



    }
}
