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
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Метод получения списка пользователей с фильтром по возрасту
     * @param age возраст
     * @return список пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAg(@PathVariable("age") int age) {
        List<User> users = service.getUsers();
        return service.filterUserByAge(users, age);
    }

    /**
     * Метод получения среднего возраста пользователей
     * @return средний возраст
     */
    @GetMapping("/calc")
    public Double calculateAverageAge() {
        List<User> users = service.getUsers();
        return service.calculateAverageAge(users);
    }

}