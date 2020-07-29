import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class GetBody {

    public static void main(String[] args) {

        System.out.println(GetBody.get());
    }
    public static String get(){
        try {
            Gson gson= new GsonBuilder().disableHtmlEscaping().create();
            String content = GetFile.get("","","");
            CodeContent codeContent=gson.fromJson(content, CodeContent.class);


            Parameters parameters = new Parameters();

            String pa = Test.Get(" ");
            String[] s = pa.split(" |=");
            //System.out.println(s[4]);

            ScheduleParms[] scheduleParms = new ScheduleParms[4];



            int k = 0;
            for (int i = 0; i < 4; i++) {

                k += 2;
                ScheduleParms scheduleParms1 = new ScheduleParms();
                scheduleParms1.setKey(s[k + 1]);
                scheduleParms1.setValue(s[k + 2]);
                scheduleParms[i] = scheduleParms1;
                System.out.println(i);
                System.out.println(s[k + 1]+" "+s[k + 2]);
            }

            parameters.setScheduleParams(scheduleParms);




//        parameters.scheduleParams.yesterday = s[4];
//        parameters.scheduleParams.today = s[6];
//        parameters.scheduleParams.st = s[8];
//        parameters.scheduleParams.ed = s[10];

            RunBody runBody = new RunBody();

            runBody.setProjectId("120010");
            runBody.setTenantId("377532642531394");
            runBody.setUserId("281512194344325318");
            runBody.setFileId("500866799");

            runBody.setFileType("23");
            runBody.setAdvanceSettings("");
            runBody.setGroupIdentifier("group_377532642531394");

            String jsoncodeContent = gson.toJson(codeContent);
            String jsonParameters = gson.toJson(parameters);

            runBody.setCodeContent(jsoncodeContent);
            runBody.setParameters(jsonParameters);

            String s1 = gson.toJson(runBody);

            //System.out.println("s1====="+s1);
            //String s2 = gson.toJson(s1);
            System.out.println("s2====="+s1);
            return s1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "r";
    }

}
