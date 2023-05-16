// 
// Decompiled by Procyon v0.5.29
// 

package top.wangruns.trackstacking.utils;

import java.util.Hashtable;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;

public class SendEmail
{
    public static boolean sendemail(final String theme, final String messages, final String email) {
        final Properties prop = new Properties();
        //((Hashtable<String, String>)prop).put("mail.transport.protocol", "smtp");
        //((Hashtable<String, String>)prop).put("mail.host", "smtp.163.com");
        //((Hashtable<String, String>)prop).put("mail.smtp.auth", "true");
        
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.host", "smtp.163.com");
        prop.put("mail.smtp.auth", "true");
        
        
        final Session session = Session.getInstance(prop);
        session.setDebug(true);
        try {
            final Message message = (Message)createSimpleMail(session, theme, messages, email);
            final Transport ts = session.getTransport();
            ts.connect("yuanmamatouemail@163.com", "yuanmamatou1234");
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    private static MimeMessage createSimpleMail(final Session session, final String theme, final String messages, final String email) throws Exception {
        final MimeMessage message = new MimeMessage(session);
        message.setFrom((Address)new InternetAddress("yuanmamatouemail@163.com"));
        message.addRecipients(Message.RecipientType.TO, email);
        message.setSubject(theme);
        message.setText(messages);
        message.saveChanges();
        return message;
    }
}
