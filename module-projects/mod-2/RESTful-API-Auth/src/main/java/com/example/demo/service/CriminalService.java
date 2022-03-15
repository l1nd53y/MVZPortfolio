package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Criminal;
import com.example.demo.repository.CriminalRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CriminalService {
    CriminalRepository criminalRepository;

    PasswordEncoder passwordEncoder;

    public CriminalService(CriminalRepository criminalRepository) {
        this.criminalRepository = criminalRepository;
    }

    public Criminal save(Criminal criminal) {
//        String hashedName = Hasher.hash(criminal.getName());
//        String hashedMod = Hasher.hash(criminal.getMod());
//        String hashedImageLink = Hasher.hash(criminal.getImageLink());
//
//        criminal.setName(hashedName);
//        criminal.setMod(hashedMod);
//        criminal.setImageLink(hashedImageLink);

        String name = (criminal.getName());
        String mod = (criminal.getMod());
        String imageLink = (criminal.getImageLink());

        criminal.setName(name);
        criminal.setMod(mod);
        criminal.setImageLink(imageLink);

        return this.criminalRepository.save(criminal);
    }

    public Criminal updateCriminal(long id, Criminal criminalDetails) {
        Criminal updateCriminal = criminalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Criminal does not exist with id: " + id));

        updateCriminal.setName(criminalDetails.getName());
        updateCriminal.setMod(criminalDetails.getMod());
        updateCriminal.setImageLink(criminalDetails.getImageLink());

        return criminalRepository.save(updateCriminal);
    }
}
