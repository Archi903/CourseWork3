package me.peleshyan.coursework3.repository;

import me.peleshyan.coursework3.model.Quantity;
import me.peleshyan.coursework3.model.Socks;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SocksRepositoryImpl implements SocksRepository {


    private Map < Socks, Integer> socksMap = new HashMap<>();

    @Override
    public void addSocks(Quantity socks) {
        Socks socksGet = socks.getSocks();
        if (socksMap.containsKey(socksGet)){
            socksMap.replace(socksGet, socksMap.get(socksGet) + socks.getQuantity());
        } else {
            socksMap.put(socksGet, socks.getQuantity());
        }
    }
    @Override
    public int deleteSocks(Quantity socks) {
        Socks socksGet = socks.getSocks();
        if (socksMap.containsKey(socksGet)){
            int quantity = socksMap.get(socksGet);
            if (quantity > socks.getQuantity()){
                socksMap.replace(socksGet, socksMap.get(socksGet) - socks.getQuantity());
                return socks.getQuantity();
            } else {
                socksMap.remove(socksGet);
                return quantity;
            }
        } else {
            socksMap.put(socksGet, socks.getQuantity());
        }
        return 0;
    }
    @Override
    public Map<Socks, Integer> getAll(){
        return socksMap;
    }


}
