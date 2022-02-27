import com.isoft.dao.NewstypeDao;
import com.isoft.entity.Newstype;
import com.isoft.service.NewstypeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNewstype {
    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        //NewstypeDao 测试 (测试通过 😊)
//          NewstypeDao newstypeDao =(NewstypeDao) ioc.getBean("newstypeDao");
       // System.out.println(newstypeDao.all());

        //NewstypeService 测试（测试通过 😊）
        NewstypeService newstypeService = (NewstypeService) ioc.getBean("newstypeService");
       // System.out.println(newstypeService.getAll());


      //  System.out.println(newstypeDao.insert("喜剧"));
      //  System.out.println(newstypeDao.delById(4));


       // System.out.println(newstypeService.add("jijiji"));
      //  System.out.println(newstypeService.delById(5));

       // System.out.println(newstypeDao.getPage(0,10,"娱乐"));
       // System.out.println(newstypeDao.getCount("娱乐"));

//        Newstype newstype = new Newstype();
//        newstype.setId(8);
//        newstype.setTypename("你好");
//
//
//        System.out.println(newstypeDao.updateById(newstype));
//        System.out.println(newstypeService.updateById(newstype));




    }
}
