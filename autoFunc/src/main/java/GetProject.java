
import com.google.gson.*;
import junit.framework.TestCase;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.io.IOException;
import java.util.*;

public class GetProject extends TestCase {

    Map<String,Map> taskMap = new HashMap<>();



    public void test1() throws IOException {
//        for (int i =0;i < 7; i++ ){
//
//            GetTask(i);
//
//        }
//        GetTask(1);
//        System.out.println(GetTask(1));
        GetTask(1);

    }

    public Map<String,Map> GetTask(int page) throws IOException {


        String TaskInstanceUrl = String.format("https://workbench2-cn-shanghai.data.aliyun.com/workbench/cwf/node/list?" +
                "projectId=120010&env=prod&tenantId=377532642531394&sortOrder=&sortField=&includeRelation=false&pageNum=%s&pageSize=40&forceUpdateId=0&expand=false&prgTypes=&modifyTime=&nodeType=&searchText=&owner=&solId=&bizId=&resgroupId=&baseLineId=&connectionRegionId=&connectionType=&connections=&expired=false&lonely=false",page);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(TaskInstanceUrl)
                .method("GET", null)
                .addHeader("authority", " workbench2-cn-shanghai.data.aliyun.com")
                .addHeader("user-agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
                .addHeader("accept", " */*")
                .addHeader("sec-fetch-site", " same-origin")
                .addHeader("sec-fetch-mode", " cors")
                .addHeader("sec-fetch-dest", " empty")
                .addHeader("referer", " https://workbench2-cn-shanghai.data.aliyun.com/?env=prod")
                .addHeader("accept-language", " zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("cookie", " cna=jDMbF/HGWU4CAd5M8MrcC2wA; t=d7a3a19089397933ca46de8f7a2dfd6b; _tb_token_=3e9ee3bb7ee1e; cookie2=1fb47c98f4727ee2c889750d92f48720; _samesite_flag_=true; bs_n_lang=zh_CN; ping_test=true; aliyun_lang=zh; aliyun_site=CN; UC-XSRF-TOKEN=7f3d9924-6557-43da-8845-d666768749b4; aliyun_country=CN; UM_distinctid=1717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4; _ga=GA1.2.865862036.1586942748; _bl_uid=Umk079FR2gL4hhnRCh1Llt6wqthR; iaGreyFlag=1587091015675; dplus_cross_id=171f705642d4b6-02c2b5043a036b-30657701-1fa400-171f705642e77b; dplus_finger_print=2217311665; cn_1277724970_dplus=1%5B%7B%7D%2C0%2C1588987262%2C0%2C1588987262%2C%22www.umeng.com%22%2C%221717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4%22%2C%221588983653%22%2C%22https%3A%2F%2Fwww.umeng.com%2F%22%2C%22www.umeng.com%22%5D; consoleRecentVisit=dms; csrf_token=810a4e033d7d41c2a24d44fb586431b7; currentRegionId=cn-shanghai; bd=s0ouCmI%3D; SESSIONX=4b6c7a48-45bd-4820-a084-0fe4f0d2b542; aliyun_choice=CN; CLOSE_HELP_GUIDE_V2=true; ck2=2ccbc0213cb40e1bfb5122af4dd914af; an=liny; lg=true; sg=y23; csg=3518d419; login_aliyunid=\"liny @ 1255717397738878\"; login_aliyunid_ticket=2b0QPUkz8Jy0F5HJA6lOgOnJdn3h4bxMj6*TuA0xohofq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd5zatj3srBu*fdqE*7kRCW03rmJK*H1vT5ERPp2356A*R; FECS-XSRF-TOKEN=0daf53e5-0db4-4a24-8a4e-37603fc3f2a0; FECS-UMID=%7B%22token%22%3A%22Yca717354731807a8cad4ec60d3b49786%22%2C%22timestamp%22%3A%2206562742515A5C46534E617F%22%7D; console_base_assets_version=3.14.7; login_aliyunid_csrf=a6b787a4452f4a748039850a346df1cd; c_token=09fac2cfae39c769d58e9454dd5788e0; aliyunAliothSource=eyJzcG0iOiJhMmM0Zy4xMTE4NjYzMS43eTlqaHFzZnouZDE3OSIsInNjbSI6IjIwMTQwNzIyLjEzNzEuNC4xMzk0In0=; __yunlog_session__=1595916769946; lvc=sAhlCkhFlODy%2Bw%3D%3D; l=eBjTyiRIQcQDUoeNBOfwourza77OSIRAguPzaNbMiOCPOpXH5x5fWZkH97-MC3GVh6WyR3kYyUXbBeYBcIvq4TCuLwwv0nkmn; isg=BDMz9FcMaMWi5yVyVrD4FBIlwjFdaMcq7JjvIOXQj9KJ5FOGbThXepFynhQKxB8i")
                .addHeader("Cookie", "bs_n_lang=zh_CN; login_aliyunid_csrf=_csrf_tk_1586395917188583; aliyun_lang=zh; aliyun_country=CN; lvc=sAhlCkhFlOaYJQ%3D%3D")
                .build();
        String res = client.newCall(request).execute().body().string();
        System.out.println(res);
        JsonObject resJson = new JsonParser().parse(res).getAsJsonObject();
        JsonArray resJsonarr = resJson.get("data").getAsJsonObject().getAsJsonArray("data");


        if (resJsonarr != null){
            Iterator<JsonElement> resJsonIt=resJsonarr.iterator();
//            初始化map


            while(resJsonIt.hasNext()){
                JsonObject dataJson = (JsonObject) resJsonIt.next();
                String task = dataJson.get("nodeName").toString();
                String nodeId = dataJson.get("nodeId").toString();
                System.out.println(task);
                String projectId = dataJson.get("projectId").toString();
                String fileId = dataJson.get("fileId").toString();
                System.out.println(fileId);
                JsonElement inputs = dataJson.get("inputs").getAsJsonArray().get(0).getAsJsonObject();
                String tenantId = inputs.getAsJsonObject().get("tenantId").toString();
                Map<String,String> body = new HashMap();
                body.put("task", task);
                body.put("projectId",projectId);
                body.put("tenantId",tenantId);
                body.put("fileId",fileId);
                System.out.println(body.get(fileId));
                taskMap.put(nodeId, body);
            }
        }
        return taskMap;
    }


}

