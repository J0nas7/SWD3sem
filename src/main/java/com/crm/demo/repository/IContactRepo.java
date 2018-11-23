package com.crm.demo.repository;

import com.crm.demo.model.*;
import org.springframework.*;


import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepo extends JpaRepository<Contact, Integer> {



}
