package com.notification.repository;

import com.notification.model.Message;
import com.notification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findBysenderId(String email);

    List<Message> findByreceiverId(String email);

}
