package br.com.bb9leko;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.util.List;

public class TesteLeituraPDF {
    public static void main(String[] args) throws Exception {
        PDDocument document = PDDocument.load(new File("src/test/java/br/com/bb9leko/resources/documento.pdf"));
        String texto = new PDFTextStripper().getText(document);
        System.out.println(texto);
        document.close();



    }
}