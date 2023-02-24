package me.peleshyan.coursework3.services;

import me.peleshyan.coursework3.model.Color;
import me.peleshyan.coursework3.model.Quantity;
import me.peleshyan.coursework3.model.Size;

public interface SocksService {
    void addSocks(Quantity socks);

    int deleteSocks(Quantity socks);

    int rejectSocks(Quantity socks);

    int getSocks(Color color, Size size, int cottonMin, int cottonMax);
}
