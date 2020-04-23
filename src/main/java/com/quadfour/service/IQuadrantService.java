package com.quadfour.service;

import com.quadfour.dto.QuadrantDTO;
import com.quadfour.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IQuadrantService {
    QuadrantDTO getQuadrant(boolean isImportant, boolean isUrgent, int userId);
}
