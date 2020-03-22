package com.quadfour.dao;

import com.quadfour.dto.QuadrantDTO;

public interface IQuadrantDAO {
    QuadrantDTO getQuadrant(boolean isImportant, boolean isUrgent);
}
