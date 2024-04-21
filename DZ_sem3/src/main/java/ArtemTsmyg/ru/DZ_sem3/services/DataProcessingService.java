package ArtemTsmyg.ru.DZ_sem3.services;

import ArtemTsmyg.ru.DZ_sem3.domain.User;
import ArtemTsmyg.ru.DZ_sem3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }

    public List<User> sortUsersByAge(List<User> users) {

        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public List<User> getUsers() {
        return getUsers();
    }

    public List<User> filterUserByAge(List<User> users, int age) {
        return getUsers().reversed();
    }

    public void addUser(User createUser) {
    }

    public void processUserData(User user) {
    }
}