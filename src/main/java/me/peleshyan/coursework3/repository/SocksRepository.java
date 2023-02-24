package me.peleshyan.coursework3.repository;

import me.peleshyan.coursework3.model.Quantity;
import me.peleshyan.coursework3.model.Socks;

import java.util.Map;

public interface SocksRepository {

    void addSocks (Quantity socks);

    int deleteSocks(Quantity socks);

    Map<Socks, Integer> getAll();
}
