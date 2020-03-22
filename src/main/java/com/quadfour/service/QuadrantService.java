package com.quadfour.service;

import com.quadfour.dao.QuadrantDAO;
import com.quadfour.dto.QuadrantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuadrantService implements IQuadrantService {

    @Autowired
    QuadrantDAO quadrantDAO;

    @Override
    public QuadrantDTO getQuadrant(boolean isImportant, boolean isUrgent) {
        QuadrantDTO quadrant = quadrantDAO.getQuadrant(isImportant, isUrgent);
        return quadrant;
    };

}
