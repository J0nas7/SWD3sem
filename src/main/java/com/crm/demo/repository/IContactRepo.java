package com.crm.demo.repository;

import com.crm.demo.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepo extends JpaRepository<Contact, Integer> {



}
