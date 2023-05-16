// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import top.wangruns.trackstacking.utils.ReturnMsg;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import top.wangruns.trackstacking.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class SongController
{
    @Autowired
    private UserService userService;
    @Autowired
    private SongService songService;
    
    @RequestMapping(value = { "deleteSong.do" }, method = { RequestMethod.POST })
    public void deleteSong(final HttpServletRequest request, final int[] songIds) {
        if (this.userService.isHasPrivilege(request)) {
            this.songService.batchDeleteById(request, songIds);
        }
    }
    
    @PostMapping({ "addSong.do" })
    @ResponseBody
    public String addSong(final HttpServletRequest request, final MultipartFile song, final MultipartFile lyric) {
        if (!this.userService.isHasPrivilege(request) || !this.songService.checkFormat(song, lyric)) {
            return ReturnMsg.msg(400, "\u683c\u5f0f\u9519\u8bef");
        }
        final boolean isSuccessful = this.songService.addSong(request, song, lyric);
        if (isSuccessful) {
            return ReturnMsg.msg(200, "\u4e0a\u4f20\u6210\u529f");
        }
        return ReturnMsg.msg(400, "\u4e0a\u4f20\u5931\u8d25");
    }
}
