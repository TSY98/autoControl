import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GetTask {


    public static void main(String[] args) {
        //get();
        getTaskIdMap();

    }

    public static Map<String,String> getTaskIdMap(){
        Map<String, String> TaskId=new HashMap<>();
        for (int i = 1; i <= 40; i++) {
            Map<String, String> stringStringMap = get(String.valueOf(i));
            for (String key : stringStringMap.keySet()) {
                TaskId.put(key, stringStringMap.get(key));
            }
        }

        System.out.println(TaskId.size());

        return TaskId;
    }

    public static Map<String,String> get(String page){
        Map<String,String> body = new HashMap();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://workbench2-cn-shanghai.data.aliyun.com/workbench/cwf/instance/list?projectId=120010&env=prod&tenantId=377532642531394&sortOrder=&sortField=&includeRelation=false&dagType=0&taskStatuses=&pageNum="+page+"&pageSize=40&forceUpdateId=0&expand=false&prgTypes=&searchText=&owner=&solId=&bizId=&taskTypes=0%2C2%2C3%2C5%2C6%2C7&startRunTimeFrom=&startRunTimeTo=&baseLineId=&bizdate=2020-07-28%2000%3A00%3A00&beginBizDate=&endBizDate=&bizBeginHour=2020-07-29%2000%3A00%3A00&bizEndHour=2020-07-29%2023%3A59%3A00&connectionRegionId=&connectionType=&connections=&slowly=false")
                    .method("GET", null)
                    .addHeader("accept", " */*")
                    .addHeader("accept-language", " zh-CN,zh;q=0.9")
                    .addHeader("cookie", " cna=cmiMF7hx9x0CAd5M8MoLgtA2; login_aliyunid_pk=1576681398954529; activeRegionId=cn-shenzhen; UM_distinctid=173320f2e1fb6a-09f589456553c7-4353760-1fa400-173320f2e20ae9; login_aliyunid_pks=\"BG+Iuqb2F1Wg1JtV36kVA8e0buoe7JhnJnRakiix+KVDPI=\"; aliyun_site=CN; bs_n_lang=zh_CN; currentRegionId=cn-shanghai; _bl_uid=FakhUczRkU63pmfbhzg030L1jtCe; aliyun_choice=CN; aliyun_lang=zh; UC-XSRF-TOKEN=d4651e00-23e3-4d6d-8dc4-0ff86030d9d4; bd=s0ouCmI%3D; aliyun_country=CN; login_aliyunid_csrf=3de1c93671c64541b0ca03bfac24ea6a; login_aliyunid=\"tangsy @ 1255717397738878\"; login_aliyunid_ticket=*H4u0ymKkC8uk2xYkMcpxQa9RF6N1g_AvRwujvCNVQwfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd5_cZOlCO*2djTl_jzDdLNLHrmJK*H1vT5ERPp2356A*R; FECS-XSRF-TOKEN=ef489f70-4568-4ad0-8051-b4c44e075408; FECS-UMID=%7B%22token%22%3A%22Ycaa92462758af8351b8d3b412446585d%22%2C%22timestamp%22%3A%228453183559585C4350416678%22%7D; console_base_assets_version=3.14.7; c_token=cbf37695ac133e2a719e674099698070; ck2=2e3f83f37b73cedf86edb7c700f136bb; an=tangsy; lg=true; sg=y28; lvc=sAhlCV0xllK5mQ%3D%3D; l=eBMp87-IOOcRuzkwBOfZourza7797IRAguPzaNbMiOCPOXWp5OthWZojY2-9CnGVh6u2R3ow4YKgBeYBqIbdXRa8Lwwv03Dmn; isg=BAIC6EzP6fzn9PUEBv4qVCIEUwhk0wbt7xv52UwbOnUgn6IZNGd0_4rZT5vjz36F; bs_n_lang=zh_CN; aliyun_lang=zh; aliyun_country=CN; lvc=sAhlCV0xkL3wpw%3D%3D")
                    .addHeader("referer", " https://workbench2-cn-shanghai.data.aliyun.com/?env=prod")
                    .addHeader("sec-fetch-dest", " empty")
                    .addHeader("sec-fetch-mode", " cors")
                    .addHeader("sec-fetch-site", " same-origin")
                    .addHeader("user-agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36")
                    .build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            System.out.println(res);
            JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
            JsonArray resJsonarr = jsonObject.get("data").getAsJsonObject().getAsJsonArray("data");

            if (resJsonarr != null){
                Iterator<JsonElement> resJsonIt=resJsonarr.iterator();
//            初始化map


                while(resJsonIt.hasNext()){
                    JsonObject dataJson = (JsonObject) resJsonIt.next();
                    String taskId = dataJson.get("taskId").toString();
                    String nodeId= dataJson.get("nodeId").toString();
                    body.put(nodeId, taskId);
                    //System.out.println(nodeId+"="+TaskId.get(nodeId));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return body;
    }
}
