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
     * Сохранение пользователя в БД.
     * @param name имя пользователя.
     * @param age возраст пользователя.
     * @param email email пользователя.
     */
    public void processRegistration(String name, int age, String email){
        User createUser = userService.createUser(name, age, email);
        dataProcessingService.addUser(createUser);
        notificationService.sendNotification("User added from body");
    }
}