// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.algorithm;

import top.wangruns.trackstacking.model.Collection;
import top.wangruns.trackstacking.model.PlayRecord;
import top.wangruns.trackstacking.model.DownloadRecord;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import top.wangruns.trackstacking.utils.Static;
import java.util.concurrent.TimeUnit;
import top.wangruns.trackstacking.service.SongService;
import top.wangruns.trackstacking.service.UserService;
import top.wangruns.trackstacking.service.CollectionService;
import top.wangruns.trackstacking.service.RecordPlayService;
import top.wangruns.trackstacking.service.RecordDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.PersonalRecService;
import org.springframework.stereotype.Component;
import java.util.TimerTask;

@Component
public class UpdateTask extends TimerTask
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
    
    public void run() {
        System.out.println("------------\u5f00\u59cb\u6267\u884c\u4efb\u52a1-------------");
        try {
            TimeUnit.SECONDS.sleep(10L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.userService.getAllRecords();
        Static.isFromA = !Static.isFromA;
        Map<Integer, Integer[]> user2songRecMatrix = new HashMap<Integer, Integer[]>();
        final List<DownloadRecord> downloadList = this.recordDownloadService.getAllRecords();
        final List<PlayRecord> playList = this.recordPlayService.getAllRecords();
        final List<Collection> collectionList = this.collectionService.getAllRecords();
        final List<Integer> userIdList = this.userService.getAllUserIdRecords();
        final List<Integer> songIdList = this.songService.getAllSongIdRecords();
        final Map<Integer, float[]> user2songRatingMatrix = DataTranslate.getFrequencyMatrix(userIdList, songIdList, downloadList, playList, collectionList);
        final Map<Integer, Integer[]> userKNNMatrix = UserKNN.getKNN(userIdList, user2songRatingMatrix, 2);
        user2songRecMatrix = CollaborativeFiltering.userKNNBasedCF(userIdList, userKNNMatrix, user2songRatingMatrix, songIdList, 10);
        System.out.println("------------\u6267\u884c\u4efb\u52a1\u5b8c\u6210-------------");
        if (Static.isFromA) {
            this.personalRecService.updatePersonalRecIntoB(user2songRecMatrix);
        }
        else {
            this.personalRecService.updatePersonalRecIntoA(user2songRecMatrix);
        }
    }
}
