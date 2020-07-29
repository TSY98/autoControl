import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class GetFsBody {
    public static void main(String[] args) {

        Map<String, String> taskIdMap = GetTask.getTaskIdMap();
        for (String key : taskIdMap.keySet()) {
            System.out.println(key + "=" + taskIdMap.get(key));
        }


    }
    public static String get(String ProjectId,String TenantId,String UserId,String FileId,String FileType){
        try {
            Gson gson= new GsonBuilder().disableHtmlEscaping().create();
            String content = GetFile.get(ProjectId,TenantId,FileId);
            CodeContent codeContent=gson.fromJson(content, CodeContent.class);


            Parameters parameters = new Parameters();

            String pa = Test.Get("");
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

            runBody.setProjectId(ProjectId);
            runBody.setTenantId(TenantId);
            runBody.setUserId("281512194344325318");
            runBody.setFileId(FileId);

            runBody.setFileType(FileType);
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
