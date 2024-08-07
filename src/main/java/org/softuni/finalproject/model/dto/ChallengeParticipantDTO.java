package org.softuni.finalproject.model.dto;

public class ChallengeParticipantDTO {
    private String username;
    private UserGuessDTO userGuessDTO;
    private int score;

    public ChallengeParticipantDTO() {
    }

    public ChallengeParticipantDTO(String username) {
        this.username = username;
        this.userGuessDTO = new UserGuessDTO();
        this.score = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UserGuessDTO getUserGuessDTO() {
        return userGuessDTO;
    }

    public void setUserGuessDTO(UserGuessDTO userGuessDTO) {
        this.userGuessDTO = userGuessDTO;
    }
}
