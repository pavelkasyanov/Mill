package by.kasyanov.mvc.views;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.entities.Country;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.Producer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;

public class MillPDFBuilder {

    public void build(Document document,
                      Mill mIll, Producer producer,
                      Country country) {

        try {

            ClassLoader classLoader = getClass().getClassLoader();
            String fontUrl = classLoader.getResource("fonts/times.ttf").toString();
            BaseFont bf = BaseFont.createFont(fontUrl, BaseFont.IDENTITY_H, true);
            Font font = new Font(bf);

            String value = mIll.getDescription();

            document.add(new Paragraph(value, font));

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
