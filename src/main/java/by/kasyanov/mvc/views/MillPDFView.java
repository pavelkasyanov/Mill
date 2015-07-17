package by.kasyanov.mvc.views;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.MillState;
import by.kasyanov.mvc.entities.Producer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class MillPDFView extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

       Producer producer = (Producer) model.get("producer");
        Integer millId = (Integer) model.get("millId");
        MillDAO millDAO = (MillDAO) model.get("millDAO");
        Mill mill = millDAO.getById(millId);
        MillState millState = (MillState) model.get("millState");

        String imagePath = request.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\jpg\\mills\\" + mill.getImage());
        //String imagePath = (String) model.get("imagePath");
        System.out.println(imagePath);

        new MillPDFBuilder().build(document, imagePath, mill, producer, null, millState);
    }
}
