package by.kasyanov.mvc.builders;

import by.kasyanov.mvc.Models.MillModel;
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

            MillModel millModel = (MillModel) model.get("millModel");
            Boolean isAuthenticated = (Boolean) model.get("isAuthenticated");

            ClassLoader classLoader = getClass().getClassLoader();
            String fontUrl = classLoader.getResource("fonts/times.ttf").toString();
            BaseFont bf = BaseFont.createFont(fontUrl, BaseFont.IDENTITY_H, true);
            Font font = new Font(bf);

            document.add(new Paragraph(String.format("%d-осевой %s %s(%s,%s)",
                                            millModel.getAxisCount(), millModel.getMillType().getName(),
                                            millModel.getModel(), millModel.getProducer().getName(),
                                            millModel.getCountryProducing().getName()),
                                        font));

            /*Image image = Image.getInstance(imageUrl);
            image.setAlignment(Element.ALIGN_CENTER);
            image.scaleAbsolute(200, 200);
            document.add(image);*/
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
            cell.setPhrase(new Phrase(millModel.getMillType().getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Модель станка", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getModel(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Производитель", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getProducer().getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Страна производитель", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getCountryProducing().getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Система ЧПУ", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getCncType(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Год производства", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getYear()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Физическое нахождение станка(Machine location)", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getMachineLocation().getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Кол-во осей", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getAxisCount()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Перемещение по осям", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.format("%dx%dx%d", millModel.getMovingX(),
                    millModel.getMovingY(), millModel.getMovingZ()),
                    font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Размер стола", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.format("%dx%d", millModel.getTableWidth(), millModel.getTableLength()),
                    font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Нагрузка на стол", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getTableWeightMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Конус шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getSpindleTaper(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Частота вращения шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getSpindleSpeedMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Мощьность шпинделя, kw", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getSpindlePower(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный крутящий момент шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getSpindleTorqueMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Тип шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getSpindleType(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Способ охлаждения шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getSpindleCooling(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Тип магазина", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getToolShoopType().getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Кол-во инструментов, шт", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getToolShoopNumber()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный диаметр инструмента в магазине, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getToolShoopMaxD()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный вес инструмента, кг", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getToolShoopWeightMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Время смены инструмента, сек", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getToolShoopChangeTime()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Точность позиционирования, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getPositioningAccuracy()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Точность Re-позиционирования, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Наработка на шпинделе, ч", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getSpindleWorkTime()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Включение станка всего, ч", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(millModel.getWorkTime()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Дополнительно в комплектации", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getAdditionalConfiguration(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Состояние станка", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millModel.getMillState().getName(), font));
            table.addCell(cell);

            if (isAuthenticated) {
                cell.setPhrase(new Phrase("Цена, $", font));
                table.addCell(cell);
                cell.setPhrase(new Phrase(String.valueOf(millModel.getPrice()), font));
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
