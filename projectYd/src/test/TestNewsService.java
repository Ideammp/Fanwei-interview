import com.isoft.entity.News;
import com.isoft.service.NewsService;
import com.sun.corba.se.impl.orb.AppletDataCollector;
import com.sun.media.jfxmediaimpl.HostUtils;
import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestNewsService {
    @Test
    public void test(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //NewsService （测试通过）
        NewsService newsService = (NewsService) ioc.getBean("newsService");
       // System.out.println(newsService.getById(1));
       // System.out.println(newsService.getPage(1,10,null,null));

        News news = new News();
        news.setId(1);
        news.setTitle("章鱼哥你好");
        news.setContent("我想邀请你去参加今晚的竖笛演奏表演");
        news.setComefrom("okok");


//        System.out.println(newsService.delById(8));
//        Integer[] ids = {9};
//        System.out.println(newsService.delByIds(ids));


        System.out.println(newsService.add(news));


    }
}
