package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    // NotificationManager Bean 테스트
    @Test
    public void testNotificationManager() {

        // NotificationManager 객체 검증
        assertNotNull(notificationManager);

        // EmailService 객체 검증
        assertNotNull(notificationManager.getEmailService());

        // SMSService 객체 검증
        assertNotNull(notificationManager.getSmsService());
    }

    // EmailNotificationService 테스트
    @Test
    public void testEmailNotificationService() {

        assertNotNull(notificationManager.getEmailService());

        EmailNotificationService emailService =
                (EmailNotificationService)notificationManager.getEmailService();

        assertEquals("smtp.gmail.com", emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());
    }

    // SmsNotificationService 테스트
    @Test
    public void testSmsNotificationService() {

        assertNotNull(notificationManager.getSmsService());

        SmsNotificationService smsService =
                (SmsNotificationService)notificationManager.getSmsService();

        assertEquals("SKT", smsService.getProvider());
    }

    // 알림 전송 테스트
    @Test
    public void testSendNotification() {

        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}
