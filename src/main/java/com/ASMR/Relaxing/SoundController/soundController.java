package com.ASMR.Relaxing.SoundController;

import com.ASMR.Relaxing.SoundService.SoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

@RestController
@RequestMapping("ASMR")
public class soundController {

    @Autowired
    SoundService soundService;

    @GetMapping("/sounds")
    public String Sounds(@RequestParam String soundName) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        return soundService.playSound(soundName);
    }
}
