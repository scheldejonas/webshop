package com.cupcakes.webshop.dao;

import com.cupcakes.webshop.model.CupCake;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
public interface CupCakeDao {
    List<CupCake> findAll();
    CupCake findById(Long id);
    void save(CupCake cupCake);
    void delete(CupCake cupCake);
}
