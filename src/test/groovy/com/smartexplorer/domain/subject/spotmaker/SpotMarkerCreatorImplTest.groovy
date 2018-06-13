package com.smartexplorer.domain.subject.spotmaker

import com.smartexplorer.SmartExplorerApplication
import com.smartexplorer.domain.subject.registration.Confirmation
import com.smartexplorer.domain.subject.registration.RegistrationConfirmation
import com.smartexplorer.domain.subject.registration.RegistrationConfirmationImpl
import com.smartexplorer.repository.ConfirmationRepository
import com.smartexplorer.repository.SpotMakerRepository
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.context.junit4.SpringRunner
import org.thymeleaf.TemplateEngine
import spock.lang.Shared
import spock.lang.Specification

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@SpringBootTest(classes = SmartExplorerApplication)
class SpotMarkerCreatorImplTest extends Specification {

    @Shared private SpotMakerCreatorImpl spotMarkerCreator
    @Shared private Authentication auth

    @Autowired
    private SpotMakerRepository repository

    @Autowired
    private ConfirmationRepository confirmationRepository

    @Autowired
    private RegistrationConfirmation registrationConfirmation

    /*@Autowired
    private JavaMailSender javaMailSender

    @Autowired
    private TemplateEngine templateEngine*/

    private SpotMakerForm spotMakerForm
    private String principalNumber = "574577177937757744402342"

    private static String username = "Clerifly"
    private static String password = "445rfcgv"
    private static String name = "Cler"
    private static String surname = "Abrevee"
    private static String email = "karol.meksula@onet.pl"
    private static int age = 34

    def setupSpec() {
        auth = new Authentication() {
            @Override
            Collection<? extends GrantedAuthority> getAuthorities() {
                return null
            }

            @Override
            Object getCredentials() {
                return null
            }

            @Override
            Object getDetails() {
                return null
            }

            @Override
            Object getPrincipal() {
                return principalNumber
            }

            @Override
            boolean isAuthenticated() {
                return false
            }

            @Override
            void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
                isAuthenticated
            }

            @Override
            String getName() {
                return null
            }
        }

    }

    def 'spotMakerCreator should create new SpotMaker and save to database'() {
        setup:
        spotMarkerCreator = new SpotMakerCreatorImpl(repository)
        spotMarkerCreator.setPasswordEncoder(new BCryptPasswordEncoder())

        //RegistrationConfirmation confirmation = new RegistrationConfirmationImpl()
        //confirmation.setConfirmationRepository(confirmationRepository)
        //spotMarkerCreator.setRegistrationConfirmation(confirmation)
        spotMarkerCreator.setRegistrationConfirmation(registrationConfirmation)


        when:
        this.spotMakerForm = new SpotMakerForm(username, password, name, surname, email, age)

        def spotMaker = spotMarkerCreator.createSpotMaker(spotMakerForm, auth)

        then:
        spotMaker.getSpotMakerId() != null
        spotMaker.getPrincipalNumber() != null
        username == spotMaker.getUsername()
        new BCryptPasswordEncoder().matches(password, spotMaker.getPassword())
        name == spotMaker.getName()
        surname == spotMaker.getSurname()
        email == spotMaker.getEmail()
        age == spotMaker.getAge()

        Optional<Confirmation> optionalConfirmation = confirmationRepository.findByPrincipalNumber(spotMaker.getPrincipalNumber())
        optionalConfirmation.isPresent()

        cleanup:
        repository.deleteAll()
        confirmationRepository.deleteAll()
    }

}