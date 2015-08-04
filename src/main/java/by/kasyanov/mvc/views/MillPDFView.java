package by.kasyanov.mvc.views;

import by.kasyanov.mvc.builders.MillPDFBuilder;
import by.kasyanov.mvc.builders.PDFBuilder;
import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.MillState;
import by.kasyanov.mvc.entities.Producer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class MillPDFView extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        PDFBuilder pdfBuilder = (PDFBuilder) model.get("PdfBuilderImpl");
        pdfBuilder.build(document, model);
    }
}
