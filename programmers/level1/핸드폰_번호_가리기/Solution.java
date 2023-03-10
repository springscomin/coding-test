package programmers.level1.핸드폰_번호_가리기;

class Solution {
    public String solution(String phone_number) {
        return "*".repeat(phone_number.length() - 4) + phone_number.substring(phone_number.length() - 4, phone_number.length());
    }
}
