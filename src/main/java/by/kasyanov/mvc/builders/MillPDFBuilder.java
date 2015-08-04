package by.kasyanov.mvc.builders;

import by.kasyanov.mvc.dao.MillDAO;
import by.kasyanov.mvc.entities.Country;
import by.kasyanov.mvc.entities.Mill;
import by.kasyanov.mvc.entities.MillState;
import by.kasyanov.mvc.entities.Producer;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

public class MillPDFBuilder implements PDFBuilder {

    public void build(Document document,
                      Map<String, Object> model) {

        try {

            String imageUrl = (String) model.get("");
            Mill mIll = (Mill) model.get("");
            Producer producer = (Producer) model.get("");
            Country country = (Country) model.get("");
            MillState millState = (MillState) model.get("");
            Boolean isAuthenticated = (Boolean) model.get("");

            ClassLoader classLoader = getClass().getClassLoader();
            String fontUrl = classLoader.getResource("fonts/times.ttf").toString();
            BaseFont bf = BaseFont.createFont(fontUrl, BaseFont.IDENTITY_H, true);
            Font font = new Font(bf);

            //document.add(new Paragraph(mIll.getDescription(), font));
            Image image = Image.getInstance(imageUrl);
            image.setAlignment(Element.ALIGN_CENTER);
            image.scaleAbsolute(200, 200);
            document.add(image);
            //document.add(new Paragraph(imageUrl, font));

            //document.add(new Paragraph(mIll.getDescription(), font));

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100.0f);
            table.setWidths(new float[]{3.0f, 2.0f});
            table.setSpacingBefore(10);

            PdfPCell cell = new PdfPCell();
            //cell.setBackgroundColor(BaseColor.BLUE);
            cell.setPadding(3);

            cell.setPhrase(new Phrase("Тип станка", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(producer.getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Модель станка", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getModel(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Производитель", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getMovingX()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Страна производитель", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getMovingY()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Система ЧПУ", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getMovingZ()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Год производства", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getCncType(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Физическое нахождение станка(Machine location)", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getAxisCount()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Кол-во осей", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getTableLength()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Перемещение по осям", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getTableWidth()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Размер стола", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millState.getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Нагрузка на стол", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getTableWeightMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Конус шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopNumber()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Частота вращения шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopMaxD()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Мощьность шпинделя, kw", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopWeightMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный крутящий момент шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopChangeTime()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Тип шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getSpindleTaper(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Способ охлаждения шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSpindleSpeedMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Тип магазина", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSpindleTorqueMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Кол-во инструментов, шт", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getSpindleCooling(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный диаметр инструмента в магазине, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSpindleWorkTime()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный вес инструмента, кг", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningAccuracy()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Время смены инструмента, сек", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Точность позиционирования, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Точность Re-позиционирования, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Наработка на шпинделе, ч", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Включение станка всего, ч", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Дополнительно в комплектации", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Состояние станка", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            if (isAuthenticated) {
                cell.setPhrase(new Phrase("Цена, $", font));
                table.addCell(cell);
                cell.setPhrase(new Phrase(String.valueOf(mIll.getPrice()), font));
                table.addCell(cell);
            }

            document.add(table);

            document.add(new Paragraph("220111 Беларусь, Минск, Проспект Независимости 1, офис 7", font));
            document.add(new Paragraph("Velcom: +375(44) 777-77-77", font));
            document.add(new Paragraph("MTS: +375(29) 777-77-77", font));
            document.add(new Paragraph("Городской: +375(17) 777-77-77", font));

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
