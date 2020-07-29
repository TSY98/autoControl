import java.util.ArrayList;
import java.util.Map;

public class BS {
    public static void main(String[] args) {

    }

    public String getbs(){
        ArrayList<String> strings = new ArrayList<>();
        try {
            GetProject getProject = new GetProject();
            Map<String, Map> stringMapMap = getProject.GetTask(1);

            for (String key : stringMapMap.keySet()) {
                Map<String,String> map = stringMapMap.get(key);
                String task = map.get("task");
                String[] s = task.split("_");
                if (s[0].equals("fs")){

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "t";
    }




    public String findTaskID(String nodeId){
        String taskId="";
        Map<String, String> taskIdMap = GetTask.getTaskIdMap();
        for (String key : taskIdMap.keySet()) {
            if (key .equals(nodeId) ) {
                taskId = taskIdMap.get(key);
            }

        }
        return taskId;
    }
}
