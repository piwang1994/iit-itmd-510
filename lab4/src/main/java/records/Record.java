package records;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Record extends BankRecords{

    static FileWriter fw = null;
//    public records.Record(String path, String fields) {
//        super(path, fields);
//    }

    public Record(String path) {
        super(path);
        try {
            fw = new FileWriter("bankRecords.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void avgMaleAndFemale(Header[] headers, Comparator<Header> comp)  {
        Arrays.sort(headers, comp);
        // set up needed variables to gather counts & income  by sex to determine average income by sex
        int maleCt = 0, femCt = 0;
        double maleInc =0, femInc = 0;

        for (Header header : headers)
            if (header.getSex().equals(Sex.FEMALE)) {
                ++femCt;
                femInc += header.getIncome();
            } else {
                ++maleCt;
                maleInc += header.getIncome();
            }
            // display resulting averages to console and to file
        System.out.printf("Avg inc. for Females: $%.2f  \n" , (femInc/femCt));
        System.out.printf("Avg inc. for males: $%.2f  \n" , (maleInc/maleCt));
        try {
            fw.write("Avg inc. for Females: $" + String.format("%.2f",femInc/femCt) );
            fw.write("\n"); //create newline in file
            fw.write("Avg inc. for Males: $" + String.format("%.2f",maleInc/maleCt));
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    public void numOfFemaleWithAccount(Header[] headers, Comparator<Header> comp) {
        Arrays.sort(headers, comp);
        // set up needed variables to gather counts & income  by sex to determine average income by sex
        int  femCt = 0;
        //my classmate told that enum may better be ahead of called method,it can prevent null point exception
        for (Header header : headers)
            if (header.getSex().equals(Sex.FEMALE) &
                    YesOrNo.YES.equals(header.getMortgage())  &
                    YesOrNo.YES.equals(header.getSave_act())) {
                ++femCt;
            }
        // display resulting averages to console and to file
        System.out.printf(" Num. of Females With Mortgage & savings acct:%s \n",femCt);
        try {
            fw.write("Num. of Females With Mortgage & savings acct:" +femCt );
            fw.write("\n"); //create newline in file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void numOfMaleWithCarAndOneChildPerLoc(Header[] headers, Comparator<Header> comp)  {
        HashMap<Region, Integer> RegionMale = new HashMap<>();
        // set up needed variables to gather counts & income  by sex to determine average income by sex

        for (Header header : headers)
            if (Sex.MALE.equals(header.getSex())
                    & YesOrNo.YES.equals(header.getCar())
                    & 1==header.getChildren())  {

                // introduce by idea
                RegionMale.merge(header.getRegion(), 1, Integer::sum);

//               if (RegionMale.get(header.getRegion())==null){
//                    RegionMale.put(header.getRegion(),1);
//                }else {
//                    RegionMale.put(header.getRegion(),RegionMale.get(header.getRegion())+1);
//                }

            }
        // display resulting averages to console and to file
        RegionMale.forEach((k,v) -> {
            try {
                System.out.printf("%s region males With car & 1 child:%s  \n",k,v);
                fw.write(k+" region males With car & 1 child :"+v );
                fw.write("\n"); //create newline in file
            } catch (IOException e) {
                e.printStackTrace();
        }});

    }
}
