package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    private int id;
    private String Name;
    private int ImageUrl;
    private int ganre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(int imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getGanre() {
        return ganre;
    }

    public void setGanre(int ganre) {
        this.ganre = ganre;
    }
}


