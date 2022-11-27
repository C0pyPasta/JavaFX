package com.example.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import java.util.Random;

public class RockPaperScissorController {
    @FXML
    private Label computerScore;
    @FXML
    private Label playerScore;
    @FXML
    private Label timesDraw;
    @FXML
    private Label outcome;
    @FXML
    private Label computerIsChoosing;
    @FXML
    private RadioButton rock;
    @FXML
    private RadioButton paper;
    @FXML
    private RadioButton scissor;

    private String computerPick;

    private int computerCounter = 0;
    private int playerCounter = 0;
    private int drawCounter = 0;

    @FXML
    protected void checkWhoWins() throws InterruptedException {

        String playerPick = playerChoice();
        String computerPick = computerChoice();

        if (computerPick.equals(playerPick)) {
            outcome.setText("...so it's a draw");
            drawCounter++;
        } else if (computerPick.equals("Rock") && playerPick.equals("Paper")) {
            outcome.setText("You win with " + playerPick + " over " + computerPick);
            playerCounter++;
        } else if (computerPick.equals("Scissor") && playerPick.equals("Rock")) {
            outcome.setText("You win with " + playerPick + " over " + computerPick);
            playerCounter++;
        } else if (computerPick.equals("Paper") && playerPick.equals("Scissor")) {
            outcome.setText("You win with " + playerPick + " over " + computerPick);
            playerCounter++;
        } else if (computerPick.equals("Rock") && playerPick.equals("Scissor")) {
            outcome.setText("Computer wins with " + computerPick + " over " + playerPick);
            computerCounter++;
        } else if (computerPick.equals("Scissor") && playerPick.equals("Paper")) {
            outcome.setText("Computer wins with " + computerPick+ " over " + playerPick );
            computerCounter++;
        } else if (computerPick.equals("Paper") && playerPick.equals("Rock")) {
            outcome.setText("Computer wins with " + computerPick  + " over " + playerPick);
            computerCounter++;
        } else if ((computerPick.equals("Paper") || computerPick.equals("Rock") || computerPick.equals("Scissor")) && playerPick.equals("Empty")) {
            outcome.setText("...choose you must");
        }

        //Set Labels win, draw, loss
        playerScore.setText("Win:  " + this.playerCounter);
        computerScore.setText("Loss: " + this.computerCounter);
        timesDraw.setText("Draw: " + this.drawCounter);

        Thread.sleep(600);
    }

    private String computerChoice() {

        Random random = new Random();
        int randomPick = random.nextInt(3);

        switch (randomPick) {
            case 0:
                computerPick = "Rock";
                computerIsChoosing.setText("Computer chose " + computerPick + "...");
                break;
            case 1:
                computerPick = "Scissor";
                computerIsChoosing.setText("Computer chose " + computerPick + "...");
                break;
            case 2:
                computerPick = "Paper";
                computerIsChoosing.setText("Computer chose " + computerPick + "...");
                break;
        }
        return computerPick;
    }

    private String playerChoice(){

        String playerPick;

        if (rock.isSelected()) {
            playerPick = "Rock";
        } else if (paper.isSelected()) {
            playerPick = "Paper";
        } else if (scissor.isSelected()) {
            playerPick = "Scissor";
        } else {
            playerPick = "Empty";
        }
        return playerPick;
    }
}