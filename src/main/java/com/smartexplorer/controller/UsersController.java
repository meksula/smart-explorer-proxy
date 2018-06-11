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
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@RestController
@RequestMapping("/api/v1/user/")
public class UsersController {
    private SpotMakerCreator spotMakerCreator;
    private RegistrationConfirmation registrationConfirmation;

    @Autowired
    public void setSpotMakerCreator(SpotMakerCreator spotMakerCreator) {
        this.spotMakerCreator = spotMakerCreator;
    }

    @Autowired
    public void setRegistrationConfirmation(RegistrationConfirmation registrationConfirmation) {
        this.registrationConfirmation = registrationConfirmation;
    }

    @PutMapping(path = "/spotmaker")
    @ResponseStatus(HttpStatus.CREATED)
    public SpotMaker createSpotMaker(@RequestBody SpotMakerForm form, Authentication authentication) {
        return spotMakerCreator.createSpotMaker(form, authentication);
    }

    @GetMapping("/confirmation/{verificationCode}")
    @ResponseStatus(HttpStatus.OK)
    public SpotMaker confirmSpotMaker(Authentication authentication,
                                      @PathVariable("verificationCode") String verificationCode) {
        Confirmation confirmation = new Confirmation(authentication.getPrincipal().toString(), verificationCode);

        return registrationConfirmation.confirmAndEnable(confirmation)
                .orElseThrow(() -> new UserCreationException("Authentication code is incorrect."));
    }

}
