package Book.ExhaustiveSearch.Picnic;

import java.util.ArrayList;

// 시간안에 문제를 풀지 못했음.
public class Solution {
    public int search(ArrayList<Integer> leftPeople, ArrayList<Integer> friends) {
        if (leftPeople.size() == 2) {
            if (isFriend(leftPeople.get(0), leftPeople.get(1), friends)) return 1;
            else return 0;
        }

        return search(leftPeople, friends);
    }

    // a < b 라 가정
    public boolean isFriend(int a, int b, ArrayList<Integer> friends) {
        // 짝은 무조건 2의 배수
        for (int i = 0; i < friends.size(); i += 2) {
            if (friends.get(i) == a && friends.get(i + 1) == b) {
                return true;
            }
        }

        return false;
    }
}
