package com.example.WorkReport.Model;

import com.example.WorkReport.Entity.OfficeEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Office {
    private BigInteger id;
    private String country;
    private String city;
    private String address;

    public static Office toModelOffice(OfficeEntity entity){
        Office model = new Office();
        model.setId(entity.getId());
        model.setCity(entity.getCity());
        model.setCountry(entity.getCountry());
        model.setAddress(entity.getAddress());
        return model;
    }

    public Office() {
    }
}
