package me.peleshyan.coursework3.services.impl;

import exception.ValidationException;
import lombok.AllArgsConstructor;
import me.peleshyan.coursework3.model.Color;
import me.peleshyan.coursework3.model.Quantity;
import me.peleshyan.coursework3.model.Size;
import me.peleshyan.coursework3.model.Socks;
import me.peleshyan.coursework3.repository.SocksRepository;
import me.peleshyan.coursework3.services.SocksService;
import me.peleshyan.coursework3.services.ValidationService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class SockServiceImpl implements SocksService {

    private final SocksRepository socksRepository;
    private final ValidationService validationService;

    @Override
    public void addSocks(Quantity socks) {
        check(socks);
        socksRepository.addSocks(socks);
    }

    @Override
    public int deleteSocks(Quantity socks) {
        check(socks);
        return socksRepository.deleteSocks(socks);
    }

    @Override
    public int rejectSocks(Quantity socks) {
        check(socks);
        return socksRepository.deleteSocks(socks);
    }

    @Override
    public int getSocks(Color color, Size size, int cottonMin, int cottonMax) {
        if(!validationService.validation(color, size, cottonMin, cottonMax)){
            throw new ValidationException();
        }
        Map<Socks, Integer> sockMap = socksRepository.getAll();

        for (Map.Entry<Socks, Integer> socksIntegerEntry : sockMap.entrySet()) {

            Socks socks = socksIntegerEntry.getKey();

            if (socks.getColor().equals(color)
                    && socks.getSize().equals(size)
                    && socks.getCotton() >= cottonMin
                    && socks.getCotton() <= cottonMax) {
                return socksIntegerEntry.getValue();
            }
        }
        return 0;
    }

    private void check (Quantity socks){
        if(!validationService.validation(socks)){
            throw new ValidationException();
        }
    }
}
