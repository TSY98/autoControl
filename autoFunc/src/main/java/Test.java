import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.bcel.internal.generic.NEW;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Test {

    public static void main(String[] args) {
        //System.out.println(Test.Get());
    }


    public static String Get(String taskId) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://workbench2-cn-shanghai.data.aliyun.com/workbench/cwf/instance/detail?projectId=120010&env=prod&tenantId=377532642531394&taskId="+taskId)
                    .method("GET", null)
                    .addHeader("accept", "*/*")
//                    .addHeader("accept-encoding", "gzip, deflate, br")
                    .addHeader("accept-language", "h-CN,zh;q=0.9")
                    .addHeader("cookie", "aliyun_choice=CN; aliyun_country=CN; aliyun_site=CN; aliyun_lang=zh; currentRegionId=cn-hangzhou; ping_test=true; t=1d9bc1c189c82f8faa6047fbc5410666; _tb_token_=eeeedeeae35f7; cookie2=17926c0feb057bd6a823be963ae4ecec; _samesite_flag_=true; login_aliyunid_csrf=2585c608d35e45b28a93f16172cb3a43; login_aliyunid=\"tangsy @ 1255717397738878\"; login_aliyunid_ticket=*H4u0ymKkC8uk2xYkMcpxUtvoiB0ENo9Mkx3fO98jaMfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd55ge1OdQSyWnPLXGmcVf9EDrmJK*H1vT5ERPp2356A*R; UC-XSRF-TOKEN=85c725f9-e526-49cd-aa62-2f1bb77a3108; FECS-XSRF-TOKEN=231464a0-63f2-4ee1-9037-c390c5e50df4; FECS-UMID=%7B%22token%22%3A%22Y395e85bc63a29c0b564f9852857b4f3e%22%2C%22timestamp%22%3A%2232072109525E594753486574%22%7D; console_base_assets_version=3.14.7; bs_n_lang=zh_CN; c_token=54c40b8a0a91f29f76646f5e04988f0a; ck2=f0ccf9bd8a01e4c384680da85f0ee612; an=tangsy; lg=true; sg=y28; bd=s0ouCmI%3D; __yunlog_session__=1595940922034; _bl_uid=6jknddb55h2z1Xrbe4zUb4271a17; lvc=sAhlCkhDABBY3w%3D%3D; l=eBjNh2JnOg3gVtZfBO5CPurza77tqQAb8lVzaNbMiInca6ClCFcpNNQqDfqpAdtjgt5cLeKrA42DhRnWo84T5xO3AMi4Z21GktJp8e1..; isg=BDk5wEbaQgisCx62rSik-922SKUTRi34RyARMlts_GDf4lh0opFnyhZ0ZOYU4cUw; bs_n_lang=zh_CN; aliyun_lang=zh; aliyun_country=CN; lvc=sAhlCkhDBowE7Q%3D%3D")
                    .addHeader("referer", "https://workbench2-cn-shanghai.data.aliyun.com/?env=prod")
                    .addHeader("sec-fetch-dest", "empty")
                    .addHeader("sec-fetch-mode", "cors")
                    .addHeader("sec-fetch-site", "same-origin")
                    .build();
            Response response = client.newCall(request).execute();
            String res = response.body().string();
            System.out.println(res);
            JsonObject jsonObject = new JsonParser().parse(res).getAsJsonObject();
            JsonObject data = jsonObject.getAsJsonObject("data");
            String value = data.get("paraValue").getAsString();
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "tsy";
    }
}
