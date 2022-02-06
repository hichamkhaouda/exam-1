package com.hicham.exam;

import com.hicham.exam.Controller.UtilisateurController;
import com.hicham.exam.DAO.UtilisateurRepository;
import com.hicham.exam.Model.Utilisateur;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired private UtilisateurRepository userRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(entityManager).isNotNull();
        assertThat(userRepository).isNotNull();
    }

    @Test
    void shouldCreateutilisateur() throws Exception {
        Utilisateur testUser = new Utilisateur(null, "Yassine", "yassine@exam.com");
        Utilisateur result = userRepository.save(testUser);
        assertThat(result).hasFieldOrPropertyWithValue("fullname", "Yassine");
        assertThat(result).hasFieldOrPropertyWithValue("email", "yassine@exam.com");
    }


}
