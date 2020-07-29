import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.Map;

public class filebody {

    public static void main(String[] args) {

    }

    public String getTaskFileBody(Map<String, String> params) throws IOException {
        String taskFileBaseUrl = "https://ide2-cn-shanghai.data.aliyun.com/rest/file?";
        String taskFileParams = "projectId=120010&tenantId=377532642531394&fileId=500866799&openType=0";
        String taskFileUrl = taskFileBaseUrl + taskFileParams;

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(taskFileUrl)
                .method("GET", null)
                .addHeader("authority", " ide2-cn-shanghai.data.aliyun.com")
                .addHeader("referer", " https://ide2-cn-shanghai.data.aliyun.com/")
                .addHeader("accept-language", " zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("cookie", " cna=jDMbF/HGWU4CAd5M8MrcC2wA; t=d7a3a19089397933ca46de8f7a2dfd6b; _tb_token_=3e9ee3bb7ee1e; cookie2=1fb47c98f4727ee2c889750d92f48720; _samesite_flag_=true; bs_n_lang=zh_CN; ping_test=true; aliyun_lang=zh; aliyun_site=CN; UC-XSRF-TOKEN=7f3d9924-6557-43da-8845-d666768749b4; aliyun_country=CN; _bl_uid=tek2R8X5y9sdtO61wxUqdmh7qv5z; csrf_token=335cb5ace3814ff9bbda0aae2a52fd28; UM_distinctid=1717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4; _ga=GA1.2.865862036.1586942748; iaGreyFlag=1587091015675; dplus_cross_id=171f705642d4b6-02c2b5043a036b-30657701-1fa400-171f705642e77b; dplus_finger_print=2217311665; cn_1277724970_dplus=1%5B%7B%7D%2C0%2C1588987262%2C0%2C1588987262%2C%22www.umeng.com%22%2C%221717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4%22%2C%221588983653%22%2C%22https%3A%2F%2Fwww.umeng.com%2F%22%2C%22www.umeng.com%22%5D; consoleRecentVisit=dms; currentRegionId=cn-shanghai; SESSIONX=4b6c7a48-45bd-4820-a084-0fe4f0d2b542; aliyun_choice=CN; CLOSE_HELP_GUIDE_V2=true; FECS-XSRF-TOKEN=0daf53e5-0db4-4a24-8a4e-37603fc3f2a0; FECS-UMID=%7B%22token%22%3A%22Yca717354731807a8cad4ec60d3b49786%22%2C%22timestamp%22%3A%2206562742515A5C46534E617F%22%7D; console_base_assets_version=3.14.7; aliyunAliothSource=eyJzcG0iOiJhMmM0Zy4xMTE4NjYzMS43eTlqaHFzZnouZDE3OSIsInNjbSI6IjIwMTQwNzIyLjEzNzEuNC4xMzk0In0=; __yunlog_session__=1595916769946; csg=0e59ccee; login_aliyunid=\"liny @ 1255717397738878\"; login_aliyunid_ticket=2b0QPUkz8Jy0F5HJA6lOgBX6TsQsQAC*vz6XRrOzmE0fq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd5wbK_3mvHAR9TW9*pLT*IIvrmJK*H1vT5ERPp2356A*R; c_token=a53c2b238fe2a86c4a8afdd76010bfd8; ck2=403af2caaf50f71080fe640a64eb3b3d; an=liny; lg=true; sg=y23; bd=s0ouCmI%3D; login_aliyunid_csrf=c39b666e29034fb39dd650542a373955; lvc=sAhlCkhE%2BkmFkQ%3D%3D; l=eBjTyiRIQcQDUjf3BO5Churza779BnRbXsPzaNbMiIncBs1-AFA0skxQKSUXVPtPWhQN3sVva3kYyUXbBATKGyzshi4gkqH6AyqCVpL9R; isg=BJqbETBQkYo8oxxFVzPxi0O260a8yx6l_St2N6QDtS3CFwVRt1uItIch5-OLx5Y9")
                .addHeader("Cookie", "bs_n_lang=zh_CN; login_aliyunid_csrf=_csrf_tk_1586395917188583; aliyun_lang=zh; aliyun_country=CN; lvc=sAhlCkhPD%2FzR9w%3D%3D")
                .build();
        String res = client.newCall(request).execute().body().string();
        JsonObject resJson = (JsonObject) new JsonParser().parse(res);
        JsonObject resJsonData = resJson.get("data").getAsJsonObject();

        JsonObject resJsonDataNodecfg = resJsonData.get("nodeCfg").getAsJsonObject();
        String paraValue = resJsonDataNodecfg.get("paraValue").toString();
        Gson gson = new Gson();
        String jsonStr = gson.toJson(paraValue);


        JsonObject resJsonDataFile = resJsonData.get("file").getAsJsonObject();
        String codeContent = resJsonDataFile.get("content").toString();
        params.put("fileType",resJsonDataFile.get("fileType").toString());
        params.put("codeContent",codeContent);
        params.put("groupIdentifier","group_" + resJsonDataFile.get("tenantId").toString());

        params.put("advanceSettings","");
        params.put("parameters",jsonStr);
        System.out.println(params.keySet());
        System.out.println(params.toString());
        return null;
    }

}


