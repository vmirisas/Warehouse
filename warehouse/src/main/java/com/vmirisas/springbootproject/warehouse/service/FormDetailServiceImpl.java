package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import com.vmirisas.springbootproject.warehouse.entity.*;
import com.vmirisas.springbootproject.warehouse.repository.FormDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormDetailServiceImpl implements FormDetailService{
    @Autowired
    private FormDetailRepository formDetailRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShelfService shelfService;

    @Autowired
    private TransactionFormService transactionFormService;
    @Autowired
    private StockService stockService;

    @Override
    public List<FormDetail> findAll() {
        return formDetailRepository.findAll();
    }

    @Override
    public FormDetail findById(Long theId) {
       return this.formDetailRepository.findById(theId).orElseThrow(() -> new RuntimeException("Did not find Form Detail with id " + theId));
    }

    @Override
    public FormDetail save(FormDetailDTO theFormDetail) {
        return this.formDetailRepository.save(toEntity(theFormDetail));
//        return this.formDetailRepository.save(new FormDetail(theFormDetail));
    }

    @Override
    public FormDetail save(FormDetail formDetail) {
        return this.formDetailRepository.save(formDetail);
    }

    @Override
    public void deleteById(Long theId) {
        FormDetail formDetail = this.formDetailRepository.findById(theId).orElseThrow(() -> new RuntimeException("Did not find Form Detail with id " + theId));
        formDetailRepository.delete(formDetail);
    }

    @Override
    public FormDetail toEntity(FormDetailDTO formDetailDTO) {
        FormDetail detail = new FormDetail(formDetailDTO);

        TransactionForm form = this.transactionFormService.findById(formDetailDTO.getTransactionFormId());
        detail.setTransactionForm(form);

        Product product = this.productService.findProductByBarcode(formDetailDTO.getBarcode());
        detail.setProduct(product);

        Shelf shelf = this.shelfService.findShelfByCode(formDetailDTO.getShelfCode());
        detail.setShelf(shelf);

        Stock stock = new Stock();
        stock.setShelf(shelf);
        stock.setProduct(product);
        stock.setQuantity(detail.getQuantity());
        stock.setDate(form.getDate());

        stockService.save(stock);

        return detail;
    }

    @Override
    public List<FormDetailDTO> toDtoList(List<FormDetail> details) {
        List<FormDetailDTO> list = new ArrayList<>();
        for (FormDetail d : details) {
            list.add(new FormDetailDTO(d));
        }
        return list;
    }

}
