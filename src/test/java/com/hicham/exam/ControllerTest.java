package com.hicham.exam;

import com.hicham.exam.Controller.UtilisateurController;
import com.hicham.exam.DAO.UtilisateurRepository;
import com.hicham.exam.Model.Utilisateur;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    UtilisateurController utilisateurController;

    @Mock
    UtilisateurRepository utilisateurRepository;

    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));



        Utilisateur user = new Utilisateur(null, "Nizar", "Nizar@gmail.com");
        when(utilisateurRepository.save(any(Utilisateur.class))).thenReturn(user);
        Utilisateur response = utilisateurController.creerUtilisateur(user);

        assertThat(response.getEmail()).isEqualTo("Nizar@gmail.com");
        assertThat(response.getFullName()).isEqualTo("Nizar");
    }
}
