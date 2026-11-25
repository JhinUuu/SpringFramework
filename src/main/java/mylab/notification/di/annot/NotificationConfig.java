package mylab.notification.di.annot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class NotificationConfig {

    // EmailNotificationService Bean 등록
    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    // SmsNotificationService Bean 등록
    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }

    // NotificationManager Bean 등록/DI
    @Bean
    public NotificationManager notificationManager(
            EmailNotificationService emailService,
            SmsNotificationService smsService
        ) {

        return new NotificationManager(
                emailService,
                smsService
        );
    }
}