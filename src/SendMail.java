import java.io.IOException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
	public static String[][] updates;
	public static String[][] update;
	public static String upLoc;
	public static int r,c;
	public static void main(String[] srg) {
		String username = "SendMails44@gmail.com";
		String password = "India@1947";
		String fromEmail = "SendMails44@gmail.com";
		String[][] details = FileMails.details;
		update = details;
		r = FileMails.nr;
		c = FileMails.nc+1;
		int i;
		String Body = EmailFrame2.body;
		String FileLoc = EmailFrame2.fileLoc;
		update[0][c] = "Status";
		upLoc = EmailFrame2.Loc;
		updates = update;

		for(i=1;i<r;i++) {
			int res = 0;
			String toEmail = details[i][3];
			String subject = "Mail from DSCE to " + details[i][1] + ", USN: " +details[i][2];

			Properties properties = new Properties() ; 
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");

			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(username,password);
				}
			});

			MimeMessage msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(fromEmail));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				msg.setSubject(subject);

				Multipart mailContent = new MimeMultipart();
				MimeBodyPart textBodyPart = new MimeBodyPart();
				textBodyPart.setText(Body);
				MimeBodyPart fileBodyPart = new MimeBodyPart();
				fileBodyPart.attachFile(FileLoc);

				mailContent.addBodyPart(textBodyPart);
				mailContent.addBodyPart(fileBodyPart);

				msg.setContent(mailContent);
				try{
					Transport.send(msg);
					res =1;
				}
				catch(Exception e) {
				}

			} catch (MessagingException | IOException e) {
				e.printStackTrace();
			}
			if(res == 1) 
				update[i][c] = "Sent";
			else 
				update[i][c] = "not-Sent";
			updates[i][c] = update[i][c];
		}
		FileMails.writeData();

	}

}
