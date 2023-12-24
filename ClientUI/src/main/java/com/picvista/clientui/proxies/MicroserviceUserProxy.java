package com.picvista.clientui.proxies;

import com.picvista.clientui.beans.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="microservice-user",url = "localhost:5011")
public interface MicroserviceUserProxy {
    @GetMapping("/users")
    ResponseEntity<Iterable<UserBean>> getAllUsers();
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUserById(@PathVariable("id") int id);
    @GetMapping("/{id}")
    ResponseEntity<UserBean> getUserById(@PathVariable("id") int id);
    @PostMapping("/create")
    ResponseEntity<Object> createUser(UserBean user);
}
