package io.swagger.persistence;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetDaoTest {

    @org.junit.jupiter.api.Test
    void getPetById() {
        PetDao dao = new PetDao();
        assertEquals("doggie", dao.getPetById().getName());
    }
}