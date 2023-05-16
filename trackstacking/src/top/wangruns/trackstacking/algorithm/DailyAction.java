// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationContext;
import top.wangruns.trackstacking.model.Collection;
import top.wangruns.trackstacking.model.PlayRecord;
import top.wangruns.trackstacking.model.DownloadRecord;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import top.wangruns.trackstacking.utils.Static;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContext;
import java.util.TimerTask;
import org.springframework.web.context.WebApplicationContext;
import top.wangruns.trackstacking.service.SongService;
import top.wangruns.trackstacking.service.UserService;
import top.wangruns.trackstacking.service.CollectionService;
import top.wangruns.trackstacking.service.RecordPlayService;
import top.wangruns.trackstacking.service.RecordDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.PersonalRecService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;

public class DailyAction implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private PersonalRecService personalRecService;
    @Autowired
    private RecordDownloadService recordDownloadService;
    @Autowired
    private RecordPlayService recordPlayService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private UserService userService;
    @Autowired
    private SongService songService;
    //public static volatile boolean isFirtTimeInit;
    public static boolean isFirtTimeInit;
    static {
        DailyAction.isFirtTimeInit = true;
    }
    
    public void onApplicationEvent(final ContextRefreshedEvent arg0) {
        System.out.println("###-----Spring \u5bb9\u5668\u52a0\u8f7d\u5b8c\u6bd5_-_-----###");
        this.init(arg0);
    }
    
    private void init(final ContextRefreshedEvent arg0) {
        if (DailyAction.isFirtTimeInit) {
            System.out.println("###-----\u5f00\u59cbListener_-_-----###");
            final ApplicationContext applicationContext = arg0.getApplicationContext();
            final WebApplicationContext webApplicationContext = (WebApplicationContext)applicationContext;
            final ServletContext servletContext = webApplicationContext.getServletContext();
            final Listener listener = new Listener(new TimerTask() {
                public void run() {
                    System.out.println("------------\u5f00\u59cb\u6267\u884c\u4efb\u52a1-------------");
                    try {
                        TimeUnit.SECONDS.sleep(10L);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    DailyAction.this.userService.getAllRecords();
                    Static.isFromA = !Static.isFromA;
                    Map<Integer, Integer[]> user2songRecMatrix = new HashMap<Integer, Integer[]>();
                    final List<DownloadRecord> downloadList = DailyAction.this.recordDownloadService.getAllRecords();
                    final List<PlayRecord> playList = DailyAction.this.recordPlayService.getAllRecords();
                    final List<Collection> collectionList = DailyAction.this.collectionService.getAllRecords();
                    final List<Integer> userIdList = DailyAction.this.userService.getAllUserIdRecords();
                    final List<Integer> songIdList = DailyAction.this.songService.getAllSongIdRecords();
                    final Map<Integer, float[]> user2songRatingMatrix = DataTranslate.getFrequencyMatrix(userIdList, songIdList, downloadList, playList, collectionList);
                    final Map<Integer, Integer[]> userKNNMatrix = UserKNN.getKNN(userIdList, user2songRatingMatrix, 2);
                    user2songRecMatrix = CollaborativeFiltering.userKNNBasedCF(userIdList, userKNNMatrix, user2songRatingMatrix, songIdList, 10);
                    System.out.println("------------\u6267\u884c\u4efb\u52a1\u5b8c\u6210-------------");
                    if (Static.isFromA) {
                        DailyAction.this.personalRecService.updatePersonalRecIntoB(user2songRecMatrix);
                    }
                    else {
                        DailyAction.this.personalRecService.updatePersonalRecIntoA(user2songRecMatrix);
                    }
                }
            });
            listener.listen(6, 0, 0, 86400000L, false);
        }
        DailyAction.isFirtTimeInit = false;
    }
}
