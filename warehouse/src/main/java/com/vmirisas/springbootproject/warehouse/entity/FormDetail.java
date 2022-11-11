package com.vmirisas.springbootproject.warehouse.entity;

import com.vmirisas.springbootproject.warehouse.dto.FormDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "form_detail")
public class FormDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_detail_id")
    private Long formDetailId;

//    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "transaction_form_id")
    private TransactionForm transactionForm;
//    @Column(name = "transaction_form_id")
//    private Long transactionFormId;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
        //CascadeType.MERGE,
        //CascadeType.PERSIST,
        CascadeType.REFRESH})
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;


    public FormDetail(FormDetailDTO dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
