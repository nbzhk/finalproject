//package org.softuni.finalproject.Init;
//
//import org.softuni.finalproject.model.CurrentUser;
//import org.softuni.finalproject.model.PictureLocation;
//import org.softuni.finalproject.model.UserGuess;
//import org.softuni.finalproject.model.dto.GameDTO;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class TestConfig {
//
//    @Bean
//    public GameDTO currentGame() {
//        CurrentUser currentUser = currentUser();
//        PictureLocation[] pictureLocations = pictureLocations();
//        UserGuess userGuess = userGuess();
//
//        GameDTO gameDTO = new GameDTO();
//        gameDTO.setUser(currentUser);
//        gameDTO.setPictureLocations(pictureLocations);
//        gameDTO.setUserGuess(userGuess);
//
//        return gameDTO;
//    }
//
//    public CurrentUser currentUser() {
//        CurrentUser currentUser = new CurrentUser();
//        currentUser.setUsername("test");
//        return currentUser;
//    }
//
//    private UserGuess userGuess() {
//        return new UserGuess();
//    }
//
//
//    public PictureLocation[] pictureLocations() {
//
//        PictureLocation[] pictureLocations = new PictureLocation[5];
//        for (int i = 0; i < pictureLocations.length; i++) {
//
//            PictureLocation pictureLocation = new PictureLocation();
//            pictureLocation.setImgUrl("images/Eiffel.jpeg");
//            pictureLocation.setLatitude(48.858093);
//            pictureLocation.setLongitude(2.294694);
//            pictureLocation.setYear(2024);
//
//            pictureLocations[i] = pictureLocation;
//        }
//
//        return pictureLocations;
//    }
//}
