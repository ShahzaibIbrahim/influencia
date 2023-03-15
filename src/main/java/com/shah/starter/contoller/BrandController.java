package com.shah.starter.contoller;

import com.shah.starter.entity.Brand;
import com.shah.starter.exception.ProcessException;
import com.shah.starter.model.BrandModel;
import com.shah.starter.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/register")
    public ResponseEntity<String> registerBrand(@RequestBody BrandModel brandModel) {
        ResponseEntity response = null;
        try {
            Brand registeredBrand = brandService.registerBrand(brandModel);

            if(registeredBrand == null) {
                throw new ProcessException("Brand Registeration Failed!");
            }

            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Brand successfully registered");

        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }
}
