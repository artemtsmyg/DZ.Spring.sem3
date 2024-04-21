package ArtemTsmyg.ru.DZ_sem3.controllers;

import ArtemTsmyg.ru.DZ_sem3.domain.User;
import ArtemTsmyg.ru.DZ_sem3.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Фильтровать пользователей по возрасту
     *
     * @param age Возраст для фильтрации пользователей
     * @return Список пользователей, отфильтрованный по возрасту
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Рассчитайте средний возраст пользователей
     *
     * @return Средний возраст пользователей
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}