package com.codegym.formartter;

import com.codegym.model.Province;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.Formatter;

import java.util.Optional;

import static java.awt.SystemColor.text;

public class ProvinceFormatter extends Formatter<Province> {
    private final IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Local local) {
        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Province object, Local local) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }

}
