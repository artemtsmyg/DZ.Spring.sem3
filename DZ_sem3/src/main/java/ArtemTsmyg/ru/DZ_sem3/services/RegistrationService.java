package ArtemTsmyg.ru.DZ_sem3.services;

import ArtemTsmyg.ru.DZ_sem3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RegistrationService - класс регистрации новых пользователей.
 */
@Service
public class RegistrationService {

    /**
     * Поле сервиса работы с хранилищем пользователей.
     */
    private final DataProcessingService dataProcessingService;

    /**
     * Поле сервиса создания пользователей.
     */
    private final UserService userService;
    /**
     * Поле сервиса консольных уведомлений.
     */
    private final NotificationService notificationService;

    /**
     * Конструктор класса.
     * @param dataProcessingService сервис работы с хранилищем пользователей.
     * @param userService сервис создания пользователей.
     * @param notificationService сервис консольных уведомлений.
     */
    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * Получение сервиса работы с хранилищем пользователей.
     * @return
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Обработайте регистрацию нового пользователя
     * @param user Пользовательский объект, содержащий регистрационные данные
     */
    public void processRegistration(User user) {
// Выполнять обработку данных
        dataProcessingService.processUserData(user);

// Сохранение сведений о пользователе в базе данных
        userService.saveUser(user);

// Отправить уведомление пользователю
        notificationService.sendNotification(user.getEmail(), "Welcome to our platform, " + user.getName() + "! You have successfully registered.");
    }
}