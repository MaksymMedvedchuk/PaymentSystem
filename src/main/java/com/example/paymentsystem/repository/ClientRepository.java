package com.example.paymentsystem.repository;

import com.example.paymentsystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    /*Jpa інтерфейс фреймворку Spring Data, що має набір стандартних методів JPA для роботи з БД
    * второй дженерик - тип нашого ID
    * ClientRepository extends JpaRepository для реалізації нашого репозиторію
    * слой який забезпечує доступ к БД
    *ClientRepository це і є бін  */
}
