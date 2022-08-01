package records;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
-Create a records.BankRecords.java file which will
utilize the records.Client asbtract methods and generate ultimately the client records from the csv file.
 */
public class BankRecords extends Client {
    String path;
    int printCount = 25;
    String fields = "ID,AGE,SEX,REGION,INCOME,MORTGAGE";
    // store the maxLength of every attribute
    HeaderFieldMaxLength maxLength = new HeaderFieldMaxLength();
    //store the data in ffile
    List<ArrayList<String>> arr= new ArrayList<>();

    List<Header> objs=new ArrayList<>();

    public BankRecords(String path) {
        this.path = path;
    }
    public BankRecords(String path, String fields) {
        this.path = path;
        this.fields = fields;
    }
    public BankRecords(String path, int printCount) {
        this.path = path;
        this.printCount = printCount;
    }

    public BankRecords(String path, int printCount, String fields) {
        this.path = path;
        this.printCount = printCount;
        this.fields = fields;
    }

    @Override
    public void readData() throws IOException {
//        Make sure to include a try catch block when reading
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.path)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                // warning:ArrayList that Arrays.asList return is static ArrayList in Arrays rather than java.util.ArrayList
                arr.add(new ArrayList<>(Arrays.asList(info)));


//            System.out.println(line);
//            Arrays.asList(info).forEach(System.out::println);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("check your data or path ");
            throw e;
        }

    }

    @Override
    public void processData() {
        for (ArrayList<String> strings : arr) {
            Header header = new Header();

//            add the data into each of  instance fields via  setters of records.Header
            try {

                header.setId(strings.get(0));
                maxLength.setId(Math.max(strings.get(0).length(),maxLength.getId()));

                header.setAge(Integer.parseInt(strings.get(1)));
                maxLength.setAge(Math.max(strings.get(1).length(),maxLength.getAge()));

                header.setSex(Sex.valueOf(strings.get(2)));
                maxLength.setSex(Math.max(strings.get(2).length(),maxLength.getSex()));

                header.setRegion(Region.valueOf(strings.get(3)));
                maxLength.setRegion(Math.max(strings.get(3).length(),maxLength.getRegion()));

                header.setIncome(Double.valueOf(strings.get(4)));
                maxLength.setIncome(Math.max(strings.get(4).length(),maxLength.getIncome()));

                header.setMarried(YesOrNo.valueOf(strings.get(5)));
                maxLength.setMarried(Math.max(strings.get(5).length(),maxLength.getMarried()));

                header.setChildren(Integer.parseInt(strings.get(6)));
                maxLength.setChildren(Math.max(strings.get(6).length(),maxLength.getChildren()));

                header.setCar(YesOrNo.valueOf(strings.get(7)));
                maxLength.setCar(Math.max(strings.get(7).length(),maxLength.getCar()));

                header.setSave_act(YesOrNo.valueOf(strings.get(8)));
                maxLength.setSave_act(Math.max(strings.get(8).length(),maxLength.getSave_act()));

                header.setCurrent_act(YesOrNo.valueOf(strings.get(9)));
                maxLength.setCurrent_act(Math.max(strings.get(9).length(),maxLength.getCurrent_act()));

                header.setMortgage(YesOrNo.valueOf(strings.get(10)));
                maxLength.setMortgage(Math.max(strings.get(10).length(),maxLength.getMortgage()));

                header.setPep(YesOrNo.valueOf(strings.get(11)));
                maxLength.setPep(Math.max(strings.get(11).length(),maxLength.getPep()));
                objs.add(header);
            } catch (Exception e) {
                e.printStackTrace();
                // print this
                System.out.println("length isn't 12:" + strings);
            }


        }

    }

    @Override
    public void printData() throws NoSuchFieldException, IllegalAccessException {
//        ID, AGE, SEX, REGION, INCOME, and MORTGAGE
        int cnt = 0;
        for (String s : fields.split(",")) {
                Field fl = maxLength.getClass().getDeclaredField(s.toLowerCase());
                System.out.printf("%-"+(Math.max(s.length(),(int)fl.get(maxLength)+3))+"s",s);

        }
        System.out.println();
        for (Header obj : objs) {
            for (String s : fields.split(",")) {

                //use reflect to get the attribute
                Field f = obj.getClass().getDeclaredField(s.toLowerCase());
                Field fl = maxLength.getClass().getDeclaredField(s.toLowerCase());

                System.out.printf("%-"+(Math.max(s.length(),(int)fl.get(maxLength)+3))+"s",f.get(obj));
            }
            System.out.println();
            if (this.printCount == ++cnt) break;
        }
    }
}
