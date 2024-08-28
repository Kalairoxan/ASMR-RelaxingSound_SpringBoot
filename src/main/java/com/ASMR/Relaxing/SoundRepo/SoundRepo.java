package com.ASMR.Relaxing.SoundRepo;

import org.springframework.stereotype.Repository;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class SoundRepo {

    public String playSound(String soundName) {
        ArrayList<File> soundFiles = new ArrayList<>();

        // Populate sound files based on the soundName
        switch (soundName) {
            case "heavyRain":
                soundFiles.add(new File("src/main/resources/Assets/heavy-rain-nature-sounds-8186.wav"));
                break;
            case "sleepNature":
                soundFiles.add(new File("src/main/resources/Assets/sleep-sounds-nature-3-235031.wav"));
                break;
            case "thunderRain":
                soundFiles.add(new File("src/main/resources/Assets/rain-and-thunder-sfx-12820.wav"));
                break;
            default:
                return "Sound not found";
        }

        // Check if there are sound files to play
        if (soundFiles.isEmpty()) {
            return "No sound files found";
        }

        // Play the first sound file
        File file = soundFiles.get(0);
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
             Clip clip = AudioSystem.getClip()) {

            clip.open(audioInputStream);
            clip.start();

            // Ensure the thread waits long enough for the sound to finish
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Convert microseconds to milliseconds

            return "Sound played successfully";

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            return "Error playing sound: " + e.getMessage();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Playback interrupted";
        }
    }
}
