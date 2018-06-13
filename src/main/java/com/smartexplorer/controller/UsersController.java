package com.smartexplorer.controller;

import com.smartexplorer.controller.exception.UserCreationException;
import com.smartexplorer.domain.mail.MailReceiver;
import com.smartexplorer.domain.mail.MailSender;
import com.smartexplorer.domain.mail.MailType;
import com.smartexplorer.domain.mail.TemplateMailSender;
import com.smartexplorer.domain.subject.registration.Confirmation;
import com.smartexplorer.domain.subject.registration.RegistrationConfirmation;
import com.smartexplorer.domain.subject.spotmaker.SpotMaker;
import com.smartexplorer.domain.subject.spotmaker.SpotMakerForm;
import com.smartexplorer.domain.subject.spotmaker.SpotMakerCreator;
import com.smartexplorer.repository.ConfirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@RestController
@RequestMapping("/api/v1/user")
public class UsersController {
    private SpotMakerCreator spotMakerCreator;
    private RegistrationConfirmation registrationConfirmation;
    private Authentication authentication;

    @Autowired
    public void setSpotMakerCreator(SpotMakerCreator spotMakerCreator) {
        this.spotMakerCreator = spotMakerCreator;
    }

    @Autowired
    public void setRegistrationConfirmation(RegistrationConfirmation registrationConfirmation) {
        this.registrationConfirmation = registrationConfirmation;
    }

    @PostMapping("/spotmaker")
    @ResponseStatus(HttpStatus.CREATED)
    public SpotMaker createSpotMaker(@RequestBody SpotMakerForm form) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        return spotMakerCreator.createSpotMaker(form, authentication);
    }

    @GetMapping("/confirmation/{verificationCode}")
    @ResponseStatus(HttpStatus.OK)
    public SpotMaker confirmSpotMaker(@PathVariable("verificationCode") String verificationCode) {
        authentication = SecurityContextHolder.getContext().getAuthentication();

        Confirmation confirmation = new Confirmation(authentication.getPrincipal().toString(), verificationCode);

        return registrationConfirmation.confirmAndEnable(confirmation)
                .orElseThrow(() -> new UserCreationException("Authentication code is incorrect."));
    }

}
