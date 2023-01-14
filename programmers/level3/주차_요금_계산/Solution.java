package programmers.level3.주차_요금_계산;

import java.util.*;

class Solution {
    int lastTime = calTime("23:59");
    int basicFee;
    int basicTime;
    int unitTime;
    int unitFee;

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] solution = sol.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        int[] solution = sol.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT"});
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        for (String record : records) {
            String[] rec = record.split(" ");
            int time = calTime(rec[0]);
            String number = rec[1];
            ArrayList<Integer> log = map.getOrDefault(number, new ArrayList<>());
            log.add(time);
            map.put(number, log);
        }

        for (String carNumber : map.keySet()) {
            ArrayList<Integer> logs = map.get(carNumber);
            int time = 0;
            for (int i = 0; i < logs.size() / 2; i++) {
                time += logs.get(2 * i + 1) - logs.get(2 * i);
            }
            if (logs.size() % 2 != 0) {
                time += lastTime - logs.get(logs.size() - 1);
            }
            list.add(new int[]{Integer.parseInt(carNumber), calFee(time)});
        }
        int[] answer = new int[map.keySet().size()];

        list.sort((a,b) -> {
            return a[0] - b[0];
        });
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i)[1];
        }
        return answer;
    }

    public int calFee(int time) {
        int money = basicFee;
        int additionalTime = time - basicTime;
        if (additionalTime <= 0) return basicFee;
        int times = additionalTime / unitTime;
        money += times * unitFee;
        if (additionalTime % unitTime > 0) {
            money += unitFee;
        }
        return money;
    }

    public int calTime(String times) {
        String[] time = times.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 60 + minute;
    }
}

