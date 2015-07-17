package by.kasyanov.mvc.views;

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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;

public class MillPDFBuilder {

    public void build(Document document,
                      String imageUrl,
                      Mill mIll, Producer producer,
                      Country country,
                      MillState millState) {

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String fontUrl = classLoader.getResource("fonts/times.ttf").toString();
            BaseFont bf = BaseFont.createFont(fontUrl, BaseFont.IDENTITY_H, true);
            Font font = new Font(bf);

            //document.add(new Paragraph(mIll.getDescription(), font));

            Image image = Image.getInstance(imageUrl);
            image.setAlignment(Element.ALIGN_CENTER);
            image.scaleAbsolute(200, 200);
            //document.add(image);
            document.add(new Paragraph(imageUrl, font));

            document.add(new Paragraph(mIll.getDescription(), font));

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100.0f);
            table.setWidths(new float[]{3.0f, 2.0f});
            table.setSpacingBefore(10);

            PdfPCell cell = new PdfPCell();
            //cell.setBackgroundColor(BaseColor.BLUE);
            cell.setPadding(3);

            cell.setPhrase(new Phrase("Производитель", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(producer.getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Модель", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Ход по X, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSizeX()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Ход по Y, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSizeY()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Ход по Z, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSizeZ()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("CNC", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getCncType(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Количество осей", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getAxis()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Длина стола, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getTableLength()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Ширина стола, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getTableWidth()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Состояние", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(millState.getName(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальная нагрузка на стол, Кг", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getTableWeightMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Количество ячеек для инструмента", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopNumber()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный диаметринструмента устанавливаемый в магазинe, мм", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopMaxD()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный вес инструмента, К", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopWeightMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Время смены инструмента, с", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getToolShoopChangeTime()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Конус шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getSpindleTaper(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальная скорасть шпинделя, обр/мин", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSpindleSpeedMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Максимальный крутящий момент шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSpindleTorqueMax()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Охлаждение шпинделя", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(mIll.getSpindleCooling(), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Наработка шпинделя, ч", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getSpindleWorkTime()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Точность позиционирования", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningAccuracy()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Повторяемость позиционирования", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPositioningRepeatability()), font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Цена, $", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(mIll.getPrice()), font));
            table.addCell(cell);

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
