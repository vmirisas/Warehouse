package com.vmirisas.springbootproject.warehouse.service;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import com.vmirisas.springbootproject.warehouse.entity.*;
import com.vmirisas.springbootproject.warehouse.repository.FormDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FormDetailServiceImpl implements FormDetailService{

    @Autowired
    private ShelfService shelfService;
    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;
    @Autowired
    private TransactionFormService transactionFormService;
    @Autowired
    private FormDetailRepository formDetailRepository;

//    @Autowired
//    private ProductRepository productRepository;

    @Override
    public List<FormDetailDTO> findAll() {

        List<FormDetail> formDetailList = formDetailRepository.findAll();
        List<FormDetailDTO> formDetailDTOList = new ArrayList<>();

        for (FormDetail detail: formDetailList) {

            FormDetailDTO formDetailDTO = new FormDetailDTO(detail);

            formDetailDTO.setFormDetailId(detail.getFormDetailId());
            formDetailDTO.setTransactionFormId(detail.getTransactionForm().getTransactionFormId());
            formDetailDTO.setShelfCode(detail.getShelf().getShelfCode());
            formDetailDTO.setBarcode(detail.getProduct().getBarcode());
            formDetailDTO.setQuantity(detail.getQuantity());

//            formDetailDTO.setTransactionFormId(detail.getTransactionForm().getTransactionFormId());

//            formDetailDTOList.add(new FormDetailDTO(detail));
            formDetailDTOList.add(formDetailDTO);
        }

        return formDetailDTOList;
    }

    @Override
    public FormDetailDTO findById(Long theId) {
       Optional<FormDetail> result = formDetailRepository.findById(theId);

//       FormDetailDTO theFormDetail;
        FormDetailDTO theFormDetail = new FormDetailDTO();

       if(result.isPresent()) {

           theFormDetail.setFormDetailId(result.get().getFormDetailId());
           theFormDetail.setTransactionFormId(result.get().getTransactionForm().getTransactionFormId());
           theFormDetail.setShelfCode(result.get().getShelf().getShelfCode());
           theFormDetail.setBarcode(result.get().getProduct().getBarcode());
           theFormDetail.setQuantity(result.get().getQuantity());

//           theFormDetail = new FormDetailDTO(result.get());
       } else {
           throw new RuntimeException("Did not find Form Detail id " + theId);
       }

       return theFormDetail;
    }

    @Override
    public void save(FormDetailDTO theFormDetail) {

        FormDetail formDetail = new FormDetail(theFormDetail);

        Product product = new Product(productService.findProductByBarcode(theFormDetail.getBarcode()));
        formDetail.setProduct(product);

        Shelf shelf = new Shelf(shelfService.findShelfByCode(theFormDetail.getShelfCode()));
        formDetail.setShelf(shelf);

        TransactionForm form =  new TransactionForm(transactionFormService.findById(theFormDetail.getTransactionFormId()));
        formDetail.setTransactionForm(form);

        String transactionType = formDetail.getTransactionForm().getType();

        if(transactionType.equalsIgnoreCase("import")) {

            Stock stock = new Stock(stockService.getStockExistence(product.getBarcode(), shelf.getShelfCode()));


            if (stock.getStockId() != null ) {

                int stockQuantity = stock.getQuantity();
                int importedQuantity = theFormDetail.getQuantity();

                stock.setStockId(1L);
                stock.setShelf(shelf);
                stock.setProduct(product);
                stock.setDate(new Date());
                stock.setQuantity(stockQuantity + importedQuantity);

            } else {

                stock.setStockId(0L);
                stock.setShelf(shelf);
                stock.setProduct(product);
                stock.setDate(new Date());
                stock.setQuantity(theFormDetail.getQuantity());
            }

            stockService.save(stock);

            formDetailRepository.save(formDetail);

        } else if (transactionType.equalsIgnoreCase("export")) {

//            Stock stock = new Stock(stockService.getStockExistence(product.getBarcode(), shelf.getShelfCode()));
//            int currentQuantity = stock.getQuantity();

            int currentQuantity = stockService.getStockToExport(product.getBarcode(), shelf.getShelfCode());
            int exportedQuantity = formDetail.getQuantity();

            if (exportedQuantity > currentQuantity) {
                throw new RuntimeException("The exported quantity is greater than the current stock");
            }

            Stock stock = new Stock();
            stock.setStockId(0L);
            stock.setShelf(shelf);
            stock.setProduct(product);
            stock.setDate(new Date());
            stock.setQuantity(currentQuantity - exportedQuantity);

            stockService.save(stock);

        } else {

            throw new RuntimeException("Did not find transaction type - " + transactionType);

        }

//        Stock stock = new Stock();
//        stock.setStockId(0L);
//        stock.setShelf(shelf);
//        stock.setProduct(product);
//        stock.setDate(new Date());
//        stock.setQuantity(theFormDetail.getQuantity());
//
//        stockService.save(stock);
//
//        formDetailRepository.save(formDetail);
    }

    @Override
    public void deleteById(Long theId) {
        formDetailRepository.deleteById(theId);
    }

}
