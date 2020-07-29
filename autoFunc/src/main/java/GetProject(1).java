import cn.hutool.core.util.StrUtil;
import com.google.common.base.Splitter;
import com.google.gson.*;
import junit.framework.TestCase;
import okhttp3.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class GetProject extends TestCase {

    // 存实例任务的Map
    Map<String,String> body = new HashMap();
    private String userId = "260151584943417253";
    private String connName = "odps_first";
    // 公共headers
    private Map<String,String> commonHeaders = new HashMap(){{
                put("user-agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36");
                put("x-requested-with", " XMLHttpRequest");
                put("accept", " */*");
                put("accept-language", " zh-CN,zh;q=0.9,en;q=0.8");
                put("sec-fetch-site", " same-origin");
                put("sec-fetch-mode", " cors");
                put("sec-fetch-dest", " empty");
    }};




    public void test1() throws IOException {
//        Map<String,String> params = new HashMap<String,String>(){{
//            put("projectId","120010");
//            put("tenantId","377532642531394");
//            put("fileId","500894029");
//            put("openType","0");
//        }};
////        getTaskContext(params);
//        System.out.println(getTaskFileBody(params));
        for (int i=0;i < 10;i++){
            List<Map> taskMap = new ArrayList<>();
            // 获取主要实例任务
            getTask(i);
        }

        // 根据任务名分层

        // 通过任务名获取参数，传入参数，获取任务信息

        // 解析getTaskFileBody 参数，格式化成run接口的参数，传入run接口


        // 解析run接口结果，拼接成Url， 每5秒获取一次 runLogInfo 接口结果，知道logEnd=True

        //

    }



    /***
     * 获取运维中心所有实例任务
     * @param page :页码
     * @throws IOException
     */
    public void getTask(int page) throws IOException {

        String taskInstanceUrl = String.format("https://workbench2-cn-shanghai.data.aliyun.com/workbench/cwf/node/list?" +
                "projectId=120010&env=prod&tenantId=377532642531394&sortOrder=&sortField=&includeRelation=false&pageNum=%s&pageSize=40&forceUpdateId=0&expand=false&prgTypes=&modifyTime=&nodeType=&searchText=&owner=&solId=&bizId=&resgroupId=&baseLineId=&connectionRegionId=&connectionType=&connections=&expired=false&lonely=false",page);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(taskInstanceUrl)
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
        JsonObject resJson = new JsonParser().parse(res).getAsJsonObject();
        JsonArray resJsonarr = resJson.get("data").getAsJsonObject().getAsJsonArray("data");

        Map<String,Map> taskInfo = new HashMap<>();
        if (resJsonarr != null){
            Iterator<JsonElement> resJsonIt=resJsonarr.iterator();


            while(resJsonIt.hasNext()){
                // 初始化map

                JsonObject dataJson = (JsonObject) resJsonIt.next();
                String task = dataJson.get("nodeName").toString();
                String projectId = dataJson.get("projectId").toString();
                JsonElement inputs = dataJson.get("inputs").getAsJsonArray().get(0).getAsJsonObject();
                String tenantId = inputs.getAsJsonObject().get("tenantId").toString();
                String fileId = inputs.getAsJsonObject().get("fileId").toString();



                if ( task != null ){
                    body.put("projectId",projectId);
                    body.put("tenantId",tenantId);
                    body.put("fileId",fileId);

                    taskInfo.put(task,body);

                }
            }
        }
    }


    /**
     * 获取任务代码，配置
     * @return
     * @param params
     */
    public String getTaskFileBody(Map<String, String> params) throws IOException {
        String taskFileBaseUrl = "https://ide2-cn-shanghai.data.aliyun.com/rest/file?";
        String taskFileParams = setUrlParams(params);
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
        String jsonStr = gson.toJson(transData(paraValue));


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


    /**
     * 执行任务
     * @return
     * @throws IOException
     */
    public String runTask(RequestBody body) throws IOException {
        String runTaskUrl = "https://ide2-cn-shanghai.data.aliyun.com/rest/task/run";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse(" application/json,application/json");
//        RequestBody body = RequestBody.Companion.create("{\"projectId\":120010,\"tenantId\":377532642531394,\"userId\":\"260151584943417253\",\"fileId\":500866799,\"codeContent\":\"{\\\"type\\\":\\\"job\\\",\\\"steps\\\":[{\\\"stepType\\\":\\\"loghub\\\",\\\"parameter\\\":{\\\"datasource\\\":\\\"feishu\\\",\\\"column\\\":[\\\"body\\\",\\\"post_time\\\"],\\\"beginDateTime\\\":\\\"${yesterday}${st}0000\\\",\\\"batchSize\\\":256,\\\"encoding\\\":\\\"UTF-8\\\",\\\"endDateTime\\\":\\\"${today}${ed}0000\\\",\\\"fieldDelimiter\\\":\\\",\\\",\\\"logstore\\\":\\\"fs_business_s1\\\"},\\\"name\\\":\\\"Reader\\\",\\\"category\\\":\\\"reader\\\"},{\\\"stepType\\\":\\\"odps\\\",\\\"parameter\\\":{\\\"partition\\\":\\\"ds=${yesterday},hh=${st},logstore_part=fs_business_s1\\\",\\\"truncate\\\":true,\\\"datasource\\\":\\\"odps_first\\\",\\\"column\\\":[\\\"body\\\",\\\"post_time\\\"],\\\"emptyAsNull\\\":false,\\\"table\\\":\\\"ods_loghub_feishu_bs_h_f\\\"},\\\"name\\\":\\\"Writer\\\",\\\"category\\\":\\\"writer\\\"}],\\\"version\\\":\\\"2.0\\\",\\\"order\\\":{\\\"hops\\\":[{\\\"from\\\":\\\"Reader\\\",\\\"to\\\":\\\"Writer\\\"}]},\\\"setting\\\":{\\\"errorLimit\\\":{\\\"record\\\":\\\"\\\"},\\\"speed\\\":{\\\"throttle\\\":false,\\\"concurrent\\\":2}}}\",\"parameters\":\"{\\\"sysParams\\\":[],\\\"scheduleParams\\\":[{\\\"key\\\":\\\"bizdate\\\",\\\"value\\\":\\\"20200723\\\"},{\\\"key\\\":\\\"yesterday\\\",\\\"value\\\":\\\"20200723\\\"},{\\\"key\\\":\\\"st\\\",\\\"value\\\":\\\"00\\\"},{\\\"key\\\":\\\"today\\\",\\\"value\\\":\\\"20200723\\\"},{\\\"key\\\":\\\"ed\\\",\\\"value\\\":\\\"24\\\"}]}\",\"fileType\":23,\"advanceSettings\":\"\",\"groupIdentifier\":\"group_377532642531394\"}"
//                                                        ,mediaType    );
//                .create(mediaType, "{\"projectId\":120010,\"tenantId\":377532642531394,\"userId\":\"260151584943417253\",\"fileId\":500866799,\"codeContent\":\"{\\\"type\\\":\\\"job\\\",\\\"steps\\\":[{\\\"stepType\\\":\\\"loghub\\\",\\\"parameter\\\":{\\\"datasource\\\":\\\"feishu\\\",\\\"column\\\":[\\\"body\\\",\\\"post_time\\\"],\\\"beginDateTime\\\":\\\"${yesterday}${st}0000\\\",\\\"batchSize\\\":256,\\\"encoding\\\":\\\"UTF-8\\\",\\\"endDateTime\\\":\\\"${today}${ed}0000\\\",\\\"fieldDelimiter\\\":\\\",\\\",\\\"logstore\\\":\\\"fs_business_s1\\\"},\\\"name\\\":\\\"Reader\\\",\\\"category\\\":\\\"reader\\\"},{\\\"stepType\\\":\\\"odps\\\",\\\"parameter\\\":{\\\"partition\\\":\\\"ds=${yesterday},hh=${st},logstore_part=fs_business_s1\\\",\\\"truncate\\\":true,\\\"datasource\\\":\\\"odps_first\\\",\\\"column\\\":[\\\"body\\\",\\\"post_time\\\"],\\\"emptyAsNull\\\":false,\\\"table\\\":\\\"ods_loghub_feishu_bs_h_f\\\"},\\\"name\\\":\\\"Writer\\\",\\\"category\\\":\\\"writer\\\"}],\\\"version\\\":\\\"2.0\\\",\\\"order\\\":{\\\"hops\\\":[{\\\"from\\\":\\\"Reader\\\",\\\"to\\\":\\\"Writer\\\"}]},\\\"setting\\\":{\\\"errorLimit\\\":{\\\"record\\\":\\\"\\\"},\\\"speed\\\":{\\\"throttle\\\":false,\\\"concurrent\\\":2}}}\",\"parameters\":\"{\\\"sysParams\\\":[],\\\"scheduleParams\\\":[{\\\"key\\\":\\\"bizdate\\\",\\\"value\\\":\\\"20200723\\\"},{\\\"key\\\":\\\"yesterday\\\",\\\"value\\\":\\\"20200723\\\"},{\\\"key\\\":\\\"st\\\",\\\"value\\\":\\\"00\\\"},{\\\"key\\\":\\\"today\\\",\\\"value\\\":\\\"20200723\\\"},{\\\"key\\\":\\\"ed\\\",\\\"value\\\":\\\"24\\\"}]}\",\"fileType\":23,\"advanceSettings\":\"\",\"groupIdentifier\":\"group_377532642531394\"}");
        Request request = new Request.Builder()
                .url(runTaskUrl)
                .method("POST", body)
                .headers(Headers.of(commonHeaders))
                .addHeader("accept", " application/json")
                .addHeader("x-csrf-token", " 335cb5ace3814ff9bbda0aae2a52fd28")
                .addHeader("origin", " https://ide2-cn-shanghai.data.aliyun.com")
                .addHeader("referer", " https://ide2-cn-shanghai.data.aliyun.com/")
                .addHeader("cookie", " cna=jDMbF/HGWU4CAd5M8MrcC2wA; t=d7a3a19089397933ca46de8f7a2dfd6b; _tb_token_=3e9ee3bb7ee1e; cookie2=1fb47c98f4727ee2c889750d92f48720; _samesite_flag_=true; bs_n_lang=zh_CN; ping_test=true; aliyun_lang=zh; aliyun_site=CN; UC-XSRF-TOKEN=7f3d9924-6557-43da-8845-d666768749b4; aliyun_country=CN; _bl_uid=tek2R8X5y9sdtO61wxUqdmh7qv5z; csrf_token=335cb5ace3814ff9bbda0aae2a52fd28; UM_distinctid=1717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4; _ga=GA1.2.865862036.1586942748; iaGreyFlag=1587091015675; dplus_cross_id=171f705642d4b6-02c2b5043a036b-30657701-1fa400-171f705642e77b; dplus_finger_print=2217311665; cn_1277724970_dplus=1%5B%7B%7D%2C0%2C1588987262%2C0%2C1588987262%2C%22www.umeng.com%22%2C%221717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4%22%2C%221588983653%22%2C%22https%3A%2F%2Fwww.umeng.com%2F%22%2C%22www.umeng.com%22%5D; consoleRecentVisit=dms; currentRegionId=cn-shanghai; SESSIONX=4b6c7a48-45bd-4820-a084-0fe4f0d2b542; aliyun_choice=CN; CLOSE_HELP_GUIDE_V2=true; FECS-XSRF-TOKEN=0daf53e5-0db4-4a24-8a4e-37603fc3f2a0; FECS-UMID=%7B%22token%22%3A%22Yca717354731807a8cad4ec60d3b49786%22%2C%22timestamp%22%3A%2206562742515A5C46534E617F%22%7D; console_base_assets_version=3.14.7; aliyunAliothSource=eyJzcG0iOiJhMmM0Zy4xMTE4NjYzMS43eTlqaHFzZnouZDE3OSIsInNjbSI6IjIwMTQwNzIyLjEzNzEuNC4xMzk0In0=; __yunlog_session__=1595916769946; csg=0e59ccee; login_aliyunid_csrf=6c5779436d3e4af78df2ca84a9229c98; login_aliyunid=\"liny @ 1255717397738878\"; login_aliyunid_ticket=2b0QPUkz8Jy0F5HJA6lOgBX6TsQsQAC*vz6XRrOzmE0fq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd5wbK_3mvHAR9TW9*pLT*IIvrmJK*H1vT5ERPp2356A*R; c_token=a53c2b238fe2a86c4a8afdd76010bfd8; ck2=403af2caaf50f71080fe640a64eb3b3d; an=liny; lg=true; sg=y23; bd=s0ouCmI%3D; lvc=sAhlCkhFndpUlA%3D%3D; l=eBjTyiRIQcQDUGraBO5Cnurza7794KRXXsPzaNbMiIncB6y_4Fp_skxQKSUdVq-5WhQNnsEJw3kYyUXbB5TToPUnhTJXoDD6AyqIEdLh.; isg=BIuLNbk7UE34OI16bgjQbHp9Gil1IJ-idFCHKP2AskoMHIR-vPKZ8Lz69hzyPPea")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "bs_n_lang=zh_CN; login_aliyunid_csrf=_csrf_tk_1586395917188583; aliyun_lang=zh; aliyun_country=CN; lvc=sAhlCkhPAZHBAw%3D%3D")
                .build();
        String response = client.newCall(request).execute().body().string();
        return response;

    }


    /**
     *
     * @param runLogInfoUrl  url
     * @return
     * @throws IOException
     */
    public String runLogInfo(String runLogInfoUrl) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(runLogInfoUrl)
                .method("GET", null)
                .headers(Headers.of(commonHeaders))
                .addHeader("authority", " ide2-cn-shanghai.data.aliyun.com")
                .addHeader("user-agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36")
                .addHeader("referer", " https://ide2-cn-shanghai.data.aliyun.com/")
                .addHeader("accept-language", " zh-CN,zh;q=0.9,en;q=0.8")
                .addHeader("cookie", " cna=jDMbF/HGWU4CAd5M8MrcC2wA; t=d7a3a19089397933ca46de8f7a2dfd6b; _tb_token_=3e9ee3bb7ee1e; cookie2=1fb47c98f4727ee2c889750d92f48720; _samesite_flag_=true; bs_n_lang=zh_CN; ping_test=true; aliyun_lang=zh; aliyun_site=CN; UC-XSRF-TOKEN=7f3d9924-6557-43da-8845-d666768749b4; aliyun_country=CN; _bl_uid=tek2R8X5y9sdtO61wxUqdmh7qv5z; csrf_token=335cb5ace3814ff9bbda0aae2a52fd28; UM_distinctid=1717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4; _ga=GA1.2.865862036.1586942748; iaGreyFlag=1587091015675; dplus_cross_id=171f705642d4b6-02c2b5043a036b-30657701-1fa400-171f705642e77b; dplus_finger_print=2217311665; cn_1277724970_dplus=1%5B%7B%7D%2C0%2C1588987262%2C0%2C1588987262%2C%22www.umeng.com%22%2C%221717d28a28b221-08228c2b581378-396d7507-1fa400-1717d28a28c9d4%22%2C%221588983653%22%2C%22https%3A%2F%2Fwww.umeng.com%2F%22%2C%22www.umeng.com%22%5D; consoleRecentVisit=dms; currentRegionId=cn-shanghai; SESSIONX=4b6c7a48-45bd-4820-a084-0fe4f0d2b542; aliyun_choice=CN; CLOSE_HELP_GUIDE_V2=true; FECS-XSRF-TOKEN=0daf53e5-0db4-4a24-8a4e-37603fc3f2a0; FECS-UMID=%7B%22token%22%3A%22Yca717354731807a8cad4ec60d3b49786%22%2C%22timestamp%22%3A%2206562742515A5C46534E617F%22%7D; console_base_assets_version=3.14.7; aliyunAliothSource=eyJzcG0iOiJhMmM0Zy4xMTE4NjYzMS43eTlqaHFzZnouZDE3OSIsInNjbSI6IjIwMTQwNzIyLjEzNzEuNC4xMzk0In0=; __yunlog_session__=1595916769946; csg=0e59ccee; login_aliyunid_csrf=6c5779436d3e4af78df2ca84a9229c98; login_aliyunid=\"liny @ 1255717397738878\"; login_aliyunid_ticket=2b0QPUkz8Jy0F5HJA6lOgBX6TsQsQAC*vz6XRrOzmE0fq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755n55JdGUosFFBrCFdU4R7jp3EwO1ri8Gr56CirX_*9VBpfkTFdJTd5wbK_3mvHAR9TW9*pLT*IIvrmJK*H1vT5ERPp2356A*R; c_token=a53c2b238fe2a86c4a8afdd76010bfd8; ck2=403af2caaf50f71080fe640a64eb3b3d; an=liny; lg=true; sg=y23; bd=s0ouCmI%3D; lvc=sAhlCkhFndpUkw%3D%3D; l=eBjTyiRIQcQDUCrFKO5Cnurza7794KRXXsPzaNbMiIncB6y_4Fp_skxQKSUdVq-5WhQNnsEww3kYyUXbB5TToPUndxv9-eM6AyqIndLh.; isg=BAwMNzJev0CThapflQ1PsWHQ3Ww-RbDv340gzWbFzbd38YP7t1c2fZcHkflJuehH")
                .addHeader("Cookie", "bs_n_lang=zh_CN; login_aliyunid_csrf=_csrf_tk_1586395917188583; aliyun_lang=zh; aliyun_country=CN; lvc=sAhlCkhFnDiWUw%3D%3D")
                .build();
        String response = client.newCall(request).execute().body().string();


        return response;
    }




    /**
     * 设置get连接拼接参数
     * @param params
     * @return
     */
    private String setUrlParams(Map<String, String> params){
        StringBuffer param = new StringBuffer();
        int i = 0;
        if(params == null){
            return param.toString();
        }
        for (String key : params.keySet()) {
            if (i == 0){
                param.append("?");
            }
            else {
                param.append("&");
            }
            try {
                param.append(key).append("=").append(URLEncoder.encode(params.get(key).toString(),"UTF-8"));  //字符串拼接
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i++;
        }
        return param.toString();
    }


    /**
     * 将 bizdate=$bizdate yesterday=$[yyyymmdd-1/24] today=$[yyyymmdd] st=$[hh24-1/24] ed=$[hh24] 转为
     * {"sysParams":[],"scheduleParams":[{"key":"yesterday","value":"20200725"},{"key":"st","value":"00"},{"key":"today","value":"20200725"},{"key":"ed","value":"24"}]}
     * @param s
     * @return
     */
    private Map<String, List> transData(String s) {
        Map<String,List> parameters = new HashMap<String,List>();

        List<Map<String, String>> rs = new ArrayList<>();
        char[] chars = {'$','[',']'};
        Map<String, String> kv = Splitter.on(" ").trimResults().omitEmptyStrings().withKeyValueSeparator("=").split(s);
        Map<String,String> m  = null;
        for(String key:kv.keySet()) {
            m = new HashMap<>();
            // 去除特殊字符
            String v = kv.get(key);
            v = StrUtil.removeAll(v,chars);
            m.put("key", key);
            m.put("value", v);
            rs.add(m);
        }
        parameters.put("sysParams",Collections.emptyList());
        parameters.put("scheduleParams",rs);

        return  parameters;
    }




}

