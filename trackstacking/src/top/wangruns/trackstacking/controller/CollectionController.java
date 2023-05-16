// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import top.wangruns.trackstacking.utils.ReturnMsg;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.CollectionService;
import org.springframework.stereotype.Controller;

@Controller
public class CollectionController
{
    @Autowired
    private CollectionService collectionService;
    
    @PostMapping(value = { "collectSong.do" }, produces = { "text/html;charset=UTF-8" })
    @ResponseBody
    public String collectSong(final HttpServletRequest request, final int songId) {
        final boolean isCollected = this.collectionService.collectionChange(request, songId);
        return ReturnMsg.msg(200, new StringBuilder(String.valueOf(isCollected)).toString());
    }
}
