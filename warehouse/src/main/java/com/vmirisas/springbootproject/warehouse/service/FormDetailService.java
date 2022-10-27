package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;

import java.util.List;

public interface FormDetailService {

    List<FormDetailDTO> findAll();
    FormDetailDTO findById (Long theId);
    void save(FormDetailDTO theFormDetail);
    void deleteById(Long theId);
}
