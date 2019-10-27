package com.zerowolf.ancient_service.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zerowolf.ancient_service.ReadTxtFile;
import com.zerowolf.ancient_service.bean.ListBean;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.filechooser.FileSystemView;

public class PathUtil {
    private static boolean isDev = true;

    public static String getJsonPath() {
        FileSystemView fsv = FileSystemView.getFileSystemView();

        File com = fsv.getHomeDirectory();//获取桌面路径
        String filePath;
        if (isDev) {
            filePath = com.getPath() + "/Desktop/diaryJson.json";//指定要读取文件read.txt的路径（桌面）
        } else {
            filePath = com.getPath() + "/zerowolf/diaryJson.json";//指定要读取文件read.txt的路径（桌面）
        }
        return filePath;
    }

    public static JSONObject getJsonData() {
        String jsonPath = PathUtil.getJsonPath();
        System.out.println(jsonPath);

        String str = ReadTxtFile.readTxtFile(jsonPath);//读取read.txt文件输出字符串

        System.out.println(str);

//        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONObject jsonObject = JSONObject.parseObject(str);
//        JSONObject jsonObject = JSONObject.parseObject("{\"new_list\":[{\"publishTime\":\"2019.02.11\",\"loveCount\":18,\"imageUrl\":\"icon_user_01\",\"content\":\"늙어서머리가하얗게되고, 잠자고, 난로옆에서 졸고, 이 시를 꺼내고, 천천히 읽으며, 당신의 과거의 눈빛의 부드러움을 회상하고, 과거의 짙은 그림자를 떠올리며, 젊음을 사랑하는 사람은 얼마나 될까\",\"username\":\"재드맨\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":22,\"imageUrl\":\"icon_user_02\",\"content\":\"주께서 주의 놋가지와 쇠 줄기를 가지시고, 칼과 같고, 검과 같고, 극과 같으시고, 나에게는 홍색 꽃송이와, 무거운 탄식과, 용감한 횃불과 같이, 우리는 한파와 천둥과, 그리고 벼락을 분담합니다.영원히 헤어질 것 같았는데 평생을 의지했다.그것이 위대한 사랑이다.당신의 위안의 몸뿐만 아니라 당신이 견지하는 위치, 발밑의 땅도 사랑합니다.\",\"username\":\"완기호\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":168,\"imageUrl\":\"icon_user_03\",\"content\":\"나의 마음과 나의 모든 것을 나는 네가 가져가서 내가 너를 볼 수 있도록 눈을 하나 남겨 달라고 부탁할 것이다.내 몸에는 너에게 정복당한 적이 없는 것이 없다.네가 그 목숨을 앗아가고, 그 죽음도 가져가고, 내가 또 잃을 것이 있다면, 그러나 네가 나를 데리고 가서, 내가 너를 볼 수 있도록 눈만이라도 남겨 주길 바란다.\",\"username\":\"신나무\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":88,\"imageUrl\":\"icon_user_04\",\"content\":\"나는 당신의 여름, 여름날 날개를 달고 날아갔으면 좋겠습니다!나는 여전히 너의 귓가에 있는 음악이다.그대를 위해 꽃을 피우고, 묘지를 탈출하고, 내 꽃들이 줄지어 피어나도록 하시오!저를 뽑아주세요, 가을 모란?당신의 꽃?? 영원히 당신의 것!\",\"username\":\"베트남\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":66,\"imageUrl\":\"icon_user_05\",\"content\":\"막 웃으며 안녕이라고 말했지만, 돌아서서 조용히 흐르는 눈물을 훔치느라고 바빴고, 네가 방금 내 곁을 떠나자, 나는 황급히 너의 귀환을 계산하기 시작했다.헤어진 지 이틀밖에 되지 않았지만, 나를 이렇게 심란하게 하고, 안절부절못하게 하며, 마치 무엇을 잃어버린 듯하고, 무엇이 부족한 듯하며, 시끄러운 무리 속에서 마치 황막한 곳에 틀어박힌 듯, 마치 달을 감추는 것 같았다.밤낮의 매 순간이 이렇듯 짜증나고 시간마저 지칠 대로 지쳤는데, 이 아름다운 노래는 마치 꽃이 지는 듯 가시 돋친 가지만 남았다.\\n\",\"username\":\"성문에\"},{\"publishTime\":\"2019.03.12\",\"loveCount\":54,\"imageUrl\":\"icon_user_06\",\"content\":\"나는 네가 필요해, 너만 필요해-- 내 마음을 쉬지 않고 이 말을 되풀이하게 해.\",\"username\":\"양광\"},{\"content\":\"内容\",\"imageUrl\":\"icon_user_01\",\"loveCount\":198,\"publishTime\":\"2019-08-24\",\"username\":\"独行者bbb\"}],\"hot_list\":[{\"publishTime\":\"2019.02.11\",\"loveCount\":102,\"imageUrl\":\"icon_user_03\",\"content\":\"우리는 다시는 이 새콤달콤한 과거의 시간 속에 빠져들지 않을 것이다.우리가 서로를 사랑하게 되는 것을 보았을 때\",\"username\":\"부로요\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":91,\"imageUrl\":\"icon_user_01\",\"content\":\"장미는 가장 깊은 향기를 풍기고 별의 가장 순결한 빛은 끊임없이 반짝인다.나이팅게일은 가장 깊은 울먹임으로 아름다운 밤을 마음껏 노래한다.그윽한 향기는 내 근육을 손상시켰고, 하늘의 차가운 별은 내 앞 이마를 어둡게 했고, 나이팅게일의 맑은 예찬은 나의 변덕스러운 운명에 뜨거운 눈물을 쏟았다.이것은 옛날의 기이한 서글픔이 아니라\",\"username\":\"찐뻥\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":109,\"imageUrl\":\"icon_user_02\",\"content\":\"여보, 나는 여행과 슬픔에서 돌아와서, 당신의 목소리로 돌아가서, 당신이 기타를 질주하는 손으로 돌아가서, 키스로 가을을 어지럽히는 불로 돌아가 하늘로 돌아가는 밤까지.나는 온 세상 사람들을 위하여 빵과 주권을 기원하며\",\"username\":\"김추양\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":122,\"imageUrl\":\"icon_user_05\",\"content\":\"너와 마음을 터놓고 얘기하면 나는 시간을 다 잊는다.\",\"username\":\"왛효공\"},{\"publishTime\":\"2019.02.11\",\"loveCount\":189,\"imageUrl\":\"icon_user_04\",\"content\":\"kjbasjdaksdlls.dasjdasldajsdlkasl;d;lasdljas\",\"username\":\"JackLove\"},{\"publishTime\":\"2019.03.12\",\"loveCount\":176,\"imageUrl\":\"icon_user_06\",\"content\":\"kjbasjdaksdlls.dasjdasldajsdlkasl;d;lasdljas\",\"username\":\"Uzi\"}]}");

//        return JSONObject.toJSONString(jsonObject);
        return jsonObject;
//        return str;
    }

    public static void updateJson(ListBean diaryBean) {

//        ListBean listBean = new ListBean();
//        listBean.setContent("内容");
//        listBean.setLoveCount(198);
//        listBean.setImageUrl("icon_user_01");
//        listBean.setPublishTime("2019-08-24");
//        listBean.setUsername("独行者");

        JSONObject jsonObject = getJsonData();
//        String jsonStr = (String) jsonData;
//        System.out.println(jsonStr);
//        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        JSONArray newList = jsonObject.getJSONArray("new_list");

        newList.add(diaryBean);
//        System.out.println(newList.toJSONString());
//
//        System.out.println(jsonObject.toJSONString());

        reWriteJson(JSONObject.toJSONString(jsonObject));
    }

//    @Value("classpath:static/json/userInfo.json")
//    private Resource userInfo;

    public static void resetJson(String resetString) {
        reWriteJson(resetString);
    }

    private static void reWriteJson(String resetString) {
        File f = new File(PathUtil.getJsonPath());//创建保存文件save.txt（桌面）
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.print(resetString);//将字符串写入到save.txt
        pw.close();
    }

    private static File getResFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) { // 如果同级目录没有，则去config下面找
            file = new File("config/" + filename);
        }
        Resource resource = new FileSystemResource(file);
        if (!resource.exists()) { //config目录下还是找不到，那就直接用classpath下的
            file = ResourceUtils.getFile("classpath:" + filename);
        }
        return file;
    }
}