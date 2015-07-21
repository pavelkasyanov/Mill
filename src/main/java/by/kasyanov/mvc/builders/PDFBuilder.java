package by.kasyanov.mvc.builders;

import com.itextpdf.text.Document;

import java.util.Map;

public interface PDFBuilder {
    void build(Document document, Map<String, Object> params);
}
