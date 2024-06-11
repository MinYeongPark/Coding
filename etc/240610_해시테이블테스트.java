import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int elements = 100_000_000;
        Random random = new Random();

        int[] data = createData(elements, random);

        // 각각을 따로 주석 풀어서 돌려야 함

        // 해시의 버킷 개수 64개 && 한 버킷에 대해 값 8개 쌓일 때 트리 구조로 바뀜
        // 값 8개 기준 => 7개일 때 트리가 딱 갖춰져있는 상태!
        // 1) 디폴트 해시 테이블 사이즈 + 버킷의 링크드리스트가 트리로 변환 O
//        HashMap<Integer, Integer> generalMap1 = new HashMap<>();
//        generalMapTest(generalMap1, data);

        // 2) 해시 테이블 사이즈 늘렸을 때 + 버킷의 링크드리스트가 트리로 변환 O
//        HashMap<Integer, Integer> generalMap2 = new HashMap<>((int)(elements / 0.75f + 1));
//        generalMapTest(generalMap2, data);

        // 3) 디폴트 해시 테이블 사이즈 + 트리 변환 X (linkedList만 이용하는 경우)
//        TestMap<Integer, Integer> testMap1 = new TestMap();
//        testMapTest(testMap1, data);

        // 4) 해시 테이블 사이즈 늘렸을 때 + 트리 변환 X
        TestMap<Integer, Integer> testMap2 = new TestMap((int)(elements / 0.75f + 1));
        testMapTest(testMap2, data);
    }

    private static int[] createData(int elements, Random random) {
        int[] data = new int[elements];
        for (int i = 0; i < elements; i++) {
            data[i] = random.nextInt(elements);
        }
        return data;
    }

    private static void generalMapTest(HashMap<Integer, Integer> generalMap, int[] data) {
        for (int i : data) {
            generalMap.put(i, i);
        }

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        for (int i = 0; i < generalMap.size(); i++) {
            generalMap.get(i);
        }
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); // 두 시간에 차 계산
        System.out.println("generalMap 조회 실행 시간 : "+secDiffTime);
    }

    private static void testMapTest(TestMap<Integer, Integer> testMap, int[] data) {
        for (int i : data) {
            testMap.put(i, i);
        }

        long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
        for (int i = 0; i < testMap.size(); i++) {
            testMap.get(i);
        }
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); // 두 시간에 차 계산
        System.out.println("testMap 조회 실행 시간 : "+secDiffTime);
    }
}

class TestMap<K,V> extends HashMap<K,V> {

    static final int TREEIFY_THRESHOLD = 100_000_001; // 트리로 변환되는 기준을 1억으로 설정 (그냥 안 바뀌게..)

    public TestMap(int initialCapacity) {
        super(initialCapacity);
    }

    public TestMap() {
        super();
    }
}

/* 240610 테스트
 * 1) 디폴트 해시 테이블 사이즈 + 트리 변환 O : 2457
 * 2) 해시 테이블 사이즈 늘렸을 때 + 트리 변환 O : 2260
 * 3) 디폴트 해시 테이블 사이즈 + 트리 변환 X : 3945
 * 4) 해시 테이블 사이즈 늘렸을 때 + 트리 변환 X : 2286
 * => 해시 테이블이 디폴트 사이즈일 때에는,
 *    버킷의 값들이 트리 구조로 변환되는 게 확실히 map에서 조회할 때 더 빠른 것을 확인할 수 있었고,
 * => 해시 테이블 사이즈를 크게 늘리게 되면 트리로 변환되든 안 되든 큰 차이가 없다!
 */

/* 240611 테스트 : generalMapTest, testMapTest 메서드로 따로 분리한 후 각각 주석 풀어서 돌려서 진행
 * 1) 디폴트 해시 테이블 사이즈 + 트리 변환 O : 3705
 * 2) 해시 테이블 사이즈 늘렸을 때 + 트리 변환 O : 2744
 * 3) 디폴트 해시 테이블 사이즈 + 트리 변환 X : 3559
 * 4) 해시 테이블 사이즈 늘렸을 때 + 트리 변환 X : 2420
 * 음.. 메서드로 따로 분리했는데 결과가 좀 다르게 나오네...
 */
