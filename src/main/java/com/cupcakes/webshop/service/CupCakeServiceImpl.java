package com.cupcakes.webshop.service;

import com.cupcakes.webshop.dao.CupCakeDao;
import com.cupcakes.webshop.model.Bottom;
import com.cupcakes.webshop.model.CupCake;
import com.cupcakes.webshop.model.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by scheldejonas on 11/09/16.
 */
@Service
public class CupCakeServiceImpl implements CupCakeService {

    @Autowired
    private CupCakeDao cupCakeDao;

    @Override
    public List<CupCake> findAll() {
        return cupCakeDao.findAll();
    }

    @Override
    public CupCake findById(Long id) {
        return cupCakeDao.findById(id);
    }

    // Make data turn into one CupCake object here, not in the controller
    @Override
    public void save(CupCake cupCake, MultipartFile toppingImage, MultipartFile bottomImage) {

        // Save the bytes from the file object to the Cup Cake
        try {
            cupCake.getTopping().setImage(toppingImage.getBytes());
            cupCake.getBottom().setImage(bottomImage.getBytes());
        } catch (IOException e) {
            System.out.println("Unable to get the byte array from topping or bottom image");
        }

        // Send the cup cake to the data access object, for storage with a hibernate session
        cupCakeDao.save(cupCake);
    }

    @Override
    public void delete(CupCake cupCake) {
        cupCakeDao.delete(cupCake);
    }
}
