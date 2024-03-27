package com.yandiar.service;

import com.yandiar.model.User;
import com.yandiar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author YAR
 */
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "usersCache")
public class UserService {

    private final UserRepository userRepository;

    private final RedisTemplate<String, Serializable> redisTemplate;

    @Cacheable(cacheNames = "users")
    public List<User> getAllUsers() {
        doLongRunningTask();
        return userRepository.findAll();
    }

    @Cacheable("user")
    public Optional<User> getUserById(long id) {
        doLongRunningTask(); //set delay processing

        return userRepository.findById(id);
    }

    @CacheEvict(cacheNames = "user", allEntries = true)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
