package org.softuni.finalproject.web;

import com.dropbox.core.DbxWebAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softuni.finalproject.service.DropboxAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@ControllerAdvice(basePackageClasses = DropboxAuthController.class)
public class DropboxExceptionController {

    private static final String NOT_APPROVED_MESSAGE = "You have to authorise Dropbox in oder to upload an image.";
    private static final String BAD_REQUEST_MESSAGE = "Ooops...something went wrong!";
    private static final String BAD_STATE_MESSAGE = "There might be a problem with your Dropbox authorization. Please try again!";
    private static final String BAD_CSRF_MESSAGE = "Something went wrong! Please logout and login again!";
    private static final String PROVIDER_MESSAGE = "Error communicating with Dropbox!";

    private static final Logger logger = LoggerFactory.getLogger(DropboxAuthService.class);

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({DbxWebAuth.NotApprovedException.class})
    public String handleNotApproved(DbxWebAuth.NotApprovedException exception, Model model) {

        logger.error(exception.getMessage());

        model.addAttribute("errorMessage", NOT_APPROVED_MESSAGE);
        model.addAttribute("reauthenticate", "/dropbox/auth");

        return "error";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DbxWebAuth.BadRequestException.class})
    public String handleBadRequest(DbxWebAuth.BadRequestException exception, Model model) {

        logger.error("On /dropbox-auth-finish: Bad request: {}", exception.getMessage());

        model.addAttribute("errorMessage", BAD_REQUEST_MESSAGE);
        model.addAttribute("errorCode", HttpStatus.BAD_REQUEST.value());

        return "error";
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DbxWebAuth.BadStateException.class})
    public String handleBadState(DbxWebAuth.BadStateException exception, Model model) {

        logger.error(exception.getMessage());

        model.addAttribute("errorMessage", BAD_STATE_MESSAGE);
        model.addAttribute("errorCode", HttpStatus.BAD_REQUEST.value());

        return "error";
    }


    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler({DbxWebAuth.CsrfException.class})
    public String handleCsrfException(DbxWebAuth.CsrfException exception, Model model) {

        logger.error("On /dropbox-auth-finish: CSRF mismatch: {}", exception.getMessage());

        model.addAttribute("errorMessage", BAD_CSRF_MESSAGE);
        model.addAttribute("errorCode", HttpStatus.FORBIDDEN.value());

        return "error";
    }


    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler({DbxWebAuth.ProviderException.class})
    public String handleProviderException(DbxWebAuth.ProviderException exception, Model model) {

        logger.error("On /dropbox-auth-finish: Auth failed: {}", exception.getMessage());

        model.addAttribute("errorMessage", PROVIDER_MESSAGE);
        model.addAttribute("errorCode", HttpStatus.SERVICE_UNAVAILABLE.value());

        return "error";
    }
}
