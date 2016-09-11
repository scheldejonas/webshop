package com.cupcakes.webshop.service;

import com.cupcakes.webshop.model.CupCake;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
public interface CupCakeService {
    List<CupCake> findAll();
    CupCake findById(Long id);
    void save(CupCake cupCake, MultipartFile toppingImage, MultipartFile bottomImage);
    void delete(CupCake cupCake);
}
