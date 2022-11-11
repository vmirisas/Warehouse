package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import com.vmirisas.springbootproject.warehouse.entity.FormDetail;

import java.util.List;

public interface FormDetailService {
    List<FormDetail> findAll();
    FormDetail findById (Long theId);
    FormDetail save(FormDetailDTO theFormDetail);
    //FormDetail save(FormDetail formDetail);
    void deleteById(Long theId);
    List<FormDetailDTO> toDtoList(List<FormDetail> details);


}
