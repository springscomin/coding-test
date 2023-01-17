package programmers.level2.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> uuidName = new HashMap<>();
        int size = 0;
        for (String re : record) {
            String[] logs = re.split(" ");
            if (logs[0].equals("Enter")) {
                size++;
                uuidName.put(logs[1], logs[2]);
            } else if (logs[0].equals("Change")) {
                uuidName.put(logs[1], logs[2]);
            } else {
                size++;
            }
        }

        String[] answer = new String[size];
        int idx = 0;
        for (int i = 0; i < record.length; i++){
            if (record[i].split(" ")[0].equals("Change")) continue;
            answer[idx++] = getLog(record[i], uuidName);
        }
        return answer;
    }

    public String getLog(String rec, HashMap<String, String> map) {
        String[] logs = rec.split(" ");
        String stat = logs[0];
        String uuid = logs[1];
        if (stat.equals("Enter")) {
            return map.get(uuid) + "님이 들어왔습니다.";
        }
        else if (stat.equals("Leave")) {
            return map.get(uuid) + "님이 나갔습니다.";
        }
        return "";
    }
}
