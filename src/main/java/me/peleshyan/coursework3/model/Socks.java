package me.peleshyan.coursework3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socks {
    public Color color;
    public Size size;
    public int cotton;
}
