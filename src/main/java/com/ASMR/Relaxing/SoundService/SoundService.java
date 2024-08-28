package com.ASMR.Relaxing.SoundService;

import com.ASMR.Relaxing.SoundRepo.SoundRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoundService {

    @Autowired
    private SoundRepo soundRepo;

    public String playSound(String soundName) {
        return soundRepo.playSound(soundName);
    }
}
