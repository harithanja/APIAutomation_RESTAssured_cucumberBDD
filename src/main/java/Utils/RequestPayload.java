package Utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import pojo.AddPlace;
import pojo.Location;
import pojo.delete;
import pojo.update;

import java.util.ArrayList;
import java.util.List;
public class RequestPayload {
    ConfigReader con=new ConfigReader();
    public AddPlace payload(Sheet testSheet, int num){
        DataFormatter formatter = new DataFormatter();
        Row row = testSheet.getRow(num);
        AddPlace add=new AddPlace();
        Location l=new Location();
        l.setLng(Double.parseDouble(formatter.formatCellValue(row.getCell(1))));
        l.setLat(Double.parseDouble(formatter.formatCellValue(row.getCell(2))));
        add.setLocation(l);
        add.setLanguage(formatter.formatCellValue(row.getCell(10)));
        add.setAccuracy(Integer.parseInt(formatter.formatCellValue(row.getCell(3))));
       ArrayList a=new ArrayList();
       a.add(formatter.formatCellValue(row.getCell(7)));
       a.add(formatter.formatCellValue(row.getCell(8)));
       add.setTypes(a);
       add.setWebsite(formatter.formatCellValue(row.getCell(9)));
       add.setName(formatter.formatCellValue(row.getCell(4)));
       add.setPhone_number(formatter.formatCellValue(row.getCell(5)));
       add.setAddress(formatter.formatCellValue(row.getCell(6)));


        return add;
    }
    public update requestpayload(Sheet s, int r){

        DataFormatter formatter = new DataFormatter();
        Row row = s.getRow(r);
       update u=new update();
        List<String> all= reader.GetArrayList();

        for(int i=0;i<all.size();i++) {
            u.setPlace_id(all.get(i));
        }
        u.setAddress(formatter.formatCellValue(row.getCell(11)));
        u.setKey(con.getKey());
        return u;



    }
    public delete deleteRequest(Sheet s,int r){
        DataFormatter formatter = new DataFormatter();
        Row row = s.getRow(r);
        delete d=new delete();
        d.setPlace_id(formatter.formatCellValue(row.getCell(0)));
        return d;
    }




        }









