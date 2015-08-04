package by.kasyanov.mvc.builders;

import com.itextpdf.text.Document;
import org.springframework.ui.ModelMap;

import java.util.Map;

public interface PDFBuilder {
    void build(Document document, Map<String, Object> model);
}
