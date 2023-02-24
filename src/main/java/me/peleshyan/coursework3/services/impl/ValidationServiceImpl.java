package me.peleshyan.coursework3.services.impl;

import me.peleshyan.coursework3.model.Color;
import me.peleshyan.coursework3.model.Quantity;
import me.peleshyan.coursework3.model.Size;
import me.peleshyan.coursework3.services.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {


    @Override
    public boolean validation(Quantity socks) {
        return socks.getSocks() != null
                && socks.getQuantity() != 0
                && socks.getSocks().getColor() != null
                && socks.getSocks().getSize() != null
                && checkCotton(socks.getSocks().getCotton(), socks.getSocks().getCotton());
    }

    @Override
    public boolean validation(Color color, Size size, int cottonMin, int cottonMax) {
        return color != null
                && size != null
                && checkCotton(cottonMin, cottonMax);
    }

    private boolean checkCotton (int cottonMin, int cottonMax){
        return cottonMin >=0 && cottonMax <= 100;
    }
}
