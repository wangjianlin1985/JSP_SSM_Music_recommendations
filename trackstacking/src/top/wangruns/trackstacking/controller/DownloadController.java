// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.BufferedInputStream;
import java.net.URL;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import top.wangruns.trackstacking.service.RecordDownloadService;
import org.springframework.stereotype.Controller;

@Controller
public class DownloadController
{
    @Autowired
    private RecordDownloadService recordDownloadService;
    
    @RequestMapping(value = { "download.do" }, method = { RequestMethod.GET })
    public void download(final HttpServletRequest request, final HttpServletResponse response, String songAddress, final int songId) throws IOException {
        this.recordDownloadService.recordDownload(request, songId);
        response.setContentType("audio/mp3");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(String.valueOf(System.currentTimeMillis()) + "\u5982\u679c\u4e0d\u60f3\u8fd4\u56de\u540d\u79f0\u7684\u8bdd.mp3", "utf8"));
        final BufferedOutputStream out = new BufferedOutputStream((OutputStream)response.getOutputStream());
        InputStream bis = null;
        if (songAddress.contains("http")) {
            final URL url = new URL(songAddress);
            final URLConnection uc = url.openConnection();
            bis = new BufferedInputStream(uc.getInputStream());
        }
        else {
            songAddress = request.getServletContext().getRealPath(songAddress);
            bis = new BufferedInputStream(new FileInputStream(new File(songAddress)));
        }
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
        bis.close();
    }
}
