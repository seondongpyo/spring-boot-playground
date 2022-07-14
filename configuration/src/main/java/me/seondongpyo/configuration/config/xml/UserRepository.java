package me.seondongpyo.configuration.config.xml;

import java.util.*;

public class UserRepository {

    private final Map<UUID, User> users = new HashMap<>();

    public UserRepository() {
        User userA = new User(UUID.randomUUID(), "userA");
        User userB = new User(UUID.randomUUID(), "userB");
        users.put(userA.getId(), userA);
        users.put(userB.getId(), userB);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
