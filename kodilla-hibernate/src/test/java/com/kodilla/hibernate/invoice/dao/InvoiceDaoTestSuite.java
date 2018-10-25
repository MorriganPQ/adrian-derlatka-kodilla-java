package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        // Given
        Product computer = new Product("Computer");
        Product desk = new Product("Desk");
        Product tv = new Product("TV");
        Product lamp = new Product("Lamp");

        Item computers = new Item(new BigDecimal(2985.77), 3);
        Item desks = new Item(new BigDecimal(205.89), 4);
        Item tvs = new Item(new BigDecimal(1347.38), 1);
        Item lamps = new Item(new BigDecimal(44.39), 3);
        Item computers2 = new Item(new BigDecimal(8772.94), 1);

        computers.setProduct(computer);
        desks.setProduct(desk);
        tvs.setProduct(tv);
        lamps.setProduct(lamp);
        computers2.setProduct(computer);

        computer.getItems().add(computers);
        desk.getItems().add(desks);
        tv.getItems().add(tvs);
        lamp.getItems().add(lamps);
        computer.getItems().add(computers2);

        Invoice invoice = new Invoice("7/II/2016");
        invoice.getItems().add(computers);
        invoice.getItems().add(desks);
        invoice.getItems().add(tvs);
        invoice.getItems().add(lamps);
        invoice.getItems().add(computers2);

        computers.setInvoice(invoice);
        desks.setInvoice(invoice);
        tvs.setInvoice(invoice);
        lamps.setInvoice(invoice);
        computers2.setInvoice(invoice);

        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // Then
        Assert.assertNotEquals(0, invoiceId);

        // CleanUp
        invoiceDao.delete(invoiceId);
    }
}
