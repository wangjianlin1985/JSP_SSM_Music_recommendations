// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.RecordPlayService;
import org.springframework.stereotype.Controller;

@Controller
public class RecordPlayController
{
    @Autowired
    private RecordPlayService recordPlayService;
    
    @GetMapping({ "recordPlay.do" })
    public void recordPlay(final HttpServletRequest request, final int songId) {
        this.recordPlayService.recordPlay(request, songId);
    }
}
