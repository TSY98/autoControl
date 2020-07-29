import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetFile {

    public static void main(String[] args) {
        //System.out.println(GetFile.get());
    }

    public static String get(String projectId,String tenantId,String fileId){
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://ide2-cn-shanghai.data.aliyun.com/rest/file?projectId=120010&tenantId=377532642531394&fileId=500866799&openType=0")
                    .get()
                    .addHeader("accept", "*/*")
                    .addHeader("accept-language", "zh,en-US;q=0.9,en;q=0.8,zh-TW;q=0.7")
                    .addHeader("cookie", "cna=a6a0FWFl83oCAdpogjPnDW66; _ga=GA1.2.766692957.1575891185; consoleRecentVisit=ecs; CLOSE_HELP_GUIDE_V2=true; iaGreyFlag=1589880137727; _bl_uid=mmkhRaIyg26t40vCRbvqbhpj4sLL; bs_n_lang=zh_CN; aliyun_choice=CN; login_aliyunid_pk=1576681398954529; login_aliyunid_pks=\"BG+he4RP/G5F+XiQtLbn4n/7Luoe7JhnJnRakiix+KVDPI=\"; aliyun_site=CN; activeRegionId=cn-shenzhen; currentRegionId=cn-shenzhen; ping_test=true; t=dc7ccd40fadcde65a18f38895c5d1e72; _tb_token_=5e1f14ef5d731; cookie2=1281c5a4d6e952616a2978a9debe19eb; _samesite_flag_=true; aliyun_lang=zh; login_aliyunid_csrf=dbffa75c24cc47ac9895da10d6b31d57; login_aliyunid=\"tangsy @ 1255717397738878\"; login_aliyunid_ticket=*H4u0ymKkC8uk2xYkMcpxUtvoiB0ENo9JiYIWR_wRzQfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd55ge1OdQSyWn8PiXjffBpZrrmJK*H1vT5ERPp2356A*R; UC-XSRF-TOKEN=ecbd99ff-46a1-415c-8ff9-53cb4d4cf2e0; FECS-XSRF-TOKEN=4b8c30d9-4343-4bde-88d6-9b72d115f715; FECS-UMID=%7B%22token%22%3A%22Y77b46ba5eb2b1cd5a793e9a8cba397e3%22%2C%22timestamp%22%3A%2242835345555E5143544A6178%22%7D; console_base_assets_version=3.14.7; c_token=04af3c97c45a23b43860ae0ae4c073ff; ck2=ca59179691f38f03a62d7c106df6a5a7; an=tangsy; lg=true; sg=y28; bd=s0ouCmI%3D; __yunlog_session__=1595940501632; aliyun_country=CN; csrf_token=4880d59acdfc4d0ba71d0ec521c67363; lvc=sAhlCkhCd4M4hQ%3D%3D; l=eBLdvStVQ0jViwb6BO5aourza77Ta3Ojn5VzaNbMiIncB6AQZFIGhitQKyA8mxx5Wh_Vns-Hl3ow4YKgBmTnzyUIhi4gkqH6AyqInd8h.; isg=BPb21yYQtWH1UUBxMz-_UjRARyz4FzpR25dtfWDMu1n7o8A9xKbUYYwVu3fPVDJp, cna=a6a0FWFl83oCAdpogjPnDW66; _ga=GA1.2.766692957.1575891185; consoleRecentVisit=ecs; CLOSE_HELP_GUIDE_V2=true; iaGreyFlag=1589880137727; _bl_uid=mmkhRaIyg26t40vCRbvqbhpj4sLL; bs_n_lang=zh_CN; aliyun_choice=CN; login_aliyunid_pk=1576681398954529; login_aliyunid_pks=\"BG+he4RP/G5F+XiQtLbn4n/7Luoe7JhnJnRakiix+KVDPI=\"; aliyun_site=CN; activeRegionId=cn-shenzhen; currentRegionId=cn-shenzhen; ping_test=true; t=dc7ccd40fadcde65a18f38895c5d1e72; _tb_token_=5e1f14ef5d731; cookie2=1281c5a4d6e952616a2978a9debe19eb; _samesite_flag_=true; aliyun_lang=zh; login_aliyunid_csrf=dbffa75c24cc47ac9895da10d6b31d57; login_aliyunid=\"tangsy @ 1255717397738878\"; login_aliyunid_ticket=*H4u0ymKkC8uk2xYkMcpxUtvoiB0ENo9JiYIWR_wRzQfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd55ge1OdQSyWn8PiXjffBpZrrmJK*H1vT5ERPp2356A*R; UC-XSRF-TOKEN=ecbd99ff-46a1-415c-8ff9-53cb4d4cf2e0; FECS-XSRF-TOKEN=4b8c30d9-4343-4bde-88d6-9b72d115f715; FECS-UMID=%7B%22token%22%3A%22Y77b46ba5eb2b1cd5a793e9a8cba397e3%22%2C%22timestamp%22%3A%2242835345555E5143544A6178%22%7D; console_base_assets_version=3.14.7; c_token=04af3c97c45a23b43860ae0ae4c073ff; ck2=ca59179691f38f03a62d7c106df6a5a7; an=tangsy; lg=true; sg=y28; bd=s0ouCmI%3D; __yunlog_session__=1595940501632; aliyun_country=CN; csrf_token=4880d59acdfc4d0ba71d0ec521c67363; lvc=sAhlCkhCd4M4hQ%3D%3D; l=eBLdvStVQ0jViwb6BO5aourza77Ta3Ojn5VzaNbMiIncB6AQZFIGhitQKyA8mxx5Wh_Vns-Hl3ow4YKgBmTnzyUIhi4gkqH6AyqInd8h.; isg=BPb21yYQtWH1UUBxMz-_UjRARyz4FzpR25dtfWDMu1n7o8A9xKbUYYwVu3fPVDJp; bs_n_lang=zh_CN; login_aliyunid_csrf=_csrf_tk_1521395951543531")
                    .addHeader("referer", "https://ide2-cn-shanghai.data.aliyun.com/")
                    .addHeader("sec-fetch-dest", "empty")
                    .addHeader("sec-fetch-mode", "cors")
                    .addHeader("sec-fetch-site", "same-origin")
                    .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36")
                    .addHeader("x-requested-with", "XMLHttpRequest")
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("Postman-Token", "661f54bd-bccb-4e7c-a349-b556927a7af5,41854375-eb22-409e-9934-05357e56101c")
                    .addHeader("Host", "ide2-cn-shanghai.data.aliyun.com")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("cache-control", "no-cache")
                    .build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            //System.out.println(res);
            JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
            JsonObject data = jsonObject.getAsJsonObject("data");
            JsonObject file = data.getAsJsonObject("file");
            String value = file.get("content").getAsString();
            return value;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sgh";
    }
}
