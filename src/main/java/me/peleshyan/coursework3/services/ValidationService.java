package me.peleshyan.coursework3.services;

import me.peleshyan.coursework3.model.Color;
import me.peleshyan.coursework3.model.Quantity;
import me.peleshyan.coursework3.model.Size;

public interface ValidationService {

    boolean validation (Quantity socks);
    boolean validation (Color color, Size size, int cottonMin, int cottonMax);

}
