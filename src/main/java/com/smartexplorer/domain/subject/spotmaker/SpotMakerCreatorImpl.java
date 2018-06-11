package com.smartexplorer.domain.subject.spotmaker;

import com.smartexplorer.controller.exception.UserCreationException;
import com.smartexplorer.domain.subject.registration.RegistrationConfirmation;
import com.smartexplorer.repository.DefaultUniqueDatabaseIdCreator;
import com.smartexplorer.repository.SpotMakerRepository;
import com.smartexplorer.repository.UniqueDatabaseIdCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@Service
public class SpotMakerCreatorImpl implements SpotMakerCreator {
    private SpotMakerValidator spotMakerValidator;
    private SpotMakerRepository spotMakerRepository;
    private PasswordEncoder passwordEncoder;
    private UniqueDatabaseIdCreator uniqueDatabaseIdCreator;
    private RegistrationConfirmation registrationConfirmation;

    public SpotMakerCreatorImpl(SpotMakerRepository spotMakerRepository) {
        this.spotMakerValidator = new SpotMakerValidatorDefault();
        this.spotMakerRepository = spotMakerRepository;
        this.uniqueDatabaseIdCreator = new DefaultUniqueDatabaseIdCreator();
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setRegistrationConfirmation(RegistrationConfirmation registrationConfirmation) {
        this.registrationConfirmation = registrationConfirmation;
    }

    @Override
    public SpotMaker createSpotMaker(SpotMakerForm form, Authentication authentication) {
        if (spotMakerValidator.validateSpotMaker(form)) {
            SpotMaker spotMaker = buildSpotMaker(form, authentication);
            save(spotMaker);
            createConfirmationProcess(spotMaker);
        }

        return buildSpotMaker(form, authentication);
    }

    private SpotMaker buildSpotMaker(SpotMakerForm spotMakerForm, Authentication authentication) {
        return new SpotMaker.SpotMakerBuilder()
                .spotMakerId(uniqueDatabaseIdCreator.assignUniqueId())
                .isConfirmed(false)
                .principalNumber(String.valueOf(authentication.getPrincipal()))
                .username(spotMakerForm.getUsername())
                .password(passwordEncoder.encode(spotMakerForm.getPassword()))
                .name(spotMakerForm.getName())
                .surname(spotMakerForm.getSurname())
                .email(spotMakerForm.getEmail())
                .age(spotMakerForm.getAge())
                .build();
    }

    private void save(SpotMaker spotMaker) {
        if (spotMakerRepository.findByUsername(spotMaker.getUsername()).isPresent())
            throw new UserCreationException("User [" + spotMaker.getUsername() + "] just exist in database.");

        spotMakerRepository.save(spotMaker);
    }

    private void createConfirmationProcess(SpotMaker spotMaker) {
        registrationConfirmation.confirmation(spotMaker);
    }

}