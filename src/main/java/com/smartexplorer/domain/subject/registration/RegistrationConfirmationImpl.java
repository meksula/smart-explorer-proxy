package com.smartexplorer.domain.subject.registration;

import com.smartexplorer.domain.mail.MailSender;
import com.smartexplorer.domain.mail.MailType;
import com.smartexplorer.domain.mail.TemplateMailSender;
import com.smartexplorer.domain.subject.spotmaker.SpotMaker;
import com.smartexplorer.repository.ConfirmationRepository;
import com.smartexplorer.repository.DefaultUniqueDatabaseIdCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 11-06-2018
 * */

@Service
public class RegistrationConfirmationImpl implements RegistrationConfirmation {
    private ConfirmationRepository confirmationRepository;
    private MailSender mailSender;

    @Autowired
    public void setConfirmationRepository(ConfirmationRepository confirmationRepository) {
        this.confirmationRepository = confirmationRepository;
    }

    @Override
    public void confirmation(SpotMaker spotMaker) {
        String verificationCode = new DefaultUniqueDatabaseIdCreator().assignUniqueId();
        Confirmation confirmation = new Confirmation(spotMaker.getPrincipalNumber(), verificationCode);
        confirmation.setId(verificationCode);

        confirmationRepository.save(confirmation);
        sendConfirmationMail(confirmation, spotMaker);
    }

    @Override
    public Optional<SpotMaker> confirmAndEnable(Confirmation confirmation) {
        /**
         * TODO interfejs jest już ustalony, trzeba tylko tutaj dopisać mechanizm:
         * 1. Sprawdź czy encje z bazy danych i podane w argumencie są takie same.
         * 2. Jeśli tak to usuń encję
         * 3. Ustaw użytkownikowi parametr na `true`
         * */
        
        return Optional.empty();
    }

    private void sendConfirmationMail(Confirmation confirmation, SpotMaker spotMaker) {
        mailSender = new TemplateMailSender();
        mailSender.setAttachment(confirmation);
        mailSender.sendMail(MailType.REGISTER_CONFIRM, spotMaker);
    }

}
