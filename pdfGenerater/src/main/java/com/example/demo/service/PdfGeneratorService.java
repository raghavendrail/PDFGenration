package com.example.demo.service;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.SellerEntity;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfGeneratorService {

    public ByteArrayInputStream generateInvoice(SellerEntity sellerEntity) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Create a table for Seller and Buyer details
            PdfPTable sellerTable = new PdfPTable(2);
            sellerTable.setWidthPercentage(100);
            sellerTable.setWidths(new int[]{1, 1});

            Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

            PdfPCell sellerCell = new PdfPCell(new Phrase("Seller:\n" + sellerEntity.getSeller() + "\n" 
                    + sellerEntity.getSellerAddress() + "\nGSTIN: " + sellerEntity.getSellerGstIn(), headFont));
            sellerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            sellerCell.setBorder(PdfPCell.NO_BORDER);
            sellerTable.addCell(sellerCell);

            PdfPCell buyerCell = new PdfPCell(new Phrase("Buyer:\n" + sellerEntity.getBuyer() + "\n" 
                    + sellerEntity.getBuyerAddress() + "\nGSTIN: " + sellerEntity.getBuyerGstIn(), headFont));
            buyerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
            buyerCell.setBorder(PdfPCell.NO_BORDER);
            sellerTable.addCell(buyerCell);

            document.add(sellerTable);

            // Add empty space between tables
            document.add(new Paragraph("\n"));

            // Create table for items
            PdfPTable itemTable = new PdfPTable(4);
            itemTable.setWidthPercentage(100);
            itemTable.setWidths(new int[]{4, 1, 1, 1});

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Item", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            itemTable.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            itemTable.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Rate", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            itemTable.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Amount", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            itemTable.addCell(hcell);

            // Add item details from ItemsEntity
            hcell = new PdfPCell(new Phrase(sellerEntity.getItemsEntity().getName()));
            hcell.setPaddingLeft(5);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
            itemTable.addCell(hcell);

            hcell = new PdfPCell(new Phrase(String.valueOf(sellerEntity.getItemsEntity().getQuantity()) + " Nos"));
            hcell.setPaddingLeft(5);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            itemTable.addCell(hcell);

            hcell = new PdfPCell(new Phrase(String.valueOf(sellerEntity.getItemsEntity().getRate())));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            itemTable.addCell(hcell);

            hcell = new PdfPCell(new Phrase(String.valueOf(sellerEntity.getItemsEntity().getAmount())));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            itemTable.addCell(hcell);

            document.add(itemTable);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
