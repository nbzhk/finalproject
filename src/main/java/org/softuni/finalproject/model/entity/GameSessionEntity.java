package org.softuni.finalproject.model.entity;

import jakarta.persistence.*;
import org.softuni.finalproject.model.dto.UserGuessDTO;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "games")
public class GameSessionEntity extends BaseEntity {
    @ManyToOne
    private UserEntity player;

    @ManyToMany
    @CollectionTable(name = "game_pictures",
                     joinColumns = @JoinColumn(name = "game_session_id"))
    private List<PictureEntity> pictures;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "game_data",
                     joinColumns = @JoinColumn(name = "game_session_id"))
    private List<UserGuess> guesses;

    @ElementCollection
    @CollectionTable(name = "game_data",
                     joinColumns = @JoinColumn(name = "game_session_id"))
    private List<Integer> roundScores;
    @ElementCollection
    @CollectionTable(name = "game_data",
                    joinColumns = @JoinColumn(name = "game_session_id"))
    private List<Integer> yearDifferences;

    @ElementCollection
    @CollectionTable(name = "game_data",
                     joinColumns = @JoinColumn(name = "game_session_id"))
    private List<Double> distanceDifferences;

    @Column
    private LocalDateTime timestamp;

    public UserEntity getPlayer() {
        return player;
    }

    public void setPlayer(UserEntity player) {
        this.player = player;
    }

    public List<PictureEntity> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureEntity> pictures) {
        this.pictures = pictures;
    }

    public List<UserGuess> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<UserGuess> guesses) {
        this.guesses = guesses;
    }

    public List<Integer> getRoundScores() {
        return roundScores;
    }

    public void setRoundScores(List<Integer> scores) {
        this.roundScores = scores;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setYearDifferences(List<Integer> yearDifferences) {
        this.yearDifferences = yearDifferences;
    }

    public void setDistanceDifferences(List<Double> distanceDifferences) {
        this.distanceDifferences = distanceDifferences;
    }

    public List<Integer> getYearDifferences() {
        return yearDifferences;
    }

    public List<Double> getDistanceDifferences() {
        return distanceDifferences;
    }
}
