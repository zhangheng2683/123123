import com.sun.media.jfxmedia.logging.Logger;
import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhangheng on 16-8-2.
 */
public class MyExcelApi {

    public static void main(String[] args){
        HSSFWorkbook wb = new HSSFWorkbook();//建立新HSSFWorkbook对象
        HSSFSheet sheet = wb.createSheet("一个列表");//建立新的sheet对象
        HSSFRow row = sheet.createRow((short)0);//建立新行
        for(int i = 0; i < 10; i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue("zhangheng" + i);//设置cell的整数类型的值
        }
        String path = "/home/zhangheng/excel/";
        String fileName = "first.xls";
        File pathFile = new File(path);
        File file = new File(path + fileName);
        FileOutputStream fos = null;
        try {
            if(!pathFile.exists()) {
                pathFile.mkdir();
                if (!file.exists())
                    file.createNewFile();
            }
            fos = new FileOutputStream(file);
            wb.write(fos);
            fos.flush();
        } catch (IOException e) {
            System.out.println("新建失败!");
            e.printStackTrace();
        }finally {
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
